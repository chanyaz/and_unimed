package com.mopub.common.event;

import android.os.HandlerThread;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;

public class MoPubEvents {
    private static volatile EventDispatcher a;

    @VisibleForTesting
    static EventDispatcher a() {
        EventDispatcher eventDispatcher = a;
        if (eventDispatcher == null) {
            synchronized (MoPubEvents.class) {
                eventDispatcher = a;
                if (eventDispatcher == null) {
                    Iterable arrayList = new ArrayList();
                    HandlerThread handlerThread = new HandlerThread("mopub_event_logging");
                    handlerThread.start();
                    arrayList.add(new ScribeEventRecorder(handlerThread.getLooper()));
                    eventDispatcher = new EventDispatcher(arrayList, handlerThread.getLooper());
                    a = eventDispatcher;
                }
            }
        }
        return eventDispatcher;
    }

    public static void log(BaseEvent baseEvent) {
        a().dispatch(baseEvent);
    }

    @VisibleForTesting
    public static void setEventDispatcher(EventDispatcher eventDispatcher) {
        a = eventDispatcher;
    }
}
