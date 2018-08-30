package com.appnext.ads.fullscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.appnext.R;
import com.appnext.core.m;

public class g extends Fragment {
    private final int TICK = 330;
    private int currentPosition = 0;
    private Circle dw;
    Runnable eA = new Runnable() {
        public void run() {
            g.this.eu.setAlpha(1.0f);
            g.this.eu.animate().alpha(0.0f).setDuration(1000);
        }
    };
    private ImageView es;
    private Button et;
    private TextView eu;
    private ImageView ev;
    private Animation ew;
    private ImageView ex;
    private boolean ey = false;
    private j ez;
    private boolean finished = false;
    private int lastProgress = 0;
    private Handler mHandler = new Handler();
    private MediaPlayer mediaPlayer;
    private boolean started = false;
    @SuppressLint({"SetTextI18n"})
    Runnable tick = new Runnable() {
        public void run() {
            com.appnext.core.g.X("tick");
            if (g.this.videoView != null) {
                com.appnext.core.g.X("" + g.this.videoView.getCurrentPosition() + " of " + g.this.videoView.getDuration());
                if (g.this.videoView.getDuration() == -1) {
                    g.this.am();
                    return;
                }
                g.this.checkProgress();
                if (g.this.dw.getVisibility() == 0) {
                    Animation aVar = new a(g.this.dw, 360.0f - ((((float) (g.this.videoView.getCurrentPosition() + 1)) / ((float) g.this.videoView.getDuration())) * 360.0f));
                    aVar.setDuration(330);
                    g.this.dw.startAnimation(aVar);
                }
                if (g.this.videoView.getCurrentPosition() < g.this.videoView.getDuration() && !g.this.finished) {
                    g.this.mHandler.postDelayed(g.this.tick, 330);
                }
            }
        }
    };
    private VideoView videoView;

    class a extends Animation {
        final int eF;
        int eG;
        View view;

        public a(View view, int i, int i2) {
            this.view = view;
            this.eF = i;
            this.eG = i2;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.view.getLayoutParams().width = (int) (((float) this.eG) + (((float) (this.eF - this.eG)) * f));
            this.view.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    private void am() {
        try {
            if (this.mediaPlayer != null && this.mediaPlayer.getCurrentPosition() != 0 && this.mediaPlayer.getDuration() != 0 && !this.finished) {
                com.appnext.core.g.X("onCompletion. " + this.mediaPlayer.getCurrentPosition() + "/" + this.mediaPlayer.getDuration());
                this.finished = true;
                if (this.ez != null) {
                    this.ez.videoEnded();
                }
                report(com.appnext.ads.a.cR);
            }
        } catch (Throwable th) {
        }
    }

    private void an() {
        this.ew = AnimationUtils.loadAnimation(getActivity(), R.anim.apnxt_stream_loader);
        this.ew.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (g.this.ev.getVisibility() != 8) {
                    g.this.ev.startAnimation(g.this.ew);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.ew.setRepeatCount(-1);
        this.ew.setRepeatMode(1);
    }

    private void checkProgress() {
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

    private void report(String str) {
        this.ez.report(str, "S2");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ez = (j) activity;
        an();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.ez = (j) context;
        an();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, final Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(this.ez.getTemplate("S2"), viewGroup, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.privacy);
            this.ex = (ImageView) relativeLayout.findViewById(R.id.close);
            this.es = (ImageView) relativeLayout.findViewById(R.id.v_view);
            this.et = (Button) relativeLayout.findViewById(R.id.install);
            this.dw = (Circle) relativeLayout.findViewById(R.id.circle);
            this.eu = (TextView) relativeLayout.findViewById(R.id.click_txt);
            this.eu.setText("You will be redirected to " + (this.ez.isInstalled() ? "app" : "Google Play") + " once the ad will finish");
            this.ev = (ImageView) relativeLayout.findViewById(R.id.loader);
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    g.this.ez.privacyClicked();
                }
            });
            if (m.a(this.ez.getSelectedAd(), this.ez.getConfigManager())) {
                m.a((Context) this.ez, imageView);
            }
            this.ex.setVisibility(8);
            if (this.ez.showClose()) {
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        g.this.ex.setVisibility(0);
                    }
                }, this.ez.closeDelay());
            }
            this.ex.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    g.this.ez.closeClicked();
                }
            });
            if (!(getArguments() == null || !getArguments().containsKey("showCta") || getArguments().getBoolean("showCta"))) {
                this.et.setVisibility(8);
            }
            this.et.setText(this.ez.getCtaText());
            this.et.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    g.this.ez.installClicked();
                    Animation aVar = new a(g.this.et, com.appnext.core.g.a(g.this.getActivity(), 40.0f), g.this.et.getMeasuredWidth());
                    aVar.setDuration(300);
                    aVar.setInterpolator(new AccelerateInterpolator());
                    aVar.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            g.this.es.setVisibility(0);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            g.this.et.setText("");
                        }
                    });
                    if (!g.this.et.getText().equals("")) {
                        g.this.et.startAnimation(aVar);
                    }
                    g.this.report(com.appnext.ads.a.cS);
                }
            });
            this.es.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    g.this.eu.setVisibility(0);
                    g.this.eu.setAlpha(0.0f);
                    g.this.eu.animate().alpha(1.0f).setDuration(1000);
                    if (!g.this.ey) {
                        g.this.ey = true;
                        g.this.report(com.appnext.ads.a.cT);
                    }
                    int captionTextTime = g.this.ez.getCaptionTextTime();
                    if (captionTextTime == -2) {
                        captionTextTime = Integer.parseInt(g.this.ez.getConfigManager().get("caption_text_time"));
                    }
                    if (captionTextTime > 0) {
                        g.this.mHandler.postDelayed(g.this.eA, (long) (captionTextTime * 1000));
                    }
                }
            });
            try {
                this.videoView = new VideoView(getActivity().getApplicationContext());
            } catch (Throwable th) {
                com.appnext.core.g.c(th);
            }
            this.videoView.setLayoutParams(new LayoutParams(-1, -2));
            ((ViewGroup) relativeLayout.findViewById(R.id.media)).addView(this.videoView, 0);
            this.videoView.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    g.this.mediaPlayer = mediaPlayer;
                    g.this.mediaPlayer.seekTo(g.this.currentPosition);
                    g.this.mediaPlayer.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
                        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                            if (i < 100) {
                                g.this.ev.setVisibility(0);
                                g.this.ev.startAnimation(g.this.ew);
                                g.this.mediaPlayer.pause();
                                return;
                            }
                            g.this.ev.clearAnimation();
                            g.this.ev.setVisibility(8);
                            g.this.mediaPlayer.start();
                        }
                    });
                    g.this.mediaPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            g.this.mediaPlayer.start();
                        }
                    });
                    g.this.mediaPlayer.start();
                    if ((bundle == null || !bundle.getBoolean("started")) && g.this.ez != null) {
                        g.this.started = true;
                        g.this.ez.videoStarted();
                        g.this.report(com.appnext.ads.a.cN);
                    }
                    g.this.mHandler.postDelayed(g.this.tick, 33);
                    if (g.this.ez.getMute()) {
                        g.this.mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        g.this.mediaPlayer.setVolume(1.0f, 1.0f);
                    }
                }
            });
            this.videoView.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    g.this.am();
                }
            });
            this.videoView.setOnErrorListener(new OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    if (!(i == -38 && i2 == 0)) {
                        com.appnext.core.g.X("mp error: what: " + i + " extra: " + i2);
                    }
                    return true;
                }
            });
            this.videoView.setVideoURI(this.ez.getSelectedVideoUri());
            report(com.appnext.ads.a.cK);
            return relativeLayout;
        } catch (Throwable th2) {
            this.ez.closeClicked();
            return null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.videoView != null) {
                this.videoView.setOnCompletionListener(null);
                this.videoView.setOnErrorListener(null);
                this.videoView.setOnPreparedListener(null);
                this.videoView.suspend();
                this.videoView = null;
            }
        } catch (Throwable th) {
        }
        try {
            if (this.mediaPlayer != null) {
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th2) {
        }
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.tick);
        if (this.videoView != null) {
            this.videoView.pause();
            this.currentPosition = this.videoView.getCurrentPosition();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.videoView != null && !this.finished) {
            try {
                this.mediaPlayer.seekTo(this.currentPosition);
                this.mediaPlayer.start();
                this.mHandler.postDelayed(this.tick, 33);
            } catch (Throwable th) {
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("currentPosition", this.currentPosition);
        bundle.putBoolean("started", this.started);
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.currentPosition = bundle.getInt("currentPosition");
        }
    }
}
