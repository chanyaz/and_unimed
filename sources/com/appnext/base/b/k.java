package com.appnext.base.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.operations.d;
import com.appnext.base.operations.imp.cdm;
import com.appnext.base.operations.imp.rcd;
import com.appnext.base.services.OperationService;
import com.appnext.base.services.ReceiverService;
import com.appnext.core.g;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpRetryException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class k {
    private static final String TAG = "SdkHelper";
    public static final int ku = 120000;
    private static final long kv = 1000;
    private static final long kw = 60000;
    private static final long kx = 3600000;
    private static final long ky = 86400000;
    private static Random kz = new Random();

    public static long a(int i, int i2, int i3, int i4) {
        return c(i, i2) + (((long) (kz.nextInt(i3 + i4) - i3)) * kv);
    }

    public static Location a(double d, double d2, float f) {
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        location.setAccuracy(f);
        return location;
    }

    public static Object a(String str, a aVar) {
        try {
            List ae = com.appnext.base.a.a.aM().aP().ae(str);
            if (!(ae == null || ae.isEmpty())) {
                return b(((b) ae.get(0)).aY(), aVar);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String a(Date date) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.US).format(date));
        stringBuilder.append(" ");
        stringBuilder.append(cO());
        stringBuilder.append(" ");
        stringBuilder.append(new SimpleDateFormat("yyyy", Locale.US).format(date));
        return stringBuilder.toString();
    }

    public static List<ApplicationInfo> a(PackageManager packageManager, int i) {
        List<ApplicationInfo> arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
            if (applicationInfo != null && (applicationInfo.flags & 1) == i) {
                arrayList.add(applicationInfo);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, Class cls, long j, c cVar) {
        if (context != null && cVar != null && cls != null) {
            long i = c.ju.equalsIgnoreCase(cVar.bc()) ? ky : i(cVar.bb(), cVar.bc());
            if (i != -1) {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                Intent intent = new Intent(context, cls);
                intent.putExtra(c.jn, cVar.getKey());
                int hashCode = cVar.bf().hashCode();
                l.k(" *** alarm *** ", String.valueOf(cVar.bf()));
                PendingIntent service = PendingIntent.getService(context, hashCode, intent, 134217728);
                if (!cVar.bg()) {
                    alarmManager.setInexactRepeating(1, j, i, service);
                } else if (VERSION.SDK_INT >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(0, j, service);
                } else if (VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(0, j, service);
                } else {
                    alarmManager.set(0, j, service);
                }
                alarmManager.setInexactRepeating(1, j, i, service);
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, int i2) {
        String num = Integer.toString(i2);
        for (int i3 = 0; i3 < i - num.length(); i3++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(num);
    }

    public static boolean a(Class cls) {
        try {
            return d.getContext().getPackageManager().queryIntentServices(new Intent(d.getContext(), cls), 65536).size() > 0;
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }

    public static boolean a(String str, String str2, c cVar) {
        Object obj = -1;
        try {
            switch (str2.hashCode()) {
                case 570418373:
                    if (str2.equals(c.jw)) {
                        obj = null;
                        break;
                    }
                    break;
                case 1852089416:
                    if (str2.equals(c.jt)) {
                        int obj2 = 1;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    return ((com.appnext.base.operations.a) Class.forName(d.getOperationClassName(str)).getConstructor(new Class[]{c.class, Bundle.class}).newInstance(new Object[]{cVar, null})).hasPermission();
                case 1:
                    return ((com.appnext.base.receivers.c) Class.forName(ReceiverService.getOperationClassName(str)).getConstructor(new Class[0]).newInstance(new Object[0])).hasPermission();
                default:
                    return false;
            }
        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();
            com.appnext.base.b.a(e.getCause());
            return false;
        } catch (ClassNotFoundException e2) {
            return false;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return false;
        }
    }

    public static long aF(String str) {
        return i.cE().getLong(str + i.jY, 0);
    }

    public static String aG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return i.cE().getString(str + i.kb, null);
    }

    public static Object b(String str, a aVar) {
        try {
            switch (aVar) {
                case Integer:
                    return Integer.valueOf(str);
                case Double:
                    return Double.valueOf(str);
                case Long:
                    return Long.valueOf(str);
                case Boolean:
                    return Boolean.valueOf(str);
                case Set:
                    return new HashSet(Arrays.asList(str.split(",")));
                case JSONArray:
                    return new JSONArray(str);
                case JSONObject:
                    return new JSONObject(str);
                default:
                    return str;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public static void b(String str, List<b> list) {
        Intent intent = new Intent(d.getContext(), OperationService.class);
        intent.putExtra(c.jn, str);
        JSONArray a = b.a((List) list, false);
        if (a != null && a.length() != 0) {
            intent.putExtra("data", a.toString());
            intent.putExtra(c.jD, rcd.class.getSimpleName());
            a(d.getContext(), intent);
        }
    }

    public static boolean b(String str, Map<String, String> map) {
        c av = e.cy().av(str);
        if (av == null || c.jy.equalsIgnoreCase(av.ba())) {
            return true;
        }
        if (map.isEmpty()) {
            return true;
        }
        String str2 = c.cv() + "/data";
        HashMap hashMap = new HashMap();
        Object u = g.u(d.getContext());
        if (TextUtils.isEmpty(u)) {
            u = i.cE().getString(i.kc, "");
        }
        if (TextUtils.isEmpty(u)) {
            return false;
        }
        hashMap.put("aid", u);
        hashMap.put("cuid", u + "_" + System.currentTimeMillis());
        hashMap.put("lvid", "4.6.9");
        try {
            hashMap.put("localdate", a(new Date()));
            hashMap.put("timezone", cO());
            hashMap.put("app_package", d.getPackageName());
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            hashMap.put("app_package", "");
        }
        String str3 = "";
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), (String) entry.getValue());
        }
        l.k(str, "-------Sending to server data for key = " + str + " ----------");
        for (Entry entry2 : hashMap.entrySet()) {
            l.k(str, "---- " + ((String) entry2.getKey()) + " : " + ((String) entry2.getValue()) + " ----");
        }
        try {
            byte[] a = g.a(str2, hashMap, false, c.jm, a.HashMap);
            if (a != null) {
                l.k(str, "result send data: " + new String(a, "UTF-8"));
            }
            return true;
        } catch (HttpRetryException e) {
            l.n(str, "(Type:HttpRetryException)" + e.getMessage() + "  " + e.responseCode());
            return false;
        } catch (Throwable th2) {
            l.n(str, "(Type:Throwable) " + th2.getMessage());
            return false;
        }
    }

    public static long c(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        if (new Date().after(instance.getTime())) {
            instance.add(5, 1);
        }
        return instance.getTimeInMillis();
    }

    public static void cN() {
        ActivityManager activityManager = (ActivityManager) d.getContext().getSystemService("activity");
        d.getContext().getPackageManager();
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                Log.e("Running app", "Name : - " + runningAppProcessInfo.processName + " Importance - " + runningAppProcessInfo.importance + " Lru - " + runningAppProcessInfo.lru + " LastTrimLevel - " + runningAppProcessInfo.lastTrimLevel + " ImportanceReasonCode - " + runningAppProcessInfo.importanceReasonCode + " importanceReasonComponent - " + runningAppProcessInfo.importanceReasonComponent);
            }
        }
    }

    public static String cO() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        int i = (instance.get(16) + instance.get(15)) / 60000;
        char c = '+';
        if (i < 0) {
            c = '-';
            i = -i;
        }
        StringBuilder stringBuilder = new StringBuilder(9);
        stringBuilder.append("GMT");
        stringBuilder.append(c);
        a(stringBuilder, 2, i / 60);
        stringBuilder.append(':');
        a(stringBuilder, 2, i % 60);
        return stringBuilder.toString();
    }

    public static void d(String str, String str2, a aVar) {
        List arrayList = new ArrayList();
        arrayList.add(new b(str, str2, aVar.getType()));
        b(str, arrayList);
    }

    public static void e(String str, String str2, a aVar) {
        com.appnext.base.a.a.aM().aP().b(new b(str, str2, aVar.getType()));
    }

    public static long i(String str, String str2) {
        try {
            if (!TextUtils.isDigitsOnly(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return 0;
            }
            long parseLong = Long.parseLong(str);
            return c.ju.equalsIgnoreCase(str2) ? str.length() == 4 ? a(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(2, 4)), 60, 60) : -1 : c.jo.equalsIgnoreCase(str2) ? kv * parseLong : c.jp.equalsIgnoreCase(str2) ? kw * parseLong : c.jq.equalsIgnoreCase(str2) ? kx * parseLong : c.jr.equalsIgnoreCase(str2) ? ky * parseLong : -1;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return -1;
        }
    }

    public static void j(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            i.cE().putString(str + i.kb, str2);
        }
    }

    public static List<String> m(Context context) {
        List<String> arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT < 21) {
                if (f.g(d.getContext(), "android.permission.GET_TASKS")) {
                    List runningTasks = activityManager.getRunningTasks(3);
                    if (!(runningTasks == null || runningTasks.isEmpty())) {
                        arrayList.add(((RunningTaskInfo) runningTasks.get(0)).baseActivity.getPackageName());
                    }
                }
                return arrayList;
            }
            if (VERSION.SDK_INT >= 21 && n(context.getApplicationContext())) {
                UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
                long currentTimeMillis = System.currentTimeMillis();
                List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(4, currentTimeMillis - 300000, currentTimeMillis);
                if (queryUsageStats == null) {
                    return arrayList;
                }
                ListIterator listIterator = queryUsageStats.listIterator();
                while (listIterator.hasNext()) {
                    UsageStats usageStats = (UsageStats) listIterator.next();
                    if (VERSION.SDK_INT >= 23 && usageStatsManager.isAppInactive(usageStats.getPackageName())) {
                        listIterator.remove();
                    }
                }
                if (queryUsageStats.size() > 0) {
                    SortedMap treeMap = new TreeMap();
                    for (UsageStats usageStats2 : queryUsageStats) {
                        treeMap.put(Long.valueOf(usageStats2.getLastTimeUsed()), usageStats2);
                    }
                    if (!treeMap.isEmpty()) {
                        arrayList.add(((UsageStats) treeMap.get(treeMap.lastKey())).getPackageName());
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    @TargetApi(21)
    public static boolean n(Context context) {
        return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    public static void o(Context context) {
        try {
            List bm = com.appnext.base.a.a.aM().aR().bm();
            if (bm == null || bm.size() != 0) {
                com.appnext.base.a.aI().a(com.appnext.base.a.a.aM().aR().bm());
                com.appnext.base.a.aI().aJ();
                return;
            }
            com.appnext.base.a.a.aM().aR().a(new JSONObject("{ \"status\": \"on\", \"sample\": \"1\", \"sample_type\": \"hour\", \"cycle\": \"1\", \"cycle_type\": \"interval\", \"exact\": \"false\", \"key\": \"cdm\" }"));
            Intent intent = new Intent(context, OperationService.class);
            intent.putExtra(c.jn, cdm.class.getSimpleName());
            a(context, intent);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    public static boolean p(Context context) {
        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        return advertisingIdInfo != null && advertisingIdInfo.isLimitAdTrackingEnabled();
    }

    public static boolean q(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            return advertisingIdInfo == null || advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            l.n(TAG, th.toString());
            return true;
        }
    }
}
