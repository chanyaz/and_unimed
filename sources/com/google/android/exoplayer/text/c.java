package com.google.android.exoplayer.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.util.m;

final class c {
    private final RectF a = new RectF();
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final TextPaint h;
    private final Paint i;
    private CharSequence j;
    private int k;
    private Alignment l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private StaticLayout v;
    private int w;
    private int x;
    private int y;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.b = (float) round;
        this.c = (float) round;
        this.d = (float) round;
        this.e = (float) round;
        this.h = new TextPaint();
        this.h.setAntiAlias(true);
        this.h.setSubpixelText(true);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setStyle(Style.FILL);
    }

    private void a(Canvas canvas) {
        StaticLayout staticLayout = this.v;
        if (staticLayout != null) {
            int lineCount;
            int i;
            int save = canvas.save();
            canvas.translate((float) this.w, (float) this.x);
            if (Color.alpha(this.o) > 0) {
                this.i.setColor(this.o);
                canvas.drawRect((float) (-this.y), 0.0f, (float) (staticLayout.getWidth() + this.y), (float) staticLayout.getHeight(), this.i);
            }
            if (Color.alpha(this.n) > 0) {
                this.i.setColor(this.n);
                float lineTop = (float) staticLayout.getLineTop(0);
                lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.a.left = staticLayout.getLineLeft(i) - ((float) this.y);
                    this.a.right = staticLayout.getLineRight(i) + ((float) this.y);
                    this.a.top = f;
                    this.a.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.a.bottom;
                    canvas.drawRoundRect(this.a, this.b, this.b, this.i);
                }
            }
            if (this.q == 1) {
                this.h.setStrokeJoin(Join.ROUND);
                this.h.setStrokeWidth(this.c);
                this.h.setColor(this.p);
                this.h.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.q == 2) {
                this.h.setShadowLayer(this.d, this.e, this.e, this.p);
            } else if (this.q == 3 || this.q == 4) {
                lineCount = this.q == 3 ? 1 : 0;
                int i2 = lineCount != 0 ? -1 : this.p;
                i = lineCount != 0 ? this.p : -1;
                float f2 = this.d / 2.0f;
                this.h.setColor(this.m);
                this.h.setStyle(Style.FILL);
                this.h.setShadowLayer(this.d, -f2, -f2, i2);
                staticLayout.draw(canvas);
                this.h.setShadowLayer(this.d, f2, f2, i);
            }
            this.h.setColor(this.m);
            this.h.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    public void a(b bVar, a aVar, float f, Canvas canvas, int i, int i2, int i3, int i4) {
        if (!TextUtils.isEmpty(bVar.a)) {
            if (TextUtils.equals(this.j, bVar.a) && this.k == bVar.c && m.a(this.l, bVar.d) && this.m == aVar.b && this.n == aVar.c && this.o == aVar.d && this.q == aVar.e && this.p == aVar.f && m.a(this.h.getTypeface(), aVar.g) && this.r == i && this.s == i2 && this.t == i3 && this.u == i4) {
                a(canvas);
                return;
            }
            this.j = bVar.a;
            this.k = bVar.c;
            this.l = bVar.d;
            this.m = aVar.b;
            this.n = aVar.c;
            this.o = aVar.d;
            this.q = aVar.e;
            this.p = aVar.f;
            this.h.setTypeface(aVar.g);
            this.r = i;
            this.s = i2;
            this.t = i3;
            this.u = i4;
            int i5 = this.t - this.r;
            int i6 = this.u - this.s;
            float f2 = (0.0533f * ((float) i6)) * f;
            this.h.setTextSize(f2);
            int i7 = (int) ((f2 * 0.125f) + 0.5f);
            int i8 = i5 - (i7 * 2);
            if (i8 <= 0) {
                Log.w("CuePainter", "Skipped drawing subtitle cue (insufficient space)");
                return;
            }
            int i9;
            Alignment alignment = this.l == null ? Alignment.ALIGN_CENTER : this.l;
            this.v = new StaticLayout(this.j, this.h, i8, alignment, this.f, this.g, true);
            i8 = this.v.getHeight();
            int i10 = 0;
            int lineCount = this.v.getLineCount();
            for (i9 = 0; i9 < lineCount; i9++) {
                i10 = Math.max((int) Math.ceil((double) this.v.getLineWidth(i9)), i10);
            }
            int i11 = i10 + (i7 * 2);
            i10 = (i5 - i11) / 2;
            i9 = i10 + i11;
            lineCount = (this.u - i8) - ((int) (((float) i6) * 0.08f));
            int i12 = lineCount + i8;
            if (bVar.c == -1) {
                i5 = i10;
            } else if (bVar.d == Alignment.ALIGN_OPPOSITE) {
                i9 = ((bVar.c * i5) / 100) + this.r;
                i5 = Math.max(i9 - i11, this.r);
            } else {
                i10 = this.r + ((bVar.c * i5) / 100);
                i9 = Math.min(i10 + i11, this.t);
                i5 = i10;
            }
            if (bVar.b != -1) {
                i10 = ((bVar.b * i6) / 100) + this.s;
                if (i10 + i8 > this.u) {
                    i10 = this.u - i8;
                    lineCount = this.u;
                    i6 = i10;
                } else {
                    i6 = i10;
                }
            } else {
                i6 = lineCount;
            }
            this.v = new StaticLayout(this.j, this.h, i9 - i5, alignment, this.f, this.g, true);
            this.w = i5;
            this.x = i6;
            this.y = i7;
            a(canvas);
        }
    }
}
