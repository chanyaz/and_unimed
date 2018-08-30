package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v4.view.ap;
import android.support.v4.view.ar;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.a.k;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.a;
import android.support.v7.view.i;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.cl;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ai extends ActionBar implements ActionBarVisibilityCallback {
    static final /* synthetic */ boolean s = (!ai.class.desiredAssertionStatus());
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<OnMenuVisibilityListener> C = new ArrayList();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    DecorToolbar d;
    ActionBarContextView e;
    View f;
    cl g;
    aj h;
    ActionMode i;
    Callback j;
    boolean k = true;
    boolean l;
    boolean m;
    i n;
    boolean o;
    final ViewPropertyAnimatorListener p = new ar() {
        public void onAnimationEnd(View view) {
            if (ai.this.k && ai.this.f != null) {
                ai.this.f.setTranslationY(0.0f);
                ai.this.c.setTranslationY(0.0f);
            }
            ai.this.c.setVisibility(8);
            ai.this.c.setTransitioning(false);
            ai.this.n = null;
            ai.this.k();
            if (ai.this.b != null) {
                ViewCompat.q(ai.this.b);
            }
        }
    };
    final ViewPropertyAnimatorListener q = new ar() {
        public void onAnimationEnd(View view) {
            ai.this.n = null;
            ai.this.c.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener r = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) ai.this.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList();
    private int z = -1;

    public ai(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.f = decorView.findViewById(16908290);
        }
    }

    public ai(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(g.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(g.action_bar));
        this.e = (ActionBarContextView) view.findViewById(g.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(g.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.a = this.d.getContext();
        boolean z = (this.d.getDisplayOptions() & 4) != 0;
        if (z) {
            this.A = true;
        }
        a a = a.a(this.a);
        z = a.f() || z;
        b(z);
        j(a.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, k.ActionBar, b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(k.ActionBar_hideOnContentScroll, false)) {
            c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private DecorToolbar b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void j(boolean z) {
        boolean z2 = true;
        this.D = z;
        if (this.D) {
            this.c.setTabContainer(null);
            this.d.setEmbeddedTabView(this.g);
        } else {
            this.d.setEmbeddedTabView(null);
            this.c.setTabContainer(this.g);
        }
        boolean z3 = l() == 2;
        if (this.g != null) {
            if (z3) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    ViewCompat.q(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.d;
        boolean z4 = !this.D && z3;
        decorToolbar.setCollapsible(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (this.D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void k(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                g(z);
            }
        } else if (this.G) {
            this.G = false;
            h(z);
        }
    }

    private void m() {
        if (!this.F) {
            this.F = true;
            if (this.b != null) {
                this.b.setShowingForActionMode(true);
            }
            k(false);
        }
    }

    private void n() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            k(false);
        }
    }

    private boolean o() {
        return ViewCompat.y(this.c);
    }

    public int a() {
        return this.d.getDisplayOptions();
    }

    public ActionMode a(Callback callback) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        ActionMode ajVar = new aj(this, this.e.getContext(), callback);
        if (!ajVar.e()) {
            return null;
        }
        this.h = ajVar;
        ajVar.d();
        this.e.a(ajVar);
        i(true);
        this.e.sendAccessibilityEvent(32);
        return ajVar;
    }

    public void a(float f) {
        ViewCompat.a(this.c, f);
    }

    public void a(int i) {
        this.d.setNavigationIcon(i);
    }

    public void a(int i, int i2) {
        int displayOptions = this.d.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void a(Configuration configuration) {
        j(a.a(this.a).d());
    }

    public void a(Drawable drawable) {
        this.c.setPrimaryBackground(drawable);
    }

    public void a(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h == null) {
            return false;
        }
        Menu b = this.h.b();
        if (b == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }

    public int b() {
        return this.c.getHeight();
    }

    public void b(int i) {
        this.d.setNavigationContentDescription(i);
    }

    public void b(Drawable drawable) {
        this.d.setNavigationIcon(drawable);
    }

    public void b(CharSequence charSequence) {
        this.d.setWindowTitle(charSequence);
    }

    public void b(boolean z) {
        this.d.setHomeButtonEnabled(z);
    }

    public void c() {
        if (this.l) {
            this.l = false;
            k(false);
        }
    }

    public void c(boolean z) {
        if (!z || this.b.a()) {
            this.o = z;
            this.b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void d() {
        if (!this.l) {
            this.l = true;
            k(false);
        }
    }

    public void d(boolean z) {
        if (!this.A) {
            a(z);
        }
    }

    public Context e() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.a, i);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    public void e(boolean z) {
        this.H = z;
        if (!z && this.n != null) {
            this.n.c();
        }
    }

    public void enableContentAnimations(boolean z) {
        this.k = z;
    }

    public void f(boolean z) {
        if (z != this.B) {
            this.B = z;
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                ((OnMenuVisibilityListener) this.C.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public void g(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.c.setTranslationY(f);
            i iVar = new i();
            ap b = ViewCompat.l(this.c).b(0.0f);
            b.a(this.r);
            iVar.a(b);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                iVar.a(ViewCompat.l(this.f).b(0.0f));
            }
            iVar.a(u);
            iVar.a(250);
            iVar.a(this.q);
            this.n = iVar;
            iVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.onAnimationEnd(null);
        }
        if (this.b != null) {
            ViewCompat.q(this.b);
        }
    }

    public void h(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            i iVar = new i();
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ap b = ViewCompat.l(this.c).b(f);
            b.a(this.r);
            iVar.a(b);
            if (this.k && this.f != null) {
                iVar.a(ViewCompat.l(this.f).b(f));
            }
            iVar.a(t);
            iVar.a(250);
            iVar.a(this.p);
            this.n = iVar;
            iVar.a();
            return;
        }
        this.p.onAnimationEnd(null);
    }

    public void hideForSystem() {
        if (!this.m) {
            this.m = true;
            k(true);
        }
    }

    public void i(boolean z) {
        if (z) {
            m();
        } else {
            n();
        }
        if (o()) {
            ap apVar;
            ap a;
            if (z) {
                apVar = this.d.setupAnimatorToVisibility(4, 100);
                a = this.e.a(0, 200);
            } else {
                a = this.d.setupAnimatorToVisibility(0, 200);
                apVar = this.e.a(8, 100);
            }
            i iVar = new i();
            iVar.a(apVar, a);
            iVar.a();
        } else if (z) {
            this.d.setVisibility(4);
            this.e.setVisibility(0);
        } else {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        }
    }

    public boolean i() {
        if (this.d == null || !this.d.hasExpandedActionView()) {
            return false;
        }
        this.d.collapseActionView();
        return true;
    }

    void k() {
        if (this.j != null) {
            this.j.onDestroyActionMode(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public int l() {
        return this.d.getNavigationMode();
    }

    public void onContentScrollStarted() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public void onWindowVisibilityChanged(int i) {
        this.E = i;
    }

    public void showForSystem() {
        if (this.m) {
            this.m = false;
            k(true);
        }
    }
}
