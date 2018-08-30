package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.mopub.common.util.Dips;

class g {
    @NonNull
    private final Context a;
    @NonNull
    private final Rect b = new Rect();
    @NonNull
    private final Rect c = new Rect();
    @NonNull
    private final Rect d = new Rect();
    @NonNull
    private final Rect e = new Rect();
    @NonNull
    private final Rect f = new Rect();
    @NonNull
    private final Rect g = new Rect();
    @NonNull
    private final Rect h = new Rect();
    @NonNull
    private final Rect i = new Rect();
    private final float j;

    g(Context context, float f) {
        this.a = context.getApplicationContext();
        this.j = f;
    }

    private void a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips((float) rect.left, this.a), Dips.pixelsToIntDips((float) rect.top, this.a), Dips.pixelsToIntDips((float) rect.right, this.a), Dips.pixelsToIntDips((float) rect.bottom, this.a));
    }

    @NonNull
    Rect a() {
        return this.c;
    }

    void a(int i, int i2) {
        this.b.set(0, 0, i, i2);
        a(this.b, this.c);
    }

    void a(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i + i3, i2 + i4);
        a(this.d, this.e);
    }

    @NonNull
    Rect b() {
        return this.d;
    }

    void b(int i, int i2, int i3, int i4) {
        this.f.set(i, i2, i + i3, i2 + i4);
        a(this.f, this.g);
    }

    @NonNull
    Rect c() {
        return this.e;
    }

    void c(int i, int i2, int i3, int i4) {
        this.h.set(i, i2, i + i3, i2 + i4);
        a(this.h, this.i);
    }

    @NonNull
    Rect d() {
        return this.f;
    }

    @NonNull
    Rect e() {
        return this.g;
    }

    @NonNull
    Rect f() {
        return this.h;
    }

    @NonNull
    Rect g() {
        return this.i;
    }

    public float getDensity() {
        return this.j;
    }
}
