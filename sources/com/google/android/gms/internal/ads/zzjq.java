package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.j;

@zzadh
public final class zzjq {
    private final f[] a;
    private final String b;

    public zzjq(Context context, AttributeSet attributeSet) {
        Object obj = 1;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, j.AdsAttrs);
        String string = obtainAttributes.getString(j.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(j.AdsAttrs_adSizes);
        Object obj2 = !TextUtils.isEmpty(string) ? 1 : null;
        if (TextUtils.isEmpty(string2)) {
            obj = null;
        }
        if (obj2 != null && obj == null) {
            this.a = a(string);
        } else if (obj2 == null && obj != null) {
            this.a = a(string2);
        } else if (obj2 != null) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.b = obtainAttributes.getString(j.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static f[] a(String str) {
        String str2;
        String valueOf;
        String[] split = str.split("\\s*,\\s*");
        f[] fVarArr = new f[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    fVarArr[i] = new f("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    str2 = "Could not parse XML attribute \"adSize\": ";
                    valueOf = String.valueOf(trim);
                    throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            } else if ("BANNER".equals(trim)) {
                fVarArr[i] = f.a;
            } else if ("LARGE_BANNER".equals(trim)) {
                fVarArr[i] = f.c;
            } else if ("FULL_BANNER".equals(trim)) {
                fVarArr[i] = f.b;
            } else if ("LEADERBOARD".equals(trim)) {
                fVarArr[i] = f.d;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                fVarArr[i] = f.e;
            } else if ("SMART_BANNER".equals(trim)) {
                fVarArr[i] = f.g;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                fVarArr[i] = f.f;
            } else if ("FLUID".equals(trim)) {
                fVarArr[i] = f.h;
            } else if ("ICON".equals(trim)) {
                fVarArr[i] = f.i;
            } else {
                str2 = "Could not parse XML attribute \"adSize\": ";
                valueOf = String.valueOf(trim);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
        if (fVarArr.length != 0) {
            return fVarArr;
        }
        str2 = "Could not parse XML attribute \"adSize\": ";
        valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public final String a() {
        return this.b;
    }

    public final f[] a(boolean z) {
        if (z || this.a.length == 1) {
            return this.a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
