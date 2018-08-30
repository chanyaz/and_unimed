package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;

public /* synthetic */ class c {
    @KeepForSdk
    public static Object a(ComponentContainer componentContainer, Class cls) {
        Provider provider = componentContainer.getProvider(cls);
        return provider == null ? null : provider.get();
    }
}
