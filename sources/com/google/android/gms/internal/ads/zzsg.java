package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@zzadh
@Class(creator = "HttpRequestParcelCreator")
public final class zzsg extends AbstractSafeParcelable {
    public static final Creator<zzsg> CREATOR = new aqi();
    @Field(id = 1)
    private final String a;
    @Field(id = 2)
    private final String[] b;
    @Field(id = 3)
    private final String[] c;

    @Constructor
    zzsg(@Param(id = 1) String str, @Param(id = 2) String[] strArr, @Param(id = 3) String[] strArr2) {
        this.a = str;
        this.b = strArr;
        this.c = strArr2;
    }

    public static zzsg a(apk apk) {
        Map b = apk.b();
        int size = b.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        size = 0;
        Iterator it = b.entrySet().iterator();
        while (true) {
            int i = size;
            if (!it.hasNext()) {
                return new zzsg(apk.e(), strArr, strArr2);
            }
            Entry entry = (Entry) it.next();
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            size = i + 1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a, false);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, this.c, false);
        a.a(parcel, a);
    }
}
