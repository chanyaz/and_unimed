package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.app.ak;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.app.ActionBarDrawerToggle.DelegateProvider;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.dh;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class AppCompatActivity extends FragmentActivity implements SupportParentable, DelegateProvider, AppCompatCallback {
    private AppCompatDelegate n;
    private int o = 0;
    private Resources p;

    private boolean a(int i, KeyEvent keyEvent) {
        if (!(VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()))) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public void a(@NonNull TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.a((Activity) this);
    }

    public void a(@Nullable Toolbar toolbar) {
        i().a(toolbar);
    }

    public boolean a(@NonNull Intent intent) {
        return ak.a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        i().b(view, layoutParams);
    }

    public void b(@NonNull Intent intent) {
        ak.b((Activity) this, intent);
    }

    public void b(@NonNull TaskStackBuilder taskStackBuilder) {
    }

    public boolean b(int i) {
        return i().c(i);
    }

    public void c() {
        i().f();
    }

    public void closeOptionsMenu() {
        ActionBar f = f();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (f == null || !f.g()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar f = f();
        return (keyCode == 82 && f != null && f.a(keyEvent)) ? true : super.dispatchKeyEvent(keyEvent);
    }

    @Nullable
    public ActionBar f() {
        return i().a();
    }

    public <T extends View> T findViewById(@IdRes int i) {
        return i().a(i);
    }

    public boolean g() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (a(supportParentActivityIntent)) {
            TaskStackBuilder a = TaskStackBuilder.a((Context) this);
            a(a);
            b(a);
            a.a();
            try {
                ActivityCompat.a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            b(supportParentActivityIntent);
        }
        return true;
    }

    @Nullable
    public Delegate getDrawerToggleDelegate() {
        return i().h();
    }

    public MenuInflater getMenuInflater() {
        return i().b();
    }

    public Resources getResources() {
        if (this.p == null && dh.a()) {
            this.p = new dh(this, super.getResources());
        }
        return this.p == null ? super.getResources() : this.p;
    }

    @Nullable
    public Intent getSupportParentActivityIntent() {
        return ak.a(this);
    }

    @Deprecated
    public void h() {
    }

    @NonNull
    public AppCompatDelegate i() {
        if (this.n == null) {
            this.n = AppCompatDelegate.a((Activity) this, (AppCompatCallback) this);
        }
        return this.n;
    }

    public void invalidateOptionsMenu() {
        i().f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i().a(configuration);
        if (this.p != null) {
            this.p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        h();
    }

    protected void onCreate(@Nullable Bundle bundle) {
        AppCompatDelegate i = i();
        i.i();
        i.a(bundle);
        if (i.j() && this.o != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.o, false);
            } else {
                setTheme(this.o);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        i().g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar f = f();
        return (menuItem.getItemId() != 16908332 || f == null || (f.a() & 4) == 0) ? false : g();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        i().b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        i().e();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        i().c(bundle);
    }

    protected void onStart() {
        super.onStart();
        i().c();
    }

    protected void onStop() {
        super.onStop();
        i().d();
    }

    @CallSuper
    public void onSupportActionModeFinished(@NonNull ActionMode actionMode) {
    }

    @CallSuper
    public void onSupportActionModeStarted(@NonNull ActionMode actionMode) {
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        i().a(charSequence);
    }

    @Nullable
    public ActionMode onWindowStartingSupportActionMode(@NonNull Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar f = f();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (f == null || !f.f()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(@LayoutRes int i) {
        i().b(i);
    }

    public void setContentView(View view) {
        i().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        i().a(view, layoutParams);
    }

    public void setTheme(@StyleRes int i) {
        super.setTheme(i);
        this.o = i;
    }
}
