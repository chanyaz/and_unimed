package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ar;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

class v implements Callback {
    final /* synthetic */ AppCompatDelegateImplV9 a;
    private Callback b;

    public v(AppCompatDelegateImplV9 appCompatDelegateImplV9, Callback callback) {
        this.a = appCompatDelegateImplV9;
        this.b = callback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.b.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.b.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.b.onDestroyActionMode(actionMode);
        if (this.a.o != null) {
            this.a.b.getDecorView().removeCallbacks(this.a.p);
        }
        if (this.a.n != null) {
            this.a.u();
            this.a.q = ViewCompat.l(this.a.n).a(0.0f);
            this.a.q.a(new ar() {
                public void onAnimationEnd(View view) {
                    v.this.a.n.setVisibility(8);
                    if (v.this.a.o != null) {
                        v.this.a.o.dismiss();
                    } else if (v.this.a.n.getParent() instanceof View) {
                        ViewCompat.q((View) v.this.a.n.getParent());
                    }
                    v.this.a.n.removeAllViews();
                    v.this.a.q.a(null);
                    v.this.a.q = null;
                }
            });
        }
        if (this.a.e != null) {
            this.a.e.onSupportActionModeFinished(this.a.m);
        }
        this.a.m = null;
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.b.onPrepareActionMode(actionMode, menu);
    }
}
