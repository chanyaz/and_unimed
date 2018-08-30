package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.m;
import java.util.HashMap;

@TargetApi(16)
public final class MediaCodecUtil {
    private static final HashMap<h, Pair<String, CodecCapabilities>> a = new HashMap();

    public class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isSecurePlaybackSupported(String str, CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    private MediaCodecUtil() {
    }

    private static Pair<String, CodecCapabilities> a(h hVar, MediaCodecListCompat mediaCodecListCompat) {
        try {
            return b(hVar, mediaCodecListCompat);
        } catch (Throwable e) {
            throw new DecoderQueryException(e);
        }
    }

    public static c a(String str, boolean z) {
        Pair b = b(str, z);
        return b == null ? null : new c((String) b.first, a((CodecCapabilities) b.second));
    }

    private static boolean a(CodecCapabilities codecCapabilities) {
        return m.a >= 19 ? b(codecCapabilities) : false;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        return (mediaCodecInfo.isEncoder() || !str.startsWith("OMX.")) ? false : (z || !str.endsWith(".secure")) ? (m.a == 16 && (("dlxu".equals(m.b) || "protou".equals(m.b) || "C6602".equals(m.b) || "C6603".equals(m.b)) && str.equals("OMX.qcom.audio.decoder.mp3"))) ? false : (m.a <= 19 && m.b != null && m.b.startsWith("serrano") && "samsung".equals(m.c) && str.equals("OMX.SEC.vp8.dec")) ? false : true : false;
    }

    private static Pair<String, CodecCapabilities> b(h hVar, MediaCodecListCompat mediaCodecListCompat) {
        String str = hVar.a;
        int codecCount = mediaCodecListCompat.getCodecCount();
        boolean secureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = mediaCodecListCompat.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            if (a(codecInfoAt, name, secureDecodersExplicit)) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String str2 : supportedTypes) {
                    if (str2.equalsIgnoreCase(str)) {
                        CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                        boolean isSecurePlaybackSupported = mediaCodecListCompat.isSecurePlaybackSupported(hVar.a, capabilitiesForType);
                        if (secureDecodersExplicit) {
                            a.put(hVar.b == isSecurePlaybackSupported ? hVar : new h(str, isSecurePlaybackSupported), Pair.create(name, capabilitiesForType));
                        } else {
                            Object hVar2;
                            HashMap hashMap = a;
                            if (hVar.b) {
                                hVar2 = new h(str, false);
                            } else {
                                h hVar22 = hVar;
                            }
                            hashMap.put(hVar22, Pair.create(name, capabilitiesForType));
                            if (isSecurePlaybackSupported) {
                                a.put(hVar.b ? hVar : new h(str, true), Pair.create(name + ".secure", capabilitiesForType));
                            }
                        }
                        if (a.containsKey(hVar)) {
                            return (Pair) a.get(hVar);
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static synchronized Pair<String, CodecCapabilities> b(String str, boolean z) {
        Pair<String, CodecCapabilities> pair;
        synchronized (MediaCodecUtil.class) {
            h hVar = new h(str, z);
            if (a.containsKey(hVar)) {
                pair = (Pair) a.get(hVar);
            } else {
                pair = a(hVar, m.a >= 21 ? new j(z) : new i());
                if (z && pair == null && m.a >= 21) {
                    Pair<String, CodecCapabilities> a = a(hVar, new i());
                    if (a != null) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((String) a.first));
                    }
                    pair = a;
                }
            }
        }
        return pair;
    }

    @TargetApi(19)
    private static boolean b(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }
}
