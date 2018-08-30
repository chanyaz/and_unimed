package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class p extends i {
    private static final WeakReference<byte[]> b = new WeakReference(null);
    private WeakReference<byte[]> a = b;

    p(byte[] bArr) {
        super(bArr);
    }

    final byte[] a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.a.get();
            if (bArr == null) {
                bArr = b();
                this.a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] b();
}
