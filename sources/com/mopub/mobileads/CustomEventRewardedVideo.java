package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.Map;

public abstract class CustomEventRewardedVideo {

    @VisibleForTesting
    public interface CustomEventRewardedVideoListener {
    }

    @Nullable
    @VisibleForTesting
    protected abstract CustomEventRewardedVideoListener a();

    final void a(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        try {
            if (b(activity, map, map2)) {
                MoPubLifecycleManager.getInstance(activity).addLifecycleListener(b());
            }
            c(activity, map, map2);
        } catch (Exception e) {
            MoPubLog.e(e.getMessage());
        }
    }

    @Nullable
    @VisibleForTesting
    protected abstract LifecycleListener b();

    protected abstract boolean b(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);

    @NonNull
    protected abstract String c();

    protected abstract void c(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);

    protected abstract void d();

    protected abstract boolean e();

    protected abstract void f();
}
