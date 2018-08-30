package com.google.android.gms.security;

import android.content.Intent;
import com.google.android.gms.common.g;
import java.lang.reflect.Method;

public class ProviderInstaller {
    private static final g a = g.b();
    private static final Object b = new Object();
    private static Method c = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }
}
