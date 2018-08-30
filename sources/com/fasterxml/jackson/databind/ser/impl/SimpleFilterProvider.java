package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleFilterProvider extends FilterProvider implements Serializable {
    private static final long serialVersionUID = 1;
    protected boolean _cfgFailOnUnknownId;
    protected PropertyFilter _defaultFilter;
    protected final Map<String, PropertyFilter> _filtersById;

    public SimpleFilterProvider() {
        this(new HashMap());
    }

    public SimpleFilterProvider(Map<String, ?> map) {
        this._cfgFailOnUnknownId = true;
        for (Object obj : map.values()) {
            if (!(obj instanceof PropertyFilter)) {
                this._filtersById = _convert((Map) map);
                return;
            }
        }
        this._filtersById = map;
    }

    private static final PropertyFilter _convert(BeanPropertyFilter beanPropertyFilter) {
        return SimpleBeanPropertyFilter.from(beanPropertyFilter);
    }

    private static final Map<String, PropertyFilter> _convert(Map<String, ?> map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof PropertyFilter) {
                hashMap.put(entry.getKey(), (PropertyFilter) value);
            } else if (value instanceof BeanPropertyFilter) {
                hashMap.put(entry.getKey(), _convert((BeanPropertyFilter) value));
            } else {
                throw new IllegalArgumentException("Unrecognized filter type (" + value.getClass().getName() + ")");
            }
        }
        return hashMap;
    }

    @Deprecated
    public BeanPropertyFilter findFilter(Object obj) {
        throw new UnsupportedOperationException("Access to deprecated filters not supported");
    }

    public PropertyFilter findPropertyFilter(Object obj, Object obj2) {
        PropertyFilter propertyFilter = (PropertyFilter) this._filtersById.get(obj);
        if (propertyFilter == null) {
            propertyFilter = this._defaultFilter;
            if (propertyFilter == null && this._cfgFailOnUnknownId) {
                throw new IllegalArgumentException("No filter configured with id '" + obj + "' (type " + obj.getClass().getName() + ")");
            }
        }
        return propertyFilter;
    }
}
