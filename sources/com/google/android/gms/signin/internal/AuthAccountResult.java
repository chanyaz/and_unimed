package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "AuthAccountResultCreator")
public class AuthAccountResult extends AbstractSafeParcelable implements Result {
    public static final Creator<AuthAccountResult> CREATOR = new a();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getConnectionResultCode", id = 2)
    private int b;
    @Field(getter = "getRawAuthResolutionIntent", id = 3)
    private Intent c;

    public AuthAccountResult() {
        this(0, null);
    }

    @Constructor
    AuthAccountResult(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public int a() {
        return this.b;
    }

    public Intent b() {
        return this.c;
    }

    public Status getStatus() {
        return this.b == 0 ? Status.a : Status.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a());
        a.a(parcel, 3, b(), i, false);
        a.a(parcel, a);
    }
}
