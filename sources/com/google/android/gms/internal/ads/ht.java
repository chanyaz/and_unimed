package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.appnext.base.b.c;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.p;
import com.mopub.mobileads.VastIconXmlManager;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class ht {
    public static final Handler a = new hm(Looper.getMainLooper());
    private final Object b = new Object();
    private boolean c = true;
    @GuardedBy("mLock")
    private String d;
    private boolean e = false;
    private boolean f = false;
    @GuardedBy("this")
    private Pattern g;
    @GuardedBy("this")
    private Pattern h;

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    @VisibleForTesting
    public static Bundle a(agt agt) {
        if (agt == null) {
            return null;
        }
        if (!((Boolean) akc.f().a(amn.W)).booleanValue()) {
            if (!((Boolean) akc.f().a(amn.Y)).booleanValue()) {
                return null;
            }
        }
        if (au.i().l().b() && au.i().l().d()) {
            return null;
        }
        String b;
        String c;
        String str;
        if (agt.d()) {
            agt.c();
        }
        ago b2 = agt.b();
        if (b2 != null) {
            b = b2.b();
            c = b2.c();
            String d = b2.d();
            if (b != null) {
                au.i().l().a(b);
            }
            if (d != null) {
                au.i().l().b(d);
                str = b;
                b = c;
                c = d;
            } else {
                str = b;
                b = c;
                c = d;
            }
        } else {
            b = null;
            str = au.i().l().c();
            c = au.i().l().e();
        }
        Bundle bundle = new Bundle(1);
        if (c != null) {
            if (((Boolean) akc.f().a(amn.Y)).booleanValue() && !au.i().l().d()) {
                bundle.putString("v_fp_vertical", c);
            }
        }
        if (str != null) {
            if (((Boolean) akc.f().a(amn.W)).booleanValue() && !au.i().l().b()) {
                bundle.putString("fingerprint", str);
                if (!str.equals(b)) {
                    bundle.putString("v_fp", b);
                }
            }
        }
        return !bundle.isEmpty() ? bundle : null;
    }

    public static DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static WebResourceResponse a(HttpURLConnection httpURLConnection) {
        String trim;
        au.e();
        Object contentType = httpURLConnection.getContentType();
        String trim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        au.e();
        contentType = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType)) {
            String[] split = contentType.split(";");
            if (split.length != 1) {
                for (int i = 1; i < split.length; i++) {
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            trim = split2[1].trim();
                            break;
                        }
                    }
                }
            }
        }
        trim = "";
        Map headerFields = httpURLConnection.getHeaderFields();
        Map hashMap = new HashMap(headerFields.size());
        for (Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return au.g().a(trim2, trim, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static PopupWindow a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static String a(Context context, View view, zzjn zzjn) {
        if (!((Boolean) akc.f().a(amn.ak)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(VastIconXmlManager.WIDTH, zzjn.e);
            jSONObject2.put(VastIconXmlManager.HEIGHT, zzjn.b);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", l(context));
            if (!zzjn.d) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", i);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            kk.c("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public static String a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public static String a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static Map<String, String> a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : au.g().a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    private final JSONArray a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            a(jSONArray, a);
        }
        return jSONArray;
    }

    private final JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @TargetApi(18)
    public static void a(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) akc.f().a(amn.cL)).booleanValue()) {
                b(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            kk.b(new StringBuilder(String.valueOf(uri2).length() + 26).append("Opening ").append(uri2).append(" in a new browser.").toString());
        } catch (Throwable e) {
            kk.b("No browser is found.", e);
        }
    }

    public static void a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        a(context, str, arrayList);
    }

    public static void a(Context context, String str, List<String> list) {
        for (String jpVar : list) {
            new jp(context, str, jpVar).zznt();
        }
    }

    public static void a(Context context, Throwable th) {
        if (context != null) {
            boolean booleanValue;
            try {
                booleanValue = ((Boolean) akc.f().a(amn.c)).booleanValue();
            } catch (IllegalStateException e) {
                booleanValue = false;
            }
            if (booleanValue) {
                CrashUtils.a(context, th);
            }
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            hr.a(runnable);
        }
    }

    private final void a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(a((Collection) obj));
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            JSONArray jSONArray2 = new JSONArray();
            for (Object a : objArr) {
                a(jSONArray2, a);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    @VisibleForTesting
    private static boolean a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @TargetApi(24)
    public static boolean a(Activity activity, Configuration configuration) {
        akc.a();
        int a = kb.a((Context) activity, configuration.screenHeightDp);
        int a2 = kb.a((Context) activity, configuration.screenWidthDp);
        DisplayMetrics a3 = a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = a3.heightPixels;
        int i2 = a3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        identifier = ((Integer) akc.f().a(amn.cX)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return a(i, dimensionPixelSize + a, identifier) && a(i2, a2, identifier);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity == null || resolveActivity.activityInfo == null) {
                kk.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
                return false;
            }
            boolean z;
            String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
            if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
                kk.e(String.format(str, new Object[]{"keyboard"}));
                z = false;
            } else {
                z = true;
            }
            if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                kk.e(String.format(str, new Object[]{"keyboardHidden"}));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                kk.e(String.format(str, new Object[]{"orientation"}));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                kk.e(String.format(str, new Object[]{"screenLayout"}));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
                kk.e(String.format(str, new Object[]{"uiMode"}));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & c.jk) == 0) {
                kk.e(String.format(str, new Object[]{"screenSize"}));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
                return z;
            }
            kk.e(String.format(str, new Object[]{"smallestScreenSize"}));
            return false;
        } catch (Throwable e) {
            kk.c("Could not verify that com.google.android.gms.ads.AdActivity is declared in AndroidManifest.xml", e);
            au.i().a(e, "AdUtil.hasAdActivity");
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        return com.google.android.gms.common.a.c.b(context).a(str, context.getPackageName()) == 0;
    }

    public static boolean a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return z;
        }
    }

    public static int[] a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return e();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            kk.e(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public static Bitmap b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap f = f(view);
        return f == null ? e(view) : f;
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    @TargetApi(18)
    public static void b(Context context, Intent intent) {
        if (intent != null && p.f()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void b(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Throwable e) {
            kk.b("Error writing to file in internal storage.", e);
        }
    }

    public static Bundle c() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) akc.f().a(amn.C)).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) akc.f().a(amn.D)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", au.i().k());
        } catch (Throwable e) {
            kk.c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    @Nullable
    public static WebResourceResponse c(Context context, String str, String str2) {
        Throwable e;
        try {
            Map hashMap = new HashMap();
            hashMap.put("User-Agent", au.e().b(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = (String) new jb(context).a(str2, hashMap).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException e2) {
            e = e2;
            kk.c("Could not fetch MRAID JS.", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            kk.c("Could not fetch MRAID JS.", e);
            return null;
        } catch (InterruptedException e4) {
            e = e4;
            kk.c("Could not fetch MRAID JS.", e);
            return null;
        } catch (TimeoutException e5) {
            e = e5;
            kk.c("Could not fetch MRAID JS.", e);
            return null;
        }
        return null;
    }

    public static String c(Context context, String str) {
        try {
            return new String(l.a(context.openFileInput(str), true), "UTF-8");
        } catch (IOException e) {
            kk.b("Error reading from internal storage.");
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0014  */
    public static boolean c(android.view.View r4) {
        /*
        r2 = 0;
        r1 = 0;
        r0 = r4.getRootView();
        if (r0 == 0) goto L_0x0016;
    L_0x0008:
        r0 = r0.getContext();
        r3 = r0 instanceof android.app.Activity;
        if (r3 == 0) goto L_0x0016;
    L_0x0010:
        r0 = (android.app.Activity) r0;
    L_0x0012:
        if (r0 != 0) goto L_0x0018;
    L_0x0014:
        r0 = r1;
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = r2;
        goto L_0x0012;
    L_0x0018:
        r0 = r0.getWindow();
        if (r0 != 0) goto L_0x002a;
    L_0x001e:
        r0 = r2;
    L_0x001f:
        if (r0 == 0) goto L_0x002f;
    L_0x0021:
        r0 = r0.flags;
        r2 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x002f;
    L_0x0028:
        r0 = 1;
        goto L_0x0015;
    L_0x002a:
        r0 = r0.getAttributes();
        goto L_0x001f;
    L_0x002f:
        r0 = r1;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ht.c(android.view.View):boolean");
    }

    public static boolean c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static int d(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    private static String d() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuilder.append(" ").append(VERSION.RELEASE);
        }
        stringBuilder.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuilder.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuilder.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuilder.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuilder.toString();
    }

    @VisibleForTesting
    protected static String d(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable th) {
            return d();
        }
    }

    public static Builder e(Context context) {
        return new Builder(context);
    }

    private static Bitmap e(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                kk.e("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            kk.b("Fail to capture the webview", e);
            return null;
        }
    }

    private static int[] e() {
        return new int[]{0, 0};
    }

    private static Bitmap f(@NonNull View view) {
        Bitmap drawingCache;
        Throwable e;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            drawingCache = view.getDrawingCache();
            drawingCache = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                kk.b("Fail to capture the web view", e);
                return drawingCache;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            drawingCache = null;
            e = th;
            kk.b("Fail to capture the web view", e);
            return drawingCache;
        }
        return drawingCache;
    }

    public static alz f(Context context) {
        return new alz(context);
    }

    public static boolean g(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (powerManager == null ? false : powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static Bitmap h(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bitmap f;
        try {
            if (((Boolean) akc.f().a(amn.bS)).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    f = f(window.getDecorView().getRootView());
                }
                f = null;
            } else {
                f = e(((Activity) context).getWindow().getDecorView());
            }
        } catch (Throwable e) {
            kk.b("Fail to capture screen shot", e);
        }
        return f;
    }

    public static int i(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    @TargetApi(16)
    public static boolean j(Context context) {
        if (context == null || !p.d()) {
            return false;
        }
        KeyguardManager m = m(context);
        return m != null && m.isKeyguardLocked();
    }

    public static boolean k(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            kk.b("Error loading class.", th);
            au.i().a(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    private static String l(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    @Nullable
    private static KeyguardManager m(Context context) {
        Object systemService = context.getSystemService("keyguard");
        return (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
    }

    public final JSONObject a(@Nullable Bundle bundle, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (bundle == null) {
            return jSONObject2;
        }
        try {
            return a(bundle);
        } catch (Throwable e) {
            kk.b("Error converting Bundle to JSON", e);
            return jSONObject2;
        }
    }

    public final JSONObject a(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                a(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public final void a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(b(context, str));
    }

    public final void a(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            au.e();
            bundle.putString("device", b());
            bundle.putString("eids", TextUtils.join(",", amn.a()));
        }
        akc.a();
        kb.a(context, str, str2, bundle, z, new hw(this, context, str));
    }

    public final void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final void a(Context context, List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(abx.a((Activity) context))) {
            return;
        }
        if (list == null) {
            hl.a("Cannot ping urls: empty list.");
        } else if (ani.a(context)) {
            ani ani = new ani();
            ani.a(new hu(this, list, ani, context));
            ani.b((Activity) context);
        } else {
            hl.a("Cannot ping url because custom tabs is not supported");
        }
    }

    public final boolean a(View view, Context context) {
        PowerManager powerManager = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        }
        return a(view, powerManager, m(context));
    }

    public final boolean a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        boolean z2;
        if (!au.e().c) {
            if (keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) {
                if (!(((Boolean) akc.f().a(amn.bo)).booleanValue() && c(view))) {
                    z = false;
                    if (view.getVisibility() == 0 && view.isShown()) {
                        z2 = powerManager != null || powerManager.isScreenOn();
                        if (z2 && z) {
                            if (!((Boolean) akc.f().a(amn.bm)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        z = true;
        if (powerManager != null) {
        }
        return true;
    }

    public final String b(Context context, String str) {
        String str2;
        synchronized (this.b) {
            if (this.d != null) {
                str2 = this.d;
            } else if (str == null) {
                str2 = d();
            } else {
                try {
                    this.d = au.g().a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.d)) {
                    akc.a();
                    if (kb.b()) {
                        this.d = d(context);
                    } else {
                        this.d = null;
                        a.post(new hv(this, context));
                        while (this.d == null) {
                            try {
                                this.b.wait();
                            } catch (InterruptedException e2) {
                                this.d = d();
                                String str3 = "Interrupted, use default user agent: ";
                                str2 = String.valueOf(this.d);
                                kk.e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            }
                        }
                    }
                }
                str2 = String.valueOf(this.d);
                this.d = new StringBuilder((String.valueOf(str2).length() + 10) + String.valueOf(str).length()).append(str2).append(" (Mobile; ").append(str).toString();
                try {
                    if (com.google.android.gms.common.a.c.b(context).a()) {
                        this.d = String.valueOf(this.d).concat(";aia");
                    }
                } catch (Throwable e3) {
                    au.i().a(e3, "AdUtil.getUserAgent");
                }
                this.d = String.valueOf(this.d).concat(")");
                str2 = this.d;
            }
        }
        return str2;
    }

    public final void b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) akc.f().a(amn.br)).booleanValue()) {
            a(context, str, str2, bundle, z);
        }
    }

    public final boolean b(Context context) {
        if (this.e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new hy(this, null), intentFilter);
        this.e = true;
        return true;
    }

    public final int[] b(Activity activity) {
        int[] a = a(activity);
        r1 = new int[2];
        akc.a();
        r1[0] = kb.b((Context) activity, a[0]);
        akc.a();
        r1[1] = kb.b((Context) activity, a[1]);
        return r1;
    }

    public final boolean c(Context context) {
        if (this.f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new hx(this, null), intentFilter);
        this.f = true;
        return true;
    }

    public final int[] c(Activity activity) {
        Window window = activity.getWindow();
        int[] e = (window == null || window.findViewById(16908290) == null) ? e() : new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
        r1 = new int[2];
        akc.a();
        r1[0] = kb.b((Context) activity, e[0]);
        akc.a();
        r1[1] = kb.b((Context) activity, e[1]);
        return r1;
    }

    /* JADX WARNING: Missing block: B:9:0x0024, code:
            if (((java.lang.String) com.google.android.gms.internal.ads.akc.f().a(com.google.android.gms.internal.ads.amn.aq)).equals(r3.g.pattern()) == false) goto L_0x0026;
     */
    public final boolean d(java.lang.String r4) {
        /*
        r3 = this;
        r1 = 0;
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        r0 = r1;
    L_0x0008:
        return r0;
    L_0x0009:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0047 }
        r0 = r3.g;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0026;
    L_0x000e:
        r0 = com.google.android.gms.internal.ads.amn.aq;	 Catch:{ all -> 0x0044 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0044 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0044 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0044 }
        r2 = r3.g;	 Catch:{ all -> 0x0044 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0044 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0038;
    L_0x0026:
        r0 = com.google.android.gms.internal.ads.amn.aq;	 Catch:{ all -> 0x0044 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0044 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0044 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0044 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0044 }
        r3.g = r0;	 Catch:{ all -> 0x0044 }
    L_0x0038:
        r0 = r3.g;	 Catch:{ all -> 0x0044 }
        r0 = r0.matcher(r4);	 Catch:{ all -> 0x0044 }
        r0 = r0.matches();	 Catch:{ all -> 0x0044 }
        monitor-exit(r3);	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0044 }
        throw r0;	 Catch:{ PatternSyntaxException -> 0x0047 }
    L_0x0047:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ht.d(java.lang.String):boolean");
    }

    /* JADX WARNING: Missing block: B:9:0x0024, code:
            if (((java.lang.String) com.google.android.gms.internal.ads.akc.f().a(com.google.android.gms.internal.ads.amn.ar)).equals(r3.h.pattern()) == false) goto L_0x0026;
     */
    public final boolean e(java.lang.String r4) {
        /*
        r3 = this;
        r1 = 0;
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        r0 = r1;
    L_0x0008:
        return r0;
    L_0x0009:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0047 }
        r0 = r3.h;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0026;
    L_0x000e:
        r0 = com.google.android.gms.internal.ads.amn.ar;	 Catch:{ all -> 0x0044 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0044 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0044 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0044 }
        r2 = r3.h;	 Catch:{ all -> 0x0044 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0044 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0038;
    L_0x0026:
        r0 = com.google.android.gms.internal.ads.amn.ar;	 Catch:{ all -> 0x0044 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0044 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0044 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0044 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0044 }
        r3.h = r0;	 Catch:{ all -> 0x0044 }
    L_0x0038:
        r0 = r3.h;	 Catch:{ all -> 0x0044 }
        r0 = r0.matcher(r4);	 Catch:{ all -> 0x0044 }
        r0 = r0.matches();	 Catch:{ all -> 0x0044 }
        monitor-exit(r3);	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0044 }
        throw r0;	 Catch:{ PatternSyntaxException -> 0x0047 }
    L_0x0047:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ht.e(java.lang.String):boolean");
    }
}
