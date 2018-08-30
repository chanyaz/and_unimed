package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.a.b;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {
    private final AppCompatCompoundButtonHelper a;
    private final ad b;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(cy.a(context), attributeSet, i);
        this.a = new AppCompatCompoundButtonHelper(this);
        this.a.a(attributeSet, i);
        this.b = new ad(this);
        this.b.a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.a != null ? this.a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public ColorStateList getSupportButtonTintList() {
        return this.a != null ? this.a.a() : null;
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public Mode getSupportButtonTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportButtonTintMode(@Nullable Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}
