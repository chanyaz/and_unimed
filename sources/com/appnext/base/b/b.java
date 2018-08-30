package com.appnext.base.b;

import android.text.TextUtils;
import com.appnext.base.a.b.c;
import com.appnext.base.a.c.d;
import com.appnext.base.b.c.a;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    public static String a(List<com.appnext.base.a.b.b> list, a aVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.appnext.base.a.b.b bVar : list) {
                if (bVar.aY() == null || bVar.aY().isEmpty()) {
                    return "";
                }
                jSONArray.put(a(bVar.aY(), bVar.aZ(), aVar));
            }
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
        return jSONArray.toString();
    }

    public static JSONArray a(List<com.appnext.base.a.b.b> list, boolean z) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.appnext.base.a.b.b bVar : list) {
                Object aY = bVar.aY();
                if (!aY.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.gD, bVar.aX());
                    jSONObject.put("type", bVar.getType());
                    String str = d.gE;
                    if (z) {
                        aY = h.cD().aB(aY);
                    }
                    jSONObject.put(str, aY);
                    jSONObject.put(d.gG, bVar.getDataType());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONObject a(String str, Date date, a aVar) {
        String aC = h.cD().aC(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", k.b(aC, aVar));
            jSONObject.put("date", k.a(date));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean a(String str, Map<String, String> map) {
        return k.b(str, (Map) map);
    }

    private static List<com.appnext.base.a.b.b> ar(String str) {
        List<com.appnext.base.a.b.b> list = null;
        try {
            return com.appnext.base.a.a.aM().aP().ae(str);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return list;
        }
    }

    public static boolean as(String str) {
        List ar = ar(str);
        return ar == null || ar.size() == 0;
    }

    public static void at(String str) {
        if (str != null) {
            i.cE().putInt(str + i.ka, 0);
        }
    }

    public static void au(String str) {
        i.cE().putLong(str + i.jY, System.currentTimeMillis());
        String str2 = str + i.ka;
        i.cE().putInt(str2, i.cE().getInt(str2, 0) + 1);
    }

    public static long c(String str, String str2, a aVar) {
        long j = -1;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return j;
        }
        try {
            return com.appnext.base.a.a.aM().aP().a(new com.appnext.base.a.b.b(str, str2, aVar.getType()));
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return j;
        }
    }

    public static long c(JSONArray jSONArray) {
        long j = -1;
        if (jSONArray == null) {
            return j;
        }
        try {
            return com.appnext.base.a.a.aM().aP().a(jSONArray);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return j;
        }
    }

    public static boolean c(c cVar) {
        if (cVar == null) {
            return false;
        }
        int i = i.cE().getInt(cVar.getKey() + i.ka, 0);
        try {
            return i >= Integer.parseInt(cVar.bd()) || i == 0;
        } catch (Throwable e) {
            com.appnext.base.b.a(e);
            return true;
        }
    }
}
