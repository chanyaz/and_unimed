package com.mopub.common.factories;

import com.mopub.common.util.Reflection.MethodBuilder;

public class MethodBuilderFactory {
    protected static MethodBuilderFactory a = new MethodBuilderFactory();

    public static MethodBuilder create(Object obj, String str) {
        return a.a(obj, str);
    }

    @Deprecated
    public static void setInstance(MethodBuilderFactory methodBuilderFactory) {
        a = methodBuilderFactory;
    }

    protected MethodBuilder a(Object obj, String str) {
        return new MethodBuilder(obj, str);
    }
}
