package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.b;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public final class alm {
    private final auv a;
    private final Context b;
    private final ajq c;
    private a d;
    private zzjd e;
    private zzks f;
    private String g;
    private com.google.android.gms.ads.reward.a h;
    private AppEventListener i;
    private OnCustomRenderedAdLoadedListener j;
    private g k;
    private RewardedVideoAdListener l;
    private boolean m;
    private boolean n;

    public alm(Context context) {
        this(context, ajq.a, null);
    }

    @VisibleForTesting
    private alm(Context context, ajq ajq, b bVar) {
        this.a = new auv();
        this.b = context;
        this.c = ajq;
    }

    private final void b(String str) {
        if (this.f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public final void a(a aVar) {
        try {
            this.d = aVar;
            if (this.f != null) {
                this.f.zza(aVar != null ? new ajk(aVar) : null);
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.l = rewardedVideoAdListener;
            if (this.f != null) {
                this.f.zza(rewardedVideoAdListener != null ? new ff(rewardedVideoAdListener) : null);
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(com.google.android.gms.ads.reward.a aVar) {
        try {
            this.h = aVar;
            if (this.f != null) {
                this.f.zza(aVar != null ? new ajn(aVar) : null);
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(ali ali) {
        try {
            if (this.f == null) {
                String str = "loadAd";
                if (this.g == null) {
                    b(str);
                }
                zzjn a = this.m ? zzjn.a() : new zzjn();
                ajt b = akc.b();
                Context context = this.b;
                this.f = (zzks) ajt.a(context, false, new ajx(b, context, a, this.g, this.a));
                if (this.d != null) {
                    this.f.zza(new ajk(this.d));
                }
                if (this.e != null) {
                    this.f.zza(new ajj(this.e));
                }
                if (this.h != null) {
                    this.f.zza(new ajn(this.h));
                }
                if (this.i != null) {
                    this.f.zza(new ajs(this.i));
                }
                if (this.j != null) {
                    this.f.zza(new anh(this.j));
                }
                if (this.k != null) {
                    this.f.zza(this.k.a());
                }
                if (this.l != null) {
                    this.f.zza(new ff(this.l));
                }
                this.f.setImmersiveMode(this.n);
            }
            if (this.f.zzb(ajq.a(this.b, ali))) {
                this.a.a(ali.j());
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(zzjd zzjd) {
        try {
            this.e = zzjd;
            if (this.f != null) {
                this.f.zza(zzjd != null ? new ajj(zzjd) : null);
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(String str) {
        if (this.g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.g = str;
    }

    public final void a(boolean z) {
        this.m = true;
    }

    public final boolean a() {
        try {
            return this.f == null ? false : this.f.isReady();
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final Bundle b() {
        try {
            if (this.f != null) {
                return this.f.zzba();
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final void b(boolean z) {
        try {
            this.n = z;
            if (this.f != null) {
                this.f.setImmersiveMode(z);
            }
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void c() {
        try {
            b("show");
            this.f.showInterstitial();
        } catch (Throwable e) {
            kk.d("#008 Must be called on the main UI thread.", e);
        }
    }
}
