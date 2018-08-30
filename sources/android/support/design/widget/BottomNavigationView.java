package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.d;
import android.support.design.e;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.a;
import android.support.design.k;
import android.support.design.l;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.a.b;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class BottomNavigationView extends FrameLayout {
    private static final int[] a = new int[]{16842912};
    private static final int[] b = new int[]{-16842910};
    private final MenuBuilder c;
    private final BottomNavigationMenuView d;
    private final BottomNavigationPresenter e;
    private MenuInflater f;
    private OnNavigationItemSelectedListener g;
    private OnNavigationItemReselectedListener h;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    class SavedState extends AbsSavedState {
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
        Bundle a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new BottomNavigationPresenter();
        am.a(context);
        this.c = new a(context);
        this.d = new BottomNavigationMenuView(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        this.e.a(this.d);
        this.e.a(1);
        this.d.setPresenter(this.e);
        this.c.a(this.e);
        this.e.initForMenu(getContext(), this.c);
        db a = db.a(context, attributeSet, l.BottomNavigationView, i, k.Widget_Design_BottomNavigationView);
        if (a.g(l.BottomNavigationView_itemIconTint)) {
            this.d.setIconTintList(a.e(l.BottomNavigationView_itemIconTint));
        } else {
            this.d.setIconTintList(b(16842808));
        }
        if (a.g(l.BottomNavigationView_itemTextColor)) {
            this.d.setItemTextColor(a.e(l.BottomNavigationView_itemTextColor));
        } else {
            this.d.setItemTextColor(b(16842808));
        }
        if (a.g(l.BottomNavigationView_elevation)) {
            ViewCompat.a((View) this, (float) a.e(l.BottomNavigationView_elevation, 0));
        }
        this.d.setItemBackgroundRes(a.g(l.BottomNavigationView_itemBackground, 0));
        if (a.g(l.BottomNavigationView_menu)) {
            a(a.g(l.BottomNavigationView_menu, 0));
        }
        a.a();
        addView(this.d, layoutParams);
        if (VERSION.SDK_INT < 21) {
            a(context);
        }
        this.c.a(new Callback() {
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                if (BottomNavigationView.this.h == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                    return (BottomNavigationView.this.g == null || BottomNavigationView.this.g.onNavigationItemSelected(menuItem)) ? false : true;
                } else {
                    BottomNavigationView.this.h.onNavigationItemReselected(menuItem);
                    return true;
                }
            }

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
    }

    private void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(android.support.v4.content.a.c(context, d.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private ColorStateList b(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList a = b.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.v7.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = a.getDefaultColor();
        return new ColorStateList(new int[][]{b, a, EMPTY_STATE_SET}, new int[]{a.getColorForState(b, defaultColor), i2, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f == null) {
            this.f = new f(getContext());
        }
        return this.f;
    }

    public void a(int i) {
        this.e.a(true);
        getMenuInflater().inflate(i, this.c);
        this.e.a(false);
        this.e.updateMenuView(true);
    }

    @DrawableRes
    public int getItemBackgroundResource() {
        return this.d.getItemBackgroundRes();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.d.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.d.getItemTextColor();
    }

    public int getMaxItemCount() {
        return 5;
    }

    @NonNull
    public Menu getMenu() {
        return this.c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.d.getSelectedItemId();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            this.c.b(savedState.a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = new Bundle();
        this.c.a(savedState.a);
        return savedState;
    }

    public void setItemBackgroundResource(@DrawableRes int i) {
        this.d.setItemBackgroundRes(i);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.d.setItemTextColor(colorStateList);
    }

    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        this.h = onNavigationItemReselectedListener;
    }

    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.g = onNavigationItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i) {
        MenuItem findItem = this.c.findItem(i);
        if (findItem != null && !this.c.a(findItem, this.e, 0)) {
            findItem.setChecked(true);
        }
    }
}
