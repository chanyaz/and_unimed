package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;

@zzadh
public final class mz implements zzv<zzapw> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        Throwable e;
        zzapw zzapw = (zzapw) obj;
        if (((Boolean) akc.f().a(amn.bu)).booleanValue()) {
            oe oeVar;
            oe zztm = zzapw.zztm();
            if (zztm == null) {
                try {
                    zztm = new oe(zzapw, Float.parseFloat((String) map.get(VastIconXmlManager.DURATION)), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                    zzapw.zza(zztm);
                    oeVar = zztm;
                } catch (NullPointerException e2) {
                    e = e2;
                    kk.b("Unable to parse videoMeta message.", e);
                    au.i().a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    kk.b("Unable to parse videoMeta message.", e);
                    au.i().a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            }
            oeVar = zztm;
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int parseInt = Integer.parseInt((String) map.get("playbackState"));
            int i = (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
            String str = (String) map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (kk.a(3)) {
                kk.b(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(i).append(" , aspectRatio : ").append(str).toString());
            }
            oeVar.a(parseFloat, i, equals, parseFloat2);
        }
    }
}
