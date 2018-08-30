package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VastXmlManagerAggregator extends AsyncTask<String, Void, VastVideoConfig> {
    public static final String ADS_BY_AD_SLOT_ID = "adsBy";
    public static final String SOCIAL_ACTIONS_AD_SLOT_ID = "socialActions";
    private static final List<String> a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});
    @NonNull
    private final WeakReference<VastXmlManagerAggregatorListener> b;
    private final double c;
    private final int d;
    @NonNull
    private final Context e;
    private int f;

    interface VastXmlManagerAggregatorListener {
        void onAggregationComplete(@Nullable VastVideoConfig vastVideoConfig);
    }

    VastXmlManagerAggregator(@NonNull VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener, double d, int i, @NonNull Context context) {
        Preconditions.checkNotNull(vastXmlManagerAggregatorListener);
        Preconditions.checkNotNull(context);
        this.b = new WeakReference(vastXmlManagerAggregatorListener);
        this.c = d;
        this.d = i;
        this.e = context.getApplicationContext();
    }

    private double a(int i, int i2) {
        return (Math.abs(Math.log((((double) i) / ((double) i2)) / this.c)) * 70.0d) + (Math.abs(Math.log(((double) (i * i2)) / ((double) this.d))) * 30.0d);
    }

    @Nullable
    private VastVideoConfig a(@NonNull w wVar, @NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(wVar);
        Preconditions.checkNotNull(list);
        for (x xVar : wVar.c()) {
            String a = a(xVar.k());
            if (a != null) {
                VastVideoConfig vastVideoConfig = new VastVideoConfig();
                vastVideoConfig.addImpressionTrackers(wVar.a());
                a(xVar, vastVideoConfig);
                vastVideoConfig.setClickThroughUrl(xVar.h());
                vastVideoConfig.setNetworkMediaFileUrl(a);
                List d = wVar.d();
                vastVideoConfig.setVastCompanionAd(a(d, ag.LANDSCAPE), a(d, ag.PORTRAIT));
                vastVideoConfig.setSocialActionsCompanionAds(b(d));
                list.addAll(wVar.b());
                vastVideoConfig.addErrorTrackers(list);
                a((t) wVar, vastVideoConfig);
                return vastVideoConfig;
            }
        }
        return null;
    }

    @Nullable
    private String a(@NonNull ae aeVar, @NonNull List<VastTracker> list) {
        String str = null;
        String f = aeVar.f();
        if (f == null) {
            return str;
        }
        try {
            return b(f);
        } catch (Throwable e) {
            MoPubLog.d("Failed to follow VAST redirect", e);
            if (list.isEmpty()) {
                return str;
            }
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.WRAPPER_TIMEOUT, str, str, this.e);
            return str;
        }
    }

    private void a(@NonNull af afVar, @NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(afVar, "xmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addImpressionTrackers(afVar.c());
        if (vastVideoConfig.getCustomCtaText() == null) {
            vastVideoConfig.setCustomCtaText(afVar.d());
        }
        if (vastVideoConfig.getCustomSkipText() == null) {
            vastVideoConfig.setCustomSkipText(afVar.e());
        }
        if (vastVideoConfig.getCustomCloseIconUrl() == null) {
            vastVideoConfig.setCustomCloseIconUrl(afVar.f());
        }
        if (!vastVideoConfig.isCustomForceOrientationSet()) {
            vastVideoConfig.setCustomForceOrientation(afVar.g());
        }
    }

    private void a(@NonNull t tVar, @NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(tVar);
        Preconditions.checkNotNull(vastVideoConfig);
        if (vastVideoConfig.getVideoViewabilityTracker() == null) {
            VastExtensionParentXmlManager e = tVar.e();
            if (e != null) {
                for (VastExtensionXmlManager vastExtensionXmlManager : e.a()) {
                    if ("MoPub".equals(vastExtensionXmlManager.b())) {
                        vastVideoConfig.setVideoViewabilityTracker(vastExtensionXmlManager.a());
                        return;
                    }
                }
            }
        }
    }

    private void a(@NonNull x xVar, @NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(xVar, "linearXmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addAbsoluteTrackers(xVar.b());
        vastVideoConfig.addFractionalTrackers(xVar.a());
        vastVideoConfig.addPauseTrackers(xVar.d());
        vastVideoConfig.addResumeTrackers(xVar.e());
        vastVideoConfig.addCompleteTrackers(xVar.c());
        vastVideoConfig.addCloseTrackers(xVar.f());
        vastVideoConfig.addSkipTrackers(xVar.g());
        vastVideoConfig.addClickTrackers(xVar.i());
        if (vastVideoConfig.getSkipOffsetString() == null) {
            vastVideoConfig.setSkipOffset(xVar.j());
        }
        if (vastVideoConfig.getVastIconConfig() == null) {
            vastVideoConfig.setVastIconConfig(c(xVar.l()));
        }
    }

    static boolean a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean a(@NonNull List<s> list, @NonNull af afVar, @NonNull Context context) {
        if (!list.isEmpty() || afVar.b() == null) {
            return false;
        }
        TrackingRequest.makeVastTrackingHttpRequest(Collections.singletonList(afVar.b()), this.f > 0 ? VastErrorCode.NO_ADS_VAST_RESPONSE : VastErrorCode.UNDEFINED_ERROR, null, null, context);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    @android.support.annotation.Nullable
    private java.lang.String b(@android.support.annotation.NonNull java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        com.mopub.common.Preconditions.checkNotNull(r6);
        r1 = r5.f;
        r2 = 10;
        if (r1 >= r2) goto L_0x0029;
    L_0x000a:
        r1 = r5.f;
        r1 = r1 + 1;
        r5.f = r1;
        r2 = com.mopub.common.MoPubHttpUrlConnection.getHttpUrlConnection(r6);	 Catch:{ all -> 0x002a }
        r1 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x0038 }
        r3 = r2.getInputStream();	 Catch:{ all -> 0x0038 }
        r1.<init>(r3);	 Catch:{ all -> 0x0038 }
        r0 = com.mopub.common.util.Strings.fromStream(r1);	 Catch:{ all -> 0x003d }
        com.mopub.common.util.Streams.closeStream(r1);
        if (r2 == 0) goto L_0x0029;
    L_0x0026:
        r2.disconnect();
    L_0x0029:
        return r0;
    L_0x002a:
        r1 = move-exception;
        r2 = r0;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x002f:
        com.mopub.common.util.Streams.closeStream(r1);
        if (r2 == 0) goto L_0x0037;
    L_0x0034:
        r2.disconnect();
    L_0x0037:
        throw r0;
    L_0x0038:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002f;
    L_0x003d:
        r0 = move-exception;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastXmlManagerAggregator.b(java.lang.String):java.lang.String");
    }

    @NonNull
    @VisibleForTesting
    Point a(int i, int i2, ac acVar, ag agVar) {
        int max;
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) this.e.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int dipsToIntPixels = Dips.dipsToIntPixels((float) i, this.e);
        int dipsToIntPixels2 = Dips.dipsToIntPixels((float) i2, this.e);
        if (ag.LANDSCAPE == agVar) {
            max = Math.max(width, height);
            height = Math.min(width, height);
            width = max;
            max = height;
        } else {
            max = Math.min(width, height);
            height = Math.max(width, height);
            width = max;
            max = height;
        }
        if (dipsToIntPixels <= width - 16 && dipsToIntPixels2 <= max - 16) {
            return point;
        }
        Point point2 = new Point();
        if (ac.HTML_RESOURCE == acVar) {
            point2.x = Math.min(width, dipsToIntPixels);
            point2.y = Math.min(max, dipsToIntPixels2);
        } else {
            float f = ((float) dipsToIntPixels) / ((float) width);
            float f2 = ((float) dipsToIntPixels2) / ((float) max);
            if (f >= f2) {
                point2.x = width;
                point2.y = (int) (((float) dipsToIntPixels2) / f);
            } else {
                point2.x = (int) (((float) dipsToIntPixels) / f2);
                point2.y = max;
            }
        }
        point2.x -= 16;
        point2.y -= 16;
        if (point2.x < 0 || point2.y < 0) {
            return point;
        }
        point2.x = Dips.pixelsToIntDips((float) point2.x, this.e);
        point2.y = Dips.pixelsToIntDips((float) point2.y, this.e);
        return point2;
    }

    @Nullable
    @VisibleForTesting
    VastCompanionAdConfig a(@NonNull List<u> list, @NonNull ag agVar) {
        aa aaVar;
        u uVar;
        Preconditions.checkNotNull(list, "managers cannot be null");
        Preconditions.checkNotNull(agVar, "orientation cannot be null");
        List<u> arrayList = new ArrayList(list);
        double d = Double.POSITIVE_INFINITY;
        u uVar2 = null;
        aa aaVar2 = null;
        Point point = null;
        ac[] values = ac.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                aaVar = aaVar2;
                uVar = uVar2;
                break;
            }
            ac acVar = values[i2];
            for (u uVar3 : arrayList) {
                Integer a = uVar3.a();
                Integer b = uVar3.b();
                if (a != null && a.intValue() >= 300 && b != null && b.intValue() >= 250) {
                    Point a2 = a(a.intValue(), b.intValue(), acVar, agVar);
                    aaVar = aa.a(uVar3.d(), acVar, a2.x, a2.y);
                    if (aaVar != null) {
                        u uVar4;
                        double d2;
                        Point point2;
                        aa aaVar3;
                        double a3 = ag.PORTRAIT == agVar ? a(b.intValue(), a.intValue()) : a(a.intValue(), b.intValue());
                        if (a3 < d) {
                            uVar4 = uVar3;
                            d2 = a3;
                            point2 = a2;
                            aaVar3 = aaVar;
                        } else {
                            point2 = point;
                            aaVar3 = aaVar2;
                            uVar4 = uVar2;
                            d2 = d;
                        }
                        d = d2;
                        aaVar2 = aaVar3;
                        uVar2 = uVar4;
                        point = point2;
                    }
                }
            }
            if (uVar2 != null) {
                aaVar = aaVar2;
                uVar = uVar2;
                break;
            }
            i = i2 + 1;
        }
        return uVar != null ? new VastCompanionAdConfig(point.x, point.y, aaVar, uVar.e(), uVar.f(), uVar.g()) : null;
    }

    @Nullable
    @VisibleForTesting
    VastVideoConfig a(@NonNull String str, @NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(str, "vastXml cannot be null");
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        af afVar = new af();
        try {
            afVar.a(str);
            List<s> a = afVar.a();
            if (a(a, afVar, this.e)) {
                return null;
            }
            for (s sVar : a) {
                if (a(sVar.c())) {
                    VastVideoConfig a2;
                    w a3 = sVar.a();
                    if (a3 != null) {
                        a2 = a(a3, (List) list);
                        if (a2 != null) {
                            a(afVar, a2);
                            return a2;
                        }
                    }
                    t b = sVar.b();
                    if (b != null) {
                        List arrayList = new ArrayList(list);
                        arrayList.addAll(b.b());
                        String a4 = a((ae) b, arrayList);
                        if (a4 != null) {
                            a2 = a(a4, arrayList);
                            if (a2 != null) {
                                a2.addImpressionTrackers(b.a());
                                for (x a5 : b.c()) {
                                    a(a5, a2);
                                }
                                a(b, a2);
                                List<u> d = b.d();
                                if (a2.hasCompanionAd()) {
                                    VastCompanionAdConfig vastCompanionAd = a2.getVastCompanionAd(2);
                                    VastCompanionAdConfig vastCompanionAd2 = a2.getVastCompanionAd(1);
                                    if (!(vastCompanionAd == null || vastCompanionAd2 == null)) {
                                        for (u uVar : d) {
                                            if (!uVar.h()) {
                                                vastCompanionAd.addClickTrackers(uVar.f());
                                                vastCompanionAd.addCreativeViewTrackers(uVar.g());
                                                vastCompanionAd2.addClickTrackers(uVar.f());
                                                vastCompanionAd2.addCreativeViewTrackers(uVar.g());
                                            }
                                        }
                                    }
                                } else {
                                    a2.setVastCompanionAd(a((List) d, ag.LANDSCAPE), a((List) d, ag.PORTRAIT));
                                }
                                if (a2.getSocialActionsCompanionAds().isEmpty()) {
                                    a2.setSocialActionsCompanionAds(b((List) d));
                                }
                                a(afVar, a2);
                                return a2;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        } catch (Throwable e) {
            MoPubLog.d("Failed to parse VAST XML", e);
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.XML_PARSING_ERROR, null, null, this.e);
            return null;
        }
    }

    /* renamed from: a */
    protected VastVideoConfig doInBackground(@Nullable String... strArr) {
        VastVideoConfig vastVideoConfig = null;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return vastVideoConfig;
        }
        try {
            return a(strArr[0], new ArrayList());
        } catch (Throwable e) {
            MoPubLog.d("Unable to generate VastVideoConfig.", e);
            return vastVideoConfig;
        }
    }

    @Nullable
    @VisibleForTesting
    String a(@NonNull List<z> list) {
        Preconditions.checkNotNull(list, "managers cannot be null");
        double d = Double.POSITIVE_INFINITY;
        String str = null;
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            String c = zVar.c();
            String d2 = zVar.d();
            if (!a.contains(c) || d2 == null) {
                it.remove();
            } else {
                Integer a = zVar.a();
                Integer b = zVar.b();
                if (a != null && a.intValue() > 0 && b != null && b.intValue() > 0) {
                    String str2;
                    double d3;
                    double a2 = a(a.intValue(), b.intValue());
                    if (a2 < d) {
                        str2 = d2;
                        d3 = a2;
                    } else {
                        str2 = str;
                        d3 = d;
                    }
                    d = d3;
                    str = str2;
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    protected void onPostExecute(@Nullable VastVideoConfig vastVideoConfig) {
        VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener = (VastXmlManagerAggregatorListener) this.b.get();
        if (vastXmlManagerAggregatorListener != null) {
            vastXmlManagerAggregatorListener.onAggregationComplete(vastVideoConfig);
        }
    }

    @NonNull
    @VisibleForTesting
    Map<String, VastCompanionAdConfig> b(@NonNull List<u> list) {
        Preconditions.checkNotNull(list, "managers cannot be null");
        Map<String, VastCompanionAdConfig> hashMap = new HashMap();
        for (u uVar : list) {
            Integer a = uVar.a();
            Integer b = uVar.b();
            if (!(a == null || b == null)) {
                String c = uVar.c();
                if (ADS_BY_AD_SLOT_ID.equals(c)) {
                    if (a.intValue() >= 25) {
                        if (a.intValue() <= 75) {
                            if (b.intValue() >= 10) {
                                if (b.intValue() > 50) {
                                }
                            }
                        }
                    }
                } else if (SOCIAL_ACTIONS_AD_SLOT_ID.equals(c) && a.intValue() >= 50 && a.intValue() <= 150 && b.intValue() >= 10) {
                    if (b.intValue() > 50) {
                    }
                }
                aa a2 = aa.a(uVar.d(), ac.HTML_RESOURCE, a.intValue(), b.intValue());
                if (a2 != null) {
                    hashMap.put(c, new VastCompanionAdConfig(a.intValue(), b.intValue(), a2, uVar.e(), uVar.f(), uVar.g()));
                }
            }
        }
        return hashMap;
    }

    @Nullable
    @VisibleForTesting
    v c(@NonNull List<VastIconXmlManager> list) {
        Preconditions.checkNotNull(list, "managers cannot be null");
        List<VastIconXmlManager> arrayList = new ArrayList(list);
        for (ac acVar : ac.values()) {
            for (VastIconXmlManager vastIconXmlManager : arrayList) {
                Integer a = vastIconXmlManager.a();
                Integer b = vastIconXmlManager.b();
                if (a != null && a.intValue() > 0 && a.intValue() <= 300 && b != null && b.intValue() > 0 && b.intValue() <= 300) {
                    aa a2 = aa.a(vastIconXmlManager.e(), acVar, a.intValue(), b.intValue());
                    if (a2 != null) {
                        return new v(vastIconXmlManager.a().intValue(), vastIconXmlManager.b().intValue(), vastIconXmlManager.c(), vastIconXmlManager.d(), a2, vastIconXmlManager.f(), vastIconXmlManager.g(), vastIconXmlManager.h());
                    }
                }
            }
        }
        return null;
    }

    protected void onCancelled() {
        VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener = (VastXmlManagerAggregatorListener) this.b.get();
        if (vastXmlManagerAggregatorListener != null) {
            vastXmlManagerAggregatorListener.onAggregationComplete(null);
        }
    }

    protected void onPreExecute() {
        Networking.getUserAgent(this.e);
    }
}
