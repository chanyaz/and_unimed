package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.concurrent.atomic.AtomicReference;

@JacksonStdImpl
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
    private static final AtomicReference<ObjectMapper> _mapperReference = new AtomicReference();
    public static final SerializableSerializer instance = new SerializableSerializer();

    protected SerializableSerializer() {
        super(JsonSerializable.class);
    }

    private static final synchronized ObjectMapper _getObjectMapper() {
        ObjectMapper objectMapper;
        synchronized (SerializableSerializer.class) {
            objectMapper = (ObjectMapper) _mapperReference.get();
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
                _mapperReference.set(objectMapper);
            }
        }
        return objectMapper;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        jsonFormatVisitorWrapper.expectAnyFormat(javaType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049 A:{SYNTHETIC, Splitter: B:12:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058 A:{SYNTHETIC, Splitter: B:15:0x0058} */
    public com.fasterxml.jackson.databind.JsonNode getSchema(com.fasterxml.jackson.databind.SerializerProvider r8, java.lang.reflect.Type r9) {
        /*
        r7 = this;
        r2 = 0;
        r4 = r7.createObjectNode();
        r0 = "any";
        if (r9 == 0) goto L_0x007a;
    L_0x0009:
        r1 = com.fasterxml.jackson.databind.type.TypeFactory.rawClass(r9);
        r3 = com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema.class;
        r3 = r1.isAnnotationPresent(r3);
        if (r3 == 0) goto L_0x007a;
    L_0x0015:
        r0 = com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema.class;
        r0 = r1.getAnnotation(r0);
        r0 = (com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema) r0;
        r3 = r0.schemaType();
        r1 = "##irrelevant";
        r5 = r0.schemaObjectPropertiesDefinition();
        r1 = r1.equals(r5);
        if (r1 != 0) goto L_0x0078;
    L_0x002d:
        r1 = r0.schemaObjectPropertiesDefinition();
    L_0x0031:
        r5 = "##irrelevant";
        r6 = r0.schemaItemDefinition();
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x0076;
    L_0x003d:
        r2 = r0.schemaItemDefinition();
        r0 = r3;
    L_0x0042:
        r3 = "type";
        r4.put(r3, r0);
        if (r1 == 0) goto L_0x0056;
    L_0x0049:
        r0 = "properties";
        r3 = _getObjectMapper();	 Catch:{ IOException -> 0x0066 }
        r1 = r3.readTree(r1);	 Catch:{ IOException -> 0x0066 }
        r4.set(r0, r1);	 Catch:{ IOException -> 0x0066 }
    L_0x0056:
        if (r2 == 0) goto L_0x0065;
    L_0x0058:
        r0 = "items";
        r1 = _getObjectMapper();	 Catch:{ IOException -> 0x006e }
        r1 = r1.readTree(r2);	 Catch:{ IOException -> 0x006e }
        r4.set(r0, r1);	 Catch:{ IOException -> 0x006e }
    L_0x0065:
        return r4;
    L_0x0066:
        r0 = move-exception;
        r0 = "Failed to parse @JsonSerializableSchema.schemaObjectPropertiesDefinition value";
        r0 = com.fasterxml.jackson.databind.JsonMappingException.from(r8, r0);
        throw r0;
    L_0x006e:
        r0 = move-exception;
        r0 = "Failed to parse @JsonSerializableSchema.schemaItemDefinition value";
        r0 = com.fasterxml.jackson.databind.JsonMappingException.from(r8, r0);
        throw r0;
    L_0x0076:
        r0 = r3;
        goto L_0x0042;
    L_0x0078:
        r1 = r2;
        goto L_0x0031;
    L_0x007a:
        r1 = r2;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.SerializableSerializer.getSchema(com.fasterxml.jackson.databind.SerializerProvider, java.lang.reflect.Type):com.fasterxml.jackson.databind.JsonNode");
    }

    public boolean isEmpty(SerializerProvider serializerProvider, JsonSerializable jsonSerializable) {
        return jsonSerializable instanceof Base ? ((Base) jsonSerializable).isEmpty(serializerProvider) : false;
    }

    public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonSerializable.serialize(jsonGenerator, serializerProvider);
    }

    public final void serializeWithType(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        jsonSerializable.serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
    }
}
