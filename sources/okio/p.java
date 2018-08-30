package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class p {
    public static final p c = new p() {
        public p a(long j) {
            return this;
        }

        public p a(long j, TimeUnit timeUnit) {
            return this;
        }

        public void g() {
        }
    };
    private boolean a;
    private long b;
    private long d;

    public p a(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public p a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long d() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public p f() {
        this.a = false;
        return this;
    }

    public void g() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long l_() {
        return this.d;
    }

    public boolean m_() {
        return this.a;
    }

    public p n_() {
        this.d = 0;
        return this;
    }
}
