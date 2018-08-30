package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzqa;

public class NativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzqa b = a();

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = a(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = a(context);
    }

    private final FrameLayout a(Context context) {
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzqa a() {
        ar.a(this.a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return isInEditMode() ? null : akc.b().a(this.a.getContext(), (FrameLayout) this, this.a);
    }

    protected final View a(String str) {
        try {
            IObjectWrapper zzak = this.b.zzak(str);
            if (zzak != null) {
                return (View) c.a(zzak);
            }
        } catch (Throwable e) {
            kk.b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    protected final void a(String str, View view) {
        try {
            this.b.zzb(str, c.a((Object) view));
        } catch (Throwable e) {
            kk.b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.a != view) {
            super.bringChildToFront(this.a);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View a = a("1098");
        return a instanceof AdChoicesView ? (AdChoicesView) a : null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.b != null) {
            try {
                this.b.zzb(c.a((Object) view), i);
            } catch (Throwable e) {
                kk.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    public void removeView(View view) {
        if (this.a != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a("1098", adChoicesView);
    }

    public void setNativeAd(a aVar) {
        try {
            this.b.zza((IObjectWrapper) aVar.a());
        } catch (Throwable e) {
            kk.b("Unable to call setNativeAd on delegate", e);
        }
    }
}
