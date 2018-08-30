package com.mopub.common;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new OutputStream() {
        public void write(int i) {
        }
    };
    final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private long j = 0;
    private Writer k;
    private final LinkedHashMap<String, f> l = new LinkedHashMap(0, 0.75f, true);
    private int m;
    private long n = 0;
    private final Callable<Void> o = new Callable<Void>() {
        public Void call() {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.k == null) {
                } else {
                    DiskLruCache.this.g();
                    if (DiskLruCache.this.e()) {
                        DiskLruCache.this.d();
                        DiskLruCache.this.m = 0;
                    }
                }
            }
            return null;
        }
    };

    public final class Editor {
        private final f b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        private Editor(f fVar) {
            this.b = fVar;
            this.c = fVar.d ? null : new boolean[DiskLruCache.this.i];
        }

        /* synthetic */ Editor(DiskLruCache diskLruCache, f fVar, AnonymousClass1 anonymousClass1) {
            this(fVar);
        }

        public void abort() {
            DiskLruCache.this.a(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.e) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }

        public void commit() {
            if (this.d) {
                DiskLruCache.this.a(this, false);
                DiskLruCache.this.remove(this.b.b);
            } else {
                DiskLruCache.this.a(this, true);
            }
            this.e = true;
        }

        public String getString(int i) {
            InputStream newInputStream = newInputStream(i);
            return newInputStream != null ? DiskLruCache.b(newInputStream) : null;
        }

        public InputStream newInputStream(int i) {
            synchronized (DiskLruCache.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                } else if (this.b.d) {
                    try {
                        InputStream fileInputStream = new FileInputStream(this.b.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }

        public OutputStream newOutputStream(int i) {
            OutputStream a;
            synchronized (DiskLruCache.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                OutputStream fileOutputStream;
                if (!this.b.d) {
                    this.c[i] = true;
                }
                File dirtyFile = this.b.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e2) {
                        a = DiskLruCache.p;
                    }
                }
                a = new e(this, fileOutputStream, null);
            }
            return a;
        }

        public void set(int i, String str) {
            Throwable th;
            Closeable outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), DiskLruCacheUtil.b);
                try {
                    outputStreamWriter.write(str);
                    DiskLruCacheUtil.a(outputStreamWriter);
                } catch (Throwable th2) {
                    th = th2;
                    DiskLruCacheUtil.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                DiskLruCacheUtil.a(outputStreamWriter);
                throw th;
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        /* synthetic */ Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, long[] jArr, AnonymousClass1 anonymousClass1) {
            this(str, j, inputStreamArr, jArr);
        }

        public void close() {
            for (Closeable a : this.d) {
                DiskLruCacheUtil.a(a);
            }
        }

        public Editor edit() {
            return DiskLruCache.this.a(this.b, this.c);
        }

        public InputStream getInputStream(int i) {
            return this.d[i];
        }

        public long getLength(int i) {
            return this.e[i];
        }

        public String getString(int i) {
            return DiskLruCache.b(getInputStream(i));
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
    }

    private synchronized Editor a(String str, long j) {
        Editor editor;
        f();
        b(str);
        f fVar = (f) this.l.get(str);
        if (j == -1 || (fVar != null && fVar.f == j)) {
            f fVar2;
            if (fVar == null) {
                fVar = new f(this, str, null);
                this.l.put(str, fVar);
                fVar2 = fVar;
            } else if (fVar.e != null) {
                editor = null;
            } else {
                fVar2 = fVar;
            }
            editor = new Editor(this, fVar2, null);
            fVar2.e = editor;
            this.k.write("DIRTY " + str + 10);
            this.k.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    private synchronized void a(Editor editor, boolean z) {
        int i = 0;
        synchronized (this) {
            f a = editor.b;
            if (a.e != editor) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.d) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (!editor.c[i2]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.getDirtyFile(i2).exists()) {
                            editor.abort();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.i) {
                File dirtyFile = a.getDirtyFile(i);
                if (!z) {
                    a(dirtyFile);
                } else if (dirtyFile.exists()) {
                    File cleanFile = a.getCleanFile(i);
                    dirtyFile.renameTo(cleanFile);
                    long j = a.c[i];
                    long length = cleanFile.length();
                    a.c[i] = length;
                    this.j = (this.j - j) + length;
                }
                i++;
            }
            this.m++;
            a.e = null;
            if ((a.d | z) != 0) {
                a.d = true;
                this.k.write("CLEAN " + a.b + a.getLengths() + 10);
                if (z) {
                    long j2 = this.n;
                    this.n = 1 + j2;
                    a.f = j2;
                }
            } else {
                this.l.remove(a.b);
                this.k.write("REMOVE " + a.b + 10);
            }
            this.k.flush();
            if (this.j > this.h || e()) {
                this.b.submit(this.o);
            }
        }
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void a(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        f fVar = (f) this.l.get(str2);
        if (fVar == null) {
            fVar = new f(this, str2, null);
            this.l.put(str2, fVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            fVar.d = true;
            fVar.e = null;
            fVar.a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            fVar.e = new Editor(this, fVar, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static String b(InputStream inputStream) {
        return DiskLruCacheUtil.a(new InputStreamReader(inputStream, DiskLruCacheUtil.b));
    }

    private void b() {
        Closeable gVar = new g(new FileInputStream(this.d), DiskLruCacheUtil.a);
        int i;
        try {
            String readLine = gVar.readLine();
            String readLine2 = gVar.readLine();
            String readLine3 = gVar.readLine();
            String readLine4 = gVar.readLine();
            String readLine5 = gVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.g).equals(readLine3) && Integer.toString(this.i).equals(readLine4) && "".equals(readLine5)) {
                i = 0;
                while (true) {
                    a(gVar.readLine());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (EOFException e) {
            this.m = i - this.l.size();
            DiskLruCacheUtil.a(gVar);
        } catch (Throwable th) {
            DiskLruCacheUtil.a(gVar);
        }
    }

    private void b(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    private void c() {
        a(this.e);
        Iterator it = this.l.values().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            int i;
            if (fVar.e == null) {
                for (i = 0; i < this.i; i++) {
                    this.j += fVar.c[i];
                }
            } else {
                fVar.e = null;
                for (i = 0; i < this.i; i++) {
                    a(fVar.getCleanFile(i));
                    a(fVar.getDirtyFile(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void d() {
        if (this.k != null) {
            this.k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), DiskLruCacheUtil.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (f fVar : this.l.values()) {
                if (fVar.e != null) {
                    bufferedWriter.write("DIRTY " + fVar.b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + fVar.b + fVar.getLengths() + 10);
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), DiskLruCacheUtil.a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private boolean e() {
        return this.m >= 2000 && this.m >= this.l.size();
    }

    private void f() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void g() {
        while (this.j > this.h) {
            remove((String) ((Entry) this.l.entrySet().iterator().next()).getKey());
        }
    }

    public static DiskLruCache open(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.d.exists()) {
                try {
                    diskLruCache.b();
                    diskLruCache.c();
                    diskLruCache.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.d, true), DiskLruCacheUtil.a));
                    return diskLruCache;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j);
            diskLruCache.d();
            return diskLruCache;
        }
    }

    public synchronized void close() {
        if (this.k != null) {
            Iterator it = new ArrayList(this.l.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.e != null) {
                    fVar.e.abort();
                }
            }
            g();
            this.k.close();
            this.k = null;
        }
    }

    public void delete() {
        close();
        DiskLruCacheUtil.a(this.c);
    }

    public Editor edit(String str) {
        return a(str, -1);
    }

    public synchronized void flush() {
        f();
        g();
        this.k.flush();
    }

    public synchronized Snapshot get(String str) {
        Snapshot snapshot = null;
        synchronized (this) {
            f();
            b(str);
            f fVar = (f) this.l.get(str);
            if (fVar != null) {
                if (fVar.d) {
                    InputStream[] inputStreamArr = new InputStream[this.i];
                    int i = 0;
                    while (i < this.i) {
                        try {
                            inputStreamArr[i] = new FileInputStream(fVar.getCleanFile(i));
                            i++;
                        } catch (FileNotFoundException e) {
                            int i2 = 0;
                            while (i2 < this.i && inputStreamArr[i2] != null) {
                                DiskLruCacheUtil.a(inputStreamArr[i2]);
                                i2++;
                            }
                        }
                    }
                    this.m++;
                    this.k.append("READ " + str + 10);
                    if (e()) {
                        this.b.submit(this.o);
                    }
                    snapshot = new Snapshot(this, str, fVar.f, inputStreamArr, fVar.c, null);
                }
            }
        }
        return snapshot;
    }

    public File getDirectory() {
        return this.c;
    }

    public synchronized long getMaxSize() {
        return this.h;
    }

    public synchronized boolean isClosed() {
        return this.k == null;
    }

    public synchronized boolean remove(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            f();
            b(str);
            f fVar = (f) this.l.get(str);
            if (fVar == null || fVar.e != null) {
                z = false;
            } else {
                while (i < this.i) {
                    File cleanFile = fVar.getCleanFile(i);
                    if (!cleanFile.exists() || cleanFile.delete()) {
                        this.j -= fVar.c[i];
                        fVar.c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + cleanFile);
                    }
                }
                this.m++;
                this.k.append("REMOVE " + str + 10);
                this.l.remove(str);
                if (e()) {
                    this.b.submit(this.o);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized void setMaxSize(long j) {
        this.h = j;
        this.b.submit(this.o);
    }

    public synchronized long size() {
        return this.j;
    }
}
