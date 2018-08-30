package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(14)
class p extends AppCompatDelegateImplV9 {
    private int t = -100;
    private boolean u;
    private boolean v = true;
    private r w;

    p(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    private boolean h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (z()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                aa.a(resources);
            }
        }
        return true;
    }

    private int x() {
        return this.t != -100 ? this.t : AppCompatDelegate.k();
    }

    private void y() {
        if (this.w == null) {
            this.w = new r(this, ag.a(this.a));
        }
    }

    private boolean z() {
        if (!this.u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    Callback a(Callback callback) {
        return new q(this, callback);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.t == -100) {
            this.t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void c() {
        super.c();
        j();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.t);
        }
    }

    int d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                y();
                return this.w.a();
            default:
                return i;
        }
    }

    public void d() {
        super.d();
        if (this.w != null) {
            this.w.d();
        }
    }

    public void g() {
        super.g();
        if (this.w != null) {
            this.w.d();
        }
    }

    public boolean j() {
        boolean z = false;
        int x = x();
        int d = d(x);
        if (d != -1) {
            z = h(d);
        }
        if (x == 0) {
            y();
            this.w.c();
        }
        this.u = true;
        return z;
    }

    public boolean p() {
        return this.v;
    }
}
