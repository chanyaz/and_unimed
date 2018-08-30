package android.support.v7.widget;

import android.support.v7.app.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class cm extends BaseAdapter {
    final /* synthetic */ cl a;

    cm(cl clVar) {
        this.a = clVar;
    }

    public int getCount() {
        return this.a.b.getChildCount();
    }

    public Object getItem(int i) {
        return ((co) this.a.b.getChildAt(i)).b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.a.a((a) getItem(i), true);
        }
        ((co) view).a((a) getItem(i));
        return view;
    }
}
