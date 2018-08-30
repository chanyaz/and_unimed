package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class DefaultSerializerProvider extends SerializerProvider implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
    protected transient Map<Object, WritableObjectId> _seenObjectIds;

    public final class Impl extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        protected Impl(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
            super(serializerProvider, serializationConfig, serializerFactory);
        }

        public Impl createInstance(SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
            return new Impl(this, serializationConfig, serializerFactory);
        }
    }

    protected DefaultSerializerProvider() {
    }

    protected DefaultSerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        super(serializerProvider, serializationConfig, serializerFactory);
    }

    protected Map<Object, WritableObjectId> _createObjectIdMap() {
        return isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
    }

    protected void _serializeNull(JsonGenerator jsonGenerator) {
        try {
            getDefaultNullValueSerializer().serialize(null, jsonGenerator, this);
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "[no message for " + e2.getClass().getName() + "]";
            }
            throw JsonMappingException.from(jsonGenerator, message, e2);
        }
    }

    public abstract DefaultSerializerProvider createInstance(SerializationConfig serializationConfig, SerializerFactory serializerFactory);

    public WritableObjectId findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ObjectIdGenerator objectIdGenerator2;
        if (this._seenObjectIds == null) {
            this._seenObjectIds = _createObjectIdMap();
        } else {
            WritableObjectId writableObjectId = (WritableObjectId) this._seenObjectIds.get(obj);
            if (writableObjectId != null) {
                return writableObjectId;
            }
        }
        if (this._objectIdGenerators == null) {
            this._objectIdGenerators = new ArrayList(8);
            objectIdGenerator2 = null;
        } else {
            int size = this._objectIdGenerators.size();
            for (int i = 0; i < size; i++) {
                objectIdGenerator2 = (ObjectIdGenerator) this._objectIdGenerators.get(i);
                if (objectIdGenerator2.canUseFor(objectIdGenerator)) {
                    break;
                }
            }
            objectIdGenerator2 = null;
        }
        if (objectIdGenerator2 == null) {
            objectIdGenerator2 = objectIdGenerator.newForSerialization(this);
            this._objectIdGenerators.add(objectIdGenerator2);
        }
        WritableObjectId writableObjectId2 = new WritableObjectId(objectIdGenerator2);
        this._seenObjectIds.put(obj, writableObjectId2);
        return writableObjectId2;
    }

    public void serializePolymorphic(JsonGenerator jsonGenerator, Object obj, JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer) {
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        JsonSerializer jsonSerializer2;
        boolean isEnabled;
        if (!(javaType == null || javaType.getRawClass().isAssignableFrom(obj.getClass()))) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (jsonSerializer2 == null) {
            jsonSerializer2 = (javaType == null || !javaType.isContainerType()) ? findValueSerializer(obj.getClass(), null) : findValueSerializer(javaType, null);
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            isEnabled = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (isEnabled) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            isEnabled = false;
        } else {
            isEnabled = true;
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(fullRootName.getSimpleName());
        }
        try {
            jsonSerializer2.serializeWithType(obj, jsonGenerator, this, typeSerializer);
            if (isEnabled) {
                jsonGenerator.writeEndObject();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw JsonMappingException.from(jsonGenerator, message, th);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj) {
        boolean z = true;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        JsonSerializer findTypedValueSerializer = findTypedValueSerializer(obj.getClass(), true, null);
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            z = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (z) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            z = false;
        } else {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(fullRootName.getSimpleName());
        }
        try {
            findTypedValueSerializer.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.writeEndObject();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException((Closeable) jsonGenerator, message, th);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        boolean z = true;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        JsonSerializer jsonSerializer2;
        if (!(javaType == null || javaType.getRawClass().isAssignableFrom(obj.getClass()))) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (jsonSerializer2 == null) {
            jsonSerializer2 = findTypedValueSerializer(javaType, true, null);
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            boolean isEnabled = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (isEnabled) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName((javaType == null ? this._config.findRootName(obj.getClass()) : this._config.findRootName(javaType)).simpleAsEncoded(this._config));
                z = isEnabled;
            } else {
                z = isEnabled;
            }
        } else if (fullRootName.isEmpty()) {
            z = false;
        } else {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(fullRootName.getSimpleName());
        }
        try {
            jsonSerializer2.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.writeEndObject();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw JsonMappingException.from(jsonGenerator, message, th);
        }
    }

    public JsonSerializer<Object> serializerInstance(Annotated annotated, Object obj) {
        JsonSerializer<Object> jsonSerializer = null;
        if (obj == null) {
            return null;
        }
        JsonSerializer jsonSerializer2;
        if (obj instanceof JsonSerializer) {
            jsonSerializer2 = (JsonSerializer) obj;
        } else if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == None.class || ClassUtil.isBogusClass(cls)) {
                return null;
            }
            if (JsonSerializer.class.isAssignableFrom(cls)) {
                HandlerInstantiator handlerInstantiator = this._config.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    jsonSerializer = handlerInstantiator.serializerInstance(this._config, annotated, cls);
                }
                if (jsonSerializer == null) {
                    jsonSerializer2 = (JsonSerializer) ClassUtil.createInstance(cls, this._config.canOverrideAccessModifiers());
                } else {
                    JsonSerializer<Object> jsonSerializer22 = jsonSerializer;
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        return _handleResolvable(jsonSerializer22);
    }
}
