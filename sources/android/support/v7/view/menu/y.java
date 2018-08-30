package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@RestrictTo({Scope.LIBRARY_GROUP})
public class y extends MenuBuilder implements SubMenu {
    private MenuBuilder d;
    private l e;

    public y(Context context, MenuBuilder menuBuilder, l lVar) {
        super(context);
        this.d = menuBuilder;
        this.e = lVar;
    }

    public String a() {
        int itemId = this.e != null ? this.e.getItemId() : 0;
        return itemId == 0 ? null : super.a() + ":" + itemId;
    }

    public void a(Callback callback) {
        this.d.a(callback);
    }

    boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.a(menuBuilder, menuItem) || this.d.a(menuBuilder, menuItem);
    }

    public boolean b() {
        return this.d.b();
    }

    public boolean c() {
        return this.d.c();
    }

    public boolean c(l lVar) {
        return this.d.c(lVar);
    }

    public boolean d(l lVar) {
        return this.d.d(lVar);
    }

    public MenuItem getItem() {
        return this.e;
    }

    public MenuBuilder p() {
        return this.d.p();
    }

    public Menu s() {
        return this.d;
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.e(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }
}
