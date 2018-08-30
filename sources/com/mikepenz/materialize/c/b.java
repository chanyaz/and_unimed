package com.mikepenz.materialize.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.a;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.mikepenz.materialize.d;
import com.mikepenz.materialize.f;

@SuppressLint({"InlinedApi"})
public class b {
    public static float a(float f, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    public static int a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    public static int a(Context context, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i, typedValue, true) ? typedValue.data : 0;
    }

    public static int a(Context context, @AttrRes int i, @ColorRes int i2) {
        int a = a(context, i);
        return a == 0 ? a.c(context, i2) : a;
    }

    public static int a(Context context, boolean z) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        identifier = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(f.tool_bar_top_padding);
        if (dimensionPixelSize == 0 && !z) {
            return 0;
        }
        if (identifier == 0) {
            identifier = dimensionPixelSize;
        }
        return identifier;
    }

    public static StateListDrawable a(Context context, int i, boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = new int[]{16842913};
        stateListDrawable.addState(iArr, new ColorDrawable(i));
        stateListDrawable.addState(new int[0], e(context));
        int integer = context.getResources().getInteger(17694720);
        stateListDrawable.setEnterFadeDuration(integer);
        stateListDrawable.setExitFadeDuration(integer);
        return stateListDrawable;
    }

    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static void a(Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= i;
        } else {
            attributes.flags &= i ^ -1;
        }
        window.setAttributes(attributes);
    }

    public static void a(Activity activity, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            a(activity, 67108864, z);
        }
    }

    public static void a(View view, @DrawableRes int i) {
        a(view, a.a(view.getContext(), i));
    }

    @SuppressLint({"NewApi"})
    public static void a(View view, Drawable drawable) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static int b(Context context) {
        int b = b(context, d.actionBarSize);
        return b == 0 ? context.getResources().getDimensionPixelSize(f.abc_action_bar_default_height_material) : b;
    }

    public static int b(Context context, @AttrRes int i) {
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{i});
            int dimensionPixelSize = typedArray.getDimensionPixelSize(0, 0);
            return dimensionPixelSize;
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public static void b(Activity activity, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            a(activity, 134217728, z);
        }
    }

    public static int c(Context context) {
        return a(context, false);
    }

    public static int d(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.selectableItemBackground, typedValue, true);
        return typedValue.resourceId;
    }

    public static Drawable e(Context context) {
        return a.a(context, d(context));
    }

    public static int f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
