package com.puzzlersworld.wp.dto;

import com.puzzlersworld.android.ui.activity.util.a;
import java.util.HashMap;
import java.util.Map;

public class StringPool {
    private Map<String, String> stringMap = new HashMap();

    public Map<String, String> getStringMap() {
        return this.stringMap;
    }

    public String getValue(StringConstants stringConstants) {
        return (this.stringMap == null || !this.stringMap.containsKey(stringConstants.name())) ? stringConstants.getValue() : (String) this.stringMap.get(stringConstants.name());
    }

    public void setStringMap(Map<String, String> map) {
        this.stringMap = map;
        a.a();
    }
}
