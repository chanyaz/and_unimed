package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "SignInRequestCreator")
public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR = new j();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getResolveAccountRequest", id = 2)
    private final ResolveAccountRequest b;

    @Constructor
    SignInRequest(@Param(id = 1) int i, @Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.a = i;
        this.b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest a() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a(), i, false);
        a.a(parcel, a);
    }
}
