package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.b;
import java.util.Arrays;

public final class d implements Allocator {
    private final int a;
    private final byte[] b;
    private int c;
    private int d;
    private a[] e;

    public d(int i) {
        this(i, 0);
    }

    public d(int i, int i2) {
        boolean z = true;
        int i3 = 0;
        b.a(i > 0);
        if (i2 < 0) {
            z = false;
        }
        b.a(z);
        this.a = i;
        this.d = i2;
        this.e = new a[(i2 + 100)];
        if (i2 > 0) {
            this.b = new byte[(i2 * i)];
            while (i3 < i2) {
                this.e[i3] = new a(this.b, i3 * i);
                i3++;
            }
            return;
        }
        this.b = null;
    }

    public synchronized a allocate() {
        a aVar;
        this.c++;
        if (this.d > 0) {
            a[] aVarArr = this.e;
            int i = this.d - 1;
            this.d = i;
            aVar = aVarArr[i];
            this.e[this.d] = null;
        } else {
            aVar = new a(new byte[this.a], 0);
        }
        return aVar;
    }

    public synchronized void blockWhileTotalBytesAllocatedExceeds(int i) {
        while (getTotalBytesAllocated() > i) {
            wait();
        }
    }

    public int getIndividualAllocationLength() {
        return this.a;
    }

    public synchronized int getTotalBytesAllocated() {
        return this.c * this.a;
    }

    public synchronized void release(a aVar) {
        boolean z = aVar.a == this.b || aVar.a.length == this.a;
        b.a(z);
        this.c--;
        if (this.d == this.e.length) {
            this.e = (a[]) Arrays.copyOf(this.e, this.e.length * 2);
        }
        a[] aVarArr = this.e;
        int i = this.d;
        this.d = i + 1;
        aVarArr[i] = aVar;
        notifyAll();
    }

    /* JADX WARNING: Missing block: B:20:0x004f, code:
            if (r0 < r7.d) goto L_0x0051;
     */
    public synchronized void trim(int r8) {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        r0 = r7.a;	 Catch:{ all -> 0x005c }
        r0 = com.google.android.exoplayer.util.m.a(r8, r0);	 Catch:{ all -> 0x005c }
        r2 = 0;
        r3 = r7.c;	 Catch:{ all -> 0x005c }
        r0 = r0 - r3;
        r3 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x005c }
        r0 = r7.d;	 Catch:{ all -> 0x005c }
        if (r3 < r0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r7);
        return;
    L_0x0016:
        r0 = r7.b;	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x005f;
    L_0x001a:
        r0 = r7.d;	 Catch:{ all -> 0x005c }
        r0 = r0 + -1;
    L_0x001e:
        if (r1 > r0) goto L_0x0049;
    L_0x0020:
        r2 = r7.e;	 Catch:{ all -> 0x005c }
        r4 = r2[r1];	 Catch:{ all -> 0x005c }
        r2 = r4.a;	 Catch:{ all -> 0x005c }
        r5 = r7.b;	 Catch:{ all -> 0x005c }
        if (r2 != r5) goto L_0x002d;
    L_0x002a:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x002d:
        r2 = r7.e;	 Catch:{ all -> 0x005c }
        r5 = r2[r1];	 Catch:{ all -> 0x005c }
        r2 = r5.a;	 Catch:{ all -> 0x005c }
        r6 = r7.b;	 Catch:{ all -> 0x005c }
        if (r2 == r6) goto L_0x003a;
    L_0x0037:
        r0 = r0 + -1;
        goto L_0x001e;
    L_0x003a:
        r6 = r7.e;	 Catch:{ all -> 0x005c }
        r2 = r1 + 1;
        r6[r1] = r5;	 Catch:{ all -> 0x005c }
        r5 = r7.e;	 Catch:{ all -> 0x005c }
        r1 = r0 + -1;
        r5[r0] = r4;	 Catch:{ all -> 0x005c }
        r0 = r1;
        r1 = r2;
        goto L_0x001e;
    L_0x0049:
        r0 = java.lang.Math.max(r3, r1);	 Catch:{ all -> 0x005c }
        r1 = r7.d;	 Catch:{ all -> 0x005c }
        if (r0 >= r1) goto L_0x0014;
    L_0x0051:
        r1 = r7.e;	 Catch:{ all -> 0x005c }
        r2 = r7.d;	 Catch:{ all -> 0x005c }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{ all -> 0x005c }
        r7.d = r0;	 Catch:{ all -> 0x005c }
        goto L_0x0014;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x005f:
        r0 = r3;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer.upstream.d.trim(int):void");
    }
}
