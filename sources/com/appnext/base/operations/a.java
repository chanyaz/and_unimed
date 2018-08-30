package com.appnext.base.operations;

import android.os.Bundle;
import android.util.Pair;
import com.appnext.base.a.b.c;
import com.appnext.base.a.c.d;
import com.appnext.base.b.b;
import com.appnext.base.b.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private final String TAG = a.class.getSimpleName();
    protected c gP;

    public a(c cVar, Bundle bundle) {
        this.gP = cVar;
    }

    private void a(Map<String, String> map) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String key = this.gP.getKey();
        i.cE().putLong(key + i.jZ, valueOf.longValue());
        b.a(key, (Map) map);
    }

    private void by() {
        if (bx()) {
            d.bG().a(this);
        }
    }

    private JSONObject d(com.appnext.base.a.b.b bVar) {
        return b.a(bVar.aY(), bVar.aZ(), com.appnext.base.b.c.a.valueOf(bVar.getDataType()));
    }

    private void d(List<String> list) {
        if (list != null && !list.isEmpty()) {
            d bA = bA();
            for (String ad : list) {
                bA.ad(ad);
            }
        }
    }

    protected long b(List<com.appnext.base.a.b.b> list) {
        try {
            JSONArray a = b.a((List) list, true);
            return (a == null || a.length() <= 0) ? -1 : bA().a(a);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return -1;
        }
    }

    protected d bA() {
        return com.appnext.base.a.a.aM().aP();
    }

    public abstract void bB();

    public abstract void bC();

    protected com.appnext.base.b.c.a bD() {
        return com.appnext.base.b.c.a.String;
    }

    protected void bs() {
        try {
            i.cE().putLong(this.gP.getKey() + i.jY, System.currentTimeMillis());
            List data = getData();
            if (!(data == null || data.isEmpty())) {
                b(data);
            }
            b.au(this.gP.getKey());
            if (bz()) {
                Map bu = bu();
                if (!(bu == null || bu.isEmpty())) {
                    a(bu);
                }
            }
            by();
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    protected List<com.appnext.base.a.b.b> bt() {
        return bA().af(this.gP.getKey());
    }

    protected Map<String, String> bu() {
        List bt = bt();
        if (bt == null || bt.isEmpty()) {
            return null;
        }
        List<com.appnext.base.a.b.b> c = c(bt);
        if (c == null || c.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (com.appnext.base.a.b.b bVar : c) {
            Pair pair = new Pair(bVar.aX(), bVar.getType());
            if (hashMap.containsKey(pair)) {
                ((JSONArray) hashMap.get(pair)).put(d(bVar));
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(d(bVar));
                hashMap.put(pair, jSONArray);
            }
        }
        HashMap c2 = c(hashMap);
        hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (Entry entry : c2.entrySet()) {
            String str = (String) ((Pair) entry.getKey()).second;
            hashMap.put(str, ((JSONArray) entry.getValue()).toString());
            arrayList.add(str);
        }
        b.at(this.gP.getKey());
        d(arrayList);
        b.as(this.gP.getKey());
        return hashMap;
    }

    protected boolean bv() {
        return true;
    }

    protected c bw() {
        return this.gP;
    }

    protected boolean bx() {
        return true;
    }

    protected boolean bz() {
        return b.c(this.gP);
    }

    protected HashMap<Pair<String, String>, JSONArray> c(HashMap<Pair<String, String>, JSONArray> hashMap) {
        return hashMap;
    }

    protected List<com.appnext.base.a.b.b> c(List<com.appnext.base.a.b.b> list) {
        return list;
    }

    protected abstract List<com.appnext.base.a.b.b> getData();

    protected Date getDate() {
        return new Date();
    }

    public boolean hasPermission() {
        return true;
    }
}
