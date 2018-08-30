package com.mopub.mraid;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class d {
    int a;
    @NonNull
    private final View[] b;
    @NonNull
    private final Handler c;
    @Nullable
    private Runnable d;
    private final Runnable e;

    private d(@NonNull Handler handler, @NonNull View[] viewArr) {
        this.e = new Runnable() {
            public void run() {
                for (final View view : d.this.b) {
                    if (view.getHeight() > 0 || view.getWidth() > 0) {
                        d.this.b();
                    } else {
                        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            public boolean onPreDraw() {
                                view.getViewTreeObserver().removeOnPreDrawListener(this);
                                d.this.b();
                                return true;
                            }
                        });
                    }
                }
            }
        };
        this.c = handler;
        this.b = viewArr;
    }

    /* synthetic */ d(Handler handler, View[] viewArr, com.mopub.mraid.MraidController.AnonymousClass1 anonymousClass1) {
        this(handler, viewArr);
    }

    private void b() {
        this.a--;
        if (this.a == 0 && this.d != null) {
            this.d.run();
            this.d = null;
        }
    }

    void a() {
        this.c.removeCallbacks(this.e);
        this.d = null;
    }

    void a(@NonNull Runnable runnable) {
        this.d = runnable;
        this.a = this.b.length;
        this.c.post(this.e);
    }
}
