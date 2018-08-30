package android.support.v4.app;

import java.util.ArrayList;

class w implements OpGenerator {
    final String a;
    final int b;
    final int c;
    final /* synthetic */ FragmentManagerImpl d;

    w(FragmentManagerImpl fragmentManagerImpl, String str, int i, int i2) {
        this.d = fragmentManagerImpl;
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean generateOps(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2) {
        if (this.d.p != null && this.b < 0 && this.a == null) {
            FragmentManager n = this.d.p.n();
            if (n != null && n.d()) {
                return false;
            }
        }
        return this.d.a((ArrayList) arrayList, (ArrayList) arrayList2, this.a, this.b, this.c);
    }
}
