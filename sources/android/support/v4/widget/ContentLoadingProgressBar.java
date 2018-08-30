package android.support.v4.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    long a = -1;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    private final Runnable e = new Runnable() {
        public void run() {
            ContentLoadingProgressBar.this.b = false;
            ContentLoadingProgressBar.this.a = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable f = new Runnable() {
        public void run() {
            ContentLoadingProgressBar.this.c = false;
            if (!ContentLoadingProgressBar.this.d) {
                ContentLoadingProgressBar.this.a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    };

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
