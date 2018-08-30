package com.mikepenz.materialize.b;

import android.content.Context;

public class b {
    private int a = Integer.MIN_VALUE;
    private int b = Integer.MIN_VALUE;
    private int c = Integer.MIN_VALUE;

    public int a(Context context) {
        return this.a != Integer.MIN_VALUE ? this.a : this.b != Integer.MIN_VALUE ? (int) com.mikepenz.materialize.c.b.a((float) this.b, context) : this.c != Integer.MIN_VALUE ? context.getResources().getDimensionPixelSize(this.c) : 0;
    }

    public void b(int i) {
        this.b = i;
    }
}
