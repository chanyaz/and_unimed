package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.k;
import com.google.android.exoplayer.p;
import java.util.List;

public interface ChunkSource {
    void continueBuffering(long j);

    void disable(List<? extends i> list);

    void enable();

    void getChunkOperation(List<? extends i> list, long j, long j2, c cVar);

    void getMaxVideoDimensions(k kVar);

    p getTrackInfo();

    void maybeThrowError();

    void onChunkLoadCompleted(b bVar);

    void onChunkLoadError(b bVar, Exception exception);
}
