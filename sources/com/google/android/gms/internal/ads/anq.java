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
public final class anq extends apc implements zzpc {
    private String a;
    private List<ann> b;
    private String c;
    private zzpw d;
    private String e;
    private String f;
    @Nullable
    private anj g;
    private Bundle h;
    @Nullable
    private zzlo i;
    @Nullable
    private View j;
    @Nullable
    private IObjectWrapper k;
    @Nullable
    private String l;
    private Object m = new Object();
    private zzoz n;

    public anq(String str, List<ann> list, String str2, zzpw zzpw, String str3, String str4, @Nullable anj anj, Bundle bundle, zzlo zzlo, View view, IObjectWrapper iObjectWrapper, String str5) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = zzpw;
        this.e = str3;
        this.f = str4;
        this.g = anj;
        this.h = bundle;
        this.i = zzlo;
        this.j = view;
        this.k = iObjectWrapper;
        this.l = str5;
    }

    public final void destroy() {
        ht.a.post(new anr(this));
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = null;
        this.i = null;
        this.j = null;
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
        return this.h;
    }

    public final String getHeadline() {
        return this.a;
    }

    public final List getImages() {
        return this.b;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return this.l;
    }

    public final zzlo getVideoController() {
        return this.i;
    }

    public final void performClick(Bundle bundle) {
        synchronized (this.m) {
            if (this.n == null) {
                kk.c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.n.performClick(bundle);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        boolean z;
        synchronized (this.m) {
            if (this.n == null) {
                kk.c("#002 Attempt to record impression before native ad initialized.");
                z = false;
            } else {
                z = this.n.recordImpression(bundle);
            }
        }
        return z;
    }

    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.m) {
            if (this.n == null) {
                kk.c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.n.reportTouchEvent(bundle);
        }
    }

    public final void zzb(zzoz zzoz) {
        synchronized (this.m) {
            this.n = zzoz;
        }
    }

    public final IObjectWrapper zzka() {
        return c.a(this.n);
    }

    public final String zzkb() {
        return "1";
    }

    public final anj zzkc() {
        return this.g;
    }

    public final View zzkd() {
        return this.j;
    }

    public final IObjectWrapper zzke() {
        return this.k;
    }

    public final zzps zzkf() {
        return this.g;
    }

    public final zzpw zzkg() {
        return this.d;
    }
}
