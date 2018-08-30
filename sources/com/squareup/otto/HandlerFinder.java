package com.squareup.otto;

import java.util.Map;
import java.util.Set;

interface HandlerFinder {
    public static final HandlerFinder a = new HandlerFinder() {
        public Map<Class<?>, d> findAllProducers(Object obj) {
            return a.a(obj);
        }

        public Map<Class<?>, Set<c>> findAllSubscribers(Object obj) {
            return a.b(obj);
        }
    };

    Map<Class<?>, d> findAllProducers(Object obj);

    Map<Class<?>, Set<c>> findAllSubscribers(Object obj);
}
