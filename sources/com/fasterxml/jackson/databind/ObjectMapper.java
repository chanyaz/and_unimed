package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectMapper extends ObjectCodec implements Versioned, Serializable {
    protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    protected static final BaseSettings DEFAULT_BASE = new BaseSettings(null, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, TypeFactory.defaultInstance(), null, StdDateFormat.instance, null, Locale.getDefault(), null, Base64Variants.getDefaultVariant());
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
    protected static final VisibilityChecker<?> STD_VISIBILITY_CHECKER = Std.defaultInstance();
    @Deprecated
    protected static final PrettyPrinter _defaultPrettyPrinter = new DefaultPrettyPrinter();
    private static final long serialVersionUID = 1;
    protected DeserializationConfig _deserializationConfig;
    protected DefaultDeserializationContext _deserializationContext;
    protected InjectableValues _injectableValues;
    protected final JsonFactory _jsonFactory;
    protected SimpleMixInResolver _mixIns;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected SerializationConfig _serializationConfig;
    protected SerializerFactory _serializerFactory;
    protected DefaultSerializerProvider _serializerProvider;
    protected SubtypeResolver _subtypeResolver;
    protected TypeFactory _typeFactory;

    public class DefaultTypeResolverBuilder extends StdTypeResolverBuilder implements Serializable {
        private static final long serialVersionUID = 1;
        protected final DefaultTyping _appliesFor;

        public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
            return useForType(javaType) ? super.buildTypeDeserializer(deserializationConfig, javaType, collection) : null;
        }

        public TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
            return useForType(javaType) ? super.buildTypeSerializer(serializationConfig, javaType, collection) : null;
        }

        /* JADX WARNING: Missing block: B:14:0x003d, code:
            if (r5.isArrayType() == false) goto L_0x0044;
     */
        /* JADX WARNING: Missing block: B:15:0x003f, code:
            r5 = r5.getContentType();
     */
        /* JADX WARNING: Missing block: B:17:0x0048, code:
            if (r5.isFinal() != false) goto L_0x0058;
     */
        /* JADX WARNING: Missing block: B:19:0x0054, code:
            if (com.fasterxml.jackson.core.TreeNode.class.isAssignableFrom(r5.getRawClass()) != false) goto L_0x0058;
     */
        /* JADX WARNING: Missing block: B:21:0x0058, code:
            r1 = false;
     */
        /* JADX WARNING: Missing block: B:28:?, code:
            return r1;
     */
        public boolean useForType(com.fasterxml.jackson.databind.JavaType r5) {
            /*
            r4 = this;
            r1 = 1;
            r0 = 0;
            r2 = com.fasterxml.jackson.databind.ObjectMapper.AnonymousClass2.$SwitchMap$com$fasterxml$jackson$databind$ObjectMapper$DefaultTyping;
            r3 = r4._appliesFor;
            r3 = r3.ordinal();
            r2 = r2[r3];
            switch(r2) {
                case 1: goto L_0x0014;
                case 2: goto L_0x001f;
                case 3: goto L_0x0039;
                default: goto L_0x000f;
            };
        L_0x000f:
            r0 = r5.isJavaLangObject();
        L_0x0013:
            return r0;
        L_0x0014:
            r2 = r5.isArrayType();
            if (r2 == 0) goto L_0x001f;
        L_0x001a:
            r5 = r5.getContentType();
            goto L_0x0014;
        L_0x001f:
            r2 = r5.isJavaLangObject();
            if (r2 != 0) goto L_0x0037;
        L_0x0025:
            r2 = r5.isConcrete();
            if (r2 != 0) goto L_0x0013;
        L_0x002b:
            r2 = com.fasterxml.jackson.core.TreeNode.class;
            r3 = r5.getRawClass();
            r2 = r2.isAssignableFrom(r3);
            if (r2 != 0) goto L_0x0013;
        L_0x0037:
            r0 = r1;
            goto L_0x0013;
        L_0x0039:
            r2 = r5.isArrayType();
            if (r2 == 0) goto L_0x0044;
        L_0x003f:
            r5 = r5.getContentType();
            goto L_0x0039;
        L_0x0044:
            r2 = r5.isFinal();
            if (r2 != 0) goto L_0x0058;
        L_0x004a:
            r2 = com.fasterxml.jackson.core.TreeNode.class;
            r3 = r5.getRawClass();
            r2 = r2.isAssignableFrom(r3);
            if (r2 != 0) goto L_0x0058;
        L_0x0056:
            r0 = r1;
            goto L_0x0013;
        L_0x0058:
            r1 = r0;
            goto L_0x0056;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder.useForType(com.fasterxml.jackson.databind.JavaType):boolean");
        }
    }

    public enum DefaultTyping {
        JAVA_LANG_OBJECT,
        OBJECT_AND_NON_CONCRETE,
        NON_CONCRETE_AND_ARRAYS,
        NON_FINAL
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    public ObjectMapper(JsonFactory jsonFactory) {
        this(jsonFactory, null, null);
    }

    public ObjectMapper(JsonFactory jsonFactory, DefaultSerializerProvider defaultSerializerProvider, DefaultDeserializationContext defaultDeserializationContext) {
        this._rootDeserializers = new ConcurrentHashMap(64, 0.6f, 2);
        if (jsonFactory == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jsonFactory;
            if (jsonFactory.getCodec() == null) {
                this._jsonFactory.setCodec(this);
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNameLookup = new RootNameLookup();
        this._typeFactory = TypeFactory.defaultInstance();
        SimpleMixInResolver simpleMixInResolver = new SimpleMixInResolver(null);
        this._mixIns = simpleMixInResolver;
        BaseSettings withClassIntrospector = DEFAULT_BASE.withClassIntrospector(defaultClassIntrospector());
        this._serializationConfig = new SerializationConfig(withClassIntrospector, this._subtypeResolver, simpleMixInResolver, rootNameLookup);
        this._deserializationConfig = new DeserializationConfig(withClassIntrospector, this._subtypeResolver, simpleMixInResolver, rootNameLookup);
        boolean requiresPropertyOrdering = this._jsonFactory.requiresPropertyOrdering();
        if ((this._serializationConfig.isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY) ^ requiresPropertyOrdering) != 0) {
            configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, requiresPropertyOrdering);
        }
        if (defaultSerializerProvider == null) {
            defaultSerializerProvider = new Impl();
        }
        this._serializerProvider = defaultSerializerProvider;
        if (defaultDeserializationContext == null) {
            defaultDeserializationContext = new DefaultDeserializationContext.Impl(BeanDeserializerFactory.instance);
        }
        this._deserializationContext = defaultDeserializationContext;
        this._serializerFactory = BeanSerializerFactory.instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A:{SYNTHETIC, Splitter: B:23:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A:{SYNTHETIC, Splitter: B:23:0x0034} */
    private final void _configAndWriteCloseable(com.fasterxml.jackson.core.JsonGenerator r6, java.lang.Object r7, com.fasterxml.jackson.databind.SerializationConfig r8) {
        /*
        r5 = this;
        r2 = 0;
        r0 = r7;
        r0 = (java.io.Closeable) r0;
        r1 = r5._serializerProvider(r8);	 Catch:{ all -> 0x0023 }
        r1.serializeValue(r6, r7);	 Catch:{ all -> 0x0023 }
        r1 = 0;
        r6.close();	 Catch:{ all -> 0x0040 }
        r3 = 0;
        r0.close();	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x001d;
    L_0x0015:
        r0 = com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT;
        r2.disable(r0);
        r1.close();	 Catch:{ IOException -> 0x0038 }
    L_0x001d:
        if (r2 == 0) goto L_0x0022;
    L_0x001f:
        r3.close();	 Catch:{ IOException -> 0x003a }
    L_0x0022:
        return;
    L_0x0023:
        r1 = move-exception;
        r2 = r6;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x0028:
        if (r2 == 0) goto L_0x0032;
    L_0x002a:
        r3 = com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT;
        r2.disable(r3);
        r2.close();	 Catch:{ IOException -> 0x003c }
    L_0x0032:
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r1.close();	 Catch:{ IOException -> 0x003e }
    L_0x0037:
        throw r0;
    L_0x0038:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003a:
        r0 = move-exception;
        goto L_0x0022;
    L_0x003c:
        r2 = move-exception;
        goto L_0x0032;
    L_0x003e:
        r1 = move-exception;
        goto L_0x0037;
    L_0x0040:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0028;
    L_0x0045:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper._configAndWriteCloseable(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object, com.fasterxml.jackson.databind.SerializationConfig):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A:{SYNTHETIC, Splitter: B:14:0x0025} */
    private final void _writeCloseableValue(com.fasterxml.jackson.core.JsonGenerator r4, java.lang.Object r5, com.fasterxml.jackson.databind.SerializationConfig r6) {
        /*
        r3 = this;
        r0 = r5;
        r0 = (java.io.Closeable) r0;
        r1 = r3._serializerProvider(r6);	 Catch:{ all -> 0x001f }
        r1.serializeValue(r4, r5);	 Catch:{ all -> 0x001f }
        r1 = com.fasterxml.jackson.databind.SerializationFeature.FLUSH_AFTER_WRITE_VALUE;	 Catch:{ all -> 0x001f }
        r1 = r6.isEnabled(r1);	 Catch:{ all -> 0x001f }
        if (r1 == 0) goto L_0x0015;
    L_0x0012:
        r4.flush();	 Catch:{ all -> 0x001f }
    L_0x0015:
        r1 = 0;
        r0.close();	 Catch:{ all -> 0x002d }
        if (r1 == 0) goto L_0x001e;
    L_0x001b:
        r1.close();	 Catch:{ IOException -> 0x0029 }
    L_0x001e:
        return;
    L_0x001f:
        r1 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
    L_0x0023:
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r1.close();	 Catch:{ IOException -> 0x002b }
    L_0x0028:
        throw r0;
    L_0x0029:
        r0 = move-exception;
        goto L_0x001e;
    L_0x002b:
        r1 = move-exception;
        goto L_0x0028;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper._writeCloseableValue(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object, com.fasterxml.jackson.databind.SerializationConfig):void");
    }

    protected final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) {
        SerializationConfig serializationConfig = getSerializationConfig();
        serializationConfig.initialize(jsonGenerator);
        if (serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            _configAndWriteCloseable(jsonGenerator, obj, serializationConfig);
            return;
        }
        Object obj2 = null;
        try {
            _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                jsonGenerator.disable(Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    protected Object _convert(Object obj, JavaType javaType) {
        Class rawClass = javaType.getRawClass();
        if (rawClass == Object.class || javaType.hasGenericTypes() || !rawClass.isAssignableFrom(obj.getClass())) {
            JsonGenerator tokenBuffer = new TokenBuffer((ObjectCodec) this, false);
            if (isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                tokenBuffer = tokenBuffer.forceUseOfBigDecimal(true);
            }
            try {
                _serializerProvider(getSerializationConfig().without(SerializationFeature.WRAP_ROOT_VALUE)).serializeValue(tokenBuffer, obj);
                JsonParser asParser = tokenBuffer.asParser();
                DeserializationConfig deserializationConfig = getDeserializationConfig();
                JsonToken _initForReading = _initForReading(asParser);
                DeserializationContext createDeserializationContext;
                if (_initForReading == JsonToken.VALUE_NULL) {
                    createDeserializationContext = createDeserializationContext(asParser, deserializationConfig);
                    obj = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
                } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                    obj = null;
                } else {
                    createDeserializationContext = createDeserializationContext(asParser, deserializationConfig);
                    obj = _findRootDeserializer(createDeserializationContext, javaType).deserialize(asParser, createDeserializationContext);
                }
                asParser.close();
            } catch (Throwable e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        return obj;
    }

    protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext deserializationContext, JavaType javaType) {
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) this._rootDeserializers.get(javaType);
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.findRootValueDeserializer(javaType);
            if (jsonDeserializer == null) {
                throw JsonMappingException.from(deserializationContext, "Can not find a deserializer for type " + javaType);
            }
            this._rootDeserializers.put(javaType, jsonDeserializer);
        }
        return jsonDeserializer;
    }

    protected JsonToken _initForReading(JsonParser jsonParser) {
        this._deserializationConfig.initialize(jsonParser);
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == null) {
            currentToken = jsonParser.nextToken();
            if (currentToken == null) {
                throw JsonMappingException.from(jsonParser, "No content to map due to end-of-input");
            }
        }
        return currentToken;
    }

    protected ObjectReader _newReader(DeserializationConfig deserializationConfig, JavaType javaType, Object obj, FormatSchema formatSchema, InjectableValues injectableValues) {
        return new ObjectReader(this, deserializationConfig, javaType, obj, formatSchema, injectableValues);
    }

    protected ObjectWriter _newWriter(SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter) {
        return new ObjectWriter(this, serializationConfig, javaType, prettyPrinter);
    }

    protected Object _readMapAndClose(JsonParser jsonParser, JavaType javaType) {
        try {
            Object nullValue;
            JsonToken _initForReading = _initForReading(jsonParser);
            if (_initForReading == JsonToken.VALUE_NULL) {
                DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser, getDeserializationConfig());
                nullValue = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
            } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                nullValue = null;
            } else {
                DeserializationConfig deserializationConfig = getDeserializationConfig();
                DeserializationContext createDeserializationContext2 = createDeserializationContext(jsonParser, deserializationConfig);
                JsonDeserializer _findRootDeserializer = _findRootDeserializer(createDeserializationContext2, javaType);
                nullValue = deserializationConfig.useRootWrapping() ? _unwrapAndDeserialize(jsonParser, createDeserializationContext2, deserializationConfig, javaType, _findRootDeserializer) : _findRootDeserializer.deserialize(jsonParser, createDeserializationContext2);
                createDeserializationContext2.checkUnresolvedObjectId();
            }
            jsonParser.clearCurrentToken();
            return nullValue;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    protected Object _readValue(DeserializationConfig deserializationConfig, JsonParser jsonParser, JavaType javaType) {
        Object nullValue;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL) {
            DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser, deserializationConfig);
            nullValue = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
        } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            nullValue = null;
        } else {
            DeserializationContext createDeserializationContext2 = createDeserializationContext(jsonParser, deserializationConfig);
            JsonDeserializer _findRootDeserializer = _findRootDeserializer(createDeserializationContext2, javaType);
            nullValue = deserializationConfig.useRootWrapping() ? _unwrapAndDeserialize(jsonParser, createDeserializationContext2, deserializationConfig, javaType, _findRootDeserializer) : _findRootDeserializer.deserialize(jsonParser, createDeserializationContext2);
        }
        jsonParser.clearCurrentToken();
        return nullValue;
    }

    protected DefaultSerializerProvider _serializerProvider(SerializationConfig serializationConfig) {
        return this._serializerProvider.createInstance(serializationConfig, this._serializerFactory);
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<Object> jsonDeserializer) {
        String simpleName = deserializationConfig.findRootName(javaType).getSimpleName();
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw JsonMappingException.from(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
        } else if (jsonParser.nextToken() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.from(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
        } else {
            String currentName = jsonParser.getCurrentName();
            if (simpleName.equals(currentName)) {
                jsonParser.nextToken();
                Object deserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                if (jsonParser.nextToken() == JsonToken.END_OBJECT) {
                    return deserialize;
                }
                throw JsonMappingException.from(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + simpleName + "'), but " + jsonParser.getCurrentToken());
            }
            throw JsonMappingException.from(jsonParser, "Root name '" + currentName + "' does not match expected ('" + simpleName + "') for type " + javaType);
        }
    }

    public ObjectMapper configure(JsonParser.Feature feature, boolean z) {
        this._jsonFactory.configure(feature, z);
        return this;
    }

    public ObjectMapper configure(MapperFeature mapperFeature, boolean z) {
        SerializationConfig with;
        DeserializationConfig with2;
        if (z) {
            with = this._serializationConfig.with(mapperFeature);
        } else {
            with = this._serializationConfig.without(mapperFeature);
        }
        this._serializationConfig = with;
        if (z) {
            with2 = this._deserializationConfig.with(mapperFeature);
        } else {
            with2 = this._deserializationConfig.without(mapperFeature);
        }
        this._deserializationConfig = with2;
        return this;
    }

    public <T> T convertValue(Object obj, Class<T> cls) {
        return obj == null ? null : _convert(obj, this._typeFactory.constructType((Type) cls));
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser jsonParser, DeserializationConfig deserializationConfig) {
        return this._deserializationContext.createInstance(deserializationConfig, jsonParser, this._injectableValues);
    }

    protected ClassIntrospector defaultClassIntrospector() {
        return new BasicClassIntrospector();
    }

    public ObjectMapper disable(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        this._deserializationConfig = this._deserializationConfig.without(deserializationFeature, deserializationFeatureArr);
        return this;
    }

    public ObjectMapper enable(DeserializationFeature deserializationFeature) {
        this._deserializationConfig = this._deserializationConfig.with(deserializationFeature);
        return this;
    }

    public DeserializationConfig getDeserializationConfig() {
        return this._deserializationConfig;
    }

    public JsonFactory getFactory() {
        return this._jsonFactory;
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public JsonNodeFactory getNodeFactory() {
        return this._deserializationConfig.getNodeFactory();
    }

    public SerializationConfig getSerializationConfig() {
        return this._serializationConfig;
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public boolean isEnabled(DeserializationFeature deserializationFeature) {
        return this._deserializationConfig.isEnabled(deserializationFeature);
    }

    public <T extends TreeNode> T readTree(JsonParser jsonParser) {
        DeserializationConfig deserializationConfig = getDeserializationConfig();
        if (jsonParser.getCurrentToken() == null && jsonParser.nextToken() == null) {
            return null;
        }
        JsonNode jsonNode = (JsonNode) _readValue(deserializationConfig, jsonParser, JSON_NODE_TYPE);
        return jsonNode == null ? getNodeFactory().nullNode() : jsonNode;
    }

    public JsonNode readTree(String str) {
        JsonNode jsonNode = (JsonNode) _readMapAndClose(this._jsonFactory.createParser(str), JSON_NODE_TYPE);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) {
        return _readValue(getDeserializationConfig(), jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(String str, TypeReference typeReference) {
        return _readMapAndClose(this._jsonFactory.createParser(str), this._typeFactory.constructType(typeReference));
    }

    public <T> T readValue(String str, Class<T> cls) {
        return _readMapAndClose(this._jsonFactory.createParser(str), this._typeFactory.constructType((Type) cls));
    }

    @Deprecated
    public ObjectReader reader(JavaType javaType) {
        return _newReader(getDeserializationConfig(), javaType, null, null, this._injectableValues);
    }

    public ObjectReader readerFor(JavaType javaType) {
        return _newReader(getDeserializationConfig(), javaType, null, null, this._injectableValues);
    }

    public JsonParser treeAsTokens(TreeNode treeNode) {
        return new TreeTraversingParser((JsonNode) treeNode, this);
    }

    public <T> T treeToValue(TreeNode treeNode, Class<T> cls) {
        try {
            return (cls == Object.class || !cls.isAssignableFrom(treeNode.getClass())) ? readValue(treeAsTokens(treeNode), (Class) cls) : treeNode;
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
        SerializationConfig serializationConfig = getSerializationConfig();
        if (serializationConfig.isEnabled(SerializationFeature.INDENT_OUTPUT) && jsonGenerator.getPrettyPrinter() == null) {
            jsonGenerator.setPrettyPrinter(serializationConfig.constructDefaultPrettyPrinter());
        }
        if (serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            _writeCloseableValue(jsonGenerator, obj, serializationConfig);
            return;
        }
        _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
        if (serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public String writeValueAsString(Object obj) {
        Writer segmentedStringWriter = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._jsonFactory.createGenerator(segmentedStringWriter), obj);
            return segmentedStringWriter.getAndClear();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public ObjectWriter writerFor(JavaType javaType) {
        return _newWriter(getSerializationConfig(), javaType, null);
    }

    @Deprecated
    public ObjectWriter writerWithType(JavaType javaType) {
        return _newWriter(getSerializationConfig(), javaType, null);
    }
}
