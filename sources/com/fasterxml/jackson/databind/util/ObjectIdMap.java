package com.fasterxml.jackson.databind.util;

import java.util.IdentityHashMap;

public class ObjectIdMap extends IdentityHashMap<Object, Object> {
    public ObjectIdMap() {
        super(16);
    }
}
