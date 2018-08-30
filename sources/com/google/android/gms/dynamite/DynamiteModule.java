package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule {
    public static final VersionPolicy a = new i();
    public static final VersionPolicy b = new j();
    public static final VersionPolicy c = new k();
    public static final VersionPolicy d = new l();
    public static final VersionPolicy e = new m();
    public static final VersionPolicy f = new n();
    @GuardedBy("DynamiteModule.class")
    private static Boolean g;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoader h;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoaderV2 i;
    @GuardedBy("DynamiteModule.class")
    private static String j;
    private static final ThreadLocal<b> k = new ThreadLocal();
    private static final IVersions l = new h();
    private final Context m;

    @DynamiteApi
    public class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, h hVar) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int getLocalVersion(Context context, String str);

            int getRemoteVersion(Context context, String str, boolean z);
        }

        a selectModule(Context context, String str, IVersions iVersions);
    }

    private DynamiteModule(Context context) {
        this.m = (Context) ar.a((Object) context);
    }

    public static int a(Context context, String str) {
        String valueOf;
        try {
            Class loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf(str).length() + 61).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            String str2 = "Failed to load module descriptor class: ";
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC, Splitter: B:21:0x003b} */
    public static int a(android.content.Context r7, java.lang.String r8, boolean r9) {
        /*
        r1 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r1);
        r0 = g;	 Catch:{ all -> 0x0074 }
        if (r0 != 0) goto L_0x0034;
    L_0x0007:
        r0 = r7.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        r2 = r0.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        r0 = "sClassLoader";
        r3 = r2.getDeclaredField(r0);	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        monitor-enter(r2);	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
        r0 = 0;
        r0 = r3.get(r0);	 Catch:{ all -> 0x009c }
        r0 = (java.lang.ClassLoader) r0;	 Catch:{ all -> 0x009c }
        if (r0 == 0) goto L_0x0046;
    L_0x0029:
        r3 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x009c }
        if (r0 != r3) goto L_0x0040;
    L_0x002f:
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x009c }
    L_0x0031:
        monitor-exit(r2);	 Catch:{ all -> 0x009c }
    L_0x0032:
        g = r0;	 Catch:{ all -> 0x0074 }
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00ed;
    L_0x003b:
        r0 = d(r7, r8, r9);	 Catch:{ LoadingException -> 0x00ca }
    L_0x003f:
        return r0;
    L_0x0040:
        a(r0);	 Catch:{ LoadingException -> 0x00f3 }
    L_0x0043:
        r0 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x009c }
        goto L_0x0031;
    L_0x0046:
        r0 = "com.google.android.gms";
        r4 = r7.getApplicationContext();	 Catch:{ all -> 0x009c }
        r4 = r4.getPackageName();	 Catch:{ all -> 0x009c }
        r0 = r0.equals(r4);	 Catch:{ all -> 0x009c }
        if (r0 == 0) goto L_0x0061;
    L_0x0056:
        r0 = 0;
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x009c }
        r3.set(r0, r4);	 Catch:{ all -> 0x009c }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x009c }
        goto L_0x0031;
    L_0x0061:
        r0 = d(r7, r8, r9);	 Catch:{ LoadingException -> 0x0090 }
        r4 = j;	 Catch:{ LoadingException -> 0x0090 }
        if (r4 == 0) goto L_0x0071;
    L_0x0069:
        r4 = j;	 Catch:{ LoadingException -> 0x0090 }
        r4 = r4.isEmpty();	 Catch:{ LoadingException -> 0x0090 }
        if (r4 == 0) goto L_0x0077;
    L_0x0071:
        monitor-exit(r2);	 Catch:{ all -> 0x009c }
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x003f;
    L_0x0074:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        throw r0;
    L_0x0077:
        r4 = new com.google.android.gms.dynamite.o;	 Catch:{ LoadingException -> 0x0090 }
        r5 = j;	 Catch:{ LoadingException -> 0x0090 }
        r6 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ LoadingException -> 0x0090 }
        r4.<init>(r5, r6);	 Catch:{ LoadingException -> 0x0090 }
        a(r4);	 Catch:{ LoadingException -> 0x0090 }
        r5 = 0;
        r3.set(r5, r4);	 Catch:{ LoadingException -> 0x0090 }
        r4 = java.lang.Boolean.TRUE;	 Catch:{ LoadingException -> 0x0090 }
        g = r4;	 Catch:{ LoadingException -> 0x0090 }
        monitor-exit(r2);	 Catch:{ all -> 0x009c }
        monitor-exit(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x003f;
    L_0x0090:
        r0 = move-exception;
        r0 = 0;
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x009c }
        r3.set(r0, r4);	 Catch:{ all -> 0x009c }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x009c }
        goto L_0x0031;
    L_0x009c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x009c }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x009f, IllegalAccessException -> 0x00f8, NoSuchFieldException -> 0x00f6 }
    L_0x009f:
        r0 = move-exception;
    L_0x00a0:
        r2 = "DynamiteModule";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0074 }
        r3 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0074 }
        r3 = r3.length();	 Catch:{ all -> 0x0074 }
        r3 = r3 + 30;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r4.<init>(r3);	 Catch:{ all -> 0x0074 }
        r3 = "Failed to load module via V2: ";
        r3 = r4.append(r3);	 Catch:{ all -> 0x0074 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0074 }
        r0 = r0.toString();	 Catch:{ all -> 0x0074 }
        android.util.Log.w(r2, r0);	 Catch:{ all -> 0x0074 }
        r0 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0074 }
        goto L_0x0032;
    L_0x00ca:
        r0 = move-exception;
        r1 = "DynamiteModule";
        r2 = "Failed to retrieve remote module version: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00e7;
    L_0x00dd:
        r0 = r2.concat(r0);
    L_0x00e1:
        android.util.Log.w(r1, r0);
        r0 = 0;
        goto L_0x003f;
    L_0x00e7:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x00e1;
    L_0x00ed:
        r0 = c(r7, r8, r9);
        goto L_0x003f;
    L_0x00f3:
        r0 = move-exception;
        goto L_0x0043;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x00a0;
    L_0x00f8:
        r0 = move-exception;
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean):int");
    }

    private static Context a(Context context, String str, int i, Cursor cursor, IDynamiteLoaderV2 iDynamiteLoaderV2) {
        try {
            return (Context) c.a(iDynamiteLoaderV2.loadModule2(c.a((Object) context), str, i, c.a((Object) cursor)));
        } catch (Exception e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static Uri a(String str, boolean z) {
        String str2 = z ? "api_force_staging" : "api";
        return Uri.parse(new StringBuilder((String.valueOf(str2).length() + 42) + String.valueOf(str).length()).append("content://com.google.android.gms.chimera/").append(str2).append("/").append(str).toString());
    }

    public static DynamiteModule a(Context context, VersionPolicy versionPolicy, String str) {
        b bVar = (b) k.get();
        b bVar2 = new b();
        k.set(bVar2);
        a selectModule;
        DynamiteModule c;
        try {
            selectModule = versionPolicy.selectModule(context, str, l);
            Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(selectModule.a).append(" and remote module ").append(str).append(":").append(selectModule.b).toString());
            if (selectModule.c == 0 || ((selectModule.c == -1 && selectModule.a == 0) || (selectModule.c == 1 && selectModule.b == 0))) {
                throw new LoadingException("No acceptable module found. Local version is " + selectModule.a + " and remote version is " + selectModule.b + ".", null);
            } else if (selectModule.c == -1) {
                c = c(context, str);
                if (bVar2.a != null) {
                    bVar2.a.close();
                }
                k.set(bVar);
                return c;
            } else if (selectModule.c == 1) {
                c = a(context, str, selectModule.b);
                if (bVar2.a != null) {
                    bVar2.a.close();
                }
                k.set(bVar);
                return c;
            } else {
                throw new LoadingException("VersionPolicy returned invalid code:" + selectModule.c, null);
            }
        } catch (Throwable e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load remote module: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            if (selectModule.a == 0 || versionPolicy.selectModule(context, str, new c(selectModule.a, 0)).c != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
            }
            c = c(context, str);
            if (bVar2.a != null) {
                bVar2.a.close();
            }
            k.set(bVar);
            return c;
        } catch (Throwable th) {
            if (bVar2.a != null) {
                bVar2.a.close();
            }
            k.set(bVar);
        }
    }

    private static DynamiteModule a(Context context, String str, int i) {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = g;
        }
        if (bool != null) {
            return bool.booleanValue() ? c(context, str, i) : b(context, str, i);
        } else {
            throw new LoadingException("Failed to determine which loading route to use.", null);
        }
    }

    private static IDynamiteLoader a(Context context) {
        synchronized (DynamiteModule.class) {
            IDynamiteLoader iDynamiteLoader;
            if (h != null) {
                iDynamiteLoader = h;
                return iDynamiteLoader;
            } else if (g.b().a(context) != 0) {
                return null;
            } else {
                try {
                    iDynamiteLoader = d.a((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (iDynamiteLoader != null) {
                        h = iDynamiteLoader;
                        return iDynamiteLoader;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void a(ClassLoader classLoader) {
        Throwable e;
        try {
            i = f.a((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (InstantiationException e4) {
            e = e4;
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    public static Cursor b(Context context, String str, boolean z) {
        return context.getContentResolver().query(a(str, z), null, null, null, null);
    }

    private static DynamiteModule b(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        IDynamiteLoader a = a(context);
        if (a == null) {
            throw new LoadingException("Failed to create IDynamiteLoader.", null);
        }
        try {
            IObjectWrapper createModuleContext = a.createModuleContext(c.a((Object) context), str, i);
            if (c.a(createModuleContext) != null) {
                return new DynamiteModule((Context) c.a(createModuleContext));
            }
            throw new LoadingException("Failed to load remote module.", null);
        } catch (Throwable e) {
            throw new LoadingException("Failed to load remote module.", e, null);
        }
    }

    private static int c(Context context, String str, boolean z) {
        IDynamiteLoader a = a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.getModuleVersion2(c.a((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    private static DynamiteModule c(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule c(Context context, String str, int i) {
        IDynamiteLoaderV2 iDynamiteLoaderV2;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            iDynamiteLoaderV2 = i;
        }
        if (iDynamiteLoaderV2 == null) {
            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
        }
        b bVar = (b) k.get();
        if (bVar == null || bVar.a == null) {
            throw new LoadingException("No result cursor", null);
        }
        Context a = a(context.getApplicationContext(), str, i, bVar.a, iDynamiteLoaderV2);
        if (a != null) {
            return new DynamiteModule(a);
        }
        throw new LoadingException("Failed to get module context", null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    private static int d(android.content.Context r5, java.lang.String r6, boolean r7) {
        /*
        r2 = 0;
        r1 = b(r5, r6, r7);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        if (r1 == 0) goto L_0x000d;
    L_0x0007:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x001d }
        if (r0 != 0) goto L_0x002a;
    L_0x000d:
        r0 = "DynamiteModule";
        r2 = "Failed to retrieve remote module version.";
        android.util.Log.w(r0, r2);	 Catch:{ Exception -> 0x001d }
        r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException;	 Catch:{ Exception -> 0x001d }
        r2 = "Failed to connect to dynamite module ContentResolver.";
        r3 = 0;
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x001d }
        throw r0;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r0 = move-exception;
    L_0x001e:
        r2 = r0 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException;	 Catch:{ all -> 0x0023 }
        if (r2 == 0) goto L_0x0056;
    L_0x0022:
        throw r0;	 Catch:{ all -> 0x0023 }
    L_0x0023:
        r0 = move-exception;
    L_0x0024:
        if (r1 == 0) goto L_0x0029;
    L_0x0026:
        r1.close();
    L_0x0029:
        throw r0;
    L_0x002a:
        r0 = 0;
        r3 = r1.getInt(r0);	 Catch:{ Exception -> 0x001d }
        if (r3 <= 0) goto L_0x004d;
    L_0x0031:
        r4 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r4);	 Catch:{ Exception -> 0x001d }
        r0 = 2;
        r0 = r1.getString(r0);	 Catch:{ all -> 0x0053 }
        j = r0;	 Catch:{ all -> 0x0053 }
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        r0 = k;	 Catch:{ Exception -> 0x001d }
        r0 = r0.get();	 Catch:{ Exception -> 0x001d }
        r0 = (com.google.android.gms.dynamite.b) r0;	 Catch:{ Exception -> 0x001d }
        if (r0 == 0) goto L_0x004d;
    L_0x0046:
        r4 = r0.a;	 Catch:{ Exception -> 0x001d }
        if (r4 != 0) goto L_0x004d;
    L_0x004a:
        r0.a = r1;	 Catch:{ Exception -> 0x001d }
        r1 = r2;
    L_0x004d:
        if (r1 == 0) goto L_0x0052;
    L_0x004f:
        r1.close();
    L_0x0052:
        return r3;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;	 Catch:{ Exception -> 0x001d }
    L_0x0056:
        r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException;	 Catch:{ all -> 0x0023 }
        r3 = "V2 version check failed";
        r4 = 0;
        r2.<init>(r3, r0, r4);	 Catch:{ all -> 0x0023 }
        throw r2;	 Catch:{ all -> 0x0023 }
    L_0x005f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0024;
    L_0x0062:
        r0 = move-exception;
        r1 = r2;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.d(android.content.Context, java.lang.String, boolean):int");
    }

    public final Context a() {
        return this.m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    public final android.os.IBinder a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = r5.m;	 Catch:{ ClassNotFoundException -> 0x0011, InstantiationException -> 0x002f, IllegalAccessException -> 0x0031 }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0011, InstantiationException -> 0x002f, IllegalAccessException -> 0x0031 }
        r0 = r0.loadClass(r6);	 Catch:{ ClassNotFoundException -> 0x0011, InstantiationException -> 0x002f, IllegalAccessException -> 0x0031 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x0011, InstantiationException -> 0x002f, IllegalAccessException -> 0x0031 }
        r0 = (android.os.IBinder) r0;	 Catch:{ ClassNotFoundException -> 0x0011, InstantiationException -> 0x002f, IllegalAccessException -> 0x0031 }
        return r0;
    L_0x0011:
        r0 = move-exception;
    L_0x0012:
        r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException;
        r3 = "Failed to instantiate module class: ";
        r1 = java.lang.String.valueOf(r6);
        r4 = r1.length();
        if (r4 == 0) goto L_0x0029;
    L_0x0020:
        r1 = r3.concat(r1);
    L_0x0024:
        r3 = 0;
        r2.<init>(r1, r0, r3);
        throw r2;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r3);
        goto L_0x0024;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0012;
    L_0x0031:
        r0 = move-exception;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(java.lang.String):android.os.IBinder");
    }
}
