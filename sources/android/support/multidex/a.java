package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String a = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> b = new HashSet();
    private static final boolean c = a(System.getProperty("java.vm.version"));

    private a() {
    }

    /* JADX WARNING: Missing block: B:43:0x010f, code:
            android.util.Log.i("MultiDex", "install done");
     */
    /* JADX WARNING: Missing block: B:54:?, code:
            return;
     */
    public static void a(android.content.Context r6) {
        /*
        r4 = 20;
        r3 = 4;
        r0 = "MultiDex";
        r1 = "install";
        android.util.Log.i(r0, r1);
        r0 = c;
        if (r0 == 0) goto L_0x0016;
    L_0x000e:
        r0 = "MultiDex";
        r1 = "VM has multidex support, MultiDex support library is disabled.";
        android.util.Log.i(r0, r1);
    L_0x0015:
        return;
    L_0x0016:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 >= r3) goto L_0x0045;
    L_0x001a:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Multi dex installation failed. SDK ";
        r1 = r1.append(r2);
        r2 = android.os.Build.VERSION.SDK_INT;
        r1 = r1.append(r2);
        r2 = " is unsupported. Min SDK version is ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ".";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0045:
        r0 = b(r6);	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x0015;
    L_0x004b:
        r1 = b;	 Catch:{ Exception -> 0x005d }
        monitor-enter(r1);	 Catch:{ Exception -> 0x005d }
        r2 = r0.sourceDir;	 Catch:{ all -> 0x005a }
        r3 = b;	 Catch:{ all -> 0x005a }
        r3 = r3.contains(r2);	 Catch:{ all -> 0x005a }
        if (r3 == 0) goto L_0x0088;
    L_0x0058:
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = "Multidex installation failure";
        android.util.Log.e(r1, r2, r0);
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Multi dex installation failed (";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = ").";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0088:
        r3 = b;	 Catch:{ all -> 0x005a }
        r3.add(r2);	 Catch:{ all -> 0x005a }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        if (r2 <= r4) goto L_0x00d9;
    L_0x0091:
        r2 = "MultiDex";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r3.<init>();	 Catch:{ all -> 0x005a }
        r4 = "MultiDex is not guaranteed to work in SDK version ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = ": SDK version higher than ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = 20;
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = " should be backed by ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "runtime with built-in multidex capabilty but it's not the ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "case here: java.vm.version=\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "java.vm.version";
        r4 = java.lang.System.getProperty(r4);	 Catch:{ all -> 0x005a }
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r3 = r3.toString();	 Catch:{ all -> 0x005a }
        android.util.Log.w(r2, r3);	 Catch:{ all -> 0x005a }
    L_0x00d9:
        r2 = r6.getClassLoader();	 Catch:{ RuntimeException -> 0x00e9 }
        if (r2 != 0) goto L_0x00f4;
    L_0x00df:
        r0 = "MultiDex";
        r2 = "Context class loader is null. Must be running in test mode. Skip patching.";
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x005a }
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00e9:
        r0 = move-exception;
        r2 = "MultiDex";
        r3 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.";
        android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x005a }
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00f4:
        c(r6);	 Catch:{ Throwable -> 0x0118 }
    L_0x00f7:
        r3 = new java.io.File;	 Catch:{ all -> 0x005a }
        r4 = r0.dataDir;	 Catch:{ all -> 0x005a }
        r5 = a;	 Catch:{ all -> 0x005a }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x005a }
        r4 = 0;
        r4 = android.support.multidex.e.a(r6, r0, r3, r4);	 Catch:{ all -> 0x005a }
        r5 = a(r4);	 Catch:{ all -> 0x005a }
        if (r5 == 0) goto L_0x0121;
    L_0x010b:
        a(r2, r3, r4);	 Catch:{ all -> 0x005a }
    L_0x010e:
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        r0 = "MultiDex";
        r1 = "install done";
        android.util.Log.i(r0, r1);
        goto L_0x0015;
    L_0x0118:
        r3 = move-exception;
        r4 = "MultiDex";
        r5 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.";
        android.util.Log.w(r4, r5, r3);	 Catch:{ all -> 0x005a }
        goto L_0x00f7;
    L_0x0121:
        r4 = "MultiDex";
        r5 = "Files were not valid zip files.  Forcing a reload.";
        android.util.Log.w(r4, r5);	 Catch:{ all -> 0x005a }
        r4 = 1;
        r0 = android.support.multidex.e.a(r6, r0, r3, r4);	 Catch:{ all -> 0x005a }
        r4 = a(r0);	 Catch:{ all -> 0x005a }
        if (r4 == 0) goto L_0x0137;
    L_0x0133:
        a(r2, r3, r0);	 Catch:{ all -> 0x005a }
        goto L_0x010e;
    L_0x0137:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x005a }
        r2 = "Zip files were not valid.";
        r0.<init>(r2);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ all -> 0x005a }
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.a.a(android.content.Context):void");
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                c.b(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                b.b(classLoader, list, file);
            } else {
                d.b(classLoader, list);
            }
        }
    }

    static boolean a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean a(List<File> list) {
        for (File a : list) {
            if (!e.a(a)) {
                return false;
            }
        }
        return true;
    }

    private static ApplicationInfo b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            return (packageManager == null || packageName == null) ? null : packageManager.getApplicationInfo(packageName, 128);
        } catch (Throwable e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static Field b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method b(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void b(Object obj, String str, Object[] objArr) {
        Field b = b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
    }

    private static void c(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
