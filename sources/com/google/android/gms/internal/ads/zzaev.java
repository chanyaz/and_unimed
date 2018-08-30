package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.l;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

@zzadh
@Class(creator = "LargeParcelTeleporterCreator")
@Reserved({1})
public final class zzaev extends AbstractSafeParcelable {
    public static final Creator<zzaev> CREATOR = new da();
    @Field(id = 2)
    private ParcelFileDescriptor a;
    private Parcelable b;
    private boolean c;

    @Constructor
    public zzaev(@Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.a = parcelFileDescriptor;
        this.b = null;
        this.c = true;
    }

    public zzaev(SafeParcelable safeParcelable) {
        this.a = null;
        this.b = safeParcelable;
        this.c = false;
    }

    private final ParcelFileDescriptor a() {
        if (this.a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.a = a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        return this.a;
    }

    private final <T> ParcelFileDescriptor a(byte[] bArr) {
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new cz(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            kk.b("Error transporting the ad response", e);
            au.i().a(e, "LargeParcelTeleporter.pipeData.2");
            l.a(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public final <T extends SafeParcelable> T a(Creator<T> creator) {
        if (this.c) {
            if (this.a == null) {
                kk.c("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.a));
            byte[] bArr;
            try {
                bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.b = (SafeParcelable) creator.createFromParcel(obtain);
                    this.c = false;
                } finally {
                    obtain.recycle();
                }
            } catch (IOException e) {
                bArr = e;
                kk.b("Could not read from parcel file descriptor", bArr);
                return null;
            } finally {
                l.a(dataInputStream);
            }
        }
        return (SafeParcelable) this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a();
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, i, false);
        a.a(parcel, a);
    }
}
