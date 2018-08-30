package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;

public abstract class ParserMinimalBase extends JsonParser {
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;

    protected ParserMinimalBase() {
    }

    protected ParserMinimalBase(int i) {
        super(i);
    }

    protected static final String _getCharDesc(int i) {
        char c = (char) i;
        return Character.isISOControl(c) ? "(CTRL-CHAR, code " + i + ")" : i > 255 ? "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")" : "'" + c + "' (code " + i + ")";
    }

    protected final JsonParseException _constructError(String str, Throwable th) {
        return new JsonParseException((JsonParser) this, str, th);
    }

    protected void _decodeBase64(String str, ByteArrayBuilder byteArrayBuilder, Base64Variant base64Variant) {
        try {
            base64Variant.decode(str, byteArrayBuilder);
        } catch (IllegalArgumentException e) {
            _reportError(e.getMessage());
        }
    }

    protected abstract void _handleEOF();

    protected char _handleUnrecognizedCharacterEscape(char c) {
        if (!(isEnabled(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && isEnabled(Feature.ALLOW_SINGLE_QUOTES)))) {
            _reportError("Unrecognized character escape " + _getCharDesc(c));
        }
        return c;
    }

    protected boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    protected final void _reportError(String str) {
        throw _constructError(str);
    }

    protected void _reportInvalidEOF() {
        _reportInvalidEOF(" in " + this._currToken);
    }

    protected void _reportInvalidEOF(String str) {
        _reportError("Unexpected end-of-input" + str);
    }

    protected void _reportInvalidEOFInValue() {
        _reportInvalidEOF(" in a value");
    }

    protected void _reportMissingRootWS(int i) {
        _reportUnexpectedChar(i, "Expected space separating root-level values");
    }

    protected void _reportUnexpectedChar(int i, String str) {
        if (i < 0) {
            _reportInvalidEOF();
        }
        String str2 = "Unexpected character (" + _getCharDesc(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        _reportError(str2);
    }

    protected final void _throwInternal() {
        VersionUtil.throwInternal();
    }

    protected void _throwInvalidSpace(int i) {
        _reportError("Illegal character (" + _getCharDesc((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected void _throwUnquotedSpace(int i, String str) {
        if (!isEnabled(Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            _reportError("Illegal unquoted character (" + _getCharDesc((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    protected final void _wrapError(String str, Throwable th) {
        throw _constructError(str, th);
    }

    public void clearCurrentToken() {
        if (this._currToken != null) {
            this._lastClearedToken = this._currToken;
            this._currToken = null;
        }
    }

    public abstract String getCurrentName();

    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    public int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? 0 : jsonToken.id();
    }

    public abstract String getText();

    public int getValueAsInt() {
        JsonToken jsonToken = this._currToken;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? getIntValue() : getValueAsInt(0);
    }

    public int getValueAsInt(int i) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        if (jsonToken == null) {
            return i;
        }
        switch (jsonToken.id()) {
            case 6:
                String text = getText();
                return _hasTextualNull(text) ? 0 : NumberInput.parseAsInt(text, i);
            case 9:
                return 1;
            case 10:
                return 0;
            case 11:
                return 0;
            case 12:
                Object embeddedObject = getEmbeddedObject();
                return embeddedObject instanceof Number ? ((Number) embeddedObject).intValue() : i;
            default:
                return i;
        }
    }

    public long getValueAsLong() {
        JsonToken jsonToken = this._currToken;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? getLongValue() : getValueAsLong(0);
    }

    public long getValueAsLong(long j) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getLongValue();
        }
        if (jsonToken == null) {
            return j;
        }
        switch (jsonToken.id()) {
            case 6:
                String text = getText();
                return _hasTextualNull(text) ? 0 : NumberInput.parseAsLong(text, j);
            case 9:
                return 1;
            case 10:
            case 11:
                return 0;
            case 12:
                Object embeddedObject = getEmbeddedObject();
                return embeddedObject instanceof Number ? ((Number) embeddedObject).longValue() : j;
            default:
                return j;
        }
    }

    public String getValueAsString() {
        return this._currToken == JsonToken.VALUE_STRING ? getText() : this._currToken == JsonToken.FIELD_NAME ? getCurrentName() : getValueAsString(null);
    }

    public String getValueAsString(String str) {
        return this._currToken == JsonToken.VALUE_STRING ? getText() : this._currToken == JsonToken.FIELD_NAME ? getCurrentName() : (this._currToken == null || this._currToken == JsonToken.VALUE_NULL || !this._currToken.isScalarValue()) ? str : getText();
    }

    public boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    public boolean hasTokenId(int i) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? i == 0 : jsonToken.id() == i;
    }

    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    public abstract JsonToken nextToken();

    public JsonToken nextValue() {
        JsonToken nextToken = nextToken();
        return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
    }

    public JsonParser skipChildren() {
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken nextToken = nextToken();
                if (nextToken == null) {
                    _handleEOF();
                    break;
                } else if (nextToken.isStructStart()) {
                    i++;
                } else if (nextToken.isStructEnd()) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this;
    }
}
