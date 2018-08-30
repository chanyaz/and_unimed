package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;

final class cp {
    private long A;
    private long B;
    private final es a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;
    private String y;
    private boolean z;

    @WorkerThread
    cp(es esVar, String str) {
        ar.a((Object) esVar);
        ar.a(str);
        this.a = esVar;
        this.b = str;
        this.a.s();
    }

    @WorkerThread
    public final long A() {
        this.a.s();
        return this.p;
    }

    @WorkerThread
    public final boolean B() {
        this.a.s();
        return this.q;
    }

    @WorkerThread
    public final boolean C() {
        this.a.s();
        return this.r;
    }

    @WorkerThread
    public final void a() {
        this.a.s();
        this.z = false;
    }

    @WorkerThread
    public final void a(long j) {
        this.a.s();
        this.z = (this.h != j ? 1 : 0) | this.z;
        this.h = j;
    }

    @WorkerThread
    public final void a(String str) {
        this.a.s();
        this.z = (!ie.b(this.c, str) ? 1 : 0) | this.z;
        this.c = str;
    }

    @WorkerThread
    public final void a(boolean z) {
        this.a.s();
        this.z = (this.o != z ? 1 : 0) | this.z;
        this.o = z;
    }

    @WorkerThread
    public final String b() {
        this.a.s();
        return this.b;
    }

    @WorkerThread
    public final void b(long j) {
        this.a.s();
        this.z = (this.i != j ? 1 : 0) | this.z;
        this.i = j;
    }

    @WorkerThread
    public final void b(String str) {
        this.a.s();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.z = (!ie.b(this.d, str) ? 1 : 0) | this.z;
        this.d = str;
    }

    @WorkerThread
    public final void b(boolean z) {
        this.a.s();
        this.z = this.q != z;
        this.q = z;
    }

    @WorkerThread
    public final String c() {
        this.a.s();
        return this.c;
    }

    @WorkerThread
    public final void c(long j) {
        this.a.s();
        this.z = (this.k != j ? 1 : 0) | this.z;
        this.k = j;
    }

    @WorkerThread
    public final void c(String str) {
        this.a.s();
        this.z = (!ie.b(this.e, str) ? 1 : 0) | this.z;
        this.e = str;
    }

    @WorkerThread
    public final void c(boolean z) {
        this.a.s();
        this.z = this.r != z;
        this.r = z;
    }

    @WorkerThread
    public final String d() {
        this.a.s();
        return this.d;
    }

    @WorkerThread
    public final void d(long j) {
        this.a.s();
        this.z = (this.m != j ? 1 : 0) | this.z;
        this.m = j;
    }

    @WorkerThread
    public final void d(String str) {
        this.a.s();
        this.z = (!ie.b(this.f, str) ? 1 : 0) | this.z;
        this.f = str;
    }

    @WorkerThread
    public final String e() {
        this.a.s();
        return this.e;
    }

    @WorkerThread
    public final void e(long j) {
        this.a.s();
        this.z = (this.n != j ? 1 : 0) | this.z;
        this.n = j;
    }

    @WorkerThread
    public final void e(String str) {
        this.a.s();
        this.z = (!ie.b(this.j, str) ? 1 : 0) | this.z;
        this.j = str;
    }

    @WorkerThread
    public final String f() {
        this.a.s();
        return this.f;
    }

    @WorkerThread
    public final void f(long j) {
        int i = 1;
        ar.b(j >= 0);
        this.a.s();
        boolean z = this.z;
        if (this.g == j) {
            i = 0;
        }
        this.z = z | i;
        this.g = j;
    }

    @WorkerThread
    public final void f(String str) {
        this.a.s();
        this.z = (!ie.b(this.l, str) ? 1 : 0) | this.z;
        this.l = str;
    }

    @WorkerThread
    public final long g() {
        this.a.s();
        return this.h;
    }

    @WorkerThread
    public final void g(long j) {
        this.a.s();
        this.z = (this.A != j ? 1 : 0) | this.z;
        this.A = j;
    }

    @WorkerThread
    public final void g(String str) {
        this.a.s();
        this.z = (!ie.b(this.y, str) ? 1 : 0) | this.z;
        this.y = str;
    }

    @WorkerThread
    public final long h() {
        this.a.s();
        return this.i;
    }

    @WorkerThread
    public final void h(long j) {
        this.a.s();
        this.z = (this.B != j ? 1 : 0) | this.z;
        this.B = j;
    }

    @WorkerThread
    public final String i() {
        this.a.s();
        return this.j;
    }

    @WorkerThread
    public final void i(long j) {
        this.a.s();
        this.z = (this.s != j ? 1 : 0) | this.z;
        this.s = j;
    }

    @WorkerThread
    public final long j() {
        this.a.s();
        return this.k;
    }

    @WorkerThread
    public final void j(long j) {
        this.a.s();
        this.z = (this.t != j ? 1 : 0) | this.z;
        this.t = j;
    }

    @WorkerThread
    public final String k() {
        this.a.s();
        return this.l;
    }

    @WorkerThread
    public final void k(long j) {
        this.a.s();
        this.z = (this.u != j ? 1 : 0) | this.z;
        this.u = j;
    }

    @WorkerThread
    public final long l() {
        this.a.s();
        return this.m;
    }

    @WorkerThread
    public final void l(long j) {
        this.a.s();
        this.z = (this.v != j ? 1 : 0) | this.z;
        this.v = j;
    }

    @WorkerThread
    public final long m() {
        this.a.s();
        return this.n;
    }

    @WorkerThread
    public final void m(long j) {
        this.a.s();
        this.z = (this.x != j ? 1 : 0) | this.z;
        this.x = j;
    }

    @WorkerThread
    public final void n(long j) {
        this.a.s();
        this.z = (this.w != j ? 1 : 0) | this.z;
        this.w = j;
    }

    @WorkerThread
    public final boolean n() {
        this.a.s();
        return this.o;
    }

    @WorkerThread
    public final long o() {
        this.a.s();
        return this.g;
    }

    @WorkerThread
    public final void o(long j) {
        this.a.s();
        this.z = (this.p != j ? 1 : 0) | this.z;
        this.p = j;
    }

    @WorkerThread
    public final long p() {
        this.a.s();
        return this.A;
    }

    @WorkerThread
    public final long q() {
        this.a.s();
        return this.B;
    }

    @WorkerThread
    public final void r() {
        this.a.s();
        long j = this.g + 1;
        if (j > 2147483647L) {
            this.a.zzge().u().a("Bundle index overflow. appId", dp.a(this.b));
            j = 0;
        }
        this.z = true;
        this.g = j;
    }

    @WorkerThread
    public final long s() {
        this.a.s();
        return this.s;
    }

    @WorkerThread
    public final long t() {
        this.a.s();
        return this.t;
    }

    @WorkerThread
    public final long u() {
        this.a.s();
        return this.u;
    }

    @WorkerThread
    public final long v() {
        this.a.s();
        return this.v;
    }

    @WorkerThread
    public final long w() {
        this.a.s();
        return this.x;
    }

    @WorkerThread
    public final long x() {
        this.a.s();
        return this.w;
    }

    @WorkerThread
    public final String y() {
        this.a.s();
        return this.y;
    }

    @WorkerThread
    public final String z() {
        this.a.s();
        String str = this.y;
        g(null);
        return str;
    }
}
