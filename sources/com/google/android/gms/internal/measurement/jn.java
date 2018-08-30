package com.google.android.gms.internal.measurement;

import android.util.Log;

final class jn extends jj<Long> {
    jn(jt jtVar, String str, Long l) {
        super(jtVar, str, l, null);
    }

    private final Long b(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            String str2 = this.a;
            Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(str2).length() + 25) + String.valueOf(str).length()).append("Invalid long value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
