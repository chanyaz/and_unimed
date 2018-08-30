package com.appnext.banners;

import com.appnext.core.g;
import java.util.Random;
import org.json.JSONArray;

public class h {
    public static String M(String str) {
        int i = 0;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int nextInt = new Random(System.nanoTime()).nextInt(100);
            int i2 = 0;
            while (i < jSONArray.length()) {
                i2 += jSONArray.getJSONObject(i).getInt("p");
                if (nextInt < i2) {
                    return jSONArray.getJSONObject(i).getString("id");
                }
                i++;
            }
        } catch (Throwable th) {
            g.c(th);
        }
        return "";
    }
}
