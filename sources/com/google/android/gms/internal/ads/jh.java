package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class jh implements zzb {
    private final Map<String, kg> a;
    private long b;
    private final File c;
    private final int d;

    public jh(File file) {
        this(file, 5242880);
    }

    private jh(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = 5242880;
    }

    static int a(InputStream inputStream) {
        return (((c(inputStream) | 0) | (c(inputStream) << 8)) | (c(inputStream) << 16)) | (c(inputStream) << 24);
    }

    private static InputStream a(File file) {
        return new FileInputStream(file);
    }

    static String a(lb lbVar) {
        return new String(a(lbVar, b((InputStream) lbVar)), "UTF-8");
    }

    static void a(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final synchronized void a(String str) {
        boolean delete = c(str).delete();
        d(str);
        if (!delete) {
            dc.b("Could not delete cache entry for key=%s, filename=%s", str, b(str));
        }
    }

    private final void a(String str, kg kgVar) {
        if (this.a.containsKey(str)) {
            kg kgVar2 = (kg) this.a.get(str);
            this.b = (kgVar.a - kgVar2.a) + this.b;
        } else {
            this.b += kgVar.a;
        }
        this.a.put(str, kgVar);
    }

    private static byte[] a(lb lbVar, long j) {
        long a = lbVar.a();
        if (j < 0 || j > a || ((long) ((int) j)) != j) {
            throw new IOException("streamToBytes length=" + j + ", maxLength=" + a);
        }
        byte[] bArr = new byte[((int) j)];
        new DataInputStream(lbVar).readFully(bArr);
        return bArr;
    }

    static long b(InputStream inputStream) {
        return (((((((0 | (((long) c(inputStream)) & 255)) | ((((long) c(inputStream)) & 255) << 8)) | ((((long) c(inputStream)) & 255) << 16)) | ((((long) c(inputStream)) & 255) << 24)) | ((((long) c(inputStream)) & 255) << 32)) | ((((long) c(inputStream)) & 255) << 40)) | ((((long) c(inputStream)) & 255) << 48)) | ((((long) c(inputStream)) & 255) << 56);
    }

    private static String b(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static List<akt> b(lb lbVar) {
        int a = a((InputStream) lbVar);
        List<akt> emptyList = a == 0 ? Collections.emptyList() : new ArrayList(a);
        for (int i = 0; i < a; i++) {
            emptyList.add(new akt(a(lbVar).intern(), a(lbVar).intern()));
        }
        return emptyList;
    }

    private static int c(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final File c(String str) {
        return new File(this.c, b(str));
    }

    private final void d(String str) {
        kg kgVar = (kg) this.a.remove(str);
        if (kgVar != null) {
            this.b -= kgVar.a;
        }
    }

    public final synchronized acs zza(String str) {
        acs acs;
        kg kgVar = (kg) this.a.get(str);
        if (kgVar == null) {
            acs = null;
        } else {
            File c = c(str);
            lb lbVar;
            try {
                lbVar = new lb(new BufferedInputStream(a(c)), c.length());
                if (TextUtils.equals(str, kg.a(lbVar).b)) {
                    byte[] a = a(lbVar, lbVar.a());
                    acs acs2 = new acs();
                    acs2.a = a;
                    acs2.b = kgVar.c;
                    acs2.c = kgVar.d;
                    acs2.d = kgVar.e;
                    acs2.e = kgVar.f;
                    acs2.f = kgVar.g;
                    List<akt> list = kgVar.h;
                    Map treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                    for (akt akt : list) {
                        treeMap.put(akt.a(), akt.b());
                    }
                    acs2.g = treeMap;
                    acs2.h = Collections.unmodifiableList(kgVar.h);
                    lbVar.close();
                    acs = acs2;
                } else {
                    dc.b("%s: key=%s, found=%s", c.getAbsolutePath(), str, kg.a(lbVar).b);
                    d(str);
                    lbVar.close();
                    acs = null;
                }
            } catch (IOException e) {
                dc.b("%s: %s", c.getAbsolutePath(), e.toString());
                a(str);
                acs = null;
            } catch (Throwable th) {
                lbVar.close();
            }
        }
        return acs;
    }

    public final synchronized void zza() {
        if (this.c.exists()) {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    lb lbVar;
                    try {
                        long length = file.length();
                        lbVar = new lb(new BufferedInputStream(a(file)), length);
                        kg a = kg.a(lbVar);
                        a.a = length;
                        a(a.b, a);
                        lbVar.close();
                    } catch (IOException e) {
                        file.delete();
                    } catch (Throwable th) {
                        lbVar.close();
                    }
                }
            }
        } else if (!this.c.mkdirs()) {
            dc.c("Unable to create cache dir %s", this.c.getAbsolutePath());
        }
    }

    public final synchronized void zza(String str, acs acs) {
        int i = 0;
        synchronized (this) {
            int length = acs.a.length;
            if (this.b + ((long) length) >= ((long) this.d)) {
                int i2;
                if (dc.a) {
                    dc.a("Pruning old cache entries.", new Object[0]);
                }
                long j = this.b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    kg kgVar = (kg) ((Entry) it.next()).getValue();
                    if (c(kgVar.b).delete()) {
                        this.b -= kgVar.a;
                    } else {
                        dc.b("Could not delete cache entry for key=%s, filename=%s", kgVar.b, b(kgVar.b));
                    }
                    it.remove();
                    i2 = i + 1;
                    if (((float) (this.b + ((long) length))) < ((float) this.d) * 0.9f) {
                        break;
                    }
                    i = i2;
                }
                i2 = i;
                if (dc.a) {
                    dc.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File c = c(str);
            try {
                OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c));
                kg kgVar2 = new kg(str, acs);
                if (kgVar2.a(bufferedOutputStream)) {
                    bufferedOutputStream.write(acs.a);
                    bufferedOutputStream.close();
                    a(str, kgVar2);
                } else {
                    bufferedOutputStream.close();
                    dc.b("Failed to write header for %s", c.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException e) {
                if (!c.delete()) {
                    dc.b("Could not clean up file %s", c.getAbsolutePath());
                }
            }
        }
    }
}
