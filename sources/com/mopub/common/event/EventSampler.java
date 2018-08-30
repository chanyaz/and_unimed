package com.mopub.common.event;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;

public class EventSampler {
    @NonNull
    private Random a;
    @NonNull
    private LinkedHashMap<String, Boolean> b;

    public EventSampler() {
        this(new Random());
    }

    @VisibleForTesting
    public EventSampler(@NonNull Random random) {
        this.a = random;
        this.b = new LinkedHashMap<String, Boolean>(135, 0.75f, true) {
            protected boolean removeEldestEntry(Entry<String, Boolean> entry) {
                return size() > 100;
            }
        };
    }

    boolean a(@NonNull BaseEvent baseEvent) {
        boolean z = true;
        Preconditions.checkNotNull(baseEvent);
        String requestId = baseEvent.getRequestId();
        if (requestId == null) {
            return this.a.nextDouble() < baseEvent.getSamplingRate();
        } else {
            Boolean bool = (Boolean) this.b.get(requestId);
            if (bool != null) {
                return bool.booleanValue();
            }
            if (this.a.nextDouble() >= baseEvent.getSamplingRate()) {
                z = false;
            }
            this.b.put(requestId, Boolean.valueOf(z));
            return z;
        }
    }
}
