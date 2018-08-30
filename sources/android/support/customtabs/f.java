package android.support.customtabs;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

public final class f {
    private final Object a = new Object();
    private final ICustomTabsService b;
    private final ICustomTabsCallback c;
    private final ComponentName d;

    f(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.b = iCustomTabsService;
        this.c = iCustomTabsCallback;
        this.d = componentName;
    }

    IBinder a() {
        return this.c.asBinder();
    }

    public boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.b.mayLaunchUrl(this.c, uri, bundle, list);
        } catch (RemoteException e) {
            return false;
        }
    }

    ComponentName b() {
        return this.d;
    }
}
