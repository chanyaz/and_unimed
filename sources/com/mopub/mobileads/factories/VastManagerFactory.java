package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;

public class VastManagerFactory {
    protected static VastManagerFactory a = new VastManagerFactory();

    public static VastManager create(Context context) {
        return a.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean z) {
        return a.internalCreate(context, z);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory vastManagerFactory) {
        a = vastManagerFactory;
    }

    public VastManager internalCreate(Context context, boolean z) {
        return new VastManager(context, z);
    }
}
