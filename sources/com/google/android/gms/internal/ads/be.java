package com.google.android.gms.internal.ads;

import android.support.v4.util.s;
import android.view.View;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
public final class be implements zzacd<ans> {
    private final boolean a;

    public be(boolean z) {
        this.a = z;
    }

    public final /* synthetic */ zzpb zza(am amVar, JSONObject jSONObject) {
        String valueOf;
        View view = null;
        int i = 0;
        s sVar = new s();
        s sVar2 = new s();
        Future a = amVar.a(jSONObject);
        zzanz a2 = amVar.a(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                sVar2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if ("image".equals(string)) {
                sVar.put(jSONObject2.getString("name"), amVar.a(jSONObject2, "image_value", this.a));
            } else {
                String str = "Unknown custom asset type: ";
                valueOf = String.valueOf(string);
                kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        zzaqw a3 = am.a(a2);
        valueOf = jSONObject.getString("custom_template_id");
        s sVar3 = new s();
        while (true) {
            int i3 = i;
            if (i3 >= sVar.size()) {
                break;
            }
            sVar3.put(sVar.b(i3), ((Future) sVar.c(i3)).get());
            i = i3 + 1;
        }
        anj anj = (anj) a.get();
        zzlo zztm = a3 != null ? a3.zztm() : null;
        if (a3 != null) {
            view = a3.getView();
        }
        return new ans(valueOf, sVar3, sVar2, anj, zztm, view);
    }
}
