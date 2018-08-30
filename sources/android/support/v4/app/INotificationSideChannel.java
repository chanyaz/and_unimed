package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

public interface INotificationSideChannel extends IInterface {
    void cancel(String str, int i, String str2);

    void cancelAll(String str);

    void notify(String str, int i, String str2, Notification notification);
}
