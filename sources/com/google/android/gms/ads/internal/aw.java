package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.im;
import com.google.android.gms.internal.ads.ka;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.ArrayList;
import java.util.List;

public final class aw extends ViewSwitcher {
    private final im a;
    @Nullable
    private final ka b;
    private boolean c = true;

    public aw(Context context, String str, String str2, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.a = new im(context);
        this.a.a(str);
        this.a.b(str2);
        if (context instanceof Activity) {
            this.b = new ka((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.b = new ka(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.b.a();
    }

    public final im a() {
        return this.a;
    }

    public final void b() {
        hl.a("Disable position monitoring on adFrame.");
        if (this.b != null) {
            this.b.b();
        }
    }

    public final void c() {
        hl.a("Enable debug gesture detector on adFrame.");
        this.c = true;
    }

    public final void d() {
        hl.a("Disable debug gesture detector on adFrame.");
        this.c = false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            this.b.c();
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.d();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.c) {
            this.a.a(motionEvent);
        }
        return false;
    }

    public final void removeAllViews() {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof zzaqw)) {
                arrayList.add((zzaqw) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = (ArrayList) arrayList;
        i = arrayList2.size();
        while (i2 < i) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((zzaqw) obj).destroy();
        }
    }
}
