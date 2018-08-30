package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ViewCompat {
    static final ab a;

    @Retention(RetentionPolicy.SOURCE)
    @interface AccessibilityLiveRegion {
    }

    @TargetApi(26)
    @Retention(RetentionPolicy.SOURCE)
    @interface AutofillImportance {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ImportantForAccessibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LayerType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LayoutDirectionMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface OverScroll {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ResolvedLayoutDirectionMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new aa();
        } else if (VERSION.SDK_INT >= 24) {
            a = new z();
        } else if (VERSION.SDK_INT >= 23) {
            a = new y();
        } else if (VERSION.SDK_INT >= 21) {
            a = new x();
        } else if (VERSION.SDK_INT >= 19) {
            a = new w();
        } else if (VERSION.SDK_INT >= 18) {
            a = new v();
        } else if (VERSION.SDK_INT >= 17) {
            a = new u();
        } else if (VERSION.SDK_INT >= 16) {
            a = new t();
        } else if (VERSION.SDK_INT >= 15) {
            a = new s();
        } else {
            a = new ab();
        }
    }

    protected ViewCompat() {
    }

    public static Rect A(View view) {
        return a.q(view);
    }

    public static boolean B(View view) {
        return a.s(view);
    }

    public static boolean C(View view) {
        return a.a(view);
    }

    public static Display D(@NonNull View view) {
        return a.p(view);
    }

    @Deprecated
    public static int a(View view) {
        return view.getOverScrollMode();
    }

    public static as a(View view, as asVar) {
        return a.a(view, asVar);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void a(@NonNull View view, int i, int i2) {
        a.a(view, i, i2);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    @Deprecated
    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, Rect rect) {
        a.a(view, rect);
    }

    public static void a(View view, Drawable drawable) {
        a.a(view, drawable);
    }

    public static void a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        a.a(view, onApplyWindowInsetsListener);
    }

    public static void a(View view, a aVar) {
        a.a(view, aVar);
    }

    public static void a(@NonNull View view, q qVar) {
        a.a(view, qVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static void a(View view, String str) {
        a.a(view, str);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    @Deprecated
    public static boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static as b(View view, as asVar) {
        return a.b(view, asVar);
    }

    public static void b(View view, float f) {
        a.b(view, f);
    }

    public static void b(View view, int i) {
        a.a(view, i);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        a.b(view, i, i2, i3, i4);
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean b(View view) {
        return a.B(view);
    }

    public static void c(View view, int i) {
        a.b(view, i);
    }

    public static boolean c(View view) {
        return a.b(view);
    }

    public static void d(View view) {
        a.c(view);
    }

    public static void d(View view, int i) {
        a.d(view, i);
    }

    public static int e(View view) {
        return a.d(view);
    }

    public static void e(View view, int i) {
        a.c(view, i);
    }

    public static int f(View view) {
        return a.k(view);
    }

    public static ViewParent g(View view) {
        return a.e(view);
    }

    public static int h(View view) {
        return a.l(view);
    }

    public static int i(View view) {
        return a.m(view);
    }

    public static int j(View view) {
        return a.f(view);
    }

    public static int k(View view) {
        return a.g(view);
    }

    public static ap l(View view) {
        return a.C(view);
    }

    public static float m(View view) {
        return a.u(view);
    }

    public static float n(View view) {
        return a.v(view);
    }

    public static String o(View view) {
        return a.t(view);
    }

    public static int p(View view) {
        return a.n(view);
    }

    public static void q(View view) {
        a.h(view);
    }

    public static boolean r(View view) {
        return a.i(view);
    }

    public static boolean s(View view) {
        return a.j(view);
    }

    public static boolean t(View view) {
        return a.o(view);
    }

    public static ColorStateList u(View view) {
        return a.y(view);
    }

    public static Mode v(View view) {
        return a.z(view);
    }

    public static boolean w(@NonNull View view) {
        return a.w(view);
    }

    public static void x(@NonNull View view) {
        a.x(view);
    }

    public static boolean y(View view) {
        return a.r(view);
    }

    public static float z(View view) {
        return a.A(view);
    }
}
