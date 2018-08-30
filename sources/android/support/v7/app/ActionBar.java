package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.a.k;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ActionBar {

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    public class LayoutParams extends MarginLayoutParams {
        public int a;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionBarLayout);
            this.a = obtainStyledAttributes.getInt(k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(a aVar, FragmentTransaction fragmentTransaction);

        void onTabSelected(a aVar, FragmentTransaction fragmentTransaction);

        void onTabUnselected(a aVar, FragmentTransaction fragmentTransaction);
    }

    public abstract int a();

    @RestrictTo({Scope.LIBRARY_GROUP})
    public ActionMode a(Callback callback) {
        return null;
    }

    public void a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void a(@DrawableRes int i) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Configuration configuration) {
    }

    public abstract void a(@Nullable Drawable drawable);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract int b();

    public void b(@StringRes int i) {
    }

    public void b(@Nullable Drawable drawable) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void b(CharSequence charSequence) {
    }

    public void b(boolean z) {
    }

    public abstract void c();

    public void c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public abstract void d();

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void d(boolean z) {
    }

    public Context e() {
        return null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void e(boolean z) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void f(boolean z) {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean f() {
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean g() {
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean h() {
        return false;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean i() {
        return false;
    }

    void j() {
    }
}
