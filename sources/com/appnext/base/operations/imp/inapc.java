package com.appnext.base.operations.imp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.k;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class inapc extends e {
    private Context mContext = d.getContext();

    public inapc(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected a bD() {
        return a.JSONArray;
    }

    protected List<b> getData() {
        List<ApplicationInfo> a = k.a(this.mContext.getPackageManager(), 0);
        HashMap hashMap = new HashMap();
        for (ApplicationInfo applicationInfo : a) {
            try {
                List aa = com.appnext.base.a.a.aM().aO().aa(applicationInfo.packageName);
                if (aa.size() > 0) {
                    int intValue = ((com.appnext.base.a.b.a) aa.get(0)).aW().intValue();
                    if (hashMap.get(Integer.valueOf(intValue)) == null) {
                        hashMap.put(Integer.valueOf(intValue), Integer.valueOf(1));
                    } else {
                        hashMap.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) hashMap.get(Integer.valueOf(intValue))).intValue() + 1));
                    }
                }
            } catch (Throwable th) {
                com.appnext.base.b.a(th);
            }
        }
        if (hashMap == null || hashMap.isEmpty() || hashMap == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("categoryId", ((Integer) entry.getKey()).intValue());
                jSONObject.put("value", ((Integer) entry.getValue()).intValue());
                jSONArray.put(jSONObject);
            } catch (Throwable th2) {
                return null;
            }
        }
        List<b> arrayList = new ArrayList();
        arrayList.add(new b(inapc.class.getSimpleName(), jSONArray.toString(), a.JSONArray.getType()));
        return arrayList;
    }

    public boolean hasPermission() {
        return true;
    }
}
