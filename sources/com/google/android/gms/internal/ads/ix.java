package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzadh
public final class ix {
    private final String[] a;
    private final double[] b;
    private final double[] c;
    private final int[] d;
    private int e;

    private ix(ja jaVar) {
        int size = jaVar.b.size();
        this.a = (String[]) jaVar.a.toArray(new String[size]);
        this.b = a(jaVar.b);
        this.c = a(jaVar.c);
        this.d = new int[size];
        this.e = 0;
    }

    /* synthetic */ ix(ja jaVar, iy iyVar) {
        this(jaVar);
    }

    private static double[] a(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = ((Double) list.get(i2)).doubleValue();
            i = i2 + 1;
        }
    }

    public final List<iz> a() {
        List<iz> arrayList = new ArrayList(this.a.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.length) {
                return arrayList;
            }
            arrayList.add(new iz(this.a[i2], this.c[i2], this.b[i2], ((double) this.d[i2]) / ((double) this.e), this.d[i2]));
            i = i2 + 1;
        }
    }

    public final void a(double d) {
        this.e++;
        int i = 0;
        while (i < this.c.length) {
            if (this.c[i] <= d && d < this.b[i]) {
                int[] iArr = this.d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
