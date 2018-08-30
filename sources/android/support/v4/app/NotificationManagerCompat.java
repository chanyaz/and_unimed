package android.support.v4.app;

import android.support.annotation.GuardedBy;
import java.util.HashSet;
import java.util.Set;

public final class NotificationManagerCompat {
    private static final Object a = new Object();
    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> b = new HashSet();
    private static final Object c = new Object();

    interface Task {
        void send(INotificationSideChannel iNotificationSideChannel);
    }
}
