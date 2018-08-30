package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.b;
import com.google.android.exoplayer.upstream.c;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements DataSource {
    private final DataSource a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;

    public a(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.a = dataSource;
        this.b = bArr;
        this.c = bArr2;
    }

    public void close() {
        this.d = null;
        this.a.close();
    }

    public long open(c cVar) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                this.d = new CipherInputStream(new b(this.a, cVar), instance);
                return -1;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        com.google.android.exoplayer.util.b.b(this.d != null);
        int read = this.d.read(bArr, i, i2);
        return read < 0 ? -1 : read;
    }
}
