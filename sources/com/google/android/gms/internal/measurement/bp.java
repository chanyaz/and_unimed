package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class bp {
    private final Map<String, String> a;
    private final List<zzbo> b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final String g;

    public bp(ae aeVar, Map<String, String> map, long j, boolean z) {
        this(aeVar, map, j, z, 0, 0, null);
    }

    public bp(ae aeVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(aeVar, map, j, z, j2, i, null);
    }

    public bp(ae aeVar, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbo> list) {
        CharSequence b;
        String a;
        String str = null;
        ar.a((Object) aeVar);
        ar.a((Object) map);
        this.d = j;
        this.f = z;
        this.c = j2;
        this.e = i;
        this.b = list != null ? list : Collections.emptyList();
        if (list != null) {
            for (zzbo zzbo : list) {
                if ("appendVersion".equals(zzbo.a())) {
                    b = zzbo.b();
                    break;
                }
            }
        }
        b = null;
        if (!TextUtils.isEmpty(b)) {
            CharSequence str2 = b;
        }
        this.g = str2;
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (a(entry.getKey())) {
                a = a(aeVar, entry.getKey());
                if (a != null) {
                    hashMap.put(a, b(aeVar, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!a(entry2.getKey())) {
                a = a(aeVar, entry2.getKey());
                if (a != null) {
                    hashMap.put(a, b(aeVar, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            cj.a(hashMap, "_v", this.g);
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.a = Collections.unmodifiableMap(hashMap);
    }

    private static String a(ae aeVar, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            aeVar.c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private final String a(String str, String str2) {
        ar.a(str);
        ar.b(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static boolean a(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String b(ae aeVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        aeVar.c("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    public final int a() {
        return this.e;
    }

    public final Map<String, String> b() {
        return this.a;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final List<zzbo> e() {
        return this.b;
    }

    public final boolean f() {
        return this.f;
    }

    public final long g() {
        return cj.a(a("_s", "0"));
    }

    public final String h() {
        return a("_m", "");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ht=").append(this.d);
        if (this.c != 0) {
            stringBuilder.append(", dbId=").append(this.c);
        }
        if (this.e != 0) {
            stringBuilder.append(", appUID=").append(this.e);
        }
        List arrayList = new ArrayList(this.a.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            stringBuilder.append(", ");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) this.a.get(str));
        }
        return stringBuilder.toString();
    }
}
