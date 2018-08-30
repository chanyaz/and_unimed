package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.a.b;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class y extends Dialog implements AppCompatCallback {
    private AppCompatDelegate a;

    public y(Context context, int i) {
        super(context, a(context, i));
        b().a(null);
        b().j();
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean a(int i) {
        return b().c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        b().b(view, layoutParams);
    }

    public AppCompatDelegate b() {
        if (this.a == null) {
            this.a = AppCompatDelegate.a((Dialog) this, (AppCompatCallback) this);
        }
        return this.a;
    }

    @Nullable
    public <T extends View> T findViewById(@IdRes int i) {
        return b().a(i);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void invalidateOptionsMenu() {
        b().f();
    }

    protected void onCreate(Bundle bundle) {
        b().i();
        super.onCreate(bundle);
        b().a(bundle);
    }

    protected void onStop() {
        super.onStop();
        b().d();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Nullable
    public ActionMode onWindowStartingSupportActionMode(Callback callback) {
        return null;
    }

    public void setContentView(@LayoutRes int i) {
        b().b(i);
    }

    public void setContentView(View view) {
        b().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        b().a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        b().a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().a(charSequence);
    }
}
