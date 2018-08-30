package com.mikepenz.iconics.utils;

import android.content.Context;
import android.util.TypedValue;

public class e {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
