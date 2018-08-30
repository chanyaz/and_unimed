package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.appnext.base.b.c;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzadh
public final class my implements zzv<zzapw> {
    private boolean a;

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            akc.a();
            return kb.a(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            kk.e(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            return i;
        }
    }

    private static void a(mg mgVar, Map<String, String> map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        if (str != null) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                kk.e(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            Integer.parseInt(str2);
        }
        if (str3 != null) {
            Integer.parseInt(str3);
        }
        if (str4 != null) {
            Integer.parseInt(str4);
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i = 0;
        zzapw zzapw = (zzapw) obj;
        String str = (String) map.get(c.jD);
        if (str == null) {
            kk.e("Action missing from video GMSG.");
            return;
        }
        String jSONObject;
        if (kk.a(3)) {
            JSONObject jSONObject2 = new JSONObject(map);
            jSONObject2.remove("google.afma.Notify_dt");
            jSONObject = jSONObject2.toString();
            kk.b(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(jSONObject).length()).append("Video GMSG: ").append(str).append(" ").append(jSONObject).toString());
        }
        int length;
        if ("background".equals(str)) {
            jSONObject = (String) map.get("color");
            if (TextUtils.isEmpty(jSONObject)) {
                kk.e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzapw.setBackgroundColor(Color.parseColor(jSONObject));
            } catch (IllegalArgumentException e) {
                kk.e("Invalid color parameter in video GMSG.");
            }
        } else if ("decoderProps".equals(str)) {
            jSONObject = (String) map.get("mimeTypes");
            if (jSONObject == null) {
                kk.e("No MIME types specified for decoder properties inspection.");
                mg.a(zzapw, "missingMimeTypes");
            } else if (VERSION.SDK_INT < 16) {
                kk.e("Video decoder properties available on API versions >= 16.");
                mg.a(zzapw, "deficientApiVersion");
            } else {
                Map hashMap = new HashMap();
                String[] split = jSONObject.split(",");
                length = split.length;
                while (i < length) {
                    String str2 = split[i];
                    hashMap.put(str2, jz.a(str2.trim()));
                    i++;
                }
                mg.a(zzapw, hashMap);
            }
        } else {
            ml zztl = zzapw.zztl();
            if (zztl == null) {
                kk.e("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            int min;
            if (equals || equals2) {
                Context context = zzapw.getContext();
                int a = a(context, map, "x", 0);
                length = a(context, map, "y", 0);
                int a2 = a(context, map, "w", -1);
                int a3 = a(context, map, "h", -1);
                if (((Boolean) akc.f().a(amn.cf)).booleanValue()) {
                    min = Math.min(a2, zzapw.zzts() - a);
                    a3 = Math.min(a3, zzapw.zztr() - length);
                } else {
                    min = a2;
                }
                try {
                    a2 = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException e2) {
                    a2 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (equals && zztl.a() == null) {
                    zztl.a(a, length, min, a3, a2, parseBoolean, new ms((String) map.get("flags")));
                    mg a4 = zztl.a();
                    if (a4 != null) {
                        a(a4, map);
                        return;
                    }
                    return;
                }
                zztl.a(a, length, min, a3);
                return;
            }
            mg a5 = zztl.a();
            Context context2;
            if (a5 == null) {
                mg.a(zzapw);
            } else if ("click".equals(str)) {
                context2 = zzapw.getContext();
                length = a(context2, map, "x", 0);
                min = a(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) length, (float) min, 0);
                a5.a(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                jSONObject = (String) map.get(c.ju);
                if (jSONObject == null) {
                    kk.e("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    a5.a((int) (Float.parseFloat(jSONObject) * 1000.0f));
                } catch (NumberFormatException e3) {
                    str = "Could not parse time parameter from currentTime video GMSG: ";
                    jSONObject = String.valueOf(jSONObject);
                    kk.e(jSONObject.length() != 0 ? str.concat(jSONObject) : new String(str));
                }
            } else if ("hide".equals(str)) {
                a5.setVisibility(4);
            } else if ("load".equals(str)) {
                a5.a();
            } else if ("loadControl".equals(str)) {
                a(a5, map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    a5.d();
                } else {
                    a5.e();
                }
            } else if ("pause".equals(str)) {
                a5.b();
            } else if ("play".equals(str)) {
                a5.c();
            } else if ("show".equals(str)) {
                a5.setVisibility(0);
            } else if ("src".equals(str)) {
                a5.a((String) map.get("src"));
            } else if ("touchMove".equals(str)) {
                context2 = zzapw.getContext();
                a5.a((float) a(context2, map, "dx", 0), (float) a(context2, map, "dy", 0));
                if (!this.a) {
                    zzapw.zznp();
                    this.a = true;
                }
            } else if ("volume".equals(str)) {
                jSONObject = (String) map.get("volume");
                if (jSONObject == null) {
                    kk.e("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    a5.setVolume(Float.parseFloat(jSONObject));
                } catch (NumberFormatException e4) {
                    str = "Could not parse volume parameter from volume video GMSG: ";
                    jSONObject = String.valueOf(jSONObject);
                    kk.e(jSONObject.length() != 0 ? str.concat(jSONObject) : new String(str));
                }
            } else if ("watermark".equals(str)) {
                a5.f();
            } else {
                String str3 = "Unknown video action: ";
                jSONObject = String.valueOf(str);
                kk.e(jSONObject.length() != 0 ? str3.concat(jSONObject) : new String(str3));
            }
        }
    }
}
