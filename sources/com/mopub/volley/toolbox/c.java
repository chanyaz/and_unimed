package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import java.util.LinkedList;

class c {
    final /* synthetic */ ImageLoader a;
    private final Request<?> b;
    private Bitmap c;
    private VolleyError d;
    private final LinkedList<ImageContainer> e = new LinkedList();

    public c(ImageLoader imageLoader, Request<?> request, ImageContainer imageContainer) {
        this.a = imageLoader;
        this.b = request;
        this.e.add(imageContainer);
    }

    public void addContainer(ImageContainer imageContainer) {
        this.e.add(imageContainer);
    }

    public VolleyError getError() {
        return this.d;
    }

    public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
        this.e.remove(imageContainer);
        if (this.e.size() != 0) {
            return false;
        }
        this.b.cancel();
        return true;
    }

    public void setError(VolleyError volleyError) {
        this.d = volleyError;
    }
}
