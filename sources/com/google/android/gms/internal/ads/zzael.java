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
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
@Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@Reserved({1})
@ParametersAreNonnullByDefault
public final class zzael extends AbstractSafeParcelable {
    public static final Creator<zzael> CREATOR = new ct();
    @Field(id = 2)
    public final boolean a;
    @Nullable
    @Field(id = 3)
    public final List<String> b;

    public zzael() {
        this(false, Collections.emptyList());
    }

    @Constructor
    public zzael(@Param(id = 2) boolean z, @Param(id = 3) List<String> list) {
        this.a = z;
        this.b = list;
    }

    @Nullable
    public static zzael a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzael();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Throwable e) {
                    kk.c("Error grabbing url from json.", e);
                }
            }
        }
        return new zzael(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a);
        a.b(parcel, 3, this.b, false);
        a.a(parcel, a);
    }
}
