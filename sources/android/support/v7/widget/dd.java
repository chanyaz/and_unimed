package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ap;
import android.support.v4.view.ar;
import android.support.v7.a.b;
import android.support.v7.a.f;
import android.support.v7.a.g;
import android.support.v7.a.i;
import android.support.v7.a.k;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.a;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

@RestrictTo({Scope.LIBRARY_GROUP})
public class dd implements DecorToolbar {
    Toolbar a;
    CharSequence b;
    Callback c;
    boolean d;
    private int e;
    private View f;
    private Spinner g;
    private View h;
    private Drawable i;
    private Drawable j;
    private Drawable k;
    private boolean l;
    private CharSequence m;
    private CharSequence n;
    private ActionMenuPresenter o;
    private int p;
    private int q;
    private Drawable r;

    public dd(Toolbar toolbar, boolean z) {
        this(toolbar, z, i.abc_action_bar_up_description, f.abc_ic_ab_back_material);
    }

    public dd(Toolbar toolbar, boolean z, int i, int i2) {
        this.p = 0;
        this.q = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.m = toolbar.getSubtitle();
        this.l = this.b != null;
        this.k = toolbar.getNavigationIcon();
        db a = db.a(toolbar.getContext(), null, k.ActionBar, b.actionBarStyle, 0);
        this.r = a.a(k.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.c(k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                setTitle(c);
            }
            c = a.c(k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                setSubtitle(c);
            }
            Drawable a2 = a.a(k.ActionBar_logo);
            if (a2 != null) {
                setLogo(a2);
            }
            a2 = a.a(k.ActionBar_icon);
            if (a2 != null) {
                setIcon(a2);
            }
            if (this.k == null && this.r != null) {
                setNavigationIcon(this.r);
            }
            setDisplayOptions(a.a(k.ActionBar_displayOptions, 0));
            int g = a.g(k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                setCustomView(LayoutInflater.from(this.a.getContext()).inflate(g, this.a, false));
                setDisplayOptions(this.e | 16);
            }
            g = a.f(k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = g;
                this.a.setLayoutParams(layoutParams);
            }
            g = a.d(k.ActionBar_contentInsetStart, -1);
            int d = a.d(k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.a.a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.g(k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.a.a(this.a.getContext(), g);
            }
            g = a.g(k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.a.b(this.a.getContext(), g);
            }
            int g2 = a.g(k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.a.setPopupTheme(g2);
            }
        } else {
            this.e = a();
        }
        a.a();
        setDefaultNavigationContentDescription(i);
        this.n = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new OnClickListener() {
            final a a = new a(dd.this.a.getContext(), 0, 16908332, 0, 0, dd.this.b);

            public void onClick(View view) {
                if (dd.this.c != null && dd.this.d) {
                    dd.this.c.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    private int a() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.r = this.a.getNavigationIcon();
        return 15;
    }

    private void a(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void b() {
        Drawable drawable = null;
        if ((this.e & 2) != 0) {
            drawable = (this.e & 1) != 0 ? this.j != null ? this.j : this.i : this.i;
        }
        this.a.setLogo(drawable);
    }

    private void c() {
        if (this.g == null) {
            this.g = new AppCompatSpinner(getContext(), null, b.actionDropDownStyle);
            this.g.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void d() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.k != null ? this.k : this.r);
        } else {
            this.a.setNavigationIcon(null);
        }
    }

    private void e() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.n)) {
            this.a.setNavigationContentDescription(this.q);
        } else {
            this.a.setNavigationContentDescription(this.n);
        }
    }

    public void animateToVisibility(int i) {
        ap apVar = setupAnimatorToVisibility(i, 200);
        if (apVar != null) {
            apVar.c();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.a.a();
    }

    public void collapseActionView() {
        this.a.i();
    }

    public void dismissPopupMenus() {
        this.a.f();
    }

    public Context getContext() {
        return this.a.getContext();
    }

    public View getCustomView() {
        return this.h;
    }

    public int getDisplayOptions() {
        return this.e;
    }

    public int getDropdownItemCount() {
        return this.g != null ? this.g.getCount() : 0;
    }

    public int getDropdownSelectedPosition() {
        return this.g != null ? this.g.getSelectedItemPosition() : 0;
    }

    public int getHeight() {
        return this.a.getHeight();
    }

    public Menu getMenu() {
        return this.a.getMenu();
    }

    public int getNavigationMode() {
        return this.p;
    }

    public CharSequence getSubtitle() {
        return this.a.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.a;
    }

    public int getVisibility() {
        return this.a.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.f != null;
    }

    public boolean hasExpandedActionView() {
        return this.a.h();
    }

    public boolean hasIcon() {
        return this.i != null;
    }

    public boolean hasLogo() {
        return this.j != null;
    }

    public boolean hideOverflowMenu() {
        return this.a.e();
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.a.c();
    }

    public boolean isOverflowMenuShowing() {
        return this.a.b();
    }

    public boolean isTitleTruncated() {
        return this.a.g();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.a.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.a.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.a(this.a, drawable);
    }

    public void setCollapsible(boolean z) {
        this.a.setCollapsible(z);
    }

    public void setCustomView(View view) {
        if (!(this.h == null || (this.e & 16) == 0)) {
            this.a.removeView(this.h);
        }
        this.h = view;
        if (view != null && (this.e & 16) != 0) {
            this.a.addView(this.h);
        }
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.q) {
            this.q = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.q);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            d();
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    e();
                }
                d();
            }
            if ((i2 & 3) != 0) {
                b();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.m);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.h != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.h);
                } else {
                    this.a.removeView(this.h);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, OnItemSelectedListener onItemSelectedListener) {
        c();
        this.g.setAdapter(spinnerAdapter);
        this.g.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        if (this.g == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.g.setSelection(i);
    }

    public void setEmbeddedTabView(cl clVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = clVar;
        if (clVar != null && this.p == 2) {
            this.a.addView(this.f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.a = 8388691;
            clVar.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? android.support.v7.c.a.b.b(getContext(), i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.i = drawable;
        b();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? android.support.v7.c.a.b.b(getContext(), i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.j = drawable;
        b();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.o == null) {
            this.o = new ActionMenuPresenter(this.a.getContext());
            this.o.a(g.action_menu_presenter);
        }
        this.o.setCallback(callback);
        this.a.a((MenuBuilder) menu, this.o);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.a.a(callback, callback2);
    }

    public void setMenuPrepared() {
        this.d = true;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        e();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? android.support.v7.c.a.b.b(getContext(), i) : null);
    }

    public void setNavigationIcon(Drawable drawable) {
        this.k = drawable;
        d();
    }

    public void setNavigationMode(int i) {
        int i2 = this.p;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.g != null && this.g.getParent() == this.a) {
                        this.a.removeView(this.g);
                        break;
                    }
                case 2:
                    if (this.f != null && this.f.getParent() == this.a) {
                        this.a.removeView(this.f);
                        break;
                    }
            }
            this.p = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    c();
                    this.a.addView(this.g, 0);
                    return;
                case 2:
                    if (this.f != null) {
                        this.a.addView(this.f, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.a = 8388691;
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.m = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.l = true;
        a(charSequence);
    }

    public void setVisibility(int i) {
        this.a.setVisibility(i);
    }

    public void setWindowCallback(Callback callback) {
        this.c = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.l) {
            a(charSequence);
        }
    }

    public ap setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.l(this.a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new ar() {
            private boolean c = false;

            public void onAnimationCancel(View view) {
                this.c = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.c) {
                    dd.this.a.setVisibility(i);
                }
            }

            public void onAnimationStart(View view) {
                dd.this.a.setVisibility(0);
            }
        });
    }

    public boolean showOverflowMenu() {
        return this.a.d();
    }
}
