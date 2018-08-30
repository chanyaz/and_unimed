package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class at implements OnAttachStateChangeListener, OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private at(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static at a(View view, Runnable runnable) {
        at atVar = new at(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(atVar);
        view.addOnAttachStateChangeListener(atVar);
        return atVar;
    }

    public void a() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
