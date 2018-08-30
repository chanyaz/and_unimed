package com.puzzlersworld.android.util;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public abstract class d implements OnScrollListener {
    private int a = 5;
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private int e = 0;

    public d(int i) {
        this.e = i;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
        this.b = i;
        this.d = false;
    }

    public abstract void a(int i, int i2);

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i3 < this.c) {
            this.b = this.e;
            this.c = i3;
            if (i3 == 0) {
                this.d = true;
            }
        }
        if (this.d && i3 > this.c) {
            this.d = false;
            this.c = i3;
            this.b++;
        }
        if (!this.d && i3 - i2 <= this.a + i) {
            a(this.b + 1, i3);
            this.d = true;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
