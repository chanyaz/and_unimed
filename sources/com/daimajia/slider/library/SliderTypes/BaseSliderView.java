package com.daimajia.slider.library.SliderTypes;

import android.content.Context;
import android.view.View;
import java.io.File;

public abstract class BaseSliderView {
    protected Context a;
    private String b;
    private File c;
    private int d;
    private boolean e;
    private ImageLoadListener f;
    private String g;
    private int h = 0;
    private int i = 0;
    private ScaleType j = ScaleType.Fit;

    public interface ImageLoadListener {
        void onEnd(boolean z, BaseSliderView baseSliderView);

        void onStart(BaseSliderView baseSliderView);
    }

    public interface OnSliderClickListener {
        void onSliderClick(BaseSliderView baseSliderView);
    }

    public enum ScaleType {
        CenterCrop,
        CenterInside,
        Fit,
        FitCenterCrop
    }

    protected BaseSliderView(Context context) {
        this.a = context;
    }

    public BaseSliderView a(int i, int i2) {
        this.h = i;
        this.i = i2;
        return this;
    }

    public BaseSliderView a(ScaleType scaleType) {
        this.j = scaleType;
        return this;
    }

    public BaseSliderView a(String str) {
        this.g = str;
        return this;
    }

    public String a() {
        return this.b;
    }

    public void a(ImageLoadListener imageLoadListener) {
        this.f = imageLoadListener;
    }

    public BaseSliderView b(String str) {
        if (this.c == null && this.d == 0) {
            this.b = str;
            return this;
        }
        throw new IllegalStateException("Call multi image function,you only have permission to call it once");
    }

    public boolean b() {
        return this.e;
    }

    public String c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public Context f() {
        return this.a;
    }

    public abstract View g();
}
