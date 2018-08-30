package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.v4.util.a;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class o {
    private final SharedPreferences a;
    private final Context b;
    private final ae c;
    @GuardedBy("this")
    private final Map<String, af> d;

    public o(Context context) {
        this(context, new ae());
    }

    private o(Context context, ae aeVar) {
        this.d = new a();
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.c = aeVar;
        File file = new File(android.support.v4.content.a.b(this.b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !c()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    b();
                    FirebaseInstanceId.a().j();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    static String a(String str, String str2) {
        return new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
    }

    private static String b(String str, String str2, String str3) {
        return new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    private final synchronized boolean c() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized p a(String str, String str2, String str3) {
        return p.a(this.a.getString(b(str, str2, str3), null));
    }

    @Nullable
    public final synchronized String a() {
        String str = null;
        synchronized (this) {
            String string = this.a.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    public final synchronized void a(String str) {
        String string = this.a.getString("topic_operaion_queue", "");
        this.a.edit().putString("topic_operaion_queue", new StringBuilder((String.valueOf(string).length() + 1) + String.valueOf(str).length()).append(string).append(",").append(str).toString()).apply();
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a = p.a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            Editor edit = this.a.edit();
            edit.putString(b(str, str2, str3), a);
            edit.commit();
        }
    }

    public final synchronized void b() {
        this.d.clear();
        ae.a(this.b);
        this.a.edit().clear().commit();
    }

    public final synchronized boolean b(String str) {
        boolean z;
        String string = this.a.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            valueOf2 = String.valueOf(str);
            this.a.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized af c(String str) {
        af afVar;
        afVar = (af) this.d.get(str);
        if (afVar == null) {
            try {
                afVar = this.c.a(this.b, str);
            } catch (ag e) {
                Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
                FirebaseInstanceId.a().j();
                afVar = this.c.b(this.b, str);
            }
            this.d.put(str, afVar);
        }
        return afVar;
    }

    public final synchronized void d(String str) {
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.a.edit();
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
