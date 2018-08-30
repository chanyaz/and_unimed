package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.widget.RemoteViews;

public abstract class aq {
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected ao a;
    CharSequence b;
    CharSequence c;
    boolean d = false;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Bundle bundle) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
    }

    public void a(ao aoVar) {
        if (this.a != aoVar) {
            this.a = aoVar;
            if (this.a != null) {
                this.a.a(this);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public RemoteViews b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public RemoteViews c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }
}
