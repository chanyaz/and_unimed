package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.type.SimpleType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectReader extends ObjectCodec implements Versioned, Serializable {
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
    private static final long serialVersionUID = 1;
    protected final DeserializationConfig _config;
    protected final DefaultDeserializationContext _context;
    protected final DataFormatReaders _dataFormatReaders;
    private final TokenFilter _filter;
    protected final InjectableValues _injectableValues;
    protected final JsonFactory _parserFactory;
    protected final JsonDeserializer<Object> _rootDeserializer;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected final FormatSchema _schema;
    protected final boolean _unwrapRoot;
    protected final Object _valueToUpdate;
    protected final JavaType _valueType;

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig, JavaType javaType, Object obj, FormatSchema formatSchema, InjectableValues injectableValues) {
        this._config = deserializationConfig;
        this._context = objectMapper._deserializationContext;
        this._rootDeserializers = objectMapper._rootDeserializers;
        this._parserFactory = objectMapper._jsonFactory;
        this._valueType = javaType;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = formatSchema;
            this._injectableValues = injectableValues;
            this._unwrapRoot = deserializationConfig.useRootWrapping();
            this._rootDeserializer = _prefetchRootDeserializer(javaType);
            this._dataFormatReaders = null;
            this._filter = null;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<Object> jsonDeserializer, Object obj, FormatSchema formatSchema, InjectableValues injectableValues, DataFormatReaders dataFormatReaders) {
        this._config = deserializationConfig;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = javaType;
        this._rootDeserializer = jsonDeserializer;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = formatSchema;
            this._injectableValues = injectableValues;
            this._unwrapRoot = deserializationConfig.useRootWrapping();
            this._dataFormatReaders = dataFormatReaders;
            this._filter = objectReader._filter;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    protected Object _bind(JsonParser jsonParser, Object obj) {
        JsonToken _initForReading = _initForReading(jsonParser);
        DeserializationContext createDeserializationContext;
        if (_initForReading == JsonToken.VALUE_NULL) {
            if (obj == null) {
                createDeserializationContext = createDeserializationContext(jsonParser);
                obj = _findRootDeserializer(createDeserializationContext).getNullValue(createDeserializationContext);
            }
        } else if (!(_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT)) {
            createDeserializationContext = createDeserializationContext(jsonParser);
            JsonDeserializer _findRootDeserializer = _findRootDeserializer(createDeserializationContext);
            if (this._unwrapRoot) {
                obj = _unwrapAndDeserialize(jsonParser, createDeserializationContext, this._valueType, _findRootDeserializer);
            } else if (obj == null) {
                obj = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext);
            } else {
                _findRootDeserializer.deserialize(jsonParser, createDeserializationContext, obj);
            }
        }
        jsonParser.clearCurrentToken();
        return obj;
    }

    protected Object _bindAndClose(JsonParser jsonParser) {
        try {
            Object nullValue;
            JsonToken _initForReading = _initForReading(jsonParser);
            DeserializationContext createDeserializationContext;
            if (_initForReading == JsonToken.VALUE_NULL) {
                if (this._valueToUpdate == null) {
                    createDeserializationContext = createDeserializationContext(jsonParser);
                    nullValue = _findRootDeserializer(createDeserializationContext).getNullValue(createDeserializationContext);
                } else {
                    nullValue = this._valueToUpdate;
                }
            } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                nullValue = this._valueToUpdate;
            } else {
                createDeserializationContext = createDeserializationContext(jsonParser);
                JsonDeserializer _findRootDeserializer = _findRootDeserializer(createDeserializationContext);
                if (this._unwrapRoot) {
                    nullValue = _unwrapAndDeserialize(jsonParser, createDeserializationContext, this._valueType, _findRootDeserializer);
                } else if (this._valueToUpdate == null) {
                    nullValue = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext);
                } else {
                    _findRootDeserializer.deserialize(jsonParser, createDeserializationContext, this._valueToUpdate);
                    nullValue = this._valueToUpdate;
                }
            }
            return nullValue;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    protected JsonNode _bindAsTree(JsonParser jsonParser) {
        JsonNode jsonNode;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            jsonNode = NullNode.instance;
        } else {
            DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser);
            JsonDeserializer _findTreeDeserializer = _findTreeDeserializer(createDeserializationContext);
            jsonNode = this._unwrapRoot ? (JsonNode) _unwrapAndDeserialize(jsonParser, createDeserializationContext, JSON_NODE_TYPE, _findTreeDeserializer) : (JsonNode) _findTreeDeserializer.deserialize(jsonParser, createDeserializationContext);
        }
        jsonParser.clearCurrentToken();
        return jsonNode;
    }

    protected JsonParser _considerFilter(JsonParser jsonParser) {
        return (this._filter == null || FilteringParserDelegate.class.isInstance(jsonParser)) ? jsonParser : new FilteringParserDelegate(jsonParser, this._filter, false, false);
    }

    protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext deserializationContext) {
        if (this._rootDeserializer != null) {
            return this._rootDeserializer;
        }
        JavaType javaType = this._valueType;
        if (javaType == null) {
            throw JsonMappingException.from(deserializationContext, "No value type configured for ObjectReader");
        }
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) this._rootDeserializers.get(javaType);
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        jsonDeserializer = deserializationContext.findRootValueDeserializer(javaType);
        if (jsonDeserializer == null) {
            throw JsonMappingException.from(deserializationContext, "Can not find a deserializer for type " + javaType);
        }
        this._rootDeserializers.put(javaType, jsonDeserializer);
        return jsonDeserializer;
    }

    protected JsonDeserializer<Object> _findTreeDeserializer(DeserializationContext deserializationContext) {
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) this._rootDeserializers.get(JSON_NODE_TYPE);
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.findRootValueDeserializer(JSON_NODE_TYPE);
            if (jsonDeserializer == null) {
                throw JsonMappingException.from(deserializationContext, "Can not find a deserializer for type " + JSON_NODE_TYPE);
            }
            this._rootDeserializers.put(JSON_NODE_TYPE, jsonDeserializer);
        }
        return jsonDeserializer;
    }

    protected JsonToken _initForReading(JsonParser jsonParser) {
        if (this._schema != null) {
            jsonParser.setSchema(this._schema);
        }
        this._config.initialize(jsonParser);
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == null) {
            currentToken = jsonParser.nextToken();
            if (currentToken == null) {
                throw JsonMappingException.from(jsonParser, "No content to map due to end-of-input");
            }
        }
        return currentToken;
    }

    protected ObjectReader _new(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<Object> jsonDeserializer, Object obj, FormatSchema formatSchema, InjectableValues injectableValues, DataFormatReaders dataFormatReaders) {
        return new ObjectReader(objectReader, deserializationConfig, javaType, jsonDeserializer, obj, formatSchema, injectableValues, dataFormatReaders);
    }

    protected JsonDeserializer<Object> _prefetchRootDeserializer(JavaType javaType) {
        JsonDeserializer<Object> jsonDeserializer = null;
        if (javaType != null && this._config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) {
            jsonDeserializer = (JsonDeserializer) this._rootDeserializers.get(javaType);
            if (jsonDeserializer == null) {
                try {
                    jsonDeserializer = createDeserializationContext(null).findRootValueDeserializer(javaType);
                    if (jsonDeserializer != null) {
                        this._rootDeserializers.put(javaType, jsonDeserializer);
                    }
                } catch (JsonProcessingException e) {
                }
            }
        }
        return jsonDeserializer;
    }

    protected void _reportUndetectableSource(Object obj) {
        throw new JsonParseException(null, "Can not use source of type " + obj.getClass().getName() + " with format auto-detection: must be byte- not char-based");
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JavaType javaType, JsonDeserializer<Object> jsonDeserializer) {
        String simpleName = this._config.findRootName(javaType).getSimpleName();
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw JsonMappingException.from(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
        } else if (jsonParser.nextToken() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.from(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
        } else {
            String currentName = jsonParser.getCurrentName();
            if (simpleName.equals(currentName)) {
                Object deserialize;
                jsonParser.nextToken();
                if (this._valueToUpdate == null) {
                    deserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    jsonDeserializer.deserialize(jsonParser, deserializationContext, this._valueToUpdate);
                    deserialize = this._valueToUpdate;
                }
                if (jsonParser.nextToken() == JsonToken.END_OBJECT) {
                    return deserialize;
                }
                throw JsonMappingException.from(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
            }
            throw JsonMappingException.from(jsonParser, "Root name '" + currentName + "' does not match expected ('" + simpleName + "') for type " + javaType);
        }
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser jsonParser) {
        return this._context.createInstance(this._config, jsonParser, this._injectableValues);
    }

    public ObjectReader forType(JavaType javaType) {
        if (javaType != null && javaType.equals(this._valueType)) {
            return this;
        }
        JsonDeserializer _prefetchRootDeserializer = _prefetchRootDeserializer(javaType);
        DataFormatReaders dataFormatReaders = this._dataFormatReaders;
        if (dataFormatReaders != null) {
            dataFormatReaders = dataFormatReaders.withType(javaType);
        }
        return _new(this, this._config, javaType, _prefetchRootDeserializer, this._valueToUpdate, this._schema, this._injectableValues, dataFormatReaders);
    }

    public ObjectReader forType(Class<?> cls) {
        return forType(this._config.constructType(cls));
    }

    public JsonFactory getFactory() {
        return this._parserFactory;
    }

    public <T extends TreeNode> T readTree(JsonParser jsonParser) {
        return _bindAsTree(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser) {
        return _bind(jsonParser, this._valueToUpdate);
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) {
        return forType((Class) cls).readValue(jsonParser);
    }

    public <T> T readValue(Reader reader) {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(reader)));
    }

    public JsonParser treeAsTokens(TreeNode treeNode) {
        return new TreeTraversingParser((JsonNode) treeNode, this);
    }

    public <T> T treeToValue(TreeNode treeNode, Class<T> cls) {
        try {
            return readValue(treeAsTokens(treeNode), cls);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }
}
