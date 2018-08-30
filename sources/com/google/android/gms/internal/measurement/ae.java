package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;

public class ae {
    private final ah a;

    protected ae(ah ahVar) {
        ar.a((Object) ahVar);
        this.a = ahVar;
    }

    private static String a(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    private final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        bt btVar = null;
        if (this.a != null) {
            btVar = this.a.f();
        }
        if (btVar != null) {
            String str2 = (String) bk.b.a();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, c(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                btVar.a(i, str, obj, obj2, obj3);
                return;
            }
            return;
        }
        String str3 = (String) bk.b.a();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, c(str, obj, obj2, obj3));
        }
    }

    protected static String c(String str, Object obj, Object obj2, Object obj3) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        Object a = a(obj);
        Object a2 = a(obj2);
        Object a3 = a(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
            str3 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str3);
            stringBuilder.append(a);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str3);
            stringBuilder.append(a2);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str3);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public static boolean w() {
        return Log.isLoggable((String) bk.b.a(), 2);
    }

    public final void a(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void a(String str, Object obj, Object obj2, Object obj3) {
        a(3, str, obj, obj2, obj3);
    }

    public final void b(String str) {
        a(2, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void b(String str, Object obj, Object obj2, Object obj3) {
        a(5, str, obj, obj2, obj3);
    }

    public final void c(String str) {
        a(3, str, null, null, null);
    }

    public final void c(String str, Object obj) {
        a(4, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final void d(String str) {
        a(4, str, null, null, null);
    }

    public final void d(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public final void e(String str) {
        a(5, str, null, null, null);
    }

    public final void e(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public final void f(String str) {
        a(6, str, null, null, null);
    }

    public final ah h() {
        return this.a;
    }

    protected final Clock i() {
        return this.a.c();
    }

    protected final Context j() {
        return this.a.a();
    }

    /* renamed from: k */
    protected final bt h() {
        return this.a.e();
    }

    protected final bd l() {
        return this.a.d();
    }

    protected final t m() {
        return this.a.g();
    }

    public final GoogleAnalytics n() {
        return this.a.j();
    }

    /* renamed from: o */
    protected final y j() {
        return this.a.h();
    }

    protected final bi p() {
        return this.a.i();
    }

    protected final ck q() {
        return this.a.k();
    }

    protected final bx r() {
        return this.a.l();
    }

    protected final ay s() {
        return this.a.o();
    }

    /* renamed from: t */
    protected final x b() {
        return this.a.n();
    }

    /* renamed from: u */
    protected final as c() {
        return this.a.p();
    }

    /* renamed from: v */
    protected final bh e() {
        return this.a.q();
    }
}
