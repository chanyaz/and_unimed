package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.c;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzadh
public final class avo extends ave {
    private final c a;

    public avo(c cVar) {
        this.a = cVar;
    }

    public final String getBody() {
        return this.a.k();
    }

    public final String getCallToAction() {
        return this.a.m();
    }

    public final Bundle getExtras() {
        return this.a.c();
    }

    public final String getHeadline() {
        return this.a.i();
    }

    public final List getImages() {
        List<com.google.android.gms.ads.formats.c> j = this.a.j();
        if (j == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (com.google.android.gms.ads.formats.c cVar : j) {
            arrayList.add(new ann(cVar.a(), cVar.b(), cVar.c()));
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.a.b();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.a.a();
    }

    public final String getPrice() {
        return this.a.p();
    }

    public final double getStarRating() {
        return this.a.n();
    }

    public final String getStore() {
        return this.a.o();
    }

    public final zzlo getVideoController() {
        return this.a.g() != null ? this.a.g().a() : null;
    }

    public final void recordImpression() {
        this.a.e();
    }

    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.a.a((View) com.google.android.gms.dynamic.c.a(iObjectWrapper), (HashMap) com.google.android.gms.dynamic.c.a(iObjectWrapper2), (HashMap) com.google.android.gms.dynamic.c.a(iObjectWrapper3));
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.a.c((View) com.google.android.gms.dynamic.c.a(iObjectWrapper));
    }

    public final zzpw zzjz() {
        com.google.android.gms.ads.formats.c l = this.a.l();
        return l != null ? new ann(l.a(), l.b(), l.c()) : null;
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.a.a((View) com.google.android.gms.dynamic.c.a(iObjectWrapper));
    }

    public final IObjectWrapper zzke() {
        return null;
    }

    public final zzps zzkf() {
        return null;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.a.b((View) com.google.android.gms.dynamic.c.a(iObjectWrapper));
    }

    public final IObjectWrapper zzmv() {
        Object d = this.a.d();
        return d == null ? null : com.google.android.gms.dynamic.c.a(d);
    }

    public final IObjectWrapper zzmw() {
        Object f = this.a.f();
        return f == null ? null : com.google.android.gms.dynamic.c.a(f);
    }
}
