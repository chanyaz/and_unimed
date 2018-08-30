package com.google.android.gms.analytics;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public class d extends f<d> {
    public d() {
        a("&t", "event");
    }

    public d a(String str) {
        a("&ec", str);
        return this;
    }

    public d b(String str) {
        a("&ea", str);
        return this;
    }

    public d c(String str) {
        a("&el", str);
        return this;
    }
}
