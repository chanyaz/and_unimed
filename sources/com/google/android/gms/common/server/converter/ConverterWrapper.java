package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

@Class(creator = "ConverterWrapperCreator")
public class ConverterWrapper extends AbstractSafeParcelable {
    public static final Creator<ConverterWrapper> CREATOR = new a();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter b;

    @Constructor
    ConverterWrapper(@Param(id = 1) int i, @Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.a = i;
        this.b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.a = 1;
        this.b = stringToIntConverter;
    }

    public static ConverterWrapper a(FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public FieldConverter<?, ?> a() {
        if (this.b != null) {
            return this.b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, i, false);
        a.a(parcel, a);
    }
}
