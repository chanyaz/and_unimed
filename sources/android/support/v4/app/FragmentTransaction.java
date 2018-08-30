package android.support.v4.app;

import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class FragmentTransaction {

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    @interface Transit {
    }

    public abstract FragmentTransaction a(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2);

    public abstract FragmentTransaction a(@IdRes int i, Fragment fragment);

    public abstract FragmentTransaction a(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract FragmentTransaction a(Fragment fragment);

    public abstract FragmentTransaction a(Fragment fragment, String str);

    public abstract FragmentTransaction a(@Nullable String str);

    public abstract FragmentTransaction b(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract FragmentTransaction b(Fragment fragment);

    public abstract int c();

    public abstract FragmentTransaction c(Fragment fragment);

    public abstract int d();

    public abstract void e();
}
