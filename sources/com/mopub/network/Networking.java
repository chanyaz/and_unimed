package com.mopub.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.g;
import android.webkit.WebView;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.Network;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageCache;
import java.io.File;

public class Networking {
    private static final String a = System.getProperty("http.agent");
    private static volatile MoPubRequestQueue b;
    private static volatile String c;
    private static volatile MaxWidthImageLoader d;
    private static boolean e = false;

    @VisibleForTesting
    public static synchronized void clearForTesting() {
        synchronized (Networking.class) {
            b = null;
            d = null;
            c = null;
        }
    }

    public static String getBaseUrlScheme() {
        return Constants.HTTP;
    }

    @NonNull
    public static String getCachedUserAgent() {
        String str = c;
        return str == null ? a : str;
    }

    @NonNull
    public static ImageLoader getImageLoader(@NonNull Context context) {
        ImageLoader imageLoader = d;
        if (imageLoader == null) {
            synchronized (Networking.class) {
                imageLoader = d;
                if (imageLoader == null) {
                    RequestQueue requestQueue = getRequestQueue(context);
                    final g anonymousClass1 = new g<String, Bitmap>(DeviceUtils.memoryCacheSizeBytes(context)) {
                        protected int a(String str, Bitmap bitmap) {
                            return bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : super.a(str, bitmap);
                        }
                    };
                    imageLoader = new MaxWidthImageLoader(requestQueue, context, new ImageCache() {
                        public Bitmap getBitmap(String str) {
                            return (Bitmap) anonymousClass1.get(str);
                        }

                        public void putBitmap(String str, Bitmap bitmap) {
                            anonymousClass1.put(str, bitmap);
                        }
                    });
                    d = imageLoader;
                }
            }
        }
        return imageLoader;
    }

    @Nullable
    public static MoPubRequestQueue getRequestQueue() {
        return b;
    }

    @NonNull
    public static MoPubRequestQueue getRequestQueue(@NonNull Context context) {
        MoPubRequestQueue moPubRequestQueue = b;
        if (moPubRequestQueue == null) {
            synchronized (Networking.class) {
                moPubRequestQueue = b;
                if (moPubRequestQueue == null) {
                    Network basicNetwork = new BasicNetwork(new RequestQueueHttpStack(getUserAgent(context.getApplicationContext()), new PlayServicesUrlRewriter(ClientMetadata.getInstance(context).getDeviceId(), context), CustomSSLSocketFactory.getDefault(10000)));
                    File file = new File(context.getCacheDir().getPath() + File.separator + "mopub-volley-cache");
                    moPubRequestQueue = new MoPubRequestQueue(new DiskBasedCache(file, (int) DeviceUtils.diskCacheSizeBytes(file, 10485760)), basicNetwork);
                    b = moPubRequestQueue;
                    moPubRequestQueue.start();
                }
            }
        }
        return moPubRequestQueue;
    }

    public static String getScheme() {
        return useHttps() ? Constants.HTTPS : Constants.HTTP;
    }

    @NonNull
    public static String getUserAgent(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        String str = c;
        if (str == null) {
            synchronized (Networking.class) {
                str = c;
                if (str == null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        try {
                            str = new WebView(context).getSettings().getUserAgentString();
                        } catch (Exception e) {
                            str = a;
                        }
                    } else {
                        str = a;
                    }
                    c = str;
                }
            }
        }
        return str;
    }

    @VisibleForTesting
    public static synchronized void setImageLoaderForTesting(MaxWidthImageLoader maxWidthImageLoader) {
        synchronized (Networking.class) {
            d = maxWidthImageLoader;
        }
    }

    @VisibleForTesting
    public static synchronized void setRequestQueueForTesting(MoPubRequestQueue moPubRequestQueue) {
        synchronized (Networking.class) {
            b = moPubRequestQueue;
        }
    }

    @VisibleForTesting
    public static synchronized void setUserAgentForTesting(String str) {
        synchronized (Networking.class) {
            c = str;
        }
    }

    public static void useHttps(boolean z) {
        e = z;
    }

    public static boolean useHttps() {
        return e;
    }
}
