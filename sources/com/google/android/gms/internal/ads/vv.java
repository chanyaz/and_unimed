package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Mac;

public final class vv implements zzayz<Mac> {
    public final /* synthetic */ Object zzb(String str, Provider provider) {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
