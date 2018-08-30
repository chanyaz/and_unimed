package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.s;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.ads.ada;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.gt;
import com.google.android.gms.internal.ads.hd;
import com.google.android.gms.internal.ads.hg;
import com.google.android.gms.internal.ads.jq;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzalc;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzasc;
import com.google.android.gms.internal.ads.zzce;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzke;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzkx;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzrl;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class av implements OnGlobalLayoutListener, OnScrollChangedListener {
    @Nullable
    List<Integer> A;
    @Nullable
    zzod B;
    @Nullable
    zzahe C;
    @Nullable
    zzagx D;
    @Nullable
    public String E;
    @Nullable
    List<String> F;
    @Nullable
    public hd G;
    @Nullable
    View H;
    public int I;
    boolean J;
    private HashSet<gt> K;
    private int L;
    private int M;
    private jq N;
    private boolean O;
    private boolean P;
    private boolean Q;
    final String a;
    public String b;
    public final Context c;
    final ada d;
    public final zzang e;
    @Nullable
    aw f;
    @Nullable
    public hg g;
    @Nullable
    public zzalc h;
    public zzjn i;
    @Nullable
    public gr j;
    public gs k;
    @Nullable
    public gt l;
    @Nullable
    zzke m;
    @Nullable
    zzkh n;
    @Nullable
    zzla o;
    @Nullable
    zzkx p;
    @Nullable
    zzlg q;
    @Nullable
    zzqw r;
    @Nullable
    zzqz s;
    @Nullable
    zzrl t;
    s<String, zzrc> u;
    s<String, zzrf> v;
    zzpl w;
    @Nullable
    zzmu x;
    @Nullable
    zzlu y;
    @Nullable
    zzri z;

    public av(Context context, zzjn zzjn, String str, zzang zzang) {
        this(context, zzjn, str, zzang, null);
    }

    private av(Context context, zzjn zzjn, String str, zzang zzang, ada ada) {
        this.G = null;
        this.H = null;
        this.I = 0;
        this.J = false;
        this.K = null;
        this.L = -1;
        this.M = -1;
        this.O = true;
        this.P = true;
        this.Q = false;
        amn.a(context);
        if (au.i().b() != null) {
            List b = amn.b();
            if (zzang.b != 0) {
                b.add(Integer.toString(zzang.b));
            }
            au.i().b().a(b);
        }
        this.a = UUID.randomUUID().toString();
        if (zzjn.d || zzjn.h) {
            this.f = null;
        } else {
            this.f = new aw(context, str, zzang.a, this, this);
            this.f.setMinimumWidth(zzjn.f);
            this.f.setMinimumHeight(zzjn.c);
            this.f.setVisibility(4);
        }
        this.i = zzjn;
        this.b = str;
        this.c = context;
        this.e = zzang;
        this.d = new ada(new g(this));
        this.N = new jq(200);
        this.v = new s();
    }

    private final void b(boolean z) {
        boolean z2 = true;
        if (this.f != null && this.j != null && this.j.b != null && this.j.b.zzuf() != null) {
            if (!z || this.N.a()) {
                if (this.j.b.zzuf().zzfz()) {
                    int[] iArr = new int[2];
                    this.f.getLocationOnScreen(iArr);
                    akc.a();
                    int b = kb.b(this.c, iArr[0]);
                    akc.a();
                    int b2 = kb.b(this.c, iArr[1]);
                    if (!(b == this.L && b2 == this.M)) {
                        this.L = b;
                        this.M = b2;
                        zzasc zzuf = this.j.b.zzuf();
                        b = this.L;
                        int i = this.M;
                        if (z) {
                            z2 = false;
                        }
                        zzuf.zza(b, i, z2);
                    }
                }
                if (this.f != null) {
                    View findViewById = this.f.getRootView().findViewById(16908290);
                    if (findViewById != null) {
                        Rect rect = new Rect();
                        Rect rect2 = new Rect();
                        this.f.getGlobalVisibleRect(rect);
                        findViewById.getGlobalVisibleRect(rect2);
                        if (rect.top != rect2.top) {
                            this.O = false;
                        }
                        if (rect.bottom != rect2.bottom) {
                            this.P = false;
                        }
                    }
                }
            }
        }
    }

    public final HashSet<gt> a() {
        return this.K;
    }

    final void a(View view) {
        if (((Boolean) akc.f().a(amn.bG)).booleanValue()) {
            zzce a = this.d.a();
            if (a != null) {
                a.zzb(view);
            }
        }
    }

    public final void a(HashSet<gt> hashSet) {
        this.K = hashSet;
    }

    public final void a(boolean z) {
        if (!(this.I != 0 || this.j == null || this.j.b == null)) {
            this.j.b.stopLoading();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.h != null) {
            this.h.cancel();
        }
        if (z) {
            this.j = null;
        }
    }

    public final void b() {
        if (this.j != null && this.j.b != null) {
            this.j.b.destroy();
        }
    }

    public final void c() {
        if (this.j != null && this.j.p != null) {
            try {
                this.j.p.destroy();
            } catch (RemoteException e) {
                kk.e("Could not destroy mediation adapter.");
            }
        }
    }

    public final boolean d() {
        return this.I == 0;
    }

    public final boolean e() {
        return this.I == 1;
    }

    public final String f() {
        return (this.O && this.P) ? "" : this.O ? this.Q ? "top-scrollable" : "top-locked" : this.P ? this.Q ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public final void onGlobalLayout() {
        b(false);
    }

    public final void onScrollChanged() {
        b(true);
        this.Q = true;
    }
}
