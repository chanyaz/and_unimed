package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.util.AttributeSet;

public class ContentLoadingSmoothProgressBar extends SmoothProgressBar {
    private long a = -1;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private final Runnable e = new Runnable() {
        public void run() {
            ContentLoadingSmoothProgressBar.this.b = false;
            ContentLoadingSmoothProgressBar.this.a = -1;
            ContentLoadingSmoothProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable f = new Runnable() {
        public void run() {
            ContentLoadingSmoothProgressBar.this.c = false;
            if (!ContentLoadingSmoothProgressBar.this.d) {
                ContentLoadingSmoothProgressBar.this.a = System.currentTimeMillis();
                ContentLoadingSmoothProgressBar.this.setVisibility(0);
            }
        }
    };

    public ContentLoadingSmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
