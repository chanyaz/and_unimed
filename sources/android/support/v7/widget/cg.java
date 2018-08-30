package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.view.View;

public class cg extends a {
    final cf a;

    public cg(cf cfVar) {
        this.a = cfVar;
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        if (!this.a.b() && this.a.a.getLayoutManager() != null) {
            this.a.a.getLayoutManager().a(view, bVar);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : (this.a.b() || this.a.a.getLayoutManager() == null) ? false : this.a.a.getLayoutManager().a(view, i, bundle);
    }
}
