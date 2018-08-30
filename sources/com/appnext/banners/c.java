package com.appnext.banners;

import com.appnext.core.r;
import java.util.HashMap;

public class c extends r {
    private static c fF;

    private c() {
    }

    public static synchronized c aF() {
        c cVar;
        synchronized (c.class) {
            if (fF == null) {
                fF = new c();
            }
            cVar = fF;
        }
        return cVar;
    }

    protected HashMap<String, String> D() {
        return null;
    }

    protected HashMap<String, String> E() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("fq_control", "true");
        hashMap.put("urlApp_protection", "true");
        hashMap.put("resolve_timeout", "8");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("pview", "true");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("new_button_text", "Install");
        hashMap.put("existing_button_text", "Open");
        hashMap.put("gdpr", "false");
        return hashMap;
    }

    protected String getUrl() {
        return "https://cdn.appnext.com/tools/sdk/config/2.3.0/banner_config.txt";
    }
}
