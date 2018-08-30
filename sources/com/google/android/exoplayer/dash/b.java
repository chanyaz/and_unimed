package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.d;
import com.google.android.exoplayer.extractor.a;

final class b implements DashSegmentIndex {
    private final a a;
    private final String b;
    private final long c;

    public b(a aVar, String str, long j) {
        this.a = aVar;
        this.b = str;
        this.c = j;
    }

    public long getDurationUs(int i) {
        return this.a.d[i];
    }

    public int getFirstSegmentNum() {
        return 0;
    }

    public int getLastSegmentNum() {
        return this.a.a - 1;
    }

    public int getSegmentNum(long j) {
        return this.a.a(j - this.c);
    }

    public d getSegmentUrl(int i) {
        return new d(this.b, null, this.a.c[i], (long) this.a.b[i]);
    }

    public long getTimeUs(int i) {
        return this.a.e[i] + this.c;
    }

    public boolean isExplicit() {
        return true;
    }
}
