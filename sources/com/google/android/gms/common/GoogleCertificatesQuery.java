package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery extends AbstractSafeParcelable {
    public static final Creator<GoogleCertificatesQuery> CREATOR = new j();
    @Field(getter = "getCallingPackage", id = 1)
    private final String a;
    @Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final i b;
    @Field(getter = "getAllowTestKeys", id = 3)
    private final boolean c;

    @Constructor
    GoogleCertificatesQuery(@Param(id = 1) String str, @Param(id = 2) @Nullable IBinder iBinder, @Param(id = 3) boolean z) {
        this.a = str;
        this.b = a(iBinder);
        this.c = z;
    }

    GoogleCertificatesQuery(String str, @Nullable i iVar, boolean z) {
        this.a = str;
        this.b = iVar;
        this.c = z;
    }

    @Nullable
    private static i a(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            i oVar;
            IObjectWrapper bytesWrapped = ac.a(iBinder).getBytesWrapped();
            byte[] bArr = bytesWrapped == null ? null : (byte[]) c.a(bytesWrapped);
            if (bArr != null) {
                oVar = new o(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                oVar = null;
            }
            return oVar;
        } catch (Throwable e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    @Nullable
    public IBinder b() {
        if (this.b != null) {
            return this.b.asBinder();
        }
        Log.w("GoogleCertificatesQuery", "certificate binder is null");
        return null;
    }

    public boolean c() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, a(), false);
        a.a(parcel, 2, b(), false);
        a.a(parcel, 3, c());
        a.a(parcel, a);
    }
}
