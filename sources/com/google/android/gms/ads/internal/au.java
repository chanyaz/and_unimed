package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.a;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.overlay.r;
import com.google.android.gms.ads.internal.overlay.s;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.f;
import com.google.android.gms.internal.ads.ad;
import com.google.android.gms.internal.ads.agq;
import com.google.android.gms.internal.ads.ahl;
import com.google.android.gms.internal.ads.ahm;
import com.google.android.gms.internal.ads.ahw;
import com.google.android.gms.internal.ads.ams;
import com.google.android.gms.internal.ads.aru;
import com.google.android.gms.internal.ads.asm;
import com.google.android.gms.internal.ads.atv;
import com.google.android.gms.internal.ads.aup;
import com.google.android.gms.internal.ads.bv;
import com.google.android.gms.internal.ads.ee;
import com.google.android.gms.internal.ads.gj;
import com.google.android.gms.internal.ads.gw;
import com.google.android.gms.internal.ads.he;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.hz;
import com.google.android.gms.internal.ads.ie;
import com.google.android.gms.internal.ads.if;
import com.google.android.gms.internal.ads.ig;
import com.google.android.gms.internal.ads.ih;
import com.google.android.gms.internal.ads.ii;
import com.google.android.gms.internal.ads.ik;
import com.google.android.gms.internal.ads.il;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jo;
import com.google.android.gms.internal.ads.jx;
import com.google.android.gms.internal.ads.ll;
import com.google.android.gms.internal.ads.lp;
import com.google.android.gms.internal.ads.m;
import com.google.android.gms.internal.ads.nc;
import com.google.android.gms.internal.ads.nw;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class au {
    private static final Object a = new Object();
    private static au b;
    private final ab A;
    private final m B;
    private final ahw C;
    private final gj D;
    private final nc E;
    private final lp F;
    private final asm G;
    private final il H;
    private final jx I;
    private final he J;
    private final a c = new a();
    private final bv d = new bv();
    private final k e = new k();
    private final ad f = new ad();
    private final ht g = new ht();
    private final nw h = new nw();
    private final hz i;
    private final agq j;
    private final gw k;
    private final ahl l;
    private final ahm m;
    private final Clock n;
    private final e o;
    private final ams p;
    private final it q;
    private final ee r;
    private final ll s;
    private final aru t;
    private final atv u;
    private final jn v;
    private final r w;
    private final s x;
    private final aup y;
    private final jo z;

    static {
        au auVar = new au();
        synchronized (a) {
            b = auVar;
        }
    }

    protected au() {
        int i = VERSION.SDK_INT;
        hz ikVar = i >= 21 ? new ik() : i >= 19 ? new ii() : i >= 18 ? new ig() : i >= 17 ? new if() : i >= 16 ? new ih() : new ie();
        this.i = ikVar;
        this.j = new agq();
        this.k = new gw();
        this.J = new he();
        this.l = new ahl();
        this.m = new ahm();
        this.n = f.a();
        this.o = new e();
        this.p = new ams();
        this.q = new it();
        this.r = new ee();
        this.G = new asm();
        this.s = new ll();
        this.t = new aru();
        this.u = new atv();
        this.v = new jn();
        this.w = new r();
        this.x = new s();
        this.y = new aup();
        this.z = new jo();
        this.A = new ab();
        this.B = new m();
        this.C = new ahw();
        this.D = new gj();
        this.E = new nc();
        this.F = new lp();
        this.H = new il();
        this.I = new jx();
    }

    public static lp A() {
        return F().F;
    }

    public static gj B() {
        return F().D;
    }

    public static asm C() {
        return F().G;
    }

    public static il D() {
        return F().H;
    }

    public static jx E() {
        return F().I;
    }

    private static au F() {
        au auVar;
        synchronized (a) {
            auVar = b;
        }
        return auVar;
    }

    public static bv a() {
        return F().d;
    }

    public static a b() {
        return F().c;
    }

    public static k c() {
        return F().e;
    }

    public static ad d() {
        return F().f;
    }

    public static ht e() {
        return F().g;
    }

    public static nw f() {
        return F().h;
    }

    public static hz g() {
        return F().i;
    }

    public static agq h() {
        return F().j;
    }

    public static gw i() {
        return F().k;
    }

    public static he j() {
        return F().J;
    }

    public static ahm k() {
        return F().m;
    }

    public static Clock l() {
        return F().n;
    }

    public static e m() {
        return F().o;
    }

    public static ams n() {
        return F().p;
    }

    public static it o() {
        return F().q;
    }

    public static ee p() {
        return F().r;
    }

    public static ll q() {
        return F().s;
    }

    public static aru r() {
        return F().t;
    }

    public static atv s() {
        return F().u;
    }

    public static jn t() {
        return F().v;
    }

    public static m u() {
        return F().B;
    }

    public static r v() {
        return F().w;
    }

    public static s w() {
        return F().x;
    }

    public static aup x() {
        return F().y;
    }

    public static jo y() {
        return F().z;
    }

    public static nc z() {
        return F().E;
    }
}
