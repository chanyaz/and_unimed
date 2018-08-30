package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class d {
    int a;
    c b;
    c c;
    Interpolator d;
    ArrayList<c> e = new ArrayList();

    public d(c... cVarArr) {
        this.a = cVarArr.length;
        this.e.addAll(Arrays.asList(cVarArr));
        this.b = (c) this.e.get(0);
        this.c = (c) this.e.get(this.a - 1);
        this.d = this.c.b();
    }

    /* renamed from: a */
    public d clone() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        c[] cVarArr = new c[size];
        for (int i = 0; i < size; i++) {
            cVarArr[i] = ((c) arrayList.get(i)).clone();
        }
        return new d(cVarArr);
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.a) {
            String str2 = str + ((c) this.e.get(i)).a() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
