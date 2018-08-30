package android.support.v7.widget;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

@RestrictTo({Scope.LIBRARY_GROUP})
class df implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static df i;
    private static df j;
    private final View a;
    private final CharSequence b;
    private final Runnable c = new Runnable() {
        public void run() {
            df.this.a(false);
        }
    };
    private final Runnable d = new Runnable() {
        public void run() {
            df.this.a();
        }
    };
    private int e;
    private int f;
    private dg g;
    private boolean h;

    private df(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    private void a() {
        if (j == this) {
            j = null;
            if (this.g != null) {
                this.g.a();
                this.g = null;
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (i == this) {
            b(null);
        }
        this.a.removeCallbacks(this.d);
    }

    public static void a(View view, CharSequence charSequence) {
        if (i != null && i.a == view) {
            b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (j != null && j.a == view) {
                j.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        df dfVar = new df(view, charSequence);
    }

    private void a(boolean z) {
        if (ViewCompat.B(this.a)) {
            b(null);
            if (j != null) {
                j.a();
            }
            j = this;
            this.h = z;
            this.g = new dg(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(this);
            long longPressTimeout = this.h ? 2500 : (ViewCompat.p(this.a) & 1) == 1 ? 3000 - ((long) ViewConfiguration.getLongPressTimeout()) : 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, longPressTimeout);
        }
    }

    private void b() {
        this.a.postDelayed(this.c, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void b(df dfVar) {
        if (i != null) {
            i.c();
        }
        i = dfVar;
        if (i != null) {
            i.b();
        }
    }

    private void c() {
        this.a.removeCallbacks(this.c);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.g == null || !this.h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
            if (!(accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.a.isEnabled() && this.g == null) {
                            this.e = (int) motionEvent.getX();
                            this.f = (int) motionEvent.getY();
                            b(this);
                            break;
                        }
                    case 10:
                        a();
                        break;
                }
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.e = view.getWidth() / 2;
        this.f = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
