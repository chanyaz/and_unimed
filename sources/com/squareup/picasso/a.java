package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import java.lang.ref.WeakReference;

abstract class a<T> {
    final Picasso a;
    final ac b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    a(Picasso picasso, T t, ac acVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.a = picasso;
        this.b = acVar;
        this.c = t == null ? null : new b(this, t, picasso.i);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        if (obj == null) {
            a obj2 = this;
        }
        this.j = obj2;
    }

    abstract void a();

    abstract void a(Bitmap bitmap, LoadedFrom loadedFrom);

    void b() {
        this.l = true;
    }

    ac c() {
        return this.b;
    }

    T d() {
        return this.c == null ? null : this.c.get();
    }

    String e() {
        return this.i;
    }

    boolean f() {
        return this.l;
    }

    boolean g() {
        return this.k;
    }

    int h() {
        return this.e;
    }

    int i() {
        return this.f;
    }

    Picasso j() {
        return this.a;
    }

    Priority k() {
        return this.b.r;
    }

    Object l() {
        return this.j;
    }
}
