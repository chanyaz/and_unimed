package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;
import java.util.Map;

public class NumberSerializers {

    public abstract class Base<T> extends StdScalarSerializer<T> implements ContextualSerializer {
        protected final boolean _isInt;
        protected final NumberType _numberType;
        protected final String _schemaType;

        protected Base(Class<?> cls, NumberType numberType, String str) {
            boolean z = false;
            super(cls, false);
            this._numberType = numberType;
            this._schemaType = str;
            if (numberType == NumberType.INT || numberType == NumberType.LONG || numberType == NumberType.BIG_INTEGER) {
                z = true;
            }
            this._isInt = z;
        }

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
            if (this._isInt) {
                visitIntFormat(jsonFormatVisitorWrapper, javaType, this._numberType);
            } else {
                visitFloatFormat(jsonFormatVisitorWrapper, javaType, this._numberType);
            }
        }

        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
            if (beanProperty == null) {
                return this;
            }
            Annotated member = beanProperty.getMember();
            if (member == null) {
                return this;
            }
            Value findFormat = serializerProvider.getAnnotationIntrospector().findFormat(member);
            if (findFormat == null) {
                return this;
            }
            switch (findFormat.getShape()) {
                case STRING:
                    return ToStringSerializer.instance;
                default:
                    return this;
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(this._schemaType, true);
        }
    }

    @JacksonStdImpl
    public final class DoubleSerializer extends Base<Object> {
        static final DoubleSerializer instance = new DoubleSerializer();

        public DoubleSerializer() {
            super(Double.class, NumberType.DOUBLE, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Double) obj).doubleValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            serialize(obj, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    public final class FloatSerializer extends Base<Object> {
        static final FloatSerializer instance = new FloatSerializer();

        public FloatSerializer() {
            super(Float.class, NumberType.FLOAT, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Float) obj).floatValue());
        }
    }

    @JacksonStdImpl
    public final class IntLikeSerializer extends Base<Object> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public IntLikeSerializer() {
            super(Number.class, NumberType.INT, "integer");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Number) obj).intValue());
        }
    }

    @JacksonStdImpl
    public final class IntegerSerializer extends Base<Object> {
        public IntegerSerializer() {
            super(Integer.class, NumberType.INT, "integer");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Integer) obj).intValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            serialize(obj, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    public final class LongSerializer extends Base<Object> {
        static final LongSerializer instance = new LongSerializer();

        public LongSerializer() {
            super(Long.class, NumberType.LONG, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Long) obj).longValue());
        }
    }

    @JacksonStdImpl
    public final class ShortSerializer extends Base<Object> {
        static final ShortSerializer instance = new ShortSerializer();

        public ShortSerializer() {
            super(Short.class, NumberType.INT, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(((Short) obj).shortValue());
        }
    }

    protected NumberSerializers() {
    }

    public static void addAll(Map<String, JsonSerializer<?>> map) {
        IntegerSerializer integerSerializer = new IntegerSerializer();
        map.put(Integer.class.getName(), integerSerializer);
        map.put(Integer.TYPE.getName(), integerSerializer);
        map.put(Long.class.getName(), LongSerializer.instance);
        map.put(Long.TYPE.getName(), LongSerializer.instance);
        map.put(Byte.class.getName(), IntLikeSerializer.instance);
        map.put(Byte.TYPE.getName(), IntLikeSerializer.instance);
        map.put(Short.class.getName(), ShortSerializer.instance);
        map.put(Short.TYPE.getName(), ShortSerializer.instance);
        map.put(Float.class.getName(), FloatSerializer.instance);
        map.put(Float.TYPE.getName(), FloatSerializer.instance);
        map.put(Double.class.getName(), DoubleSerializer.instance);
        map.put(Double.TYPE.getName(), DoubleSerializer.instance);
    }
}
