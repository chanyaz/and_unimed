package okhttp3;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.concurrent.TimeUnit;

public final class d {
    boolean a;
    boolean b;
    int c = -1;
    int d = -1;
    int e = -1;
    boolean f;
    boolean g;
    boolean h;

    public d a() {
        this.a = true;
        return this;
    }

    public d a(int i, TimeUnit timeUnit) {
        if (i < 0) {
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }
        long toSeconds = timeUnit.toSeconds((long) i);
        this.d = toSeconds > 2147483647L ? MoPubClientPositioning.NO_REPEAT : (int) toSeconds;
        return this;
    }

    public d b() {
        this.f = true;
        return this;
    }

    public c c() {
        return new c(this);
    }
}
