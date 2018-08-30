package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.k;
import com.google.android.gms.ads.m;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.ads.alk;
import com.google.android.gms.internal.ads.kk;

public final class PublisherAdView extends ViewGroup {
    private final alk a;

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new alk(this, attributeSet, true);
        ar.a((Object) context, (Object) "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new alk(this, attributeSet, true);
    }

    public final a getAdListener() {
        return this.a.b();
    }

    public final f getAdSize() {
        return this.a.c();
    }

    public final f[] getAdSizes() {
        return this.a.d();
    }

    public final String getAdUnitId() {
        return this.a.e();
    }

    public final AppEventListener getAppEventListener() {
        return this.a.f();
    }

    public final String getMediationAdapterClassName() {
        return this.a.j();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.a.g();
    }

    public final k getVideoController() {
        return this.a.k();
    }

    public final m getVideoOptions() {
        return this.a.m();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected final void onMeasure(int i, int i2) {
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

    public final void setAdListener(a aVar) {
        this.a.a(aVar);
    }

    public final void setAdSizes(f... fVarArr) {
        if (fVarArr == null || fVarArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.a.b(fVarArr);
    }

    public final void setAdUnitId(String str) {
        this.a.a(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.a.a(appEventListener);
    }

    public final void setCorrelator(g gVar) {
        this.a.a(gVar);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.a.a(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.a.a(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(m mVar) {
        this.a.a(mVar);
    }
}
