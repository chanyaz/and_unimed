package com.appnext.base.operations.imp;

import android.os.Bundle;
import android.util.Pair;
import com.appnext.base.a.a;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.a.c.d;
import com.appnext.base.operations.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;

public class cd extends e {
    public cd(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected d bA() {
        return a.aM().aS();
    }

    protected List<b> bt() {
        return bA().bm();
    }

    protected boolean bz() {
        return true;
    }

    protected HashMap<Pair<String, String>, JSONArray> c(HashMap<Pair<String, String>, JSONArray> hashMap) {
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Pair pair = (Pair) entry.getKey();
            JSONArray jSONArray = (JSONArray) entry.getValue();
            c ac = a.aM().aR().ac((String) pair.first);
            if (ac != null && Integer.valueOf(ac.bd()).intValue() > jSONArray.length()) {
                it.remove();
            }
        }
        return hashMap;
    }

    protected List<b> getData() {
        return null;
    }

    public boolean hasPermission() {
        return true;
    }
}
