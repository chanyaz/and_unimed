package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.d;
import android.support.v7.a.e;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

@RestrictTo({Scope.LIBRARY_GROUP})
public class u implements MenuHelper {
    private final Context a;
    private final MenuBuilder b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private Callback i;
    private t j;
    private OnDismissListener k;
    private final OnDismissListener l;

    public u(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public u(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i, @StyleRes int i2) {
        this.g = 8388611;
        this.l = new OnDismissListener() {
            public void onDismiss() {
                u.this.d();
            }
        };
        this.a = context;
        this.b = menuBuilder;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        t b = b();
        b.b(z2);
        if (z) {
            if ((d.a(this.g, ViewCompat.f(this.f)) & 7) == 5) {
                i += this.f.getWidth();
            }
            b.b(i);
            b.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.show();
    }

    @NonNull
    private t f() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        t cascadingMenuPopup = (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(e.abc_cascading_menus_min_smallest_width) ? 1 : null) != null ? new CascadingMenuPopup(this.a, this.f, this.d, this.e, this.c) : new x(this.a, this.b, this.f, this.d, this.e, this.c);
        cascadingMenuPopup.a(this.b);
        cascadingMenuPopup.a(this.l);
        cascadingMenuPopup.a(this.f);
        cascadingMenuPopup.setCallback(this.i);
        cascadingMenuPopup.a(this.h);
        cascadingMenuPopup.a(this.g);
        return cascadingMenuPopup;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(@NonNull View view) {
        this.f = view;
    }

    public void a(@Nullable OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.a(z);
        }
    }

    public boolean a(int i, int i2) {
        if (e()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    @NonNull
    public t b() {
        if (this.j == null) {
            this.j = f();
        }
        return this.j;
    }

    public boolean c() {
        if (e()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    protected void d() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public void dismiss() {
        if (e()) {
            this.j.dismiss();
        }
    }

    public boolean e() {
        return this.j != null && this.j.isShowing();
    }

    public void setPresenterCallback(@Nullable Callback callback) {
        this.i = callback;
        if (this.j != null) {
            this.j.setCallback(callback);
        }
    }
}
