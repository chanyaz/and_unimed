package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzadh
public final class ch {
    private static boolean b(Context context, boolean z) {
        if (!z) {
            return true;
        }
        int b = DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
        return b == 0 ? false : b <= DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }
}
