package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.e;
import android.support.v7.a.h;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.bl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class x extends t implements MenuPresenter, OnKeyListener, OnItemClickListener, OnDismissListener {
    final bl a;
    View b;
    private final Context c;
    private final MenuBuilder d;
    private final j e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private final OnGlobalLayoutListener j = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (x.this.isShowing() && !x.this.a.c()) {
                View view = x.this.b;
                if (view == null || !view.isShown()) {
                    x.this.dismiss();
                } else {
                    x.this.a.show();
                }
            }
        }
    };
    private final OnAttachStateChangeListener k = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (x.this.o != null) {
                if (!x.this.o.isAlive()) {
                    x.this.o = view.getViewTreeObserver();
                }
                x.this.o.removeGlobalOnLayoutListener(x.this.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private OnDismissListener l;
    private View m;
    private Callback n;
    private ViewTreeObserver o;
    private boolean p;
    private boolean q;
    private int r;
    private int s = 0;
    private boolean t;

    public x(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = menuBuilder;
        this.f = z;
        this.e = new j(menuBuilder, LayoutInflater.from(context), this.f);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        this.m = view;
        this.a = new bl(this.c, null, this.h, this.i);
        menuBuilder.a((MenuPresenter) this, context);
    }

    private boolean c() {
        if (isShowing()) {
            return true;
        }
        if (this.p || this.m == null) {
            return false;
        }
        this.b = this.m;
        this.a.a((OnDismissListener) this);
        this.a.a((OnItemClickListener) this);
        this.a.a(true);
        View view = this.b;
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this.j);
        }
        view.addOnAttachStateChangeListener(this.k);
        this.a.b(view);
        this.a.e(this.s);
        if (!this.q) {
            this.r = t.a(this.e, null, this.c, this.g);
            this.q = true;
        }
        this.a.g(this.r);
        this.a.h(2);
        this.a.a(b());
        this.a.show();
        ViewGroup listView = this.a.getListView();
        listView.setOnKeyListener(this);
        if (this.t && this.d.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(h.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.m());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.a.a(this.e);
        this.a.show();
        return true;
    }

    public void a(int i) {
        this.s = i;
    }

    public void a(MenuBuilder menuBuilder) {
    }

    public void a(View view) {
        this.m = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public void b(int i) {
        this.a.c(i);
    }

    public void b(boolean z) {
        this.t = z;
    }

    public void c(int i) {
        this.a.d(i);
    }

    public void dismiss() {
        if (isShowing()) {
            this.a.dismiss();
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.a.getListView();
    }

    public boolean isShowing() {
        return !this.p && this.a.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.d) {
            dismiss();
            if (this.n != null) {
                this.n.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.p = true;
        this.d.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.j);
            this.o = null;
        }
        this.b.removeOnAttachStateChangeListener(this.k);
        if (this.l != null) {
            this.l.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(y yVar) {
        if (yVar.hasVisibleItems()) {
            u uVar = new u(this.c, yVar, this.b, this.f, this.h, this.i);
            uVar.setPresenterCallback(this.n);
            uVar.a(t.b((MenuBuilder) yVar));
            uVar.a(this.s);
            uVar.a(this.l);
            this.l = null;
            this.d.b(false);
            if (uVar.a(this.a.f(), this.a.g())) {
                if (this.n != null) {
                    this.n.onOpenSubMenu(yVar);
                }
                return true;
            }
        }
        return false;
    }

    public void setCallback(Callback callback) {
        this.n = callback;
    }

    public void show() {
        if (!c()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z) {
        this.q = false;
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }
}
