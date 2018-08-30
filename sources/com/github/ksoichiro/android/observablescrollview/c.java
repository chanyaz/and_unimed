package com.github.ksoichiro.android.observablescrollview;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public final class c {
    private c() {
    }

    public static float a(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f2, f));
    }

    public static int a(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (255.0f * f))) << 24) + (16777215 & i);
    }

    public static void a(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (VERSION.SDK_INT < 16) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                runnable.run();
            }
        });
    }
}
