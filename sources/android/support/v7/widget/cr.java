package android.support.v7.widget;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class cr implements OnMenuItemClickListener {
    final /* synthetic */ ShareActionProvider a;

    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent b = ActivityChooserModel.a(this.a.a, this.a.b).b(menuItem.getItemId());
        if (b != null) {
            String action = b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.a.a(b);
            }
            this.a.a.startActivity(b);
        }
        return true;
    }
}
