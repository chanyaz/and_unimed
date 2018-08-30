package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzadh
public final class ajs extends aku {
    private final AppEventListener a;

    public ajs(AppEventListener appEventListener) {
        this.a = appEventListener;
    }

    public final void onAppEvent(String str, String str2) {
        this.a.onAppEvent(str, str2);
    }
}
