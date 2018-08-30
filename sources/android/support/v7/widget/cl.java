package android.support.v7.widget;

import android.content.res.Configuration;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.a.b;
import android.support.v7.app.a;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

@RestrictTo({Scope.LIBRARY_GROUP})
public class cl extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    LinearLayoutCompat b;
    int c;
    int d;
    private cn e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    private void b() {
        if (!a()) {
            if (this.f == null) {
                this.f = d();
            }
            removeView(this.b);
            addView(this.f, new LayoutParams(-2, -1));
            if (this.f.getAdapter() == null) {
                this.f.setAdapter(new cm(this));
            }
            if (this.a != null) {
                removeCallbacks(this.a);
                this.a = null;
            }
            this.f.setSelection(this.i);
        }
    }

    private boolean c() {
        if (a()) {
            removeView(this.f);
            addView(this.b, new LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner d() {
        Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, b.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    co a(a aVar, boolean z) {
        co coVar = new co(this, getContext(), aVar, z);
        if (z) {
            coVar.setBackgroundDrawable(null);
            coVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            coVar.setFocusable(true);
            if (this.e == null) {
                this.e = new cn(this);
            }
            coVar.setOnClickListener(this.e);
        }
        return coVar;
    }

    public void a(int i) {
        final View childAt = this.b.getChildAt(i);
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        this.a = new Runnable() {
            public void run() {
                cl.this.smoothScrollTo(childAt.getLeft() - ((cl.this.getWidth() - childAt.getWidth()) / 2), 0);
                cl.this.a = null;
            }
        };
        post(this.a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.view.a a = android.support.v7.view.a.a(getContext());
        setContentHeight(a.e());
        this.d = a.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((co) view).b().d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.c = -1;
        } else {
            if (childCount > 2) {
                this.c = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.c = MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        }
        mode = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (z || !this.g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.b.measure(0, mode);
            if (this.b.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f != null && i >= 0) {
            this.f.setSelection(i);
        }
    }
}
