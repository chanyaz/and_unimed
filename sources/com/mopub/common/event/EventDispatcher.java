package com.mopub.common.event;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

public class EventDispatcher {
    private final Iterable<EventRecorder> a;
    private final Looper b;
    private final Handler c = new Handler(this.b, this.d);
    private final Callback d = new Callback() {
        public boolean handleMessage(Message message) {
            if (message.obj instanceof BaseEvent) {
                for (EventRecorder record : EventDispatcher.this.a) {
                    record.record((BaseEvent) message.obj);
                }
            } else {
                MoPubLog.d("EventDispatcher received non-BaseEvent message type.");
            }
            return true;
        }
    };

    @VisibleForTesting
    EventDispatcher(Iterable<EventRecorder> iterable, Looper looper) {
        this.a = iterable;
        this.b = looper;
    }

    public void dispatch(BaseEvent baseEvent) {
        Message.obtain(this.c, 0, baseEvent).sendToTarget();
    }
}
