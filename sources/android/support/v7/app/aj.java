package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.ActionMode;
import android.support.v7.view.f;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

@RestrictTo({Scope.LIBRARY_GROUP})
public class aj extends ActionMode implements Callback {
    final /* synthetic */ ai a;
    private final Context b;
    private final MenuBuilder c;
    private ActionMode.Callback d;
    private WeakReference<View> e;

    public aj(ai aiVar, Context context, ActionMode.Callback callback) {
        this.a = aiVar;
        this.b = context;
        this.d = callback;
        this.c = new MenuBuilder(context).a(1);
        this.c.a((Callback) this);
    }

    public MenuInflater a() {
        return new f(this.b);
    }

    public void a(int i) {
        b(this.a.a.getResources().getString(i));
    }

    public void a(View view) {
        this.a.e.setCustomView(view);
        this.e = new WeakReference(view);
    }

    public void a(CharSequence charSequence) {
        this.a.e.setSubtitle(charSequence);
    }

    public void a(boolean z) {
        super.a(z);
        this.a.e.setTitleOptional(z);
    }

    public Menu b() {
        return this.c;
    }

    public void b(int i) {
        a(this.a.a.getResources().getString(i));
    }

    public void b(CharSequence charSequence) {
        this.a.e.setTitle(charSequence);
    }

    public void c() {
        if (this.a.h == this) {
            if (ai.a(this.a.l, this.a.m, false)) {
                this.d.onDestroyActionMode(this);
            } else {
                this.a.i = this;
                this.a.j = this.d;
            }
            this.d = null;
            this.a.i(false);
            this.a.e.b();
            this.a.d.getViewGroup().sendAccessibilityEvent(32);
            this.a.b.setHideOnContentScrollEnabled(this.a.o);
            this.a.h = null;
        }
    }

    public void d() {
        if (this.a.h == this) {
            this.c.g();
            try {
                this.d.onPrepareActionMode(this, this.c);
            } finally {
                this.c.h();
            }
        }
    }

    public boolean e() {
        this.c.g();
        try {
            boolean onCreateActionMode = this.d.onCreateActionMode(this, this.c);
            return onCreateActionMode;
        } finally {
            this.c.h();
        }
    }

    public CharSequence f() {
        return this.a.e.getTitle();
    }

    public CharSequence g() {
        return this.a.e.getSubtitle();
    }

    public boolean h() {
        return this.a.e.d();
    }

    public View i() {
        return this.e != null ? (View) this.e.get() : null;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.d != null ? this.d.onActionItemClicked(this, menuItem) : false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.d != null) {
            d();
            this.a.e.a();
        }
    }
}
