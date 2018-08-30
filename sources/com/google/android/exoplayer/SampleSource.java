package com.google.android.exoplayer;

public interface SampleSource {

    public interface SampleSourceReader {
        boolean continueBuffering(int i, long j);

        void disable(int i);

        void enable(int i, long j);

        long getBufferedPositionUs();

        int getTrackCount();

        p getTrackInfo(int i);

        void maybeThrowError();

        boolean prepare(long j);

        int readData(int i, long j, l lVar, m mVar, boolean z);

        void release();

        void seekToUs(long j);
    }

    SampleSourceReader register();
}
