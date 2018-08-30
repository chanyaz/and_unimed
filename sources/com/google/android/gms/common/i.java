package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class i extends ac {
    private int a;

    protected i(byte[] bArr) {
        ar.b(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    abstract byte[] a();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ICertData)) {
            return false;
        }
        try {
            ICertData iCertData = (ICertData) obj;
            if (iCertData.getHashCode() != hashCode()) {
                return false;
            }
            IObjectWrapper bytesWrapped = iCertData.getBytesWrapped();
            if (bytesWrapped == null) {
                return false;
            }
            return Arrays.equals(a(), (byte[]) c.a(bytesWrapped));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    public IObjectWrapper getBytesWrapped() {
        return c.a(a());
    }

    public int getHashCode() {
        return hashCode();
    }

    public int hashCode() {
        return this.a;
    }
}
