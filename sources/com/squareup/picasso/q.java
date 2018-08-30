package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class q implements Cache {
    final LinkedHashMap<String, Bitmap> b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public q(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.c = i;
        this.b = new LinkedHashMap(0, 0.75f, true);
    }

    public q(Context context) {
        this(ao.c(context));
    }

    /* JADX WARNING: Missing block: B:9:0x0031, code:
            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    private void a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r3.d;	 Catch:{ all -> 0x0032 }
        if (r0 <= r4) goto L_0x0041;
    L_0x0039:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r3.b;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0032 }
        r2 = r3.b;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r1 = r3.d;	 Catch:{ all -> 0x0032 }
        r0 = com.squareup.picasso.ao.a(r0);	 Catch:{ all -> 0x0032 }
        r0 = r1 - r0;
        r3.d = r0;	 Catch:{ all -> 0x0032 }
        r0 = r3.f;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r3.f = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.q.a(int):void");
    }

    public final void a() {
        a(-1);
    }

    public final synchronized void clear() {
        a();
    }

    public final synchronized void clearKeyUri(String str) {
        Object obj = null;
        synchronized (this) {
            int length = str.length();
            Iterator it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Object obj2;
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                Bitmap bitmap = (Bitmap) entry.getValue();
                int indexOf = str2.indexOf(10);
                if (indexOf == length && str2.substring(0, indexOf).equals(str)) {
                    it.remove();
                    this.d -= ao.a(bitmap);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                a(this.c);
            }
        }
    }

    public Bitmap get(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.b.get(str);
            if (bitmap != null) {
                this.g++;
                return bitmap;
            }
            this.h++;
            return null;
        }
    }

    public final synchronized int maxSize() {
        return this.c;
    }

    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.e++;
            this.d += ao.a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.b.put(str, bitmap);
            if (bitmap2 != null) {
                this.d -= ao.a(bitmap2);
            }
        }
        a(this.c);
    }

    public final synchronized int size() {
        return this.d;
    }
}
