package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class anv extends apw implements zzpc {
    private String a;
    private List<ann> b;
    private String c;
    private zzpw d;
    private String e;
    private String f;
    private double g;
    private String h;
    private String i;
    @Nullable
    private anj j;
    @Nullable
    private zzlo k;
    @Nullable
    private View l;
    @Nullable
    private IObjectWrapper m;
    @Nullable
    private String n;
    private Bundle o;
    private Object p = new Object();
    private zzoz q;

    public anv(String str, List<ann> list, String str2, zzpw zzpw, String str3, String str4, double d, String str5, String str6, @Nullable anj anj, zzlo zzlo, View view, IObjectWrapper iObjectWrapper, String str7, Bundle bundle) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = zzpw;
        this.e = str3;
        this.f = str4;
        this.g = d;
        this.h = str5;
        this.i = str6;
        this.j = anj;
        this.k = zzlo;
        this.l = view;
        this.m = iObjectWrapper;
        this.n = str7;
        this.o = bundle;
    }

    public final void cancelUnconfirmedClick() {
        this.q.cancelUnconfirmedClick();
    }

    public final void destroy() {
        ht.a.post(new anw(this));
    }

    public final String getAdvertiser() {
        return this.f;
    }

    public final String getBody() {
        return this.c;
    }

    public final String getCallToAction() {
        return this.e;
    }

    public final String getCustomTemplateId() {
        return "";
    }

    public final Bundle getExtras() {
        return this.o;
    }

    public final String getHeadline() {
        return this.a;
    }

    public final List getImages() {
        return this.b;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return this.n;
    }

    public final String getPrice() {
        return this.i;
    }

    public final double getStarRating() {
        return this.g;
    }

    public final String getStore() {
        return this.h;
    }

    public final zzlo getVideoController() {
        return this.k;
    }

    public final void performClick(Bundle bundle) {
        synchronized (this.p) {
            if (this.q == null) {
                kk.c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.q.performClick(bundle);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        boolean z;
        synchronized (this.p) {
            if (this.q == null) {
                kk.c("#002 Attempt to record impression before native ad initialized.");
                z = false;
            } else {
                z = this.q.recordImpression(bundle);
            }
        }
        return z;
    }

    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.p) {
            if (this.q == null) {
                kk.c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.q.reportTouchEvent(bundle);
        }
    }

    public final void zza(zzro zzro) {
        this.q.zza(zzro);
    }

    public final void zzb(zzoz zzoz) {
        synchronized (this.p) {
            this.q = zzoz;
        }
    }

    public final zzpw zzjz() {
        return this.d;
    }

    public final IObjectWrapper zzka() {
        return c.a(this.q);
    }

    public final String zzkb() {
        return "6";
    }

    public final anj zzkc() {
        return this.j;
    }

    public final View zzkd() {
        return this.l;
    }

    public final IObjectWrapper zzke() {
        return this.m;
    }

    public final zzps zzkf() {
        return this.j;
    }
}
