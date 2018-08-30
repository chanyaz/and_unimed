package com.mikepenz.materialize.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.widget.TextView;
import com.mikepenz.materialize.c.b;

public class a {
    private int a = 0;
    private int b = -1;

    public static int a(a aVar, Context context, @AttrRes int i, @ColorRes int i2) {
        return aVar == null ? b.a(context, i, i2) : aVar.a(context, i, i2);
    }

    public static void a(a aVar, Context context, GradientDrawable gradientDrawable) {
        if (aVar != null && gradientDrawable != null) {
            aVar.a(context, gradientDrawable);
        } else if (gradientDrawable != null) {
            gradientDrawable.setColor(0);
        }
    }

    public static void a(a aVar, TextView textView, ColorStateList colorStateList) {
        if (aVar != null && textView != null) {
            aVar.a(textView, colorStateList);
        } else if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public int a(Context context) {
        if (this.a == 0 && this.b != -1) {
            this.a = android.support.v4.content.a.c(context, this.b);
        }
        return this.a;
    }

    public int a(Context context, @AttrRes int i, @ColorRes int i2) {
        int a = a(context);
        return a == 0 ? b.a(context, i, i2) : a;
    }

    public void a(Context context, GradientDrawable gradientDrawable) {
        if (this.a != 0) {
            gradientDrawable.setColor(this.a);
        } else if (this.b != -1) {
            gradientDrawable.setColor(android.support.v4.content.a.c(context, this.b));
        }
    }

    public void a(TextView textView, ColorStateList colorStateList) {
        if (this.a != 0) {
            textView.setTextColor(this.a);
        } else if (this.b != -1) {
            textView.setTextColor(android.support.v4.content.a.c(textView.getContext(), this.b));
        } else if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void b(int i) {
        this.a = i;
    }
}
