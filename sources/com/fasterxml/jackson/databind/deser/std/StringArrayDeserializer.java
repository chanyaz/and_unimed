package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;

@JacksonStdImpl
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ContextualDeserializer {
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 2;
    protected JsonDeserializer<String> _elementDeserializer;
    protected final Boolean _unwrapSingle;

    public StringArrayDeserializer() {
        this(null, null);
    }

    protected StringArrayDeserializer(JsonDeserializer<?> jsonDeserializer, Boolean bool) {
        super(String[].class);
        this._elementDeserializer = jsonDeserializer;
        this._unwrapSingle = bool;
    }

    private final String[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String[] strArr = null;
        int i = (this._unwrapSingle == Boolean.TRUE || (this._unwrapSingle == null && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) ? 1 : 0;
        if (i != 0) {
            String[] strArr2 = new String[1];
            if (!jsonParser.hasToken(JsonToken.VALUE_NULL)) {
                strArr = _parseString(jsonParser, deserializationContext);
            }
            strArr2[0] = strArr;
            return strArr2;
        } else if (jsonParser.hasToken(JsonToken.VALUE_STRING) && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    protected final String[] _deserializeCustom(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] resetAndStart = leaseObjectBuffer.resetAndStart();
        JsonDeserializer jsonDeserializer = this._elementDeserializer;
        int i = 0;
        while (true) {
            try {
                String str;
                int i2;
                if (jsonParser.nextTextValue() == null) {
                    JsonToken currentToken = jsonParser.getCurrentToken();
                    if (currentToken == JsonToken.END_ARRAY) {
                        String[] strArr = (String[]) leaseObjectBuffer.completeAndClearBuffer(resetAndStart, i, String.class);
                        deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                        return strArr;
                    }
                    str = currentToken == JsonToken.VALUE_NULL ? (String) jsonDeserializer.getNullValue(deserializationContext) : (String) jsonDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    str = (String) jsonDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (i >= resetAndStart.length) {
                    resetAndStart = leaseObjectBuffer.appendCompletedChunk(resetAndStart);
                    i2 = 0;
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                resetAndStart[i2] = str;
            } catch (Throwable e) {
                throw JsonMappingException.wrapWithPath(e, (Object) String.class, i);
            }
        }
    }

    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._elementDeserializer);
        JavaType constructType = deserializationContext.constructType(String.class);
        findConvertingContentDeserializer = findConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(constructType, beanProperty) : deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, beanProperty, constructType);
        Boolean findFormatFeature = findFormatFeature(deserializationContext, beanProperty, String[].class, Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        if (findConvertingContentDeserializer != null && isDefaultDeserializer(findConvertingContentDeserializer)) {
            findConvertingContentDeserializer = null;
        }
        return (this._elementDeserializer == findConvertingContentDeserializer && this._unwrapSingle == findFormatFeature) ? this : new StringArrayDeserializer(findConvertingContentDeserializer, findFormatFeature);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A:{Catch:{ Exception -> 0x004e }} */
    public java.lang.String[] deserialize(com.fasterxml.jackson.core.JsonParser r8, com.fasterxml.jackson.databind.DeserializationContext r9) {
        /*
        r7 = this;
        r3 = 0;
        r0 = r8.isExpectedStartArrayToken();
        if (r0 != 0) goto L_0x000c;
    L_0x0007:
        r0 = r7.handleNonArray(r8, r9);
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r7._elementDeserializer;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r0 = r7._deserializeCustom(r8, r9);
        goto L_0x000b;
    L_0x0015:
        r5 = r9.leaseObjectBuffer();
        r2 = r5.resetAndStart();
        r1 = r3;
    L_0x001e:
        r0 = r8.nextTextValue();	 Catch:{ Exception -> 0x004e }
        if (r0 != 0) goto L_0x005b;
    L_0x0024:
        r4 = r8.getCurrentToken();	 Catch:{ Exception -> 0x004e }
        r6 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;	 Catch:{ Exception -> 0x004e }
        if (r4 != r6) goto L_0x0038;
    L_0x002c:
        r0 = java.lang.String.class;
        r0 = r5.completeAndClearBuffer(r2, r1, r0);
        r0 = (java.lang.String[]) r0;
        r9.returnObjectBuffer(r5);
        goto L_0x000b;
    L_0x0038:
        r6 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;	 Catch:{ Exception -> 0x004e }
        if (r4 == r6) goto L_0x005b;
    L_0x003c:
        r0 = r7._parseString(r8, r9);	 Catch:{ Exception -> 0x004e }
        r4 = r0;
    L_0x0041:
        r0 = r2.length;	 Catch:{ Exception -> 0x004e }
        if (r1 < r0) goto L_0x0059;
    L_0x0044:
        r2 = r5.appendCompletedChunk(r2);	 Catch:{ Exception -> 0x004e }
        r0 = r3;
    L_0x0049:
        r1 = r0 + 1;
        r2[r0] = r4;	 Catch:{ Exception -> 0x004e }
        goto L_0x001e;
    L_0x004e:
        r0 = move-exception;
        r3 = r5.bufferedSize();
        r1 = r1 + r3;
        r0 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r0, r2, r1);
        throw r0;
    L_0x0059:
        r0 = r1;
        goto L_0x0049;
    L_0x005b:
        r4 = r0;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer.deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.String[]");
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }
}
