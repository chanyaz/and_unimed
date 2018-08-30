package android.support.v7.app;

import android.support.v7.view.j;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class m extends j {
    final /* synthetic */ k a;

    m(k kVar, Callback callback) {
        this.a = kVar;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.a.a(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof MenuBuilder)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.a.b(i, menu);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.a.a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (i == 0 && menuBuilder == null) {
            return false;
        }
        if (menuBuilder != null) {
            menuBuilder.c(true);
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (menuBuilder == null) {
            return onPreparePanel;
        }
        menuBuilder.c(false);
        return onPreparePanel;
    }
}
