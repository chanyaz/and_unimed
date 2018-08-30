package com.google.android.exoplayer;

public final class ExoPlaybackException extends Exception {
    public final boolean a;

    public ExoPlaybackException(String str) {
        super(str);
        this.a = false;
    }

    public ExoPlaybackException(Throwable th) {
        super(th);
        this.a = false;
    }

    ExoPlaybackException(Throwable th, boolean z) {
        super(th);
        this.a = z;
    }
}
