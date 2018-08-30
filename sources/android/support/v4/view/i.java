package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;

@RequiresApi(26)
class i extends j {
    i() {
    }

    public int getAlphabeticModifiers(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    public CharSequence getContentDescription(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    public ColorStateList getIconTintList(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    public Mode getIconTintMode(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    public int getNumericModifiers(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    public CharSequence getTooltipText(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    public void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
        menuItem.setAlphabeticShortcut(c, i);
    }

    public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public void setIconTintMode(MenuItem menuItem, Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public void setNumericShortcut(MenuItem menuItem, char c, int i) {
        menuItem.setNumericShortcut(c, i);
    }

    public void setShortcut(MenuItem menuItem, char c, char c2, int i, int i2) {
        menuItem.setShortcut(c, c2, i, i2);
    }

    public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }
}
