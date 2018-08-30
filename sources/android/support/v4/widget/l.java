package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

class l extends ContentObserver {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.a.a();
    }
}
