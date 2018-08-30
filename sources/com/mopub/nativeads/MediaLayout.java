package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

@TargetApi(16)
public class MediaLayout extends RelativeLayout {
    @NonNull
    private volatile Mode a;
    @NonNull
    private MuteState b;
    @NonNull
    private ImageView c;
    @Nullable
    private TextureView d;
    @Nullable
    private ProgressBar e;
    @Nullable
    private ImageView f;
    @Nullable
    private ImageView g;
    @Nullable
    private ImageView h;
    @Nullable
    private VastVideoProgressBarWidget i;
    @Nullable
    private ImageView j;
    @Nullable
    private View k;
    @Nullable
    private Drawable l;
    @Nullable
    private Drawable m;
    private boolean n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;

    public enum Mode {
        IMAGE,
        PLAYING,
        LOADING,
        BUFFERING,
        PAUSED,
        FINISHED
    }

    public enum MuteState {
        MUTED,
        UNMUTED
    }

    public MediaLayout(@NonNull Context context) {
        this(context, null);
    }

    public MediaLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Mode.IMAGE;
        Preconditions.checkNotNull(context);
        this.b = MuteState.MUTED;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.c = new ImageView(context);
        this.c.setLayoutParams(layoutParams);
        this.c.setScaleType(ScaleType.CENTER_CROP);
        addView(this.c);
        this.o = Dips.asIntPixels(40.0f, context);
        this.p = Dips.asIntPixels(35.0f, context);
        this.q = Dips.asIntPixels(36.0f, context);
        this.r = Dips.asIntPixels(10.0f, context);
    }

    private void a() {
        switch (this.a) {
            case IMAGE:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case LOADING:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case BUFFERING:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                break;
            case PLAYING:
                break;
            case PAUSED:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(0);
                return;
            case FINISHED:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(0);
                return;
            default:
                return;
        }
        setMainImageVisibility(4);
        setLoadingSpinnerVisibility(4);
        setVideoControlVisibility(0);
        setPlayButtonVisibility(4);
    }

    private void setLoadingSpinnerVisibility(int i) {
        if (this.e != null) {
            this.e.setVisibility(i);
        }
        if (this.h != null) {
            this.h.setVisibility(i);
        }
    }

    private void setMainImageVisibility(int i) {
        this.c.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i) {
        if (this.f != null && this.k != null) {
            this.f.setVisibility(i);
            this.k.setVisibility(i);
        }
    }

    private void setVideoControlVisibility(int i) {
        if (this.g != null) {
            this.g.setVisibility(i);
        }
        if (this.i != null) {
            this.i.setVisibility(i);
        }
        if (this.j != null) {
            this.j.setVisibility(i);
        }
    }

    @Nullable
    public ImageView getMainImageView() {
        return this.c;
    }

    public TextureView getTextureView() {
        return this.d;
    }

    public void initForVideo() {
        if (!this.n) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.d = new TextureView(getContext());
            this.d.setLayoutParams(layoutParams);
            this.d.setId((int) Utils.generateUniqueId());
            addView(this.d);
            this.c.bringToFront();
            layoutParams = new RelativeLayout.LayoutParams(this.o, this.o);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            this.e = new ProgressBar(getContext());
            this.e.setLayoutParams(layoutParams);
            this.e.setPadding(0, this.r, this.r, 0);
            this.e.setIndeterminate(true);
            addView(this.e);
            layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
            layoutParams.addRule(8, this.d.getId());
            this.g = new ImageView(getContext());
            this.g.setLayoutParams(layoutParams);
            this.g.setImageDrawable(new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
            addView(this.g);
            layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
            layoutParams.addRule(6, this.d.getId());
            this.h = new ImageView(getContext());
            this.h.setLayoutParams(layoutParams);
            this.h.setImageDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
            addView(this.h);
            this.i = new VastVideoProgressBarWidget(getContext());
            this.i.setAnchorId(this.d.getId());
            this.i.calibrateAndMakeVisible(1000, 0);
            addView(this.i);
            this.l = Drawables.NATIVE_MUTED.createDrawable(getContext());
            this.m = Drawables.NATIVE_UNMUTED.createDrawable(getContext());
            layoutParams = new RelativeLayout.LayoutParams(this.q, this.q);
            layoutParams.addRule(9);
            layoutParams.addRule(2, this.i.getId());
            this.j = new ImageView(getContext());
            this.j.setLayoutParams(layoutParams);
            this.j.setScaleType(ScaleType.CENTER_INSIDE);
            this.j.setPadding(this.r, this.r, this.r, this.r);
            this.j.setImageDrawable(this.l);
            addView(this.j);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.k = new View(getContext());
            this.k.setLayoutParams(layoutParams);
            this.k.setBackgroundColor(0);
            addView(this.k);
            layoutParams = new RelativeLayout.LayoutParams(this.o, this.o);
            layoutParams.addRule(13);
            this.f = new ImageView(getContext());
            this.f.setLayoutParams(layoutParams);
            this.f.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(getContext()));
            addView(this.f);
            this.n = true;
            a();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, measuredWidth) : measuredWidth;
        }
        mode = (int) (0.5625f * ((float) size));
        if (mode2 != 1073741824 || size2 >= mode) {
            size2 = mode;
            mode = size;
        } else {
            mode = (int) (1.7777778f * ((float) size2));
        }
        if (Math.abs(size2 - measuredHeight) >= 2 || Math.abs(mode - measuredWidth) >= 2) {
            MoPubLog.v(String.format("Resetting mediaLayout size to w: %d h: %d", new Object[]{Integer.valueOf(mode), Integer.valueOf(size2)}));
            getLayoutParams().width = mode;
            getLayoutParams().height = size2;
        }
        super.onMeasure(i, i2);
    }

    public void reset() {
        setMode(Mode.IMAGE);
        setPlayButtonClickListener(null);
        setMuteControlClickListener(null);
        setVideoClickListener(null);
    }

    public void resetProgress() {
        if (this.i != null) {
            this.i.reset();
        }
    }

    public void setMainImageDrawable(@NonNull Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        this.c.setImageDrawable(drawable);
    }

    public void setMode(@NonNull Mode mode) {
        Preconditions.checkNotNull(mode);
        this.a = mode;
        post(new Runnable() {
            public void run() {
                MediaLayout.this.a();
            }
        });
    }

    public void setMuteControlClickListener(@Nullable OnClickListener onClickListener) {
        if (this.j != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setMuteState(@NonNull MuteState muteState) {
        Preconditions.checkNotNull(muteState);
        if (muteState != this.b) {
            this.b = muteState;
            if (this.j != null) {
                switch (this.b) {
                    case MUTED:
                        this.j.setImageDrawable(this.l);
                        return;
                    default:
                        this.j.setImageDrawable(this.m);
                        return;
                }
            }
        }
    }

    public void setPlayButtonClickListener(@Nullable OnClickListener onClickListener) {
        if (this.f != null && this.k != null) {
            this.k.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void setSurfaceTextureListener(@Nullable SurfaceTextureListener surfaceTextureListener) {
        if (this.d != null) {
            this.d.setSurfaceTextureListener(surfaceTextureListener);
            SurfaceTexture surfaceTexture = this.d.getSurfaceTexture();
            if (surfaceTexture != null && surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.d.getWidth(), this.d.getHeight());
            }
        }
    }

    public void setVideoClickListener(@Nullable OnClickListener onClickListener) {
        if (this.d != null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void updateProgress(int i) {
        if (this.i != null) {
            this.i.updateProgress(i);
        }
    }
}
