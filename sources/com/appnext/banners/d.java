package com.appnext.banners;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.g;

public abstract class d {
    private BannerListener bannerListener;
    private BannerSize bannerSize;
    protected Context context;
    private String placementId;
    protected ViewGroup rootView;

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (this.rootView.getParent() == null) {
                return false;
            }
            Rect rect = new Rect();
            ((ViewGroup) this.rootView.getParent()).getHitRect(rect);
            return view.getLocalVisibleRect(rect);
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }

    public abstract void click();

    public void destroy() {
        this.context = null;
    }

    public BannerListener getBannerListener() {
        return this.bannerListener;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    public abstract void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded);

    public String getPlacementId() {
        return this.placementId;
    }

    public int getVisiblePercent(View view) {
        if (!isViewPartiallyVisible(this.rootView) || this.rootView.getWindowVisibility() == 8 || this.rootView.getWindowVisibility() == 4) {
            return 0;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return (int) ((((double) (rect.height() * rect.width())) * 100.0d) / ((double) (view.getWidth() * view.getHeight())));
    }

    public abstract void impression();

    public void init(ViewGroup viewGroup) {
        this.rootView = viewGroup;
        this.context = viewGroup.getContext();
    }

    public boolean isClickEnabled() {
        return false;
    }

    public abstract void loadAd(BannerAdRequest bannerAdRequest);

    public void onScrollChanged(int i) {
    }

    protected void openLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public void parseAttributeSet(AttributeSet attributeSet) {
    }

    public void pause() {
    }

    public void play() {
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.bannerListener = bannerListener;
    }

    public void setBannerSize(BannerSize bannerSize) {
        if (bannerSize == null) {
            throw new IllegalArgumentException("The placement id cannot be null.");
        } else if (this.bannerSize != null) {
            throw new IllegalStateException("The banner size can only be set once.");
        } else {
            this.bannerSize = bannerSize;
        }
    }

    public void setClickEnabled(boolean z) {
    }

    public void setPlacementId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The placement id cannot be null.");
        } else if (this.placementId != null) {
            throw new IllegalStateException("The placement id can only be set once.");
        } else {
            this.placementId = str;
        }
    }
}
