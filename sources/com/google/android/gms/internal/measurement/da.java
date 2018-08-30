package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class da extends fo {
    private long a;
    private String b;
    private Boolean c;

    da(es esVar) {
        super(esVar);
    }

    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = Boolean.valueOf(false);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.c = Boolean.valueOf(true);
                }
            } catch (NameNotFoundException e) {
            }
        }
        return this.c.booleanValue();
    }

    protected final boolean p() {
        Calendar instance = Calendar.getInstance();
        this.a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String toLowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String toLowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.b = new StringBuilder((String.valueOf(toLowerCase).length() + 1) + String.valueOf(toLowerCase2).length()).append(toLowerCase).append("-").append(toLowerCase2).toString();
        return false;
    }

    public final long q() {
        B();
        return this.a;
    }

    public final String r() {
        B();
        return this.b;
    }
}
