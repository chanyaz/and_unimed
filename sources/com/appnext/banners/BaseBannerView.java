package com.appnext.banners;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.appnext.core.AppnextError;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.g;

public abstract class BaseBannerView extends ViewGroup {
    protected d bannerAdapter;
    private BannerListener bannerListener;
    OnScrollChangedListener onScrollChangedListener = new OnScrollChangedListener() {
        public void onScrollChanged() {
            BaseBannerView.this.impression();
            BaseBannerView.this.onScrollChanged();
        }
    };

    public BaseBannerView(Context context) {
        super(context);
        if (context == null) {
            throw new IllegalArgumentException("The context cannot be null.");
        }
        parseAttributeSet(null);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributeSet(attributeSet);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        parseAttributeSet(attributeSet);
    }

    @RequiresApi(api = 21)
    public BaseBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        parseAttributeSet(attributeSet);
    }

    private void impression() {
        getBannerAdapter().impression();
    }

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (getParent() == null) {
                return false;
            }
            Rect rect = new Rect();
            ((ViewGroup) getParent()).getHitRect(rect);
            return view.getLocalVisibleRect(rect);
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }

    private void onScrollChanged() {
        getBannerAdapter().onScrollChanged(getVisiblePercent(this));
    }

    private void parseAttributeSet(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            getBannerAdapter().init(this);
            c.aF().a(null);
            getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
            if (attributeSet != null) {
                TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.BannersAttrs);
                String string = obtainAttributes.getString(R.styleable.BannersAttrs_bannerSize);
                if (string != null) {
                    Object obj = -1;
                    switch (string.hashCode()) {
                        case -1966536496:
                            if (string.equals("LARGE_BANNER")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case -96588539:
                            if (string.equals("MEDIUM_RECTANGLE")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 1951953708:
                            if (string.equals("BANNER")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            setBannerSize(BannerSize.BANNER);
                            break;
                        case 1:
                            setBannerSize(BannerSize.LARGE_BANNER);
                            break;
                        case 2:
                            setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                            break;
                        default:
                            throw new IllegalArgumentException("Wrong banner size " + string);
                    }
                }
                String string2 = obtainAttributes.getString(R.styleable.BannersAttrs_placementId);
                if (string2 != null) {
                    setPlacementId(string2);
                }
                obtainAttributes.recycle();
                getBannerAdapter().setBannerListener(new BannerListener() {
                    public void adImpression() {
                        if (BaseBannerView.this.getBannerListener() != null) {
                            BaseBannerView.this.getBannerListener().adImpression();
                        }
                    }

                    public void onAdClicked() {
                        if (BaseBannerView.this.getBannerListener() != null) {
                            BaseBannerView.this.getBannerListener().onAdClicked();
                        }
                    }

                    public void onAdLoaded(String str) {
                        if (BaseBannerView.this.getBannerListener() != null) {
                            BaseBannerView.this.getBannerListener().onAdLoaded(str);
                        }
                        BaseBannerView.this.impression();
                    }

                    public void onError(AppnextError appnextError) {
                        if (BaseBannerView.this.getBannerListener() != null) {
                            BaseBannerView.this.getBannerListener().onError(appnextError);
                        }
                    }
                });
                getBannerAdapter().parseAttributeSet(attributeSet);
            }
        }
    }

    private void pause() {
        try {
            getBannerAdapter().pause();
        } catch (Throwable th) {
        }
    }

    private void play() {
        try {
            getBannerAdapter().play();
        } catch (Throwable th) {
        }
    }

    public void destroy() {
        getBannerAdapter().destroy();
        this.bannerAdapter = null;
        try {
            getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        } catch (Throwable th) {
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        impression();
    }

    protected void finalize() {
        super.finalize();
        destroy();
    }

    protected abstract d getBannerAdapter();

    BannerListener getBannerListener() {
        return this.bannerListener;
    }

    protected void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded) {
        getBannerAdapter().getECPM(bannerAdRequest, onECPMLoaded);
    }

    String getPlacementId() {
        return getBannerAdapter().getPlacementId();
    }

    public int getVisiblePercent(View view) {
        if (!isViewPartiallyVisible(this) || getWindowVisibility() == 8 || getWindowVisibility() == 4) {
            return 0;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return (int) ((((double) (rect.height() * rect.width())) * 100.0d) / ((double) (view.getWidth() * view.getHeight())));
    }

    public boolean isClickEnabled() {
        return getBannerAdapter().isClickEnabled();
    }

    public void loadAd(BannerAdRequest bannerAdRequest) {
        getBannerAdapter().loadAd(bannerAdRequest);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        impression();
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
        int measuredWidth;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else if (getBannerAdapter().getBannerSize() != null) {
            Context context = getContext();
            measuredWidth = (int) (((float) getBannerAdapter().getBannerSize().getWidth()) * context.getResources().getDisplayMetrics().scaledDensity);
            i3 = (int) (context.getResources().getDisplayMetrics().scaledDensity * ((float) getBannerAdapter().getBannerSize().getHeight()));
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setBannerListener(BannerListener bannerListener) {
        getBannerAdapter().setBannerListener(bannerListener);
    }

    public void setBannerSize(BannerSize bannerSize) {
        getBannerAdapter().setBannerSize(bannerSize);
    }

    public void setClickEnabled(boolean z) {
        getBannerAdapter().setClickEnabled(z);
    }

    public void setParams(String str, String str2) {
        c.aF().b(str, str2);
    }

    public void setPlacementId(String str) {
        getBannerAdapter().setPlacementId(str);
    }
}
