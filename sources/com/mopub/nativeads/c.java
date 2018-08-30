package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

@VisibleForTesting
class c implements Runnable {
    final /* synthetic */ ImpressionTracker a;
    @NonNull
    private final ArrayList<View> b = new ArrayList();

    c(ImpressionTracker impressionTracker) {
        this.a = impressionTracker;
    }

    public void run() {
        for (Entry entry : this.a.c.entrySet()) {
            View view = (View) entry.getKey();
            w wVar = (w) entry.getValue();
            if (this.a.f.a(wVar.b, ((ImpressionInterface) wVar.a).getImpressionMinTimeViewed())) {
                ((ImpressionInterface) wVar.a).recordImpression(view);
                ((ImpressionInterface) wVar.a).setImpressionRecorded();
                this.b.add(view);
            }
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            this.a.removeView((View) it.next());
        }
        this.b.clear();
        if (!this.a.c.isEmpty()) {
            this.a.a();
        }
    }
}
