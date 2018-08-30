package com.puzzlersworld.android.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.puzzlersworld.android.util.annotations.ForBackground;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class g {
    public boolean a = false;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private final ExecutorService i;
    private final Runnable j;
    private final l k;
    private final SharedPreferences l;

    @Inject
    public g(@ForBackground ExecutorService executorService, SharedPreferences sharedPreferences, l lVar) {
        this.i = executorService;
        this.j = new Runnable() {
            public void run() {
                g.this.b();
            }
        };
        this.k = lVar;
        this.l = sharedPreferences;
    }

    private void l() {
        this.i.execute(this.j);
    }

    public String a(String str, String str2) {
        return this.l.getString(str, str2);
    }

    public void a() {
        if (!this.a) {
            this.b = this.l.getString("friopin_user", "");
            this.a = true;
        }
        this.c = this.l.getString("last_fetched_posts", "");
        this.d = this.l.getString("config_data", "");
        this.e = this.l.getString("customer_info", "");
        this.f = this.l.getString("cart_session", "");
        this.g = this.l.getString("bs_key", "");
        this.h = this.l.getString("home_post_key", "");
        this.l.getAll();
    }

    public void a(String str) {
        this.c = str;
        l();
    }

    public void b() {
        Editor edit;
        if (this.a) {
            edit = this.l.edit();
            edit.putString("friopin_user", c());
            edit.commit();
        }
        edit = this.l.edit();
        edit.putString("last_fetched_posts", this.c);
        edit.putString("config_data", this.d);
        edit.putString("customer_info", this.e);
        edit.putString("cart_session", this.f);
        edit.putString("bs_key", this.g);
        edit.commit();
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(String str, String str2) {
        Editor edit = this.l.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        Editor edit = this.l.edit();
        edit.putString("x_data", str);
        edit.commit();
    }

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.e = str;
        Editor edit = this.l.edit();
        edit.putString("customer_info", str);
        edit.commit();
    }

    public String e() {
        return this.d;
    }

    public void e(String str) {
        this.f = str;
    }

    public String f() {
        return this.l.getString("x_data", null);
    }

    public void f(String str) {
        this.g = str;
        Editor edit = this.l.edit();
        edit.putString("bs_key", str);
        edit.commit();
    }

    public String g() {
        return this.e;
    }

    public void g(String str) {
        Editor edit = this.l.edit();
        edit.putString("commentNameKey", str);
        edit.commit();
    }

    public String h() {
        return this.f;
    }

    public void h(String str) {
        Editor edit = this.l.edit();
        edit.putString("commentEmailKey", str);
        edit.commit();
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.l.getString("commentNameKey", "");
    }

    public String k() {
        return this.l.getString("commentEmailKey", "");
    }
}
