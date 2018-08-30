package com.google.firebase;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.a;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import com.google.firebase.components.g;
import com.google.firebase.components.j;
import com.google.firebase.internal.b;
import com.google.firebase.internal.c;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp {
    @GuardedBy("sLock")
    static final Map<String, FirebaseApp> a = new a();
    private static final List<String> b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> e = Arrays.asList(new String[0]);
    private static final Set<String> f = Collections.emptySet();
    private static final Object g = new Object();
    private final Context h;
    private final String i;
    private final b j;
    private final j k;
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final AtomicBoolean m = new AtomicBoolean();
    private final List<IdTokenListener> n = new CopyOnWriteArrayList();
    private final List<BackgroundStateChangeListener> o = new CopyOnWriteArrayList();
    private final List<Object> p = new CopyOnWriteArrayList();
    private IdTokenListenersCountChangedListener q;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    public interface IdTokenListener {
        @KeepForSdk
        void onIdTokenChanged(@NonNull com.google.firebase.internal.a aVar);
    }

    @KeepForSdk
    public interface IdTokenListenersCountChangedListener {
        @KeepForSdk
        void onListenerCountChanged(int i);
    }

    private FirebaseApp(Context context, String str, b bVar) {
        this.h = (Context) ar.a((Object) context);
        this.i = ar.a(str);
        this.j = (b) ar.a((Object) bVar);
        this.q = new b();
        this.k = new j(new g(this.h).a(), com.google.firebase.components.a.a(Context.class, this.h), com.google.firebase.components.a.a(FirebaseApp.class, this), com.google.firebase.components.a.a(b.class, this.j));
    }

    @Nullable
    public static FirebaseApp a(Context context) {
        FirebaseApp d;
        synchronized (g) {
            if (a.containsKey("[DEFAULT]")) {
                d = d();
            } else {
                b a = b.a(context);
                if (a == null) {
                    d = null;
                } else {
                    d = a(context, a);
                }
            }
        }
        return d;
    }

    public static FirebaseApp a(Context context, b bVar) {
        return a(context, bVar, "[DEFAULT]");
    }

    public static FirebaseApp a(Context context, b bVar, String str) {
        Object context2;
        FirebaseApp firebaseApp;
        c.a(context2);
        if (p.b() && (context2.getApplicationContext() instanceof Application)) {
            BackgroundDetector.a((Application) context2.getApplicationContext());
            BackgroundDetector.a().a(new c());
        }
        String trim = str.trim();
        if (context2.getApplicationContext() != null) {
            context2 = context2.getApplicationContext();
        }
        synchronized (g) {
            ar.a(!a.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
            ar.a(context2, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context2, trim, bVar);
            a.put(trim, firebaseApp);
        }
        c.a(firebaseApp);
        firebaseApp.h();
        return firebaseApp;
    }

    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String str : iterable) {
            String str2;
            if (z) {
                try {
                    if (!e.contains(str2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (f.contains(str2)) {
                        throw new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(str2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str3 = "FirebaseApp";
                    String str4 = "Failed to initialize ";
                    str2 = String.valueOf(str2);
                    Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e4);
                }
            }
            Method method = Class.forName(str2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    @KeepForSdk
    public static void a(boolean z) {
        synchronized (g) {
            ArrayList arrayList = new ArrayList(a.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.l.get()) {
                    firebaseApp.b(z);
                }
            }
        }
    }

    private final void b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.o) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    @Nullable
    public static FirebaseApp d() {
        FirebaseApp firebaseApp;
        synchronized (g) {
            firebaseApp = (FirebaseApp) a.get("[DEFAULT]");
            if (firebaseApp == null) {
                String a = ProcessUtils.a();
                throw new IllegalStateException(new StringBuilder(String.valueOf(a).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(a).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    private final void g() {
        ar.a(!this.m.get(), (Object) "FirebaseApp was deleted");
    }

    private final void h() {
        boolean c = android.support.v4.content.a.c(this.h);
        if (c) {
            a.b(this.h);
        } else {
            this.k.a(e());
        }
        a(FirebaseApp.class, this, b, c);
        if (e()) {
            a(FirebaseApp.class, this, c, c);
            a(Context.class, this.h, d, c);
        }
    }

    @NonNull
    public Context a() {
        g();
        return this.h;
    }

    @KeepForSdk
    public <T> T a(Class<T> cls) {
        g();
        return this.k.get(cls);
    }

    @NonNull
    public String b() {
        g();
        return this.i;
    }

    @NonNull
    public b c() {
        g();
        return this.j;
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean e() {
        return "[DEFAULT]".equals(b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof FirebaseApp) ? false : this.i.equals(((FirebaseApp) obj).b());
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public String toString() {
        return ap.a((Object) this).a("name", this.i).a("options", this.j).toString();
    }
}
