package com.mikepenz.materialdrawer.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.mikepenz.iconics.d;
import com.mikepenz.materialdrawer.f;
import com.mikepenz.materialdrawer.g;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont.Icon;

@SuppressLint({"InlinedApi"})
public class b {
    public static int a(Context context) {
        return Math.min(com.mikepenz.materialize.c.b.f(context) - com.mikepenz.materialize.c.b.b(context), context.getResources().getDimensionPixelSize(g.material_drawer_width));
    }

    public static ColorStateList a(int i, int i2) {
        r1 = new int[2][];
        r1[0] = new int[]{16842913};
        r1[1] = new int[0];
        return new ColorStateList(r1, new int[]{i2, i});
    }

    public static void a(View view) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(g.material_drawer_vertical_padding);
        view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public static void a(View view, int i) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(g.material_drawer_vertical_padding);
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(dimensionPixelSize * i, 0, dimensionPixelSize, 0);
        } else {
            view.setPadding(dimensionPixelSize * i, 0, dimensionPixelSize, 0);
        }
    }

    public static Drawable b(Context context) {
        return new d(context, Icon.mdf_person).b(f.accent).p(f.primary).i(56).f(16);
    }

    public static boolean c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Object obj = (displayMetrics.widthPixels == displayMetrics.heightPixels || context.getResources().getConfiguration().smallestScreenWidthDp >= 600) ? null : 1;
        return obj == null || displayMetrics.widthPixels < displayMetrics.heightPixels;
    }
}
