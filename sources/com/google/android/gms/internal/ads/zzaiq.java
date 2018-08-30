package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzadh
@Class(creator = "SafeBrowsingConfigParcelCreator")
@Reserved({1})
public final class zzaiq extends AbstractSafeParcelable {
    public static final Creator<zzaiq> CREATOR = new gf();
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    public final String b;
    @Field(id = 4)
    public final boolean c;
    @Field(id = 5)
    public final boolean d;
    @Field(id = 6)
    public final List<String> e;
    @Field(id = 7)
    public final boolean f;
    @Field(id = 8)
    public final boolean g;
    @Field(id = 9)
    public final List<String> h;

    @Constructor
    public zzaiq(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) List<String> list, @Param(id = 7) boolean z3, @Param(id = 8) boolean z4, @Param(id = 9) List<String> list2) {
        List list22;
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = list;
        this.f = z3;
        this.g = z4;
        if (list22 == null) {
            list22 = new ArrayList();
        }
        this.h = list22;
    }

    @Nullable
    public static zzaiq a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new zzaiq(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), jl.a(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), jl.a(jSONObject.optJSONArray("webview_permissions"), null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b, false);
        a.a(parcel, 4, this.c);
        a.a(parcel, 5, this.d);
        a.b(parcel, 6, this.e, false);
        a.a(parcel, 7, this.f);
        a.a(parcel, 8, this.g);
        a.b(parcel, 9, this.h, false);
        a.a(parcel, a);
    }
}
