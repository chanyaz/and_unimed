package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@JacksonStdImpl
public class StdKeyDeserializer extends KeyDeserializer implements Serializable {
    private static final long serialVersionUID = 1;
    protected final FromStringDeserializer<?> _deser;
    protected final Class<?> _keyClass;
    protected final int _kind;

    final class DelegatingKD extends KeyDeserializer implements Serializable {
        private static final long serialVersionUID = 1;
        protected final JsonDeserializer<?> _delegate;
        protected final Class<?> _keyClass;

        protected DelegatingKD(Class<?> cls, JsonDeserializer<?> jsonDeserializer) {
            this._keyClass = cls;
            this._delegate = jsonDeserializer;
        }

        public final Object deserializeKey(String str, DeserializationContext deserializationContext) {
            if (str == null) {
                return null;
            }
            try {
                Object deserialize = this._delegate.deserialize(deserializationContext.getParser(), deserializationContext);
                if (deserialize != null) {
                    return deserialize;
                }
                throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation");
            } catch (Exception e) {
                throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation: " + e.getMessage());
            }
        }
    }

    @JacksonStdImpl
    final class EnumKD extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        protected final AnnotatedMethod _factory;
        protected final EnumResolver _resolver;

        protected EnumKD(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
            super(-1, enumResolver.getEnumClass());
            this._resolver = enumResolver;
            this._factory = annotatedMethod;
        }

        public Object _parse(String str, DeserializationContext deserializationContext) {
            if (this._factory != null) {
                try {
                    return this._factory.call1(str);
                } catch (Throwable e) {
                    ClassUtil.unwrapAndThrowAsIAE(e);
                }
            }
            Enum findEnum = this._resolver.findEnum(str);
            if (findEnum != null || deserializationContext.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return findEnum;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not one of values for Enum class");
        }
    }

    final class StringCtorKeyDeserializer extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        protected final Constructor<?> _ctor;

        public StringCtorKeyDeserializer(Constructor<?> constructor) {
            super(-1, constructor.getDeclaringClass());
            this._ctor = constructor;
        }

        public Object _parse(String str, DeserializationContext deserializationContext) {
            return this._ctor.newInstance(new Object[]{str});
        }
    }

    final class StringFactoryKeyDeserializer extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;
        final Method _factoryMethod;

        public StringFactoryKeyDeserializer(Method method) {
            super(-1, method.getDeclaringClass());
            this._factoryMethod = method;
        }

        public Object _parse(String str, DeserializationContext deserializationContext) {
            return this._factoryMethod.invoke(null, new Object[]{str});
        }
    }

    @JacksonStdImpl
    final class StringKD extends StdKeyDeserializer {
        private static final StringKD sObject = new StringKD(Object.class);
        private static final StringKD sString = new StringKD(String.class);
        private static final long serialVersionUID = 1;

        private StringKD(Class<?> cls) {
            super(-1, cls);
        }

        public static StringKD forType(Class<?> cls) {
            return cls == String.class ? sString : cls == Object.class ? sObject : new StringKD(cls);
        }

        public Object deserializeKey(String str, DeserializationContext deserializationContext) {
            return str;
        }
    }

    protected StdKeyDeserializer(int i, Class<?> cls) {
        this(i, cls, null);
    }

    protected StdKeyDeserializer(int i, Class<?> cls, FromStringDeserializer<?> fromStringDeserializer) {
        this._kind = i;
        this._keyClass = cls;
        this._deser = fromStringDeserializer;
    }

    public static StdKeyDeserializer forType(Class<?> cls) {
        if (cls == String.class || cls == Object.class) {
            return StringKD.forType(cls);
        }
        int i;
        if (cls == UUID.class) {
            i = 12;
        } else if (cls == Integer.class) {
            i = 5;
        } else if (cls == Long.class) {
            i = 6;
        } else if (cls == Date.class) {
            i = 10;
        } else if (cls == Calendar.class) {
            i = 11;
        } else if (cls == Boolean.class) {
            i = 1;
        } else if (cls == Byte.class) {
            i = 2;
        } else if (cls == Character.class) {
            i = 4;
        } else if (cls == Short.class) {
            i = 3;
        } else if (cls == Float.class) {
            i = 7;
        } else if (cls == Double.class) {
            i = 8;
        } else if (cls == URI.class) {
            i = 13;
        } else if (cls == URL.class) {
            i = 14;
        } else if (cls != Class.class) {
            return cls == Locale.class ? new StdKeyDeserializer(9, cls, FromStringDeserializer.findDeserializer(Locale.class)) : cls == Currency.class ? new StdKeyDeserializer(16, cls, FromStringDeserializer.findDeserializer(Currency.class)) : null;
        } else {
            i = 15;
        }
        return new StdKeyDeserializer(i, cls);
    }

    protected Object _parse(String str, DeserializationContext deserializationContext) {
        int _parseInt;
        switch (this._kind) {
            case 1:
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                throw deserializationContext.weirdKeyException(this._keyClass, str, "value not 'true' or 'false'");
            case 2:
                _parseInt = _parseInt(str);
                if (_parseInt >= -128 && _parseInt <= 255) {
                    return Byte.valueOf((byte) _parseInt);
                }
                throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 8-bit value");
            case 3:
                _parseInt = _parseInt(str);
                if (_parseInt >= -32768 && _parseInt <= 32767) {
                    return Short.valueOf((short) _parseInt);
                }
                throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 16-bit value");
            case 4:
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw deserializationContext.weirdKeyException(this._keyClass, str, "can only convert 1-character Strings");
            case 5:
                return Integer.valueOf(_parseInt(str));
            case 6:
                return Long.valueOf(_parseLong(str));
            case 7:
                return Float.valueOf((float) _parseDouble(str));
            case 8:
                return Double.valueOf(_parseDouble(str));
            case 9:
                try {
                    return this._deser._deserialize(str, deserializationContext);
                } catch (IOException e) {
                    throw deserializationContext.weirdKeyException(this._keyClass, str, "unable to parse key as locale");
                }
            case 10:
                return deserializationContext.parseDate(str);
            case 11:
                Date parseDate = deserializationContext.parseDate(str);
                return parseDate != null ? deserializationContext.constructCalendar(parseDate) : null;
            case 12:
                return UUID.fromString(str);
            case 13:
                return URI.create(str);
            case 14:
                return new URL(str);
            case 15:
                try {
                    return deserializationContext.findClass(str);
                } catch (Exception e2) {
                    throw deserializationContext.weirdKeyException(this._keyClass, str, "unable to parse key as Class");
                }
            case 16:
                try {
                    return this._deser._deserialize(str, deserializationContext);
                } catch (IOException e3) {
                    throw deserializationContext.weirdKeyException(this._keyClass, str, "unable to parse key as currency");
                }
            default:
                return null;
        }
    }

    protected double _parseDouble(String str) {
        return NumberInput.parseDouble(str);
    }

    protected int _parseInt(String str) {
        return Integer.parseInt(str);
    }

    protected long _parseLong(String str) {
        return Long.parseLong(str);
    }

    public Object deserializeKey(String str, DeserializationContext deserializationContext) {
        if (str == null) {
            return null;
        }
        try {
            Object _parse = _parse(str, deserializationContext);
            if (_parse != null) {
                return _parse;
            }
            if (this._keyClass.isEnum() && deserializationContext.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation");
        } catch (Exception e) {
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation: " + e.getMessage());
        }
    }
}
