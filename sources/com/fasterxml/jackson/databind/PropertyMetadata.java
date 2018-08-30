package com.fasterxml.jackson.databind;

import java.io.Serializable;

public class PropertyMetadata implements Serializable {
    public static final PropertyMetadata STD_OPTIONAL = new PropertyMetadata(Boolean.FALSE, null, null, null);
    public static final PropertyMetadata STD_REQUIRED = new PropertyMetadata(Boolean.TRUE, null, null, null);
    public static final PropertyMetadata STD_REQUIRED_OR_OPTIONAL = new PropertyMetadata(null, null, null, null);
    private static final long serialVersionUID = -1;
    protected final String _defaultValue;
    protected final String _description;
    protected final Integer _index;
    protected final Boolean _required;

    protected PropertyMetadata(Boolean bool, String str, Integer num, String str2) {
        this._required = bool;
        this._description = str;
        this._index = num;
        if (str2 == null || str2.isEmpty()) {
            str2 = null;
        }
        this._defaultValue = str2;
    }

    public static PropertyMetadata construct(boolean z, String str, Integer num, String str2) {
        return (str == null && num == null && str2 == null) ? z ? STD_REQUIRED : STD_OPTIONAL : new PropertyMetadata(Boolean.valueOf(z), str, num, str2);
    }

    public boolean isRequired() {
        return this._required != null && this._required.booleanValue();
    }

    protected Object readResolve() {
        return (this._description == null && this._index == null && this._defaultValue == null) ? this._required == null ? STD_REQUIRED_OR_OPTIONAL : this._required.booleanValue() ? STD_REQUIRED : STD_OPTIONAL : this;
    }

    public PropertyMetadata withDescription(String str) {
        return new PropertyMetadata(this._required, str, this._index, this._defaultValue);
    }
}
