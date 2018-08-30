package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
    static final Object e = new Object();
    static final HashMap<ComponentName, Object> f = new HashMap();
    boolean a = false;
    boolean b = false;
    boolean c = false;
    final ArrayList<Object> d;

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    public JobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.d = null;
        } else {
            this.d = new ArrayList();
        }
    }
}
