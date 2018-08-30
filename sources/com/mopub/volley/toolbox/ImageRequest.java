package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;

public class ImageRequest extends Request<Bitmap> {
    private static final Object e = new Object();
    private final Listener<Bitmap> a;
    private final Config b;
    private final int c;
    private final int d;

    public ImageRequest(String str, Listener<Bitmap> listener, int i, int i2, Config config, ErrorListener errorListener) {
        super(0, str, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.a = listener;
        this.b = config;
        this.c = i;
        this.d = i2;
    }

    static int a(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (((double) (f * 2.0f)) <= Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))) {
            f *= 2.0f;
        }
        return (int) f;
    }

    private static int b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) ((((double) i2) / ((double) i4)) * ((double) i3));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        return ((double) i) * d > ((double) i2) ? (int) (((double) i2) / d) : i;
    }

    private Response<Bitmap> b(NetworkResponse networkResponse) {
        Object decodeByteArray;
        byte[] bArr = networkResponse.data;
        Options options = new Options();
        if (this.c == 0 && this.d == 0) {
            options.inPreferredConfig = this.b;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = b(this.c, this.d, i, i2);
            int b2 = b(this.d, this.c, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, b, b2);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray2 == null || (decodeByteArray2.getWidth() <= b && decodeByteArray2.getHeight() <= b2)) {
                Bitmap decodeByteArray3 = decodeByteArray2;
            } else {
                decodeByteArray3 = Bitmap.createScaledBitmap(decodeByteArray2, b, b2, true);
                decodeByteArray2.recycle();
            }
        }
        return decodeByteArray3 == null ? Response.error(new ParseError(networkResponse)) : Response.success(decodeByteArray3, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    protected Response<Bitmap> a(NetworkResponse networkResponse) {
        Response<Bitmap> b;
        synchronized (e) {
            try {
                b = b(networkResponse);
            } catch (Throwable e) {
                VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                b = Response.error(new ParseError(e));
            }
        }
        return b;
    }

    /* renamed from: a */
    protected void deliverResponse(Bitmap bitmap) {
        this.a.onResponse(bitmap);
    }

    public Priority getPriority() {
        return Priority.LOW;
    }
}
