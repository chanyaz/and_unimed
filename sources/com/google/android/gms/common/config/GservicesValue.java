package com.google.android.gms.common.config;

public abstract class GservicesValue<T> {
    private static final Object c = new Object();
    private static zza d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Double zza(String str, Double d);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);

        String zzb(String str, String str2);
    }

    protected GservicesValue(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static GservicesValue<Float> a(String str, Float f) {
        return new d(str, f);
    }

    public static GservicesValue<Integer> a(String str, Integer num) {
        return new c(str, num);
    }

    public static GservicesValue<Long> a(String str, Long l) {
        return new b(str, l);
    }

    public static GservicesValue<String> a(String str, String str2) {
        return new e(str, str2);
    }

    public static GservicesValue<Boolean> a(String str, boolean z) {
        return new a(str, Boolean.valueOf(z));
    }
}
