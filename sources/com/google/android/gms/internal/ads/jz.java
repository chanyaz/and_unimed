package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzadh
public final class jz {
    private static Map<String, List<Map<String, Object>>> a = new HashMap();
    private static List<MediaCodecInfo> b;
    private static final Object c = new Object();

    @TargetApi(16)
    public static List<Map<String, Object>> a(String str) {
        Object e;
        synchronized (c) {
            if (a.containsKey(str)) {
                return (List) a.get(str);
            }
            try {
                int i;
                synchronized (c) {
                    if (b != null) {
                    } else {
                        if (VERSION.SDK_INT >= 21) {
                            b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else if (VERSION.SDK_INT >= 16) {
                            int codecCount = MediaCodecList.getCodecCount();
                            b = new ArrayList(codecCount);
                            for (i = 0; i < codecCount; i++) {
                                b.add(MediaCodecList.getCodecInfoAt(i));
                            }
                        } else {
                            b = Collections.emptyList();
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : b) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        Map hashMap = new HashMap();
                        hashMap.put("codecName", mediaCodecInfo.getName());
                        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        hashMap.put("profileLevels", arrayList2);
                        if (VERSION.SDK_INT >= 21) {
                            VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            hashMap.put("bitRatesBps", a(videoCapabilities.getBitrateRange()));
                            hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                            hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                            hashMap.put("frameRates", a(videoCapabilities.getSupportedFrameRates()));
                            hashMap.put("widths", a(videoCapabilities.getSupportedWidths()));
                            hashMap.put("heights", a(videoCapabilities.getSupportedHeights()));
                        }
                        if (VERSION.SDK_INT >= 23) {
                            hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        }
                        arrayList.add(hashMap);
                    }
                }
                a.put(str, arrayList);
                return arrayList;
            } catch (RuntimeException e2) {
                e = e2;
            } catch (LinkageError e3) {
                e = e3;
            }
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("error", e.getClass().getSimpleName());
        List arrayList3 = new ArrayList();
        arrayList3.add(hashMap2);
        a.put(str, arrayList3);
        return arrayList3;
    }

    @TargetApi(21)
    private static Integer[] a(Range<Integer> range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
