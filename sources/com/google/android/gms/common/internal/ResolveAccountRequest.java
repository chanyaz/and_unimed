package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "ResolveAccountRequestCreator")
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new as();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getAccount", id = 2)
    private final Account b;
    @Field(getter = "getSessionId", id = 3)
    private final int c;
    @Field(getter = "getSignInAccountHint", id = 4)
    private final GoogleSignInAccount d;

    @Constructor
    ResolveAccountRequest(@Param(id = 1) int i, @Param(id = 2) Account account, @Param(id = 3) int i2, @Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.a = i;
        this.b = account;
        this.c = i2;
        this.d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    @Nullable
    public GoogleSignInAccount c() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a(), i, false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, c(), i, false);
        a.a(parcel, a);
    }
}
