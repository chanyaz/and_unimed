package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;

public final class JsonReadContext extends JsonStreamContext {
    protected JsonReadContext _child;
    protected int _columnNr;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected int _lineNr;
    protected final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i, int i2, int i3) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i;
        this._lineNr = i2;
        this._columnNr = i3;
        this._index = -1;
    }

    private void _checkDup(DupDetector dupDetector, String str) {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            throw new JsonParseException(source instanceof JsonGenerator ? (JsonParser) source : null, "Duplicate field '" + str + "'");
        }
    }

    public static JsonReadContext createRootContext(DupDetector dupDetector) {
        return new JsonReadContext(null, dupDetector, 0, 1, 0);
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public JsonReadContext createChildArrayContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, this._dups == null ? null : this._dups.child(), 1, i, i2);
            this._child = jsonReadContext;
        } else {
            jsonReadContext.reset(1, i, i2);
        }
        return jsonReadContext;
    }

    public JsonReadContext createChildObjectContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, this._dups == null ? null : this._dups.child(), 2, i, i2);
            this._child = jsonReadContext;
        } else {
            jsonReadContext.reset(2, i, i2);
        }
        return jsonReadContext;
    }

    public boolean expectComma() {
        int i = this._index + 1;
        this._index = i;
        return this._type != 0 && i > 0;
    }

    public String getCurrentName() {
        return this._currentName;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    public JsonReadContext getParent() {
        return this._parent;
    }

    public JsonLocation getStartLocation(Object obj) {
        return new JsonLocation(obj, -1, this._lineNr, this._columnNr);
    }

    protected void reset(int i, int i2, int i3) {
        this._type = i;
        this._index = -1;
        this._lineNr = i2;
        this._columnNr = i3;
        this._currentName = null;
        this._currentValue = null;
        if (this._dups != null) {
            this._dups.reset();
        }
    }

    public void setCurrentName(String str) {
        this._currentName = str;
        if (this._dups != null) {
            _checkDup(this._dups, str);
        }
    }

    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        switch (this._type) {
            case 0:
                stringBuilder.append("/");
                break;
            case 1:
                stringBuilder.append('[');
                stringBuilder.append(getCurrentIndex());
                stringBuilder.append(']');
                break;
            case 2:
                stringBuilder.append('{');
                if (this._currentName != null) {
                    stringBuilder.append('\"');
                    CharTypes.appendQuoted(stringBuilder, this._currentName);
                    stringBuilder.append('\"');
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append('}');
                break;
        }
        return stringBuilder.toString();
    }

    public JsonReadContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }
}
