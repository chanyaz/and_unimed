package com.daimajia.slider.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.daimajia.slider.library.Animations.BaseAnimationInterface;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.Indicators.PagerIndicator.IndicatorVisibility;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.InfiniteViewPager;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.daimajia.slider.library.Tricks.ViewPagerEx.OnPageChangeListener;
import com.daimajia.slider.library.Tricks.a;
import com.daimajia.slider.library.Tricks.b;
import com.daimajia.slider.library.a.c;
import com.daimajia.slider.library.a.d;
import com.daimajia.slider.library.a.e;
import com.daimajia.slider.library.a.f;
import com.daimajia.slider.library.a.g;
import com.daimajia.slider.library.a.h;
import com.daimajia.slider.library.a.i;
import com.daimajia.slider.library.a.j;
import com.daimajia.slider.library.a.k;
import com.daimajia.slider.library.a.l;
import com.daimajia.slider.library.a.m;
import com.daimajia.slider.library.a.o;
import com.daimajia.slider.library.a.p;
import com.daimajia.slider.library.a.q;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public class SliderLayout extends RelativeLayout {
    private Context a;
    private InfiniteViewPager b;
    private f c;
    private PagerIndicator d;
    private Timer e;
    private TimerTask f;
    private Timer g;
    private TimerTask h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private boolean m;
    private long n;
    private IndicatorVisibility o;
    private c p;
    private BaseAnimationInterface q;
    private Handler r;

    public enum PresetIndicators {
        Center_Bottom("Center_Bottom", c.default_center_bottom_indicator),
        Right_Bottom("Right_Bottom", c.default_bottom_right_indicator),
        Left_Bottom("Left_Bottom", c.default_bottom_left_indicator),
        Center_Top("Center_Top", c.default_center_top_indicator),
        Right_Top("Right_Top", c.default_center_top_right_indicator),
        Left_Top("Left_Top", c.default_center_top_left_indicator);
        
        private final String g;
        private final int h;

        private PresetIndicators(String str, int i) {
            this.g = str;
            this.h = i;
        }

        public int a() {
            return this.h;
        }

        public String toString() {
            return this.g;
        }
    }

    public enum Transformer {
        Default("Default"),
        Accordion("Accordion"),
        Background2Foreground("Background2Foreground"),
        CubeIn("CubeIn"),
        DepthPage("DepthPage"),
        Fade("Fade"),
        FlipHorizontal("FlipHorizontal"),
        FlipPage("FlipPage"),
        Foreground2Background("Foreground2Background"),
        RotateDown("RotateDown"),
        RotateUp("RotateUp"),
        Stack("Stack"),
        Tablet("Tablet"),
        ZoomIn("ZoomIn"),
        ZoomOutSlide("ZoomOutSlide"),
        ZoomOut("ZoomOut");
        
        private final String q;

        private Transformer(String str) {
            this.q = str;
        }

        public boolean a(String str) {
            return str == null ? false : this.q.equals(str);
        }

        public String toString() {
            return this.q;
        }
    }

    public SliderLayout(Context context) {
        this(context, null);
    }

    public SliderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.SliderStyle);
    }

    public SliderLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.j = true;
        this.l = 1100;
        this.n = 4000;
        this.o = IndicatorVisibility.Visible;
        this.r = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                SliderLayout.this.a(true);
            }
        };
        this.a = context;
        LayoutInflater.from(context).inflate(d.slider_layout, this, true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.SliderLayout, i, 0);
        this.l = obtainStyledAttributes.getInteger(e.SliderLayout_pager_animation_span, 1100);
        this.k = obtainStyledAttributes.getInt(e.SliderLayout_pager_animation, Transformer.Default.ordinal());
        this.m = obtainStyledAttributes.getBoolean(e.SliderLayout_auto_cycle, true);
        int i3 = obtainStyledAttributes.getInt(e.SliderLayout_indicator_visibility, 0);
        IndicatorVisibility[] values = IndicatorVisibility.values();
        int length = values.length;
        while (i2 < length) {
            IndicatorVisibility indicatorVisibility = values[i2];
            if (indicatorVisibility.ordinal() == i3) {
                this.o = indicatorVisibility;
                break;
            }
            i2++;
        }
        this.c = new f(this.a);
        b bVar = new b(this.c);
        this.b = (InfiniteViewPager) findViewById(c.daimajia_slider_viewpager);
        this.b.setAdapter(this.c);
        this.b.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 1:
                        SliderLayout.this.d();
                        break;
                }
                return false;
            }
        });
        obtainStyledAttributes.recycle();
        setPresetIndicator(PresetIndicators.Center_Bottom);
        setPresetTransformer(this.k);
        a(this.l, null);
        setIndicatorVisibility(this.o);
        if (this.m) {
            a();
        }
    }

    private void c() {
        if (this.i) {
            this.e.cancel();
            this.f.cancel();
            this.i = false;
        } else if (this.g != null && this.h != null) {
            d();
        }
    }

    private void d() {
        if (this.j && this.m && !this.i) {
            if (!(this.h == null || this.g == null)) {
                this.g.cancel();
                this.h.cancel();
            }
            this.g = new Timer();
            this.h = new TimerTask() {
                public void run() {
                    SliderLayout.this.a();
                }
            };
            this.g.schedule(this.h, 6000);
        }
    }

    private f getRealAdapter() {
        n adapter = this.b.getAdapter();
        if (adapter != null) {
            if (adapter instanceof b) {
                return ((b) adapter).d();
            }
            if (adapter instanceof f) {
                return (f) adapter;
            }
        }
        return null;
    }

    private b getWrapperAdapter() {
        n adapter = this.b.getAdapter();
        return adapter != null ? (b) adapter : null;
    }

    public void a() {
        a(this.n, this.n, this.j);
    }

    public void a(int i, Interpolator interpolator) {
        try {
            Field declaredField = ViewPagerEx.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            declaredField.set(this.b, new a(this.b.getContext(), interpolator, i));
        } catch (Exception e) {
        }
    }

    public void a(int i, boolean z) {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        } else if (i >= getRealAdapter().b()) {
            throw new IllegalStateException("Item position is not exist");
        } else {
            this.b.a((i - (this.b.getCurrentItem() % getRealAdapter().b())) + this.b.getCurrentItem(), z);
        }
    }

    public void a(long j, long j2, boolean z) {
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.f != null) {
            this.f.cancel();
        }
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        this.n = j2;
        this.e = new Timer();
        this.j = z;
        this.f = new TimerTask() {
            public void run() {
                SliderLayout.this.r.sendEmptyMessage(0);
            }
        };
        this.e.schedule(this.f, j, this.n);
        this.i = true;
        this.m = true;
    }

    public <T extends BaseSliderView> void a(T t) {
        this.c.a((BaseSliderView) t);
    }

    public void a(OnPageChangeListener onPageChangeListener) {
        if (onPageChangeListener != null) {
            this.b.a(onPageChangeListener);
        }
    }

    public void a(boolean z) {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        }
        this.b.a(this.b.getCurrentItem() + 1, z);
    }

    public void a(boolean z, c cVar) {
        this.p = cVar;
        this.p.a(this.q);
        this.b.a(z, this.p);
    }

    public void b() {
        if (this.f != null) {
            this.f.cancel();
        }
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.h != null) {
            this.h.cancel();
        }
        this.m = false;
        this.i = false;
    }

    public int getCurrentPosition() {
        if (getRealAdapter() != null) {
            return this.b.getCurrentItem() % getRealAdapter().b();
        }
        throw new IllegalStateException("You did not set a slider adapter");
    }

    public BaseSliderView getCurrentSlider() {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        }
        return getRealAdapter().a(this.b.getCurrentItem() % getRealAdapter().b());
    }

    public IndicatorVisibility getIndicatorVisibility() {
        return this.d == null ? this.d.getIndicatorVisibility() : IndicatorVisibility.Invisible;
    }

    public PagerIndicator getPagerIndicator() {
        return this.d;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                c();
                break;
        }
        return false;
    }

    public void setCurrentPosition(int i) {
        a(i, true);
    }

    public void setCustomAnimation(BaseAnimationInterface baseAnimationInterface) {
        this.q = baseAnimationInterface;
        if (this.p != null) {
            this.p.a(this.q);
        }
    }

    public void setCustomIndicator(PagerIndicator pagerIndicator) {
        if (this.d != null) {
            this.d.a();
        }
        this.d = pagerIndicator;
        this.d.setIndicatorVisibility(this.o);
        this.d.setViewPager(this.b);
        this.d.b();
    }

    public void setDuration(long j) {
        if (j >= 500) {
            this.n = j;
            if (this.m && this.i) {
                a();
            }
        }
    }

    public void setIndicatorVisibility(IndicatorVisibility indicatorVisibility) {
        if (this.d != null) {
            this.d.setIndicatorVisibility(indicatorVisibility);
        }
    }

    public void setPresetIndicator(PresetIndicators presetIndicators) {
        setCustomIndicator((PagerIndicator) findViewById(presetIndicators.a()));
    }

    public void setPresetTransformer(int i) {
        for (Transformer transformer : Transformer.values()) {
            if (transformer.ordinal() == i) {
                setPresetTransformer(transformer);
                return;
            }
        }
    }

    public void setPresetTransformer(Transformer transformer) {
        c cVar = null;
        switch (transformer) {
            case Default:
                cVar = new e();
                break;
            case Accordion:
                cVar = new com.daimajia.slider.library.a.a();
                break;
            case Background2Foreground:
                cVar = new com.daimajia.slider.library.a.b();
                break;
            case CubeIn:
                cVar = new d();
                break;
            case DepthPage:
                cVar = new f();
                break;
            case Fade:
                cVar = new g();
                break;
            case FlipHorizontal:
                cVar = new h();
                break;
            case FlipPage:
                cVar = new i();
                break;
            case Foreground2Background:
                cVar = new j();
                break;
            case RotateDown:
                cVar = new k();
                break;
            case RotateUp:
                cVar = new l();
                break;
            case Stack:
                cVar = new m();
                break;
            case Tablet:
                cVar = new com.daimajia.slider.library.a.n();
                break;
            case ZoomIn:
                cVar = new o();
                break;
            case ZoomOutSlide:
                cVar = new p();
                break;
            case ZoomOut:
                cVar = new q();
                break;
        }
        a(true, cVar);
    }

    public void setPresetTransformer(String str) {
        for (Transformer transformer : Transformer.values()) {
            if (transformer.a(str)) {
                setPresetTransformer(transformer);
                return;
            }
        }
    }
}
