package com.mopub.common;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class MoPubLifecycleManager implements LifecycleListener {
    private static MoPubLifecycleManager a;
    @NonNull
    private final Set<LifecycleListener> b = new HashSet();
    @NonNull
    private final WeakReference<Activity> c;

    private MoPubLifecycleManager(Activity activity) {
        this.c = new WeakReference(activity);
    }

    @NonNull
    public static synchronized MoPubLifecycleManager getInstance(Activity activity) {
        MoPubLifecycleManager moPubLifecycleManager;
        synchronized (MoPubLifecycleManager.class) {
            if (a == null) {
                a = new MoPubLifecycleManager(activity);
            }
            moPubLifecycleManager = a;
        }
        return moPubLifecycleManager;
    }

    public void addLifecycleListener(@Nullable LifecycleListener lifecycleListener) {
        if (lifecycleListener != null && this.b.add(lifecycleListener)) {
            Activity activity = (Activity) this.c.get();
            if (activity != null) {
                lifecycleListener.onCreate(activity);
                lifecycleListener.onStart(activity);
            }
        }
    }

    public void onBackPressed(@NonNull Activity activity) {
        for (LifecycleListener onBackPressed : this.b) {
            onBackPressed.onBackPressed(activity);
        }
    }

    public void onCreate(@NonNull Activity activity) {
        for (LifecycleListener onCreate : this.b) {
            onCreate.onCreate(activity);
        }
    }

    public void onDestroy(@NonNull Activity activity) {
        for (LifecycleListener onRestart : this.b) {
            onRestart.onRestart(activity);
        }
    }

    public void onPause(@NonNull Activity activity) {
        for (LifecycleListener onPause : this.b) {
            onPause.onPause(activity);
        }
    }

    public void onRestart(@NonNull Activity activity) {
        for (LifecycleListener onRestart : this.b) {
            onRestart.onRestart(activity);
        }
    }

    public void onResume(@NonNull Activity activity) {
        for (LifecycleListener onResume : this.b) {
            onResume.onResume(activity);
        }
    }

    public void onStart(@NonNull Activity activity) {
        for (LifecycleListener onStart : this.b) {
            onStart.onStart(activity);
        }
    }

    public void onStop(@NonNull Activity activity) {
        for (LifecycleListener onRestart : this.b) {
            onRestart.onRestart(activity);
        }
    }
}
