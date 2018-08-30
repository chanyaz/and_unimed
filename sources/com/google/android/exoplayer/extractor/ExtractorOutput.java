package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.drm.a;

public interface ExtractorOutput {
    void drmInitData(a aVar);

    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i);
}
