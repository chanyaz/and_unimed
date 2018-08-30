package com.google.android.exoplayer.text;

import java.util.List;

public interface Subtitle {
    List<b> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    long getLastEventTime();

    int getNextEventTimeIndex(long j);

    long getStartTime();
}
