package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.f;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@zzadh
public final class ke {
    private static Object a = new Object();
    @GuardedBy("sLock")
    private static boolean b = false;
    @GuardedBy("sLock")
    private static boolean c = false;
    private static Clock d = f.a();
    private static final Set<String> e = new HashSet(Arrays.asList(new String[0]));
    private final List<String> f;

    public ke() {
        this(null);
    }

    public ke(@Nullable String str) {
        List asList;
        if (c()) {
            String uuid = UUID.randomUUID().toString();
            String[] strArr;
            String str2;
            String valueOf;
            if (str == null) {
                strArr = new String[1];
                str2 = "network_request_";
                valueOf = String.valueOf(uuid);
                strArr[0] = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
                asList = Arrays.asList(strArr);
            } else {
                strArr = new String[2];
                str2 = "ad_request_";
                valueOf = String.valueOf(str);
                strArr[0] = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
                str2 = "network_request_";
                valueOf = String.valueOf(uuid);
                strArr[1] = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
                asList = Arrays.asList(strArr);
            }
        } else {
            asList = new ArrayList();
        }
        this.f = asList;
    }

    public static void a() {
        synchronized (a) {
            b = false;
            c = false;
            kk.e("Ad debug logging enablement is out of date.");
        }
    }

    static final /* synthetic */ void a(int i, Map map, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        a(jsonWriter, map);
        jsonWriter.endObject();
    }

    private static void a(JsonWriter jsonWriter, @Nullable Map<String, ?> map) {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (!e.contains(str)) {
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            kk.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str2 : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(str2);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void a(String str, zzand zzand) {
        Writer stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(d.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.f) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzand.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (Throwable e) {
            kk.b("unable to log", e);
        }
        c(stringWriter.toString());
    }

    static final /* synthetic */ void a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        a(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(c.a(bArr));
        }
        jsonWriter.endObject();
    }

    public static void a(boolean z) {
        synchronized (a) {
            b = true;
            c = z;
        }
    }

    public static boolean a(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) akc.f().a(amn.bh)).booleanValue()) {
            return false;
        }
        try {
            return Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Throwable e) {
            kk.c("Fail to determine debug setting.", e);
            return false;
        }
    }

    private final void b(@Nullable String str) {
        a("onNetworkRequestError", new kj(str));
    }

    private final void b(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        a("onNetworkRequest", new kf(str, str2, map, bArr));
    }

    private final void b(@Nullable Map<String, ?> map, int i) {
        a("onNetworkResponse", new kh(i, map));
    }

    public static boolean b() {
        boolean z;
        synchronized (a) {
            z = b;
        }
        return z;
    }

    private static synchronized void c(String str) {
        synchronized (ke.class) {
            kk.d("GMA Debug BEGIN");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < str.length()) {
                    String str2 = "GMA Debug CONTENT ";
                    String valueOf = String.valueOf(str.substring(i2, Math.min(i2 + 4000, str.length())));
                    kk.d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    i = i2 + 4000;
                } else {
                    kk.d("GMA Debug FINISH");
                }
            }
        }
    }

    public static boolean c() {
        boolean z;
        synchronized (a) {
            z = b && c;
        }
        return z;
    }

    public final void a(@Nullable String str) {
        if (c() && str != null) {
            a(str.getBytes());
        }
    }

    public final void a(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (c()) {
            b(str, str2, map, bArr);
        }
    }

    public final void a(HttpURLConnection httpURLConnection, int i) {
        String str = null;
        if (c()) {
            b(httpURLConnection.getHeaderFields() == null ? str : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String str2 = "Can not get error message from error HttpURLConnection\n";
                    String valueOf = String.valueOf(e.getMessage());
                    kk.e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                b(str);
            }
        }
    }

    public final void a(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (c()) {
            b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void a(@Nullable Map<String, ?> map, int i) {
        if (c()) {
            b(map, i);
            if (i < 200 || i >= 300) {
                b(null);
            }
        }
    }

    public final void a(byte[] bArr) {
        a("onNetworkResponseBody", new ki(bArr));
    }
}
