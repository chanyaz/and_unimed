package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Iterator;

public class ImageLoader {
    private final RequestQueue a;
    private int b = 100;
    private final ImageCache c;
    private final HashMap<String, c> d = new HashMap();
    private final HashMap<String, c> e = new HashMap();
    private final Handler f = new Handler(Looper.getMainLooper());
    private Runnable g;

    public interface ImageListener extends ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public class ImageContainer {
        private Bitmap b;
        private final ImageListener c;
        private final String d;
        private final String e;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.b = bitmap;
            this.e = str;
            this.d = str2;
            this.c = imageListener;
        }

        public void cancelRequest() {
            if (this.c != null) {
                c cVar = (c) ImageLoader.this.d.get(this.d);
                if (cVar == null) {
                    cVar = (c) ImageLoader.this.e.get(this.d);
                    if (cVar != null) {
                        cVar.removeContainerAndCancelIfNecessary(this);
                        if (cVar.e.size() == 0) {
                            ImageLoader.this.e.remove(this.d);
                        }
                    }
                } else if (cVar.removeContainerAndCancelIfNecessary(this)) {
                    ImageLoader.this.d.remove(this.d);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.b;
        }

        public String getRequestUrl() {
            return this.e;
        }
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.a = requestQueue;
        this.c = imageCache;
    }

    private static String a(String str, int i, int i2) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append(str).toString();
    }

    private void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private void a(String str, c cVar) {
        this.e.put(str, cVar);
        if (this.g == null) {
            this.g = new Runnable() {
                public void run() {
                    for (c cVar : ImageLoader.this.e.values()) {
                        Iterator it = cVar.e.iterator();
                        while (it.hasNext()) {
                            ImageContainer imageContainer = (ImageContainer) it.next();
                            if (imageContainer.c != null) {
                                if (cVar.getError() == null) {
                                    imageContainer.b = cVar.c;
                                    imageContainer.c.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.c.onErrorResponse(cVar.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.e.clear();
                    ImageLoader.this.g = null;
                }
            };
            this.f.postDelayed(this.g, (long) this.b);
        }
    }

    public static ImageListener getImageListener(final ImageView imageView, final int i, final int i2) {
        return new ImageListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }

            public void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                } else if (i != 0) {
                    imageView.setImageResource(i);
                }
            }
        };
    }

    protected Request<Bitmap> a(String str, int i, int i2, final String str2) {
        return new ImageRequest(str, new Listener<Bitmap>() {
            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.a(str2, bitmap);
            }
        }, i, i2, Config.RGB_565, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                ImageLoader.this.a(str2, volleyError);
            }
        });
    }

    protected void a(String str, Bitmap bitmap) {
        this.c.putBitmap(str, bitmap);
        c cVar = (c) this.d.remove(str);
        if (cVar != null) {
            cVar.c = bitmap;
            a(str, cVar);
        }
    }

    protected void a(String str, VolleyError volleyError) {
        c cVar = (c) this.d.remove(str);
        if (cVar != null) {
            cVar.setError(volleyError);
            a(str, cVar);
        }
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        a();
        String a = a(str, i, i2);
        Bitmap bitmap = this.c.getBitmap(a);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, a, imageListener);
        imageListener.onResponse(imageContainer2, true);
        c cVar = (c) this.d.get(a);
        if (cVar != null) {
            cVar.addContainer(imageContainer2);
            return imageContainer2;
        }
        Request a2 = a(str, i, i2, a);
        this.a.add(a2);
        this.d.put(a, new c(this, a2, imageContainer2));
        return imageContainer2;
    }

    public boolean isCached(String str, int i, int i2) {
        a();
        return this.c.getBitmap(a(str, i, i2)) != null;
    }

    public void setBatchedResponseDelay(int i) {
        this.b = i;
    }
}
