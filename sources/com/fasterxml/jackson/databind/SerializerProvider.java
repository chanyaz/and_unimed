package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class SerializerProvider extends DatabindContext {
    public static final JsonSerializer<Object> DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    protected static final JsonSerializer<Object> DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
    protected transient ContextAttributes _attributes;
    protected final SerializationConfig _config;
    protected DateFormat _dateFormat;
    protected JsonSerializer<Object> _keySerializer;
    protected final ReadOnlyClassToSerializerMap _knownSerializers;
    protected JsonSerializer<Object> _nullKeySerializer;
    protected JsonSerializer<Object> _nullValueSerializer;
    protected final Class<?> _serializationView;
    protected final SerializerCache _serializerCache;
    protected final SerializerFactory _serializerFactory;
    protected final boolean _stdNullValueSerializer;
    protected JsonSerializer<Object> _unknownTypeSerializer;

    public SerializerProvider() {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new SerializerCache();
        this._knownSerializers = null;
        this._serializationView = null;
        this._attributes = null;
        this._stdNullValueSerializer = true;
    }

    protected SerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        if (serializationConfig == null) {
            throw new NullPointerException();
        }
        this._serializerFactory = serializerFactory;
        this._config = serializationConfig;
        this._serializerCache = serializerProvider._serializerCache;
        this._unknownTypeSerializer = serializerProvider._unknownTypeSerializer;
        this._keySerializer = serializerProvider._keySerializer;
        this._nullValueSerializer = serializerProvider._nullValueSerializer;
        this._nullKeySerializer = serializerProvider._nullKeySerializer;
        this._stdNullValueSerializer = this._nullValueSerializer == DEFAULT_NULL_KEY_SERIALIZER;
        this._serializationView = serializationConfig.getActiveView();
        this._attributes = serializationConfig.getAttributes();
        this._knownSerializers = this._serializerCache.getReadOnlyLookupMap();
    }

    protected JsonSerializer<Object> _createAndCacheUntypedSerializer(JavaType javaType) {
        try {
            JsonSerializer<Object> _createUntypedSerializer = _createUntypedSerializer(javaType);
            if (_createUntypedSerializer != null) {
                this._serializerCache.addAndResolveNonTypedSerializer(javaType, _createUntypedSerializer, this);
            }
            return _createUntypedSerializer;
        } catch (Throwable e) {
            throw JsonMappingException.from(this, e.getMessage(), e);
        }
    }

    protected JsonSerializer<Object> _createAndCacheUntypedSerializer(Class<?> cls) {
        JavaType constructType = this._config.constructType(cls);
        try {
            JsonSerializer<Object> _createUntypedSerializer = _createUntypedSerializer(constructType);
            if (_createUntypedSerializer != null) {
                this._serializerCache.addAndResolveNonTypedSerializer(cls, constructType, _createUntypedSerializer, this);
            }
            return _createUntypedSerializer;
        } catch (Throwable e) {
            throw JsonMappingException.from(this, e.getMessage(), e);
        }
    }

    protected JsonSerializer<Object> _createUntypedSerializer(JavaType javaType) {
        JsonSerializer<Object> createSerializer;
        synchronized (this._serializerCache) {
            createSerializer = this._serializerFactory.createSerializer(this, javaType);
        }
        return createSerializer;
    }

    protected final DateFormat _dateFormat() {
        if (this._dateFormat != null) {
            return this._dateFormat;
        }
        DateFormat dateFormat = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat;
        return dateFormat;
    }

    protected JsonSerializer<Object> _handleContextualResolvable(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) {
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).resolve(this);
        }
        return handleSecondaryContextualization(jsonSerializer, beanProperty);
    }

    protected JsonSerializer<Object> _handleResolvable(JsonSerializer<?> jsonSerializer) {
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).resolve(this);
        }
        return jsonSerializer;
    }

    protected void _reportIncompatibleRootType(Object obj, JavaType javaType) {
        if (!javaType.isPrimitive() || !ClassUtil.wrapperType(javaType.getRawClass()).isAssignableFrom(obj.getClass())) {
            throw JsonMappingException.from(this, "Incompatible types: declared root type (" + javaType + ") vs " + obj.getClass().getName());
        }
    }

    public final boolean canOverrideAccessModifiers() {
        return this._config.canOverrideAccessModifiers();
    }

    public void defaultSerializeDateKey(long j, JsonGenerator jsonGenerator) {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.writeFieldName(String.valueOf(j));
        } else {
            jsonGenerator.writeFieldName(_dateFormat().format(new Date(j)));
        }
    }

    public void defaultSerializeDateKey(Date date, JsonGenerator jsonGenerator) {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.writeFieldName(String.valueOf(date.getTime()));
        } else {
            jsonGenerator.writeFieldName(_dateFormat().format(date));
        }
    }

    public final void defaultSerializeDateValue(Date date, JsonGenerator jsonGenerator) {
        if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.writeNumber(date.getTime());
        } else {
            jsonGenerator.writeString(_dateFormat().format(date));
        }
    }

    public final void defaultSerializeNull(JsonGenerator jsonGenerator) {
        if (this._stdNullValueSerializer) {
            jsonGenerator.writeNull();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public JsonSerializer<Object> findKeySerializer(JavaType javaType, BeanProperty beanProperty) {
        return _handleContextualResolvable(this._serializerFactory.createKeySerializer(this._config, javaType, this._keySerializer), beanProperty);
    }

    public JsonSerializer<Object> findKeySerializer(Class<?> cls, BeanProperty beanProperty) {
        return findKeySerializer(this._config.constructType(cls), beanProperty);
    }

    public JsonSerializer<Object> findNullKeySerializer(JavaType javaType, BeanProperty beanProperty) {
        return this._nullKeySerializer;
    }

    public JsonSerializer<Object> findNullValueSerializer(BeanProperty beanProperty) {
        return this._nullValueSerializer;
    }

    public abstract WritableObjectId findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public JsonSerializer<Object> findPrimaryPropertySerializer(JavaType javaType, BeanProperty beanProperty) {
        JsonSerializer untypedValueSerializer = this._knownSerializers.untypedValueSerializer(javaType);
        if (untypedValueSerializer == null) {
            untypedValueSerializer = this._serializerCache.untypedValueSerializer(javaType);
            if (untypedValueSerializer == null) {
                untypedValueSerializer = _createAndCacheUntypedSerializer(javaType);
                if (untypedValueSerializer == null) {
                    return getUnknownTypeSerializer(javaType.getRawClass());
                }
            }
        }
        return handlePrimaryContextualization(untypedValueSerializer, beanProperty);
    }

    public JsonSerializer<Object> findPrimaryPropertySerializer(Class<?> cls, BeanProperty beanProperty) {
        JsonSerializer untypedValueSerializer = this._knownSerializers.untypedValueSerializer((Class) cls);
        if (untypedValueSerializer == null) {
            untypedValueSerializer = this._serializerCache.untypedValueSerializer((Class) cls);
            if (untypedValueSerializer == null) {
                untypedValueSerializer = this._serializerCache.untypedValueSerializer(this._config.constructType(cls));
                if (untypedValueSerializer == null) {
                    untypedValueSerializer = _createAndCacheUntypedSerializer((Class) cls);
                    if (untypedValueSerializer == null) {
                        return getUnknownTypeSerializer(cls);
                    }
                }
            }
        }
        return handlePrimaryContextualization(untypedValueSerializer, beanProperty);
    }

    public JsonSerializer<Object> findTypedValueSerializer(JavaType javaType, boolean z, BeanProperty beanProperty) {
        JsonSerializer<Object> typedValueSerializer = this._knownSerializers.typedValueSerializer(javaType);
        if (typedValueSerializer == null) {
            typedValueSerializer = this._serializerCache.typedValueSerializer(javaType);
            if (typedValueSerializer == null) {
                JsonSerializer<Object> findValueSerializer = findValueSerializer(javaType, beanProperty);
                TypeSerializer createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, javaType);
                JsonSerializer typedValueSerializer2 = createTypeSerializer != null ? new TypeWrappedSerializer(createTypeSerializer.forProperty(beanProperty), findValueSerializer) : findValueSerializer;
                if (z) {
                    this._serializerCache.addTypedSerializer(javaType, typedValueSerializer2);
                }
            }
        }
        return typedValueSerializer2;
    }

    public JsonSerializer<Object> findTypedValueSerializer(Class<?> cls, boolean z, BeanProperty beanProperty) {
        JsonSerializer<Object> typedValueSerializer = this._knownSerializers.typedValueSerializer((Class) cls);
        if (typedValueSerializer == null) {
            typedValueSerializer = this._serializerCache.typedValueSerializer((Class) cls);
            if (typedValueSerializer == null) {
                JsonSerializer<Object> findValueSerializer = findValueSerializer((Class) cls, beanProperty);
                TypeSerializer createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, this._config.constructType(cls));
                JsonSerializer typedValueSerializer2 = createTypeSerializer != null ? new TypeWrappedSerializer(createTypeSerializer.forProperty(beanProperty), findValueSerializer) : findValueSerializer;
                if (z) {
                    this._serializerCache.addTypedSerializer((Class) cls, typedValueSerializer2);
                }
            }
        }
        return typedValueSerializer2;
    }

    public JsonSerializer<Object> findValueSerializer(JavaType javaType) {
        JsonSerializer<Object> untypedValueSerializer = this._knownSerializers.untypedValueSerializer(javaType);
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        untypedValueSerializer = this._serializerCache.untypedValueSerializer(javaType);
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        untypedValueSerializer = _createAndCacheUntypedSerializer(javaType);
        return untypedValueSerializer == null ? getUnknownTypeSerializer(javaType.getRawClass()) : untypedValueSerializer;
    }

    public JsonSerializer<Object> findValueSerializer(JavaType javaType, BeanProperty beanProperty) {
        JsonSerializer untypedValueSerializer = this._knownSerializers.untypedValueSerializer(javaType);
        if (untypedValueSerializer == null) {
            untypedValueSerializer = this._serializerCache.untypedValueSerializer(javaType);
            if (untypedValueSerializer == null) {
                untypedValueSerializer = _createAndCacheUntypedSerializer(javaType);
                if (untypedValueSerializer == null) {
                    return getUnknownTypeSerializer(javaType.getRawClass());
                }
            }
        }
        return handleSecondaryContextualization(untypedValueSerializer, beanProperty);
    }

    public JsonSerializer<Object> findValueSerializer(Class<?> cls) {
        JsonSerializer<Object> untypedValueSerializer = this._knownSerializers.untypedValueSerializer((Class) cls);
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        untypedValueSerializer = this._serializerCache.untypedValueSerializer((Class) cls);
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        untypedValueSerializer = this._serializerCache.untypedValueSerializer(this._config.constructType(cls));
        if (untypedValueSerializer != null) {
            return untypedValueSerializer;
        }
        untypedValueSerializer = _createAndCacheUntypedSerializer((Class) cls);
        return untypedValueSerializer == null ? getUnknownTypeSerializer(cls) : untypedValueSerializer;
    }

    public JsonSerializer<Object> findValueSerializer(Class<?> cls, BeanProperty beanProperty) {
        JsonSerializer untypedValueSerializer = this._knownSerializers.untypedValueSerializer((Class) cls);
        if (untypedValueSerializer == null) {
            untypedValueSerializer = this._serializerCache.untypedValueSerializer((Class) cls);
            if (untypedValueSerializer == null) {
                untypedValueSerializer = this._serializerCache.untypedValueSerializer(this._config.constructType(cls));
                if (untypedValueSerializer == null) {
                    untypedValueSerializer = _createAndCacheUntypedSerializer((Class) cls);
                    if (untypedValueSerializer == null) {
                        return getUnknownTypeSerializer(cls);
                    }
                }
            }
        }
        return handleSecondaryContextualization(untypedValueSerializer, beanProperty);
    }

    public final Class<?> getActiveView() {
        return this._serializationView;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public Object getAttribute(Object obj) {
        return this._attributes.getAttribute(obj);
    }

    public final SerializationConfig getConfig() {
        return this._config;
    }

    public JsonSerializer<Object> getDefaultNullValueSerializer() {
        return this._nullValueSerializer;
    }

    public final Value getDefaultPropertyFormat(Class<?> cls) {
        return this._config.getDefaultPropertyFormat(cls);
    }

    public final FilterProvider getFilterProvider() {
        return this._config.getFilterProvider();
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public JsonSerializer<Object> getUnknownTypeSerializer(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new UnknownSerializer(cls);
    }

    public JsonSerializer<?> handlePrimaryContextualization(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) {
        return (jsonSerializer == null || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).createContextual(this, beanProperty);
    }

    public JsonSerializer<?> handleSecondaryContextualization(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) {
        return (jsonSerializer == null || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).createContextual(this, beanProperty);
    }

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public final boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public JsonMappingException mappingException(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return JsonMappingException.from(this, str);
    }

    public abstract JsonSerializer<Object> serializerInstance(Annotated annotated, Object obj);

    public SerializerProvider setAttribute(Object obj, Object obj2) {
        this._attributes = this._attributes.withPerCallAttribute(obj, obj2);
        return this;
    }
}
