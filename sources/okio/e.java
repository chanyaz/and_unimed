package okio;

public abstract class e implements Source {
    private final Source a;

    public e(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = source;
    }

    public void close() {
        this.a.close();
    }

    public long read(d dVar, long j) {
        return this.a.read(dVar, j);
    }

    public p timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
