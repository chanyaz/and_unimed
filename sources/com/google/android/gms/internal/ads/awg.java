package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.c;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzadh
public final class awg extends avi {
    private final e a;

    public awg(e eVar) {
        this.a = eVar;
    }

    public final String getAdvertiser() {
        return this.a.f();
    }

    public final String getBody() {
        return this.a.c();
    }

    public final String getCallToAction() {
        return this.a.e();
    }

    public final Bundle getExtras() {
        return this.a.o();
    }

    public final String getHeadline() {
        return this.a.a();
    }

    public final List getImages() {
        List<c> b = this.a.b();
        List arrayList = new ArrayList();
        if (b != null) {
            for (c cVar : b) {
                arrayList.add(new ann(cVar.a(), cVar.b(), cVar.c()));
            }
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.a.q();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.a.p();
    }

    public final String getPrice() {
        return this.a.i();
    }

    public final double getStarRating() {
        return this.a.g() != null ? this.a.g().doubleValue() : -1.0d;
    }

    public final String getStore() {
        return this.a.h();
    }

    public final zzlo getVideoController() {
        return this.a.j() != null ? this.a.j().a() : null;
    }

    public final void recordImpression() {
        this.a.r();
    }

    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.a.a((View) com.google.android.gms.dynamic.c.a(iObjectWrapper), (HashMap) com.google.android.gms.dynamic.c.a(iObjectWrapper2), (HashMap) com.google.android.gms.dynamic.c.a(iObjectWrapper3));
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.a.a((View) com.google.android.gms.dynamic.c.a(iObjectWrapper));
    }

    public final zzpw zzjz() {
        c d = this.a.d();
        return d != null ? new ann(d.a(), d.b(), d.c()) : null;
    }

    public final IObjectWrapper zzke() {
        Object n = this.a.n();
        return n == null ? null : com.google.android.gms.dynamic.c.a(n);
    }

    public final zzps zzkf() {
        return null;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.a.b((View) com.google.android.gms.dynamic.c.a(iObjectWrapper));
    }

    public final IObjectWrapper zzmv() {
        Object l = this.a.l();
        return l == null ? null : com.google.android.gms.dynamic.c.a(l);
    }

    public final IObjectWrapper zzmw() {
        Object m = this.a.m();
        return m == null ? null : com.google.android.gms.dynamic.c.a(m);
    }
}
