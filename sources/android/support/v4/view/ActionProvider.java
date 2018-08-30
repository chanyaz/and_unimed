package android.support.v4.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
    private final Context a;
    private SubUiVisibilityListener b;
    private VisibilityListener c;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
        this.a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(SubUiVisibilityListener subUiVisibilityListener) {
        this.b = subUiVisibilityListener;
    }

    public void a(VisibilityListener visibilityListener) {
        if (!(this.c == null || visibilityListener == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = visibilityListener;
    }

    public void a(SubMenu subMenu) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(boolean z) {
        if (this.b != null) {
            this.b.onSubUiVisibilityChanged(z);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void f() {
        this.c = null;
        this.b = null;
    }
}
