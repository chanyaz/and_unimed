package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringParserDelegate extends JsonParserDelegate {
    protected boolean _allowMultipleMatches;
    protected JsonToken _currToken;
    protected TokenFilterContext _exposedContext;
    protected TokenFilterContext _headContext;
    @Deprecated
    protected boolean _includeImmediateParent;
    protected boolean _includePath;
    protected TokenFilter _itemFilter;
    protected JsonToken _lastClearedToken;
    protected TokenFilter rootFilter;

    public FilteringParserDelegate(JsonParser jsonParser, TokenFilter tokenFilter, boolean z, boolean z2) {
        super(jsonParser);
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._headContext = TokenFilterContext.createRootContext(tokenFilter);
        this._includePath = z;
        this._allowMultipleMatches = z2;
    }

    private JsonToken _nextBuffered(TokenFilterContext tokenFilterContext) {
        this._exposedContext = tokenFilterContext;
        JsonToken nextTokenToRead = tokenFilterContext.nextTokenToRead();
        if (nextTokenToRead != null) {
            return nextTokenToRead;
        }
        while (tokenFilterContext != this._headContext) {
            tokenFilterContext = this._exposedContext.findChildOf(tokenFilterContext);
            this._exposedContext = tokenFilterContext;
            if (tokenFilterContext == null) {
                throw _constructError("Unexpected problem: chain of filtered context broken");
            }
            nextTokenToRead = this._exposedContext.nextTokenToRead();
            if (nextTokenToRead != null) {
            }
        }
        throw _constructError("Internal error: failed to locate expected buffered tokens");
        return nextTokenToRead;
    }

    protected JsonStreamContext _filterContext() {
        return this._exposedContext != null ? this._exposedContext : this._headContext;
    }

    protected final JsonToken _nextToken2() {
        JsonToken nextToken;
        while (true) {
            nextToken = this.delegate.nextToken();
            if (nextToken == null) {
                this._currToken = nextToken;
                return nextToken;
            }
            TokenFilter tokenFilter;
            JsonToken _nextTokenWithBuffering;
            TokenFilter filter;
            switch (nextToken.id()) {
                case 1:
                    tokenFilter = this._itemFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        tokenFilter = this._headContext.checkValue(tokenFilter);
                        if (tokenFilter == null) {
                            this.delegate.skipChildren();
                            break;
                        }
                        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
                            tokenFilter = tokenFilter.filterStartObject();
                        }
                        this._itemFilter = tokenFilter;
                        if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                            this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        this._headContext = this._headContext.createChildObjectContext(tokenFilter, false);
                        if (this._includePath) {
                            _nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering == null) {
                                break;
                            }
                            this._currToken = _nextTokenWithBuffering;
                            return _nextTokenWithBuffering;
                        }
                        continue;
                    }
                case 2:
                case 4:
                    boolean isStartHandled = this._headContext.isStartHandled();
                    filter = this._headContext.getFilter();
                    if (!(filter == null || filter == TokenFilter.INCLUDE_ALL)) {
                        filter.filterFinishArray();
                    }
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (!isStartHandled) {
                        break;
                    }
                    this._currToken = nextToken;
                    return nextToken;
                case 3:
                    tokenFilter = this._itemFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(tokenFilter, true);
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        tokenFilter = this._headContext.checkValue(tokenFilter);
                        if (tokenFilter == null) {
                            this.delegate.skipChildren();
                            break;
                        }
                        if (tokenFilter != TokenFilter.INCLUDE_ALL) {
                            tokenFilter = tokenFilter.filterStartArray();
                        }
                        this._itemFilter = tokenFilter;
                        if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                            this._headContext = this._headContext.createChildArrayContext(tokenFilter, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        this._headContext = this._headContext.createChildArrayContext(tokenFilter, false);
                        if (this._includePath) {
                            _nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering == null) {
                                break;
                            }
                            this._currToken = _nextTokenWithBuffering;
                            return _nextTokenWithBuffering;
                        }
                        continue;
                    }
                case 5:
                    String currentName = this.delegate.getCurrentName();
                    filter = this._headContext.setFieldName(currentName);
                    if (filter == TokenFilter.INCLUDE_ALL) {
                        this._itemFilter = filter;
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (filter == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        break;
                    } else {
                        tokenFilter = filter.includeProperty(currentName);
                        if (tokenFilter == null) {
                            this.delegate.nextToken();
                            this.delegate.skipChildren();
                            break;
                        }
                        this._itemFilter = tokenFilter;
                        if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                            if (!this._includePath) {
                                break;
                            }
                            this._currToken = nextToken;
                            return nextToken;
                        } else if (this._includePath) {
                            _nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering == null) {
                                break;
                            }
                            this._currToken = _nextTokenWithBuffering;
                            return _nextTokenWithBuffering;
                        } else {
                            continue;
                        }
                    }
                default:
                    tokenFilter = this._itemFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter != null) {
                        tokenFilter = this._headContext.checkValue(tokenFilter);
                        if (tokenFilter == TokenFilter.INCLUDE_ALL || (tokenFilter != null && tokenFilter.includeValue(this.delegate))) {
                            this._currToken = nextToken;
                            break;
                        }
                    } else {
                        continue;
                    }
            }
        }
        this._currToken = nextToken;
        return nextToken;
    }

    /* JADX WARNING: Missing block: B:107:?, code:
            return _nextBuffered(r7);
     */
    protected final com.fasterxml.jackson.core.JsonToken _nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
    L_0x0002:
        r0 = r6.delegate;
        r3 = r0.nextToken();
        if (r3 != 0) goto L_0x000c;
    L_0x000a:
        r0 = r3;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r3.id();
        switch(r0) {
            case 1: goto L_0x0052;
            case 2: goto L_0x009e;
            case 3: goto L_0x001e;
            case 4: goto L_0x009e;
            case 5: goto L_0x00df;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r6._itemFilter;
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 != r3) goto L_0x0123;
    L_0x0019:
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
    L_0x001e:
        r0 = r6._headContext;
        r3 = r6._itemFilter;
        r0 = r0.checkValue(r3);
        if (r0 != 0) goto L_0x002e;
    L_0x0028:
        r0 = r6.delegate;
        r0.skipChildren();
        goto L_0x0002;
    L_0x002e:
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 == r3) goto L_0x0036;
    L_0x0032:
        r0 = r0.filterStartArray();
    L_0x0036:
        r6._itemFilter = r0;
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 != r3) goto L_0x0049;
    L_0x003c:
        r2 = r6._headContext;
        r0 = r2.createChildArrayContext(r0, r1);
        r6._headContext = r0;
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
    L_0x0049:
        r3 = r6._headContext;
        r0 = r3.createChildArrayContext(r0, r2);
        r6._headContext = r0;
        goto L_0x0002;
    L_0x0052:
        r0 = r6._itemFilter;
        r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 != r4) goto L_0x0062;
    L_0x0058:
        r2 = r6._headContext;
        r0 = r2.createChildObjectContext(r0, r1);
        r6._headContext = r0;
        r0 = r3;
        goto L_0x000b;
    L_0x0062:
        if (r0 != 0) goto L_0x006a;
    L_0x0064:
        r0 = r6.delegate;
        r0.skipChildren();
        goto L_0x0002;
    L_0x006a:
        r3 = r6._headContext;
        r0 = r3.checkValue(r0);
        if (r0 != 0) goto L_0x0078;
    L_0x0072:
        r0 = r6.delegate;
        r0.skipChildren();
        goto L_0x0002;
    L_0x0078:
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 == r3) goto L_0x0080;
    L_0x007c:
        r0 = r0.filterStartObject();
    L_0x0080:
        r6._itemFilter = r0;
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 != r3) goto L_0x0094;
    L_0x0086:
        r2 = r6._headContext;
        r0 = r2.createChildObjectContext(r0, r1);
        r6._headContext = r0;
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
    L_0x0094:
        r3 = r6._headContext;
        r0 = r3.createChildObjectContext(r0, r2);
        r6._headContext = r0;
        goto L_0x0002;
    L_0x009e:
        r0 = r6._headContext;
        r0 = r0.getFilter();
        if (r0 == 0) goto L_0x00ad;
    L_0x00a6:
        r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 == r4) goto L_0x00ad;
    L_0x00aa:
        r0.filterFinishArray();
    L_0x00ad:
        r0 = r6._headContext;
        if (r0 != r7) goto L_0x00d2;
    L_0x00b1:
        r4 = r1;
    L_0x00b2:
        if (r4 == 0) goto L_0x00d4;
    L_0x00b4:
        r0 = r6._headContext;
        r0 = r0.isStartHandled();
        if (r0 == 0) goto L_0x00d4;
    L_0x00bc:
        r0 = r1;
    L_0x00bd:
        r5 = r6._headContext;
        r5 = r5.getParent();
        r6._headContext = r5;
        r5 = r6._headContext;
        r5 = r5.getFilter();
        r6._itemFilter = r5;
        if (r0 == 0) goto L_0x00d6;
    L_0x00cf:
        r0 = r3;
        goto L_0x000b;
    L_0x00d2:
        r4 = r2;
        goto L_0x00b2;
    L_0x00d4:
        r0 = r2;
        goto L_0x00bd;
    L_0x00d6:
        if (r4 != 0) goto L_0x00dc;
    L_0x00d8:
        r0 = r6._headContext;
        if (r0 != r7) goto L_0x0002;
    L_0x00dc:
        r0 = 0;
        goto L_0x000b;
    L_0x00df:
        r0 = r6.delegate;
        r0 = r0.getCurrentName();
        r3 = r6._headContext;
        r3 = r3.setFieldName(r0);
        r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r3 != r4) goto L_0x00f7;
    L_0x00ef:
        r6._itemFilter = r3;
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
    L_0x00f7:
        if (r3 != 0) goto L_0x0105;
    L_0x00f9:
        r0 = r6.delegate;
        r0.nextToken();
        r0 = r6.delegate;
        r0.skipChildren();
        goto L_0x0002;
    L_0x0105:
        r0 = r3.includeProperty(r0);
        if (r0 != 0) goto L_0x0117;
    L_0x010b:
        r0 = r6.delegate;
        r0.nextToken();
        r0 = r6.delegate;
        r0.skipChildren();
        goto L_0x0002;
    L_0x0117:
        r6._itemFilter = r0;
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 != r3) goto L_0x0002;
    L_0x011d:
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
    L_0x0123:
        if (r0 == 0) goto L_0x0002;
    L_0x0125:
        r3 = r6._headContext;
        r0 = r3.checkValue(r0);
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
        if (r0 == r3) goto L_0x0139;
    L_0x012f:
        if (r0 == 0) goto L_0x0002;
    L_0x0131:
        r3 = r6.delegate;
        r0 = r0.includeValue(r3);
        if (r0 == 0) goto L_0x0002;
    L_0x0139:
        r0 = r6._nextBuffered(r7);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.filter.FilteringParserDelegate._nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext):com.fasterxml.jackson.core.JsonToken");
    }

    public void clearCurrentToken() {
        if (this._currToken != null) {
            this._lastClearedToken = this._currToken;
            this._currToken = null;
        }
    }

    public BigInteger getBigIntegerValue() {
        return this.delegate.getBigIntegerValue();
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) {
        return this.delegate.getBinaryValue(base64Variant);
    }

    public byte getByteValue() {
        return this.delegate.getByteValue();
    }

    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    public String getCurrentName() {
        JsonStreamContext _filterContext = _filterContext();
        if (this._currToken != JsonToken.START_OBJECT && this._currToken != JsonToken.START_ARRAY) {
            return _filterContext.getCurrentName();
        }
        _filterContext = _filterContext.getParent();
        return _filterContext == null ? null : _filterContext.getCurrentName();
    }

    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    public final int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? 0 : jsonToken.id();
    }

    public BigDecimal getDecimalValue() {
        return this.delegate.getDecimalValue();
    }

    public double getDoubleValue() {
        return this.delegate.getDoubleValue();
    }

    public Object getEmbeddedObject() {
        return this.delegate.getEmbeddedObject();
    }

    public float getFloatValue() {
        return this.delegate.getFloatValue();
    }

    public int getIntValue() {
        return this.delegate.getIntValue();
    }

    public long getLongValue() {
        return this.delegate.getLongValue();
    }

    public NumberType getNumberType() {
        return this.delegate.getNumberType();
    }

    public Number getNumberValue() {
        return this.delegate.getNumberValue();
    }

    public JsonStreamContext getParsingContext() {
        return _filterContext();
    }

    public short getShortValue() {
        return this.delegate.getShortValue();
    }

    public String getText() {
        return this.delegate.getText();
    }

    public char[] getTextCharacters() {
        return this.delegate.getTextCharacters();
    }

    public int getTextLength() {
        return this.delegate.getTextLength();
    }

    public int getTextOffset() {
        return this.delegate.getTextOffset();
    }

    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    public int getValueAsInt() {
        return this.delegate.getValueAsInt();
    }

    public int getValueAsInt(int i) {
        return this.delegate.getValueAsInt(i);
    }

    public long getValueAsLong() {
        return this.delegate.getValueAsLong();
    }

    public long getValueAsLong(long j) {
        return this.delegate.getValueAsLong(j);
    }

    public String getValueAsString() {
        return this.delegate.getValueAsString();
    }

    public String getValueAsString(String str) {
        return this.delegate.getValueAsString(str);
    }

    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    public final boolean hasToken(JsonToken jsonToken) {
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

    public JsonToken nextToken() {
        JsonToken nextTokenToRead;
        TokenFilterContext tokenFilterContext = this._exposedContext;
        if (tokenFilterContext != null) {
            do {
                nextTokenToRead = tokenFilterContext.nextTokenToRead();
                if (nextTokenToRead != null) {
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                } else if (tokenFilterContext == this._headContext) {
                    this._exposedContext = null;
                    if (tokenFilterContext.inArray()) {
                        nextTokenToRead = this.delegate.getCurrentToken();
                        this._currToken = nextTokenToRead;
                        return nextTokenToRead;
                    }
                } else {
                    tokenFilterContext = this._headContext.findChildOf(tokenFilterContext);
                    this._exposedContext = tokenFilterContext;
                }
            } while (tokenFilterContext != null);
            throw _constructError("Unexpected problem: chain of filtered context broken");
        }
        nextTokenToRead = this.delegate.nextToken();
        if (nextTokenToRead == null) {
            this._currToken = nextTokenToRead;
            return nextTokenToRead;
        }
        TokenFilter tokenFilter;
        TokenFilter filter;
        switch (nextTokenToRead.id()) {
            case 1:
                tokenFilter = this._itemFilter;
                if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                } else if (tokenFilter == null) {
                    this.delegate.skipChildren();
                    break;
                } else {
                    tokenFilter = this._headContext.checkValue(tokenFilter);
                    if (tokenFilter == null) {
                        this.delegate.skipChildren();
                        break;
                    }
                    if (tokenFilter != TokenFilter.INCLUDE_ALL) {
                        tokenFilter = tokenFilter.filterStartObject();
                    }
                    this._itemFilter = tokenFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                        this._currToken = nextTokenToRead;
                        return nextTokenToRead;
                    }
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter, false);
                    if (this._includePath) {
                        nextTokenToRead = _nextTokenWithBuffering(this._headContext);
                        if (nextTokenToRead != null) {
                            this._currToken = nextTokenToRead;
                            return nextTokenToRead;
                        }
                    }
                }
                break;
            case 2:
            case 4:
                boolean isStartHandled = this._headContext.isStartHandled();
                filter = this._headContext.getFilter();
                if (!(filter == null || filter == TokenFilter.INCLUDE_ALL)) {
                    filter.filterFinishArray();
                }
                this._headContext = this._headContext.getParent();
                this._itemFilter = this._headContext.getFilter();
                if (isStartHandled) {
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                }
                break;
            case 3:
                tokenFilter = this._itemFilter;
                if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildArrayContext(tokenFilter, true);
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                } else if (tokenFilter == null) {
                    this.delegate.skipChildren();
                    break;
                } else {
                    tokenFilter = this._headContext.checkValue(tokenFilter);
                    if (tokenFilter == null) {
                        this.delegate.skipChildren();
                        break;
                    }
                    if (tokenFilter != TokenFilter.INCLUDE_ALL) {
                        tokenFilter = tokenFilter.filterStartArray();
                    }
                    this._itemFilter = tokenFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(tokenFilter, true);
                        this._currToken = nextTokenToRead;
                        return nextTokenToRead;
                    }
                    this._headContext = this._headContext.createChildArrayContext(tokenFilter, false);
                    if (this._includePath) {
                        nextTokenToRead = _nextTokenWithBuffering(this._headContext);
                        if (nextTokenToRead != null) {
                            this._currToken = nextTokenToRead;
                            return nextTokenToRead;
                        }
                    }
                }
                break;
            case 5:
                String currentName = this.delegate.getCurrentName();
                filter = this._headContext.setFieldName(currentName);
                if (filter == TokenFilter.INCLUDE_ALL) {
                    JsonToken jsonToken;
                    this._itemFilter = filter;
                    if (this._includePath || !this._includeImmediateParent || this._headContext.isStartHandled()) {
                        jsonToken = nextTokenToRead;
                    } else {
                        jsonToken = this._headContext.nextTokenToRead();
                        this._exposedContext = this._headContext;
                    }
                    this._currToken = jsonToken;
                    return jsonToken;
                } else if (filter == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                    break;
                } else {
                    tokenFilter = filter.includeProperty(currentName);
                    if (tokenFilter == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        break;
                    }
                    this._itemFilter = tokenFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL && this._includePath) {
                        this._currToken = nextTokenToRead;
                        return nextTokenToRead;
                    } else if (this._includePath) {
                        nextTokenToRead = _nextTokenWithBuffering(this._headContext);
                        if (nextTokenToRead != null) {
                            this._currToken = nextTokenToRead;
                            return nextTokenToRead;
                        }
                    }
                }
                break;
            default:
                tokenFilter = this._itemFilter;
                if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                } else if (tokenFilter != null) {
                    tokenFilter = this._headContext.checkValue(tokenFilter);
                    if (tokenFilter == TokenFilter.INCLUDE_ALL || (tokenFilter != null && tokenFilter.includeValue(this.delegate))) {
                        this._currToken = nextTokenToRead;
                        return nextTokenToRead;
                    }
                }
                break;
        }
        return _nextToken2();
    }

    public JsonToken nextValue() {
        JsonToken nextToken = nextToken();
        return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
    }

    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    public JsonParser skipChildren() {
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken nextToken = nextToken();
                if (nextToken == null) {
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
