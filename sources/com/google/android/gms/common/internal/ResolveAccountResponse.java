package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new at();
    @VersionField(id = 1)
    private final int a;
    @Field(id = 2)
    private IBinder b;
    @Field(getter = "getConnectionResult", id = 3)
    private ConnectionResult c;
    @Field(getter = "getSaveDefaultAccount", id = 4)
    private boolean d;
    @Field(getter = "isFromCrossClientAuth", id = 5)
    private boolean e;

    @Constructor
    ResolveAccountResponse(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder, @Param(id = 3) ConnectionResult connectionResult, @Param(id = 4) boolean z, @Param(id = 5) boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public IAccountAccessor a() {
        return aa.a(this.b);
    }

    public ConnectionResult b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.c.equals(resolveAccountResponse.c) && a().equals(resolveAccountResponse.a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, b(), i, false);
        a.a(parcel, 4, c());
        a.a(parcel, 5, d());
        a.a(parcel, a);
    }
}
