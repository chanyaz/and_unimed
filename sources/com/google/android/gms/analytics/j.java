package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.measurement.af;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.ci;
import java.util.HashMap;
import java.util.Map;

final class j extends af implements zza {
    private boolean a;
    private int b;
    private long c = -1;
    private boolean d;
    private long e;
    private final /* synthetic */ i f;

    protected j(i iVar, ah ahVar) {
        this.f = iVar;
        super(ahVar);
    }

    private final void c() {
        if (this.c >= 0 || this.a) {
            n().a(this.f.e);
        } else {
            n().b(this.f.e);
        }
    }

    protected final void a() {
    }

    public final void a(long j) {
        this.c = j;
        c();
    }

    public final void a(boolean z) {
        this.a = z;
        c();
    }

    public final synchronized boolean b() {
        boolean z;
        z = this.d;
        this.d = false;
        return z;
    }

    public final void zzc(Activity activity) {
        if (this.b == 0) {
            if (i().elapsedRealtime() >= this.e + Math.max(1000, this.c)) {
                this.d = true;
            }
        }
        this.b++;
        if (this.a) {
            String str;
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.f.a(intent.getData());
            }
            Map hashMap = new HashMap();
            hashMap.put("&t", "screenview");
            i iVar = this.f;
            String str2 = "&cd";
            if (this.f.g != null) {
                ci k = this.f.g;
                String canonicalName = activity.getClass().getCanonicalName();
                str = (String) k.g.get(canonicalName);
                if (str == null) {
                    str = canonicalName;
                }
            } else {
                str = activity.getClass().getCanonicalName();
            }
            iVar.a(str2, str);
            if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                CharSequence charSequence;
                ar.a((Object) activity);
                intent = activity.getIntent();
                if (intent == null) {
                    charSequence = null;
                } else {
                    charSequence = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = null;
                    }
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    hashMap.put("&dr", charSequence);
                }
            }
            this.f.a(hashMap);
        }
    }

    public final void zzd(Activity activity) {
        this.b--;
        this.b = Math.max(0, this.b);
        if (this.b == 0) {
            this.e = i().elapsedRealtime();
        }
    }
}
