package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.f;
import com.google.android.gms.internal.ads.alk;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class SearchAdView extends ViewGroup {
    private final alk a;

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new alk(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new alk(this, attributeSet, false);
    }

    public final a getAdListener() {
        return this.a.b();
    }

    public final f getAdSize() {
        return this.a.c();
    }

    public final String getAdUnitId() {
        return this.a.e();
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

    public final void setAdSize(f fVar) {
        this.a.a(fVar);
    }

    public final void setAdUnitId(String str) {
        this.a.a(str);
    }
}
