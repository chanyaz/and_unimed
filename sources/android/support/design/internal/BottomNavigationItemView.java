package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.e;
import android.support.design.f;
import android.support.design.g;
import android.support.design.i;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.q;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.l;
import android.support.v7.widget.de;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

@RestrictTo({Scope.LIBRARY_GROUP})
public class BottomNavigationItemView extends FrameLayout implements ItemView {
    private static final int[] a = new int[]{16842912};
    private final int b;
    private final int c;
    private final float d;
    private final float e;
    private boolean f;
    private ImageView g;
    private final TextView h;
    private final TextView i;
    private int j;
    private l k;
    private ColorStateList l;

    public BottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(e.design_bottom_navigation_text_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e.design_bottom_navigation_active_text_size);
        this.b = resources.getDimensionPixelSize(e.design_bottom_navigation_margin);
        this.c = dimensionPixelSize - dimensionPixelSize2;
        this.d = (((float) dimensionPixelSize2) * 1.0f) / ((float) dimensionPixelSize);
        this.e = (((float) dimensionPixelSize) * 1.0f) / ((float) dimensionPixelSize2);
        LayoutInflater.from(context).inflate(i.design_bottom_navigation_item, this, true);
        setBackgroundResource(f.design_bottom_navigation_item_background);
        this.g = (ImageView) findViewById(g.icon);
        this.h = (TextView) findViewById(g.smallLabel);
        this.i = (TextView) findViewById(g.largeLabel);
    }

    public l getItemData() {
        return this.k;
    }

    public int getItemPosition() {
        return this.j;
    }

    public void initialize(l lVar, int i) {
        this.k = lVar;
        setCheckable(lVar.isCheckable());
        setChecked(lVar.isChecked());
        setEnabled(lVar.isEnabled());
        setIcon(lVar.getIcon());
        setTitle(lVar.getTitle());
        setId(lVar.getItemId());
        setContentDescription(lVar.getContentDescription());
        de.a(this, lVar.getTooltipText());
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.k != null && this.k.isCheckable() && this.k.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, a);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.i.setPivotX((float) (this.i.getWidth() / 2));
        this.i.setPivotY((float) this.i.getBaseline());
        this.h.setPivotX((float) (this.h.getWidth() / 2));
        this.h.setPivotY((float) this.h.getBaseline());
        LayoutParams layoutParams;
        if (this.f) {
            if (z) {
                layoutParams = (LayoutParams) this.g.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.b;
                this.g.setLayoutParams(layoutParams);
                this.i.setVisibility(0);
                this.i.setScaleX(1.0f);
                this.i.setScaleY(1.0f);
            } else {
                layoutParams = (LayoutParams) this.g.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.topMargin = this.b;
                this.g.setLayoutParams(layoutParams);
                this.i.setVisibility(4);
                this.i.setScaleX(0.5f);
                this.i.setScaleY(0.5f);
            }
            this.h.setVisibility(4);
        } else if (z) {
            layoutParams = (LayoutParams) this.g.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.b + this.c;
            this.g.setLayoutParams(layoutParams);
            this.i.setVisibility(0);
            this.h.setVisibility(4);
            this.i.setScaleX(1.0f);
            this.i.setScaleY(1.0f);
            this.h.setScaleX(this.d);
            this.h.setScaleY(this.d);
        } else {
            layoutParams = (LayoutParams) this.g.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.b;
            this.g.setLayoutParams(layoutParams);
            this.i.setVisibility(4);
            this.h.setVisibility(0);
            this.i.setScaleX(this.e);
            this.i.setScaleY(this.e);
            this.h.setScaleX(1.0f);
            this.h.setScaleY(1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.h.setEnabled(z);
        this.i.setEnabled(z);
        this.g.setEnabled(z);
        if (z) {
            ViewCompat.a((View) this, q.a(getContext(), 1002));
        } else {
            ViewCompat.a((View) this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a.g(drawable).mutate();
            a.a(drawable, this.l);
        }
        this.g.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        if (this.k != null) {
            setIcon(this.k.getIcon());
        }
    }

    public void setItemBackground(int i) {
        ViewCompat.a((View) this, i == 0 ? null : android.support.v4.content.a.a(getContext(), i));
    }

    public void setItemPosition(int i) {
        this.j = i;
    }

    public void setShiftingMode(boolean z) {
        this.f = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.h.setTextColor(colorStateList);
        this.i.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.h.setText(charSequence);
        this.i.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
