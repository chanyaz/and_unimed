package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.widget.EdgeEffect;

public final class r {
    private static final t b;
    private EdgeEffect a;

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new s();
        } else {
            b = new t();
        }
    }

    @Deprecated
    public r(Context context) {
        this.a = new EdgeEffect(context);
    }

    public static void a(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        b.a(edgeEffect, f, f2);
    }

    @Deprecated
    public void a(int i, int i2) {
        this.a.setSize(i, i2);
    }

    @Deprecated
    public boolean a() {
        return this.a.isFinished();
    }

    @Deprecated
    public boolean a(float f) {
        this.a.onPull(f);
        return true;
    }

    @Deprecated
    public boolean a(Canvas canvas) {
        return this.a.draw(canvas);
    }

    @Deprecated
    public void b() {
        this.a.finish();
    }

    @Deprecated
    public boolean c() {
        this.a.onRelease();
        return this.a.isFinished();
    }
}
