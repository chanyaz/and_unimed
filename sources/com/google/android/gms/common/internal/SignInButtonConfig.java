package com.google.android.gms.common.internal;

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

@Class(creator = "SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new au();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getButtonSize", id = 2)
    private final int b;
    @Field(getter = "getColorScheme", id = 3)
    private final int c;
    @Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] d;

    @Constructor
    SignInButtonConfig(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) Scope[] scopeArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    @Deprecated
    public Scope[] c() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a());
        a.a(parcel, 3, b());
        a.a(parcel, 4, c(), i, false);
        a.a(parcel, a);
    }
}
