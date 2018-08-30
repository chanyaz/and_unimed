package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Locale;

@Class(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {
    public static final Creator<WebImage> CREATOR = new g();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getUrl", id = 2)
    private final Uri b;
    @Field(getter = "getWidth", id = 3)
    private final int c;
    @Field(getter = "getHeight", id = 4)
    private final int d;

    @Constructor
    WebImage(@Param(id = 1) int i, @Param(id = 2) Uri uri, @Param(id = 3) int i2, @Param(id = 4) int i3) {
        this.a = i;
        this.b = uri;
        this.c = i2;
        this.d = i3;
    }

    public final Uri a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return ap.a(this.b, webImage.b) && this.c == webImage.c && this.d == webImage.d;
    }

    public final int hashCode() {
        return ap.a(this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a(), i, false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, c());
        a.a(parcel, a);
    }
}
