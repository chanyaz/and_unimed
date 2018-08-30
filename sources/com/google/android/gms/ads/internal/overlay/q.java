package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.o;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class q extends o {
    private AdOverlayInfoParcel a;
    private Activity b;
    private boolean c = false;
    private boolean d = false;

    public q(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.a = adOverlayInfoParcel;
        this.b = activity;
    }

    private final synchronized void a() {
        if (!this.d) {
            if (this.a.c != null) {
                this.a.c.zzcb();
            }
            this.d = true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        if (this.a == null) {
            this.b.finish();
        } else if (z) {
            this.b.finish();
        } else {
            if (bundle == null) {
                if (this.a.b != null) {
                    this.a.b.onAdClicked();
                }
                if (!(this.b.getIntent() == null || !this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.a.c == null)) {
                    this.a.c.zzcc();
                }
            }
            au.b();
            if (!a.a(this.b, this.a.a, this.a.i)) {
                this.b.finish();
            }
        }
    }

    public final void onDestroy() {
        if (this.b.isFinishing()) {
            a();
        }
    }

    public final void onPause() {
        if (this.a.c != null) {
            this.a.c.onPause();
        }
        if (this.b.isFinishing()) {
            a();
        }
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.c) {
            this.b.finish();
            return;
        }
        this.c = true;
        if (this.a.c != null) {
            this.a.c.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }

    public final void onStart() {
    }

    public final void onStop() {
        if (this.b.isFinishing()) {
            a();
        }
    }

    public final void zzax() {
    }

    public final boolean zznj() {
        return false;
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
    }
}
