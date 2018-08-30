package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.NativeImageHelper.ImageListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class e extends StaticNativeAd {
    @NonNull
    private final Context a;
    @NonNull
    private final CustomEventNativeListener b;
    @NonNull
    private final JSONObject c;
    @NonNull
    private final ImpressionTracker d;
    @NonNull
    private final NativeClickHandler e;

    e(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull ImpressionTracker impressionTracker, @NonNull NativeClickHandler nativeClickHandler, @NonNull CustomEventNativeListener customEventNativeListener) {
        this.c = jSONObject;
        this.a = context.getApplicationContext();
        this.d = impressionTracker;
        this.e = nativeClickHandler;
        this.b = customEventNativeListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    private void a(@android.support.annotation.NonNull com.mopub.nativeads.f r3, @android.support.annotation.Nullable java.lang.Object r4) {
        /*
        r2 = this;
        r0 = com.mopub.nativeads.MoPubCustomEventNative.AnonymousClass1.a;	 Catch:{ ClassCastException -> 0x002a }
        r1 = r3.ordinal();	 Catch:{ ClassCastException -> 0x002a }
        r0 = r0[r1];	 Catch:{ ClassCastException -> 0x002a }
        switch(r0) {
            case 1: goto L_0x0024;
            case 2: goto L_0x0048;
            case 3: goto L_0x004e;
            case 4: goto L_0x0052;
            case 5: goto L_0x0058;
            case 6: goto L_0x005c;
            case 7: goto L_0x0062;
            case 8: goto L_0x0068;
            case 9: goto L_0x006e;
            default: goto L_0x000b;
        };	 Catch:{ ClassCastException -> 0x002a }
    L_0x000b:
        r0 = new java.lang.StringBuilder;	 Catch:{ ClassCastException -> 0x002a }
        r0.<init>();	 Catch:{ ClassCastException -> 0x002a }
        r1 = "Unable to add JSON key to internal mapping: ";
        r0 = r0.append(r1);	 Catch:{ ClassCastException -> 0x002a }
        r1 = r3.a;	 Catch:{ ClassCastException -> 0x002a }
        r0 = r0.append(r1);	 Catch:{ ClassCastException -> 0x002a }
        r0 = r0.toString();	 Catch:{ ClassCastException -> 0x002a }
        com.mopub.common.logging.MoPubLog.d(r0);	 Catch:{ ClassCastException -> 0x002a }
    L_0x0023:
        return;
    L_0x0024:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setMainImageUrl(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x002a:
        r0 = move-exception;
        r1 = r3.b;
        if (r1 != 0) goto L_0x0076;
    L_0x002f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Ignoring class cast exception for optional key: ";
        r0 = r0.append(r1);
        r1 = r3.a;
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.mopub.common.logging.MoPubLog.d(r0);
        goto L_0x0023;
    L_0x0048:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setIconImageUrl(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x004e:
        r2.a(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x0052:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setClickDestinationUrl(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x0058:
        r2.c(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x005c:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setCallToAction(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x0062:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setTitle(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x0068:
        r4 = (java.lang.String) r4;	 Catch:{ ClassCastException -> 0x002a }
        r2.setText(r4);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x006e:
        r0 = com.mopub.common.util.Numbers.parseDouble(r4);	 Catch:{ ClassCastException -> 0x002a }
        r2.setStarRating(r0);	 Catch:{ ClassCastException -> 0x002a }
        goto L_0x0023;
    L_0x0076:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.e.a(com.mopub.nativeads.f, java.lang.Object):void");
    }

    private boolean a(@Nullable String str) {
        return str != null && str.toLowerCase(Locale.US).endsWith("image");
    }

    private boolean a(@NonNull JSONObject jSONObject) {
        Set hashSet = new HashSet();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet.containsAll(f.c);
    }

    private void c(@NonNull Object obj) {
        if (obj instanceof JSONArray) {
            b(obj);
        } else {
            addClickTracker((String) obj);
        }
    }

    public void clear(@NonNull View view) {
        this.d.removeView(view);
        this.e.clearOnClickListener(view);
    }

    public void destroy() {
        this.d.destroy();
    }

    void e() {
        if (a(this.c)) {
            Iterator keys = this.c.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                f a = f.a(str);
                if (a != null) {
                    try {
                        a(a, this.c.opt(str));
                    } catch (ClassCastException e) {
                        throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
                    }
                }
                addExtra(str, this.c.opt(str));
            }
            setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
            NativeImageHelper.preCacheImages(this.a, g(), new ImageListener() {
                public void onImagesCached() {
                    e.this.b.onNativeAdLoaded(e.this);
                }

                public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
                    e.this.b.onNativeAdFailed(nativeErrorCode);
                }
            });
            return;
        }
        throw new IllegalArgumentException("JSONObject did not contain required keys.");
    }

    @NonNull
    List<String> f() {
        List<String> arrayList = new ArrayList(getExtras().size());
        for (Entry entry : getExtras().entrySet()) {
            if (a((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                arrayList.add((String) entry.getValue());
            }
        }
        return arrayList;
    }

    @NonNull
    List<String> g() {
        List<String> arrayList = new ArrayList();
        if (getMainImageUrl() != null) {
            arrayList.add(getMainImageUrl());
        }
        if (getIconImageUrl() != null) {
            arrayList.add(getIconImageUrl());
        }
        arrayList.addAll(f());
        return arrayList;
    }

    public void handleClick(@Nullable View view) {
        b();
        this.e.openClickDestinationUrl(getClickDestinationUrl(), view);
    }

    public void prepare(@NonNull View view) {
        this.d.addView(view, this);
        this.e.setOnClickListener(view, this);
    }

    public void recordImpression(@NonNull View view) {
        a();
    }
}
