package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.j;
import android.view.KeyEvent;
import android.view.MenuItem;

@RestrictTo({Scope.LIBRARY_GROUP})
public class bm extends ao {
    final int a;
    final int b;
    private MenuItemHoverListener c;
    private MenuItem d;

    public bm(Context context, boolean z) {
        super(context, z);
        Configuration configuration = context.getResources().getConfiguration();
        if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
            this.a = 22;
            this.b = 21;
            return;
        }
        this.a = 21;
        this.b = 22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    public boolean onHoverEvent(android.view.MotionEvent r6) {
        /*
        r5 = this;
        r0 = r5.c;
        if (r0 == 0) goto L_0x0058;
    L_0x0004:
        r0 = r5.getAdapter();
        r1 = r0 instanceof android.widget.HeaderViewListAdapter;
        if (r1 == 0) goto L_0x005d;
    L_0x000c:
        r0 = (android.widget.HeaderViewListAdapter) r0;
        r1 = r0.getHeadersCount();
        r0 = r0.getWrappedAdapter();
        r0 = (android.support.v7.view.menu.j) r0;
    L_0x0018:
        r2 = 0;
        r3 = r6.getAction();
        r4 = 10;
        if (r3 == r4) goto L_0x0061;
    L_0x0021:
        r3 = r6.getX();
        r3 = (int) r3;
        r4 = r6.getY();
        r4 = (int) r4;
        r3 = r5.pointToPosition(r3, r4);
        r4 = -1;
        if (r3 == r4) goto L_0x0061;
    L_0x0032:
        r1 = r3 - r1;
        if (r1 < 0) goto L_0x0061;
    L_0x0036:
        r3 = r0.getCount();
        if (r1 >= r3) goto L_0x0061;
    L_0x003c:
        r1 = r0.getItem(r1);
    L_0x0040:
        r2 = r5.d;
        if (r2 == r1) goto L_0x0058;
    L_0x0044:
        r0 = r0.a();
        if (r2 == 0) goto L_0x004f;
    L_0x004a:
        r3 = r5.c;
        r3.onItemHoverExit(r0, r2);
    L_0x004f:
        r5.d = r1;
        if (r1 == 0) goto L_0x0058;
    L_0x0053:
        r2 = r5.c;
        r2.onItemHoverEnter(r0, r1);
    L_0x0058:
        r0 = super.onHoverEvent(r6);
        return r0;
    L_0x005d:
        r1 = 0;
        r0 = (android.support.v7.view.menu.j) r0;
        goto L_0x0018;
    L_0x0061:
        r1 = r2;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bm.onHoverEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.a) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        } else if (listMenuItemView == null || i != this.b) {
            return super.onKeyDown(i, keyEvent);
        } else {
            setSelection(-1);
            ((j) getAdapter()).a().b(false);
            return true;
        }
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.c = menuItemHoverListener;
    }
}
