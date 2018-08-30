package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

@RestrictTo({Scope.LIBRARY_GROUP})
public class c extends ActionMode implements Callback {
    private Context a;
    private ActionBarContextView b;
    private ActionMode.Callback c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private MenuBuilder g;

    public c(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = callback;
        this.g = new MenuBuilder(actionBarContextView.getContext()).a(1);
        this.g.a((Callback) this);
        this.f = z;
    }

    public MenuInflater a() {
        return new f(this.b.getContext());
    }

    public void a(int i) {
        b(this.a.getString(i));
    }

    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference(view) : null;
    }

    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    public Menu b() {
        return this.g;
    }

    public void b(int i) {
        a(this.a.getString(i));
    }

    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    public void c() {
        if (!this.e) {
            this.e = true;
            this.b.sendAccessibilityEvent(32);
            this.c.onDestroyActionMode(this);
        }
    }

    public void d() {
        this.c.onPrepareActionMode(this, this.g);
    }

    public CharSequence f() {
        return this.b.getTitle();
    }

    public CharSequence g() {
        return this.b.getSubtitle();
    }

    public boolean h() {
        return this.b.d();
    }

    public View i() {
        return this.d != null ? (View) this.d.get() : null;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.c.onActionItemClicked(this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        d();
        this.b.a();
    }
}
