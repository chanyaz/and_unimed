package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class l {
    private final Object a;

    public final boolean a() {
        return this.a instanceof FragmentActivity;
    }

    public final boolean b() {
        return this.a instanceof Activity;
    }

    public final Activity c() {
        return (Activity) this.a;
    }

    public final FragmentActivity d() {
        return (FragmentActivity) this.a;
    }
}
