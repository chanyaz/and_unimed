package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class h implements OnPreDrawListener {
    final ae a;
    final WeakReference<ImageView> b;
    Callback c;

    h(ae aeVar, ImageView imageView, Callback callback) {
        this.a = aeVar;
        this.b = new WeakReference(imageView);
        this.c = callback;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    void a() {
        this.c = null;
        ImageView imageView = (ImageView) this.b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.a.a().a(width, height).a(imageView, this.c);
                }
            }
        }
        return true;
    }
}
