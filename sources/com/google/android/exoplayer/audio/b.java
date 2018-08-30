package com.google.android.exoplayer.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer.audio.AudioTrack.AnonymousClass1;
import com.google.android.exoplayer.util.m;

class b {
    protected AudioTrack a;
    private boolean b;
    private int c;
    private long d;
    private long e;
    private long f;

    private b() {
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.a = audioTrack;
        this.b = z;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        if (audioTrack != null) {
            this.c = audioTrack.getSampleRate();
        }
    }

    public boolean a() {
        return m.a <= 22 && this.b && this.a.getPlayState() == 2 && this.a.getPlaybackHeadPosition() == 0;
    }

    public long b() {
        long playbackHeadPosition = 4294967295L & ((long) this.a.getPlaybackHeadPosition());
        if (m.a <= 22 && this.b) {
            if (this.a.getPlayState() == 1) {
                this.d = playbackHeadPosition;
            } else if (this.a.getPlayState() == 2 && playbackHeadPosition == 0) {
                this.f = this.d;
            }
            playbackHeadPosition += this.f;
        }
        if (this.d > playbackHeadPosition) {
            this.e++;
        }
        this.d = playbackHeadPosition;
        return playbackHeadPosition + (this.e << 32);
    }

    public long c() {
        return (b() * 1000000) / ((long) this.c);
    }

    public boolean d() {
        return false;
    }

    public long e() {
        throw new UnsupportedOperationException();
    }

    public long f() {
        throw new UnsupportedOperationException();
    }
}
