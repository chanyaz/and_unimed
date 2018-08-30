package com.puzzlersworld.android.util;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;
import com.google.firebase.messaging.FirebaseMessagingService;
import dagger.a;
import java.util.List;

public abstract class InjectibleApplication extends MultiDexApplication {
    private static a a;
    private static Activity b;
    private static Context c;

    public static a a(Fragment fragment) {
        a.a((Object) fragment);
        return a;
    }

    public static a a(FirebaseMessagingService firebaseMessagingService) {
        a.a((Object) firebaseMessagingService);
        return a;
    }

    public static void a(Activity activity) {
        b = activity;
        c = activity;
        a.a((Object) activity);
    }

    public static void a(Object obj) {
        a.a(obj);
    }

    public static void b(Activity activity) {
        c = activity;
        b = activity;
    }

    public static Activity j() {
        return b;
    }

    protected abstract List<Object> c();

    protected void d() {
    }

    public void onCreate() {
        super.onCreate();
        a = a.a(c().toArray());
        d();
    }
}
