package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CtaButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

@TargetApi(16)
public class NativeFullScreenVideoView extends RelativeLayout {
    @NonNull
    @VisibleForTesting
    Mode a;
    @VisibleForTesting
    final int b;
    @VisibleForTesting
    final int c;
    @VisibleForTesting
    final int d;
    @VisibleForTesting
    final int e;
    @VisibleForTesting
    final int f;
    @VisibleForTesting
    final int g;
    @VisibleForTesting
    final int h;
    @VisibleForTesting
    final int i;
    private int j;
    @NonNull
    private final ImageView k;
    @NonNull
    private final TextureView l;
    @NonNull
    private final ProgressBar m;
    @NonNull
    private final ImageView n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final VastVideoProgressBarWidget p;
    @NonNull
    private final View q;
    @NonNull
    private final ImageView r;
    @NonNull
    private final ImageView s;
    @NonNull
    private final ImageView t;
    @NonNull
    private final ImageView u;

    public enum Mode {
        LOADING,
        PLAYING,
        PAUSED,
        FINISHED
    }

    public NativeFullScreenVideoView(@NonNull Context context, int i, @Nullable String str) {
        this(context, i, str, new ImageView(context), new TextureView(context), new ProgressBar(context), new ImageView(context), new ImageView(context), new VastVideoProgressBarWidget(context), new View(context), new ImageView(context), new ImageView(context), new ImageView(context), new ImageView(context));
    }

    @VisibleForTesting
    NativeFullScreenVideoView(@NonNull Context context, int i, @Nullable String str, @NonNull ImageView imageView, @NonNull TextureView textureView, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull VastVideoProgressBarWidget vastVideoProgressBarWidget, @NonNull View view, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7) {
        super(context);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(imageView);
        Preconditions.checkNotNull(textureView);
        Preconditions.checkNotNull(progressBar);
        Preconditions.checkNotNull(imageView2);
        Preconditions.checkNotNull(imageView3);
        Preconditions.checkNotNull(vastVideoProgressBarWidget);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(imageView4);
        Preconditions.checkNotNull(imageView5);
        Preconditions.checkNotNull(imageView6);
        Preconditions.checkNotNull(imageView7);
        this.j = i;
        this.a = Mode.LOADING;
        this.b = Dips.asIntPixels(200.0f, context);
        this.c = Dips.asIntPixels(42.0f, context);
        this.d = Dips.asIntPixels(10.0f, context);
        this.e = Dips.asIntPixels(50.0f, context);
        this.f = Dips.asIntPixels(8.0f, context);
        this.g = Dips.asIntPixels(44.0f, context);
        this.h = Dips.asIntPixels(50.0f, context);
        this.i = Dips.asIntPixels(45.0f, context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.l = textureView;
        this.l.setId((int) Utils.generateUniqueId());
        this.l.setLayoutParams(layoutParams);
        addView(this.l);
        this.k = imageView;
        this.k.setId((int) Utils.generateUniqueId());
        this.k.setLayoutParams(layoutParams);
        this.k.setBackgroundColor(0);
        addView(this.k);
        layoutParams = new RelativeLayout.LayoutParams(this.h, this.h);
        layoutParams.addRule(13);
        this.m = progressBar;
        this.m.setId((int) Utils.generateUniqueId());
        this.m.setBackground(new n(context));
        this.m.setLayoutParams(layoutParams);
        this.m.setIndeterminate(true);
        addView(this.m);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.i);
        layoutParams.addRule(8, this.l.getId());
        this.n = imageView2;
        this.n.setId((int) Utils.generateUniqueId());
        this.n.setLayoutParams(layoutParams);
        this.n.setImageDrawable(new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
        addView(this.n);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.i);
        layoutParams.addRule(10);
        this.o = imageView3;
        this.o.setId((int) Utils.generateUniqueId());
        this.o.setLayoutParams(layoutParams);
        this.o.setImageDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
        addView(this.o);
        this.p = vastVideoProgressBarWidget;
        this.p.setId((int) Utils.generateUniqueId());
        this.p.setAnchorId(this.l.getId());
        this.p.calibrateAndMakeVisible(1000, 0);
        addView(this.p);
        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.q = view;
        this.q.setId((int) Utils.generateUniqueId());
        this.q.setLayoutParams(layoutParams);
        this.q.setBackgroundColor(DrawableConstants.TRANSPARENT_GRAY);
        addView(this.q);
        layoutParams = new RelativeLayout.LayoutParams(this.h, this.h);
        layoutParams.addRule(13);
        this.r = imageView4;
        this.r.setId((int) Utils.generateUniqueId());
        this.r.setLayoutParams(layoutParams);
        this.r.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(context));
        addView(this.r);
        this.s = imageView5;
        this.s.setId((int) Utils.generateUniqueId());
        this.s.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
        this.s.setPadding(this.f, this.f, this.f * 2, this.f * 2);
        addView(this.s);
        Drawable ctaButtonDrawable = new CtaButtonDrawable(context);
        if (!TextUtils.isEmpty(str)) {
            ctaButtonDrawable.setCtaText(str);
        }
        this.t = imageView6;
        this.t.setId((int) Utils.generateUniqueId());
        this.t.setImageDrawable(ctaButtonDrawable);
        addView(this.t);
        this.u = imageView7;
        this.u.setId((int) Utils.generateUniqueId());
        this.u.setImageDrawable(new CloseButtonDrawable());
        this.u.setPadding(this.f * 3, this.f, this.f, this.f * 3);
        addView(this.u);
        a();
    }

    private void a() {
        switch (this.a) {
            case LOADING:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(4);
                break;
            case PLAYING:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(4);
                break;
            case PAUSED:
                setCachedImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(0);
                setPlayButtonVisibility(0);
                break;
            case FINISHED:
                setCachedImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoProgressVisibility(4);
                setPlayButtonVisibility(0);
                break;
        }
        b();
        c();
    }

    private void b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        LayoutParams layoutParams = this.l.getLayoutParams();
        int dipsToIntPixels = Dips.dipsToIntPixels((float) configuration.screenWidthDp, getContext());
        if (dipsToIntPixels != layoutParams.width) {
            layoutParams.width = dipsToIntPixels;
        }
        int dipsToIntPixels2 = Dips.dipsToIntPixels((((float) configuration.screenWidthDp) * 9.0f) / 16.0f, getContext());
        if (dipsToIntPixels2 != layoutParams.height) {
            layoutParams.height = dipsToIntPixels2;
        }
    }

    private void c() {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        layoutParams.setMargins(this.d, this.d, this.d, this.d);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.g, this.g);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.e, this.e);
        switch (this.j) {
            case 1:
                layoutParams.addRule(3, this.l.getId());
                layoutParams.addRule(14);
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
                layoutParams3.addRule(10);
                layoutParams3.addRule(11);
                break;
            case 2:
                layoutParams.addRule(2, this.p.getId());
                layoutParams.addRule(11);
                layoutParams2.addRule(6, this.l.getId());
                layoutParams2.addRule(5, this.l.getId());
                layoutParams3.addRule(6, this.l.getId());
                layoutParams3.addRule(7, this.l.getId());
                break;
        }
        this.t.setLayoutParams(layoutParams);
        this.s.setLayoutParams(layoutParams2);
        this.u.setLayoutParams(layoutParams3);
    }

    private void setCachedImageVisibility(int i) {
        this.k.setVisibility(i);
    }

    private void setLoadingSpinnerVisibility(int i) {
        this.m.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i) {
        this.r.setVisibility(i);
        this.q.setVisibility(i);
    }

    private void setVideoProgressVisibility(int i) {
        this.p.setVisibility(i);
    }

    @Deprecated
    @VisibleForTesting
    ImageView getCtaButton() {
        return this.t;
    }

    @NonNull
    public TextureView getTextureView() {
        return this.l;
    }

    public void resetProgress() {
        this.p.reset();
    }

    public void setCachedVideoFrame(@Nullable Bitmap bitmap) {
        this.k.setImageBitmap(bitmap);
    }

    public void setCloseControlListener(@Nullable OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
    }

    public void setCtaClickListener(@Nullable OnClickListener onClickListener) {
        this.t.setOnClickListener(onClickListener);
    }

    public void setMode(@NonNull Mode mode) {
        Preconditions.checkNotNull(mode);
        if (this.a != mode) {
            this.a = mode;
            a();
        }
    }

    public void setOrientation(int i) {
        if (this.j != i) {
            this.j = i;
            a();
        }
    }

    public void setPlayControlClickListener(@Nullable OnClickListener onClickListener) {
        this.r.setOnClickListener(onClickListener);
        this.q.setOnClickListener(onClickListener);
    }

    public void setPrivacyInformationClickListener(@Nullable OnClickListener onClickListener) {
        this.s.setOnClickListener(onClickListener);
    }

    public void setSurfaceTextureListener(@Nullable SurfaceTextureListener surfaceTextureListener) {
        this.l.setSurfaceTextureListener(surfaceTextureListener);
        SurfaceTexture surfaceTexture = this.l.getSurfaceTexture();
        if (surfaceTexture != null && surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.l.getWidth(), this.l.getHeight());
        }
    }

    public void updateProgress(int i) {
        this.p.updateProgress(i);
    }
}
