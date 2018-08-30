package com.appnext.ads.fullscreen;

import com.appnext.core.r;
import java.util.HashMap;

public class c extends r {
    private static c dO;
    private String bW = "https://cdn.appnext.com/tools/sdk/config/2.3.0/fullscreen_config.txt";
    private HashMap<String, String> bq = null;

    private c() {
    }

    public static synchronized c aj() {
        c cVar;
        synchronized (c.class) {
            if (dO == null) {
                dO = new c();
            }
            cVar = dO;
        }
        return cVar;
    }

    protected HashMap<String, String> D() {
        return this.bq;
    }

    protected HashMap<String, String> E() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("can_close", "true");
        hashMap.put("show_close", "true");
        hashMap.put("video_length", "15");
        hashMap.put("mute", "false");
        hashMap.put("urlApp_protection", "false");
        hashMap.put("pview", "true");
        hashMap.put("min_internet_connection_video", "3g");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("resolve_timeout", "8");
        hashMap.put("fq_control", "false");
        hashMap.put("num_saved_videos", "5");
        hashMap.put("caption_text_time", "3");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("gdpr", "false");
        return hashMap;
    }

    public void b(HashMap<String, String> hashMap) {
        this.bq = hashMap;
    }

    protected String getUrl() {
        return this.bW;
    }

    public void setUrl(String str) {
        this.bW = str;
    }
}
