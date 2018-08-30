package android.support.design.internal;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.l;
import android.support.v7.widget.bo;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

class d extends bo<k> {
    final /* synthetic */ NavigationMenuPresenter a;
    private final ArrayList<NavigationMenuItem> b = new ArrayList();
    private l c;
    private boolean d;

    d(NavigationMenuPresenter navigationMenuPresenter) {
        this.a = navigationMenuPresenter;
        c();
    }

    private void a(int i, int i2) {
        while (i < i2) {
            ((g) this.b.get(i)).a = true;
            i++;
        }
    }

    private void c() {
        if (!this.d) {
            this.d = true;
            this.b.clear();
            this.b.add(new e());
            int i = -1;
            int i2 = 0;
            boolean z = false;
            int size = this.a.b.i().size();
            int i3 = 0;
            while (i3 < size) {
                int i4;
                l lVar = (l) this.a.b.i().get(i3);
                if (lVar.isChecked()) {
                    a(lVar);
                }
                if (lVar.isCheckable()) {
                    lVar.a(false);
                }
                int i5;
                if (lVar.hasSubMenu()) {
                    SubMenu subMenu = lVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.b.add(new f(this.a.j, 0));
                        }
                        this.b.add(new g(lVar));
                        Object obj = null;
                        int size2 = this.b.size();
                        int size3 = subMenu.size();
                        for (i5 = 0; i5 < size3; i5++) {
                            l lVar2 = (l) subMenu.getItem(i5);
                            if (lVar2.isVisible()) {
                                if (obj == null && lVar2.getIcon() != null) {
                                    obj = 1;
                                }
                                if (lVar2.isCheckable()) {
                                    lVar2.a(false);
                                }
                                if (lVar.isChecked()) {
                                    a(lVar);
                                }
                                this.b.add(new g(lVar2));
                            }
                        }
                        if (obj != null) {
                            a(size2, this.b.size());
                        }
                    }
                    i4 = i;
                } else {
                    int size4;
                    boolean z2;
                    i5 = lVar.getGroupId();
                    if (i5 != i) {
                        size4 = this.b.size();
                        z2 = lVar.getIcon() != null;
                        if (i3 != 0) {
                            size4++;
                            this.b.add(new f(this.a.j, this.a.j));
                        }
                    } else if (z || lVar.getIcon() == null) {
                        z2 = z;
                        size4 = i2;
                    } else {
                        z2 = true;
                        a(i2, this.b.size());
                        size4 = i2;
                    }
                    g gVar = new g(lVar);
                    gVar.a = z2;
                    this.b.add(gVar);
                    z = z2;
                    i2 = size4;
                    i4 = i5;
                }
                i3++;
                i = i4;
            }
            this.d = false;
        }
    }

    /* renamed from: a */
    public k onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new h(this.a.d, viewGroup, this.a.k);
            case 1:
                return new j(this.a.d, viewGroup);
            case 2:
                return new i(this.a.d, viewGroup);
            case 3:
                return new c(this.a.a);
            default:
                return null;
        }
    }

    public void a() {
        c();
        notifyDataSetChanged();
    }

    public void a(Bundle bundle) {
        NavigationMenuItem navigationMenuItem;
        l a;
        int i = 0;
        int i2 = bundle.getInt("android:menu:checked", 0);
        if (i2 != 0) {
            this.d = true;
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                navigationMenuItem = (NavigationMenuItem) this.b.get(i3);
                if (navigationMenuItem instanceof g) {
                    a = ((g) navigationMenuItem).a();
                    if (a != null && a.getItemId() == i2) {
                        a(a);
                        break;
                    }
                }
            }
            this.d = false;
            c();
        }
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
        if (sparseParcelableArray != null) {
            i2 = this.b.size();
            while (i < i2) {
                navigationMenuItem = (NavigationMenuItem) this.b.get(i);
                if (navigationMenuItem instanceof g) {
                    a = ((g) navigationMenuItem).a();
                    if (a != null) {
                        View actionView = a.getActionView();
                        if (actionView != null) {
                            ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a.getItemId());
                            if (parcelableSparseArray != null) {
                                actionView.restoreHierarchyState(parcelableSparseArray);
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    public void onViewRecycled(k kVar) {
        if (kVar instanceof h) {
            ((NavigationMenuItemView) kVar.itemView).a();
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(k kVar, int i) {
        switch (getItemViewType(i)) {
            case 0:
                View view = (NavigationMenuItemView) kVar.itemView;
                view.setIconTintList(this.a.h);
                if (this.a.f) {
                    view.setTextAppearance(this.a.e);
                }
                if (this.a.g != null) {
                    view.setTextColor(this.a.g);
                }
                ViewCompat.a(view, this.a.i != null ? this.a.i.getConstantState().newDrawable() : null);
                g gVar = (g) this.b.get(i);
                view.setNeedsEmptyIcon(gVar.a);
                view.initialize(gVar.a(), 0);
                return;
            case 1:
                ((TextView) kVar.itemView).setText(((g) this.b.get(i)).a().getTitle());
                return;
            case 2:
                f fVar = (f) this.b.get(i);
                kVar.itemView.setPadding(0, fVar.a(), 0, fVar.b());
                return;
            default:
                return;
        }
    }

    public void a(l lVar) {
        if (this.c != lVar && lVar.isCheckable()) {
            if (this.c != null) {
                this.c.setChecked(false);
            }
            this.c = lVar;
            lVar.setChecked(true);
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        if (this.c != null) {
            bundle.putInt("android:menu:checked", this.c.getItemId());
        }
        SparseArray sparseArray = new SparseArray();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.b.get(i);
            if (navigationMenuItem instanceof g) {
                l a = ((g) navigationMenuItem).a();
                View actionView = a != null ? a.getActionView() : null;
                if (actionView != null) {
                    SparseArray parcelableSparseArray = new ParcelableSparseArray();
                    actionView.saveHierarchyState(parcelableSparseArray);
                    sparseArray.put(a.getItemId(), parcelableSparseArray);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
        return bundle;
    }

    public int getItemCount() {
        return this.b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.b.get(i);
        if (navigationMenuItem instanceof f) {
            return 2;
        }
        if (navigationMenuItem instanceof e) {
            return 3;
        }
        if (navigationMenuItem instanceof g) {
            return ((g) navigationMenuItem).a().hasSubMenu() ? 1 : 0;
        } else {
            throw new RuntimeException("Unknown item type.");
        }
    }
}
