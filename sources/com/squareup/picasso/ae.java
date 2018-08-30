package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.util.concurrent.atomic.AtomicInteger;

public class ae {
    private static final AtomicInteger a = new AtomicInteger();
    private final Picasso b;
    private final ad c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    ae() {
        this.f = true;
        this.b = null;
        this.c = new ad(null, 0, null);
    }

    ae(Picasso picasso, Uri uri, int i) {
        this.f = true;
        if (picasso.m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.b = picasso;
        this.c = new ad(uri, i, picasso.j);
    }

    private ac a(long j) {
        int andIncrement = a.getAndIncrement();
        ac c = this.c.c();
        c.a = andIncrement;
        c.b = j;
        boolean z = this.b.l;
        if (z) {
            ao.a("Main", "created", c.b(), c.toString());
        }
        ac a = this.b.a(c);
        if (a != c) {
            a.a = andIncrement;
            a.b = j;
            if (z) {
                ao.a("Main", "changed", a.a(), "into " + a);
            }
        }
        return a;
    }

    private Drawable c() {
        return this.g != 0 ? this.b.c.getResources().getDrawable(this.g) : this.k;
    }

    ae a() {
        this.e = false;
        return this;
    }

    public ae a(int i) {
        if (!this.f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.k != null) {
            throw new IllegalStateException("Placeholder image already set.");
        } else {
            this.g = i;
            return this;
        }
    }

    public ae a(int i, int i2) {
        this.c.a(i, i2);
        return this;
    }

    public void a(ImageView imageView) {
        a(imageView, null);
    }

    public void a(ImageView imageView, Callback callback) {
        long nanoTime = System.nanoTime();
        ao.b();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.c.a()) {
            if (this.e) {
                if (this.c.b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.f) {
                        z.a(imageView, c());
                    }
                    this.b.a(imageView, new h(this, imageView, callback));
                    return;
                }
                this.c.a(width, height);
            }
            ac a = a(nanoTime);
            String a2 = ao.a(a);
            if (MemoryPolicy.a(this.i)) {
                Bitmap b = this.b.b(a2);
                if (b != null) {
                    this.b.a(imageView);
                    z.a(imageView, this.b.c, b, LoadedFrom.MEMORY, this.d, this.b.k);
                    if (this.b.l) {
                        ao.a("Main", "completed", a.b(), "from " + LoadedFrom.MEMORY);
                    }
                    if (callback != null) {
                        callback.onSuccess();
                        return;
                    }
                    return;
                }
            }
            if (this.f) {
                z.a(imageView, c());
            }
            this.b.a(new p(this.b, imageView, a, this.i, this.j, this.h, this.l, a2, this.m, callback, this.d));
        } else {
            this.b.a(imageView);
            if (this.f) {
                z.a(imageView, c());
            }
        }
    }

    public void a(Target target) {
        Drawable drawable = null;
        long nanoTime = System.nanoTime();
        ao.b();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else if (this.c.a()) {
            ac a = a(nanoTime);
            String a2 = ao.a(a);
            if (MemoryPolicy.a(this.i)) {
                Bitmap b = this.b.b(a2);
                if (b != null) {
                    this.b.a(target);
                    target.onBitmapLoaded(b, LoadedFrom.MEMORY);
                    return;
                }
            }
            if (this.f) {
                drawable = c();
            }
            target.onPrepareLoad(drawable);
            this.b.a(new al(this.b, target, a, this.i, this.j, this.l, a2, this.m, this.h));
        } else {
            this.b.a(target);
            if (this.f) {
                drawable = c();
            }
            target.onPrepareLoad(drawable);
        }
    }

    public Bitmap b() {
        long nanoTime = System.nanoTime();
        ao.a();
        if (this.e) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.c.a()) {
            return null;
        } else {
            ac a = a(nanoTime);
            return d.a(this.b, this.b.d, this.b.e, this.b.f, new o(this.b, a, this.i, this.j, this.m, ao.a(a, new StringBuilder()))).a();
        }
    }
}
