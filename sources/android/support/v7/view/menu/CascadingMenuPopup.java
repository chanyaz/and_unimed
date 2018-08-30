package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.d;
import android.support.v7.a.e;
import android.support.v7.a.h;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.bl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends t implements MenuPresenter, OnKeyListener, OnDismissListener {
    final Handler a;
    final List<g> b = new ArrayList();
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final List<MenuBuilder> j = new ArrayList();
    private final OnGlobalLayoutListener k = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.b.size() > 0 && !((g) CascadingMenuPopup.this.b.get(0)).a.c()) {
                View view = CascadingMenuPopup.this.c;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (g gVar : CascadingMenuPopup.this.b) {
                    gVar.a.show();
                }
            }
        }
    };
    private final OnAttachStateChangeListener l = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (CascadingMenuPopup.this.y != null) {
                if (!CascadingMenuPopup.this.y.isAlive()) {
                    CascadingMenuPopup.this.y = view.getViewTreeObserver();
                }
                CascadingMenuPopup.this.y.removeGlobalOnLayoutListener(CascadingMenuPopup.this.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener m = new MenuItemHoverListener() {
        public void onItemHoverEnter(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
            int i;
            CascadingMenuPopup.this.a.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (menuBuilder == ((g) CascadingMenuPopup.this.b.get(i2)).b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i++;
                final g gVar = i < CascadingMenuPopup.this.b.size() ? (g) CascadingMenuPopup.this.b.get(i) : null;
                CascadingMenuPopup.this.a.postAtTime(new Runnable() {
                    public void run() {
                        if (gVar != null) {
                            CascadingMenuPopup.this.d = true;
                            gVar.b.b(false);
                            CascadingMenuPopup.this.d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.a(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.a.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private int n = 0;
    private int o = 0;
    private View p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private Callback x;
    private ViewTreeObserver y;
    private OnDismissListener z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i, @StyleRes int i2, boolean z) {
        this.e = context;
        this.p = view;
        this.g = i;
        this.h = i2;
        this.i = z;
        this.v = false;
        this.q = d();
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View a(@NonNull g gVar, @NonNull MenuBuilder menuBuilder) {
        int i = 0;
        MenuItem a = a(gVar.b, menuBuilder);
        if (a == null) {
            return null;
        }
        int headersCount;
        j jVar;
        int i2;
        ListView a2 = gVar.a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            jVar = (j) headerViewListAdapter.getWrappedAdapter();
        } else {
            jVar = (j) adapter;
            headersCount = 0;
        }
        int count = jVar.getCount();
        while (i < count) {
            if (a == jVar.getItem(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= a2.getChildCount()) ? null : a2.getChildAt(i2);
    }

    private bl c() {
        bl blVar = new bl(this.e, null, this.g, this.h);
        blVar.a(this.m);
        blVar.a((OnItemClickListener) this);
        blVar.a((OnDismissListener) this);
        blVar.b(this.p);
        blVar.e(this.o);
        blVar.a(true);
        blVar.h(2);
        return blVar;
    }

    private void c(@NonNull MenuBuilder menuBuilder) {
        View a;
        g gVar;
        LayoutInflater from = LayoutInflater.from(this.e);
        Object jVar = new j(menuBuilder, from, this.i);
        if (!isShowing() && this.v) {
            jVar.a(true);
        } else if (isShowing()) {
            jVar.a(t.b(menuBuilder));
        }
        int a2 = t.a(jVar, null, this.e, this.f);
        bl c = c();
        c.a((ListAdapter) jVar);
        c.g(a2);
        c.e(this.o);
        if (this.b.size() > 0) {
            g gVar2 = (g) this.b.get(this.b.size() - 1);
            a = a(gVar2, menuBuilder);
            gVar = gVar2;
        } else {
            a = null;
            Object gVar3 = null;
        }
        if (a != null) {
            int i;
            c.c(false);
            c.a(null);
            int d = d(a2);
            boolean z = d == 1;
            this.q = d;
            if (VERSION.SDK_INT >= 26) {
                c.b(a);
                d = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                d = iArr2[1] - iArr[1];
            }
            int width = (this.o & 5) == 5 ? z ? i + a2 : i - a.getWidth() : z ? a.getWidth() + i : i - a2;
            c.c(width);
            c.b(true);
            c.d(d);
        } else {
            if (this.r) {
                c.c(this.t);
            }
            if (this.s) {
                c.d(this.u);
            }
            c.a(b());
        }
        this.b.add(new g(c, menuBuilder, this.q));
        c.show();
        ViewGroup listView = c.getListView();
        listView.setOnKeyListener(this);
        if (gVar3 == null && this.w && menuBuilder.m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(h.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.m());
            listView.addHeaderView(frameLayout, null, false);
            c.show();
        }
    }

    private int d() {
        return ViewCompat.f(this.p) == 1 ? 0 : 1;
    }

    private int d(int i) {
        ListView a = ((g) this.b.get(this.b.size() - 1)).a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        if (this.q != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        } else {
            return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
    }

    private int d(@NonNull MenuBuilder menuBuilder) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == ((g) this.b.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = d.a(i, ViewCompat.f(this.p));
        }
    }

    public void a(MenuBuilder menuBuilder) {
        menuBuilder.a((MenuPresenter) this, this.e);
        if (isShowing()) {
            c(menuBuilder);
        } else {
            this.j.add(menuBuilder);
        }
    }

    public void a(@NonNull View view) {
        if (this.p != view) {
            this.p = view;
            this.o = d.a(this.n, ViewCompat.f(this.p));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void a(boolean z) {
        this.v = z;
    }

    protected boolean a() {
        return false;
    }

    public void b(int i) {
        this.r = true;
        this.t = i;
    }

    public void b(boolean z) {
        this.w = z;
    }

    public void c(int i) {
        this.s = true;
        this.u = i;
    }

    public void dismiss() {
        int size = this.b.size();
        if (size > 0) {
            g[] gVarArr = (g[]) this.b.toArray(new g[size]);
            for (size--; size >= 0; size--) {
                g gVar = gVarArr[size];
                if (gVar.a.isShowing()) {
                    gVar.a.dismiss();
                }
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.b.isEmpty() ? null : ((g) this.b.get(this.b.size() - 1)).a();
    }

    public boolean isShowing() {
        return this.b.size() > 0 && ((g) this.b.get(0)).a.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int d = d(menuBuilder);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.b.size()) {
                ((g) this.b.get(i)).b.b(false);
            }
            g gVar = (g) this.b.remove(d);
            gVar.b.b((MenuPresenter) this);
            if (this.d) {
                gVar.a.b(null);
                gVar.a.b(0);
            }
            gVar.a.dismiss();
            d = this.b.size();
            if (d > 0) {
                this.q = ((g) this.b.get(d - 1)).c;
            } else {
                this.q = d();
            }
            if (d == 0) {
                dismiss();
                if (this.x != null) {
                    this.x.onCloseMenu(menuBuilder, true);
                }
                if (this.y != null) {
                    if (this.y.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.k);
                    }
                    this.y = null;
                }
                this.c.removeOnAttachStateChangeListener(this.l);
                this.z.onDismiss();
            } else if (z) {
                ((g) this.b.get(0)).b.b(false);
            }
        }
    }

    public void onDismiss() {
        g gVar;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            gVar = (g) this.b.get(i);
            if (!gVar.a.isShowing()) {
                break;
            }
        }
        gVar = null;
        if (gVar != null) {
            gVar.b.b(false);
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
        for (g gVar : this.b) {
            if (yVar == gVar.b) {
                gVar.a().requestFocus();
                return true;
            }
        }
        if (!yVar.hasVisibleItems()) {
            return false;
        }
        a((MenuBuilder) yVar);
        if (this.x != null) {
            this.x.onOpenSubMenu(yVar);
        }
        return true;
    }

    public void setCallback(Callback callback) {
        this.x = callback;
    }

    public void show() {
        if (!isShowing()) {
            for (MenuBuilder c : this.j) {
                c(c);
            }
            this.j.clear();
            this.c = this.p;
            if (this.c != null) {
                Object obj = this.y == null ? 1 : null;
                this.y = this.c.getViewTreeObserver();
                if (obj != null) {
                    this.y.addOnGlobalLayoutListener(this.k);
                }
                this.c.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    public void updateMenuView(boolean z) {
        for (g a : this.b) {
            t.a(a.a().getAdapter()).notifyDataSetChanged();
        }
    }
}
