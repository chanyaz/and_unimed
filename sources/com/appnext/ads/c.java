package com.appnext.ads;

import com.appnext.core.g;
import java.util.Random;
import org.json.JSONArray;

public class c {
    public static String M(String str) {
        int i = 0;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int nextInt = new Random(System.nanoTime()).nextInt(100);
            g.X("TemplateRandomizer percent " + nextInt);
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
