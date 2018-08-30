package com.mikepenz.iconics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mikepenz.iconics.a.b;
import com.mikepenz.iconics.d;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.utils.e;

public class IconicsImageView extends ImageView {
    private d a;
    @ColorInt
    private int b;
    private int c;
    private int d;
    @ColorInt
    private int e;
    private int f;
    @ColorInt
    private int g;
    private int h;

    public IconicsImageView(Context context) {
        this(context, null);
    }

    public IconicsImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconicsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = 0;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = -1;
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.IconicsImageView, i, 0);
            String string = obtainStyledAttributes.getString(b.IconicsImageView_iiv_icon);
            this.b = obtainStyledAttributes.getColor(b.IconicsImageView_iiv_color, 0);
            this.c = obtainStyledAttributes.getDimensionPixelSize(b.IconicsImageView_iiv_size, -1);
            this.d = obtainStyledAttributes.getDimensionPixelSize(b.IconicsImageView_iiv_padding, -1);
            this.e = obtainStyledAttributes.getColor(b.IconicsImageView_iiv_contour_color, 0);
            this.f = obtainStyledAttributes.getDimensionPixelSize(b.IconicsImageView_iiv_contour_width, -1);
            this.g = obtainStyledAttributes.getColor(b.IconicsImageView_iiv_background_color, 0);
            this.h = obtainStyledAttributes.getDimensionPixelSize(b.IconicsImageView_iiv_corner_radius, -1);
            obtainStyledAttributes.recycle();
            setScaleType(ScaleType.CENTER_INSIDE);
            if (string != null) {
                this.a = new d(context, string);
                a();
                setImageDrawable(this.a);
            }
        }
    }

    private void a() {
        if (this.b != 0) {
            this.a.a(this.b);
        }
        if (this.c != -1) {
            this.a.j(this.c);
        }
        if (this.d != -1) {
            this.a.g(this.d);
        }
        if (this.e != 0) {
            this.a.m(this.e);
        }
        if (this.f != -1) {
            this.a.w(this.f);
        }
        if (this.g != 0) {
            this.a.o(this.g);
        }
        if (this.h != -1) {
            this.a.t(this.h);
        }
    }

    public void a(d dVar, boolean z) {
        this.a = dVar;
        if (z) {
            a();
        }
        setImageDrawable(this.a);
    }

    public void a(IIcon iIcon, boolean z) {
        a(new d(getContext(), iIcon), z);
    }

    public void a(Character ch, boolean z) {
        a(new d(getContext(), ch), z);
    }

    public void a(String str, boolean z) {
        a(new d(getContext(), str), z);
    }

    public void b(String str, boolean z) {
        a(new d(getContext()).a(str), z);
    }

    public d getIcon() {
        return getDrawable() instanceof d ? (d) getDrawable() : this.a;
    }

    public void setBackgroundColor(@ColorInt int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).o(i);
        }
        this.g = i;
    }

    public void setBackgroundColorRes(@ColorRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).p(i);
        }
        this.g = a.c(getContext(), i);
    }

    public void setColor(@ColorInt int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).a(i);
        }
        this.b = i;
    }

    public void setColorRes(@ColorRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).b(i);
        }
        this.b = a.c(getContext(), i);
    }

    public void setContourColor(@ColorInt int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).m(i);
        }
        this.e = i;
    }

    public void setContourColorRes(@ColorRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).n(i);
        }
        this.e = a.c(getContext(), i);
    }

    public void setContourWidthDp(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).v(i);
        }
        this.f = e.a(getContext(), (float) i);
    }

    public void setContourWidthPx(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).w(i);
        }
        this.f = i;
    }

    public void setContourWidthRes(@DimenRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).u(i);
        }
        this.f = getContext().getResources().getDimensionPixelSize(i);
    }

    public void setIcon(d dVar) {
        a(dVar, true);
    }

    public void setIcon(IIcon iIcon) {
        a(iIcon, true);
    }

    public void setIcon(Character ch) {
        a(ch, true);
    }

    public void setIcon(String str) {
        a(str, true);
    }

    public void setIconText(String str) {
        b(str, true);
    }

    public void setPaddingDp(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).f(i);
        }
        this.d = e.a(getContext(), (float) i);
    }

    public void setPaddingPx(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).g(i);
        }
        this.d = i;
    }

    public void setPaddingRes(@DimenRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).e(i);
        }
        this.d = getContext().getResources().getDimensionPixelSize(i);
    }

    public void setRoundedCornersDp(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).s(i);
        }
        this.h = e.a(getContext(), (float) i);
    }

    public void setRoundedCornersPx(int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).s(i);
        }
        this.h = i;
    }

    public void setRoundedCornersRes(@DimenRes int i) {
        if (getDrawable() instanceof d) {
            ((d) getDrawable()).t(i);
        }
        this.h = getContext().getResources().getDimensionPixelSize(i);
    }
}
