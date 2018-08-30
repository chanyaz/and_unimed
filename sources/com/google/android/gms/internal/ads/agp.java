package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class agp {
    private final Object a = new Object();
    private int b;
    private List<ago> c = new LinkedList();

    @Nullable
    public final ago a() {
        ago ago = null;
        int i = 0;
        synchronized (this.a) {
            ago ago2;
            if (this.c.size() == 0) {
                kk.b("Queue empty");
                return null;
            } else if (this.c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (ago ago22 : this.c) {
                    ago ago3;
                    int i4;
                    int i5 = ago22.i();
                    if (i5 > i2) {
                        i = i5;
                        ago3 = ago22;
                        i4 = i3;
                    } else {
                        i4 = i;
                        ago3 = ago;
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    ago = ago3;
                    i = i4;
                }
                this.c.remove(i);
                return ago;
            } else {
                ago22 = (ago) this.c.get(0);
                ago22.e();
                return ago22;
            }
        }
    }

    public final boolean a(ago ago) {
        boolean z;
        synchronized (this.a) {
            if (this.c.contains(ago)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean b(ago ago) {
        synchronized (this.a) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ago ago2 = (ago) it.next();
                if (!((Boolean) akc.f().a(amn.W)).booleanValue() || au.i().l().b()) {
                    if (((Boolean) akc.f().a(amn.Y)).booleanValue() && !au.i().l().d() && ago != ago2 && ago2.d().equals(ago.d())) {
                        it.remove();
                        return true;
                    }
                } else if (ago != ago2 && ago2.b().equals(ago.b())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void c(ago ago) {
        synchronized (this.a) {
            if (this.c.size() >= 10) {
                kk.b("Queue is full, current size = " + this.c.size());
                this.c.remove(0);
            }
            int i = this.b;
            this.b = i + 1;
            ago.a(i);
            this.c.add(ago);
        }
    }
}
