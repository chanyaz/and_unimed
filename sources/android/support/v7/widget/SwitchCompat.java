package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.b;
import android.support.v7.a.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] N = new int[]{16842912};
    private static final Property<SwitchCompat, Float> b = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.z);
        }

        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    private final Rect M;
    ObjectAnimator a;
    private Drawable c;
    private ColorStateList d;
    private Mode e;
    private boolean f;
    private boolean g;
    private Drawable h;
    private ColorStateList i;
    private Mode j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private CharSequence q;
    private CharSequence r;
    private boolean s;
    private int t;
    private int u;
    private float v;
    private float w;
    private VelocityTracker x;
    private int y;
    private float z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.x = VelocityTracker.obtain();
        this.M = new Rect();
        this.H = new TextPaint(1);
        Resources resources = getResources();
        this.H.density = resources.getDisplayMetrics().density;
        db a = db.a(context, attributeSet, k.SwitchCompat, i, 0);
        this.c = a.a(k.SwitchCompat_android_thumb);
        if (this.c != null) {
            this.c.setCallback(this);
        }
        this.h = a.a(k.SwitchCompat_track);
        if (this.h != null) {
            this.h.setCallback(this);
        }
        this.q = a.c(k.SwitchCompat_android_textOn);
        this.r = a.c(k.SwitchCompat_android_textOff);
        this.s = a.a(k.SwitchCompat_showText, true);
        this.m = a.e(k.SwitchCompat_thumbTextPadding, 0);
        this.n = a.e(k.SwitchCompat_switchMinWidth, 0);
        this.o = a.e(k.SwitchCompat_switchPadding, 0);
        this.p = a.a(k.SwitchCompat_splitTrack, false);
        ColorStateList e = a.e(k.SwitchCompat_thumbTint);
        if (e != null) {
            this.d = e;
            this.f = true;
        }
        Mode a2 = an.a(a.a(k.SwitchCompat_thumbTintMode, -1), null);
        if (this.e != a2) {
            this.e = a2;
            this.g = true;
        }
        if (this.f || this.g) {
            b();
        }
        e = a.e(k.SwitchCompat_trackTint);
        if (e != null) {
            this.i = e;
            this.k = true;
        }
        a2 = an.a(a.a(k.SwitchCompat_trackTintMode, -1), null);
        if (this.j != a2) {
            this.j = a2;
            this.l = true;
        }
        if (this.k || this.l) {
            a();
        }
        int g = a.g(k.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            a(context, g);
        }
        a.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.u = viewConfiguration.getScaledTouchSlop();
        this.y = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private Layout a(CharSequence charSequence) {
        CharSequence transformation = this.L != null ? this.L.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.H, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.H)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void a() {
        if (this.h == null) {
            return;
        }
        if (this.k || this.l) {
            this.h = this.h.mutate();
            if (this.k) {
                a.a(this.h, this.i);
            }
            if (this.l) {
                a.a(this.h, this.j);
            }
            if (this.h.isStateful()) {
                this.h.setState(getDrawableState());
            }
        }
    }

    private void a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        a(typeface, i2);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void a(boolean z) {
        float f = z ? 1.0f : 0.0f;
        this.a = ObjectAnimator.ofFloat(this, b, new float[]{f});
        this.a.setDuration(250);
        if (VERSION.SDK_INT >= 18) {
            this.a.setAutoCancel(true);
        }
        this.a.start();
    }

    private boolean a(float f, float f2) {
        if (this.c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.c.getPadding(this.M);
        thumbOffset = (thumbOffset + this.D) - this.u;
        return f > ((float) thumbOffset) && f < ((float) ((((this.C + thumbOffset) + this.M.left) + this.M.right) + this.u)) && f2 > ((float) (this.E - this.u)) && f2 < ((float) (this.G + this.u));
    }

    private void b() {
        if (this.c == null) {
            return;
        }
        if (this.f || this.g) {
            this.c = this.c.mutate();
            if (this.f) {
                a.a(this.c, this.d);
            }
            if (this.g) {
                a.a(this.c, this.e);
            }
            if (this.c.isStateful()) {
                this.c.setState(getDrawableState());
            }
        }
    }

    private void b(MotionEvent motionEvent) {
        boolean z = true;
        this.t = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.x.computeCurrentVelocity(1000);
            float xVelocity = this.x.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.y)) {
                z = getTargetCheckedState();
            } else if (dk.a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        a(motionEvent);
    }

    private void c() {
        if (this.a != null) {
            this.a.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((dk.a(this) ? 1.0f - this.z : this.z) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.h == null) {
            return 0;
        }
        Rect rect = this.M;
        this.h.getPadding(rect);
        Rect a = this.c != null ? an.a(this.c) : an.a;
        return ((((this.A - this.C) - rect.left) - rect.right) - a.left) - a.right;
    }

    public void a(Context context, int i) {
        db a = db.a(context, i, k.TextAppearance);
        ColorStateList e = a.e(k.TextAppearance_android_textColor);
        if (e != null) {
            this.I = e;
        } else {
            this.I = getTextColors();
        }
        int e2 = a.e(k.TextAppearance_android_textSize, 0);
        if (!(e2 == 0 || ((float) e2) == this.H.getTextSize())) {
            this.H.setTextSize((float) e2);
            requestLayout();
        }
        a(a.a(k.TextAppearance_android_typeface, -1), a.a(k.TextAppearance_android_textStyle, -1));
        if (a.a(k.TextAppearance_textAllCaps, false)) {
            this.L = new android.support.v7.e.a(getContext());
        } else {
            this.L = null;
        }
        a.a();
    }

    public void a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.H;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            this.H.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void draw(Canvas canvas) {
        int i;
        Rect rect = this.M;
        int i2 = this.D;
        int i3 = this.E;
        int i4 = this.F;
        int i5 = this.G;
        int thumbOffset = i2 + getThumbOffset();
        Rect a = this.c != null ? an.a(this.c) : an.a;
        if (this.h != null) {
            this.h.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                thumbOffset = a.top > rect.top ? (a.top - rect.top) + i3 : i3;
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.h.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.c != null) {
            this.c.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.C) + rect.right;
            this.c.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.c != null) {
            a.a(this.c, f, f2);
        }
        if (this.h != null) {
            a.a(this.h, f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.c;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.h;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!dk.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.o : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (dk.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.o : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.s;
    }

    public boolean getSplitTrack() {
        return this.p;
    }

    public int getSwitchMinWidth() {
        return this.n;
    }

    public int getSwitchPadding() {
        return this.o;
    }

    public CharSequence getTextOff() {
        return this.r;
    }

    public CharSequence getTextOn() {
        return this.q;
    }

    public Drawable getThumbDrawable() {
        return this.c;
    }

    public int getThumbTextPadding() {
        return this.m;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.d;
    }

    @Nullable
    public Mode getThumbTintMode() {
        return this.e;
    }

    public Drawable getTrackDrawable() {
        return this.h;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.i;
    }

    @Nullable
    public Mode getTrackTintMode() {
        return this.j;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
        if (this.h != null) {
            this.h.jumpToCurrentState();
        }
        if (this.a != null && this.a.isStarted()) {
            this.a.end();
            this.a = null;
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, N);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.M;
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.E + rect.top;
        int i2 = this.G - rect.bottom;
        Drawable drawable2 = this.c;
        if (drawable != null) {
            if (!this.p || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = an.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.I != null) {
                this.H.setColor(this.I.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.q : this.r;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            CharSequence stringBuilder = new StringBuilder();
            stringBuilder.append(text).append(' ').append(charSequence);
            accessibilityNodeInfo.setText(stringBuilder);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null) {
            Rect rect = this.M;
            if (this.h != null) {
                this.h.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = an.a(this.c);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (dk.a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.A + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.A);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.B / 2);
                paddingLeft = this.B + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.B;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.B + paddingTop;
                break;
        }
        this.D = i5;
        this.E = paddingTop;
        this.G = paddingLeft;
        this.F = max;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int i3 = 0;
        if (this.s) {
            if (this.J == null) {
                this.J = a(this.q);
            }
            if (this.K == null) {
                this.K = a(this.r);
            }
        }
        Rect rect = this.M;
        if (this.c != null) {
            this.c.getPadding(rect);
            intrinsicWidth = (this.c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.c.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.C = Math.max(this.s ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.m * 2) : 0, intrinsicWidth);
        if (this.h != null) {
            this.h.getPadding(rect);
            i3 = this.h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i4 = rect.left;
        intrinsicWidth = rect.right;
        if (this.c != null) {
            rect = an.a(this.c);
            i4 = Math.max(i4, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.n, intrinsicWidth + (i4 + (this.C * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.A = intrinsicWidth;
        this.B = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), intrinsicHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.q : this.r;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x.addMovement(motionEvent);
        float x;
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && a(x, y)) {
                    this.t = 1;
                    this.v = x;
                    this.w = y;
                    break;
                }
            case 1:
            case 3:
                if (this.t != 2) {
                    this.t = 0;
                    this.x.clear();
                    break;
                }
                b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.t) {
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.v) > ((float) this.u) || Math.abs(y - this.w) > ((float) this.u)) {
                            this.t = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.v = x;
                            this.w = y;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.v;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (dk.a(this)) {
                            x = -x;
                        }
                        x = a(x + this.z, 0.0f, 1.0f);
                        if (x != this.z) {
                            this.v = x2;
                            setThumbPosition(x);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !ViewCompat.y(this)) {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setShowText(boolean z) {
        if (this.s != z) {
            this.s = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.n = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.o = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(typeface)) || (this.H.getTypeface() == null && typeface != null)) {
            this.H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.r = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f) {
        this.z = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.m = i;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.d = colorStateList;
        this.f = true;
        b();
    }

    public void setThumbTintMode(@Nullable Mode mode) {
        this.e = mode;
        this.g = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.h != null) {
            this.h.setCallback(null);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.i = colorStateList;
        this.k = true;
        a();
    }

    public void setTrackTintMode(@Nullable Mode mode) {
        this.j = mode;
        this.l = true;
        a();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.c || drawable == this.h;
    }
}
