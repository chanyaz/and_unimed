package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.Provider;

public final class vw implements zzayz<MessageDigest> {
    public final /* synthetic */ Object zzb(String str, Provider provider) {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
