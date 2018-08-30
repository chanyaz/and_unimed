package com.google.android.exoplayer.upstream.cache;

import java.io.File;
import java.util.NavigableSet;
import java.util.Set;

public interface Cache {

    public interface Listener {
        void onSpanAdded(Cache cache, a aVar);

        void onSpanRemoved(Cache cache, a aVar);

        void onSpanTouched(Cache cache, a aVar, a aVar2);
    }

    NavigableSet<a> addListener(String str, Listener listener);

    void commitFile(File file);

    long getCacheSpace();

    NavigableSet<a> getCachedSpans(String str);

    Set<String> getKeys();

    boolean isCached(String str, long j, long j2);

    void releaseHoleSpan(a aVar);

    void removeListener(String str, Listener listener);

    void removeSpan(a aVar);

    File startFile(String str, long j, long j2);

    a startReadWrite(String str, long j);

    a startReadWriteNonBlocking(String str, long j);
}
