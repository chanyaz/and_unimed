package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class ank implements OnClickListener {
    @Nullable
    @VisibleForTesting
    String a;
    @Nullable
    @VisibleForTesting
    Long b;
    @Nullable
    @VisibleForTesting
    WeakReference<View> c;
    private final zzacm d;
    @Nullable
    private zzro e;
    @Nullable
    private zzv f;

    public ank(zzacm zzacm) {
        this.d = zzacm;
    }

    private final void c() {
        this.a = null;
        this.b = null;
        if (this.c != null) {
            View view = (View) this.c.get();
            this.c = null;
            if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
            }
        }
    }

    @Nullable
    public final zzro a() {
        return this.e;
    }

    public final void a(zzro zzro) {
        this.e = zzro;
        if (this.f != null) {
            this.d.zzb("/unconfirmedClick", this.f);
        }
        this.f = new anl(this);
        this.d.zza("/unconfirmedClick", this.f);
    }

    public final void b() {
        if (this.e != null && this.b != null) {
            c();
            try {
                this.e.onUnconfirmedClickCancelled();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        if (this.c != null && this.c.get() == view) {
            if (!(this.a == null || this.b == null)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    jSONObject.put("time_interval", au.l().currentTimeMillis() - this.b.longValue());
                    jSONObject.put("messageType", "onePointFiveClick");
                    this.d.zza("sendMessageToNativeJs", jSONObject);
                } catch (Throwable e) {
                    kk.b("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
            c();
        }
    }
}
