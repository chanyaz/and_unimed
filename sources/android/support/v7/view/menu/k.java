package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.a.h;
import android.support.v7.app.i;
import android.support.v7.app.j;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class k implements OnClickListener, OnDismissListener, OnKeyListener, Callback {
    h a;
    private MenuBuilder b;
    private i c;
    private Callback d;

    public k(MenuBuilder menuBuilder) {
        this.b = menuBuilder;
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.b;
        j jVar = new j(menuBuilder.e());
        this.a = new h(jVar.a(), h.abc_list_menu_item_layout);
        this.a.setCallback(this);
        this.b.a(this.a);
        jVar.a(this.a.a(), this);
        View o = menuBuilder.o();
        if (o != null) {
            jVar.a(o);
        } else {
            jVar.a(menuBuilder.n()).a(menuBuilder.m());
        }
        jVar.a((OnKeyListener) this);
        this.c = jVar.b();
        this.c.setOnDismissListener(this);
        LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((l) this.a.a().getItem(i), 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.onCloseMenu(menuBuilder, z);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.onCloseMenu(this.b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.b.b(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return this.d != null ? this.d.onOpenSubMenu(menuBuilder) : false;
    }
}
