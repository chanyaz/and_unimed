package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class c {
    private static final Lock a = new ReentrantLock();
    @GuardedBy("sLk")
    private static c b;
    private final Lock c = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences d;

    @VisibleForTesting
    private c(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c a(Context context) {
        ar.a((Object) context);
        a.lock();
        try {
            if (b == null) {
                b = new c(context.getApplicationContext());
            }
            c cVar = b;
            return cVar;
        } finally {
            a.unlock();
        }
    }

    private static String a(String str, String str2) {
        return new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(":").append(str2).toString();
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInAccount b(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (TextUtils.isEmpty(str)) {
            return googleSignInAccount;
        }
        String a = a(a("googleSignInAccount", str));
        if (a == null) {
            return googleSignInAccount;
        }
        try {
            return GoogleSignInAccount.a(a);
        } catch (JSONException e) {
            return googleSignInAccount;
        }
    }

    @Nullable
    public GoogleSignInAccount a() {
        return b(a("defaultGoogleSignInAccount"));
    }

    @Nullable
    protected String a(String str) {
        this.c.lock();
        try {
            String string = this.d.getString(str, null);
            return string;
        } finally {
            this.c.unlock();
        }
    }
}
