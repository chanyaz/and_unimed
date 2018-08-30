package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@TargetApi(19)
public final class ah extends ae {
    private Object d = new Object();
    @GuardedBy("mPopupWindowLock")
    private PopupWindow e;
    @GuardedBy("mPopupWindowLock")
    private boolean f = false;

    ah(Context context, gs gsVar, zzaqw zzaqw, zzabm zzabm) {
        super(context, gsVar, zzaqw, zzabm);
    }

    private final void c() {
        synchronized (this.d) {
            this.f = true;
            if ((this.a instanceof Activity) && ((Activity) this.a).isDestroyed()) {
                this.e = null;
            }
            if (this.e != null) {
                if (this.e.isShowing()) {
                    this.e.dismiss();
                }
                this.e = null;
            }
        }
    }

    protected final void a(int i) {
        c();
        super.a(i);
    }

    protected final void b() {
        Window window = this.a instanceof Activity ? ((Activity) this.a).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.a).isDestroyed()) {
            View frameLayout = new FrameLayout(this.a);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.b.getView(), -1, -1);
            synchronized (this.d) {
                if (this.f) {
                    return;
                }
                this.e = new PopupWindow(frameLayout, 1, 1, false);
                this.e.setOutsideTouchable(true);
                this.e.setClippingEnabled(false);
                kk.b("Displaying the 1x1 popup off the screen.");
                try {
                    this.e.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.e = null;
                }
            }
        }
    }

    public final void cancel() {
        c();
        super.cancel();
    }
}
