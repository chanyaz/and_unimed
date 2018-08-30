package android.support.v4.app;

import android.app.Notification.InboxStyle;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.ArrayList;
import java.util.Iterator;

public class ap extends aq {
    private ArrayList<CharSequence> e = new ArrayList();

    public ap a(CharSequence charSequence) {
        this.c = ao.d(charSequence);
        this.d = true;
        return this;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (VERSION.SDK_INT >= 16) {
            InboxStyle bigContentTitle = new InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b);
            if (this.d) {
                bigContentTitle.setSummaryText(this.c);
            }
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }
    }

    public ap b(CharSequence charSequence) {
        this.e.add(ao.d(charSequence));
        return this;
    }
}
