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
import com.appnext.base.b.c;
import com.appnext.core.AppnextAd;
import com.appnext.core.g;
import com.appnext.core.m;
import java.util.ArrayList;

public class e extends Fragment {
    private i ea;
    private TextView eb;
    private int ec = 0;
    private ArrayList<AppnextAd> ed;
    private Handler handler;
    Runnable tick = new Runnable() {
        public void run() {
            e.this.handler.removeCallbacks(this);
            if (e.c(e.this) == 0) {
                e.this.ea.videoSelected((AppnextAd) e.this.ed.get(0));
                e.this.report(a.cJ);
                return;
            }
            if (e.this.eb != null) {
                e.this.eb.setText("" + e.this.ec + " sec");
            }
            e.this.handler.postDelayed(e.this.tick, 1000);
        }
    };

    private void a(ViewGroup viewGroup, final AppnextAd appnextAd, final int i) {
        TextView textView = (TextView) viewGroup.findViewById(R.id.title);
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.icon);
        final ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.background_image);
        RatingBar ratingBar = (RatingBar) viewGroup.findViewById(R.id.ratingBar);
        if (viewGroup.findViewById(R.id.playGameTextView) != null) {
            ((TextView) viewGroup.findViewById(R.id.playGameTextView)).setText(this.ea.getConfigManager().get("pre_cta_string"));
        }
        textView.setText(appnextAd.getAdTitle());
        ratingBar.setRating(Float.parseFloat(appnextAd.getStoreRating()));
        viewGroup.findViewById(R.id.click).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.ea.videoSelected(appnextAd);
                if (i == 0) {
                    e.this.report(a.cH);
                } else if (i == 1) {
                    e.this.report(a.cI);
                }
            }
        });
        if (imageView2 != null) {
            new Thread(new Runnable() {
                public void run() {
                    final Bitmap aN = g.aN(appnextAd.getWideImageURL());
                    final Bitmap aN2 = g.aN(appnextAd.getImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            imageView2.setImageBitmap(aN);
                            imageView.setImageBitmap(aN2);
                        }
                    });
                }
            }).start();
        }
        new Thread(new Runnable() {
            public void run() {
                Bitmap bitmap = null;
                if (imageView2 != null) {
                    bitmap = g.aN(appnextAd.getWideImageURL());
                }
                final Bitmap aN = g.aN(appnextAd.getImageURL());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (imageView2 != null) {
                            imageView2.setImageBitmap(bitmap);
                        }
                        imageView.setImageBitmap(aN);
                    }
                });
            }
        }).start();
    }

    static /* synthetic */ int c(e eVar) {
        int i = eVar.ec - 1;
        eVar.ec = i;
        return i;
    }

    private void report(String str) {
        this.ea.report(str, "S1");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ea = (i) activity;
        this.handler = new Handler();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.ea = (i) context;
        this.handler = new Handler();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey(c.ju)) {
            this.ec = getArguments().getInt(c.ju);
        }
        if (bundle != null) {
            this.ec = bundle.getInt(c.ju);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(this.ea.getTemplate("S1"), viewGroup, false);
            View findViewById = relativeLayout.findViewById(R.id.item1);
            View findViewById2 = relativeLayout.findViewById(R.id.item2);
            ((TextView) relativeLayout.findViewById(R.id.title)).setText(this.ea.getConfigManager().get("pre_title_string1"));
            ((TextView) relativeLayout.findViewById(R.id.secondTile)).setText(this.ea.getConfigManager().get("pre_title_string2"));
            this.eb = (TextView) relativeLayout.findViewById(R.id.timer);
            this.ed = this.ea.getPreRollAds();
            if (this.ed.size() < 2) {
                this.ea.videoSelected((AppnextAd) this.ed.get(0));
                return null;
            }
            a((ViewGroup) findViewById, (AppnextAd) this.ed.get(0), 0);
            a((ViewGroup) findViewById2, (AppnextAd) this.ed.get(1), 1);
            relativeLayout.findViewById(R.id.privacy).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    e.this.ea.privacyClicked();
                }
            });
            if (m.a((AppnextAd) this.ed.get(0), this.ea.getConfigManager())) {
                m.a((Context) this.ea, (ImageView) relativeLayout.findViewById(R.id.privacy));
            }
            this.eb.setText("" + this.ec + " sec");
            report(a.cG);
            return relativeLayout;
        } catch (Throwable th) {
            this.ea.closeClicked();
            return null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacksAndMessages(null);
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.tick);
    }

    public void onResume() {
        super.onResume();
        this.handler.postDelayed(this.tick, 1000);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(c.ju, this.ec);
        super.onSaveInstanceState(bundle);
    }
}
