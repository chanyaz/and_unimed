package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.e;
import com.google.android.gms.measurement.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class ie extends fo {
    private static final String[] a = new String[]{"firebase_", "google_", "ga_"};
    private SecureRandom b;
    private final AtomicLong c = new AtomicLong(0);
    private int d;
    private Integer e = null;

    ie(es esVar) {
        super(esVar);
    }

    public static is a(ir irVar, String str) {
        for (is isVar : irVar.c) {
            if (isVar.c.equals(str)) {
                return isVar;
            }
        }
        return null;
    }

    private static Object a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String a(String str, int i, boolean z) {
        return str.codePointCount(0, str.length()) > i ? z ? String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...") : null : str;
    }

    @Nullable
    public static String a(String str, String[] strArr, String[] strArr2) {
        ar.a((Object) strArr);
        ar.a((Object) strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (b(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void a(Bundle bundle, Object obj) {
        ar.a((Object) bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    public static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    private static boolean a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    static boolean a(zzeu zzeu, zzdz zzdz) {
        ar.a((Object) zzeu);
        ar.a((Object) zzdz);
        return !TextUtils.isEmpty(zzdz.b);
    }

    static boolean a(String str) {
        ar.a(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final boolean a(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzge().u().a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            int length;
            int i2;
            Object obj2;
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                length = parcelableArr.length;
                i2 = 0;
                while (i2 < length) {
                    obj2 = parcelableArr[i2];
                    if (obj2 instanceof Bundle) {
                        i2++;
                    } else {
                        zzge().u().a("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                length = arrayList.size();
                i2 = 0;
                while (i2 < length) {
                    obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzge().u().a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean a(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static Bundle[] a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    static is[] a(is[] isVarArr, String str, Object obj) {
        for (is isVar : isVarArr) {
            if (str.equals(isVar.c)) {
                isVar.e = null;
                isVar.d = null;
                isVar.f = null;
                if (obj instanceof Long) {
                    isVar.e = (Long) obj;
                    return isVarArr;
                } else if (obj instanceof String) {
                    isVar.d = (String) obj;
                    return isVarArr;
                } else if (!(obj instanceof Double)) {
                    return isVarArr;
                } else {
                    isVar.f = (Double) obj;
                    return isVarArr;
                }
            }
        }
        Object obj2 = new is[(isVarArr.length + 1)];
        System.arraycopy(isVarArr, 0, obj2, 0, isVarArr.length);
        is isVar2 = new is();
        isVar2.c = str;
        if (obj instanceof Long) {
            isVar2.e = (Long) obj;
        } else if (obj instanceof String) {
            isVar2.d = (String) obj;
        } else if (obj instanceof Double) {
            isVar2.f = (Double) obj;
        }
        obj2[isVarArr.length] = isVar2;
        return obj2;
    }

    public static Object b(ir irVar, String str) {
        is a = a(irVar, str);
        if (a != null) {
            if (a.d != null) {
                return a.d;
            }
            if (a.e != null) {
                return a.e;
            }
            if (a.f != null) {
                return a.f;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A:{Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A:{Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }} */
    public static java.lang.Object b(java.lang.Object r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x002e }
        r1.<init>();	 Catch:{ all -> 0x002e }
        r3 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x002e }
        r3.<init>(r1);	 Catch:{ all -> 0x002e }
        r3.writeObject(r5);	 Catch:{ all -> 0x0040 }
        r3.flush();	 Catch:{ all -> 0x0040 }
        r2 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x0040 }
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x0040 }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x0040 }
        r4.<init>(r1);	 Catch:{ all -> 0x0040 }
        r2.<init>(r4);	 Catch:{ all -> 0x0040 }
        r1 = r2.readObject();	 Catch:{ all -> 0x0043 }
        r3.close();	 Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
        r2.close();	 Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
        r0 = r1;
        goto L_0x0003;
    L_0x002e:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
    L_0x0031:
        if (r3 == 0) goto L_0x0036;
    L_0x0033:
        r3.close();	 Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
    L_0x0036:
        if (r2 == 0) goto L_0x003b;
    L_0x0038:
        r2.close();	 Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
    L_0x003b:
        throw r1;	 Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
    L_0x003c:
        r1 = move-exception;
        goto L_0x0003;
    L_0x003e:
        r1 = move-exception;
        goto L_0x0003;
    L_0x0040:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0031;
    L_0x0043:
        r1 = move-exception;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ie.b(java.lang.Object):java.lang.Object");
    }

    public static boolean b(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    @VisibleForTesting
    static long c(byte[] bArr) {
        long j = null;
        ar.a((Object) bArr);
        ar.a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    @VisibleForTesting
    private final boolean c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b = c.b(context).b(str, 64);
            if (!(b == null || b.signatures == null || b.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            zzge().r().a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzge().r().a("Package name not found", e2);
        }
        return true;
    }

    private final boolean c(String str, String str2) {
        if (str2 == null) {
            zzge().r().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().r().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().r().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzge().r().a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    static MessageDigest f(String str) {
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

    public static boolean h(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean j(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @WorkerThread
    static boolean k(String str) {
        ar.a(str);
        boolean z = true;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    z = false;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    z = true;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    private static int l(String str) {
        return "_ldl".equals(str) ? 2048 : "_id".equals(str) ? 256 : 36;
    }

    public final Bundle a(@NonNull Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            try {
                Object queryParameter;
                Object queryParameter2;
                Object queryParameter3;
                Object queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (!(TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4))) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("campaign", queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("source", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString("medium", queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("term", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("content", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("aclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("cp1", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("anid", queryParameter4);
                    }
                }
            } catch (UnsupportedOperationException e) {
                zzge().u().a("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a = a(str, bundle.get(str));
                if (a == null) {
                    zzge().u().a("Param value can't be null", k().b(str));
                } else {
                    a(bundle2, str, a);
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0133  */
    public final android.os.Bundle a(java.lang.String r10, android.os.Bundle r11, @android.support.annotation.Nullable java.util.List<java.lang.String> r12, boolean r13, boolean r14) {
        /*
        r9 = this;
        r0 = 0;
        if (r11 == 0) goto L_0x0174;
    L_0x0003:
        r7 = new android.os.Bundle;
        r7.<init>(r11);
        r0 = 0;
        r1 = r11.keySet();
        r8 = r1.iterator();
        r6 = r0;
    L_0x0012:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0173;
    L_0x0018:
        r2 = r8.next();
        r2 = (java.lang.String) r2;
        r0 = 0;
        if (r12 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r12.contains(r2);
        if (r1 != 0) goto L_0x003d;
    L_0x0027:
        if (r13 == 0) goto L_0x0032;
    L_0x0029:
        r0 = "event param";
        r0 = r9.a(r0, r2);
        if (r0 != 0) goto L_0x005b;
    L_0x0031:
        r0 = 3;
    L_0x0032:
        if (r0 != 0) goto L_0x003d;
    L_0x0034:
        r0 = "event param";
        r0 = r9.c(r0, r2);
        if (r0 != 0) goto L_0x0075;
    L_0x003c:
        r0 = 3;
    L_0x003d:
        if (r0 == 0) goto L_0x008f;
    L_0x003f:
        r1 = a(r7, r0);
        if (r1 == 0) goto L_0x0057;
    L_0x0045:
        r1 = 40;
        r3 = 1;
        r1 = a(r2, r1, r3);
        r3 = "_ev";
        r7.putString(r3, r1);
        r1 = 3;
        if (r0 != r1) goto L_0x0057;
    L_0x0054:
        a(r7, r2);
    L_0x0057:
        r7.remove(r2);
        goto L_0x0012;
    L_0x005b:
        r0 = "event param";
        r1 = 0;
        r0 = r9.a(r0, r1, r2);
        if (r0 != 0) goto L_0x0067;
    L_0x0064:
        r0 = 14;
        goto L_0x0032;
    L_0x0067:
        r0 = "event param";
        r1 = 40;
        r0 = r9.a(r0, r1, r2);
        if (r0 != 0) goto L_0x0073;
    L_0x0071:
        r0 = 3;
        goto L_0x0032;
    L_0x0073:
        r0 = 0;
        goto L_0x0032;
    L_0x0075:
        r0 = "event param";
        r1 = 0;
        r0 = r9.a(r0, r1, r2);
        if (r0 != 0) goto L_0x0081;
    L_0x007e:
        r0 = 14;
        goto L_0x003d;
    L_0x0081:
        r0 = "event param";
        r1 = 40;
        r0 = r9.a(r0, r1, r2);
        if (r0 != 0) goto L_0x008d;
    L_0x008b:
        r0 = 3;
        goto L_0x003d;
    L_0x008d:
        r0 = 0;
        goto L_0x003d;
    L_0x008f:
        r4 = r11.get(r2);
        r9.c();
        if (r14 == 0) goto L_0x00f4;
    L_0x0098:
        r1 = "param";
        r0 = r4 instanceof android.os.Parcelable[];
        if (r0 == 0) goto L_0x00e4;
    L_0x009e:
        r0 = r4;
        r0 = (android.os.Parcelable[]) r0;
        r0 = r0.length;
    L_0x00a2:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 <= r3) goto L_0x00f2;
    L_0x00a6:
        r3 = r9.zzge();
        r3 = r3.u();
        r5 = "Parameter array is too long; discarded. Value kind, name, array length";
        r0 = java.lang.Integer.valueOf(r0);
        r3.a(r5, r1, r2, r0);
        r0 = 0;
    L_0x00b8:
        if (r0 != 0) goto L_0x00f4;
    L_0x00ba:
        r0 = 17;
    L_0x00bc:
        if (r0 == 0) goto L_0x012d;
    L_0x00be:
        r1 = "_ev";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x012d;
    L_0x00c6:
        r0 = a(r7, r0);
        if (r0 == 0) goto L_0x00df;
    L_0x00cc:
        r0 = 40;
        r1 = 1;
        r0 = a(r2, r0, r1);
        r1 = "_ev";
        r7.putString(r1, r0);
        r0 = r11.get(r2);
        a(r7, r0);
    L_0x00df:
        r7.remove(r2);
        goto L_0x0012;
    L_0x00e4:
        r0 = r4 instanceof java.util.ArrayList;
        if (r0 == 0) goto L_0x00f0;
    L_0x00e8:
        r0 = r4;
        r0 = (java.util.ArrayList) r0;
        r0 = r0.size();
        goto L_0x00a2;
    L_0x00f0:
        r0 = 1;
        goto L_0x00b8;
    L_0x00f2:
        r0 = 1;
        goto L_0x00b8;
    L_0x00f4:
        r0 = r9.o();
        r1 = r9.f();
        r1 = r1.s();
        r0 = r0.f(r1);
        if (r0 == 0) goto L_0x010c;
    L_0x0106:
        r0 = h(r10);
        if (r0 != 0) goto L_0x0112;
    L_0x010c:
        r0 = h(r2);
        if (r0 == 0) goto L_0x0120;
    L_0x0112:
        r1 = "param";
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = r9;
        r5 = r14;
        r0 = r0.a(r1, r2, r3, r4, r5);
    L_0x011c:
        if (r0 == 0) goto L_0x012b;
    L_0x011e:
        r0 = 0;
        goto L_0x00bc;
    L_0x0120:
        r1 = "param";
        r3 = 100;
        r0 = r9;
        r5 = r14;
        r0 = r0.a(r1, r2, r3, r4, r5);
        goto L_0x011c;
    L_0x012b:
        r0 = 4;
        goto L_0x00bc;
    L_0x012d:
        r0 = a(r2);
        if (r0 == 0) goto L_0x016f;
    L_0x0133:
        r0 = r6 + 1;
        r1 = 25;
        if (r0 <= r1) goto L_0x0170;
    L_0x0139:
        r1 = 48;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r1 = "Event can't contain more than 25 params";
        r1 = r3.append(r1);
        r1 = r1.toString();
        r3 = r9.zzge();
        r3 = r3.r();
        r4 = r9.k();
        r4 = r4.a(r10);
        r5 = r9.k();
        r5 = r5.a(r11);
        r3.a(r1, r4, r5);
        r1 = 5;
        a(r7, r1);
        r7.remove(r2);
        r6 = r0;
        goto L_0x0012;
    L_0x016f:
        r0 = r6;
    L_0x0170:
        r6 = r0;
        goto L_0x0012;
    L_0x0173:
        r0 = r7;
    L_0x0174:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ie.a(java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    final <T extends Parcelable> T a(byte[] bArr, Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        T t;
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            t = (Parcelable) creator.createFromParcel(obtain);
            return t;
        } catch (ParseException e) {
            t = zzge().r();
            t.a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    final zzeu a(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b(str) != 0) {
            zzge().r().a("Invalid conditional property event name", k().c(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new zzeu(str, new zzer(a(a(str, bundle2, e.a((Object) "_o"), false, false))), str2, j);
    }

    public final Object a(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return a(256, obj, true);
        }
        if (!h(str)) {
            i = 100;
        }
        return a(i, obj, false);
    }

    public final void a(int i, String str, String str2, int i2) {
        a(null, i, str, str2, i2);
    }

    public final void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzge().v().a("Not putting event parameter. Invalid value type. name, type", k().b(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void a(is isVar, Object obj) {
        ar.a(obj);
        isVar.d = null;
        isVar.e = null;
        isVar.f = null;
        if (obj instanceof String) {
            isVar.d = (String) obj;
        } else if (obj instanceof Long) {
            isVar.e = (Long) obj;
        } else if (obj instanceof Double) {
            isVar.f = (Double) obj;
        } else {
            zzge().r().a("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void a(iw iwVar, Object obj) {
        ar.a(obj);
        iwVar.e = null;
        iwVar.f = null;
        iwVar.g = null;
        if (obj instanceof String) {
            iwVar.e = (String) obj;
        } else if (obj instanceof Long) {
            iwVar.f = (Long) obj;
        } else if (obj instanceof Double) {
            iwVar.g = (Double) obj;
        } else {
            zzge().r().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        a(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.q.h().a("auto", "_err", bundle);
    }

    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzbt().currentTimeMillis() - j) > j2;
    }

    final boolean a(String str, int i, String str2) {
        if (str2 == null) {
            zzge().r().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzge().r().a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    final boolean a(String str, String str2) {
        if (str2 == null) {
            zzge().r().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().r().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().r().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzge().r().a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    final boolean a(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzge().r().a("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        ar.a((Object) str2);
        for (String startsWith : a) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            zzge().r().a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            ar.a((Object) strArr);
            for (String startsWith2 : strArr) {
                if (b(str2, startsWith2)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                zzge().r().a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final byte[] a(it itVar) {
        try {
            byte[] bArr = new byte[itVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            itVar.a(a);
            a.a();
            return bArr;
        } catch (IOException e) {
            zzge().r().a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final byte[] a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzge().r().a("Failed to gzip content", e);
            throw e;
        }
    }

    public final int b(String str) {
        return !c("event", str) ? 2 : !a("event", a.a, str) ? 13 : a("event", 40, str) ? 0 : 2;
    }

    public final int b(String str, Object obj) {
        return "_ldl".equals(str) ? a("user property referrer", str, l(str), obj, false) : a("user property", str, l(str), obj, false) ? 0 : 7;
    }

    @WorkerThread
    final long b(Context context, String str) {
        c();
        ar.a((Object) context);
        ar.a(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest f = f("MD5");
        if (f == null) {
            zzge().r().a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!c(context, str)) {
                    PackageInfo b = c.b(context).b(getContext().getPackageName(), 64);
                    if (b.signatures != null && b.signatures.length > 0) {
                        return c(f.digest(b.signatures[0].toByteArray()));
                    }
                    zzge().u().a("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                zzge().r().a("Package name not found", e);
            }
        }
        return 0;
    }

    public final byte[] b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[com.appnext.base.b.c.jk];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzge().r().a("Failed to ungzip content", e);
            throw e;
        }
    }

    public final int c(String str) {
        return !a("user property", str) ? 6 : !a("user property", com.google.android.gms.measurement.c.a, str) ? 15 : a("user property", 24, str) ? 0 : 6;
    }

    public final Object c(String str, Object obj) {
        return "_ldl".equals(str) ? a(l(str), obj, true) : a(l(str), obj, false);
    }

    @WorkerThread
    protected final void c_() {
        c();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzge().u().a("Utils falling back to Random for random id");
            }
        }
        this.c.set(nextLong);
    }

    public final int d(String str) {
        return !c("user property", str) ? 6 : !a("user property", com.google.android.gms.measurement.c.a, str) ? 15 : a("user property", 24, str) ? 0 : 6;
    }

    public final boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            zzge().r().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        ar.a((Object) str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzge().r().a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    @WorkerThread
    public final boolean g(String str) {
        c();
        if (c.b(getContext()).a(str) == 0) {
            return true;
        }
        zzge().x().a("Permission not granted", str);
        return false;
    }

    public final boolean i(String str) {
        return TextUtils.isEmpty(str) ? false : o().t().equals(str);
    }

    protected final boolean p() {
        return true;
    }

    public final long r() {
        long nextLong;
        if (this.c.get() == 0) {
            synchronized (this.c) {
                nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                int i = this.d + 1;
                this.d = i;
                nextLong += (long) i;
            }
        } else {
            synchronized (this.c) {
                this.c.compareAndSet(-1, 1);
                nextLong = this.c.getAndIncrement();
            }
        }
        return nextLong;
    }

    @WorkerThread
    final SecureRandom s() {
        c();
        if (this.b == null) {
            this.b = new SecureRandom();
        }
        return this.b;
    }

    public final int t() {
        if (this.e == null) {
            this.e = Integer.valueOf(g.b().b(getContext()) / 1000);
        }
        return this.e.intValue();
    }
}
