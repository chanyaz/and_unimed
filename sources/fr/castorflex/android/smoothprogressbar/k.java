package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable.Callbacks;

public class k {
    private Interpolator a;
    private int b;
    private int[] c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private float i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Drawable n;
    private Callbacks o;

    public k(Context context) {
        a(context);
    }

    private void a(Context context) {
        Resources resources = context.getResources();
        this.a = new AccelerateInterpolator();
        this.b = resources.getInteger(g.spb_default_sections_count);
        this.c = new int[]{resources.getColor(e.spb_default_color)};
        this.d = Float.parseFloat(resources.getString(h.spb_default_speed));
        this.e = this.d;
        this.f = this.d;
        this.g = resources.getBoolean(d.spb_default_reversed);
        this.j = resources.getDimensionPixelSize(f.spb_default_stroke_separator_length);
        this.i = (float) resources.getDimensionPixelOffset(f.spb_default_stroke_width);
        this.k = resources.getBoolean(d.spb_default_progressiveStart_activated);
        this.m = false;
    }

    public SmoothProgressDrawable a() {
        if (this.l) {
            this.n = j.a(this.c, this.i);
        }
        return new SmoothProgressDrawable(this.a, this.b, this.j, this.c, this.i, this.d, this.e, this.f, this.g, this.h, this.o, this.k, this.n, this.m, null);
    }

    public k a(float f) {
        j.a(f, "Width");
        this.i = f;
        return this;
    }

    public k a(int i) {
        j.a(i, "Sections count");
        this.b = i;
        return this;
    }

    public k a(Drawable drawable) {
        this.n = drawable;
        return this;
    }

    public k a(Interpolator interpolator) {
        j.a((Object) interpolator, "Interpolator");
        this.a = interpolator;
        return this;
    }

    public k a(boolean z) {
        this.g = z;
        return this;
    }

    public k a(int[] iArr) {
        j.a(iArr);
        this.c = iArr;
        return this;
    }

    public k b() {
        this.l = true;
        return this;
    }

    public k b(float f) {
        j.a(f);
        this.d = f;
        return this;
    }

    public k b(int i) {
        j.a((float) i, "Separator length");
        this.j = i;
        return this;
    }

    public k b(boolean z) {
        this.h = z;
        return this;
    }

    public k c(float f) {
        j.a(f);
        this.e = f;
        return this;
    }

    public k c(int i) {
        this.c = new int[]{i};
        return this;
    }

    public k c(boolean z) {
        this.k = z;
        return this;
    }

    public k d(float f) {
        j.a(f);
        this.f = f;
        return this;
    }

    public k d(boolean z) {
        this.m = z;
        return this;
    }
}
