package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import com.google.android.gms.ads.internal.au;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public class pc extends oz {
    @GuardedBy("this")
    private boolean b;
    @GuardedBy("this")
    private boolean c;

    public pc(oo ooVar) {
        super(ooVar);
        au.i().i();
    }

    private final synchronized void c() {
        if (!this.c) {
            this.c = true;
            au.i().j();
        }
    }

    @GuardedBy("this")
    protected void a(boolean z) {
    }

    final /* synthetic */ void b() {
        super.destroy();
    }

    public synchronized void destroy() {
        if (!this.b) {
            this.b = true;
            a(false);
            hl.a("Initiating WebView self destruct sequence in 3...");
            hl.a("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (Throwable e) {
                au.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
                kk.d("#007 Could not call remote method.", e);
            }
        }
        return;
    }

    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else {
            super.evaluateJavascript(str, valueCallback);
        }
    }

    protected void finalize() {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    a(true);
                }
                c();
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.b;
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public synchronized void loadUrl(String str) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadUrl(str);
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    public final synchronized void zzc(pb pbVar) {
        if (isDestroyed()) {
            hl.a("Blank page loaded, 1...");
            zzuk();
        } else {
            super.zzc(pbVar);
        }
    }

    public final synchronized void zzuk() {
        hl.a("Destroying WebView!");
        c();
        lf.a.execute(new pd(this));
    }
}
