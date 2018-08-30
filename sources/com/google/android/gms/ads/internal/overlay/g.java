package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.im;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@VisibleForTesting
final class g extends RelativeLayout {
    @VisibleForTesting
    boolean a;
    @VisibleForTesting
    private im b;

    public g(Context context, String str, String str2) {
        super(context);
        this.b = new im(context, str);
        this.b.b(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            this.b.a(motionEvent);
        }
        return false;
    }
}
