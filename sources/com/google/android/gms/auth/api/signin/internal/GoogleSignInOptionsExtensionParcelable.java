package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension.TypeId;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new a();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getType", id = 2)
    private int b;
    @Field(getter = "getBundle", id = 3)
    private Bundle c;

    @Constructor
    GoogleSignInOptionsExtensionParcelable(@Param(id = 1) int i, @TypeId @Param(id = 2) int i2, @Param(id = 3) Bundle bundle) {
        this.a = i;
        this.b = i2;
        this.c = bundle;
    }

    @TypeId
    public int a() {
        return this.b;
    }

    public Bundle b() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a());
        a.a(parcel, 3, b(), false);
        a.a(parcel, a);
    }
}
