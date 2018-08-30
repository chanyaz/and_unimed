package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

@zzadh
@Class(creator = "CacheOfferingCreator")
@Reserved({1})
public final class zzhl extends AbstractSafeParcelable {
    public static final Creator<zzhl> CREATOR = new aht();
    @Nullable
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    private final long b;
    @Field(id = 4)
    private final String c;
    @Field(id = 5)
    private final String d;
    @Field(id = 6)
    private final String e;
    @Field(id = 7)
    private final Bundle f;
    @Field(id = 8)
    private final boolean g;
    @Field(id = 9)
    private long h;

    @Constructor
    zzhl(@Nullable @Param(id = 2) String str, @Param(id = 3) long j, @Param(id = 4) String str2, @Param(id = 5) String str3, @Param(id = 6) String str4, @Param(id = 7) Bundle bundle, @Param(id = 8) boolean z, @Param(id = 9) long j2) {
        this.a = str;
        this.b = j;
        if (str2 == null) {
            str2 = "";
        }
        this.c = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.d = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.e = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f = bundle;
        this.g = z;
        this.h = j2;
    }

    @Nullable
    public static zzhl a(Uri uri) {
        Throwable e;
        long j = 0;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                kk.e("Expected 2 path parts for namespace and id, found :" + pathSegments.size());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 != null) {
                j = Long.parseLong(queryParameter2);
            }
            Bundle bundle = new Bundle();
            for (String queryParameter22 : au.g().a(uri)) {
                if (queryParameter22.startsWith("tag.")) {
                    bundle.putString(queryParameter22.substring(4), uri.getQueryParameter(queryParameter22));
                }
            }
            return new zzhl(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException e2) {
            e = e2;
            kk.c("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            kk.c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Nullable
    public static zzhl a(String str) {
        return a(Uri.parse(str));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.c, false);
        a.a(parcel, 5, this.d, false);
        a.a(parcel, 6, this.e, false);
        a.a(parcel, 7, this.f, false);
        a.a(parcel, 8, this.g);
        a.a(parcel, 9, this.h);
        a.a(parcel, a);
    }
}
