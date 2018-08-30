package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.zzaf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class anb extends and {
    private final zzaf a;
    @Nullable
    private final String b;
    private final String c;

    public anb(zzaf zzaf, @Nullable String str, String str2) {
        this.a = zzaf;
        this.b = str;
        this.c = str2;
    }

    public final String getContent() {
        return this.c;
    }

    public final void recordClick() {
        this.a.zzcn();
    }

    public final void recordImpression() {
        this.a.zzco();
    }

    public final void zzg(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.a.zzh((View) c.a(iObjectWrapper));
        }
    }

    public final String zzjn() {
        return this.b;
    }
}
