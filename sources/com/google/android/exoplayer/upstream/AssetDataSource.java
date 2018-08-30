package com.google.android.exoplayer.upstream;

import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource implements UriDataSource {
    private final AssetManager a;
    private final TransferListener b;
    private String c;
    private InputStream d;
    private long e;
    private boolean f;

    public final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public void close() {
        this.c = null;
        if (this.d != null) {
            try {
                this.d.close();
                this.d = null;
                if (this.f) {
                    this.f = false;
                    if (this.b != null) {
                        this.b.onTransferEnd();
                    }
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            } catch (Throwable th) {
                this.d = null;
                if (this.f) {
                    this.f = false;
                    if (this.b != null) {
                        this.b.onTransferEnd();
                    }
                }
            }
        }
    }

    public String getUri() {
        return this.c;
    }

    public long open(c cVar) {
        try {
            this.c = cVar.a.toString();
            String path = cVar.a.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.c = cVar.a.toString();
            this.d = this.a.open(path, 1);
            if (this.d.skip(cVar.d) < cVar.d) {
                throw new EOFException();
            }
            if (cVar.e != -1) {
                this.e = cVar.e;
            } else {
                this.e = (long) this.d.available();
                if (this.e == 2147483647L) {
                    this.e = -1;
                }
            }
            this.f = true;
            if (this.b != null) {
                this.b.onTransferStart();
            }
            return this.e;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.e == 0) {
            return -1;
        }
        try {
            if (this.e != -1) {
                i2 = (int) Math.min(this.e, (long) i2);
            }
            int read = this.d.read(bArr, i, i2);
            if (read <= 0) {
                return read;
            }
            if (this.e != -1) {
                this.e -= (long) read;
            }
            if (this.b == null) {
                return read;
            }
            this.b.onBytesTransferred(read);
            return read;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }
}
