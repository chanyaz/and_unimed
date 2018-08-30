package com.appnext.base.receivers.imp;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.appnext.base.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.receivers.c;
import java.io.File;

public class caact implements c {
    private static final String CAMERA = "camera";
    private static final String hL = "[^a-zA-Z]+";
    private static final String hM = "dcim";
    private static Uri hN = Media.INTERNAL_CONTENT_URI;
    private static Uri hO = Media.EXTERNAL_CONTENT_URI;
    public static final String he = caact.class.getSimpleName();
    private Handler hP;
    private CaactContentObserver hQ;
    private CaactContentObserver hR;
    private HandlerThread hS;

    class CaactContentObserver extends ContentObserver {
        private Uri hT;

        private CaactContentObserver(Handler handler, Uri uri) {
            super(handler);
            this.hT = uri;
        }

        private boolean a(Uri uri) {
            Uri uri2 = uri;
            Cursor query = d.getContext().getContentResolver().query(uri2, new String[]{"_data", "datetaken"}, null, null, "datetaken DESC");
            if (query != null && query.moveToNext()) {
                long j = query.getLong(query.getColumnIndexOrThrow("datetaken"));
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                query.close();
                String toLowerCase = string.replaceAll(caact.hL, "").toLowerCase();
                if (!TextUtils.isEmpty(string) && (toLowerCase.contains(caact.CAMERA) || toLowerCase.contains(caact.hM))) {
                    if (!new File(string).exists()) {
                        return false;
                    }
                    if (System.currentTimeMillis() - j > 40000 || i.cE().getString(caact.he + uri, "").equals(string)) {
                        return false;
                    }
                    i.cE().putString(caact.he + uri, string);
                    return true;
                }
            }
            return false;
        }

        private void cc() {
            k.d(caact.he, "true", a.Boolean);
        }

        public void onChange(boolean z) {
            super.onChange(z);
            try {
                if (caact.this.hasPermission() && a(this.hT)) {
                    cc();
                }
            } catch (Throwable th) {
            }
        }
    }

    public caact() {
        try {
            if (hasPermission()) {
                this.hS = new HandlerThread(he + "HandlerThread");
                this.hS.start();
                this.hP = new Handler(this.hS.getLooper());
                this.hR = new CaactContentObserver(this.hP, hO);
                this.hQ = new CaactContentObserver(this.hP, hN);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public boolean hasPermission() {
        return VERSION.SDK_INT >= 16 ? f.g(d.getContext().getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") : f.g(d.getContext().getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public boolean register() {
        try {
            d.getContext().getContentResolver().registerContentObserver(hN, true, this.hQ);
            d.getContext().getContentResolver().registerContentObserver(hO, true, this.hR);
        } catch (Throwable th) {
        }
        return true;
    }

    public void unregister() {
        try {
            if (this.hQ != null) {
                d.getContext().getContentResolver().unregisterContentObserver(this.hQ);
            }
            if (this.hR != null) {
                d.getContext().getContentResolver().unregisterContentObserver(this.hR);
            }
            if (this.hP != null) {
                this.hP.removeCallbacks(null);
                this.hP = null;
            }
            if (this.hS != null) {
                this.hS.quit();
                this.hS = null;
            }
        } catch (Throwable th) {
        }
    }
}
