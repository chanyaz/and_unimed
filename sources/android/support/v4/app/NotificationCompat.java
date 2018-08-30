package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NotificationCompat {

    public class Action {
        final Bundle a;
        public int b;
        public CharSequence c;
        public PendingIntent d;
        private final au[] e;
        private final au[] f;
        private boolean g;

        public interface Extender {
            al extend(al alVar);
        }

        public int a() {
            return this.b;
        }

        public CharSequence b() {
            return this.c;
        }

        public PendingIntent c() {
            return this.d;
        }

        public Bundle d() {
            return this.a;
        }

        public boolean e() {
            return this.g;
        }

        public au[] f() {
            return this.e;
        }

        public au[] g() {
            return this.f;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public interface Extender {
        ao extend(ao aoVar);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static Bundle a(Notification notification) {
        return VERSION.SDK_INT >= 19 ? notification.extras : VERSION.SDK_INT >= 16 ? as.a(notification) : null;
    }
}
