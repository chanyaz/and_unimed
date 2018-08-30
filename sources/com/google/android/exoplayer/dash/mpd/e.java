package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.dash.DashSegmentIndex;

public abstract class e implements FormatWrapper {
    public final String a;
    public final long b;
    public final f c;
    public final long d;
    public final long e;
    private final d f;

    public d a() {
        return this.f;
    }

    public abstract d b();

    public abstract DashSegmentIndex c();

    public String d() {
        return this.a + "." + this.c.a + "." + this.b;
    }

    public f getFormat() {
        return this.c;
    }
}
