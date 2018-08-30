package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

public class c {
    private static final ClassLoader a = c.class.getClassLoader();

    private c() {
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
