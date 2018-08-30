package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class s extends ConstantState {
    private final ConstantState a;

    public s(ConstantState constantState) {
        this.a = constantState;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        Drawable lVar = new l();
        lVar.b = (VectorDrawable) this.a.newDrawable();
        return lVar;
    }

    public Drawable newDrawable(Resources resources) {
        Drawable lVar = new l();
        lVar.b = (VectorDrawable) this.a.newDrawable(resources);
        return lVar;
    }

    public Drawable newDrawable(Resources resources, Theme theme) {
        Drawable lVar = new l();
        lVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
        return lVar;
    }
}
