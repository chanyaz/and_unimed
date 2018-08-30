package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "AuthAccountRequestCreator")
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new d();
    @VersionField(id = 1)
    private final int a;
    @Field(id = 2)
    @Deprecated
    private final IBinder b;
    @Field(id = 3)
    private final Scope[] c;
    @Field(id = 4)
    private Integer d;
    @Field(id = 5)
    private Integer e;
    @Field(id = 6, type = "android.accounts.Account")
    private Account f;

    @Constructor
    AuthAccountRequest(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder, @Param(id = 3) Scope[] scopeArr, @Param(id = 4) Integer num, @Param(id = 5) Integer num2, @Param(id = 6) Account account) {
        this.a = i;
        this.b = iBinder;
        this.c = scopeArr;
        this.d = num;
        this.e = num2;
        this.f = account;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, this.c, i, false);
        a.a(parcel, 4, this.d, false);
        a.a(parcel, 5, this.e, false);
        a.a(parcel, 6, this.f, i, false);
        a.a(parcel, a);
    }
}
