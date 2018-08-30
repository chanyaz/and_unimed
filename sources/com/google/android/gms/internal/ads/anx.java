package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class anx extends anz {
    @Nullable
    private zzxz c;
    @Nullable
    private zzyc d;
    @Nullable
    private zzyf e;
    private final zzpa f;
    @Nullable
    private zzoz g;
    private boolean h;
    private Object i;

    private anx(Context context, zzpa zzpa, ada ada, zzpb zzpb) {
        super(context, zzpa, null, ada, null, zzpb, null, null);
        this.h = false;
        this.i = new Object();
        this.f = zzpa;
    }

    public anx(Context context, zzpa zzpa, ada ada, zzxz zzxz, zzpb zzpb) {
        this(context, zzpa, ada, zzpb);
        this.c = zzxz;
    }

    public anx(Context context, zzpa zzpa, ada ada, zzyc zzyc, zzpb zzpb) {
        this(context, zzpa, ada, zzpb);
        this.d = zzyc;
    }

    public anx(Context context, zzpa zzpa, ada ada, zzyf zzyf, zzpb zzpb) {
        this(context, zzpa, ada, zzpb);
        this.e = zzyf;
    }

    private static HashMap<String, View> b(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final void a(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.i) {
            this.h = true;
            Object b = b(map);
            Object b2 = b(map2);
            try {
                if (this.e != null) {
                    this.e.zzb(c.a((Object) view), c.a(b), c.a(b2));
                } else if (this.c != null) {
                    this.c.zzb(c.a((Object) view), c.a(b), c.a(b2));
                    this.c.zzk(c.a((Object) view));
                } else if (this.d != null) {
                    this.d.zzb(c.a((Object) view), c.a(b), c.a(b2));
                    this.d.zzk(c.a((Object) view));
                }
            } catch (Throwable e) {
                kk.c("Failed to call prepareAd", e);
            }
            this.h = false;
        }
    }

    public final void a(@Nullable zzoz zzoz) {
        synchronized (this.i) {
            this.g = zzoz;
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.i) {
            z = this.h;
        }
        return z;
    }

    public final zzoz b() {
        zzoz zzoz;
        synchronized (this.i) {
            zzoz = this.g;
        }
        return zzoz;
    }

    @Nullable
    public final zzaqw c() {
        return null;
    }

    public final void cancelUnconfirmedClick() {
        synchronized (this.i) {
            if (this.g != null) {
                this.g.cancelUnconfirmedClick();
            }
        }
    }

    public final void setClickConfirmingView(View view) {
        synchronized (this.i) {
            if (this.g != null) {
                this.g.setClickConfirmingView(view);
            }
        }
    }

    @Nullable
    public final View zza(OnClickListener onClickListener, boolean z) {
        synchronized (this.i) {
            View zza;
            if (this.g != null) {
                zza = this.g.zza(onClickListener, z);
                return zza;
            }
            IObjectWrapper zzmv;
            try {
                if (this.e != null) {
                    zzmv = this.e.zzmv();
                } else if (this.c != null) {
                    zzmv = this.c.zzmv();
                } else {
                    if (this.d != null) {
                        zzmv = this.d.zzmv();
                    }
                    zzmv = null;
                }
            } catch (Throwable e) {
                kk.c("Failed to call getAdChoicesContent", e);
            }
            if (zzmv != null) {
                zza = (View) c.a(zzmv);
                return zza;
            }
            return null;
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map) {
        ar.b("recordImpression must be called on the main UI thread.");
        synchronized (this.i) {
            this.a = true;
            if (this.g != null) {
                this.g.zza(view, (Map) map);
                this.f.recordImpression();
            } else {
                try {
                    if (this.e != null && !this.e.getOverrideImpressionRecording()) {
                        this.e.recordImpression();
                        this.f.recordImpression();
                    } else if (this.c != null && !this.c.getOverrideImpressionRecording()) {
                        this.c.recordImpression();
                        this.f.recordImpression();
                    } else if (!(this.d == null || this.d.getOverrideImpressionRecording())) {
                        this.d.recordImpression();
                        this.f.recordImpression();
                    }
                } catch (Throwable e) {
                    kk.c("Failed to call recordImpression", e);
                }
            }
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        ar.b("performClick must be called on the main UI thread.");
        synchronized (this.i) {
            if (this.g != null) {
                this.g.zza(view, map, bundle, view2);
                this.f.onAdClicked();
            } else {
                try {
                    if (this.e != null && !this.e.getOverrideClickHandling()) {
                        this.e.zzj(c.a((Object) view));
                        this.f.onAdClicked();
                    } else if (this.c != null && !this.c.getOverrideClickHandling()) {
                        this.c.zzj(c.a((Object) view));
                        this.f.onAdClicked();
                    } else if (!(this.d == null || this.d.getOverrideClickHandling())) {
                        this.d.zzj(c.a((Object) view));
                        this.f.onAdClicked();
                    }
                } catch (Throwable e) {
                    kk.c("Failed to call performClick", e);
                }
            }
        }
    }

    public final void zza(zzro zzro) {
        synchronized (this.i) {
            if (this.g != null) {
                this.g.zza(zzro);
            }
        }
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.i) {
            try {
                if (this.e != null) {
                    this.e.zzl(c.a((Object) view));
                } else if (this.c != null) {
                    this.c.zzl(c.a((Object) view));
                } else if (this.d != null) {
                    this.d.zzl(c.a((Object) view));
                }
            } catch (Throwable e) {
                kk.c("Failed to call untrackView", e);
            }
        }
    }

    public final void zzcr() {
        if (this.g != null) {
            this.g.zzcr();
        }
    }

    public final void zzcs() {
        if (this.g != null) {
            this.g.zzcs();
        }
    }

    public final boolean zzkj() {
        boolean zzkj;
        synchronized (this.i) {
            if (this.g != null) {
                zzkj = this.g.zzkj();
            } else {
                zzkj = this.f.zzcu();
            }
        }
        return zzkj;
    }

    public final boolean zzkk() {
        boolean zzkk;
        synchronized (this.i) {
            if (this.g != null) {
                zzkk = this.g.zzkk();
            } else {
                zzkk = this.f.zzcv();
            }
        }
        return zzkk;
    }

    public final void zzkl() {
        ar.b("recordDownloadedImpression must be called on main UI thread.");
        synchronized (this.i) {
            this.b = true;
            if (this.g != null) {
                this.g.zzkl();
            }
        }
    }

    public final void zzkp() {
    }

    public final void zzkq() {
    }
}
