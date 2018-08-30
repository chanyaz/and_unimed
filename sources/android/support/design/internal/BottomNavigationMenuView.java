package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.e;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.transition.aj;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.q;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a.b;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

@RestrictTo({Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private final TransitionSet a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final OnClickListener f;
    private final Pool<BottomNavigationItemView> g;
    private boolean h;
    private BottomNavigationItemView[] i;
    private int j;
    private int k;
    private ColorStateList l;
    private ColorStateList m;
    private int n;
    private int[] o;
    private BottomNavigationPresenter p;
    private MenuBuilder q;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new q(5);
        this.h = true;
        this.j = 0;
        this.k = 0;
        Resources resources = getResources();
        this.b = resources.getDimensionPixelSize(e.design_bottom_navigation_item_max_width);
        this.c = resources.getDimensionPixelSize(e.design_bottom_navigation_item_min_width);
        this.d = resources.getDimensionPixelSize(e.design_bottom_navigation_active_item_max_width);
        this.e = resources.getDimensionPixelSize(e.design_bottom_navigation_height);
        this.a = new AutoTransition();
        this.a.a(0);
        this.a.a(115);
        this.a.a(new b());
        this.a.b(new m());
        this.f = new OnClickListener() {
            public void onClick(View view) {
                MenuItem itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.q.a(itemData, BottomNavigationMenuView.this.p, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.o = new int[5];
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.g.acquire();
        return bottomNavigationItemView == null ? new BottomNavigationItemView(getContext()) : bottomNavigationItemView;
    }

    public void a() {
        removeAllViews();
        if (this.i != null) {
            for (Object release : this.i) {
                this.g.release(release);
            }
        }
        if (this.q.size() == 0) {
            this.j = 0;
            this.k = 0;
            this.i = null;
            return;
        }
        this.i = new BottomNavigationItemView[this.q.size()];
        this.h = this.q.size() > 3;
        for (int i = 0; i < this.q.size(); i++) {
            this.p.a(true);
            this.q.getItem(i).setCheckable(true);
            this.p.a(false);
            View newItem = getNewItem();
            this.i[i] = newItem;
            newItem.setIconTintList(this.l);
            newItem.setTextColor(this.m);
            newItem.setItemBackground(this.n);
            newItem.setShiftingMode(this.h);
            newItem.initialize((l) this.q.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.f);
            addView(newItem);
        }
        this.k = Math.min(this.q.size() - 1, this.k);
        this.q.getItem(this.k).setChecked(true);
    }

    void a(int i) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.q.getItem(i2);
            if (i == item.getItemId()) {
                this.j = i;
                this.k = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void b() {
        int size = this.q.size();
        if (size != this.i.length) {
            a();
            return;
        }
        int i = this.j;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.q.getItem(i2);
            if (item.isChecked()) {
                this.j = item.getItemId();
                this.k = i2;
            }
        }
        if (i != this.j) {
            aj.a(this, this.a);
        }
        for (i = 0; i < size; i++) {
            this.p.a(true);
            this.i[i].initialize((l) this.q.getItem(i), 0);
            this.p.a(false);
        }
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.l;
    }

    public int getItemBackgroundRes() {
        return this.n;
    }

    public ColorStateList getItemTextColor() {
        return this.m;
    }

    public int getSelectedItemId() {
        return this.j;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.q = menuBuilder;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.f(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int min;
        int size = MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.e, 1073741824);
        int min2;
        if (this.h) {
            i3 = childCount - 1;
            min = Math.min(size - (this.c * i3), this.d);
            min2 = Math.min((size - min) / i3, this.b);
            size = (size - min) - (i3 * min2);
            int i4 = 0;
            while (i4 < childCount) {
                this.o[i4] = i4 == this.k ? min : min2;
                if (size > 0) {
                    int[] iArr = this.o;
                    iArr[i4] = iArr[i4] + 1;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        } else {
            min2 = Math.min(size / (childCount == 0 ? 1 : childCount), this.d);
            i3 = size - (min2 * childCount);
            for (min = 0; min < childCount; min++) {
                this.o[min] = min2;
                if (i3 > 0) {
                    int[] iArr2 = this.o;
                    iArr2[min] = iArr2[min] + 1;
                    i3--;
                }
            }
        }
        i3 = 0;
        for (min = 0; min < childCount; min++) {
            View childAt = getChildAt(min);
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(this.o[min], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i3 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i3, MeasureSpec.makeMeasureSpec(i3, 1073741824), 0), View.resolveSizeAndState(this.e, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        if (this.i != null) {
            for (BottomNavigationItemView iconTintList : this.i) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.n = i;
        if (this.i != null) {
            for (BottomNavigationItemView itemBackground : this.i) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.m = colorStateList;
        if (this.i != null) {
            for (BottomNavigationItemView textColor : this.i) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.p = bottomNavigationPresenter;
    }
}
