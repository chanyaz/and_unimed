package com.appnext.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class m {
    public static void a(final Context context, final ImageView imageView) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    final Bitmap aN = g.aN("https://cdn.appnext.com/tools/sdk/adchoices/adchoices_big.png");
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            try {
                                if (aN != null) {
                                    imageView.setImageDrawable(new BitmapDrawable(context.getResources(), aN));
                                    return;
                                }
                                imageView.setImageResource(C0000R.drawable.apnxt_adchoices);
                            } catch (Throwable th) {
                            }
                        }
                    });
                } catch (Throwable th) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            imageView.setImageResource(C0000R.drawable.apnxt_adchoices);
                        }
                    });
                }
            }
        }).start();
    }

    public static boolean a(AppnextAd appnextAd, r rVar) {
        return appnextAd.isGdpr() && Boolean.parseBoolean(rVar.get("gdpr"));
    }
}
