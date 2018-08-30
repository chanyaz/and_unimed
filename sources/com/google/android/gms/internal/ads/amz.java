package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class amz {
    private final Map<String, amy> a = new HashMap();
    @Nullable
    private final ana b;

    public amz(@Nullable ana ana) {
        this.b = ana;
    }

    @Nullable
    public final ana a() {
        return this.b;
    }

    public final void a(String str, amy amy) {
        this.a.put(str, amy);
    }

    public final void a(String str, String str2, long j) {
        ana ana = this.b;
        amy amy = (amy) this.a.get(str2);
        String[] strArr = new String[]{str};
        if (!(ana == null || amy == null)) {
            ana.a(amy, j, strArr);
        }
        Map map = this.a;
        ana ana2 = this.b;
        map.put(str, ana2 == null ? null : ana2.a(j));
    }
}
