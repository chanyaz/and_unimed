package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

class VisibilityTracker {
    @Nullable
    @VisibleForTesting
    OnPreDrawListener a;
    @NonNull
    @VisibleForTesting
    final WeakReference<View> b;
    @NonNull
    private final ArrayList<View> c;
    private long d;
    @NonNull
    private final Map<View, x> e;
    @NonNull
    private final y f;
    @Nullable
    private VisibilityTrackerListener g;
    @NonNull
    private final z h;
    @NonNull
    private final Handler i;
    private boolean j;

    interface VisibilityTrackerListener {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    public VisibilityTracker(@NonNull Activity activity) {
        this(activity, new WeakHashMap(10), new y(), new Handler());
    }

    @VisibleForTesting
    VisibilityTracker(@NonNull Activity activity, @NonNull Map<View, x> map, @NonNull y yVar, @NonNull Handler handler) {
        this.d = 0;
        this.e = map;
        this.f = yVar;
        this.i = handler;
        this.h = new z(this);
        this.c = new ArrayList(50);
        View decorView = activity.getWindow().getDecorView();
        this.b = new WeakReference(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.a = new OnPreDrawListener() {
                public boolean onPreDraw() {
                    VisibilityTracker.this.c();
                    return true;
                }
            };
            viewTreeObserver.addOnPreDrawListener(this.a);
            return;
        }
        MoPubLog.w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
    }

    private void a(long j) {
        for (Entry entry : this.e.entrySet()) {
            if (((x) entry.getValue()).c < j) {
                this.c.add(entry.getKey());
            }
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a((View) it.next());
        }
        this.c.clear();
    }

    void a() {
        this.e.clear();
        this.i.removeMessages(0);
        this.j = false;
    }

    void a(@NonNull View view) {
        this.e.remove(view);
    }

    void a(@NonNull View view, int i) {
        a(view, view, i);
    }

    void a(@NonNull View view, @NonNull View view2, int i) {
        a(view, view2, i, i);
    }

    void a(@NonNull View view, @NonNull View view2, int i, int i2) {
        x xVar = (x) this.e.get(view2);
        if (xVar == null) {
            xVar = new x();
            this.e.put(view2, xVar);
            c();
        }
        int min = Math.min(i2, i);
        xVar.d = view;
        xVar.a = i;
        xVar.b = min;
        xVar.c = this.d;
        this.d++;
        if (this.d % 50 == 0) {
            a(this.d - 50);
        }
    }

    void a(@Nullable VisibilityTrackerListener visibilityTrackerListener) {
        this.g = visibilityTrackerListener;
    }

    void b() {
        a();
        View view = (View) this.b.get();
        if (!(view == null || this.a == null)) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.a);
            }
            this.a = null;
        }
        this.g = null;
    }

    void c() {
        if (!this.j) {
            this.j = true;
            this.i.postDelayed(this.h, 100);
        }
    }
}
