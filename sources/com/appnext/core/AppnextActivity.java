package com.appnext.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appnext.base.b.c;
import com.appnext.core.e.a;

public abstract class AppnextActivity extends Activity {
    protected String banner = "";
    protected String guid = "";
    protected Handler handler;
    protected String kS = "";
    private RelativeLayout kT;
    protected RelativeLayout kU;
    protected String placementID;
    protected s userAction;

    protected void a(ViewGroup viewGroup, Drawable drawable) {
        if (this.kT != null) {
            cV();
        }
        this.kT = new RelativeLayout(this);
        this.kT.setBackgroundColor(Color.parseColor("#77ffffff"));
        viewGroup.addView(this.kT);
        this.kT.getLayoutParams().height = -1;
        this.kT.getLayoutParams().width = -1;
        View progressBar = new ProgressBar(this, null, 16842871);
        progressBar.setIndeterminateDrawable(drawable);
        progressBar.setIndeterminate(true);
        this.kT.addView(progressBar);
        Animation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        progressBar.setAnimation(rotateAnimation);
        ((LayoutParams) progressBar.getLayoutParams()).addRule(13, -1);
        this.kT.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.handler.postDelayed(new Runnable() {
            public void run() {
                AppnextActivity.this.cV();
            }
        }, 8000);
    }

    protected void a(AppnextAd appnextAd, a aVar) {
        if (this.userAction != null && appnextAd != null) {
            this.userAction.a(appnextAd, appnextAd.getAppURL(), aVar);
        }
    }

    protected void b(AppnextAd appnextAd, a aVar) {
        if (this.userAction != null && appnextAd != null) {
            this.userAction.a(appnextAd, appnextAd.getAppURL(), this.placementID, aVar);
        }
    }

    @SuppressLint({"NewApi"})
    protected void cT() {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() ^ 2;
        if (VERSION.SDK_INT >= 16) {
            systemUiVisibility ^= 4;
        }
        if (VERSION.SDK_INT >= 18) {
            systemUiVisibility ^= 4096;
        }
        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
    }

    @SuppressLint({"NewApi"})
    protected void cU() {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() | 2;
        if (VERSION.SDK_INT >= 16) {
            systemUiVisibility |= 4;
        }
        if (VERSION.SDK_INT >= 18) {
            systemUiVisibility |= 4096;
        }
        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
    }

    protected void cV() {
        if (this.kT != null) {
            this.kT.removeAllViews();
            this.kT.removeAllViewsInLayout();
            if (this.kT.getParent() != null) {
                ((RelativeLayout) this.kT.getParent()).removeView(this.kT);
            }
        }
        if (this.handler != null) {
            this.handler.removeCallbacks(null);
        }
        this.kT = null;
    }

    protected abstract r getConfig();

    protected void onCreate(Bundle bundle) {
        new Thread(new Runnable() {
            public void run() {
                if (!g.B(AppnextActivity.this)) {
                    AppnextActivity.this.finish();
                    AppnextActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            AppnextActivity.this.onError(AppnextError.CONNECTION_ERROR);
                        }
                    });
                }
            }
        }).start();
        requestWindowFeature(1);
        getWindow().setFlags(c.jk, c.jk);
        getWindow().addFlags(128);
        super.onCreate(bundle);
        this.handler = new Handler();
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            this.handler.removeCallbacks(null);
            this.handler = null;
        } catch (Throwable th) {
        }
    }

    protected abstract void onError(String str);
}
