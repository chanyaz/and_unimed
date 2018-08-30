package com.appnext.ads.fullscreen;

import com.appnext.core.r;
import java.util.HashMap;

public class f extends r {
    private static f er;
    private String bW = "https://cdn.appnext.com/tools/sdk/config/2.3.0/rewarded_config.txt";
    private HashMap<String, String> bq = null;

    private f() {
    }

    public static synchronized f al() {
        f fVar;
        synchronized (f.class) {
            if (er == null) {
                er = new f();
            }
            fVar = er;
        }
        return fVar;
    }

    protected HashMap<String, String> D() {
        return this.bq;
    }

    protected HashMap<String, String> E() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("can_close", "false");
        hashMap.put("show_close", "false");
        hashMap.put("video_length", "15");
        hashMap.put("mute", "false");
        hashMap.put("urlApp_protection", "false");
        hashMap.put("pview", "true");
        hashMap.put("min_internet_connection_video", "3g");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("default_mode", "normal");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("resolve_timeout", "8");
        hashMap.put("fq_control", "false");
        hashMap.put("num_saved_videos", "5");
        hashMap.put("caption_text_time", "3");
        hashMap.put("pre_title_string1", "Which Ad");
        hashMap.put("pre_title_string2", "Would you like to watch?");
        hashMap.put("pre_cta_string", "Play this ad");
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
