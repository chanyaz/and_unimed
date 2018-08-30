package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

@Deprecated
public final class AdapterHelper {
    @NonNull
    private final WeakReference<Activity> a;
    @NonNull
    private final Context b;
    private final int c;
    private final int d;

    @Deprecated
    public AdapterHelper(@NonNull Context context, int i, int i2) {
        boolean z = true;
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkArgument(context instanceof Activity, "Context must be an Activity.");
        Preconditions.checkArgument(i >= 0, "start position must be non-negative");
        if (i2 < 2) {
            z = false;
        }
        Preconditions.checkArgument(z, "interval must be at least 2");
        this.a = new WeakReference((Activity) context);
        this.b = context.getApplicationContext();
        this.c = i;
        this.d = i2;
    }

    private int a(int i) {
        return i <= this.c ? 0 : ((int) Math.floor(((double) (i - this.c)) / ((double) this.d))) + 1;
    }

    private int b(int i) {
        if (i <= this.c) {
            return 0;
        }
        int i2 = this.d - 1;
        return (i - this.c) % i2 == 0 ? (i - this.c) / i2 : ((int) Math.floor(((double) (i - this.c)) / ((double) i2))) + 1;
    }

    @Deprecated
    @NonNull
    public View getAdView(@Nullable View view, @Nullable ViewGroup viewGroup, @Nullable NativeAd nativeAd, @Nullable ViewBinder viewBinder) {
        Activity activity = (Activity) this.a.get();
        if (activity != null) {
            return l.a(view, viewGroup, activity, nativeAd, viewBinder);
        }
        MoPubLog.w("Weak reference to Activity Context in AdapterHelper became null. Returning empty view.");
        return new View(this.b);
    }

    @Deprecated
    public boolean isAdPosition(int i) {
        return i >= this.c && (i - this.c) % this.d == 0;
    }

    @Deprecated
    public int shiftedCount(int i) {
        return b(i) + i;
    }

    @Deprecated
    public int shiftedPosition(int i) {
        return i - a(i);
    }
}
