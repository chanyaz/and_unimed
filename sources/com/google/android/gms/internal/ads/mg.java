package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.c;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class mg extends FrameLayout implements zzapf {
    private final zzapw a;
    private final FrameLayout b;
    private final ana c;
    private final mu d;
    private final long e;
    @Nullable
    private me f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private String m;
    private Bitmap n;
    private ImageView o;
    private boolean p;

    public mg(Context context, zzapw zzapw, int i, boolean z, ana ana, ms msVar) {
        super(context);
        this.a = zzapw;
        this.c = ana;
        this.b = new FrameLayout(context);
        addView(this.b, new LayoutParams(-1, -1));
        c.a(zzapw.zzbi());
        this.f = zzapw.zzbi().b.a(context, zzapw, i, z, ana, msVar);
        if (this.f != null) {
            this.b.addView(this.f, new LayoutParams(-1, -1, 17));
            if (((Boolean) akc.f().a(amn.w)).booleanValue()) {
                f();
            }
        }
        this.o = new ImageView(context);
        this.e = ((Long) akc.f().a(amn.A)).longValue();
        this.j = ((Boolean) akc.f().a(amn.y)).booleanValue();
        if (this.c != null) {
            this.c.a("spinner_used", this.j ? "1" : "0");
        }
        this.d = new mu(this);
        if (this.f != null) {
            this.f.a((zzapf) this);
        }
        if (this.f == null) {
            zzg("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void a(zzapw zzapw) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzapw.zza("onVideoEvent", hashMap);
    }

    public static void a(zzapw zzapw, String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzapw.zza("onVideoEvent", hashMap);
    }

    public static void a(zzapw zzapw, Map<String, List<Map<String, Object>>> map) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzapw.zza("onVideoEvent", hashMap);
    }

    private final void a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.a.zza("onVideoEvent", hashMap);
    }

    private final boolean i() {
        return this.o.getParent() != null;
    }

    private final void j() {
        if (this.a.zzto() != null && this.h && !this.i) {
            this.a.zzto().getWindow().clearFlags(128);
            this.h = false;
        }
    }

    public final void a() {
        if (this.f != null) {
            if (TextUtils.isEmpty(this.m)) {
                a("no_src", new String[0]);
            } else {
                this.f.setVideoPath(this.m);
            }
        }
    }

    public final void a(float f, float f2) {
        if (this.f != null) {
            this.f.a(f, f2);
        }
    }

    public final void a(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    @TargetApi(14)
    public final void a(MotionEvent motionEvent) {
        if (this.f != null) {
            this.f.dispatchTouchEvent(motionEvent);
        }
    }

    public final void a(String str) {
        this.m = str;
    }

    public final void b() {
        if (this.f != null) {
            this.f.d();
        }
    }

    public final void c() {
        if (this.f != null) {
            this.f.c();
        }
    }

    public final void d() {
        if (this.f != null) {
            me meVar = this.f;
            meVar.b.a(true);
            meVar.zzst();
        }
    }

    public final void e() {
        if (this.f != null) {
            me meVar = this.f;
            meVar.b.a(false);
            meVar.zzst();
        }
    }

    @TargetApi(14)
    public final void f() {
        if (this.f != null) {
            View textView = new TextView(this.f.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f.a());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.b.addView(textView, new LayoutParams(-2, -2, 17));
            this.b.bringChildToFront(textView);
        }
    }

    public final void finalize() {
        try {
            this.d.a();
            if (this.f != null) {
                me meVar = this.f;
                Executor executor = lf.a;
                meVar.getClass();
                executor.execute(mh.a(meVar));
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void g() {
        this.d.a();
        if (this.f != null) {
            this.f.b();
        }
        j();
    }

    final void h() {
        if (this.f != null) {
            long currentPosition = (long) this.f.getCurrentPosition();
            if (this.k != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                a("timeupdate", com.appnext.base.b.c.ju, String.valueOf(f));
                this.k = currentPosition;
            }
        }
    }

    public final void onPaused() {
        a("pause", new String[0]);
        j();
        this.g = false;
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        if (i == 0) {
            this.d.b();
            z = true;
        } else {
            this.d.a();
            this.l = this.k;
            z = false;
        }
        ht.a.post(new mk(this, z));
    }

    public final void setVolume(float f) {
        if (this.f != null) {
            me meVar = this.f;
            meVar.b.a(f);
            meVar.zzst();
        }
    }

    public final void zzf(int i, int i2) {
        if (this.j) {
            int max = Math.max(i / ((Integer) akc.f().a(amn.z)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) akc.f().a(amn.z)).intValue(), 1);
            if (this.n == null || this.n.getWidth() != max || this.n.getHeight() != max2) {
                this.n = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.p = false;
            }
        }
    }

    public final void zzg(String str, @Nullable String str2) {
        a("error", "what", str, "extra", str2);
    }

    public final void zzsu() {
        this.d.b();
        ht.a.post(new mi(this));
    }

    public final void zzsv() {
        if (this.f != null && this.l == 0) {
            float duration = ((float) this.f.getDuration()) / 1000.0f;
            int videoWidth = this.f.getVideoWidth();
            int videoHeight = this.f.getVideoHeight();
            a("canplaythrough", VastIconXmlManager.DURATION, String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public final void zzsw() {
        if (!(this.a.zzto() == null || this.h)) {
            this.i = (this.a.zzto().getWindow().getAttributes().flags & 128) != 0;
            if (!this.i) {
                this.a.zzto().getWindow().addFlags(128);
                this.h = true;
            }
        }
        this.g = true;
    }

    public final void zzsx() {
        a("ended", new String[0]);
        j();
    }

    public final void zzsy() {
        if (!(!this.p || this.n == null || i())) {
            this.o.setImageBitmap(this.n);
            this.o.invalidate();
            this.b.addView(this.o, new LayoutParams(-1, -1));
            this.b.bringChildToFront(this.o);
        }
        this.d.a();
        this.l = this.k;
        ht.a.post(new mj(this));
    }

    public final void zzsz() {
        if (this.g && i()) {
            this.b.removeView(this.o);
        }
        if (this.n != null) {
            long elapsedRealtime = au.l().elapsedRealtime();
            if (this.f.getBitmap(this.n) != null) {
                this.p = true;
            }
            elapsedRealtime = au.l().elapsedRealtime() - elapsedRealtime;
            if (hl.a()) {
                hl.a("Spinner frame grab took " + elapsedRealtime + "ms");
            }
            if (elapsedRealtime > this.e) {
                kk.e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.j = false;
                this.n = null;
                if (this.c != null) {
                    this.c.a("spinner_jank", Long.toString(elapsedRealtime));
                }
            }
        }
    }
}
