package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.a.h;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.y;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends d implements SubUiVisibilityListener {
    private f A;
    h g;
    i h;
    e i;
    g j;
    final j k = new j(this);
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private View z;

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, h.abc_action_menu_layout, h.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ItemView) && ((ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public View a(l lVar, View view, ViewGroup viewGroup) {
        View actionView = lVar.getActionView();
        if (actionView == null || lVar.m()) {
            actionView = super.a(lVar, view, viewGroup);
        }
        actionView.setVisibility(lVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.a(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public void a(l lVar, ItemView itemView) {
        itemView.initialize(lVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new f(this);
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.initialize(this.c);
    }

    public void a(boolean z) {
        this.o = z;
        this.p = true;
    }

    public boolean a(int i, l lVar) {
        return lVar.i();
    }

    public boolean a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.g ? false : super.a(viewGroup, i);
    }

    public Drawable b() {
        return this.g != null ? this.g.getDrawable() : this.n ? this.m : null;
    }

    public void b(boolean z) {
        this.w = z;
    }

    public boolean c() {
        if (!this.o || g() || this.c == null || this.f == null || this.j != null || this.c.l().isEmpty()) {
            return false;
        }
        this.j = new g(this, new i(this, this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.onSubMenuSelected(null);
        return true;
    }

    public boolean d() {
        if (this.j == null || this.f == null) {
            u uVar = this.h;
            if (uVar == null) {
                return false;
            }
            uVar.dismiss();
            return true;
        }
        ((View) this.f).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean e() {
        return d() | f();
    }

    public boolean f() {
        if (this.i == null) {
            return false;
        }
        this.i.dismiss();
        return true;
    }

    public boolean flagActionItems() {
        int size;
        ArrayList arrayList;
        l lVar;
        int i;
        if (this.c != null) {
            ArrayList i2 = this.c.i();
            size = i2.size();
            arrayList = i2;
        } else {
            size = 0;
            arrayList = null;
        }
        int i3 = this.s;
        int i4 = this.r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            lVar = (l) arrayList.get(i7);
            if (lVar.k()) {
                i5++;
            } else if (lVar.j()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.w && lVar.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.o && (obj != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.y;
        sparseBooleanArray.clear();
        i = 0;
        if (this.u) {
            i = i4 / this.x;
            i6 = ((i4 % this.x) / i) + this.x;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            lVar = (l) arrayList.get(i8);
            int i10;
            if (lVar.k()) {
                View a = a(lVar, this.z, viewGroup);
                if (this.z == null) {
                    this.z = a;
                }
                if (this.u) {
                    i9 -= ActionMenuView.a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = lVar.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                lVar.d(true);
                i = i10;
                i3 = i7;
            } else if (lVar.j()) {
                boolean z;
                int groupId = lVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.u || i9 > 0);
                if (z3) {
                    View a2 = a(lVar, this.z, viewGroup);
                    if (this.z == null) {
                        this.z = a2;
                    }
                    boolean z4;
                    if (this.u) {
                        int a3 = ActionMenuView.a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.u) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        l lVar2 = (l) arrayList.get(i7);
                        if (lVar2.getGroupId() == groupId) {
                            if (lVar2.i()) {
                                i5++;
                            }
                            lVar2.d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                lVar.d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                lVar.d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public boolean g() {
        return this.h != null && this.h.e();
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.f;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public boolean h() {
        return this.j != null || g();
    }

    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        a a = a.a(context);
        if (!this.p) {
            this.o = a.b();
        }
        if (!this.v) {
            this.q = a.c();
        }
        if (!this.t) {
            this.s = a.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new h(this, this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (56.0f * resources.getDisplayMetrics().density);
        this.z = null;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        e();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.a > 0) {
                MenuItem findItem = this.c.findItem(savedState.a);
                if (findItem != null) {
                    onSubMenuSelected((y) findItem.getSubMenu());
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.a = this.l;
        return savedState;
    }

    public boolean onSubMenuSelected(y yVar) {
        if (!yVar.hasVisibleItems()) {
            return false;
        }
        y yVar2 = yVar;
        while (yVar2.s() != this.c) {
            yVar2 = (y) yVar2.s();
        }
        View a = a(yVar2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.l = yVar.getItem().getItemId();
        int size = yVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = yVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.i = new e(this, this.b, yVar, a);
        this.i.a(z);
        this.i.a();
        super.onSubMenuSelected(yVar);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.c != null) {
            this.c.b(false);
        }
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.updateMenuView(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                ActionProvider supportActionProvider = ((l) k.get(i)).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.a((SubUiVisibilityListener) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.l() : null;
        if (this.o && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((l) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.g == null) {
                this.g = new h(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }
}
