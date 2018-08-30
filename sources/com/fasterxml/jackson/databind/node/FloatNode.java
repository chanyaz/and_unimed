package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FloatNode extends NumericNode {
    protected final float _value;

    public FloatNode(float f) {
        this._value = f;
    }

    public static FloatNode valueOf(float f) {
        return new FloatNode(f);
    }

    public String asText() {
        return Float.toString(this._value);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public BigInteger bigIntegerValue() {
        return decimalValue().toBigInteger();
    }

    public BigDecimal decimalValue() {
        return BigDecimal.valueOf((double) this._value);
    }

    public double doubleValue() {
        return (double) this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FloatNode)) {
            return false;
        }
        return Float.compare(this._value, ((FloatNode) obj)._value) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this._value);
    }

    public int intValue() {
        return (int) this._value;
    }

    public long longValue() {
        return (long) this._value;
    }

    public NumberType numberType() {
        return NumberType.FLOAT;
    }

    public Number numberValue() {
        return Float.valueOf(this._value);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeNumber(this._value);
    }
}
