package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

@RestrictTo({Scope.LIBRARY_GROUP})
public class bl extends ListPopupWindow implements MenuItemHoverListener {
    private static Method a;
    private MenuItemHoverListener b;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public bl(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    ao a(Context context, boolean z) {
        ao bmVar = new bm(context, z);
        bmVar.setHoverListener(this);
        return bmVar;
    }

    public void a(MenuItemHoverListener menuItemHoverListener) {
        this.b = menuItemHoverListener;
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (this.b != null) {
            this.b.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (this.b != null) {
            this.b.onItemHoverExit(menuBuilder, menuItem);
        }
    }
}
