package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.NumberInput;

public class JsonPointer {
    protected static final JsonPointer EMPTY = new JsonPointer();
    protected final String _asString;
    protected final int _matchingElementIndex;
    protected final String _matchingPropertyName;
    protected final JsonPointer _nextSegment;

    protected JsonPointer() {
        this._nextSegment = null;
        this._matchingPropertyName = "";
        this._matchingElementIndex = -1;
        this._asString = "";
    }

    protected JsonPointer(String str, String str2, JsonPointer jsonPointer) {
        this._asString = str;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = _parseIndex(str2);
    }

    private static void _appendEscape(StringBuilder stringBuilder, char c) {
        if (c == '0') {
            c = '~';
        } else if (c == '1') {
            c = '/';
        } else {
            stringBuilder.append('~');
        }
        stringBuilder.append(c);
    }

    private static final int _parseIndex(String str) {
        int i = 0;
        int length = str.length();
        if (length == 0 || length > 10) {
            return -1;
        }
        char charAt = str.charAt(0);
        if (charAt <= '0') {
            if (!(length == 1 && charAt == '0')) {
                i = -1;
            }
            return i;
        } else if (charAt > '9') {
            return -1;
        } else {
            for (i = 1; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (charAt2 > '9' || charAt2 < '0') {
                    return -1;
                }
            }
            return (length != 10 || NumberInput.parseLong(str) <= 2147483647L) ? NumberInput.parseInt(str) : -1;
        }
    }

    protected static JsonPointer _parseQuotedTail(String str, int i) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(Math.max(16, length));
        if (i > 2) {
            stringBuilder.append(str, 1, i - 1);
        }
        int i2 = i + 1;
        _appendEscape(stringBuilder, str.charAt(i));
        int i3 = i2;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt == '/') {
                return new JsonPointer(str, stringBuilder.toString(), _parseTail(str.substring(i3)));
            }
            i3++;
            if (charAt != '~' || i3 >= length) {
                stringBuilder.append(charAt);
            } else {
                i2 = i3 + 1;
                _appendEscape(stringBuilder, str.charAt(i3));
                i3 = i2;
            }
        }
        return new JsonPointer(str, stringBuilder.toString(), EMPTY);
    }

    protected static JsonPointer _parseTail(String str) {
        int length = str.length();
        int i = 1;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/') {
                return new JsonPointer(str, str.substring(1, i), _parseTail(str.substring(i)));
            }
            int i2 = i + 1;
            if (charAt == '~' && i2 < length) {
                return _parseQuotedTail(str, i2);
            }
            i = i2;
        }
        return new JsonPointer(str, str.substring(1), EMPTY);
    }

    public static JsonPointer compile(String str) {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        if (str.charAt(0) == '/') {
            return _parseTail(str);
        }
        throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || !(obj instanceof JsonPointer)) ? false : this._asString.equals(((JsonPointer) obj)._asString);
    }

    public int getMatchingIndex() {
        return this._matchingElementIndex;
    }

    public String getMatchingProperty() {
        return this._matchingPropertyName;
    }

    public int hashCode() {
        return this._asString.hashCode();
    }

    public boolean matches() {
        return this._nextSegment == null;
    }

    public JsonPointer tail() {
        return this._nextSegment;
    }

    public String toString() {
        return this._asString;
    }
}
