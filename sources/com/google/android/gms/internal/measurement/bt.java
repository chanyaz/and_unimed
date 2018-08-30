package com.google.android.gms.internal.measurement;

import com.appnext.base.b.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.Map.Entry;

public class bt extends af {
    private static bt a;

    public bt(ah ahVar) {
        super(ahVar);
    }

    @VisibleForTesting
    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (!(valueOf instanceof Long)) {
            return valueOf instanceof Boolean ? String.valueOf(valueOf) : valueOf instanceof Throwable ? valueOf.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    public static bt b() {
        return a;
    }

    protected final void a() {
        synchronized (bt.class) {
            a = this;
        }
    }

    public final synchronized void a(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            ar.a((Object) str);
            if (i >= 0) {
                i2 = i;
            }
            int i3 = i2 >= 9 ? 8 : i2;
            char c = l().a() ? 'C' : 'c';
            char charAt = "01VDIWEA?".charAt(i3);
            String str2 = ag.a;
            String c2 = ae.c(str, a(obj), a(obj2), a(obj3));
            String stringBuilder = new StringBuilder((String.valueOf(str2).length() + 4) + String.valueOf(c2).length()).append("3").append(charAt).append(c).append(str2).append(":").append(c2).toString();
            if (stringBuilder.length() > c.jk) {
                stringBuilder = stringBuilder.substring(0, c.jk);
            }
            bx m = h().m();
            if (m != null) {
                m.g().a(stringBuilder);
            }
        }
    }

    public final void a(bp bpVar, String str) {
        Object bpVar2 = bpVar != null ? bpVar.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(str);
        d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), bpVar2);
    }

    public final void a(Map<String, String> map, String str) {
        Object stringBuilder;
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(str);
        d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }
}
