package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession.QueueItem;

class ac {
    ac() {
    }

    public static Object a(Object obj) {
        return ((QueueItem) obj).getDescription();
    }

    public static Object a(Object obj, long j) {
        return new QueueItem((MediaDescription) obj, j);
    }

    public static long b(Object obj) {
        return ((QueueItem) obj).getQueueId();
    }
}
