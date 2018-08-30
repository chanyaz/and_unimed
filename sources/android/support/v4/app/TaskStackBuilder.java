package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
    private static final ax a;
    private final ArrayList<Intent> b = new ArrayList();
    private final Context c;

    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new aw();
        } else {
            a = new ax();
        }
    }

    private TaskStackBuilder(Context context) {
        this.c = context;
    }

    @NonNull
    public static TaskStackBuilder a(@NonNull Context context) {
        return new TaskStackBuilder(context);
    }

    @NonNull
    public TaskStackBuilder a(@NonNull Activity activity) {
        Intent intent = null;
        if (activity instanceof SupportParentable) {
            intent = ((SupportParentable) activity).getSupportParentActivityIntent();
        }
        Intent a = intent == null ? ak.a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(a);
        }
        return this;
    }

    public TaskStackBuilder a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent a = ak.a(this.c, componentName);
            while (a != null) {
                this.b.add(size, a);
                a = ak.a(this.c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @NonNull
    public TaskStackBuilder a(@NonNull Intent intent) {
        this.b.add(intent);
        return this;
    }

    public void a() {
        a(null);
    }

    public void a(@Nullable Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!a.a(this.c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.c.startActivity(intent);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }
}
