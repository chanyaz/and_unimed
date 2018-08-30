package com.puzzlersworld.android;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.h;
import com.google.android.gms.analytics.i;
import com.google.common.base.ab;
import com.google.common.collect.fb;
import com.google.firebase.FirebaseApp;
import com.google.firebase.b;
import com.google.gson.Gson;
import com.puzzlersworld.android.util.AnalyticsTrackers;
import com.puzzlersworld.android.util.AnalyticsTrackers.Target;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.wp.dto.StringPool;
import com.puzzlersworld.wp.service.WpApiService;
import java.util.List;
import mobi.androapp.ac.c8700.R;

public class FriopinApplication extends InjectibleApplication {
    private static String a = "FriopinApplication";
    private static Context b;
    private static FriopinApplication e;
    private static StringPool f = new StringPool();
    private Gson c;
    private FriopinAppModule d;

    public static synchronized FriopinApplication a() {
        FriopinApplication friopinApplication;
        synchronized (FriopinApplication.class) {
            friopinApplication = e;
        }
        return friopinApplication;
    }

    public static Context e() {
        return b;
    }

    public static StringPool h() {
        return f;
    }

    public void a(Error error) {
        if (error != null) {
            b().a(new e().a(error.getMessage() != null ? error.getMessage() : error.getClass().getCanonicalName()).a(false).a());
            GoogleAnalytics.a((Context) this).f();
        }
    }

    public void a(Exception exception) {
        if (exception != null) {
            b().a(new e().a(new h(this, null).getDescription(Thread.currentThread().getName(), exception)).a(false).a());
            GoogleAnalytics.a((Context) this).f();
        }
    }

    public void a(String str) {
        i b = b();
        b.a(str);
        b.a(new g().a());
        GoogleAnalytics.a((Context) this).f();
    }

    public void a(String str, String str2, String str3) {
        b().a(new d().a(str).b(str2).c(str3).a());
        GoogleAnalytics.a((Context) this).f();
    }

    public synchronized i b() {
        return AnalyticsTrackers.a().a(Target.APP);
    }

    protected List<Object> c() {
        Object[] objArr = new Object[1];
        this.d = new FriopinAppModule(this);
        objArr[0] = this.d;
        return fb.a(objArr);
    }

    public void d() {
        Log.i(a, "Initializing Application");
        b = getApplicationContext();
        this.c = new Gson();
    }

    public Gson f() {
        return this.c;
    }

    public WpApiService g() {
        return this.d.providesRestServiceManager().getWpApiService();
    }

    public FriopinAppModule i() {
        return this.d;
    }

    public void onCreate() {
        super.onCreate();
        e = this;
        try {
            FirebaseApp.d();
        } catch (IllegalStateException e) {
            if (!ab.a(b.getString(R.string.google_app_id))) {
                FirebaseApp.a(b, b.a(b));
            }
        }
        AnalyticsTrackers.a((Context) this);
        AnalyticsTrackers.a().a(Target.APP);
    }
}
