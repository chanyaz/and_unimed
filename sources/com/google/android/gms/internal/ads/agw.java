package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class agw implements ValueCallback<String> {
    private final /* synthetic */ agv a;

    agw(agv agv) {
        this.a = agv;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.d.a(this.a.a, this.a.b, (String) obj, this.a.c);
    }
}
