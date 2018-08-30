package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.StyleRes;
import android.support.v7.a.j;
import android.view.LayoutInflater;

public class b extends ContextWrapper {
    private int a;
    private Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public b() {
        super(null);
    }

    public b(Context context, @StyleRes int i) {
        super(context);
        this.a = i;
    }

    public b(Context context, Theme theme) {
        super(context);
        this.b = theme;
    }

    private Resources b() {
        if (this.e == null) {
            if (this.d == null) {
                this.e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(this.d).getResources();
            }
        }
        return this.e;
    }

    private void c() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        a(this.b, this.a, z);
    }

    public int a() {
        return this.a;
    }

    protected void a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = j.Theme_AppCompat_Light;
        }
        c();
        return this.b;
    }

    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            c();
        }
    }
}
