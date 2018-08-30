package android.support.v4.app;

import android.app.Notification.BigPictureStyle;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

public class am extends aq {
    private Bitmap e;
    private Bitmap f;
    private boolean g;

    public am a(Bitmap bitmap) {
        this.e = bitmap;
        return this;
    }

    public am a(CharSequence charSequence) {
        this.b = ao.d(charSequence);
        return this;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (VERSION.SDK_INT >= 16) {
            BigPictureStyle bigPicture = new BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b).bigPicture(this.e);
            if (this.g) {
                bigPicture.bigLargeIcon(this.f);
            }
            if (this.d) {
                bigPicture.setSummaryText(this.c);
            }
        }
    }

    public am b(Bitmap bitmap) {
        this.f = bitmap;
        this.g = true;
        return this;
    }

    public am b(CharSequence charSequence) {
        this.c = ao.d(charSequence);
        this.d = true;
        return this;
    }
}
