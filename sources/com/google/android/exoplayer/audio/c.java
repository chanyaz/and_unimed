package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
class c extends b {
    private final AudioTimestamp b = new AudioTimestamp();
    private long c;
    private long d;
    private long e;

    public c() {
        super();
    }

    public void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public boolean d() {
        boolean timestamp = this.a.getTimestamp(this.b);
        if (timestamp) {
            long j = this.b.framePosition;
            if (this.d > j) {
                this.c++;
            }
            this.d = j;
            this.e = j + (this.c << 32);
        }
        return timestamp;
    }

    public long e() {
        return this.b.nanoTime;
    }

    public long f() {
        return this.e;
    }
}
