package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.ax;
import com.google.android.gms.common.util.r;

public final class b {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    private b(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        ar.a(!r.b(str), (Object) "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static b a(Context context) {
        ax axVar = new ax(context);
        Object a = axVar.a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new b(a, axVar.a("google_api_key"), axVar.a("firebase_database_url"), axVar.a("ga_trackingId"), axVar.a("gcm_defaultSenderId"), axVar.a("google_storage_bucket"), axVar.a("project_id"));
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return ap.a(this.b, bVar.b) && ap.a(this.a, bVar.a) && ap.a(this.c, bVar.c) && ap.a(this.d, bVar.d) && ap.a(this.e, bVar.e) && ap.a(this.f, bVar.f) && ap.a(this.g, bVar.g);
    }

    public final int hashCode() {
        return ap.a(this.b, this.a, this.c, this.d, this.e, this.f, this.g);
    }

    public final String toString() {
        return ap.a((Object) this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).a("projectId", this.g).toString();
    }
}
