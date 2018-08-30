package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

class u extends ViewGroup {
    @NonNull
    private final ProgressBar a;
    private int b;

    u(@NonNull Context context) {
        super(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setVisibility(8);
        setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        getBackground().setAlpha(180);
        this.a = new ProgressBar(context);
        this.b = Dips.asIntPixels(25.0f, getContext());
        this.a.setIndeterminate(true);
        addView(this.a);
    }

    boolean a() {
        Views.removeFromParent(this);
        setVisibility(8);
        return true;
    }

    boolean a(@NonNull View view) {
        Preconditions.checkNotNull(view);
        View rootView = view.getRootView();
        if (rootView == null || !(rootView instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) rootView;
        setVisibility(0);
        setMeasuredDimension(rootView.getWidth(), rootView.getHeight());
        viewGroup.addView(this);
        forceLayout();
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = (i + i3) / 2;
            int i6 = (i2 + i4) / 2;
            this.a.layout(i5 - this.b, i6 - this.b, i5 + this.b, i6 + this.b);
        }
    }
}
