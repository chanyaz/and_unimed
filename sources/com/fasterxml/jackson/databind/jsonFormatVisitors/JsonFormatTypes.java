package com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.HashMap;
import java.util.Map;

public enum JsonFormatTypes {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL,
    ANY;
    
    private static final Map<String, JsonFormatTypes> _byLCName = null;

    static {
        _byLCName = new HashMap();
        JsonFormatTypes[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            JsonFormatTypes jsonFormatTypes = values[i];
            _byLCName.put(jsonFormatTypes.name().toLowerCase(), jsonFormatTypes);
            i++;
        }
    }
}
