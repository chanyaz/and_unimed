package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class o {
    private final List<p> a = new ArrayList();
    private final List<Bundle> b = new ArrayList();

    public p a(Context context, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return null;
            }
            if (x.a((Bundle) this.b.get(i2), bundle)) {
                return (p) this.a.get(i2);
            }
            i = i2 + 1;
        }
    }

    public void a(Context context, Bundle bundle, p pVar) {
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                this.a.add(pVar);
                this.b.add(bundle);
                return;
            } else if (x.a((Bundle) this.b.get(i2), bundle)) {
                this.a.set(i2, pVar);
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    public List<Bundle> b() {
        return this.b;
    }

    public List<p> c() {
        return this.a;
    }
}
