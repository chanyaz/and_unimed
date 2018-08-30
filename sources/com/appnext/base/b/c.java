package com.appnext.base.b;

import com.appnext.core.k;

public class c {
    public static final String PACKAGE_NAME = "com.appnext.sdk";
    public static final String jA = "com.appnext.sdk.ACTIVITIES_BROADCAST_ACTION";
    public static final String jB = "com.appnext.sdk.ACTIVITIES_EXTRA";
    public static final String jC = "data";
    public static final String jD = "action";
    public static final String jE = "before_time_remove_data";
    public static final String jF = "type";
    public static final String jG = "service_key";
    public static final String jH = "isAidDisabled";
    public static final int jI = 6;
    public static final int jJ = 70;
    public static final int jK = 50;
    public static final int jL = 25;
    public static final int jM = 100;
    public static final String jN = "wpul_driving_state_dmstat";
    public static final int jO = 150;
    public static final String jP = "aidForSend";
    public static final String jc = "4.6.9";
    public static final String jd = "config.json";
    public static final String je = "plist.json";
    public static final String jf = "/data/appnext/";
    public static final String jg = "videos/";
    public static final String jh = ".tmp";
    public static final String ji = "http://cdn.appnext.com/tools/services/4.6.9/config.json";
    public static final String jj = "http://cdn.appnext.com/tools/services/4.6.9/plist.json";
    public static final int jk = 1024;
    public static final long jl = 1048576;
    public static final int jm = 15000;
    public static final String jn = "config_data_obj";
    public static final String jo = "second";
    public static final String jp = "minute";
    public static final String jq = "hour";
    public static final String jr = "day";
    public static final String js = "month";
    public static final String jt = "monitoring";
    public static final String ju = "time";
    public static final String jv = "once";
    public static final String jw = "interval";
    public static final String jx = "on";
    public static final String jy = "off";
    public static final String jz = "com.appnext.sdk.DETECTED_ACTIVITIES";
    public static final long serialVersionUID = 3596288679259847957L;

    public enum a {
        String("String"),
        Long("Long"),
        Double("Double"),
        Integer("Integer"),
        HashMap("HashMap"),
        ArrayList("ArrayList"),
        Boolean("Boolean"),
        JSONArray("JSONArray"),
        JSONObject("JSONObject"),
        Set("Set");
        
        private String mDataType;

        private a(String str) {
            this.mDataType = str;
        }

        public String getType() {
            return this.mDataType;
        }
    }

    public static final String cv() {
        return k.lZ;
    }

    public static final String cw() {
        return k.ma;
    }
}
