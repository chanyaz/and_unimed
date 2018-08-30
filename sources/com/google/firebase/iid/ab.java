package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

final class ab implements zzo {
    private final FirebaseApp a;
    private final FirebaseInstanceId b;
    private final f c;
    private final l d;
    private final ScheduledThreadPoolExecutor e = new ScheduledThreadPoolExecutor(1);

    ab(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, f fVar) {
        this.a = firebaseApp;
        this.b = firebaseInstanceId;
        this.c = fVar;
        this.d = new l(firebaseApp.a(), fVar);
    }

    private final String a(Bundle bundle) {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
            if (string == null) {
                string = bundle.getString("error");
                if ("RST".equals(string)) {
                    this.b.j();
                    throw new IOException("INSTANCE_ID_RESET");
                } else if (string != null) {
                    throw new IOException(string);
                } else {
                    String valueOf = String.valueOf(bundle);
                    Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 21).append("Unexpected response: ").append(valueOf).toString(), new Throwable());
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
        }
        return string;
    }

    private final Bundle b(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", FirebaseInstanceId.d());
        bundle.putString("gmp_app_id", this.a.c().a());
        bundle.putString("gmsv", Integer.toString(this.c.d()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.c.b());
        bundle.putString("app_ver_name", this.c.c());
        bundle.putString("cliv", "fiid-12451000");
        return bundle;
    }

    final String a(String str, String str2, Bundle bundle) {
        b(str, str2, bundle);
        return a(this.d.a(bundle));
    }

    public final a<String> zzb(String str, String str2) {
        Bundle bundle = new Bundle();
        b(str, str2, bundle);
        b bVar = new b();
        this.e.execute(new ac(this, bundle, bVar));
        return bVar.a().a(this.e, new ad(this));
    }
}
