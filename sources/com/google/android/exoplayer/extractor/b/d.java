package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.i;

abstract class d {
    protected final TrackOutput a;

    protected d(TrackOutput trackOutput) {
        this.a = trackOutput;
    }

    public abstract void a();

    public abstract void a(i iVar, long j, boolean z);

    public abstract void b();
}
