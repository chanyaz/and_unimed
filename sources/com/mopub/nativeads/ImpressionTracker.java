package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ImpressionTracker {
    @NonNull
    private final VisibilityTracker a;
    @NonNull
    private final Map<View, ImpressionInterface> b;
    @NonNull
    private final Map<View, w<ImpressionInterface>> c;
    @NonNull
    private final Handler d;
    @NonNull
    private final c e;
    @NonNull
    private final y f;
    @Nullable
    private VisibilityTrackerListener g;

    public ImpressionTracker(@NonNull Activity activity) {
        this(new WeakHashMap(), new WeakHashMap(), new y(), new VisibilityTracker(activity), new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    ImpressionTracker(@NonNull Map<View, ImpressionInterface> map, @NonNull Map<View, w<ImpressionInterface>> map2, @NonNull y yVar, @NonNull VisibilityTracker visibilityTracker, @NonNull Handler handler) {
        this.b = map;
        this.c = map2;
        this.f = yVar;
        this.a = visibilityTracker;
        this.g = new VisibilityTrackerListener() {
            public void onVisibilityChanged(@NonNull List<View> list, @NonNull List<View> list2) {
                for (View view : list) {
                    ImpressionInterface impressionInterface = (ImpressionInterface) ImpressionTracker.this.b.get(view);
                    if (impressionInterface == null) {
                        ImpressionTracker.this.removeView(view);
                    } else {
                        w wVar = (w) ImpressionTracker.this.c.get(view);
                        if (wVar == null || !impressionInterface.equals(wVar.a)) {
                            ImpressionTracker.this.c.put(view, new w(impressionInterface));
                        }
                    }
                }
                for (View view2 : list2) {
                    ImpressionTracker.this.c.remove(view2);
                }
                ImpressionTracker.this.a();
            }
        };
        this.a.a(this.g);
        this.d = handler;
        this.e = new c(this);
    }

    private void a(View view) {
        this.c.remove(view);
    }

    @VisibleForTesting
    void a() {
        if (!this.d.hasMessages(0)) {
            this.d.postDelayed(this.e, 250);
        }
    }

    public void addView(View view, @NonNull ImpressionInterface impressionInterface) {
        if (this.b.get(view) != impressionInterface) {
            removeView(view);
            if (!impressionInterface.isImpressionRecorded()) {
                this.b.put(view, impressionInterface);
                this.a.a(view, impressionInterface.getImpressionMinPercentageViewed());
            }
        }
    }

    public void clear() {
        this.b.clear();
        this.c.clear();
        this.a.a();
        this.d.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.a.b();
        this.g = null;
    }

    public void removeView(View view) {
        this.b.remove(view);
        a(view);
        this.a.a(view);
    }
}
