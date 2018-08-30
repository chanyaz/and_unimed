package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.b;
import com.google.android.gms.measurement.c;
import java.io.IOException;
import java.util.Map;

public final class em extends hv implements zzeh {
    @VisibleForTesting
    private static int b = 65535;
    @VisibleForTesting
    private static int c = 2;
    private final Map<String, Map<String, String>> d = new a();
    private final Map<String, Map<String, Boolean>> e = new a();
    private final Map<String, Map<String, Boolean>> f = new a();
    private final Map<String, io> g = new a();
    private final Map<String, Map<String, Integer>> h = new a();
    private final Map<String, String> i = new a();

    em(hw hwVar) {
        super(hwVar);
    }

    @WorkerThread
    private final io a(String str, byte[] bArr) {
        if (bArr == null) {
            return new io();
        }
        h a = h.a(bArr, 0, bArr.length);
        p ioVar = new io();
        try {
            ioVar.a(a);
            zzge().y().a("Parsed config. version, gmp_app_id", ioVar.c, ioVar.d);
            return ioVar;
        } catch (IOException e) {
            zzge().u().a("Unable to merge remote config. appId", dp.a(str), e);
            return new io();
        }
    }

    private static Map<String, String> a(io ioVar) {
        Map<String, String> aVar = new a();
        if (!(ioVar == null || ioVar.e == null)) {
            for (ip ipVar : ioVar.e) {
                if (ipVar != null) {
                    aVar.put(ipVar.c, ipVar.d);
                }
            }
        }
        return aVar;
    }

    private final void a(String str, io ioVar) {
        Map aVar = new a();
        Map aVar2 = new a();
        Map aVar3 = new a();
        if (!(ioVar == null || ioVar.f == null)) {
            for (in inVar : ioVar.f) {
                if (TextUtils.isEmpty(inVar.c)) {
                    zzge().u().a("EventConfig contained null event name");
                } else {
                    Object a = com.google.android.gms.measurement.a.a(inVar.c);
                    if (!TextUtils.isEmpty(a)) {
                        inVar.c = a;
                    }
                    aVar.put(inVar.c, inVar.d);
                    aVar2.put(inVar.c, inVar.e);
                    if (inVar.f != null) {
                        if (inVar.f.intValue() < c || inVar.f.intValue() > b) {
                            zzge().u().a("Invalid sampling rate. Event name, sample rate", inVar.c, inVar.f);
                        } else {
                            aVar3.put(inVar.c, inVar.f);
                        }
                    }
                }
            }
        }
        this.e.put(str, aVar);
        this.f.put(str, aVar2);
        this.h.put(str, aVar3);
    }

    @WorkerThread
    private final void g(String str) {
        J();
        c();
        ar.a(str);
        if (this.g.get(str) == null) {
            byte[] d = a_().d(str);
            if (d == null) {
                this.d.put(str, null);
                this.e.put(str, null);
                this.f.put(str, null);
                this.g.put(str, null);
                this.i.put(str, null);
                this.h.put(str, null);
                return;
            }
            io a = a(str, d);
            this.d.put(str, a(a));
            a(str, a);
            this.g.put(str, a);
            this.i.put(str, null);
        }
    }

    @WorkerThread
    protected final io a(String str) {
        J();
        c();
        ar.a(str);
        g(str);
        return (io) this.g.get(str);
    }

    @WorkerThread
    final boolean a(String str, String str2) {
        c();
        g(str);
        if (e(str) && ie.h(str2)) {
            return true;
        }
        if (f(str) && ie.a(str2)) {
            return true;
        }
        Map map = (Map) this.e.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    protected final boolean a(String str, byte[] bArr, String str2) {
        J();
        c();
        ar.a(str);
        io a = a(str, bArr);
        if (a == null) {
            return false;
        }
        a(str, a);
        this.g.put(str, a);
        this.i.put(str, str2);
        this.d.put(str, a(a));
        hu b_ = b_();
        ih[] ihVarArr = a.g;
        ar.a((Object) ihVarArr);
        for (ih ihVar : ihVarArr) {
            for (ii iiVar : ihVar.e) {
                String a2 = com.google.android.gms.measurement.a.a(iiVar.d);
                if (a2 != null) {
                    iiVar.d = a2;
                }
                for (ij ijVar : iiVar.e) {
                    String a3 = b.a(ijVar.f);
                    if (a3 != null) {
                        ijVar.f = a3;
                    }
                }
            }
            for (il ilVar : ihVar.d) {
                String a4 = c.a(ilVar.d);
                if (a4 != null) {
                    ilVar.d = a4;
                }
            }
        }
        b_.a_().a(str, ihVarArr);
        try {
            a.g = null;
            byte[] bArr2 = new byte[a.d()];
            a.a(i.a(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzge().u().a("Unable to serialize reduced-size config. Storing full config instead. appId", dp.a(str), e);
        }
        fn a_ = a_();
        ar.a(str);
        a_.c();
        a_.J();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) a_.t().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                a_.zzge().r().a("Failed to update remote config (got 0). appId", dp.a(str));
            }
        } catch (SQLiteException e2) {
            a_.zzge().r().a("Error storing remote config. appId", dp.a(str), e2);
        }
        return true;
    }

    @WorkerThread
    protected final String b(String str) {
        c();
        return (String) this.i.get(str);
    }

    @WorkerThread
    final boolean b(String str, String str2) {
        c();
        g(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    final int c(String str, String str2) {
        c();
        g(str);
        Map map = (Map) this.h.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        return num == null ? 1 : num.intValue();
    }

    @WorkerThread
    protected final void c(String str) {
        c();
        this.i.put(str, null);
    }

    @WorkerThread
    final void d(String str) {
        c();
        this.g.remove(str);
    }

    final boolean e(String str) {
        return "1".equals(zze(str, "measurement.upload.blacklist_internal"));
    }

    final boolean f(String str) {
        return "1".equals(zze(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean p() {
        return false;
    }

    @WorkerThread
    public final String zze(String str, String str2) {
        c();
        g(str);
        Map map = (Map) this.d.get(str);
        return map != null ? (String) map.get(str2) : null;
    }
}
