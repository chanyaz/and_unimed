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

public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzqa b = a();

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = a(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = a(context);
    }

    private final View a(String str) {
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

    private final FrameLayout a(Context context) {
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzqa a() {
        ar.a(this.a, (Object) "createDelegate must be called after overlayFrame has been created");
        return isInEditMode() ? null : akc.b().a(this.a.getContext(), (FrameLayout) this, this.a);
    }

    private final void a(String str, View view) {
        try {
            this.b.zzb(str, c.a((Object) view));
        } catch (Throwable e) {
            kk.b("Unable to call setAssetView on delegate", e);
        }
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.a);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.a != view) {
            super.bringChildToFront(this.a);
        }
    }

    public final AdChoicesView getAdChoicesView() {
        View a = a("3011");
        return a instanceof AdChoicesView ? (AdChoicesView) a : null;
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final MediaView getMediaView() {
        View a = a("3010");
        if (a instanceof MediaView) {
            return (MediaView) a;
        }
        if (a != null) {
            kk.b("View is not an instance of MediaView");
        }
        return null;
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final View getStoreView() {
        return a("3006");
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.b != null) {
            try {
                this.b.zzb(c.a((Object) view), i);
            } catch (Throwable e) {
                kk.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    public final void removeView(View view) {
        if (this.a != view) {
            super.removeView(view);
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        a("3011", adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        a("3005", view);
    }

    public final void setBodyView(View view) {
        a("3004", view);
    }

    public final void setCallToActionView(View view) {
        a("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.b.zzc(c.a((Object) view));
        } catch (Throwable e) {
            kk.b("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        a("3001", view);
    }

    public final void setIconView(View view) {
        a("3003", view);
    }

    public final void setImageView(View view) {
        a("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        a("3010", mediaView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.b.zza((IObjectWrapper) unifiedNativeAd.k());
        } catch (Throwable e) {
            kk.b("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        a("3007", view);
    }

    public final void setStarRatingView(View view) {
        a("3009", view);
    }

    public final void setStoreView(View view) {
        a("3006", view);
    }
}
