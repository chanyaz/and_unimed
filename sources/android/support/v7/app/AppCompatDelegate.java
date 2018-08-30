package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class AppCompatDelegate {
    private static int a = -1;
    private static boolean b = false;

    @Retention(RetentionPolicy.SOURCE)
    @interface ApplyableNightMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    AppCompatDelegate() {
    }

    public static AppCompatDelegate a(Activity activity, AppCompatCallback appCompatCallback) {
        return a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate a(Dialog dialog, AppCompatCallback appCompatCallback) {
        return a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    private static AppCompatDelegate a(Context context, Window window, AppCompatCallback appCompatCallback) {
        return VERSION.SDK_INT >= 24 ? new n(context, window, appCompatCallback) : VERSION.SDK_INT >= 23 ? new s(context, window, appCompatCallback) : new p(context, window, appCompatCallback);
    }

    public static int k() {
        return a;
    }

    public static boolean l() {
        return b;
    }

    @Nullable
    public abstract ActionBar a();

    @Nullable
    public abstract <T extends View> T a(@IdRes int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(@Nullable Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(@Nullable CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(@LayoutRes int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(Bundle bundle);

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    @Nullable
    public abstract Delegate h();

    public abstract void i();

    public abstract boolean j();
}
