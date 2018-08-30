package com.google.android.gms.internal.ads;

import android.os.Environment;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.zzhu.zza.zzb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class ahx {
    private final aib a;
    @GuardedBy("this")
    private final ain b;
    private final boolean c;

    private ahx() {
        this.c = false;
        this.a = new aib();
        this.b = new ain();
        b();
    }

    public ahx(aib aib) {
        this.a = aib;
        this.c = ((Boolean) akc.f().a(amn.db)).booleanValue();
        this.b = new ain();
        b();
    }

    public static ahx a() {
        return new ahx();
    }

    private final synchronized void b() {
        this.b.d = new aig();
        this.b.d.b = new aij();
        this.b.c = new ail();
    }

    private final synchronized void b(zzb zzb) {
        this.b.b = c();
        this.a.a(abj.a(this.b)).b(zzb.zzhq()).a();
        String str = "Logging Event with event code : ";
        String valueOf = String.valueOf(Integer.toString(zzb.zzhq(), 10));
        hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    private final synchronized void c(zzb zzb) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(d(zzb).getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        hl.a("Could not close Clearcut output stream.");
                    }
                } catch (IOException e2) {
                    hl.a("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        hl.a("Could not close Clearcut output stream.");
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        hl.a("Could not close Clearcut output stream.");
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e5) {
            hl.a("Could not find file for Clearcut");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static long[] c() {
        int i = 0;
        List<String> b = amn.b();
        List arrayList = new ArrayList();
        for (String split : b) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException e) {
                    hl.a("Experiment ID is not a number");
                }
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }

    private final synchronized String d(zzb zzb) {
        return String.format("id=%s,timestamp=%s,event=%s", new Object[]{this.b.a, Long.valueOf(au.l().elapsedRealtime()), Integer.valueOf(zzb.zzhq())});
    }

    public final synchronized void a(zzht zzht) {
        if (this.c) {
            try {
                zzht.zza(this.b);
            } catch (Throwable e) {
                au.i().a(e, "AdMobClearcutLogger.modify");
            }
        }
        return;
    }

    public final synchronized void a(zzb zzb) {
        if (this.c) {
            if (((Boolean) akc.f().a(amn.dc)).booleanValue()) {
                c(zzb);
            } else {
                b(zzb);
            }
        }
    }
}
