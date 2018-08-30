package com.google.android.exoplayer.extractor;

public interface SeekMap {
    public static final SeekMap f = new SeekMap() {
        public long getPosition(long j) {
            return 0;
        }

        public boolean isSeekable() {
            return false;
        }
    };

    long getPosition(long j);

    boolean isSeekable();
}
