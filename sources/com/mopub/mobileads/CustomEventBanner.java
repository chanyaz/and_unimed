package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;

public abstract class CustomEventBanner {

    public interface CustomEventBannerListener {
        void onBannerClicked();

        void onBannerCollapsed();

        void onBannerExpanded();

        void onBannerFailed(MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(View view);

        void onLeaveApplication();
    }

    protected abstract void a();

    protected abstract void a(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2);
}
