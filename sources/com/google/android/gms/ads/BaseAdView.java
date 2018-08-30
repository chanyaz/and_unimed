package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.alk;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzjd;

class BaseAdView extends ViewGroup {
    protected final alk a;

    public BaseAdView(Context context, int i) {
        super(context);
        this.a = new alk(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.a = new alk(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.a = new alk(this, attributeSet, false, i2);
    }

    public void a() {
        this.a.i();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void a(d dVar) {
        this.a.a(dVar.a());
    }

    public void b() {
        this.a.h();
    }

    public void c() {
        this.a.a();
    }

    public a getAdListener() {
        return this.a.b();
    }

    public f getAdSize() {
        return this.a.c();
    }

    public String getAdUnitId() {
        return this.a.e();
    }

    public String getMediationAdapterClassName() {
        return this.a.j();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            f adSize;
            f fVar = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                kk.b("Unable to retrieve ad size.", e);
                adSize = fVar;
            }
            if (adSize != null) {
                Context context = getContext();
                b = adSize.b(context);
                i3 = adSize.a(context);
            } else {
                b = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            b = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(b, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(a aVar) {
        this.a.a(aVar);
        if (aVar == null) {
            this.a.a(null);
            this.a.a(null);
            return;
        }
        if (aVar instanceof zzjd) {
            this.a.a((zzjd) aVar);
        }
        if (aVar instanceof AppEventListener) {
            this.a.a((AppEventListener) aVar);
        }
    }

    public void setAdSize(f fVar) {
        this.a.a(fVar);
    }

    public void setAdUnitId(String str) {
        this.a.a(str);
    }
}
