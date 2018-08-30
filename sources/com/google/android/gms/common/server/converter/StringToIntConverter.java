package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FieldConverter<String, Integer> {
    public static final Creator<StringToIntConverter> CREATOR = new b();
    @VersionField(id = 1)
    private final int a;
    private final HashMap<String, Integer> b;
    private final SparseArray<String> c;
    @Field(getter = "getSerializedMap", id = 2)
    private final ArrayList<Entry> d;

    @Class(creator = "StringToIntConverterEntryCreator")
    public final class Entry extends AbstractSafeParcelable {
        public static final Creator<Entry> CREATOR = new c();
        @Field(id = 2)
        final String a;
        @Field(id = 3)
        final int b;
        @VersionField(id = 1)
        private final int c;

        @Constructor
        Entry(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
            this.c = i;
            this.a = str;
            this.b = i2;
        }

        Entry(String str, int i) {
            this.c = 1;
            this.a = str;
            this.b = i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int a = a.a(parcel);
            a.a(parcel, 1, this.c);
            a.a(parcel, 2, this.a, false);
            a.a(parcel, 3, this.b);
            a.a(parcel, a);
        }
    }

    public StringToIntConverter() {
        this.a = 1;
        this.b = new HashMap();
        this.c = new SparseArray();
        this.d = null;
    }

    @Constructor
    StringToIntConverter(@Param(id = 1) int i, @Param(id = 2) ArrayList<Entry> arrayList) {
        this.a = i;
        this.b = new HashMap();
        this.c = new SparseArray();
        this.d = null;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            Entry entry = (Entry) obj;
            a(entry.a, entry.b);
        }
    }

    public final StringToIntConverter a(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
        this.c.put(i, str);
        return this;
    }

    /* renamed from: a */
    public final Integer convert(String str) {
        Integer num = (Integer) this.b.get(str);
        return num == null ? (Integer) this.b.get("gms_unknown") : num;
    }

    /* renamed from: a */
    public final String convertBack(Integer num) {
        String str = (String) this.c.get(num.intValue());
        return (str == null && this.b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int getTypeIn() {
        return 7;
    }

    public final int getTypeOut() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        List arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.b.get(str)).intValue()));
        }
        a.c(parcel, 2, arrayList, false);
        a.a(parcel, a);
    }
}
