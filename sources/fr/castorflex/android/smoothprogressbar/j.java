package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

public final class j {
    private j() {
    }

    public static Drawable a(int[] iArr, float f) {
        return (iArr == null || iArr.length == 0) ? null : new ShapeDrawable(new a(f, iArr));
    }

    static void a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    static void a(float f, String str) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format("%s %d must be positive", new Object[]{str, Float.valueOf(f)}));
        }
    }

    static void a(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("%s must not be null", new Object[]{str}));
        }
    }

    static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("%s must be not null", new Object[]{str}));
        }
    }

    static void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least 1 color");
        }
    }
}
