package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

public class CustomEventInterstitialFactory {
    private static CustomEventInterstitialFactory a = new CustomEventInterstitialFactory();

    public static CustomEventInterstitial create(String str) {
        return a.a(str);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialFactory customEventInterstitialFactory) {
        a = customEventInterstitialFactory;
    }

    protected CustomEventInterstitial a(String str) {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        return (CustomEventInterstitial) declaredConstructor.newInstance(new Object[0]);
    }
}
