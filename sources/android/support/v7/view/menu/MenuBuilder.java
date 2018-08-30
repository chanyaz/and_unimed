package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.a;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v7.a.c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class MenuBuilder implements SupportMenu {
    private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private Callback i;
    private ArrayList<l> j;
    private ArrayList<l> k;
    private boolean l;
    private ArrayList<l> m;
    private ArrayList<l> n;
    private boolean o;
    private int p = 0;
    private ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<l> w = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> x = new CopyOnWriteArrayList();
    private l y;
    private boolean z;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface ItemInvoker {
        boolean invokeItem(l lVar);
    }

    public MenuBuilder(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        e(true);
    }

    private static int a(ArrayList<l> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((l) arrayList.get(size)).b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private l a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new l(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = d.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = a.a(e(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        a(false);
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                a(true);
            }
        }
    }

    private boolean a(y yVar, MenuPresenter menuPresenter) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z = menuPresenter.onSubMenuSelected(yVar);
        }
        Iterator it = this.x.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null) {
                this.x.remove(weakReference);
            } else if (!z2) {
                z2 = menuPresenter2.onSubMenuSelected(yVar);
            }
            z = z2;
        }
    }

    private void d(boolean z) {
        if (!this.x.isEmpty()) {
            g();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    menuPresenter.updateMenuView(z);
                }
            }
            h();
        }
    }

    private void e(Bundle bundle) {
        if (!this.x.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = menuPresenter.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(c.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.h = z2;
    }

    private static int f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < d.length) {
            return (d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void f(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.x.isEmpty()) {
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            menuPresenter.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((l) this.j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public MenuBuilder a(int i) {
        this.p = i;
        return this;
    }

    protected MenuBuilder a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    protected MenuBuilder a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    l a(int i, KeyEvent keyEvent) {
        List list = this.w;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (l) list.get(0);
        }
        boolean b = b();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            char alphabeticShortcut = b ? lVar.getAlphabeticShortcut() : lVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return lVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return lVar;
            }
            if (b && alphabeticShortcut == 8 && i == 67) {
                return lVar;
            }
        }
        return null;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int f = f(i3);
        MenuItem a = a(i, i2, i3, f, charSequence, this.p);
        if (this.q != null) {
            a.a(this.q);
        }
        this.j.add(a(this.j, f), a);
        a(true);
        return a;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        e(bundle);
    }

    public void a(Callback callback) {
        this.i = callback;
    }

    public void a(MenuPresenter menuPresenter) {
        a(menuPresenter, this.e);
    }

    public void a(MenuPresenter menuPresenter, Context context) {
        this.x.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.o = true;
    }

    void a(l lVar) {
        this.l = true;
        a(true);
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        g();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (l) this.j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.f() && menuItem2.isCheckable()) {
                menuItem2.b(menuItem2 == menuItem);
            }
        }
        h();
    }

    void a(List<l> list, int i, KeyEvent keyEvent) {
        boolean b = b();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar = (l) this.j.get(i2);
                if (lVar.hasSubMenu()) {
                    ((MenuBuilder) lVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? lVar.getAlphabeticShortcut() : lVar.getNumericShortcut();
                if (!(((modifiers & 69647) == ((b ? lVar.getAlphabeticModifiers() : lVar.getNumericModifiers()) & 69647) ? 1 : 0) == 0 || alphabeticShortcut == 0 || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!b || alphabeticShortcut != 8 || i != 67)) || !lVar.isEnabled()))) {
                    list.add(lVar);
                }
            }
        }
    }

    public void a(boolean z) {
        if (this.r) {
            this.s = true;
            if (z) {
                this.t = true;
                return;
            }
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        d(z);
    }

    boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.i != null && this.i.onMenuItemSelected(menuBuilder, menuItem);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, null, i);
    }

    public boolean a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        l lVar = (l) menuItem;
        if (lVar == null || !lVar.isEnabled()) {
            return false;
        }
        boolean a = lVar.a();
        ActionProvider supportActionProvider = lVar.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.e();
        boolean expandActionView;
        if (lVar.m()) {
            expandActionView = lVar.expandActionView() | a;
            if (!expandActionView) {
                return expandActionView;
            }
            b(true);
            return expandActionView;
        } else if (lVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                b(false);
            }
            if (!lVar.hasSubMenu()) {
                lVar.a(new y(e(), this, lVar));
            }
            y yVar = (y) lVar.getSubMenu();
            if (z) {
                supportActionProvider.a((SubMenu) yVar);
            }
            expandActionView = a(yVar, menuPresenter) | a;
            if (expandActionView) {
                return expandActionView;
            }
            b(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                b(true);
            }
            return a;
        }
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        l lVar = (l) a(i, i2, i3, charSequence);
        y yVar = new y(this.e, this, lVar);
        lVar.a(yVar);
        return yVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((l) this.j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        f(bundle);
    }

    public void b(MenuPresenter menuPresenter) {
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.x.remove(weakReference);
            }
        }
    }

    void b(l lVar) {
        this.o = true;
        a(true);
    }

    public final void b(boolean z) {
        if (!this.v) {
            this.v = true;
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.v = false;
        }
    }

    boolean b() {
        return this.g;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public void c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((y) item.getSubMenu()).c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(l lVar) {
        boolean z = false;
        if (!this.x.isEmpty()) {
            g();
            Iterator it = this.x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.expandItemActionView(this, lVar);
                    if (z) {
                        break;
                    }
                }
            }
            h();
            if (z) {
                this.y = lVar;
            }
        }
        return z;
    }

    public void clear() {
        if (this.y != null) {
            d(this.y);
        }
        this.j.clear();
        a(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        a(false);
    }

    public void close() {
        b(true);
    }

    Resources d() {
        return this.f;
    }

    protected MenuBuilder d(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((y) item.getSubMenu()).d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    item.expandActionView();
                }
            }
        }
    }

    public boolean d(l lVar) {
        boolean z = false;
        if (!this.x.isEmpty() && this.y == lVar) {
            g();
            Iterator it = this.x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.collapseItemActionView(this, lVar);
                    if (z) {
                        break;
                    }
                }
            }
            h();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }

    public Context e() {
        return this.e;
    }

    protected MenuBuilder e(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public void f() {
        if (this.i != null) {
            this.i.onMenuModeChange(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) this.j.get(i2);
            if (lVar.getItemId() == i) {
                return lVar;
            }
            if (lVar.hasSubMenu()) {
                MenuItem findItem = lVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void g() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.j.get(i);
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            a(this.t);
        }
    }

    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((l) this.j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public ArrayList<l> i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            l lVar = (l) this.j.get(i);
            if (lVar.isVisible()) {
                this.k.add(lVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void j() {
        ArrayList i = i();
        if (this.o) {
            Iterator it = this.x.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = menuPresenter.flagActionItems() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.m.clear();
                this.n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    l lVar = (l) i.get(i4);
                    if (lVar.i()) {
                        this.m.add(lVar);
                    } else {
                        this.n.add(lVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList<l> k() {
        j();
        return this.m;
    }

    public ArrayList<l> l() {
        j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public MenuBuilder p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, i2);
        }
        if ((i2 & 2) != 0) {
            b(true);
        }
        return z;
    }

    boolean q() {
        return this.u;
    }

    public l r() {
        return this.y;
    }

    public void removeGroup(int i) {
        int c = c(i);
        if (c >= 0) {
            int size = this.j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((l) this.j.get(c)).getGroupId() != i) {
                    a(true);
                } else {
                    a(c, false);
                    i2 = i3;
                }
            }
            a(true);
        }
    }

    public void removeItem(int i) {
        a(b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) this.j.get(i2);
            if (lVar.getGroupId() == i) {
                lVar.a(z2);
                lVar.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) this.j.get(i2);
            if (lVar.getGroupId() == i) {
                lVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            l lVar = (l) this.j.get(i2);
            boolean z3 = (lVar.getGroupId() == i && lVar.c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            a(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.g = z;
        a(false);
    }

    public int size() {
        return this.j.size();
    }
}
