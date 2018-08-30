package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zs extends zr<FieldDescriptorType, Object> {
    zs(int i) {
        super(i, null);
    }

    public final void a() {
        if (!b()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= c()) {
                    break;
                }
                Entry b = b(i2);
                if (((zzbbi) b.getKey()).zzada()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
                i = i2 + 1;
            }
            for (Entry entry : d()) {
                if (((zzbbi) entry.getKey()).zzada()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
