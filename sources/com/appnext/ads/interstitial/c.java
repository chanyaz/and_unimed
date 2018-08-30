package com.appnext.ads.interstitial;

import com.appnext.core.r;
import java.util.HashMap;

public class c extends r {
    private static c fe;
    private String bW = "https://cdn.appnext.com/tools/sdk/config/2.3.0/interstitial_config.txt";
    private HashMap<String, String> bq = null;

    private c() {
    }

    public static synchronized c ax() {
        c cVar;
        synchronized (c.class) {
            if (fe == null) {
                fe = new c();
            }
            cVar = fe;
        }
        return cVar;
    }

    protected HashMap<String, String> D() {
        return this.bq;
    }

    protected HashMap<String, String> E() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("creative", Interstitial.TYPE_MANAGED);
        hashMap.put("auto_play", "true");
        hashMap.put("mute", "false");
        hashMap.put("pview", "true");
        hashMap.put("min_internet_connection", "2g");
        hashMap.put("min_internet_connection_video", "3g");
        hashMap.put("urlApp_protection", "false");
        hashMap.put("can_close", "false");
        hashMap.put("video_length", "15");
        hashMap.put("button_text", "");
        hashMap.put("button_color", "");
        hashMap.put("skip_title", "");
        hashMap.put("remove_poster_on_auto_play", "true");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("show_rating", "true");
        hashMap.put("show_desc", "true");
        hashMap.put("new_button_text", "Install");
        hashMap.put("existing_button_text", "Open");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("fq_control", "false");
        hashMap.put("resolve_timeout", "8");
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
