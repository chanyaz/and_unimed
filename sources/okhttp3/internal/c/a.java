package okhttp3.internal.c;

import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;

public final class a {
    private static final byte[] a = new byte[]{(byte) 42};
    private static final String[] b = new String[0];
    private static final String[] c = new String[]{"*"};
    private static final a d = new a();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2 = 0;
        int length = bArr.length;
        while (i2 < length) {
            int i3;
            int i4;
            int i5;
            int i6 = (i2 + length) / 2;
            while (i6 > -1 && bArr[i6] != (byte) 10) {
                i6--;
            }
            int i7 = i6 + 1;
            i6 = 1;
            while (bArr[i7 + i6] != (byte) 10) {
                i6++;
            }
            int i8 = (i7 + i6) - i7;
            int i9 = 0;
            int i10 = 0;
            Object obj = null;
            int i11 = i;
            while (true) {
                if (obj != null) {
                    i3 = 46;
                    obj = null;
                } else {
                    i3 = bArr2[i11][i9] & 255;
                }
                i4 = i3 - (bArr[i7 + i10] & 255);
                if (i4 != 0) {
                    i3 = i10;
                    i5 = i9;
                    break;
                }
                i10++;
                i3 = i9 + 1;
                if (i10 == i8) {
                    i5 = i3;
                    i3 = i10;
                    break;
                }
                if (bArr2[i11].length == i3) {
                    if (i11 == bArr2.length - 1) {
                        i5 = i3;
                        i3 = i10;
                        break;
                    }
                    i11++;
                    i3 = -1;
                    obj = 1;
                }
                i9 = i3;
            }
            if (i4 < 0) {
                i6 = i7 - 1;
                i3 = i2;
            } else if (i4 > 0) {
                i3 = (i6 + i7) + 1;
                i6 = length;
            } else {
                i10 = i8 - i3;
                i5 = bArr2[i11].length - i5;
                for (i3 = i11 + 1; i3 < bArr2.length; i3++) {
                    i5 += bArr2[i3].length;
                }
                if (i5 < i10) {
                    i6 = i7 - 1;
                    i3 = i2;
                } else if (i5 <= i10) {
                    return new String(bArr, i7, i8, c.e);
                } else {
                    i3 = (i6 + i7) + 1;
                    i6 = length;
                }
            }
            length = i6;
            i2 = i3;
        }
        return null;
    }

    public static a a() {
        return d;
    }

    private String[] a(String[] strArr) {
        int i;
        String a;
        String str;
        String str2 = null;
        int i2 = 0;
        if (this.e.get() || !this.e.compareAndSet(false, true)) {
            try {
                this.f.await();
            } catch (InterruptedException e) {
            }
        } else {
            b();
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        Object obj = new byte[strArr.length][];
        for (i = 0; i < strArr.length; i++) {
            obj[i] = strArr[i].getBytes(c.e);
        }
        for (i = 0; i < obj.length; i++) {
            a = a(this.g, obj, i);
            if (a != null) {
                break;
            }
        }
        a = null;
        if (obj.length > 1) {
            byte[][] bArr = (byte[][]) obj.clone();
            for (int i3 = 0; i3 < bArr.length - 1; i3++) {
                bArr[i3] = a;
                String a2 = a(this.g, bArr, i3);
                if (a2 != null) {
                    str = a2;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            while (i2 < obj.length - 1) {
                String a3 = a(this.h, obj, i2);
                if (a3 != null) {
                    str2 = a3;
                    break;
                }
                i2++;
            }
        }
        if (str2 != null) {
            return ("!" + str2).split("\\.");
        }
        if (a == null && str == null) {
            return c;
        }
        String[] split = a != null ? a.split("\\.") : b;
        String[] split2 = str != null ? str.split("\\.") : b;
        return split.length > split2.length ? split : split2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0033 A:{SYNTHETIC} */
    private void b() {
        /*
        r6 = this;
        r1 = 0;
        r0 = okhttp3.internal.c.a.class;
        r0 = r0.getClassLoader();
        r2 = "publicsuffixes.gz";
        r0 = r0.getResourceAsStream(r2);
        if (r0 == 0) goto L_0x0056;
    L_0x000f:
        r2 = new okio.g;
        r0 = okio.i.a(r0);
        r2.<init>(r0);
        r3 = okio.i.a(r2);
        r0 = r3.readInt();	 Catch:{ IOException -> 0x003e }
        r2 = new byte[r0];	 Catch:{ IOException -> 0x003e }
        r3.readFully(r2);	 Catch:{ IOException -> 0x003e }
        r0 = r3.readInt();	 Catch:{ IOException -> 0x003e }
        r0 = new byte[r0];	 Catch:{ IOException -> 0x003e }
        r3.readFully(r0);	 Catch:{ IOException -> 0x003e }
        okhttp3.internal.c.a(r3);
        r1 = r2;
    L_0x0032:
        monitor-enter(r6);
        r6.g = r1;	 Catch:{ all -> 0x0053 }
        r6.h = r0;	 Catch:{ all -> 0x0053 }
        monitor-exit(r6);	 Catch:{ all -> 0x0053 }
        r0 = r6.f;
        r0.countDown();
        return;
    L_0x003e:
        r0 = move-exception;
        r2 = okhttp3.internal.b.h.b();	 Catch:{ all -> 0x004e }
        r4 = 5;
        r5 = "Failed to read public suffix list";
        r2.a(r4, r5, r0);	 Catch:{ all -> 0x004e }
        okhttp3.internal.c.a(r3);
        r0 = r1;
        goto L_0x0032;
    L_0x004e:
        r0 = move-exception;
        okhttp3.internal.c.a(r3);
        throw r0;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r1;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a.b():void");
    }

    public String a(String str) {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a = a(split);
        if (split.length == a.length && a[0].charAt(0) != '!') {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int length = a[0].charAt(0) == '!' ? split.length - a.length : split.length - (a.length + 1); length < split2.length; length++) {
            stringBuilder.append(split2[length]).append('.');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
