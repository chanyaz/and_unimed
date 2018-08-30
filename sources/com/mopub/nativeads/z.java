package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.ArrayList;
import java.util.Map.Entry;

class z implements Runnable {
    final /* synthetic */ VisibilityTracker a;
    @NonNull
    private final ArrayList<View> b = new ArrayList();
    @NonNull
    private final ArrayList<View> c = new ArrayList();

    z(VisibilityTracker visibilityTracker) {
        this.a = visibilityTracker;
    }

    public void run() {
        this.a.j = false;
        for (Entry entry : this.a.e.entrySet()) {
            View view = (View) entry.getKey();
            int i = ((x) entry.getValue()).a;
            int i2 = ((x) entry.getValue()).b;
            View view2 = ((x) entry.getValue()).d;
            if (this.a.f.a(view2, view, i)) {
                this.b.add(view);
            } else if (!this.a.f.a(view2, view, i2)) {
                this.c.add(view);
            }
        }
        if (this.a.g != null) {
            this.a.g.onVisibilityChanged(this.b, this.c);
        }
        this.b.clear();
        this.c.clear();
    }
}
