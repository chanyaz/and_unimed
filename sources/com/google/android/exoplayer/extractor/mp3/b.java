package com.google.android.exoplayer.extractor.mp3;

final class b implements Seeker {
    private final long a;
    private final int b;
    private final long c;

    public b(long j, int i, long j2) {
        long j3 = -1;
        this.a = j;
        this.b = i;
        if (j2 != -1) {
            j3 = getTimeUs(j2);
        }
        this.c = j3;
    }

    public long getDurationUs() {
        return this.c;
    }

    public long getPosition(long j) {
        return this.c == -1 ? 0 : this.a + ((((long) this.b) * j) / 8000000);
    }

    public long getTimeUs(long j) {
        return (((j - this.a) * 1000000) * 8) / ((long) this.b);
    }

    public boolean isSeekable() {
        return this.c != -1;
    }
}
