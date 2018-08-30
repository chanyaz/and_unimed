package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class d implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() {
        /* renamed from: a */
        protected StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final af w = new af() {
        public ag a(ac acVar, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + acVar);
        }

        public boolean a(ac acVar) {
            return true;
        }
    };
    final int a = v.incrementAndGet();
    final Picasso b;
    final i c;
    final Cache d;
    final ai e;
    final String f;
    final ac g;
    final int h;
    int i;
    final af j;
    a k;
    List<a> l;
    Bitmap m;
    Future<?> n;
    LoadedFrom o;
    Exception p;
    int q;
    int r;
    Priority s;

    d(Picasso picasso, i iVar, Cache cache, ai aiVar, a aVar, af afVar) {
        this.b = picasso;
        this.c = iVar;
        this.d = cache;
        this.e = aiVar;
        this.k = aVar;
        this.f = aVar.e();
        this.g = aVar.c();
        this.s = aVar.k();
        this.h = aVar.h();
        this.i = aVar.i();
        this.j = afVar;
        this.r = afVar.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    static android.graphics.Bitmap a(com.squareup.picasso.ac r16, android.graphics.Bitmap r17, int r18) {
        /*
        r8 = r17.getWidth();
        r5 = r17.getHeight();
        r0 = r16;
        r11 = r0.l;
        r9 = 0;
        r6 = 0;
        r7 = new android.graphics.Matrix;
        r7.<init>();
        r2 = r16.f();
        if (r2 == 0) goto L_0x00da;
    L_0x0019:
        r0 = r16;
        r12 = r0.h;
        r0 = r16;
        r13 = r0.i;
        r0 = r16;
        r2 = r0.m;
        r3 = 0;
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 == 0) goto L_0x003b;
    L_0x002a:
        r0 = r16;
        r3 = r0.p;
        if (r3 == 0) goto L_0x0085;
    L_0x0030:
        r0 = r16;
        r3 = r0.n;
        r0 = r16;
        r4 = r0.o;
        r7.setRotate(r2, r3, r4);
    L_0x003b:
        r0 = r16;
        r2 = r0.j;
        if (r2 == 0) goto L_0x009e;
    L_0x0041:
        r2 = (float) r12;
        r3 = (float) r8;
        r3 = r2 / r3;
        r2 = (float) r13;
        r4 = (float) r5;
        r2 = r2 / r4;
        r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0089;
    L_0x004c:
        r4 = (float) r5;
        r2 = r2 / r3;
        r2 = r2 * r4;
        r14 = (double) r2;
        r14 = java.lang.Math.ceil(r14);
        r4 = (int) r14;
        r2 = r5 - r4;
        r6 = r2 / 2;
        r2 = (float) r13;
        r10 = (float) r4;
        r2 = r2 / r10;
        r10 = r9;
        r9 = r6;
        r6 = r8;
    L_0x005f:
        r5 = a(r11, r8, r5, r12, r13);
        if (r5 == 0) goto L_0x0068;
    L_0x0065:
        r7.preScale(r3, r2);
    L_0x0068:
        r5 = r6;
        r3 = r10;
        r6 = r4;
        r4 = r9;
    L_0x006c:
        if (r18 == 0) goto L_0x0074;
    L_0x006e:
        r0 = r18;
        r2 = (float) r0;
        r7.preRotate(r2);
    L_0x0074:
        r8 = 1;
        r2 = r17;
        r2 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8);
        r0 = r17;
        if (r2 == r0) goto L_0x0084;
    L_0x007f:
        r17.recycle();
        r17 = r2;
    L_0x0084:
        return r17;
    L_0x0085:
        r7.setRotate(r2);
        goto L_0x003b;
    L_0x0089:
        r4 = (float) r8;
        r3 = r3 / r2;
        r3 = r3 * r4;
        r14 = (double) r3;
        r14 = java.lang.Math.ceil(r14);
        r4 = (int) r14;
        r3 = r8 - r4;
        r9 = r3 / 2;
        r3 = (float) r12;
        r10 = (float) r4;
        r3 = r3 / r10;
        r10 = r9;
        r9 = r6;
        r6 = r4;
        r4 = r5;
        goto L_0x005f;
    L_0x009e:
        r0 = r16;
        r2 = r0.k;
        if (r2 == 0) goto L_0x00be;
    L_0x00a4:
        r2 = (float) r12;
        r3 = (float) r8;
        r2 = r2 / r3;
        r3 = (float) r13;
        r4 = (float) r5;
        r3 = r3 / r4;
        r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r4 >= 0) goto L_0x00bc;
    L_0x00ae:
        r3 = a(r11, r8, r5, r12, r13);
        if (r3 == 0) goto L_0x00b7;
    L_0x00b4:
        r7.preScale(r2, r2);
    L_0x00b7:
        r4 = r6;
        r3 = r9;
        r6 = r5;
        r5 = r8;
        goto L_0x006c;
    L_0x00bc:
        r2 = r3;
        goto L_0x00ae;
    L_0x00be:
        if (r12 != 0) goto L_0x00c2;
    L_0x00c0:
        if (r13 == 0) goto L_0x00da;
    L_0x00c2:
        if (r12 != r8) goto L_0x00c6;
    L_0x00c4:
        if (r13 == r5) goto L_0x00da;
    L_0x00c6:
        if (r12 == 0) goto L_0x00df;
    L_0x00c8:
        r2 = (float) r12;
        r3 = (float) r8;
        r2 = r2 / r3;
        r3 = r2;
    L_0x00cc:
        if (r13 == 0) goto L_0x00e4;
    L_0x00ce:
        r2 = (float) r13;
        r4 = (float) r5;
        r2 = r2 / r4;
    L_0x00d1:
        r4 = a(r11, r8, r5, r12, r13);
        if (r4 == 0) goto L_0x00da;
    L_0x00d7:
        r7.preScale(r3, r2);
    L_0x00da:
        r4 = r6;
        r3 = r9;
        r6 = r5;
        r5 = r8;
        goto L_0x006c;
    L_0x00df:
        r2 = (float) r13;
        r3 = (float) r5;
        r2 = r2 / r3;
        r3 = r2;
        goto L_0x00cc;
    L_0x00e4:
        r2 = (float) r12;
        r4 = (float) r8;
        r2 = r2 / r4;
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.d.a(com.squareup.picasso.ac, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static Bitmap a(InputStream inputStream, ac acVar) {
        InputStream rVar = new r(inputStream);
        long a = rVar.a(65536);
        Options c = af.c(acVar);
        boolean a2 = af.a(c);
        boolean c2 = ao.c(rVar);
        rVar.a(a);
        if (c2) {
            byte[] b = ao.b(rVar);
            if (a2) {
                BitmapFactory.decodeByteArray(b, 0, b.length, c);
                af.a(acVar.h, acVar.i, c, acVar);
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length, c);
        }
        if (a2) {
            BitmapFactory.decodeStream(rVar, null, c);
            af.a(acVar.h, acVar.i, c, acVar);
            rVar.a(a);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(rVar, null, c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    static Bitmap a(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            final Transformation transformation = (Transformation) list.get(i);
            try {
                bitmap = transformation.transform(bitmap2);
                if (bitmap == null) {
                    final StringBuilder append = new StringBuilder().append("Transformation ").append(transformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation transformation2 : list) {
                        append.append(transformation2.key()).append(10);
                    }
                    Picasso.a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(append.toString());
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                    Picasso.a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation2.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmap;
                } else {
                    Picasso.a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation2.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (final RuntimeException e) {
                Picasso.a.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + transformation2.key() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap2;
    }

    static d a(Picasso picasso, i iVar, Cache cache, ai aiVar, a aVar) {
        ac c = aVar.c();
        List a = picasso.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            af afVar = (af) a.get(i);
            if (afVar.a(c)) {
                return new d(picasso, iVar, cache, aiVar, aVar, afVar);
            }
        }
        return new d(picasso, iVar, cache, aiVar, aVar, w);
    }

    static void a(ac acVar) {
        String c = acVar.c();
        StringBuilder stringBuilder = (StringBuilder) u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    private Priority o() {
        int i = 1;
        int i2 = 0;
        Priority priority = Priority.LOW;
        int i3 = (this.l == null || this.l.isEmpty()) ? 0 : 1;
        if (this.k == null && i3 == 0) {
            i = 0;
        }
        if (i == 0) {
            return priority;
        }
        Priority k = this.k != null ? this.k.k() : priority;
        if (i3 == 0) {
            return k;
        }
        int size = this.l.size();
        while (i2 < size) {
            Priority k2 = ((a) this.l.get(i2)).k();
            if (k2.ordinal() <= k.ordinal()) {
                k2 = k;
            }
            i2++;
            k = k2;
        }
        return k;
    }

    Bitmap a() {
        Bitmap bitmap = null;
        if (MemoryPolicy.a(this.h)) {
            bitmap = this.d.get(this.f);
            if (bitmap != null) {
                this.e.a();
                this.o = LoadedFrom.MEMORY;
                if (this.b.l) {
                    ao.a("Hunter", "decoded", this.g.a(), "from cache");
                }
                return bitmap;
            }
        }
        this.g.c = this.r == 0 ? NetworkPolicy.OFFLINE.d : this.i;
        ag a = this.j.a(this.g, this.i);
        if (a != null) {
            this.o = a.c();
            this.q = a.d();
            bitmap = a.a();
            if (bitmap == null) {
                InputStream b = a.b();
                try {
                    bitmap = a(b, this.g);
                } finally {
                    ao.a(b);
                }
            }
        }
        if (bitmap != null) {
            if (this.b.l) {
                ao.a("Hunter", "decoded", this.g.a());
            }
            this.e.a(bitmap);
            if (this.g.e() || this.q != 0) {
                synchronized (t) {
                    if (this.g.f() || this.q != 0) {
                        bitmap = a(this.g, bitmap, this.q);
                        if (this.b.l) {
                            ao.a("Hunter", "transformed", this.g.a());
                        }
                    }
                    if (this.g.g()) {
                        bitmap = a(this.g.g, bitmap);
                        if (this.b.l) {
                            ao.a("Hunter", "transformed", this.g.a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.e.b(bitmap);
                }
            }
        }
        return bitmap;
    }

    void a(a aVar) {
        boolean z = this.b.l;
        ac acVar = aVar.b;
        if (this.k == null) {
            this.k = aVar;
            if (!z) {
                return;
            }
            if (this.l == null || this.l.isEmpty()) {
                ao.a("Hunter", "joined", acVar.a(), "to empty hunter");
                return;
            } else {
                ao.a("Hunter", "joined", acVar.a(), ao.a(this, "to "));
                return;
            }
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add(aVar);
        if (z) {
            ao.a("Hunter", "joined", acVar.a(), ao.a(this, "to "));
        }
        Priority k = aVar.k();
        if (k.ordinal() > this.s.ordinal()) {
            this.s = k;
        }
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.r > 0)) {
            return false;
        }
        this.r--;
        return this.j.a(z, networkInfo);
    }

    void b(a aVar) {
        boolean z = false;
        if (this.k == aVar) {
            this.k = null;
            z = true;
        } else if (this.l != null) {
            z = this.l.remove(aVar);
        }
        if (z && aVar.k() == this.s) {
            this.s = o();
        }
        if (this.b.l) {
            ao.a("Hunter", "removed", aVar.b.a(), ao.a(this, "from "));
        }
    }

    boolean b() {
        return this.k == null ? (this.l == null || this.l.isEmpty()) && this.n != null && this.n.cancel(false) : false;
    }

    boolean c() {
        return this.n != null && this.n.isCancelled();
    }

    boolean d() {
        return this.j.b();
    }

    Bitmap e() {
        return this.m;
    }

    String f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    ac h() {
        return this.g;
    }

    a i() {
        return this.k;
    }

    Picasso j() {
        return this.b;
    }

    List<a> k() {
        return this.l;
    }

    Exception l() {
        return this.p;
    }

    LoadedFrom m() {
        return this.o;
    }

    Priority n() {
        return this.s;
    }

    public void run() {
        try {
            a(this.g);
            if (this.b.l) {
                ao.a("Hunter", "executing", ao.a(this));
            }
            this.m = a();
            if (this.m == null) {
                this.c.c(this);
            } else {
                this.c.a(this);
            }
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e) {
            if (!(e.a && e.b == 504)) {
                this.p = e;
            }
            this.c.c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e2) {
            this.p = e2;
            this.c.b(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e22) {
            this.p = e22;
            this.c.b(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable e3) {
            Writer stringWriter = new StringWriter();
            this.e.e().a(new PrintWriter(stringWriter));
            this.p = new RuntimeException(stringWriter.toString(), e3);
            this.c.c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e222) {
            this.p = e222;
            this.c.c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable e32) {
            Thread.currentThread().setName("Picasso-Idle");
            throw e32;
        }
    }
}
