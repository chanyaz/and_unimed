package android.support.v7.view.menu;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.widget.db;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private MenuBuilder b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        db a = db.a(context, attributeSet, a, i, 0);
        if (a.g(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.g(1)) {
            setDivider(a.a(1));
        }
        a.a();
    }

    public int getWindowAnimations() {
        return this.c;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.b = menuBuilder;
    }

    public boolean invokeItem(l lVar) {
        return this.b.a((MenuItem) lVar, 0);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((l) getAdapter().getItem(i));
    }
}
