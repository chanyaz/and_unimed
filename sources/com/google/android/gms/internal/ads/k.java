package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

@zzadh
public final class k extends l implements zzv<zzaqw> {
    private final zzaqw a;
    private final Context b;
    private final WindowManager c;
    private final alz d;
    private DisplayMetrics e;
    private float f;
    private int g = -1;
    private int h = -1;
    private int i;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;

    public k(zzaqw zzaqw, Context context, alz alz) {
        super(zzaqw);
        this.a = zzaqw;
        this.b = context;
        this.d = alz;
        this.c = (WindowManager) context.getSystemService("window");
    }

    public final void a(int i, int i2) {
        int i3 = this.b instanceof Activity ? au.e().c((Activity) this.b)[0] : 0;
        if (this.a.zzud() == null || !this.a.zzud().d()) {
            akc.a();
            this.l = kb.b(this.b, this.a.getWidth());
            akc.a();
            this.m = kb.b(this.b, this.a.getHeight());
        }
        b(i, i2 - i3, this.l, this.m);
        this.a.zzuf().zzb(i, i2);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int[] a;
        this.e = new DisplayMetrics();
        Display defaultDisplay = this.c.getDefaultDisplay();
        defaultDisplay.getMetrics(this.e);
        this.f = this.e.density;
        this.i = defaultDisplay.getRotation();
        akc.a();
        this.g = kb.b(this.e, this.e.widthPixels);
        akc.a();
        this.h = kb.b(this.e, this.e.heightPixels);
        Activity zzto = this.a.zzto();
        if (zzto == null || zzto.getWindow() == null) {
            this.j = this.g;
            this.k = this.h;
        } else {
            au.e();
            a = ht.a(zzto);
            akc.a();
            this.j = kb.b(this.e, a[0]);
            akc.a();
            this.k = kb.b(this.e, a[1]);
        }
        if (this.a.zzud().d()) {
            this.l = this.g;
            this.m = this.h;
        } else {
            this.a.measure(0, 0);
        }
        a(this.g, this.h, this.j, this.k, this.f, this.i);
        this.a.zza("onDeviceFeaturesReceived", new h(new j().b(this.d.a()).a(this.d.b()).c(this.d.d()).d(this.d.c()).e(true), null).a());
        a = new int[2];
        this.a.getLocationOnScreen(a);
        akc.a();
        int b = kb.b(this.b, a[0]);
        akc.a();
        a(b, kb.b(this.b, a[1]));
        if (kk.a(2)) {
            kk.d("Dispatching Ready Event.");
        }
        b(this.a.zztq().a);
    }
}
