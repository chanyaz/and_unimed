package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class ja {
    private final List<String> a = new ArrayList();
    private final List<Double> b = new ArrayList();
    private final List<Double> c = new ArrayList();

    public final ix a() {
        return new ix(this, null);
    }

    public final ja a(String str, double d, double d2) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.a.size()) {
                break;
            }
            double doubleValue = ((Double) this.c.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.b.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i2 = i + 1;
        }
        this.a.add(i, str);
        this.c.add(i, Double.valueOf(d));
        this.b.add(i, Double.valueOf(d2));
        return this;
    }
}
