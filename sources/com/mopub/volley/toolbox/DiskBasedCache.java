package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Cache;
import com.mopub.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DiskBasedCache implements Cache {
    private final Map<String, a> a;
    private long b;
    private final File c;
    private final int d;

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    public DiskBasedCache(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = i;
    }

    static int a(InputStream inputStream) {
        return (((0 | (e(inputStream) << 0)) | (e(inputStream) << 8)) | (e(inputStream) << 16)) | (e(inputStream) << 24);
    }

    private String a(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void a(int i) {
        if (this.b + ((long) i) >= ((long) this.d)) {
            int i2;
            if (VolleyLog.DEBUG) {
                VolleyLog.v("Pruning old cache entries.", new Object[0]);
            }
            long j = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                a aVar = (a) ((Entry) it.next()).getValue();
                if (getFileForKey(aVar.key).delete()) {
                    this.b -= aVar.size;
                } else {
                    VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", aVar.key, a(aVar.key));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.b + ((long) i))) < ((float) this.d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (VolleyLog.DEBUG) {
                VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
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

    private void a(String str, a aVar) {
        if (this.a.containsKey(str)) {
            a aVar2 = (a) this.a.get(str);
            this.b = (aVar.size - aVar2.size) + this.b;
        } else {
            this.b += aVar.size;
        }
        this.a.put(str, aVar);
    }

    static void a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                a(outputStream, (String) entry.getKey());
                a(outputStream, (String) entry.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }

    private static byte[] a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long b(InputStream inputStream) {
        return (((((((0 | ((((long) e(inputStream)) & 255) << null)) | ((((long) e(inputStream)) & 255) << 8)) | ((((long) e(inputStream)) & 255) << 16)) | ((((long) e(inputStream)) & 255) << 24)) | ((((long) e(inputStream)) & 255) << 32)) | ((((long) e(inputStream)) & 255) << 40)) | ((((long) e(inputStream)) & 255) << 48)) | ((((long) e(inputStream)) & 255) << 56);
    }

    private void b(String str) {
        a aVar = (a) this.a.get(str);
        if (aVar != null) {
            this.b -= aVar.size;
            this.a.remove(str);
        }
    }

    static String c(InputStream inputStream) {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    static Map<String, String> d(InputStream inputStream) {
        int a = a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public synchronized void clear() {
        synchronized (this) {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
            this.a.clear();
            this.b = 0;
            VolleyLog.d("Cache cleared.", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066 A:{SYNTHETIC, Splitter: B:32:0x0066} */
    public synchronized com.mopub.volley.Cache.Entry get(java.lang.String r9) {
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r8.a;	 Catch:{ all -> 0x006a }
        r0 = r0.get(r9);	 Catch:{ all -> 0x006a }
        r0 = (com.mopub.volley.toolbox.a) r0;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x000f;
    L_0x000c:
        r0 = r1;
    L_0x000d:
        monitor-exit(r8);
        return r0;
    L_0x000f:
        r3 = r8.getFileForKey(r9);	 Catch:{ all -> 0x006a }
        r2 = new com.mopub.volley.toolbox.b;	 Catch:{ IOException -> 0x003d, all -> 0x0062 }
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x003d, all -> 0x0062 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x003d, all -> 0x0062 }
        r5 = 0;
        r2.<init>(r4);	 Catch:{ IOException -> 0x003d, all -> 0x0062 }
        com.mopub.volley.toolbox.a.readHeader(r2);	 Catch:{ IOException -> 0x0072 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0072 }
        r6 = r2.a;	 Catch:{ IOException -> 0x0072 }
        r6 = (long) r6;	 Catch:{ IOException -> 0x0072 }
        r4 = r4 - r6;
        r4 = (int) r4;	 Catch:{ IOException -> 0x0072 }
        r4 = a(r2, r4);	 Catch:{ IOException -> 0x0072 }
        r0 = r0.toCacheEntry(r4);	 Catch:{ IOException -> 0x0072 }
        if (r2 == 0) goto L_0x000d;
    L_0x0036:
        r2.close();	 Catch:{ IOException -> 0x003a }
        goto L_0x000d;
    L_0x003a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000d;
    L_0x003d:
        r0 = move-exception;
        r2 = r1;
    L_0x003f:
        r4 = "%s: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0070 }
        r6 = 0;
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0070 }
        r5[r6] = r3;	 Catch:{ all -> 0x0070 }
        r3 = 1;
        r0 = r0.toString();	 Catch:{ all -> 0x0070 }
        r5[r3] = r0;	 Catch:{ all -> 0x0070 }
        com.mopub.volley.VolleyLog.d(r4, r5);	 Catch:{ all -> 0x0070 }
        r8.remove(r9);	 Catch:{ all -> 0x0070 }
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        r2.close();	 Catch:{ IOException -> 0x005f }
    L_0x005d:
        r0 = r1;
        goto L_0x000d;
    L_0x005f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000d;
    L_0x0062:
        r0 = move-exception;
        r2 = r1;
    L_0x0064:
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.close();	 Catch:{ IOException -> 0x006d }
    L_0x0069:
        throw r0;	 Catch:{ all -> 0x006a }
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000d;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0064;
    L_0x0072:
        r0 = move-exception;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.DiskBasedCache.get(java.lang.String):com.mopub.volley.Cache$Entry");
    }

    public File getFileForKey(String str) {
        return new File(this.c, a(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A:{SYNTHETIC, Splitter: B:28:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0052 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A:{SYNTHETIC, Splitter: B:31:0x005f} */
    public synchronized void initialize() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.c;	 Catch:{ all -> 0x006c }
        r1 = r1.exists();	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.c;	 Catch:{ all -> 0x006c }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006c }
        r2 = 0;
        r3 = r9.c;	 Catch:{ all -> 0x006c }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006c }
        r1[r2] = r3;	 Catch:{ all -> 0x006c }
        com.mopub.volley.VolleyLog.e(r0, r1);	 Catch:{ all -> 0x006c }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.c;	 Catch:{ all -> 0x006c }
        r3 = r1.listFiles();	 Catch:{ all -> 0x006c }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x006c }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x006c }
        r1 = 0;
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r1 = com.mopub.volley.toolbox.a.readHeader(r0);	 Catch:{ IOException -> 0x0078 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0078 }
        r1.size = r6;	 Catch:{ IOException -> 0x0078 }
        r6 = r1.key;	 Catch:{ IOException -> 0x0078 }
        r9.a(r6, r1);	 Catch:{ IOException -> 0x0078 }
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.close();	 Catch:{ IOException -> 0x006f }
    L_0x0052:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0056:
        r0 = move-exception;
        r0 = r1;
    L_0x0058:
        if (r5 == 0) goto L_0x005d;
    L_0x005a:
        r5.delete();	 Catch:{ all -> 0x0073 }
    L_0x005d:
        if (r0 == 0) goto L_0x0052;
    L_0x005f:
        r0.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0052;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0065:
        r0 = move-exception;
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.close();	 Catch:{ IOException -> 0x0071 }
    L_0x006b:
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006f:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0071:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0073:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0066;
    L_0x0078:
        r1 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.DiskBasedCache.initialize():void");
    }

    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0;
            if (z) {
                entry.ttl = 0;
            }
            put(str, entry);
        }
    }

    public synchronized void put(String str, Cache.Entry entry) {
        a(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(fileForKey);
            a aVar = new a(str, entry);
            if (aVar.writeHeader(fileOutputStream)) {
                fileOutputStream.write(entry.data);
                fileOutputStream.close();
                a(str, aVar);
            } else {
                fileOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!fileForKey.delete()) {
                VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
            }
        }
    }

    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        b(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, a(str));
        }
    }
}
