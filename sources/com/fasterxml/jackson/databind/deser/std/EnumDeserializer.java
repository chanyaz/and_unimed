package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.lang.reflect.Method;

@JacksonStdImpl
public class EnumDeserializer extends StdScalarDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final CompactStringObjectMap _enumLookup;
    protected Object[] _enumsByIndex;

    public class FactoryBasedDeserializer extends StdDeserializer<Object> implements ContextualDeserializer {
        private static final long serialVersionUID = 1;
        protected final JsonDeserializer<?> _deser;
        protected final Method _factory;
        protected final Class<?> _inputType;

        protected FactoryBasedDeserializer(FactoryBasedDeserializer factoryBasedDeserializer, JsonDeserializer<?> jsonDeserializer) {
            super(factoryBasedDeserializer._valueClass);
            this._inputType = factoryBasedDeserializer._inputType;
            this._factory = factoryBasedDeserializer._factory;
            this._deser = jsonDeserializer;
        }

        public FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod, Class<?> cls2) {
            super((Class) cls);
            this._factory = annotatedMethod.getAnnotated();
            this._inputType = cls2;
            this._deser = null;
        }

        public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
            return (this._deser != null || this._inputType == String.class) ? this : new FactoryBasedDeserializer(this, deserializationContext.findContextualValueDeserializer(deserializationContext.constructType(this._inputType), beanProperty));
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Object deserialize;
            if (this._deser != null) {
                deserialize = this._deser.deserialize(jsonParser, deserializationContext);
            } else {
                JsonToken currentToken = jsonParser.getCurrentToken();
                deserialize = (currentToken == JsonToken.VALUE_STRING || currentToken == JsonToken.FIELD_NAME) ? jsonParser.getText() : jsonParser.getValueAsString();
            }
            try {
                return this._factory.invoke(this._valueClass, new Object[]{deserialize});
            } catch (Throwable th) {
                Throwable th2 = ClassUtil.getRootCause(th2);
                if (th2 instanceof IOException) {
                    throw ((IOException) th2);
                }
                throw deserializationContext.instantiationException(this._valueClass, th2);
            }
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return this._deser == null ? deserialize(jsonParser, deserializationContext) : typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
        }
    }

    public EnumDeserializer(EnumResolver enumResolver) {
        super(enumResolver.getEnumClass());
        this._enumLookup = enumResolver.constructLookup();
        this._enumsByIndex = enumResolver.getRawEnums();
    }

    private final Object _deserializeAltString(JsonParser jsonParser, DeserializationContext deserializationContext, String str) {
        String trim = str.trim();
        if (trim.length() != 0) {
            char charAt = trim.charAt(0);
            if (charAt >= '0' && charAt <= '9') {
                try {
                    int parseInt = Integer.parseInt(trim);
                    if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                        _failOnNumber(deserializationContext, jsonParser, parseInt);
                    }
                    if (parseInt >= 0 && parseInt <= this._enumsByIndex.length) {
                        return this._enumsByIndex[parseInt];
                    }
                } catch (NumberFormatException e) {
                }
            }
        } else if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
            return null;
        }
        if (deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
            return null;
        }
        throw deserializationContext.weirdStringException(trim, _enumClass(), "value not one of declared Enum instance names: " + this._enumLookup.keys());
    }

    public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedMethod annotatedMethod) {
        Class rawParameterType = annotatedMethod.getRawParameterType(0);
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotatedMethod.getMember(), deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedDeserializer(cls, annotatedMethod, rawParameterType);
    }

    protected Object _deserializeOther(JsonParser jsonParser, DeserializationContext deserializationContext) {
        jsonParser.getCurrentToken();
        if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS) && jsonParser.isExpectedStartArrayToken()) {
            jsonParser.nextToken();
            Object deserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                return deserialize;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _enumClass().getName() + "' value but there was more than a single value in the array");
        }
        throw deserializationContext.mappingException(_enumClass());
    }

    protected Class<?> _enumClass() {
        return handledType();
    }

    protected void _failOnNumber(DeserializationContext deserializationContext, JsonParser jsonParser, int i) {
        throw InvalidFormatException.from(jsonParser, String.format("Not allowed to deserialize Enum value out of JSON number (%d): disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[]{Integer.valueOf(i)}), Integer.valueOf(i), _enumClass());
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_STRING || currentToken == JsonToken.FIELD_NAME) {
            String text = jsonParser.getText();
            Object find = this._enumLookup.find(text);
            return find == null ? _deserializeAltString(jsonParser, deserializationContext, text) : find;
        } else if (currentToken != JsonToken.VALUE_NUMBER_INT) {
            return _deserializeOther(jsonParser, deserializationContext);
        } else {
            int intValue = jsonParser.getIntValue();
            if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                _failOnNumber(deserializationContext, jsonParser, intValue);
            }
            if (intValue >= 0 && intValue <= this._enumsByIndex.length) {
                return this._enumsByIndex[intValue];
            }
            if (deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            throw deserializationContext.weirdNumberException(Integer.valueOf(intValue), _enumClass(), "index value outside legal index range [0.." + (this._enumsByIndex.length - 1) + "]");
        }
    }

    public boolean isCachable() {
        return true;
    }
}
