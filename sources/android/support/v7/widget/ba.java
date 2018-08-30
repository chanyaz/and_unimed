package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class ba {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;

    public abstract int a(int i);

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    public int a(int r6, int r7) {
        /*
        r5 = this;
        r1 = 0;
        r4 = r5.a(r6);
        if (r4 != r7) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r5.b;
        if (r0 == 0) goto L_0x0041;
    L_0x000c:
        r0 = r5.a;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0041;
    L_0x0014:
        r0 = r5.b(r6);
        if (r0 < 0) goto L_0x0041;
    L_0x001a:
        r2 = r5.a;
        r2 = r2.get(r0);
        r3 = r5.a(r0);
        r2 = r2 + r3;
        r0 = r0 + 1;
    L_0x0027:
        r3 = r0;
    L_0x0028:
        if (r3 >= r6) goto L_0x003b;
    L_0x002a:
        r0 = r5.a(r3);
        r2 = r2 + r0;
        if (r2 != r7) goto L_0x0037;
    L_0x0031:
        r0 = r1;
    L_0x0032:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r0;
        goto L_0x0028;
    L_0x0037:
        if (r2 > r7) goto L_0x0032;
    L_0x0039:
        r0 = r2;
        goto L_0x0032;
    L_0x003b:
        r0 = r2 + r4;
        if (r0 > r7) goto L_0x0007;
    L_0x003f:
        r1 = r2;
        goto L_0x0007;
    L_0x0041:
        r0 = r1;
        r2 = r1;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ba.a(int, int):int");
    }

    public void a() {
        this.a.clear();
    }

    int b(int i) {
        int i2 = 0;
        int size = this.a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        return (size < 0 || size >= this.a.size()) ? -1 : this.a.keyAt(size);
    }

    int b(int i, int i2) {
        if (!this.b) {
            return a(i, i2);
        }
        int i3 = this.a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = a(i, i2);
        this.a.put(i, i3);
        return i3;
    }

    public int c(int i, int i2) {
        int a = a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        return i5 + a > i2 ? i4 + 1 : i4;
    }
}
