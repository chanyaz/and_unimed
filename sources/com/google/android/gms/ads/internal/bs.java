package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzait;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class bs {
    private final Context a;
    private boolean b;
    private zzait c;
    private zzael d;

    public bs(Context context, zzait zzait, zzael zzael) {
        this.a = context;
        this.c = zzait;
        this.d = zzael;
        if (this.d == null) {
            this.d = new zzael();
        }
    }

    private final boolean c() {
        return (this.c != null && this.c.zzpg().f) || this.d.a;
    }

    public final void a() {
        this.b = true;
    }

    public final void a(@Nullable String str) {
        if (c()) {
            if (str == null) {
                str = "";
            }
            if (this.c != null) {
                this.c.zza(str, null, 3);
            } else if (this.d.a && this.d.b != null) {
                for (String str2 : this.d.b) {
                    String str22;
                    if (!TextUtils.isEmpty(str22)) {
                        str22 = str22.replace("{NAVIGATION_URL}", Uri.encode(str));
                        au.e();
                        ht.a(this.a, "", str22);
                    }
                }
            }
        }
    }

    public final boolean b() {
        return !c() || this.b;
    }
}
