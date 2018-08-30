package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.d;

public interface DashSegmentIndex {
    long getDurationUs(int i);

    int getFirstSegmentNum();

    int getLastSegmentNum();

    int getSegmentNum(long j);

    d getSegmentUrl(int i);

    long getTimeUs(int i);

    boolean isExplicit();
}
