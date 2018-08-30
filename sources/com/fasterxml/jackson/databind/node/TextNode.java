package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TextNode extends ValueNode {
    static final TextNode EMPTY_STRING_NODE = new TextNode("");
    protected final String _value;

    public TextNode(String str) {
        this._value = str;
    }

    protected static void appendQuoted(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        CharTypes.appendQuoted(stringBuilder, str);
        stringBuilder.append('\"');
    }

    public static TextNode valueOf(String str) {
        return str == null ? null : str.length() == 0 ? EMPTY_STRING_NODE : new TextNode(str);
    }

    protected void _reportBase64EOF() {
        throw new JsonParseException(null, "Unexpected end-of-String when base64 content");
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i) {
        _reportInvalidBase64(base64Variant, c, i, null);
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) {
        r0 = c <= ' ' ? "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units" : base64Variant.usesPaddingChar(c) ? "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(c) || Character.isISOControl(c)) ? "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content" : "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        if (str != null) {
            r0 = r0 + ": " + str;
        }
        throw new JsonParseException(null, r0, JsonLocation.NA);
    }

    public String asText() {
        return this._value;
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_STRING;
    }

    public byte[] binaryValue() {
        return getBinaryValue(Base64Variants.getDefaultVariant());
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || !(obj instanceof TextNode)) ? false : ((TextNode) obj)._value.equals(this._value);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            r6 = r12.decodeBase64Char(r0);
     */
    /* JADX WARNING: Missing block: B:9:0x0028, code:
            if (r6 >= 0) goto L_0x002d;
     */
    /* JADX WARNING: Missing block: B:10:0x002a, code:
            _reportInvalidBase64(r12, r0, 0);
     */
    /* JADX WARNING: Missing block: B:11:0x002d, code:
            if (r1 < r5) goto L_0x0032;
     */
    /* JADX WARNING: Missing block: B:12:0x002f, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code:
            r0 = r1 + 1;
            r1 = r4.charAt(r1);
            r7 = r12.decodeBase64Char(r1);
     */
    /* JADX WARNING: Missing block: B:14:0x003c, code:
            if (r7 >= 0) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:15:0x003e, code:
            _reportInvalidBase64(r12, r1, 1);
     */
    /* JADX WARNING: Missing block: B:16:0x0042, code:
            r1 = (r6 << 6) | r7;
     */
    /* JADX WARNING: Missing block: B:17:0x0045, code:
            if (r0 < r5) goto L_0x0056;
     */
    /* JADX WARNING: Missing block: B:19:0x004b, code:
            if (r12.usesPadding() != false) goto L_0x0053;
     */
    /* JADX WARNING: Missing block: B:20:0x004d, code:
            r3.append(r1 >> 4);
     */
    /* JADX WARNING: Missing block: B:21:0x0053, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:22:0x0056, code:
            r6 = r0 + 1;
            r0 = r4.charAt(r0);
            r7 = r12.decodeBase64Char(r0);
     */
    /* JADX WARNING: Missing block: B:23:0x0060, code:
            if (r7 >= 0) goto L_0x00a0;
     */
    /* JADX WARNING: Missing block: B:24:0x0062, code:
            if (r7 == -2) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:25:0x0064, code:
            _reportInvalidBase64(r12, r0, 2);
     */
    /* JADX WARNING: Missing block: B:26:0x0068, code:
            if (r6 < r5) goto L_0x006d;
     */
    /* JADX WARNING: Missing block: B:27:0x006a, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:28:0x006d, code:
            r0 = r6 + 1;
            r6 = r4.charAt(r6);
     */
    /* JADX WARNING: Missing block: B:29:0x0077, code:
            if (r12.usesPaddingChar(r6) != false) goto L_0x0099;
     */
    /* JADX WARNING: Missing block: B:30:0x0079, code:
            _reportInvalidBase64(r12, r6, 3, "expected padding character '" + r12.getPaddingChar() + "'");
     */
    /* JADX WARNING: Missing block: B:31:0x0099, code:
            r3.append(r1 >> 4);
     */
    /* JADX WARNING: Missing block: B:32:0x00a0, code:
            r1 = (r1 << 6) | r7;
     */
    /* JADX WARNING: Missing block: B:33:0x00a4, code:
            if (r6 < r5) goto L_0x00b6;
     */
    /* JADX WARNING: Missing block: B:35:0x00aa, code:
            if (r12.usesPadding() != false) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:36:0x00ac, code:
            r3.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARNING: Missing block: B:37:0x00b3, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:38:0x00b6, code:
            r0 = r6 + 1;
            r6 = r4.charAt(r6);
            r7 = r12.decodeBase64Char(r6);
     */
    /* JADX WARNING: Missing block: B:39:0x00c0, code:
            if (r7 >= 0) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:40:0x00c2, code:
            if (r7 == -2) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:41:0x00c4, code:
            _reportInvalidBase64(r12, r6, 3);
     */
    /* JADX WARNING: Missing block: B:42:0x00c7, code:
            r3.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARNING: Missing block: B:43:0x00ce, code:
            r3.appendThreeBytes((r1 << 6) | r7);
     */
    public byte[] getBinaryValue(com.fasterxml.jackson.core.Base64Variant r12) {
        /*
        r11 = this;
        r10 = 3;
        r2 = 0;
        r9 = -2;
        r3 = new com.fasterxml.jackson.core.util.ByteArrayBuilder;
        r0 = 100;
        r3.<init>(r0);
        r4 = r11._value;
        r5 = r4.length();
        r0 = r2;
    L_0x0011:
        if (r0 >= r5) goto L_0x001b;
    L_0x0013:
        r1 = r0 + 1;
        r0 = r4.charAt(r0);
        if (r1 < r5) goto L_0x0020;
    L_0x001b:
        r0 = r3.toByteArray();
        return r0;
    L_0x0020:
        r6 = 32;
        if (r0 <= r6) goto L_0x00d6;
    L_0x0024:
        r6 = r12.decodeBase64Char(r0);
        if (r6 >= 0) goto L_0x002d;
    L_0x002a:
        r11._reportInvalidBase64(r12, r0, r2);
    L_0x002d:
        if (r1 < r5) goto L_0x0032;
    L_0x002f:
        r11._reportBase64EOF();
    L_0x0032:
        r0 = r1 + 1;
        r1 = r4.charAt(r1);
        r7 = r12.decodeBase64Char(r1);
        if (r7 >= 0) goto L_0x0042;
    L_0x003e:
        r8 = 1;
        r11._reportInvalidBase64(r12, r1, r8);
    L_0x0042:
        r1 = r6 << 6;
        r1 = r1 | r7;
        if (r0 < r5) goto L_0x0056;
    L_0x0047:
        r6 = r12.usesPadding();
        if (r6 != 0) goto L_0x0053;
    L_0x004d:
        r0 = r1 >> 4;
        r3.append(r0);
        goto L_0x001b;
    L_0x0053:
        r11._reportBase64EOF();
    L_0x0056:
        r6 = r0 + 1;
        r0 = r4.charAt(r0);
        r7 = r12.decodeBase64Char(r0);
        if (r7 >= 0) goto L_0x00a0;
    L_0x0062:
        if (r7 == r9) goto L_0x0068;
    L_0x0064:
        r7 = 2;
        r11._reportInvalidBase64(r12, r0, r7);
    L_0x0068:
        if (r6 < r5) goto L_0x006d;
    L_0x006a:
        r11._reportBase64EOF();
    L_0x006d:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
        r7 = r12.usesPaddingChar(r6);
        if (r7 != 0) goto L_0x0099;
    L_0x0079:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "expected padding character '";
        r7 = r7.append(r8);
        r8 = r12.getPaddingChar();
        r7 = r7.append(r8);
        r8 = "'";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r11._reportInvalidBase64(r12, r6, r10, r7);
    L_0x0099:
        r1 = r1 >> 4;
        r3.append(r1);
        goto L_0x0011;
    L_0x00a0:
        r0 = r1 << 6;
        r1 = r0 | r7;
        if (r6 < r5) goto L_0x00b6;
    L_0x00a6:
        r0 = r12.usesPadding();
        if (r0 != 0) goto L_0x00b3;
    L_0x00ac:
        r0 = r1 >> 2;
        r3.appendTwoBytes(r0);
        goto L_0x001b;
    L_0x00b3:
        r11._reportBase64EOF();
    L_0x00b6:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
        r7 = r12.decodeBase64Char(r6);
        if (r7 >= 0) goto L_0x00ce;
    L_0x00c2:
        if (r7 == r9) goto L_0x00c7;
    L_0x00c4:
        r11._reportInvalidBase64(r12, r6, r10);
    L_0x00c7:
        r1 = r1 >> 2;
        r3.appendTwoBytes(r1);
        goto L_0x0011;
    L_0x00ce:
        r1 = r1 << 6;
        r1 = r1 | r7;
        r3.appendThreeBytes(r1);
        goto L_0x0011;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.node.TextNode.getBinaryValue(com.fasterxml.jackson.core.Base64Variant):byte[]");
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.STRING;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._value == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(this._value);
        }
    }

    public String textValue() {
        return this._value;
    }

    public String toString() {
        int length = this._value.length();
        StringBuilder stringBuilder = new StringBuilder((length >> 4) + (length + 2));
        appendQuoted(stringBuilder, this._value);
        return stringBuilder.toString();
    }
}
