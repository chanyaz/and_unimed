package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import java.math.BigInteger;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class hf {
    private static final Object a = new Object();
    @GuardedBy("sLock")
    private static String b;

    public static String a() {
        String str;
        synchronized (a) {
            str = b;
        }
        return str;
    }

    public static String a(Context context, String str, String str2) {
        String str3;
        synchronized (a) {
            if (b == null && !TextUtils.isEmpty(str)) {
                try {
                    ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
                    Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
                    BigInteger bigInteger = new BigInteger(new byte[1]);
                    String[] split = str.split(",");
                    BigInteger bigInteger2 = bigInteger;
                    for (int i = 0; i < split.length; i++) {
                        au.e();
                        if (ht.a(classLoader, cls, split[i])) {
                            bigInteger2 = bigInteger2.setBit(i);
                        }
                    }
                    b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
                } catch (Throwable th) {
                    b = "err";
                }
            }
            str3 = b;
        }
        return str3;
    }
}
