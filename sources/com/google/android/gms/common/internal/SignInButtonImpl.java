package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.a.b;
import com.google.android.gms.a.c;
import com.google.android.gms.a.d;
import com.google.android.gms.common.util.g;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    public final void a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
        int a = a(i2, c.common_google_signin_btn_icon_dark, c.common_google_signin_btn_icon_light, c.common_google_signin_btn_icon_light);
        int a2 = a(i2, c.common_google_signin_btn_text_dark, c.common_google_signin_btn_text_light, c.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                break;
            case 2:
                a2 = a;
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        Drawable g = a.g(resources.getDrawable(a2));
        a.a(g, resources.getColorStateList(b.common_google_signin_btn_tint));
        a.a(g, Mode.SRC_ATOP);
        setBackgroundDrawable(g);
        setTextColor((ColorStateList) ar.a(resources.getColorStateList(a(i2, b.common_google_signin_btn_text_dark, b.common_google_signin_btn_text_light, b.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(d.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(d.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
        if (g.a(getContext())) {
            setGravity(19);
        }
    }
}
