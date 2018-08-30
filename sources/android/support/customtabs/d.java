package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.h;
import java.util.ArrayList;

public final class d {
    private final Intent a;
    private ArrayList<Bundle> b;
    private Bundle c;
    private ArrayList<Bundle> d;
    private boolean e;

    public d() {
        this(null);
    }

    public d(@Nullable f fVar) {
        IBinder iBinder = null;
        this.a = new Intent("android.intent.action.VIEW");
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = true;
        if (fVar != null) {
            this.a.setPackage(fVar.b().getPackageName());
        }
        Bundle bundle = new Bundle();
        String str = "android.support.customtabs.extra.SESSION";
        if (fVar != null) {
            iBinder = fVar.a();
        }
        h.a(bundle, str, iBinder);
        this.a.putExtras(bundle);
    }

    public c a() {
        if (this.b != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
        }
        if (this.d != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
        }
        this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
        return new c(this.a, this.c);
    }
}
