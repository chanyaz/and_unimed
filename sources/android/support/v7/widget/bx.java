package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.ArrayList;

public class bx {
    SparseArray<by> a = new SparseArray();
    private int b = 0;

    private by b(int i) {
        by byVar = (by) this.a.get(i);
        if (byVar != null) {
            return byVar;
        }
        byVar = new by();
        this.a.put(i, byVar);
        return byVar;
    }

    long a(long j, long j2) {
        return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
    }

    @Nullable
    public ce a(int i) {
        by byVar = (by) this.a.get(i);
        if (byVar == null || byVar.a.isEmpty()) {
            return null;
        }
        ArrayList arrayList = byVar.a;
        return (ce) arrayList.remove(arrayList.size() - 1);
    }

    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                ((by) this.a.valueAt(i2)).a.clear();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    void a(int i, long j) {
        by b = b(i);
        b.c = a(b.c, j);
    }

    void a(bo boVar) {
        this.b++;
    }

    void a(bo boVar, bo boVar2, boolean z) {
        if (boVar != null) {
            b();
        }
        if (!z && this.b == 0) {
            a();
        }
        if (boVar2 != null) {
            a(boVar2);
        }
    }

    public void a(ce ceVar) {
        int itemViewType = ceVar.getItemViewType();
        ArrayList arrayList = b(itemViewType).a;
        if (((by) this.a.get(itemViewType)).b > arrayList.size()) {
            ceVar.q();
            arrayList.add(ceVar);
        }
    }

    boolean a(int i, long j, long j2) {
        long j3 = b(i).c;
        return j3 == 0 || j3 + j < j2;
    }

    void b() {
        this.b--;
    }

    void b(int i, long j) {
        by b = b(i);
        b.d = a(b.d, j);
    }

    boolean b(int i, long j, long j2) {
        long j3 = b(i).d;
        return j3 == 0 || j3 + j < j2;
    }
}
