package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.Closeable;

@KeepName
@Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR = new c();
    private static final b k = new d(new String[0], null);
    @VersionField(id = 1000)
    private final int a;
    @Field(getter = "getColumns", id = 1)
    private final String[] b;
    private Bundle c;
    @Field(getter = "getWindows", id = 2)
    private final CursorWindow[] d;
    @Field(getter = "getStatusCode", id = 3)
    private final int e;
    @Field(getter = "getMetadata", id = 4)
    private final Bundle f;
    private int[] g;
    private int h;
    private boolean i = false;
    private boolean j = true;

    public class DataHolderException extends RuntimeException {
    }

    @Constructor
    DataHolder(@Param(id = 1000) int i, @Param(id = 1) String[] strArr, @Param(id = 2) CursorWindow[] cursorWindowArr, @Param(id = 3) int i2, @Param(id = 4) Bundle bundle) {
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    public final void a() {
        int i;
        int i2 = 0;
        this.c = new Bundle();
        for (i = 0; i < this.b.length; i++) {
            this.c.putInt(this.b[i], i);
        }
        this.g = new int[this.d.length];
        i = 0;
        while (i2 < this.d.length) {
            this.g[i2] = i;
            i += this.d[i2].getNumRows() - (i - this.d[i2].getStartPosition());
            i2++;
        }
        this.h = i;
    }

    public final int b() {
        return this.e;
    }

    public final Bundle c() {
        return this.f;
    }

    public final void close() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                for (CursorWindow close : this.d) {
                    close.close();
                }
            }
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    protected final void finalize() {
        try {
            if (this.j && this.d.length > 0 && !d()) {
                close();
                String obj = toString();
                Log.e("DataBuffer", new StringBuilder(String.valueOf(obj).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(obj).append(")").toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.b, false);
        a.a(parcel, 2, this.d, i, false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, c(), false);
        a.a(parcel, 1000, this.a);
        a.a(parcel, a);
        if ((i & 1) != 0) {
            close();
        }
    }
}
