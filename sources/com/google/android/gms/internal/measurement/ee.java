package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.ar;

public final class ee {
    private final String a;
    private final String b = null;
    private boolean c;
    private String d;
    private final /* synthetic */ dz e;

    public ee(dz dzVar, String str, String str2) {
        this.e = dzVar;
        ar.a(str);
        this.a = str;
    }

    @WorkerThread
    public final String a() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.y().getString(this.a, null);
        }
        return this.d;
    }

    @WorkerThread
    public final void a(String str) {
        if (!ie.b(str, this.d)) {
            Editor edit = this.e.y().edit();
            edit.putString(this.a, str);
            edit.apply();
            this.d = str;
        }
    }
}
