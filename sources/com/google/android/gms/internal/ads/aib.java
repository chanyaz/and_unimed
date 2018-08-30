package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzadh
public final class aib {
    @VisibleForTesting
    zzen a;
    @VisibleForTesting
    boolean b;

    public aib(Context context) {
        amn.a(context);
        if (((Boolean) akc.f().a(amn.db)).booleanValue()) {
            try {
                this.a = afd.a(DynamiteModule.a(context, DynamiteModule.a, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
                c.a((Object) context);
                this.a.zza(c.a((Object) context), "GMA_SDK");
                this.b = true;
                return;
            } catch (LoadingException e) {
            } catch (RemoteException e2) {
            } catch (NullPointerException e3) {
            }
        } else {
            return;
        }
        kk.b("Cannot dynamite load clearcut");
    }

    public aib(Context context, String str, String str2) {
        amn.a(context);
        try {
            this.a = afd.a(DynamiteModule.a(context, DynamiteModule.a, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
            c.a((Object) context);
            this.a.zza(c.a((Object) context), str, null);
            this.b = true;
            return;
        } catch (LoadingException e) {
        } catch (RemoteException e2) {
        } catch (NullPointerException e3) {
        }
        kk.b("Cannot dynamite load clearcut");
    }

    public final aid a(byte[] bArr) {
        return new aid(this, bArr, null);
    }
}
