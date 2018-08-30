package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzag;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class auf implements zzag {
    private final atl a;
    private final lk b;
    private final /* synthetic */ auc c;

    public auf(auc auc, atl atl, lk lkVar) {
        this.c = auc;
        this.a = atl;
        this.b = lkVar;
    }

    public final void zzau(@Nullable String str) {
        if (str == null) {
            try {
                this.b.a(new zzwe());
            } catch (IllegalStateException e) {
                this.a.c();
                return;
            } catch (Throwable th) {
                this.a.c();
            }
        } else {
            this.b.a(new zzwe(str));
        }
        this.a.c();
    }

    public final void zzd(JSONObject jSONObject) {
        try {
            this.b.b(this.c.a.zze(jSONObject));
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.b.b(e2);
        } finally {
            this.a.c();
        }
    }
}
