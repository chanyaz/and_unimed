package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.s;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.akl;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzkk;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzrl;
import com.google.android.gms.internal.ads.zzxn;

@zzadh
public final class k extends akl {
    private zzkh a;
    private zzqw b;
    private zzrl c;
    private zzqz d;
    private s<String, zzrc> e = new s();
    private s<String, zzrf> f = new s();
    private zzri g;
    private zzjn h;
    private PublisherAdViewOptions i;
    private zzpl j;
    private zzlg k;
    private final Context l;
    private final zzxn m;
    private final String n;
    private final zzang o;
    private final br p;

    public k(Context context, String str, zzxn zzxn, zzang zzang, br brVar) {
        this.l = context;
        this.n = str;
        this.m = zzxn;
        this.o = zzang;
        this.p = brVar;
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.i = publisherAdViewOptions;
    }

    public final void zza(zzpl zzpl) {
        this.j = zzpl;
    }

    public final void zza(zzqw zzqw) {
        this.b = zzqw;
    }

    public final void zza(zzqz zzqz) {
        this.d = zzqz;
    }

    public final void zza(zzri zzri, zzjn zzjn) {
        this.g = zzri;
        this.h = zzjn;
    }

    public final void zza(zzrl zzrl) {
        this.c = zzrl;
    }

    public final void zza(String str, zzrf zzrf, zzrc zzrc) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f.put(str, zzrf);
        this.e.put(str, zzrc);
    }

    public final void zzb(zzkh zzkh) {
        this.a = zzkh;
    }

    public final void zzb(zzlg zzlg) {
        this.k = zzlg;
    }

    public final zzkk zzdh() {
        return new h(this.l, this.n, this.m, this.o, this.a, this.b, this.c, this.d, this.f, this.e, this.j, this.k, this.p, this.g, this.h, this.i);
    }
}
