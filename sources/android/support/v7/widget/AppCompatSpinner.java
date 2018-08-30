package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.a.b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] a = new int[]{16843505};
    private final t b;
    private final Context c;
    private at d;
    private SpinnerAdapter e;
    private final boolean f;
    private ac g;
    private int h;
    private final Rect i;

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db  */
    public AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) {
        /*
        r8 = this;
        r7 = 1;
        r1 = 0;
        r6 = 0;
        r8.<init>(r9, r10, r11);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r8.i = r0;
        r0 = android.support.v7.a.k.Spinner;
        r3 = android.support.v7.widget.db.a(r9, r10, r0, r11, r6);
        r0 = new android.support.v7.widget.t;
        r0.<init>(r8);
        r8.b = r0;
        if (r13 == 0) goto L_0x00a9;
    L_0x001c:
        r0 = new android.support.v7.view.b;
        r0.<init>(r9, r13);
        r8.c = r0;
    L_0x0023:
        r0 = r8.c;
        if (r0 == 0) goto L_0x007b;
    L_0x0027:
        r0 = -1;
        if (r12 != r0) goto L_0x0043;
    L_0x002a:
        r0 = a;	 Catch:{ Exception -> 0x00c7, all -> 0x00d7 }
        r2 = 0;
        r2 = r9.obtainStyledAttributes(r10, r0, r11, r2);	 Catch:{ Exception -> 0x00c7, all -> 0x00d7 }
        r0 = 0;
        r0 = r2.hasValue(r0);	 Catch:{ Exception -> 0x00e1 }
        if (r0 == 0) goto L_0x003e;
    L_0x0038:
        r0 = 0;
        r4 = 0;
        r12 = r2.getInt(r0, r4);	 Catch:{ Exception -> 0x00e1 }
    L_0x003e:
        if (r2 == 0) goto L_0x0043;
    L_0x0040:
        r2.recycle();
    L_0x0043:
        if (r12 != r7) goto L_0x007b;
    L_0x0045:
        r0 = new android.support.v7.widget.ac;
        r2 = r8.c;
        r0.<init>(r8, r2, r10, r11);
        r2 = r8.c;
        r4 = android.support.v7.a.k.Spinner;
        r2 = android.support.v7.widget.db.a(r2, r10, r4, r11, r6);
        r4 = android.support.v7.a.k.Spinner_android_dropDownWidth;
        r5 = -2;
        r4 = r2.f(r4, r5);
        r8.h = r4;
        r4 = android.support.v7.a.k.Spinner_android_popupBackground;
        r4 = r2.a(r4);
        r0.a(r4);
        r4 = android.support.v7.a.k.Spinner_android_prompt;
        r4 = r3.d(r4);
        r0.a(r4);
        r2.a();
        r8.g = r0;
        r2 = new android.support.v7.widget.AppCompatSpinner$1;
        r2.<init>(r8, r0);
        r8.d = r2;
    L_0x007b:
        r0 = android.support.v7.a.k.Spinner_android_entries;
        r0 = r3.f(r0);
        if (r0 == 0) goto L_0x0093;
    L_0x0083:
        r2 = new android.widget.ArrayAdapter;
        r4 = 17367048; // 0x1090008 float:2.5162948E-38 double:8.580462E-317;
        r2.<init>(r9, r4, r0);
        r0 = android.support.v7.a.h.support_simple_spinner_dropdown_item;
        r2.setDropDownViewResource(r0);
        r8.setAdapter(r2);
    L_0x0093:
        r3.a();
        r8.f = r7;
        r0 = r8.e;
        if (r0 == 0) goto L_0x00a3;
    L_0x009c:
        r0 = r8.e;
        r8.setAdapter(r0);
        r8.e = r1;
    L_0x00a3:
        r0 = r8.b;
        r0.a(r10, r11);
        return;
    L_0x00a9:
        r0 = android.support.v7.a.k.Spinner_popupTheme;
        r0 = r3.g(r0, r6);
        if (r0 == 0) goto L_0x00ba;
    L_0x00b1:
        r2 = new android.support.v7.view.b;
        r2.<init>(r9, r0);
        r8.c = r2;
        goto L_0x0023;
    L_0x00ba:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        if (r0 >= r2) goto L_0x00c5;
    L_0x00c0:
        r0 = r9;
    L_0x00c1:
        r8.c = r0;
        goto L_0x0023;
    L_0x00c5:
        r0 = r1;
        goto L_0x00c1;
    L_0x00c7:
        r0 = move-exception;
        r2 = r1;
    L_0x00c9:
        r4 = "AppCompatSpinner";
        r5 = "Could not read android:spinnerMode";
        android.util.Log.i(r4, r5, r0);	 Catch:{ all -> 0x00df }
        if (r2 == 0) goto L_0x0043;
    L_0x00d2:
        r2.recycle();
        goto L_0x0043;
    L_0x00d7:
        r0 = move-exception;
        r2 = r1;
    L_0x00d9:
        if (r2 == 0) goto L_0x00de;
    L_0x00db:
        r2.recycle();
    L_0x00de:
        throw r0;
    L_0x00df:
        r0 = move-exception;
        goto L_0x00d9;
    L_0x00e1:
        r0 = move-exception;
        goto L_0x00c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.i);
        return (this.i.left + this.i.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.g != null ? this.g.f() : VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.g != null ? this.g.g() : VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.g != null ? this.h : VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.g != null ? this.g.d() : VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.g != null ? this.c : VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.g != null ? this.g.a() : super.getPrompt();
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null && this.g.isShowing()) {
            this.g.dismiss();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.d == null || !this.d.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.g == null) {
            return super.performClick();
        }
        if (!this.g.isShowing()) {
            this.g.show();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f) {
            super.setAdapter(spinnerAdapter);
            if (this.g != null) {
                this.g.a(new ab(spinnerAdapter, (this.c == null ? getContext() : this.c).getTheme()));
                return;
            }
            return;
        }
        this.e = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.g != null) {
            this.g.c(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.g != null) {
            this.g.d(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.g != null) {
            this.g.a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(android.support.v7.c.a.b.b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.g != null) {
            this.g.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }
}
