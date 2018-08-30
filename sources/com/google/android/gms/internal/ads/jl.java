package com.google.android.gms.internal.ads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

@zzadh
public final class jl {
    private static final zzamf<Map<String, ?>> a = new jm();

    @NonNull
    public static List<String> a(@Nullable JSONArray jSONArray, @Nullable List<String> list) {
        List<String> arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }
}
