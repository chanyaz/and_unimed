package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ago {
    private final int a;
    private final int b;
    private final int c;
    private final aha d;
    private final ahj e;
    private final Object f = new Object();
    private ArrayList<String> g = new ArrayList();
    private ArrayList<String> h = new ArrayList();
    private ArrayList<agy> i = new ArrayList();
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m;
    private String n = "";
    private String o = "";
    private String p = "";

    public ago(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new aha(i4);
        this.e = new ahj(i5, i6, i7);
    }

    private static String a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            stringBuilder.append((String) obj);
            stringBuilder.append(' ');
            if (stringBuilder.length() > 100) {
                break;
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.length() >= 100 ? stringBuilder2.substring(0, 100) : stringBuilder2;
    }

    private final void c(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.c) {
            synchronized (this.f) {
                this.g.add(str);
                this.j += str.length();
                if (z) {
                    this.h.add(str);
                    this.i.add(new agy(f, f2, f3, f4, this.h.size() - 1));
                }
            }
        }
    }

    public final void a(int i) {
        this.k = i;
    }

    public final void a(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
        synchronized (this.f) {
            if (this.l < 0) {
                kk.b("ActivityContent: negative number of WebViews.");
            }
            h();
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f) {
            z = this.l == 0;
        }
        return z;
    }

    public final String b() {
        return this.n;
    }

    public final void b(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
    }

    public final String c() {
        return this.o;
    }

    public final String d() {
        return this.p;
    }

    public final void e() {
        synchronized (this.f) {
            this.m -= 100;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ago)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ago ago = (ago) obj;
        return ago.n != null && ago.n.equals(this.n);
    }

    public final void f() {
        synchronized (this.f) {
            this.l--;
        }
    }

    public final void g() {
        synchronized (this.f) {
            this.l++;
        }
    }

    public final void h() {
        synchronized (this.f) {
            int i = (this.j * this.a) + (this.k * this.b);
            if (i > this.m) {
                this.m = i;
                if (((Boolean) akc.f().a(amn.W)).booleanValue() && !au.i().l().b()) {
                    this.n = this.d.a(this.g);
                    this.o = this.d.a(this.h);
                }
                if (((Boolean) akc.f().a(amn.Y)).booleanValue() && !au.i().l().d()) {
                    this.p = this.e.a(this.h, this.i);
                }
            }
        }
    }

    public final int hashCode() {
        return this.n.hashCode();
    }

    public final int i() {
        return this.m;
    }

    @VisibleForTesting
    final int j() {
        return this.j;
    }

    public final String toString() {
        int i = this.k;
        int i2 = this.m;
        int i3 = this.j;
        String a = a(this.g, 100);
        String a2 = a(this.h, 100);
        String str = this.n;
        String str2 = this.o;
        String str3 = this.p;
        return new StringBuilder(((((String.valueOf(a).length() + 165) + String.valueOf(a2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(a).append("\n viewableText").append(a2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).append("\n viewableSignatureForVertical: ").append(str3).toString();
    }
}
