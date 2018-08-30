package com.puzzlersworld.android.util;

import android.util.Log;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class c {
    private DateFormat a = new SimpleDateFormat("EEE, dd-MMM-yyyy hh:mm:ss z");
    private HashMap b = new HashMap();

    private boolean a(String str, String str2) {
        return str == null || str.equals("/") || str2.regionMatches(0, str, 0, str.length());
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            return new Date().compareTo(this.a.parse(str)) <= 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Map map = (Map) this.b.get(str2);
            if (a((String) map.get("path"), str) && b((String) map.get("expires"))) {
                stringBuffer.append(str2);
                stringBuffer.append("=");
                stringBuffer.append((String) map.get(str2));
                if (it.hasNext()) {
                    stringBuffer.append("; ");
                }
            }
        }
        return stringBuffer.toString();
    }

    public HashMap a() {
        return this.b;
    }

    public void a(HashMap hashMap) {
        this.b = hashMap;
    }

    public void a(List<String> list) {
        if (list != null) {
            for (String str : list) {
                String str2;
                Log.d("AndroApp", "setCookie:" + str2);
                Map hashMap = new HashMap();
                StringTokenizer stringTokenizer = new StringTokenizer(str2, ";");
                if (stringTokenizer.hasMoreTokens()) {
                    str2 = stringTokenizer.nextToken();
                    String substring = str2.substring(0, str2.indexOf(61));
                    str2 = str2.substring(str2.indexOf(61) + 1, str2.length());
                    this.b.put(substring, hashMap);
                    hashMap.put(substring, str2);
                }
                while (stringTokenizer.hasMoreTokens()) {
                    str2 = stringTokenizer.nextToken();
                    if (str2.indexOf(61) != -1) {
                        hashMap.put(str2.substring(0, str2.indexOf(61)).toLowerCase(), str2.substring(str2.indexOf(61) + 1, str2.length()));
                    }
                }
            }
        }
    }

    public String toString() {
        return this.b.toString();
    }
}
