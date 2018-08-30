package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.util.p;
import java.io.InputStream;

final class as implements zzalz<ann> {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ double b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ am e;

    as(am amVar, boolean z, double d, boolean z2, String str) {
        this.e = amVar;
        this.a = z;
        this.b = d;
        this.c = z2;
        this.d = str;
    }

    @TargetApi(19)
    private final ann a(InputStream inputStream) {
        Bitmap decodeStream;
        Options options = new Options();
        options.inDensity = (int) (160.0d * this.b);
        if (!this.c) {
            options.inPreferredConfig = Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Throwable e) {
            kk.b("Error grabbing image.", e);
            decodeStream = null;
        }
        if (decodeStream == null) {
            this.e.a(2, this.a);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (p.g() && hl.a()) {
            int width = decodeStream.getWidth();
            int height = decodeStream.getHeight();
            hl.a("Decoded image w: " + width + " h:" + height + " bytes: " + decodeStream.getAllocationByteCount() + " time: " + (uptimeMillis2 - uptimeMillis) + " on ui thread: " + (Looper.getMainLooper().getThread() == Thread.currentThread()));
        }
        return new ann(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.d), this.b);
    }

    public final /* synthetic */ Object zzny() {
        this.e.a(2, this.a);
        return null;
    }
}
