package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.l;
import android.support.v7.widget.db;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final CharSequence a;
    final Drawable b;
    final int c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        db a = db.a(context, attributeSet, l.TabItem);
        this.a = a.c(l.TabItem_android_text);
        this.b = a.a(l.TabItem_android_icon);
        this.c = a.g(l.TabItem_android_layout, 0);
        a.a();
    }
}
