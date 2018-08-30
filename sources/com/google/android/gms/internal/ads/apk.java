package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class apk<T> implements Comparable<apk<T>> {
    private final dd a;
    private final int b;
    private final String c;
    private final int d;
    private final Object e;
    private zzy f;
    private Integer g;
    private ast h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private zzab m;
    private acs n;
    private zzt o;

    public apk(int i, String str, zzy zzy) {
        int hashCode;
        this.a = dd.a ? new dd() : null;
        this.e = new Object();
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.b = i;
        this.c = str;
        this.f = zzy;
        this.m = new ahi();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    hashCode = host.hashCode();
                    this.d = hashCode;
                }
            }
        }
        hashCode = 0;
        this.d = hashCode;
    }

    public final apk<?> a(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public final apk<?> a(acs acs) {
        this.n = acs;
        return this;
    }

    public final apk<?> a(ast ast) {
        this.h = ast;
        return this;
    }

    protected abstract auj<T> a(any any);

    final void a(auj<?> auj) {
        zzt zzt;
        synchronized (this.e) {
            zzt = this.o;
        }
        if (zzt != null) {
            zzt.zza(this, auj);
        }
    }

    public final void a(zzae zzae) {
        zzy zzy;
        synchronized (this.e) {
            zzy = this.f;
        }
        if (zzy != null) {
            zzy.zzd(zzae);
        }
    }

    final void a(zzt zzt) {
        synchronized (this.e) {
            this.o = zzt;
        }
    }

    protected abstract void a(T t);

    public byte[] a() {
        return null;
    }

    public Map<String, String> b() {
        return Collections.emptyMap();
    }

    public final void b(String str) {
        if (dd.a) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    public final int c() {
        return this.b;
    }

    final void c(String str) {
        if (this.h != null) {
            this.h.b(this);
        }
        if (dd.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new aqe(this, str, id));
                return;
            }
            this.a.a(str, id);
            this.a.a(toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        apk apk = (apk) obj;
        zzu zzu = zzu.NORMAL;
        zzu zzu2 = zzu.NORMAL;
        return zzu == zzu2 ? this.g.intValue() - apk.g.intValue() : zzu2.ordinal() - zzu.ordinal();
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.c;
    }

    public final acs f() {
        return this.n;
    }

    public final boolean g() {
        synchronized (this.e) {
        }
        return false;
    }

    public final boolean h() {
        return this.i;
    }

    public final int i() {
        return this.m.zzc();
    }

    public final zzab j() {
        return this.m;
    }

    public final void k() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public final boolean l() {
        boolean z;
        synchronized (this.e) {
            z = this.k;
        }
        return z;
    }

    final void m() {
        zzt zzt;
        synchronized (this.e) {
            zzt = this.o;
        }
        if (zzt != null) {
            zzt.zza(this);
        }
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(this.d));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String str2 = this.c;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.g);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(str).append(str2).append(" ").append(valueOf).append(" ").append(valueOf2).append(" ").append(valueOf3).toString();
    }
}
