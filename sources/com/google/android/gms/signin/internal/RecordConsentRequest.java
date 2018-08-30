package com.google.android.gms.signin.internal;

import android.accounts.Account;
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

@Class(creator = "RecordConsentRequestCreator")
public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new h();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getAccount", id = 2)
    private final Account b;
    @Field(getter = "getScopesToConsent", id = 3)
    private final Scope[] c;
    @Field(getter = "getServerClientId", id = 4)
    private final String d;

    @Constructor
    RecordConsentRequest(@Param(id = 1) int i, @Param(id = 2) Account account, @Param(id = 3) Scope[] scopeArr, @Param(id = 4) String str) {
        this.a = i;
        this.b = account;
        this.c = scopeArr;
        this.d = str;
    }

    public Account a() {
        return this.b;
    }

    public Scope[] b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a(), i, false);
        a.a(parcel, 3, b(), i, false);
        a.a(parcel, 4, c(), false);
        a.a(parcel, a);
    }
}
