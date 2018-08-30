package android.support.v4.widget;

import android.database.DataSetObserver;

class m extends DataSetObserver {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}
