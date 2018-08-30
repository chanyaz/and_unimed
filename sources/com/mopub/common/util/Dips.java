package com.mopub.common.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import com.mopub.common.Preconditions;

public class Dips {
    private static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float asFloatPixels(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float f, Context context) {
        return (int) (asFloatPixels(f, context) + 0.5f);
    }

    public static float dipsToFloatPixels(float f, Context context) {
        return a(context) * f;
    }

    public static int dipsToIntPixels(float f, Context context) {
        return (int) (dipsToFloatPixels(f, context) + 0.5f);
    }

    public static float pixelsToFloatDips(float f, Context context) {
        return f / a(context);
    }

    public static int pixelsToIntDips(float f, Context context) {
        return (int) (pixelsToFloatDips(f, context) + 0.5f);
    }

    public static int screenHeightAsIntDips(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips((float) context.getResources().getDisplayMetrics().heightPixels, context);
    }

    public static int screenWidthAsIntDips(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips((float) context.getResources().getDisplayMetrics().widthPixels, context);
    }
}
