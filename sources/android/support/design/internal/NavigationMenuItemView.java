package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.e;
import android.support.design.f;
import android.support.design.g;
import android.support.design.i;
import android.support.v4.content.res.d;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.l;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.de;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements ItemView {
    private static final int[] d = new int[]{16842912};
    boolean c;
    private final int e;
    private boolean f;
    private final CheckedTextView g;
    private FrameLayout h;
    private l i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final a m;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new a() {
            public void a(View view, b bVar) {
                super.a(view, bVar);
                bVar.a(NavigationMenuItemView.this.c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(i.design_navigation_menu_item, this, true);
        this.e = context.getResources().getDimensionPixelSize(e.design_navigation_icon_size);
        this.g = (CheckedTextView) findViewById(g.design_menu_item_text);
        this.g.setDuplicateParentStateEnabled(true);
        ViewCompat.a(this.g, this.m);
    }

    private boolean b() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    private void c() {
        LayoutParams layoutParams;
        if (b()) {
            this.g.setVisibility(8);
            if (this.h != null) {
                layoutParams = (LayoutParams) this.h.getLayoutParams();
                layoutParams.width = -1;
                this.h.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.g.setVisibility(0);
        if (this.h != null) {
            layoutParams = (LayoutParams) this.h.getLayoutParams();
            layoutParams.width = -2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    private StateListDrawable d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(android.support.v7.a.b.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout) ((ViewStub) findViewById(g.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    public void a() {
        if (this.h != null) {
            this.h.removeAllViews();
        }
        this.g.setCompoundDrawables(null, null, null, null);
    }

    public l getItemData() {
        return this.i;
    }

    public void initialize(l lVar, int i) {
        this.i = lVar;
        setVisibility(lVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.a((View) this, d());
        }
        setCheckable(lVar.isCheckable());
        setChecked(lVar.isChecked());
        setEnabled(lVar.isEnabled());
        setTitle(lVar.getTitle());
        setIcon(lVar.getIcon());
        setActionView(lVar.getActionView());
        setContentDescription(lVar.getContentDescription());
        de.a(this, lVar.getTooltipText());
        c();
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.i != null && this.i.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, d);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.c != z) {
            this.c = z;
            this.m.a(this.g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = android.support.v4.graphics.drawable.a.g(drawable).mutate();
                android.support.v4.graphics.drawable.a.a(drawable, this.j);
            }
            drawable.setBounds(0, 0, this.e, this.e);
        } else if (this.f) {
            if (this.l == null) {
                this.l = d.a(getResources(), f.navigation_empty_icon, getContext().getTheme());
                if (this.l != null) {
                    this.l.setBounds(0, 0, this.e, this.e);
                }
            }
            drawable = this.l;
        }
        TextViewCompat.a(this.g, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        if (this.i != null) {
            setIcon(this.i.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        TextViewCompat.a(this.g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
