package com.google.android.exoplayer.upstream;

import android.content.ContentResolver;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentDataSource implements UriDataSource {
    private final ContentResolver a;
    private final TransferListener b;
    private InputStream c;
    private String d;
    private long e;
    private boolean f;

    public class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public void close() {
        this.d = null;
        if (this.c != null) {
            try {
                this.c.close();
                this.c = null;
                if (this.f) {
                    this.f = false;
                    if (this.b != null) {
                        this.b.onTransferEnd();
                    }
                }
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            } catch (Throwable th) {
                this.c = null;
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
        return this.d;
    }

    public long open(c cVar) {
        try {
            this.d = cVar.a.toString();
            this.c = new FileInputStream(this.a.openAssetFileDescriptor(cVar.a, "r").getFileDescriptor());
            if (this.c.skip(cVar.d) < cVar.d) {
                throw new EOFException();
            }
            if (cVar.e != -1) {
                this.e = cVar.e;
            } else {
                this.e = (long) this.c.available();
                if (this.e == 0) {
                    this.e = -1;
                }
            }
            this.f = true;
            if (this.b != null) {
                this.b.onTransferStart();
            }
            return this.e;
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
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
            int read = this.c.read(bArr, i, i2);
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
            throw new ContentDataSourceException(e);
        }
    }
}
