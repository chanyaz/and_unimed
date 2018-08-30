package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@Class(creator = "CacheEntryParcelCreator")
@Reserved({1})
public final class zzhi extends AbstractSafeParcelable {
    public static final Creator<zzhi> CREATOR = new ahr();
    @Nullable
    @GuardedBy("this")
    @Field(getter = "getContentFileDescriptor", id = 2)
    private ParcelFileDescriptor a;

    public zzhi() {
        this(null);
    }

    @Constructor
    public zzhi(@Nullable @Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.a = parcelFileDescriptor;
    }

    private final synchronized ParcelFileDescriptor c() {
        return this.a;
    }

    public final synchronized boolean a() {
        return this.a != null;
    }

    @Nullable
    public final synchronized InputStream b() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.a != null) {
                inputStream = new AutoCloseInputStream(this.a);
                this.a = null;
            }
        }
        return inputStream;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, c(), i, false);
        a.a(parcel, a);
    }
}
