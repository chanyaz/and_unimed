package com.google.android.gms.internal.ads;

import com.appnext.base.b.c;
import com.mopub.mobileads.VastIconXmlManager;
import org.json.JSONObject;

@zzadh
public class l {
    private final zzaqw a;
    private final String b;

    public l(zzaqw zzaqw) {
        this(zzaqw, "");
    }

    public l(zzaqw zzaqw, String str) {
        this.a = zzaqw;
        this.b = str;
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            this.a.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(VastIconXmlManager.WIDTH, i3).put(VastIconXmlManager.HEIGHT, i4));
        } catch (Throwable e) {
            kk.b("Error occured while dispatching size change.", e);
        }
    }

    public final void a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.a.zza("onScreenInfoChanged", new JSONObject().put(VastIconXmlManager.WIDTH, i).put(VastIconXmlManager.HEIGHT, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            kk.b("Error occured while obtaining screen information.", e);
        }
    }

    public final void a(String str) {
        try {
            this.a.zza("onError", new JSONObject().put("message", str).put(c.jD, this.b));
        } catch (Throwable e) {
            kk.b("Error occurred while dispatching error event.", e);
        }
    }

    public final void b(int i, int i2, int i3, int i4) {
        try {
            this.a.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(VastIconXmlManager.WIDTH, i3).put(VastIconXmlManager.HEIGHT, i4));
        } catch (Throwable e) {
            kk.b("Error occured while dispatching default position.", e);
        }
    }

    public final void b(String str) {
        try {
            this.a.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            kk.b("Error occured while dispatching ready Event.", e);
        }
    }

    public final void c(String str) {
        try {
            this.a.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            kk.b("Error occured while dispatching state change.", e);
        }
    }
}
