package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.k;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@VisibleForTesting
public final class cj {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static double a(String str, double d) {
        double d2 = 100.0d;
        if (str == null) {
            return d2;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return d2;
        }
    }

    public static long a(String str) {
        long j = 0;
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static jd a(bt btVar, String str) {
        ar.a((Object) btVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            String str2 = "?";
            String valueOf = String.valueOf(str);
            Map a = k.a(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
            jd jdVar = new jd();
            jdVar.e((String) a.get("utm_content"));
            jdVar.c((String) a.get("utm_medium"));
            jdVar.a((String) a.get("utm_campaign"));
            jdVar.b((String) a.get("utm_source"));
            jdVar.d((String) a.get("utm_term"));
            jdVar.f((String) a.get("utm_id"));
            jdVar.g((String) a.get("anid"));
            jdVar.h((String) a.get("gclid"));
            jdVar.i((String) a.get("dclid"));
            jdVar.j((String) a.get("aclid"));
            return jdVar;
        } catch (URISyntaxException e) {
            btVar.d("No valid campaign data found", e);
            return null;
        }
    }

    public static String a(Locale locale) {
        if (locale == null) {
            return null;
        }
        Object language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase(locale));
        }
        return stringBuilder.toString();
    }

    public static String a(boolean z) {
        return z ? "1" : "0";
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void a(Map<String, String> map, String str, Map<String, String> map2) {
        a((Map) map, str, (String) map2.get(str));
    }

    public static void a(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? "1" : "0");
        }
    }

    public static boolean a(double d, String str) {
        if (d <= 0.0d || d >= 100.0d) {
            return false;
        }
        int i;
        if (TextUtils.isEmpty(str)) {
            i = 1;
        } else {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return ((double) (i % 10000)) >= 100.0d * d;
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 0);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            return (receiverInfo == null || !receiverInfo.enabled) ? false : !z || receiverInfo.exported;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(String str, boolean z) {
        return (str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) ? true : (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) ? false : true;
    }

    public static MessageDigest b(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    public static void b(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty((CharSequence) map.get(str))) {
            map.put(str, str2);
        }
    }

    public static boolean c(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }
}
