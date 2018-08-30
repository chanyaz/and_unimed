package com.puzzlersworld.android.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.OverScroller;
import android.widget.Scroller;

@TargetApi(9)
class n {
    Scroller a;
    OverScroller b;
    boolean c;
    final /* synthetic */ TouchImageView d;

    public n(TouchImageView touchImageView, Context context) {
        this.d = touchImageView;
        if (VERSION.SDK_INT < 9) {
            this.c = true;
            this.a = new Scroller(context);
            return;
        }
        this.c = false;
        this.b = new OverScroller(context);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.c) {
            this.a.fling(i, i2, i3, i4, i5, i6, i7, i8);
        } else {
            this.b.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    public void a(boolean z) {
        if (this.c) {
            this.a.forceFinished(z);
        } else {
            this.b.forceFinished(z);
        }
    }

    public boolean a() {
        return this.c ? this.a.isFinished() : this.b.isFinished();
    }

    public boolean b() {
        if (this.c) {
            return this.a.computeScrollOffset();
        }
        this.b.computeScrollOffset();
        return this.b.computeScrollOffset();
    }

    public int c() {
        return this.c ? this.a.getCurrX() : this.b.getCurrX();
    }

    public int d() {
        return this.c ? this.a.getCurrY() : this.b.getCurrY();
    }
}
