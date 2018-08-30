package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.a;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ag;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.ak;
import com.google.android.gms.internal.measurement.b;
import com.google.android.gms.internal.measurement.bp;
import com.google.android.gms.internal.measurement.cj;
import com.google.android.gms.internal.measurement.jc;
import com.google.android.gms.internal.measurement.jd;
import com.google.android.gms.internal.measurement.je;
import com.google.android.gms.internal.measurement.jr;
import com.google.android.gms.internal.measurement.ju;
import com.google.android.gms.internal.measurement.jz;
import com.google.android.gms.internal.measurement.t;
import com.google.android.gms.internal.measurement.u;
import com.google.android.gms.internal.measurement.v;
import com.google.android.gms.internal.measurement.w;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class l extends ae implements zzo {
    private static DecimalFormat a;
    private final ah b;
    private final String c;
    private final Uri d;

    public l(ah ahVar, String str) {
        this(ahVar, str, true, false);
    }

    private l(ah ahVar, String str, boolean z, boolean z2) {
        super(ahVar);
        ar.a(str);
        this.b = ahVar;
        this.c = str;
        this.d = a(this.c);
    }

    static Uri a(String str) {
        ar.a(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static String a(double d) {
        if (a == null) {
            a = new DecimalFormat("0.######");
        }
        return a.format(d);
    }

    @VisibleForTesting
    private static Map<String, String> a(q qVar) {
        String str;
        CharSequence a;
        Map hashMap = new HashMap();
        ju juVar = (ju) qVar.a(ju.class);
        if (juVar != null) {
            for (Entry entry : juVar.a().entrySet()) {
                Object str2;
                Boolean value = entry.getValue();
                if (value == null) {
                    str2 = null;
                } else if (value instanceof String) {
                    str2 = (String) value;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = null;
                    }
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    str2 = d.doubleValue() != 0.0d ? a(d.doubleValue()) : null;
                } else {
                    str2 = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (str2 != null) {
                    hashMap.put((String) entry.getKey(), str2);
                }
            }
        }
        t tVar = (t) qVar.a(t.class);
        if (tVar != null) {
            a(hashMap, "t", tVar.a());
            a(hashMap, "cid", tVar.b());
            a(hashMap, "uid", tVar.c());
            a(hashMap, "sc", tVar.f());
            a(hashMap, "sf", tVar.h());
            a(hashMap, "ni", tVar.g());
            a(hashMap, "adid", tVar.d());
            a(hashMap, "ate", tVar.e());
        }
        u uVar = (u) qVar.a(u.class);
        if (uVar != null) {
            a(hashMap, "cd", uVar.a());
            a(hashMap, "a", (double) uVar.b());
            a(hashMap, "dr", uVar.c());
        }
        b bVar = (b) qVar.a(b.class);
        if (bVar != null) {
            a(hashMap, "ec", bVar.a());
            a(hashMap, "ea", bVar.b());
            a(hashMap, "el", bVar.c());
            a(hashMap, "ev", (double) bVar.d());
        }
        jd jdVar = (jd) qVar.a(jd.class);
        if (jdVar != null) {
            a(hashMap, "cn", jdVar.a());
            a(hashMap, "cs", jdVar.b());
            a(hashMap, "cm", jdVar.c());
            a(hashMap, "ck", jdVar.d());
            a(hashMap, "cc", jdVar.e());
            a(hashMap, "ci", jdVar.f());
            a(hashMap, "anid", jdVar.g());
            a(hashMap, "gclid", jdVar.h());
            a(hashMap, "dclid", jdVar.i());
            a(hashMap, "aclid", jdVar.j());
        }
        com.google.android.gms.internal.measurement.l lVar = (com.google.android.gms.internal.measurement.l) qVar.a(com.google.android.gms.internal.measurement.l.class);
        if (lVar != null) {
            a(hashMap, "exd", lVar.a);
            a(hashMap, "exf", lVar.b);
        }
        v vVar = (v) qVar.a(v.class);
        if (vVar != null) {
            a(hashMap, "sn", vVar.a);
            a(hashMap, "sa", vVar.b);
            a(hashMap, "st", vVar.c);
        }
        w wVar = (w) qVar.a(w.class);
        if (wVar != null) {
            a(hashMap, "utv", wVar.a);
            a(hashMap, "utt", (double) wVar.b);
            a(hashMap, "utc", wVar.c);
            a(hashMap, "utl", wVar.d);
        }
        je jeVar = (je) qVar.a(je.class);
        if (jeVar != null) {
            for (Entry entry2 : jeVar.a().entrySet()) {
                a = n.a(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put(a, (String) entry2.getValue());
                }
            }
        }
        jr jrVar = (jr) qVar.a(jr.class);
        if (jrVar != null) {
            for (Entry entry22 : jrVar.a().entrySet()) {
                a = n.b(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put(a, a(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        a aVar = (a) qVar.a(a.class);
        if (aVar != null) {
            com.google.android.gms.analytics.a.b a2 = aVar.a();
            if (a2 != null) {
                for (Entry entry3 : a2.a().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (c a3 : aVar.d()) {
                hashMap.putAll(a3.a(n.f(i)));
                i++;
            }
            i = 1;
            for (com.google.android.gms.analytics.a.a a4 : aVar.b()) {
                hashMap.putAll(a4.a(n.d(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : aVar.c().entrySet()) {
                List<com.google.android.gms.analytics.a.a> list = (List) entry222.getValue();
                String i2 = n.i(i);
                int i3 = 1;
                for (com.google.android.gms.analytics.a.a a42 : list) {
                    String valueOf = String.valueOf(i2);
                    String valueOf2 = String.valueOf(n.g(i3));
                    hashMap.putAll(a42.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    String valueOf3 = String.valueOf(i2);
                    str2 = String.valueOf("nm");
                    hashMap.put(str2.length() != 0 ? valueOf3.concat(str2) : new String(valueOf3), (String) entry222.getKey());
                }
                i++;
            }
        }
        jz jzVar = (jz) qVar.a(jz.class);
        if (jzVar != null) {
            a(hashMap, "ul", jzVar.a());
            a(hashMap, "sd", (double) jzVar.a);
            a(hashMap, "sr", jzVar.b, jzVar.c);
            a(hashMap, "vp", jzVar.d, jzVar.e);
        }
        jc jcVar = (jc) qVar.a(jc.class);
        if (jcVar != null) {
            a(hashMap, "an", jcVar.a());
            a(hashMap, "aid", jcVar.c());
            a(hashMap, "aiid", jcVar.d());
            a(hashMap, "av", jcVar.b());
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, a(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public final void zzb(q qVar) {
        ar.a((Object) qVar);
        ar.b(qVar.f(), "Can't deliver not submitted measurement");
        ar.c("deliver should be called on worker thread");
        q a = qVar.a();
        t tVar = (t) a.b(t.class);
        if (TextUtils.isEmpty(tVar.a())) {
            h().a(a(a), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(tVar.b())) {
            h().a(a(a), "Ignoring measurement without client id");
        } else if (!this.b.j().e()) {
            double h = tVar.h();
            if (cj.a(h, tVar.b())) {
                b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(h));
                return;
            }
            Map a2 = a(a);
            a2.put("v", "1");
            a2.put("_v", ag.b);
            a2.put("tid", this.c);
            if (this.b.j().d()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : a2.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                c("Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString());
                return;
            }
            Map hashMap = new HashMap();
            cj.a(hashMap, "uid", tVar.c());
            jc jcVar = (jc) qVar.a(jc.class);
            if (jcVar != null) {
                cj.a(hashMap, "an", jcVar.a());
                cj.a(hashMap, "aid", jcVar.c());
                cj.a(hashMap, "av", jcVar.b());
                cj.a(hashMap, "aiid", jcVar.d());
            }
            a2.put("_s", String.valueOf(j().a(new ak(0, tVar.b(), this.c, !TextUtils.isEmpty(tVar.d()), 0, hashMap))));
            j().a(new bp(h(), a2, qVar.d(), true));
        }
    }

    public final Uri zzk() {
        return this.d;
    }
}
