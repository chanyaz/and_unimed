package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class e extends ConstantState {
    private final ConstantState a;

    public e(ConstantState constantState) {
        this.a = constantState;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        Drawable cVar = new c();
        cVar.b = this.a.newDrawable();
        cVar.b.setCallback(cVar.a);
        return cVar;
    }

    public Drawable newDrawable(Resources resources) {
        Drawable cVar = new c();
        cVar.b = this.a.newDrawable(resources);
        cVar.b.setCallback(cVar.a);
        return cVar;
    }

    public Drawable newDrawable(Resources resources, Theme theme) {
        Drawable cVar = new c();
        cVar.b = this.a.newDrawable(resources, theme);
        cVar.b.setCallback(cVar.a);
        return cVar;
    }
}
