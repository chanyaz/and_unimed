package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.h;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class acapc extends acap {
    public acapc(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected a bD() {
        return a.JSONArray;
    }

    protected String bI() {
        return acapc.class.getSimpleName();
    }

    protected List<b> c(List<b> list) {
        List<b> c = super.c(list);
        if (c == null || c.isEmpty()) {
            return null;
        }
        b bVar;
        Map hashMap = new HashMap();
        for (b bVar2 : c) {
            List aa = com.appnext.base.a.a.aM().aO().aa(h.cD().aC(bVar2.aY()));
            if (aa.size() > 0) {
                Integer aW = ((com.appnext.base.a.b.a) aa.get(0)).aW();
                if (hashMap.containsKey(aW)) {
                    hashMap.put(aW, Integer.valueOf(((Integer) hashMap.get(aW)).intValue() + 1));
                } else {
                    hashMap.put(aW, Integer.valueOf(1));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("category", entry.getKey());
                jSONObject.put("appcount", entry.getValue());
            } catch (Throwable th) {
                com.appnext.base.b.a(th);
            }
            jSONArray.put(jSONObject);
        }
        bVar2 = new b(acapc.class.getSimpleName(), acapc.class.getSimpleName(), h.cD().aB(jSONArray.toString()), new Date(), a.JSONArray.getType());
        List<b> arrayList = new ArrayList();
        arrayList.add(bVar2);
        return arrayList.isEmpty() ? null : arrayList;
    }
}
