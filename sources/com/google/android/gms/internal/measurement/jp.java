package com.google.android.gms.internal.measurement;

import android.util.Log;

final class jp extends jj<Boolean> {
    jp(jt jtVar, String str, Boolean bool) {
        super(jtVar, str, bool, null);
    }

    protected final /* synthetic */ Object a(String str) {
        if (jf.a.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (jf.b.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.a;
        Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(str).length()).append("Invalid boolean value for ").append(str2).append(": ").append(str).toString());
        return null;
    }
}
