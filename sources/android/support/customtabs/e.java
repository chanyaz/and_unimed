package android.support.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public abstract class e implements ServiceConnection {
    public abstract void a(ComponentName componentName, b bVar);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new b(j.a(iBinder), componentName) {
        });
    }
}
