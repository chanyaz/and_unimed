package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

public final class vx implements zzayz<Signature> {
    public final /* synthetic */ Object zzb(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
