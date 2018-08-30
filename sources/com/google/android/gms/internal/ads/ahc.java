package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;

@VisibleForTesting
final class ahc {
    @VisibleForTesting
    private ByteArrayOutputStream a = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream b = new Base64OutputStream(this.a, 10);

    public final void a(byte[] bArr) {
        this.b.write(bArr);
    }

    public final String toString() {
        String byteArrayOutputStream;
        try {
            this.b.close();
        } catch (Throwable e) {
            kk.b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.a.close();
            byteArrayOutputStream = this.a.toString();
        } catch (Throwable e2) {
            kk.b("HashManager: Unable to convert to Base64.", e2);
            byteArrayOutputStream = "";
        } finally {
            this.a = null;
            this.b = null;
        }
        return byteArrayOutputStream;
    }
}
