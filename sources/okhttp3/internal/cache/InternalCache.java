package okhttp3.internal.cache;

import okhttp3.ad;
import okhttp3.ag;

public interface InternalCache {
    ag get(ad adVar);

    CacheRequest put(ag agVar);

    void remove(ad adVar);

    void trackConditionalCacheHit();

    void trackResponse(b bVar);

    void update(ag agVar, ag agVar2);
}
