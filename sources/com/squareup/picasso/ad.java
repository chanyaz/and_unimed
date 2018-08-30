package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.squareup.picasso.Picasso.Priority;
import java.util.List;

public final class ad {
    private Uri a;
    private int b;
    private String c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private List<Transformation> m;
    private Config n;
    private Priority o;

    ad(Uri uri, int i, Config config) {
        this.a = uri;
        this.b = i;
        this.n = config;
    }

    public ad a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Width must be positive number or 0.");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Height must be positive number or 0.");
        } else if (i2 == 0 && i == 0) {
            throw new IllegalArgumentException("At least one dimension has to be positive number.");
        } else {
            this.d = i;
            this.e = i2;
            return this;
        }
    }

    boolean a() {
        return (this.a == null && this.b == 0) ? false : true;
    }

    boolean b() {
        return (this.d == 0 && this.e == 0) ? false : true;
    }

    public ac c() {
        if (this.g && this.f) {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        } else if (this.f && this.d == 0 && this.e == 0) {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        } else if (this.g && this.d == 0 && this.e == 0) {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        } else {
            if (this.o == null) {
                this.o = Priority.NORMAL;
            }
            return new ac(this.a, this.b, this.c, this.m, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
