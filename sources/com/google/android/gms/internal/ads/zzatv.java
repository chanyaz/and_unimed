package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "GassResponseParcelCreator")
public final class zzatv extends AbstractSafeParcelable {
    public static final Creator<zzatv> CREATOR = new pr();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private wr b = null;
    private byte[] c;

    @Constructor
    zzatv(@Param(id = 1) int i, @Param(id = 2) byte[] bArr) {
        this.a = i;
        this.c = bArr;
        b();
    }

    private final void b() {
        if (this.b == null && this.c != null) {
            return;
        }
        if (this.b != null && this.c == null) {
            return;
        }
        if (this.b != null && this.c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.b == null && this.c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final wr a() {
        if ((this.b != null ? 1 : null) == null) {
            try {
                this.b = (wr) abj.a(new wr(), this.c);
                this.c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        b();
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.c != null ? this.c : abj.a(this.b), false);
        a.a(parcel, a);
    }
}
