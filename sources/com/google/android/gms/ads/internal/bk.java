package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class bk {
    private static String a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String a = obj == null ? "null" : obj instanceof Bundle ? a((Bundle) obj) : obj.toString();
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    public static Object[] a(String str, zzjj zzjj, String str2, int i, @Nullable zzjn zzjn) {
        Set hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzjj.b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(a(zzjj.c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzjj.d));
        }
        if (hashSet.contains("keywords")) {
            if (zzjj.e != null) {
                arrayList.add(zzjj.e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzjj.f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzjj.g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzjj.h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzjj.i);
        }
        if (hashSet.contains("location")) {
            if (zzjj.k != null) {
                arrayList.add(zzjj.k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzjj.l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(a(zzjj.m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(a(zzjj.n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzjj.o != null) {
                arrayList.add(zzjj.o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzjj.p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzjj.q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzjj.r));
        }
        return arrayList.toArray();
    }
}
