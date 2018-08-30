package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public class VastVideoCloseButtonWidget extends RelativeLayout {
    @NonNull
    private TextView a;
    @NonNull
    private ImageView b;
    @NonNull
    private final ImageLoader c;
    @NonNull
    private CloseButtonDrawable d = new CloseButtonDrawable();
    private final int e;
    private final int f;
    private final int g;
    private final int h;

    public VastVideoCloseButtonWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.e = Dips.dipsToIntPixels(16.0f, context);
        this.g = Dips.dipsToIntPixels(5.0f, context);
        this.h = Dips.dipsToIntPixels(46.0f, context);
        this.f = Dips.dipsToIntPixels(7.0f, context);
        this.c = Networking.getImageLoader(context);
        a();
        b();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.h);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    private void a() {
        this.b = new ImageView(getContext());
        this.b.setId((int) Utils.generateUniqueId());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.h, this.h);
        layoutParams.addRule(11);
        this.b.setImageDrawable(this.d);
        this.b.setPadding(this.g, this.g + this.e, this.g + this.e, this.g);
        addView(this.b, layoutParams);
    }

    private void b() {
        this.a = new TextView(getContext());
        this.a.setSingleLine();
        this.a.setEllipsize(TruncateAt.END);
        this.a.setTextColor(-1);
        this.a.setTextSize(20.0f);
        this.a.setTypeface(CloseButton.TEXT_TYPEFACE);
        this.a.setText("");
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, this.b.getId());
        this.a.setPadding(0, this.e, 0, 0);
        layoutParams.setMargins(0, 0, this.f, 0);
        addView(this.a, layoutParams);
    }

    void a(@Nullable String str) {
        if (this.a != null) {
            this.a.setText(str);
        }
    }

    void b(@NonNull final String str) {
        this.c.get(str, new ImageListener() {
            public void onErrorResponse(VolleyError volleyError) {
                MoPubLog.d("Failed to load image.", volleyError);
            }

            public void onResponse(ImageContainer imageContainer, boolean z) {
                Bitmap bitmap = imageContainer.getBitmap();
                if (bitmap != null) {
                    VastVideoCloseButtonWidget.this.b.setImageBitmap(bitmap);
                    return;
                }
                MoPubLog.d(String.format("%s returned null bitmap", new Object[]{str}));
            }
        });
    }

    @Deprecated
    @VisibleForTesting
    ImageView getImageView() {
        return this.b;
    }

    @Deprecated
    @VisibleForTesting
    TextView getTextView() {
        return this.a;
    }

    @Deprecated
    @VisibleForTesting
    void setImageView(ImageView imageView) {
        this.b = imageView;
    }

    void setOnTouchListenerToContent(@Nullable OnTouchListener onTouchListener) {
        this.b.setOnTouchListener(onTouchListener);
        this.a.setOnTouchListener(onTouchListener);
    }
}
