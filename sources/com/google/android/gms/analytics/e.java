package com.google.android.gms.analytics;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.cj;

@VisibleForTesting
public class e extends f<e> {
    public e() {
        a("&t", "exception");
    }

    public e a(String str) {
        a("&exd", str);
        return this;
    }

    public e a(boolean z) {
        a("&exf", cj.a(z));
        return this;
    }
}
