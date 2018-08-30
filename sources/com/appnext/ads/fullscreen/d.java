package com.appnext.ads.fullscreen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appnext.R;
import com.appnext.ads.a;
import com.appnext.core.AppnextAd;
import com.appnext.core.g;
import com.appnext.core.m;
import java.util.ArrayList;

public class d extends Fragment {
    private ArrayList<AppnextAd> aL;
    private ImageView dP;
    private TextView dQ;
    private boolean dR = false;
    private h dS;

    private void a(final RelativeLayout relativeLayout, final AppnextAd appnextAd, final boolean z) {
        new Thread(new Runnable() {
            public void run() {
                final Bitmap aN = g.aN(appnextAd.getImageURL());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        ((ImageView) relativeLayout.findViewById(R.id.icon)).setImageBitmap(aN);
                    }
                });
            }
        }).start();
        ((TextView) relativeLayout.findViewById(R.id.title)).setText(appnextAd.getAdTitle());
        ((RatingBar) relativeLayout.findViewById(R.id.rating)).setRating(Float.parseFloat(appnextAd.getStoreRating()));
        relativeLayout.findViewById(R.id.click).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                d.this.dS.installClicked(appnextAd);
                d.this.dR = true;
                if (z) {
                    d.this.report(a.cY);
                } else {
                    d.this.report(a.cZ);
                }
            }
        });
    }

    private void report(String str) {
        this.dS.report(str, "S3");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.dS = (h) activity;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.dS = (h) context;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(this.dS.getTemplate("S3"), viewGroup, false);
            this.aL = this.dS.getPostRollAds();
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.privacy);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.close);
            View findViewById = relativeLayout.findViewById(R.id.click);
            this.dP = (ImageView) relativeLayout.findViewById(R.id.media);
            this.dQ = (TextView) relativeLayout.findViewById(R.id.install);
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.this.dS.privacyClicked();
                }
            });
            if (m.a((AppnextAd) this.aL.get(0), this.dS.getConfigManager())) {
                m.a((Context) this.dS, imageView);
            }
            imageView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.this.dS.closeClicked();
                }
            });
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.this.dS.installClicked();
                }
            });
            this.dQ.setText(this.dS.getCtaText());
            new Thread(new Runnable() {
                public void run() {
                    final Bitmap aN = g.aN(((AppnextAd) d.this.aL.get(0)).getWideImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            d.this.dP.setImageBitmap(aN);
                        }
                    });
                }
            }).start();
            a(relativeLayout, (AppnextAd) this.aL.get(0), true);
            View findViewById2 = relativeLayout.findViewById(R.id.extra);
            if (findViewById2 != null) {
                if (this.aL.size() > 1) {
                    a((RelativeLayout) findViewById2.findViewById(R.id.item1), (AppnextAd) this.aL.get(1), false);
                } else {
                    findViewById2.findViewById(R.id.item1).setVisibility(4);
                }
                if (this.aL.size() > 2) {
                    a((RelativeLayout) findViewById2.findViewById(R.id.item2), (AppnextAd) this.aL.get(2), false);
                } else {
                    findViewById2.findViewById(R.id.item2).setVisibility(4);
                }
                if (findViewById2.findViewById(R.id.item3) != null) {
                    if (this.aL.size() > 3) {
                        a((RelativeLayout) findViewById2.findViewById(R.id.item3), (AppnextAd) this.aL.get(3), false);
                    } else {
                        findViewById2.findViewById(R.id.item3).setVisibility(4);
                    }
                }
            }
            report(a.cW);
            return relativeLayout;
        } catch (Throwable th) {
            g.c(th);
            this.dS.closeClicked();
            return null;
        }
    }

    public void onDestroyView() {
        report(a.cX);
        super.onDestroyView();
    }
}
