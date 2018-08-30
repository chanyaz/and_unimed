package com.appnext.banners;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.g;
import com.appnext.core.l;
import com.appnext.core.m;
import com.appnext.core.r;
import com.appnext.core.s;
import java.util.Locale;

public class a extends d {
    private final int TICK = 330;
    private BannerAdRequest adRequest;
    private BannerAd bannerAd;
    private boolean clickEnabled = true;
    private BannerAdData currentAd;
    private int currentPosition = 0;
    private boolean finished = false;
    private int lastProgress = 0;
    private boolean loaded = false;
    private Handler mHandler;
    private MediaPlayer mediaPlayer;
    private boolean reportedImpression = false;
    private g serviceHelper;
    private boolean started = false;
    private String template = "";
    private Runnable tick = new Runnable() {
        public void run() {
            try {
                a.this.checkProgress();
                a.this.currentPosition = a.this.mediaPlayer.getCurrentPosition();
                if (a.this.mediaPlayer.getCurrentPosition() < a.this.mediaPlayer.getDuration() && !a.this.finished) {
                    a.this.mHandler.postDelayed(a.this.tick, 330);
                }
            } catch (Throwable th) {
            }
        }
    };
    private s userAction;
    private boolean userMute = true;
    private VideoView videoView;

    private void checkProgress() {
        try {
            if (this.mediaPlayer != null) {
                int currentPosition = (int) ((((float) this.mediaPlayer.getCurrentPosition()) / ((float) this.mediaPlayer.getDuration())) * 100.0f);
                if (currentPosition > 25 && this.lastProgress == 0) {
                    this.lastProgress = 25;
                    report(com.appnext.ads.a.cO);
                } else if (currentPosition > 50 && this.lastProgress == 25) {
                    this.lastProgress = 50;
                    report(com.appnext.ads.a.cP);
                } else if (currentPosition > 75 && this.lastProgress == 50) {
                    this.lastProgress = 75;
                    report(com.appnext.ads.a.cQ);
                }
            }
        } catch (Throwable th) {
        }
    }

    private void createVideo(final ViewGroup viewGroup) {
        try {
            if (this.adRequest.isAutoPlay()) {
                report(com.appnext.ads.a.di);
            } else {
                report(com.appnext.ads.a.dj);
            }
            if (this.adRequest.isMute()) {
                report(com.appnext.ads.a.dk);
            } else {
                report(com.appnext.ads.a.dl);
            }
            this.userMute = this.adRequest.isMute();
            ((ImageView) viewGroup.findViewById(R.id.mute)).setImageResource(this.userMute ? R.drawable.apnxt_banner_unmute : R.drawable.apnxt_banner_mute);
            viewGroup.findViewById(R.id.mute).setVisibility(0);
            viewGroup.findViewById(R.id.mute).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    a.this.userMute = !a.this.userMute;
                    if (a.this.mediaPlayer != null) {
                        try {
                            a.this.mediaPlayer.setVolume(a.this.userMute ? 0.0f : 1.0f, a.this.userMute ? 0.0f : 1.0f);
                            ((ImageView) viewGroup.findViewById(R.id.mute)).setImageResource(a.this.userMute ? R.drawable.apnxt_banner_unmute : R.drawable.apnxt_banner_mute);
                        } catch (Throwable th) {
                        }
                    }
                }
            });
            this.videoView = new VideoView(this.context.getApplicationContext());
        } catch (Throwable th) {
            g.c(th);
            return;
        }
        this.videoView.setLayoutParams(new LayoutParams(-1, -2));
        viewGroup.addView(this.videoView, 0);
        viewGroup.findViewById(R.id.click).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (a.this.isClickEnabled() && a.this.mediaPlayer != null && a.this.mediaPlayer.isPlaying()) {
                    a.this.click();
                    return;
                }
                ((ImageView) viewGroup.findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                viewGroup.findViewById(R.id.play).setVisibility(0);
                a.this.pause();
            }
        });
        this.videoView.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.mediaPlayer = mediaPlayer;
                a.this.mediaPlayer.seekTo(a.this.currentPosition);
                a.this.mediaPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {
                    public void onSeekComplete(MediaPlayer mediaPlayer) {
                        if (a.this.adRequest.isAutoPlay() && !a.this.finished && a.this.getVisiblePercent(a.this.rootView) > 90 && !a.this.mediaPlayer.isPlaying()) {
                            a.this.play();
                            try {
                                a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(8);
                            } catch (Throwable th) {
                            }
                            if (!a.this.started) {
                                a.this.report(com.appnext.ads.a.cN);
                                a.this.started = true;
                            }
                        }
                    }
                });
                if (a.this.adRequest.isAutoPlay() && !a.this.finished && a.this.getVisiblePercent(a.this.rootView) > 90) {
                    a.this.play();
                    try {
                        a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(8);
                    } catch (Throwable th) {
                    }
                    if (!a.this.started) {
                        a.this.report(com.appnext.ads.a.cN);
                        a.this.started = true;
                    }
                }
                a.this.mHandler.postDelayed(a.this.tick, 33);
                if (a.this.userMute) {
                    a.this.mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    a.this.mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
        });
        this.videoView.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.mediaPlayer != null && a.this.mediaPlayer.getCurrentPosition() != 0 && a.this.mediaPlayer.getDuration() != 0 && !a.this.finished) {
                    g.X("onCompletion. " + a.this.mediaPlayer.getCurrentPosition() + "/" + a.this.mediaPlayer.getDuration());
                    a.this.finished = true;
                    a.this.report(com.appnext.ads.a.cR);
                }
            }
        });
        this.videoView.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (!(i == -38 && i2 == 0)) {
                    g.X("mp error: what: " + i + " extra: " + i2);
                }
                return true;
            }
        });
        this.videoView.setVideoURI(Uri.parse(getVideoUrl(this.currentAd, this.adRequest.getVideoLength())));
        viewGroup.findViewById(R.id.play).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewGroup.findViewById(R.id.wide_image).setVisibility(8);
                viewGroup.findViewById(R.id.play).setVisibility(8);
                a.this.play();
            }
        });
        if (!this.adRequest.isAutoPlay()) {
            viewGroup.findViewById(R.id.play).setVisibility(0);
            new Thread(new Runnable() {
                public void run() {
                    final Bitmap aN = g.aN(a.this.currentAd.getWideImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            ((ImageView) viewGroup.findViewById(R.id.wide_image)).setImageBitmap(aN);
                            viewGroup.findViewById(R.id.wide_image).setVisibility(0);
                        }
                    });
                }
            }).start();
        }
    }

    private void createWideImage(final ImageView imageView) {
        report(com.appnext.ads.a.dh);
        new Thread(new Runnable() {
            public void run() {
                final Bitmap aN = g.aN(a.this.currentAd.getWideImageURL());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(aN);
                        imageView.setVisibility(0);
                        imageView.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                a.this.report(com.appnext.ads.a.dg);
                                a.this.click();
                            }
                        });
                    }
                });
            }
        }).start();
    }

    private String getVideoUrl(AppnextAd appnextAd, String str) {
        String videoUrl30Sec;
        if (str.equals("30")) {
            videoUrl30Sec = appnextAd.getVideoUrl30Sec();
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrl();
            }
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrlHigh30Sec();
            }
            return videoUrl30Sec.equals("") ? appnextAd.getVideoUrlHigh() : videoUrl30Sec;
        } else {
            videoUrl30Sec = appnextAd.getVideoUrl();
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrl30Sec();
            }
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrlHigh();
            }
            return videoUrl30Sec.equals("") ? appnextAd.getVideoUrlHigh30Sec() : videoUrl30Sec;
        }
    }

    private void inflateView(int i, final AppnextAd appnextAd) {
        CharSequence charSequence;
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(i, this.rootView, false);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.report(com.appnext.ads.a.dg);
                a.this.click();
            }
        });
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    a.this.report(com.appnext.ads.a.de);
                    a.this.click();
                }
            });
            new Thread(new Runnable() {
                public void run() {
                    final Bitmap aN = g.aN(appnextAd.getImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            imageView.setImageBitmap(aN);
                        }
                    });
                }
            }).start();
        }
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        if (textView != null) {
            textView.setText(appnextAd.getAdTitle());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    a.this.report(com.appnext.ads.a.dg);
                    a.this.click();
                }
            });
        }
        RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.ratingBar);
        if (ratingBar != null) {
            try {
                ratingBar.setRating(Float.parseFloat(appnextAd.getStoreRating()));
            } catch (Throwable th) {
                ratingBar.setVisibility(4);
            }
            ratingBar.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    a.this.report(com.appnext.ads.a.dg);
                    a.this.click();
                }
            });
        }
        textView = (TextView) inflate.findViewById(R.id.description);
        if (textView != null) {
            textView.setText(appnextAd.getAdDescription());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    a.this.report(com.appnext.ads.a.dg);
                    a.this.click();
                }
            });
        }
        View findViewById = inflate.findViewById(R.id.install);
        String buttonText = new BannerAdData(appnextAd).getButtonText();
        Object charSequence2;
        if (appnextAd == null || !buttonText.equals("")) {
            charSequence2 = buttonText;
        } else if (g.h(this.context, this.currentAd.getAdPackage())) {
            charSequence2 = c.aF().get("existing_button_text");
        } else {
            charSequence2 = c.aF().get("new_button_text");
        }
        ((TextView) findViewById).setText(charSequence2);
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.report(com.appnext.ads.a.df);
                a.this.click();
            }
        });
        View findViewById2 = inflate.findViewById(R.id.media);
        if (findViewById2 != null) {
            if (this.adRequest.getCreativeType().equals(BannerAdRequest.TYPE_ALL)) {
                if (b.hasVideo(this.currentAd)) {
                    createVideo((ViewGroup) findViewById2);
                } else {
                    createWideImage((ImageView) inflate.findViewById(R.id.wide_image));
                }
            } else if (this.adRequest.getCreativeType().equals("video") && b.hasVideo(this.currentAd)) {
                createVideo((ViewGroup) findViewById2);
            } else {
                createWideImage((ImageView) inflate.findViewById(R.id.wide_image));
            }
        }
        imageView = (ImageView) inflate.findViewById(R.id.privacy);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.openLink(g.f(a.this.currentAd));
            }
        });
        if (m.a(this.currentAd, c.aF())) {
            m.a(this.context, imageView);
        }
        if (this.rootView.getChildCount() > 0) {
            this.rootView.removeViewAt(0);
        }
        this.rootView.addView(inflate);
    }

    private void report(String str) {
        try {
            if (this.bannerAd != null) {
                g.a(this.bannerAd.getTID(), this.bannerAd.getVID(), this.bannerAd.getAUID(), getPlacementId() == null ? "" : getPlacementId(), this.bannerAd.getSessionId(), str, this.template, this.currentAd != null ? this.currentAd.getBannerID() : "", this.currentAd != null ? this.currentAd.getCampaignID() : "");
            }
        } catch (Throwable th) {
        }
    }

    public void click() {
        report(com.appnext.ads.a.da);
        if (getBannerListener() != null) {
            getBannerListener().onAdClicked();
        }
        this.userAction.a(this.currentAd, new BannerAdData(this.currentAd).getAppURL(), getPlacementId(), new com.appnext.core.e.a() {
            public void error(String str) {
            }

            public void onMarket(String str) {
                try {
                    if (a.this.mediaPlayer != null && a.this.mediaPlayer.isPlaying()) {
                        a.this.pause();
                        ((ImageView) a.this.rootView.findViewById(R.id.media).findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                        a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(0);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    protected Ad createAd(Context context, String str) {
        String bannerSize = getBannerSize().toString();
        Object obj = -1;
        switch (bannerSize.hashCode()) {
            case -1966536496:
                if (bannerSize.equals("LARGE_BANNER")) {
                    obj = 1;
                    break;
                }
                break;
            case -96588539:
                if (bannerSize.equals("MEDIUM_RECTANGLE")) {
                    obj = 2;
                    break;
                }
                break;
            case 1951953708:
                if (bannerSize.equals("BANNER")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return new SmallBannerAd(context, str);
            case 1:
                return new LargeBannerAd(context, str);
            case 2:
                return new MediumRectangleAd(context, str);
            default:
                throw new IllegalArgumentException("Wrong banner size " + getBannerSize());
        }
    }

    public void destroy() {
        super.destroy();
        this.userAction.destroy();
        try {
            if (this.videoView != null) {
                this.videoView.setOnCompletionListener(null);
                this.videoView.setOnErrorListener(null);
                this.videoView.setOnPreparedListener(null);
                this.videoView.suspend();
                this.videoView = null;
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th) {
        }
        try {
            if (this.serviceHelper != null) {
                this.serviceHelper.d(this.context);
            }
            this.serviceHelper = null;
        } catch (Throwable th2) {
        }
        try {
            this.bannerAd.destroy();
            this.bannerAd = null;
        } catch (Throwable th3) {
        }
        this.adRequest = null;
    }

    protected void finalize() {
        super.finalize();
        destroy();
    }

    public void getECPM(final BannerAdRequest bannerAdRequest, final OnECPMLoaded onECPMLoaded) {
        if (bannerAdRequest == null) {
            throw new IllegalStateException("BannerAdRequest cannot be null.");
        } else if (getPlacementId() == null) {
            throw new IllegalStateException("Missing placement id.");
        } else if (getBannerSize() == null) {
            throw new IllegalStateException("Missing banner size.");
        } else if (onECPMLoaded == null) {
            throw new IllegalStateException("callback cannot be null.");
        } else {
            if (this.bannerAd == null) {
                this.bannerAd = (BannerAd) createAd(this.context, getPlacementId());
            }
            this.bannerAd.setCategories(bannerAdRequest.getCategories());
            this.bannerAd.setPostback(bannerAdRequest.getPostback());
            b.aE().a(this.context, this.bannerAd, getPlacementId(), new com.appnext.core.c.a() {
                public <T> void a(T t) {
                    AppnextAd a = b.aE().a(a.this.context, a.this.bannerAd, bannerAdRequest.getCreativeType());
                    if (a == null) {
                        a.this.report(com.appnext.ads.a.cB);
                        if (onECPMLoaded != null) {
                            onECPMLoaded.error(AppnextError.NO_ADS);
                        }
                    } else if (onECPMLoaded != null) {
                        onECPMLoaded.ecpm(new ECPM(a.getECPM(), a.getPPR(), a.getBannerID()));
                    }
                }

                public void error(String str) {
                    if (onECPMLoaded != null) {
                        onECPMLoaded.error(str);
                    }
                }
            }, bannerAdRequest);
        }
    }

    public void impression() {
        if (this.loaded && !this.reportedImpression && getVisiblePercent(this.rootView) >= 50) {
            this.reportedImpression = true;
            if (this.currentAd != null) {
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        a.this.userAction.e(a.this.currentAd);
                    }
                }, (long) (Integer.parseInt(c.aF().get("postpone_impression_sec")) * 1000));
                report(com.appnext.ads.a.cL);
                l.dg().q(this.currentAd.getBannerID(), getPlacementId());
                if (Boolean.parseBoolean(c.aF().get("pview"))) {
                    this.mHandler.postDelayed(new Runnable() {
                        public void run() {
                            a.this.userAction.a(a.this.currentAd, a.this.currentAd.getAppURL(), null);
                        }
                    }, (long) (Integer.parseInt(c.aF().get("postpone_vta_sec")) * 1000));
                }
                if (getBannerListener() != null) {
                    getBannerListener().adImpression();
                }
            }
            if (Boolean.parseBoolean(c.aF().get("fq_control")) && this.bannerAd != null && this.bannerAd.fq_status) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            g.a("https://www.fqtag.com/pixel.cgi?org=TkBXEI5C3FBIr4zXwnmK&p=" + a.this.getPlacementId() + "&a=" + a.this.currentAd.getBannerID() + "&cmp=" + a.this.currentAd.getCampaignID() + "&fmt=banner&dmn=" + a.this.currentAd.getAdPackage() + "&ad=&rt=displayImg&gid=" + g.u(a.this.context) + "&aid=&applng=" + Locale.getDefault().toString() + "&app=" + a.this.context.getPackageName() + "&c1=100&c2=" + a.this.bannerAd.getTID() + "&c3=" + a.this.bannerAd.getAUID() + "&c4=" + a.this.bannerAd.getVID() + "&sl=1&fq=1", null);
                        } catch (Throwable th) {
                            g.c(th);
                        }
                    }
                }).start();
            }
        }
    }

    public void init(ViewGroup viewGroup) {
        super.init(viewGroup);
        this.userAction = new s(this.context, new com.appnext.core.s.a() {
            public Ad ac() {
                return a.this.bannerAd;
            }

            public AppnextAd ad() {
                return a.this.currentAd;
            }

            public r ae() {
                return c.aF();
            }

            public void report(String str) {
                a.this.report(str);
            }
        });
        this.mHandler = new Handler();
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public void loadAd(BannerAdRequest bannerAdRequest) {
        if (bannerAdRequest == null) {
            throw new IllegalStateException("BannerAdRequest cannot be null.");
        } else if (getPlacementId() == null) {
            throw new IllegalStateException("Missing placement id.");
        } else if (getBannerSize() == null) {
            throw new IllegalStateException("Missing banner size.");
        } else {
            if (this.bannerAd == null) {
                this.bannerAd = (BannerAd) createAd(this.context, getPlacementId());
            }
            this.bannerAd.setCategories(bannerAdRequest.getCategories());
            this.bannerAd.setPostback(bannerAdRequest.getPostback());
            this.adRequest = new BannerAdRequest(bannerAdRequest);
            setClickEnabled(bannerAdRequest.isClickEnabled());
            this.loaded = false;
            this.reportedImpression = false;
            if (g.aO(g.x(this.context)) == 0) {
                this.adRequest.setCreativeType("static");
            }
            l.dg().c(Integer.parseInt(c.aF().get("banner_expiration_time")));
            b.aE().a(this.context, this.bannerAd, getPlacementId(), new com.appnext.core.c.a() {
                public <T> void a(T r10) {
                    /*
                    r9 = this;
                    r4 = 2;
                    r2 = -1;
                    r3 = 1;
                    r1 = 0;
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.adRequest;
                    if (r0 != 0) goto L_0x000d;
                L_0x000c:
                    return;
                L_0x000d:
                    r0 = com.appnext.banners.b.aE();
                    r5 = com.appnext.banners.a.this;
                    r5 = r5.context;
                    r6 = com.appnext.banners.a.this;
                    r6 = r6.bannerAd;
                    r7 = com.appnext.banners.a.this;
                    r7 = r7.adRequest;
                    r7 = r7.getCreativeType();
                    r5 = r0.a(r5, r6, r7);
                    if (r5 != 0) goto L_0x004b;
                L_0x002b:
                    r0 = com.appnext.banners.a.this;
                    r1 = "error_no_ads";
                    r0.report(r1);
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerListener();
                    if (r0 == 0) goto L_0x000c;
                L_0x003a:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerListener();
                    r1 = new com.appnext.core.AppnextError;
                    r2 = "No Ads";
                    r1.<init>(r2);
                    r0.onError(r1);
                    goto L_0x000c;
                L_0x004b:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.rootView;
                    if (r0 == 0) goto L_0x000c;
                L_0x0051:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.context;
                    if (r0 != 0) goto L_0x005f;
                L_0x0057:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.rootView;
                    r0.removeAllViews();
                    goto L_0x000c;
                L_0x005f:
                    r0 = com.appnext.banners.a.this;
                    r6 = new com.appnext.banners.BannerAdData;
                    r6.<init>(r5);
                    r0.currentAd = r6;
                    r0 = com.appnext.banners.c.aF();
                    r6 = com.appnext.banners.a.this;
                    r6 = r6.getBannerSize();
                    r6 = r6.toString();
                    r0 = r0.get(r6);
                    r0 = com.appnext.banners.h.M(r0);
                    r6 = com.appnext.banners.a.this;
                    r7 = new java.lang.StringBuilder;
                    r7.<init>();
                    r8 = "apnxt_";
                    r7 = r7.append(r8);
                    r0 = r7.append(r0);
                    r0 = r0.toString();
                    r0 = r0.toLowerCase();
                    r6.template = r0;
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.rootView;
                    r0 = r0.getContext();
                    r0 = r0.getResources();
                    r6 = com.appnext.banners.a.this;
                    r6 = r6.template;
                    r7 = "layout";
                    r8 = com.appnext.banners.a.this;
                    r8 = r8.context;
                    r8 = r8.getPackageName();
                    r0 = r0.getIdentifier(r6, r7, r8);
                    if (r0 != 0) goto L_0x00d4;
                L_0x00bd:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerSize();
                    r0 = r0.toString();
                    r6 = r0.hashCode();
                    switch(r6) {
                        case -1966536496: goto L_0x0122;
                        case -96588539: goto L_0x012c;
                        case 1951953708: goto L_0x0118;
                        default: goto L_0x00ce;
                    };
                L_0x00ce:
                    r0 = r2;
                L_0x00cf:
                    switch(r0) {
                        case 0: goto L_0x0136;
                        case 1: goto L_0x0139;
                        case 2: goto L_0x013c;
                        default: goto L_0x00d2;
                    };
                L_0x00d2:
                    r0 = com.appnext.banners.R.layout.apnxt_banner_1;
                L_0x00d4:
                    r6 = com.appnext.banners.a.this;
                    r6.loaded = r3;
                    r6 = com.appnext.banners.a.this;
                    r6.reportedImpression = r1;
                    r6 = com.appnext.banners.a.this;
                    r6.inflateView(r0, r5);
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerListener();
                    if (r0 == 0) goto L_0x00f8;
                L_0x00eb:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerListener();
                    r5 = r5.getBannerID();
                    r0.onAdLoaded(r5);
                L_0x00f8:
                    r0 = com.appnext.banners.a.this;
                    r0 = r0.getBannerSize();
                    r0 = r0.toString();
                    r5 = r0.hashCode();
                    switch(r5) {
                        case -1966536496: goto L_0x0149;
                        case -96588539: goto L_0x0153;
                        case 1951953708: goto L_0x013f;
                        default: goto L_0x0109;
                    };
                L_0x0109:
                    r0 = r2;
                L_0x010a:
                    switch(r0) {
                        case 0: goto L_0x010f;
                        case 1: goto L_0x015d;
                        case 2: goto L_0x0166;
                        default: goto L_0x010d;
                    };
                L_0x010d:
                    goto L_0x000c;
                L_0x010f:
                    r0 = com.appnext.banners.a.this;
                    r1 = "loaded_banner";
                    r0.report(r1);
                    goto L_0x000c;
                L_0x0118:
                    r6 = "BANNER";
                    r0 = r0.equals(r6);
                    if (r0 == 0) goto L_0x00ce;
                L_0x0120:
                    r0 = r1;
                    goto L_0x00cf;
                L_0x0122:
                    r6 = "LARGE_BANNER";
                    r0 = r0.equals(r6);
                    if (r0 == 0) goto L_0x00ce;
                L_0x012a:
                    r0 = r3;
                    goto L_0x00cf;
                L_0x012c:
                    r6 = "MEDIUM_RECTANGLE";
                    r0 = r0.equals(r6);
                    if (r0 == 0) goto L_0x00ce;
                L_0x0134:
                    r0 = r4;
                    goto L_0x00cf;
                L_0x0136:
                    r0 = com.appnext.banners.R.layout.apnxt_banner_1;
                    goto L_0x00d4;
                L_0x0139:
                    r0 = com.appnext.banners.R.layout.apnxt_large_banner_1;
                    goto L_0x00d4;
                L_0x013c:
                    r0 = com.appnext.banners.R.layout.apnxt_medium_rectangle_1;
                    goto L_0x00d4;
                L_0x013f:
                    r3 = "BANNER";
                    r0 = r0.equals(r3);
                    if (r0 == 0) goto L_0x0109;
                L_0x0147:
                    r0 = r1;
                    goto L_0x010a;
                L_0x0149:
                    r1 = "LARGE_BANNER";
                    r0 = r0.equals(r1);
                    if (r0 == 0) goto L_0x0109;
                L_0x0151:
                    r0 = r3;
                    goto L_0x010a;
                L_0x0153:
                    r1 = "MEDIUM_RECTANGLE";
                    r0 = r0.equals(r1);
                    if (r0 == 0) goto L_0x0109;
                L_0x015b:
                    r0 = r4;
                    goto L_0x010a;
                L_0x015d:
                    r0 = com.appnext.banners.a.this;
                    r1 = "loaded_large_banner";
                    r0.report(r1);
                    goto L_0x000c;
                L_0x0166:
                    r0 = com.appnext.banners.a.this;
                    r1 = "loaded_medium_rectangle";
                    r0.report(r1);
                    goto L_0x000c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.12.a(java.lang.Object):void");
                }

                public void error(String str) {
                    String str2 = "";
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case -2026653947:
                            if (str.equals(AppnextError.INTERNAL_ERROR)) {
                                obj = 1;
                                break;
                            }
                            break;
                        case -1958363695:
                            if (str.equals(AppnextError.NO_ADS)) {
                                obj = 2;
                                break;
                            }
                            break;
                        case -1477010874:
                            if (str.equals(AppnextError.CONNECTION_ERROR)) {
                                obj = null;
                                break;
                            }
                            break;
                        case -507110949:
                            if (str.equals(AppnextError.NO_MARKET)) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 350741825:
                            if (str.equals(AppnextError.TIMEOUT)) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 844170097:
                            if (str.equals(AppnextError.SLOW_CONNECTION)) {
                                obj = 4;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            str2 = com.appnext.ads.a.cy;
                            break;
                        case 1:
                            str2 = com.appnext.ads.a.cC;
                            break;
                        case 2:
                            str2 = com.appnext.ads.a.cB;
                            break;
                        case 3:
                            str2 = com.appnext.ads.a.cD;
                            break;
                        case 4:
                            str2 = com.appnext.ads.a.cz;
                            break;
                        case 5:
                            str2 = com.appnext.ads.a.cE;
                            break;
                    }
                    a.this.report(str2);
                    if (a.this.getBannerListener() != null) {
                        a.this.getBannerListener().onError(new AppnextError(str));
                    }
                }
            }, this.adRequest);
        }
    }

    public void onScrollChanged(int i) {
        if (this.mediaPlayer != null && !this.finished) {
            if (this.mediaPlayer.isPlaying() && i < 90) {
                try {
                    this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(0);
                } catch (Throwable th) {
                }
                try {
                    pause();
                } catch (Throwable th2) {
                    return;
                }
            }
            if (!this.mediaPlayer.isPlaying() && i > 90 && this.adRequest.isAutoPlay()) {
                g.X("start. " + this.mediaPlayer.getCurrentPosition() + "/" + this.mediaPlayer.getDuration());
                play();
                try {
                    this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(8);
                } catch (Throwable th3) {
                }
                if (!this.started) {
                    report(com.appnext.ads.a.cN);
                    this.started = true;
                }
            }
        }
    }

    protected void openLink(String str) {
        try {
            if (this.mediaPlayer != null && this.mediaPlayer.isPlaying()) {
                pause();
                ((ImageView) this.rootView.findViewById(R.id.media).findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(0);
            }
        } catch (Throwable th) {
        }
        try {
            super.openLink(str);
        } catch (Throwable th2) {
            report(com.appnext.ads.a.cD);
        }
    }

    public void pause() {
        if (this.mediaPlayer != null && this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
    }

    public void play() {
        if (this.mediaPlayer != null && !this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.start();
        }
    }

    public void setClickEnabled(boolean z) {
        this.clickEnabled = z;
    }
}
