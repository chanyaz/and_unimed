package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class RawValue implements JsonSerializable {
    protected Object _value;

    public RawValue(String str) {
        this._value = str;
    }

    protected void _serialize(JsonGenerator jsonGenerator) {
        if (this._value instanceof SerializableString) {
            jsonGenerator.writeRawValue((SerializableString) this._value);
        } else {
            jsonGenerator.writeRawValue(String.valueOf(this._value));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawValue)) {
            return false;
        }
        RawValue rawValue = (RawValue) obj;
        return this._value != rawValue._value ? this._value != null && this._value.equals(rawValue._value) : true;
    }

    public int hashCode() {
        return this._value == null ? 0 : this._value.hashCode();
    }

    public void serialize(JsonGenerator jsonGenerator) {
        if (this._value instanceof JsonSerializable) {
            jsonGenerator.writeObject(this._value);
        } else {
            _serialize(jsonGenerator);
        }
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._value instanceof JsonSerializable) {
            ((JsonSerializable) this._value).serialize(jsonGenerator, serializerProvider);
        } else {
            _serialize(jsonGenerator);
        }
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        if (this._value instanceof JsonSerializable) {
            ((JsonSerializable) this._value).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
        } else if (this._value instanceof SerializableString) {
            serialize(jsonGenerator, serializerProvider);
        }
    }

    public String toString() {
        String str = "[RawValue of type %s]";
        Object[] objArr = new Object[1];
        objArr[0] = this._value == null ? "NULL" : this._value.getClass().getName();
        return String.format(str, objArr);
    }
}
