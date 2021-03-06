package com.google.android.gms.internal.measurement;

import android.util.Log;

final class jq extends jj<Double> {
    jq(jt jtVar, String str, Double d) {
        super(jtVar, str, d, null);
    }

    private final Double b(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            String str2 = this.a;
            Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(str2).length() + 27) + String.valueOf(str).length()).append("Invalid double value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
