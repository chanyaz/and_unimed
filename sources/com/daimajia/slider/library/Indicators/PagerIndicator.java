package com.daimajia.slider.library.Indicators;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.daimajia.slider.library.Tricks.ViewPagerEx.OnPageChangeListener;
import com.daimajia.slider.library.Tricks.b;
import com.daimajia.slider.library.e;
import java.util.ArrayList;
import java.util.Iterator;

public class PagerIndicator extends LinearLayout implements OnPageChangeListener {
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private ArrayList<ImageView> H;
    private DataSetObserver I;
    private Context a;
    private ViewPagerEx b;
    private ImageView c;
    private int d;
    private int e;
    private int f;
    private Drawable g;
    private Drawable h;
    private int i;
    private Shape j;
    private IndicatorVisibility k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private GradientDrawable r;
    private GradientDrawable s;
    private LayerDrawable t;
    private LayerDrawable u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public enum IndicatorVisibility {
        Visible,
        Invisible
    }

    public enum Shape {
        Oval,
        Rectangle
    }

    public enum Unit {
        DP,
        Px
    }

    public PagerIndicator(Context context) {
        this(context, null);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.j = Shape.Oval;
        this.k = IndicatorVisibility.Visible;
        this.H = new ArrayList();
        this.I = new DataSetObserver() {
            public void onChanged() {
                n adapter = PagerIndicator.this.b.getAdapter();
                int e = adapter instanceof b ? ((b) adapter).e() : adapter.b();
                if (e > PagerIndicator.this.i) {
                    for (int i = 0; i < e - PagerIndicator.this.i; i++) {
                        View imageView = new ImageView(PagerIndicator.this.a);
                        imageView.setImageDrawable(PagerIndicator.this.h);
                        imageView.setPadding((int) PagerIndicator.this.D, (int) PagerIndicator.this.F, (int) PagerIndicator.this.E, (int) PagerIndicator.this.G);
                        PagerIndicator.this.addView(imageView);
                        PagerIndicator.this.H.add(imageView);
                    }
                } else if (e < PagerIndicator.this.i) {
                    for (int i2 = 0; i2 < PagerIndicator.this.i - e; i2++) {
                        PagerIndicator.this.removeView((View) PagerIndicator.this.H.get(0));
                        PagerIndicator.this.H.remove(0);
                    }
                }
                PagerIndicator.this.i = e;
                PagerIndicator.this.b.setCurrentItem((PagerIndicator.this.i * 20) + PagerIndicator.this.b.getCurrentItem());
            }

            public void onInvalidated() {
                super.onInvalidated();
                PagerIndicator.this.b();
            }
        };
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.PagerIndicator, 0, 0);
        int i = obtainStyledAttributes.getInt(e.PagerIndicator_visibility, IndicatorVisibility.Visible.ordinal());
        for (IndicatorVisibility indicatorVisibility : IndicatorVisibility.values()) {
            if (indicatorVisibility.ordinal() == i) {
                this.k = indicatorVisibility;
                break;
            }
        }
        i = obtainStyledAttributes.getInt(e.PagerIndicator_shape, Shape.Oval.ordinal());
        for (Shape shape : Shape.values()) {
            if (shape.ordinal() == i) {
                this.j = shape;
                break;
            }
        }
        this.f = obtainStyledAttributes.getResourceId(e.PagerIndicator_selected_drawable, 0);
        this.e = obtainStyledAttributes.getResourceId(e.PagerIndicator_unselected_drawable, 0);
        this.l = obtainStyledAttributes.getColor(e.PagerIndicator_selected_color, Color.rgb(255, 255, 255));
        this.m = obtainStyledAttributes.getColor(e.PagerIndicator_unselected_color, Color.argb(33, 255, 255, 255));
        this.n = obtainStyledAttributes.getDimension(e.PagerIndicator_selected_width, (float) ((int) a(6.0f)));
        this.o = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_selected_height, (int) a(6.0f));
        this.p = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_width, (int) a(6.0f));
        this.q = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_height, (int) a(6.0f));
        this.s = new GradientDrawable();
        this.r = new GradientDrawable();
        this.v = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_padding_left, (int) a(3.0f));
        this.w = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_padding_right, (int) a(3.0f));
        this.x = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_padding_top, (int) a(0.0f));
        this.y = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_padding_bottom, (int) a(0.0f));
        this.z = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_selected_padding_left, (int) this.v);
        this.A = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_selected_padding_right, (int) this.w);
        this.B = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_selected_padding_top, (int) this.x);
        this.C = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_selected_padding_bottom, (int) this.y);
        this.D = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_padding_left, (int) this.v);
        this.E = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_padding_right, (int) this.w);
        this.F = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_padding_top, (int) this.x);
        this.G = (float) obtainStyledAttributes.getDimensionPixelSize(e.PagerIndicator_unselected_padding_bottom, (int) this.y);
        this.t = new LayerDrawable(new Drawable[]{this.s});
        this.u = new LayerDrawable(new Drawable[]{this.r});
        a(this.f, this.e);
        setDefaultIndicatorShape(this.j);
        a(this.n, this.o, Unit.Px);
        b(this.p, this.q, Unit.Px);
        b(this.l, this.m);
        setIndicatorVisibility(this.k);
        obtainStyledAttributes.recycle();
    }

    private float a(float f) {
        return getContext().getResources().getDisplayMetrics().density * f;
    }

    private void c() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (this.c == null || !this.c.equals(view)) {
                ((ImageView) view).setImageDrawable(this.h);
            } else {
                ((ImageView) view).setImageDrawable(this.g);
            }
        }
    }

    private int getShouldDrawCount() {
        return this.b.getAdapter() instanceof b ? ((b) this.b.getAdapter()).e() : this.b.getAdapter().b();
    }

    private void setItemAsSelected(int i) {
        if (this.c != null) {
            this.c.setImageDrawable(this.h);
            this.c.setPadding((int) this.D, (int) this.F, (int) this.E, (int) this.G);
        }
        ImageView imageView = (ImageView) getChildAt(i + 1);
        if (imageView != null) {
            imageView.setImageDrawable(this.g);
            imageView.setPadding((int) this.z, (int) this.B, (int) this.A, (int) this.C);
            this.c = imageView;
        }
        this.d = i;
    }

    public void a() {
        if (this.b != null && this.b.getAdapter() != null) {
            n d = this.b.getAdapter() instanceof b ? ((b) this.b.getAdapter()).d() : this.b.getAdapter();
            if (d != null) {
                d.b(this.I);
            }
            removeAllViews();
        }
    }

    public void a(float f, float f2, Unit unit) {
        if (this.f == 0) {
            if (unit == Unit.DP) {
                f = a(f);
                f2 = a(f2);
            }
            this.s.setSize((int) f, (int) f2);
            c();
        }
    }

    public void a(int i, int i2) {
        this.f = i;
        this.e = i2;
        if (i == 0) {
            this.g = this.t;
        } else {
            this.g = this.a.getResources().getDrawable(this.f);
        }
        if (i2 == 0) {
            this.h = this.u;
        } else {
            this.h = this.a.getResources().getDrawable(this.e);
        }
        c();
    }

    public void b() {
        this.i = getShouldDrawCount();
        this.c = null;
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
        for (int i = 0; i < this.i; i++) {
            View imageView = new ImageView(this.a);
            imageView.setImageDrawable(this.h);
            imageView.setPadding((int) this.D, (int) this.F, (int) this.E, (int) this.G);
            addView(imageView);
            this.H.add(imageView);
        }
        setItemAsSelected(this.d);
    }

    public void b(float f, float f2, Unit unit) {
        if (this.e == 0) {
            if (unit == Unit.DP) {
                f = a(f);
                f2 = a(f2);
            }
            this.r.setSize((int) f, (int) f2);
            c();
        }
    }

    public void b(int i, int i2) {
        if (this.f == 0) {
            this.s.setColor(i);
        }
        if (this.e == 0) {
            this.r.setColor(i2);
        }
        c();
    }

    public IndicatorVisibility getIndicatorVisibility() {
        return this.k;
    }

    public int getSelectedIndicatorResId() {
        return this.f;
    }

    public int getUnSelectedIndicatorResId() {
        return this.e;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        if (this.i != 0) {
            setItemAsSelected(i - 1);
        }
    }

    public void setDefaultIndicatorShape(Shape shape) {
        if (this.f == 0) {
            if (shape == Shape.Oval) {
                this.s.setShape(1);
            } else {
                this.s.setShape(0);
            }
        }
        if (this.e == 0) {
            if (shape == Shape.Oval) {
                this.r.setShape(1);
            } else {
                this.r.setShape(0);
            }
        }
        c();
    }

    public void setIndicatorVisibility(IndicatorVisibility indicatorVisibility) {
        if (indicatorVisibility == IndicatorVisibility.Visible) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
        c();
    }

    public void setViewPager(ViewPagerEx viewPagerEx) {
        if (viewPagerEx.getAdapter() == null) {
            throw new IllegalStateException("Viewpager does not have adapter instance");
        }
        this.b = viewPagerEx;
        this.b.a((OnPageChangeListener) this);
        if (this.b.getAdapter() instanceof b) {
            ((b) this.b.getAdapter()).d().a(this.I);
        } else {
            this.b.getAdapter().a(this.I);
        }
    }
}
