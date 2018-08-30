package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    protected final JsonSerializer<String> _serializer;
    protected final Boolean _unwrapSingle;

    protected StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((StdSerializer) staticListSerializerBase);
        this._serializer = jsonSerializer;
        this._unwrapSingle = bool;
    }

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._serializer = null;
        this._unwrapSingle = null;
    }

    public abstract JsonSerializer<?> _withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, Boolean bool);

    protected abstract void acceptContentVisitor(JsonArrayFormatVisitor jsonArrayFormatVisitor);

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        acceptContentVisitor(jsonFormatVisitorWrapper.expectArrayFormat(javaType));
    }

    protected abstract JsonNode contentSchema();

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r5, com.fasterxml.jackson.databind.BeanProperty r6) {
        /*
        r4 = this;
        r1 = 0;
        if (r6 == 0) goto L_0x0058;
    L_0x0003:
        r0 = r5.getAnnotationIntrospector();
        r2 = r6.getMember();
        if (r2 == 0) goto L_0x0056;
    L_0x000d:
        r0 = r0.findContentSerializer(r2);
        if (r0 == 0) goto L_0x0056;
    L_0x0013:
        r0 = r5.serializerInstance(r2, r0);
    L_0x0017:
        r2 = r5.getConfig();
        r3 = r4._handledType;
        r2 = r6.findPropertyFormat(r2, r3);
        if (r2 == 0) goto L_0x0054;
    L_0x0023:
        r3 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        r2 = r2.getFeature(r3);
    L_0x0029:
        if (r0 != 0) goto L_0x002d;
    L_0x002b:
        r0 = r4._serializer;
    L_0x002d:
        r0 = r4.findConvertingContentSerializer(r5, r6, r0);
        if (r0 != 0) goto L_0x0048;
    L_0x0033:
        r0 = java.lang.String.class;
        r0 = r5.findValueSerializer(r0, r6);
    L_0x0039:
        r3 = r4.isDefaultSerializer(r0);
        if (r3 == 0) goto L_0x0052;
    L_0x003f:
        r0 = r4._serializer;
        if (r1 != r0) goto L_0x004d;
    L_0x0043:
        r0 = r4._unwrapSingle;
        if (r2 != r0) goto L_0x004d;
    L_0x0047:
        return r4;
    L_0x0048:
        r0 = r5.handleSecondaryContextualization(r0, r6);
        goto L_0x0039;
    L_0x004d:
        r4 = r4._withResolved(r6, r1, r2);
        goto L_0x0047;
    L_0x0052:
        r1 = r0;
        goto L_0x003f;
    L_0x0054:
        r2 = r1;
        goto L_0x0029;
    L_0x0056:
        r0 = r1;
        goto L_0x0017;
    L_0x0058:
        r2 = r1;
        r0 = r1;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("array", true).set("items", contentSchema());
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        return t == null || t.size() == 0;
    }
}
