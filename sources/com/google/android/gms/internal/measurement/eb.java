package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.ar;

public final class eb {
    private final String a;
    private final boolean b = true;
    private boolean c;
    private boolean d;
    private final /* synthetic */ dz e;

    public eb(dz dzVar, String str, boolean z) {
        this.e = dzVar;
        ar.a(str);
        this.a = str;
    }

    @WorkerThread
    public final void a(boolean z) {
        Editor edit = this.e.y().edit();
        edit.putBoolean(this.a, z);
        edit.apply();
        this.d = z;
    }

    @WorkerThread
    public final boolean a() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.y().getBoolean(this.a, this.b);
        }
        return this.d;
    }
}
