package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "SignInResponseCreator")
public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new k();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult b;
    @Field(getter = "getResolveAccountResponse", id = 3)
    private final ResolveAccountResponse c;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    @Constructor
    SignInResponse(@Param(id = 1) int i, @Param(id = 2) ConnectionResult connectionResult, @Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.a = i;
        this.b = connectionResult;
        this.c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult a() {
        return this.b;
    }

    public ResolveAccountResponse b() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a(), i, false);
        a.a(parcel, 3, b(), i, false);
        a.a(parcel, a);
    }
}
