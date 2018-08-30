package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.Map;

public class VastVideoViewController extends BaseVideoViewController {
    public static final int WEBVIEW_PADDING = 16;
    private boolean A = false;
    private boolean B = false;
    private int C;
    private boolean D = false;
    private final VastVideoConfig a;
    @NonNull
    private final VastVideoView b;
    @NonNull
    private VastVideoGradientStripWidget c;
    @NonNull
    private VastVideoGradientStripWidget d;
    @NonNull
    private ImageView e;
    @NonNull
    private VastVideoProgressBarWidget f;
    @NonNull
    private VastVideoRadialCountdownWidget g;
    @NonNull
    private VastVideoCtaButtonWidget h;
    @NonNull
    private VastVideoCloseButtonWidget i;
    @Nullable
    private VastCompanionAdConfig j;
    @Nullable
    private final v k;
    @NonNull
    private final View l;
    @NonNull
    private final View m;
    @NonNull
    private final Map<String, VastCompanionAdConfig> n;
    @NonNull
    private View o;
    @NonNull
    private final View p;
    @NonNull
    private final View q;
    @NonNull
    private final VastVideoViewProgressRunnable r;
    @NonNull
    private final VastVideoViewCountdownRunnable s;
    @NonNull
    private final OnTouchListener t;
    private int u = 5000;
    private boolean v;
    private int w = -1;
    private boolean x;
    private boolean y;
    private boolean z = false;

    VastVideoViewController(final Activity activity, Bundle bundle, @Nullable Bundle bundle2, long j, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(activity, Long.valueOf(j), baseVideoViewControllerListener);
        Serializable serializable = null;
        if (bundle2 != null) {
            serializable = bundle2.getSerializable("resumed_vast_config");
        }
        Serializable serializable2 = bundle.getSerializable("vast_video_config");
        if (serializable != null && (serializable instanceof VastVideoConfig)) {
            this.a = (VastVideoConfig) serializable;
            this.w = bundle2.getInt("current_position", -1);
        } else if (serializable2 == null || !(serializable2 instanceof VastVideoConfig)) {
            throw new IllegalStateException("VastVideoConfig is invalid");
        } else {
            this.a = (VastVideoConfig) serializable2;
        }
        if (this.a.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        this.j = this.a.getVastCompanionAd(activity.getResources().getConfiguration().orientation);
        this.n = this.a.getSocialActionsCompanionAds();
        this.k = this.a.getVastIconConfig();
        this.t = new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && VastVideoViewController.this.q()) {
                    VastVideoViewController.this.D = true;
                    VastVideoViewController.this.a(EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_CLICK);
                    VastVideoViewController.this.a.handleClickForResult(activity, VastVideoViewController.this.x ? VastVideoViewController.this.C : VastVideoViewController.this.j(), 1);
                }
                return true;
            }
        };
        getLayout().setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        e(activity, 4);
        this.b = a((Context) activity, 0);
        this.b.requestFocus();
        this.l = a((Context) activity, this.a.getVastCompanionAd(2), 4);
        this.m = a((Context) activity, this.a.getVastCompanionAd(1), 4);
        a((Context) activity);
        b((Context) activity, 4);
        b((Context) activity);
        c((Context) activity, 4);
        this.q = a((Context) activity, this.k, 4);
        this.q.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                VastVideoViewController.this.o = VastVideoViewController.this.a(activity);
                VastVideoViewController.this.q.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        c((Context) activity);
        Context context = activity;
        this.p = a(context, (VastCompanionAdConfig) this.n.get(VastXmlManagerAggregator.SOCIAL_ACTIONS_AD_SLOT_ID), Dips.dipsToIntPixels(38.0f, activity), 6, this.h, 4, 16);
        d((Context) activity, 8);
        Handler handler = new Handler(Looper.getMainLooper());
        this.r = new VastVideoViewProgressRunnable(this, this.a, handler);
        this.s = new VastVideoViewCountdownRunnable(this, handler);
    }

    private VastVideoView a(@NonNull final Context context, int i) {
        if (this.a.getDiskMediaFileUrl() == null) {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        final VastVideoView vastVideoView = new VastVideoView(context);
        vastVideoView.setId((int) Utils.generateUniqueId());
        vastVideoView.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VastVideoViewController.this.C = VastVideoViewController.this.b.getDuration();
                VastVideoViewController.this.p();
                if (VastVideoViewController.this.j == null || VastVideoViewController.this.B) {
                    vastVideoView.prepareBlurredLastVideoFrame(VastVideoViewController.this.e, VastVideoViewController.this.a.getDiskMediaFileUrl());
                }
                VastVideoViewController.this.f.calibrateAndMakeVisible(VastVideoViewController.this.i(), VastVideoViewController.this.u);
                VastVideoViewController.this.g.a(VastVideoViewController.this.u);
                VastVideoViewController.this.A = true;
            }
        });
        vastVideoView.setOnTouchListener(this.t);
        vastVideoView.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VastVideoViewController.this.s();
                VastVideoViewController.this.k();
                VastVideoViewController.this.b(false);
                VastVideoViewController.this.x = true;
                if (VastVideoViewController.this.a.isRewardedVideo()) {
                    VastVideoViewController.this.a(RewardedVideoBroadcastReceiver.ACTION_REWARDED_VIDEO_COMPLETE);
                }
                if (!VastVideoViewController.this.y && VastVideoViewController.this.a.getRemainingProgressTrackerCount() == 0) {
                    VastVideoViewController.this.a.handleComplete(VastVideoViewController.this.f(), VastVideoViewController.this.j());
                }
                vastVideoView.setVisibility(4);
                VastVideoViewController.this.f.setVisibility(8);
                if (!VastVideoViewController.this.B) {
                    VastVideoViewController.this.q.setVisibility(8);
                } else if (VastVideoViewController.this.e.getDrawable() != null) {
                    VastVideoViewController.this.e.setScaleType(ScaleType.CENTER_CROP);
                    VastVideoViewController.this.e.setVisibility(0);
                }
                VastVideoViewController.this.c.a();
                VastVideoViewController.this.d.a();
                VastVideoViewController.this.h.b();
                if (VastVideoViewController.this.j != null) {
                    if (context.getResources().getConfiguration().orientation == 1) {
                        VastVideoViewController.this.m.setVisibility(0);
                    } else {
                        VastVideoViewController.this.l.setVisibility(0);
                    }
                    VastVideoViewController.this.j.a(context, VastVideoViewController.this.C);
                } else if (VastVideoViewController.this.e.getDrawable() != null) {
                    VastVideoViewController.this.e.setVisibility(0);
                }
            }
        });
        vastVideoView.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (vastVideoView.a(mediaPlayer, i, i2, VastVideoViewController.this.a.getDiskMediaFileUrl())) {
                    return true;
                }
                VastVideoViewController.this.s();
                VastVideoViewController.this.k();
                VastVideoViewController.this.a(false);
                VastVideoViewController.this.y = true;
                VastVideoViewController.this.a.handleError(VastVideoViewController.this.f(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, VastVideoViewController.this.j());
                return false;
            }
        });
        vastVideoView.setVideoPath(this.a.getDiskMediaFileUrl());
        vastVideoView.setVisibility(i);
        return vastVideoView;
    }

    @NonNull
    private VastWebView a(@NonNull final Context context, @NonNull final VastCompanionAdConfig vastCompanionAdConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastCompanionAdConfig);
        VastWebView a = VastWebView.a(context, vastCompanionAdConfig.getVastResource());
        a.a(new VastWebViewClickListener() {
            public void onVastWebViewClick() {
                VastVideoViewController.this.a(EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_CLICK);
                TrackingRequest.makeVastTrackingHttpRequest(vastCompanionAdConfig.getClickTrackers(), null, Integer.valueOf(VastVideoViewController.this.C), null, context);
                vastCompanionAdConfig.a(context, 1, null, VastVideoViewController.this.a.getDspCreativeId());
            }
        });
        a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                vastCompanionAdConfig.a(context, 1, str, VastVideoViewController.this.a.getDspCreativeId());
                return true;
            }
        });
        return a;
    }

    private void a(@NonNull Context context) {
        this.c = new VastVideoGradientStripWidget(context, Orientation.TOP_BOTTOM, this.a.getCustomForceOrientation(), this.j != null, 0, 6, getLayout().getId());
        getLayout().addView(this.c);
    }

    private void b(@NonNull Context context) {
        this.d = new VastVideoGradientStripWidget(context, Orientation.BOTTOM_TOP, this.a.getCustomForceOrientation(), this.j != null, 8, 2, this.f.getId());
        getLayout().addView(this.d);
    }

    private void b(@NonNull Context context, int i) {
        this.f = new VastVideoProgressBarWidget(context);
        this.f.setAnchorId(this.b.getId());
        this.f.setVisibility(i);
        getLayout().addView(this.f);
    }

    private void c(@NonNull Context context) {
        boolean z = true;
        boolean z2 = this.j != null;
        if (TextUtils.isEmpty(this.a.getClickThroughUrl())) {
            z = false;
        }
        this.h = new VastVideoCtaButtonWidget(context, this.b.getId(), z2, z);
        getLayout().addView(this.h);
        this.h.setOnTouchListener(this.t);
        String customCtaText = this.a.getCustomCtaText();
        if (customCtaText != null) {
            this.h.a(customCtaText);
        }
    }

    private void c(@NonNull Context context, int i) {
        this.g = new VastVideoRadialCountdownWidget(context);
        this.g.setVisibility(i);
        getLayout().addView(this.g);
    }

    private void d(@NonNull Context context, int i) {
        this.i = new VastVideoCloseButtonWidget(context);
        this.i.setVisibility(i);
        getLayout().addView(this.i);
        this.i.setOnTouchListenerToContent(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int c = VastVideoViewController.this.x ? VastVideoViewController.this.C : VastVideoViewController.this.j();
                if (motionEvent.getAction() == 1) {
                    VastVideoViewController.this.D = true;
                    VastVideoViewController.this.a.handleClose(VastVideoViewController.this.f(), c);
                    VastVideoViewController.this.d().onFinish();
                }
                return true;
            }
        });
        String customSkipText = this.a.getCustomSkipText();
        if (customSkipText != null) {
            this.i.a(customSkipText);
        }
        customSkipText = this.a.getCustomCloseIconUrl();
        if (customSkipText != null) {
            this.i.b(customSkipText);
        }
    }

    private void e(@NonNull Context context, int i) {
        this.e = new ImageView(context);
        this.e.setVisibility(i);
        getLayout().addView(this.e, new LayoutParams(-1, -1));
    }

    private void p() {
        int i = i();
        if (this.a.isRewardedVideo()) {
            this.u = i;
            return;
        }
        if (i < 16000) {
            this.u = i;
        }
        Integer skipOffsetMillis = this.a.getSkipOffsetMillis(i);
        if (skipOffsetMillis != null) {
            this.u = skipOffsetMillis.intValue();
            this.z = true;
        }
    }

    private boolean q() {
        return this.v;
    }

    private void r() {
        this.r.startRepeating(50);
        this.s.startRepeating(250);
    }

    private void s() {
        this.r.stop();
        this.s.stop();
    }

    @VisibleForTesting
    View a(Activity activity) {
        return a(activity, (VastCompanionAdConfig) this.n.get(VastXmlManagerAggregator.ADS_BY_AD_SLOT_ID), this.q.getHeight(), 1, this.q, 0, 6);
    }

    @NonNull
    @VisibleForTesting
    View a(@NonNull Context context, @Nullable VastCompanionAdConfig vastCompanionAdConfig, int i) {
        Preconditions.checkNotNull(context);
        View view;
        if (vastCompanionAdConfig == null) {
            view = new View(context);
            view.setVisibility(4);
            return view;
        }
        View relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        getLayout().addView(relativeLayout, new LayoutParams(-1, -1));
        view = a(context, vastCompanionAdConfig);
        view.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(Dips.dipsToIntPixels((float) (vastCompanionAdConfig.getWidth() + 16), context), Dips.dipsToIntPixels((float) (vastCompanionAdConfig.getHeight() + 16), context));
        layoutParams.addRule(13, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    @NonNull
    @VisibleForTesting
    View a(@NonNull Context context, @Nullable VastCompanionAdConfig vastCompanionAdConfig, int i, int i2, @NonNull View view, int i3, int i4) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(view);
        View view2;
        if (vastCompanionAdConfig == null) {
            view2 = new View(context);
            view2.setVisibility(4);
            return view2;
        }
        this.B = true;
        this.h.setHasSocialActions(this.B);
        view2 = a(context, vastCompanionAdConfig);
        int dipsToIntPixels = Dips.dipsToIntPixels((float) vastCompanionAdConfig.getWidth(), context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels((float) vastCompanionAdConfig.getHeight(), context);
        int i5 = (i - dipsToIntPixels2) / 2;
        int dipsToIntPixels3 = Dips.dipsToIntPixels((float) i4, context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        layoutParams.addRule(i2, view.getId());
        layoutParams.addRule(6, view.getId());
        layoutParams.setMargins(dipsToIntPixels3, i5, 0, 0);
        View relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(16);
        relativeLayout.addView(view2, new LayoutParams(-2, -2));
        getLayout().addView(relativeLayout, layoutParams);
        view2.setVisibility(i3);
        return view2;
    }

    @NonNull
    @VisibleForTesting
    View a(@NonNull final Context context, @Nullable final v vVar, int i) {
        Preconditions.checkNotNull(context);
        if (vVar == null) {
            return new View(context);
        }
        View a = VastWebView.a(context, vVar.e());
        a.a(new VastWebViewClickListener() {
            public void onVastWebViewClick() {
                TrackingRequest.makeVastTrackingHttpRequest(vVar.f(), null, Integer.valueOf(VastVideoViewController.this.j()), VastVideoViewController.this.o(), context);
                vVar.a(VastVideoViewController.this.f(), null, VastVideoViewController.this.a.getDspCreativeId());
            }
        });
        a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                vVar.a(VastVideoViewController.this.f(), str, VastVideoViewController.this.a.getDspCreativeId());
                return true;
            }
        });
        a.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(Dips.asIntPixels((float) vVar.a(), context), Dips.asIntPixels((float) vVar.b(), context));
        layoutParams.setMargins(Dips.dipsToIntPixels(12.0f, context), Dips.dipsToIntPixels(12.0f, context), 0, 0);
        getLayout().addView(a, layoutParams);
        return a;
    }

    protected void a() {
        super.a();
        switch (this.a.getCustomForceOrientation()) {
            case FORCE_PORTRAIT:
                d().onSetRequestedOrientation(1);
                break;
            case FORCE_LANDSCAPE:
                d().onSetRequestedOrientation(0);
                break;
        }
        this.a.handleImpression(f(), j());
        a(EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_SHOW);
    }

    void a(int i) {
        if (this.k != null && i >= this.k.c()) {
            this.q.setVisibility(0);
            this.k.a(f(), i, o());
            if (this.k.d() != null && i >= this.k.c() + this.k.d().intValue()) {
                this.q.setVisibility(8);
            }
        }
    }

    void a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            d().onFinish();
        }
    }

    protected void a(Configuration configuration) {
        int i = f().getResources().getConfiguration().orientation;
        this.j = this.a.getVastCompanionAd(i);
        if (this.l.getVisibility() == 0 || this.m.getVisibility() == 0) {
            if (i == 1) {
                this.l.setVisibility(4);
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(4);
                this.l.setVisibility(0);
            }
            if (this.j != null) {
                this.j.a(f(), this.C);
            }
        }
    }

    protected void a(@NonNull Bundle bundle) {
        bundle.putInt("current_position", this.w);
        bundle.putSerializable("resumed_vast_config", this.a);
    }

    protected VideoView b() {
        return this.b;
    }

    public boolean backButtonEnabled() {
        return this.v;
    }

    protected void c() {
        s();
        this.w = j();
        this.b.pause();
        if (!this.x && !this.D) {
            this.a.handlePause(f(), this.w);
        }
    }

    protected void d() {
        r();
        if (this.w > 0) {
            this.b.seekTo(this.w);
        }
        if (!this.x) {
            this.b.start();
        }
        if (this.w != -1) {
            this.a.handleResume(f(), this.w);
        }
    }

    protected void e() {
        s();
        a(EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_DISMISS);
        this.b.onDestroy();
    }

    protected void f() {
    }

    int i() {
        return this.b.getDuration();
    }

    int j() {
        return this.b.getCurrentPosition();
    }

    void k() {
        this.v = true;
        this.g.setVisibility(8);
        this.i.setVisibility(0);
        this.h.a();
        this.p.setVisibility(0);
    }

    boolean l() {
        return !this.v && j() >= this.u;
    }

    void m() {
        if (this.A) {
            this.g.a(this.u, j());
        }
    }

    void n() {
        this.f.updateProgress(j());
    }

    String o() {
        return this.a == null ? null : this.a.getNetworkMediaFileUrl();
    }
}
