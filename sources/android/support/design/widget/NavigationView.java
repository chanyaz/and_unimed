package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.design.k;
import android.support.design.l;
import android.support.v4.content.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.support.v7.view.f;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.db;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] d = new int[]{16842912};
    private static final int[] e = new int[]{-16842910};
    OnNavigationItemSelectedListener c;
    private final b f;
    private final NavigationMenuPresenter g;
    private int h;
    private MenuInflater i;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public Bundle a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        int g;
        int i2;
        super(context, attributeSet, i);
        this.g = new NavigationMenuPresenter();
        am.a(context);
        this.f = new b(context);
        db a = db.a(context, attributeSet, l.NavigationView, i, k.Widget_Design_NavigationView);
        ViewCompat.a((View) this, a.a(l.NavigationView_android_background));
        if (a.g(l.NavigationView_elevation)) {
            ViewCompat.a((View) this, (float) a.e(l.NavigationView_elevation, 0));
        }
        ViewCompat.b((View) this, a.a(l.NavigationView_android_fitsSystemWindows, false));
        this.h = a.e(l.NavigationView_android_maxWidth, 0);
        ColorStateList e = a.g(l.NavigationView_itemIconTint) ? a.e(l.NavigationView_itemIconTint) : c(16842808);
        if (a.g(l.NavigationView_itemTextAppearance)) {
            g = a.g(l.NavigationView_itemTextAppearance, 0);
            i2 = 1;
        } else {
            g = 0;
            boolean i22 = false;
        }
        ColorStateList colorStateList = null;
        if (a.g(l.NavigationView_itemTextColor)) {
            colorStateList = a.e(l.NavigationView_itemTextColor);
        }
        if (i22 == 0 && r5 == null) {
            colorStateList = c(16842806);
        }
        Drawable a2 = a.a(l.NavigationView_itemBackground);
        this.f.a(new Callback() {
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.c != null && NavigationView.this.c.onNavigationItemSelected(menuItem);
            }

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        this.g.a(1);
        this.g.initForMenu(context, this.f);
        this.g.a(e);
        if (i22 != 0) {
            this.g.c(g);
        }
        this.g.b(colorStateList);
        this.g.a(a2);
        this.f.a(this.g);
        addView((View) this.g.getMenuView(this));
        if (a.g(l.NavigationView_menu)) {
            a(a.g(l.NavigationView_menu, 0));
        }
        if (a.g(l.NavigationView_headerLayout)) {
            b(a.g(l.NavigationView_headerLayout, 0));
        }
        a.a();
    }

    private ColorStateList c(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList a = android.support.v7.c.a.b.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.v7.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = a.getDefaultColor();
        return new ColorStateList(new int[][]{e, d, EMPTY_STATE_SET}, new int[]{a.getColorForState(e, defaultColor), i2, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new f(getContext());
        }
        return this.i;
    }

    public void a(int i) {
        this.g.a(true);
        getMenuInflater().inflate(i, this.f);
        this.g.a(false);
        this.g.updateMenuView(false);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void a(as asVar) {
        this.g.a(asVar);
    }

    public View b(@LayoutRes int i) {
        return this.g.b(i);
    }

    public int getHeaderCount() {
        return this.g.a();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.g.d();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.g.b();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.g.c();
    }

    public Menu getMenu() {
        return this.f;
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.h), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            this.f.b(savedState.a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = new Bundle();
        this.f.a(savedState.a);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i) {
        MenuItem findItem = this.f.findItem(i);
        if (findItem != null) {
            this.g.a((android.support.v7.view.menu.l) findItem);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.g.a(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i) {
        setItemBackground(a.a(getContext(), i));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public void setItemTextAppearance(@StyleRes int i) {
        this.g.c(i);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.c = onNavigationItemSelectedListener;
    }
}
