package com.google.android.gms.internal.measurement;

import android.util.Log;

final class jo extends jj<Integer> {
    jo(jt jtVar, String str, Integer num) {
        super(jtVar, str, num, null);
    }

    private final Integer b(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            String str2 = this.a;
            Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(str).length()).append("Invalid integer value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
