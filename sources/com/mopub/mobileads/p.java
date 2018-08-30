package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.CustomEventRewardedVideo.CustomEventRewardedVideoListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class p {
    @NonNull
    private final Map<String, CustomEventRewardedVideo> a = new TreeMap();
    @NonNull
    private final Map<String, MoPubReward> b = new TreeMap();
    @NonNull
    private final Map<Class<? extends CustomEventRewardedVideo>, MoPubReward> c = new HashMap();
    @NonNull
    private final Map<q, Set<String>> d = new HashMap();
    @NonNull
    private final Set<CustomEventRewardedVideoListener> e = new HashSet();
    @Nullable
    private String f;

    p() {
    }

    @Nullable
    MoPubReward a(@NonNull Class<? extends CustomEventRewardedVideo> cls) {
        return (MoPubReward) this.c.get(cls);
    }

    @Nullable
    CustomEventRewardedVideo a(@NonNull String str) {
        return (CustomEventRewardedVideo) this.a.get(str);
    }

    @Nullable
    String a() {
        return this.f;
    }

    @NonNull
    Set<String> a(@NonNull Class<? extends CustomEventRewardedVideo> cls, @Nullable String str) {
        if (str == null) {
            Set<String> hashSet = new HashSet();
            for (Entry entry : this.d.entrySet()) {
                if (cls == ((q) entry.getKey()).a) {
                    hashSet.addAll((Collection) entry.getValue());
                }
            }
            return hashSet;
        }
        q qVar = new q(cls, str);
        return this.d.containsKey(qVar) ? (Set) this.d.get(qVar) : Collections.emptySet();
    }

    void a(@NonNull Class<? extends CustomEventRewardedVideo> cls, @Nullable MoPubReward moPubReward) {
        Preconditions.checkNotNull(cls);
        this.c.put(cls, moPubReward);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    void a(@android.support.annotation.NonNull java.lang.Class<? extends com.mopub.mobileads.CustomEventRewardedVideo> r5, @android.support.annotation.NonNull java.lang.String r6, @android.support.annotation.NonNull java.lang.String r7) {
        /*
        r4 = this;
        r2 = new com.mopub.mobileads.q;
        r2.<init>(r5, r6);
        r0 = r4.d;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x000f:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x004b;
    L_0x0015:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.mopub.mobileads.q) r1;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x000f;
    L_0x0027:
        r1 = r0.getValue();
        r1 = (java.util.Set) r1;
        r1 = r1.contains(r7);
        if (r1 == 0) goto L_0x000f;
    L_0x0033:
        r1 = r0.getValue();
        r1 = (java.util.Set) r1;
        r1.remove(r7);
        r0 = r0.getValue();
        r0 = (java.util.Set) r0;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x004b;
    L_0x0048:
        r3.remove();
    L_0x004b:
        r0 = r4.d;
        r0 = r0.get(r2);
        r0 = (java.util.Set) r0;
        if (r0 != 0) goto L_0x005f;
    L_0x0055:
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = r4.d;
        r1.put(r2, r0);
    L_0x005f:
        r0.add(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.p.a(java.lang.Class, java.lang.String, java.lang.String):void");
    }

    void a(@NonNull String str, @NonNull CustomEventRewardedVideo customEventRewardedVideo, @Nullable CustomEventRewardedVideoListener customEventRewardedVideoListener, @NonNull String str2) {
        this.a.put(str, customEventRewardedVideo);
        this.e.add(customEventRewardedVideoListener);
        a(customEventRewardedVideo.getClass(), str2, str);
    }

    void a(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        if (str2 == null || str3 == null) {
            this.b.remove(str);
            return;
        }
        try {
            int parseInt = Integer.parseInt(str3);
            if (parseInt >= 0) {
                this.b.put(str, MoPubReward.success(str2, parseInt));
            }
        } catch (NumberFormatException e) {
        }
    }

    @Nullable
    MoPubReward b(@Nullable String str) {
        return (MoPubReward) this.b.get(str);
    }

    void c(@Nullable String str) {
        this.f = str;
    }
}
