package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;

class y {
    private final Rect a = new Rect();

    y() {
    }

    boolean a(long j, int i) {
        return SystemClock.uptimeMillis() - j >= ((long) i);
    }

    boolean a(@Nullable View view, @Nullable View view2, int i) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || !view2.getGlobalVisibleRect(this.a)) {
            return false;
        }
        long height = ((long) view2.getHeight()) * ((long) view2.getWidth());
        return height > 0 && (((long) this.a.height()) * ((long) this.a.width())) * 100 >= height * ((long) i);
    }
}
