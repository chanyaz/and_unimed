package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.RawValue;

public class POJONode extends ValueNode {
    protected final Object _value;

    public POJONode(Object obj) {
        this._value = obj;
    }

    protected boolean _pojoEquals(POJONode pOJONode) {
        return this._value == null ? pOJONode._value == null : this._value.equals(pOJONode._value);
    }

    public String asText() {
        return this._value == null ? "null" : this._value.toString();
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public byte[] binaryValue() {
        return this._value instanceof byte[] ? (byte[]) this._value : super.binaryValue();
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || !(obj instanceof POJONode)) ? false : _pojoEquals((POJONode) obj);
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.POJO;
    }

    public Object getPojo() {
        return this._value;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._value == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
        } else if (this._value instanceof JsonSerializable) {
            ((JsonSerializable) this._value).serialize(jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.writeObject(this._value);
        }
    }

    public String toString() {
        if (this._value instanceof byte[]) {
            return String.format("(binary value of %d bytes)", new Object[]{Integer.valueOf(((byte[]) this._value).length)});
        } else if (!(this._value instanceof RawValue)) {
            return String.valueOf(this._value);
        } else {
            return String.format("(raw value '%s')", new Object[]{((RawValue) this._value).toString()});
        }
    }
}
