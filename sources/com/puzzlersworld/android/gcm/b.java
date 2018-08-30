package com.puzzlersworld.android.gcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.appnext.banners.BannerAdRequest;
import com.google.common.base.ab;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.a;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.StringConstants;
import mobi.androapp.ac.c8700.R;

public class b {
    private static String d = null;
    String a;
    Context b;
    SharedPreferences c;

    public b(Context context, SharedPreferences sharedPreferences) {
        this.b = context;
        this.c = sharedPreferences;
        d = context.getString(R.string.gcm_defaultSenderId);
    }

    public static void a(Context context) {
        try {
            if (VERSION.SDK_INT >= 26) {
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(new NotificationChannel("androapp_posts", StringConstants.NEW_POSTS.getMessage(), 3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2) {
        int b = b(context);
        Log.i("AndroidHive GCM", "Saving regId on app version " + b + " with topics " + str2);
        Editor edit = this.c.edit();
        edit.putString("PROPERTY_REG_ID", str);
        edit.putInt("PROPERTY_APP_VERSION", b);
        edit.putString("PROPERTY_TOPICS", str2);
        edit.commit();
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private void b() {
        new AsyncTask<Void, Void, String>() {
            /* renamed from: a */
            protected String doInBackground(Void... voidArr) {
                String str = "";
                try {
                    String str2;
                    FirebaseInstanceId a = FirebaseInstanceId.a();
                    b.this.a = a.e();
                    try {
                        a.a().a(BannerAdRequest.TYPE_ALL);
                        str2 = BannerAdRequest.TYPE_ALL;
                    } catch (Exception e) {
                        e.printStackTrace();
                        str2 = "error";
                    }
                    str = "Device registered, registration ID=" + b.this.a;
                    Log.i("AndroidHive GCM", "Registration Id " + b.this.a);
                    b.this.a(b.this.a, str2);
                    b.this.a(b.this.b, b.this.a, str2);
                    return str;
                } catch (Exception e2) {
                    Log.d("AndroidHive GCM", "Error in registering " + e2.getMessage());
                    return "Error :" + e2.getMessage();
                }
            }

            /* renamed from: a */
            protected void onPostExecute(String str) {
            }
        }.execute(new Void[]{null, null, null});
    }

    public void a() {
        Editor edit = this.c.edit();
        edit.putString("PROPERTY_REG_ID", "");
        edit.commit();
        b();
    }

    public void a(String str, String str2) {
        RestServiceManager providesRestServiceManager = ((FriopinApplication) this.b).i().providesRestServiceManager();
        if (ab.a(providesRestServiceManager.getNamespace()) || ab.a(providesRestServiceManager.getAndroappNamespace())) {
            providesRestServiceManager.resetNameSpace(w.b(providesRestServiceManager));
        }
        Log.d("AndroidHive GCM", "Registered output " + ((String) ((FriopinApplication) this.b).g().registerUser(str, str2).execute().b()));
    }
}
