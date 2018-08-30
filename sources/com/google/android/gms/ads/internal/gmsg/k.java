package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class k implements zzv<Object> {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private final Map<String, zzag> b = new HashMap();

    public final void a(String str, zzag zzag) {
        synchronized (this.a) {
            this.b.put(str, zzag);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2;
        Object obj3;
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (TextUtils.isEmpty(str4)) {
            obj2 = "Unknown Fail Reason.";
        } else {
            String obj22 = str3;
        }
        if (TextUtils.isEmpty(str4)) {
            obj3 = "";
        } else {
            String str6 = "\n";
            str3 = String.valueOf(str4);
            str4 = str3.length() != 0 ? str6.concat(str3) : new String(str6);
        }
        synchronized (this.a) {
            zzag zzag = (zzag) this.b.remove(str);
            if (zzag == null) {
                str2 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                kk.e(str.length() != 0 ? str2.concat(str) : new String(str2));
                return;
            } else if (!TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(obj22);
                str = String.valueOf(obj3);
                zzag.zzau(str.length() != 0 ? str2.concat(str) : new String(str2));
                return;
            } else if (str5 == null) {
                zzag.zzd(null);
                return;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (hl.a()) {
                        str4 = "Result GMSG: ";
                        str = String.valueOf(jSONObject.toString(2));
                        hl.a(str.length() != 0 ? str4.concat(str) : new String(str4));
                    }
                    zzag.zzd(jSONObject);
                } catch (JSONException e) {
                    zzag.zzau(e.getMessage());
                }
                return;
            }
        }
    }
}
