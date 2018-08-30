package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

@VisibleForTesting
public final class x extends af {
    private static boolean a;
    private Info b;
    private final cf c;
    private String d;
    private boolean e = false;
    private final Object f = new Object();

    x(ah ahVar) {
        super(ahVar);
        this.c = new cf(ahVar.c());
    }

    private static String a(String str) {
        if (cj.b("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, cj.b("MD5").digest(str.getBytes()))});
    }

    private final boolean a(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String b = s().b();
        synchronized (this.f) {
            String valueOf;
            String valueOf2;
            boolean g;
            String valueOf3;
            if (!this.e) {
                this.d = f();
                this.e = true;
            } else if (TextUtils.isEmpty(this.d)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    valueOf2 = String.valueOf(b);
                    g = g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                    return g;
                }
                valueOf3 = String.valueOf(obj);
                valueOf = String.valueOf(b);
                this.d = a(valueOf.length() != 0 ? valueOf3.concat(valueOf) : new String(valueOf3));
            }
            valueOf3 = String.valueOf(id);
            valueOf = String.valueOf(b);
            obj = a(valueOf.length() != 0 ? valueOf3.concat(valueOf) : new String(valueOf3));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.d)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.d)) {
                    valueOf = b;
                } else {
                    b("Resetting the client id because Advertising Id changed.");
                    obj = s().c();
                    a("New client Id", obj);
                }
                String valueOf4 = String.valueOf(id);
                valueOf2 = String.valueOf(obj);
                g = g(valueOf2.length() != 0 ? valueOf4.concat(valueOf2) : new String(valueOf4));
                return g;
            }
        }
    }

    private final synchronized Info d() {
        if (this.c.a(1000)) {
            this.c.a();
            Info e = e();
            if (a(this.b, e)) {
                this.b = e;
            } else {
                f("Failed to reset client id on adid change. Not using adid");
                this.b = new Info("", false);
            }
        }
        return this.b;
    }

    private final Info e() {
        Info info = null;
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(j());
        } catch (IllegalStateException e) {
            e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return info;
        } catch (Exception e2) {
            if (a) {
                return info;
            }
            a = true;
            d("Error getting advertiser id", e2);
            return info;
        }
    }

    private final String f() {
        Object e;
        String str = null;
        try {
            FileInputStream openFileInput = j().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                e("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                j().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                b("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e2) {
                    return str2;
                } catch (IOException e3) {
                    IOException iOException = e3;
                    str = str2;
                    IOException e4 = iOException;
                    d("Error reading Hash file, deleting it", e4);
                    j().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e5) {
            return null;
        } catch (IOException e6) {
            e4 = e6;
            d("Error reading Hash file, deleting it", e4);
            j().deleteFile("gaClientIdData");
            return str;
        }
    }

    private final boolean g(String str) {
        try {
            String a = a(str);
            b("Storing hashed adid.");
            FileOutputStream openFileOutput = j().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a.getBytes());
            openFileOutput.close();
            this.d = a;
            return true;
        } catch (IOException e) {
            e("Error creating hash file", e);
            return false;
        }
    }

    protected final void a() {
    }

    public final boolean b() {
        y();
        Info d = d();
        return (d == null || d.isLimitAdTrackingEnabled()) ? false : true;
    }

    public final String c() {
        y();
        Info d = d();
        CharSequence id = d != null ? d.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }
}
