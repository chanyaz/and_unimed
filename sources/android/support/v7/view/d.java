package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.view.menu.v;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@RestrictTo({Scope.LIBRARY_GROUP})
public class d extends ActionMode {
    final Context a;
    final ActionMode b;

    public d(Context context, ActionMode actionMode) {
        this.a = context;
        this.b = actionMode;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.i();
    }

    public Menu getMenu() {
        return v.a(this.a, (SupportMenu) this.b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.j();
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    public void invalidate() {
        this.b.d();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View view) {
        this.b.a(view);
    }

    public void setSubtitle(int i) {
        this.b.b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.b.a(obj);
    }

    public void setTitle(int i) {
        this.b.a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }
}
