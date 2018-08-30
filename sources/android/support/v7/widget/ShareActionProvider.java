package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.view.ActionProvider;
import android.support.v7.a.b;
import android.support.v7.a.i;
import android.util.TypedValue;
import android.view.SubMenu;
import android.view.View;

public class ShareActionProvider extends ActionProvider {
    final Context a;
    String b;
    private int c;
    private final cr d;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public View a() {
        View activityChooserView = new ActivityChooserView(this.a);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.a(this.a, this.b));
        }
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(b.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(android.support.v7.c.a.b.b(this.a, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(i.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(i.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    void a(Intent intent) {
        if (VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    public void a(SubMenu subMenu) {
        int i;
        ResolveInfo a;
        subMenu.clear();
        ActivityChooserModel a2 = ActivityChooserModel.a(this.a, this.b);
        PackageManager packageManager = this.a.getPackageManager();
        int a3 = a2.a();
        int min = Math.min(a3, this.c);
        for (i = 0; i < min; i++) {
            a = a2.a(i);
            subMenu.add(0, i, i, a.loadLabel(packageManager)).setIcon(a.loadIcon(packageManager)).setOnMenuItemClickListener(this.d);
        }
        if (min < a3) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.a.getString(i.abc_activity_chooser_view_see_all));
            for (i = 0; i < a3; i++) {
                a = a2.a(i);
                addSubMenu.add(0, i, i, a.loadLabel(packageManager)).setIcon(a.loadIcon(packageManager)).setOnMenuItemClickListener(this.d);
            }
        }
    }

    public boolean e() {
        return true;
    }
}
