package com.google.android.gms.internal.measurement;

import com.appnext.base.b.c;

final class dq implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ Object d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ dp f;

    dq(dp dpVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f = dpVar;
        this.a = i;
        this.b = str;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    public final void run() {
        fo c = this.f.q.c();
        if (c.A()) {
            if (this.f.a == 0) {
                if (this.f.o().p()) {
                    this.f.a = 'C';
                } else {
                    this.f.a = 'c';
                }
            }
            if (this.f.b < 0) {
                this.f.b = 12451;
            }
            char charAt = "01VDIWEA?".charAt(this.a);
            char a = this.f.a;
            long b = this.f.b;
            String a2 = dp.a(true, this.b, this.c, this.d, this.e);
            String stringBuilder = new StringBuilder(String.valueOf(a2).length() + 24).append("2").append(charAt).append(a).append(b).append(":").append(a2).toString();
            if (stringBuilder.length() > c.jk) {
                stringBuilder = this.b.substring(0, c.jk);
            }
            c.b.a(stringBuilder, 1);
            return;
        }
        this.f.a(6, "Persisted config not initialized. Not logging error/warn");
    }
}
