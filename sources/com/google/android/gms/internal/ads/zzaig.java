package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import org.json.JSONArray;
import org.json.JSONException;

@zzadh
@Class(creator = "RewardItemParcelCreator")
@Reserved({1})
public final class zzaig extends AbstractSafeParcelable {
    public static final Creator<zzaig> CREATOR = new fw();
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    public final int b;

    public zzaig(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @Constructor
    public zzaig(@Param(id = 2) String str, @Param(id = 3) int i) {
        this.a = str;
        this.b = i;
    }

    @Nullable
    public static zzaig a(@Nullable String str) {
        zzaig zzaig = null;
        if (TextUtils.isEmpty(str)) {
            return zzaig;
        }
        try {
            return a(new JSONArray(str));
        } catch (JSONException e) {
            return zzaig;
        }
    }

    @Nullable
    public static zzaig a(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new zzaig(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaig)) {
            return false;
        }
        zzaig zzaig = (zzaig) obj;
        return ap.a(this.a, zzaig.a) && ap.a(Integer.valueOf(this.b), Integer.valueOf(zzaig.b));
    }

    public final int hashCode() {
        return ap.a(this.a, Integer.valueOf(this.b));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, a);
    }
}
