package android.support.v7.view.menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.bl;
import android.widget.ListView;

class g {
    public final bl a;
    public final MenuBuilder b;
    public final int c;

    public g(@NonNull bl blVar, @NonNull MenuBuilder menuBuilder, int i) {
        this.a = blVar;
        this.b = menuBuilder;
        this.c = i;
    }

    public ListView a() {
        return this.a.getListView();
    }
}
