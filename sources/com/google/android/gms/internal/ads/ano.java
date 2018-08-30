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
public final class ano extends aoz implements zzpc {
    private String a;
    private List<ann> b;
    private String c;
    private zzpw d;
    private String e;
    private double f;
    private String g;
    private String h;
    @Nullable
    private anj i;
    private Bundle j;
    @Nullable
    private zzlo k;
    @Nullable
    private View l;
    @Nullable
    private IObjectWrapper m;
    @Nullable
    private String n;
    private Object o = new Object();
    private zzoz p;

    public ano(String str, List<ann> list, String str2, zzpw zzpw, String str3, double d, String str4, String str5, @Nullable anj anj, Bundle bundle, zzlo zzlo, View view, IObjectWrapper iObjectWrapper, String str6) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = zzpw;
        this.e = str3;
        this.f = d;
        this.g = str4;
        this.h = str5;
        this.i = anj;
        this.j = bundle;
        this.k = zzlo;
        this.l = view;
        this.m = iObjectWrapper;
        this.n = str6;
    }

    public final void destroy() {
        ht.a.post(new anp(this));
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0d;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.o = null;
        this.k = null;
        this.l = null;
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
        return this.j;
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
        return this.h;
    }

    public final double getStarRating() {
        return this.f;
    }

    public final String getStore() {
        return this.g;
    }

    public final zzlo getVideoController() {
        return this.k;
    }

    public final void performClick(Bundle bundle) {
        synchronized (this.o) {
            if (this.p == null) {
                kk.c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.p.performClick(bundle);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        boolean z;
        synchronized (this.o) {
            if (this.p == null) {
                kk.c("#002 Attempt to record impression before native ad initialized.");
                z = false;
            } else {
                z = this.p.recordImpression(bundle);
            }
        }
        return z;
    }

    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.o) {
            if (this.p == null) {
                kk.c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.p.reportTouchEvent(bundle);
        }
    }

    public final void zzb(zzoz zzoz) {
        synchronized (this.o) {
            this.p = zzoz;
        }
    }

    public final zzpw zzjz() {
        return this.d;
    }

    public final IObjectWrapper zzka() {
        return c.a(this.p);
    }

    public final String zzkb() {
        return "2";
    }

    public final anj zzkc() {
        return this.i;
    }

    public final View zzkd() {
        return this.l;
    }

    public final IObjectWrapper zzke() {
        return this.m;
    }

    public final zzps zzkf() {
        return this.i;
    }
}
