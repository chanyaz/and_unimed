package com.google.android.exoplayer;

import android.os.Looper;

public interface ExoPlayer {

    public interface ExoPlayerComponent {
        void handleMessage(int i, Object obj);
    }

    public interface Listener {
        void onPlayWhenReadyCommitted();

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        void onPlayerStateChanged(boolean z, int i);
    }

    void addListener(Listener listener);

    void blockingSendMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    boolean getPlayWhenReady();

    Looper getPlaybackLooper();

    int getPlaybackState();

    boolean getRendererEnabled(int i);

    boolean getRendererHasMedia(int i);

    boolean isPlayWhenReadyCommitted();

    void prepare(q... qVarArr);

    void release();

    void removeListener(Listener listener);

    void seekTo(long j);

    void sendMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj);

    void setPlayWhenReady(boolean z);

    void setRendererEnabled(int i, boolean z);

    void stop();
}
