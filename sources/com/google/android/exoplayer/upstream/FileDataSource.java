package com.google.android.exoplayer.upstream;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource implements UriDataSource {
    private final TransferListener a;
    private RandomAccessFile b;
    private String c;
    private long d;
    private boolean e;

    public class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(TransferListener transferListener) {
        this.a = transferListener;
    }

    public void close() {
        this.c = null;
        if (this.b != null) {
            try {
                this.b.close();
                this.b = null;
                if (this.e) {
                    this.e = false;
                    if (this.a != null) {
                        this.a.onTransferEnd();
                    }
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e);
            } catch (Throwable th) {
                this.b = null;
                if (this.e) {
                    this.e = false;
                    if (this.a != null) {
                        this.a.onTransferEnd();
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
            this.b = new RandomAccessFile(cVar.a.getPath(), "r");
            this.b.seek(cVar.d);
            this.d = cVar.e == -1 ? this.b.length() - cVar.d : cVar.e;
            if (this.d < 0) {
                throw new EOFException();
            }
            this.e = true;
            if (this.a != null) {
                this.a.onTransferStart();
            }
            return this.d;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.d == 0) {
            return -1;
        }
        try {
            int read = this.b.read(bArr, i, (int) Math.min(this.d, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.d -= (long) read;
            if (this.a == null) {
                return read;
            }
            this.a.onBytesTransferred(read);
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }
}
