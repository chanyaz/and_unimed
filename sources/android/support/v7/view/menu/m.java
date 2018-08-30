package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
public class m extends e<SupportMenuItem> implements MenuItem {
    private Method c;

    m(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    n a(ActionProvider actionProvider) {
        return new n(this, this.a, actionProvider);
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = ((SupportMenuItem) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.ActionProvider supportActionProvider = ((SupportMenuItem) this.b).getSupportActionProvider();
        return supportActionProvider instanceof n ? ((n) supportActionProvider).a : null;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.b).getActionView();
        return actionView instanceof o ? ((o) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return ((SupportMenuItem) this.b).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.b).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((SupportMenuItem) this.b).getContentDescription();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.b).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((SupportMenuItem) this.b).getIconTintList();
    }

    public Mode getIconTintMode() {
        return ((SupportMenuItem) this.b).getIconTintMode();
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.b).getIntent();
    }

    public int getItemId() {
        return ((SupportMenuItem) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.b).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((SupportMenuItem) this.b).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return a(((SupportMenuItem) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.b).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((SupportMenuItem) this.b).getTooltipText();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((SupportMenuItem) this.b).setSupportActionProvider(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.b).setActionView(i);
        View actionView = ((SupportMenuItem) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.b).setActionView(new o(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new o(view);
        }
        ((SupportMenuItem) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((SupportMenuItem) this.b).setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.b).setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((SupportMenuItem) this.b).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((SupportMenuItem) this.b).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((SupportMenuItem) this.b).setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.b).setOnActionExpandListener(onActionExpandListener != null ? new p(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new q(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((SupportMenuItem) this.b).setShortcut(c, c2, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.b).setVisible(z);
    }
}
