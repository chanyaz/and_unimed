package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class zzbo implements Parcelable {
    @Deprecated
    public static final Creator<zzbo> CREATOR = new bb();
    private String a;
    private String b;
    private String c;

    @Deprecated
    zzbo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
