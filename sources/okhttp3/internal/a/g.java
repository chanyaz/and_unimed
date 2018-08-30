package okhttp3.internal.a;

import okio.d;

class g extends b {
    final /* synthetic */ a d;
    private boolean e;

    g(a aVar) {
        this.d = aVar;
        super(aVar);
    }

    public void close() {
        if (!this.b) {
            if (!this.e) {
                a(false);
            }
            this.b = true;
        }
    }

    public long read(d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e) {
            return -1;
        } else {
            long read = this.d.c.read(dVar, j);
            if (read != -1) {
                return read;
            }
            this.e = true;
            a(true);
            return -1;
        }
    }
}
