package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class l extends r<l> {
    public String a;
    public boolean b;

    public final /* synthetic */ void a(r rVar) {
        l lVar = (l) rVar;
        if (!TextUtils.isEmpty(this.a)) {
            lVar.a = this.a;
        }
        if (this.b) {
            lVar.b = this.b;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.a);
        hashMap.put("fatal", Boolean.valueOf(this.b));
        return r.a((Object) hashMap);
    }
}
