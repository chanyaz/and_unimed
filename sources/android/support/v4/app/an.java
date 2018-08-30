package android.support.v4.app;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

public class an extends aq {
    private CharSequence e;

    public an a(CharSequence charSequence) {
        this.e = ao.d(charSequence);
        return this;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (VERSION.SDK_INT >= 16) {
            BigTextStyle bigText = new BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b).bigText(this.e);
            if (this.d) {
                bigText.setSummaryText(this.c);
            }
        }
    }
}
