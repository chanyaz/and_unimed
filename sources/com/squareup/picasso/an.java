package com.squareup.picasso;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.File;
import java.io.IOException;

class an {
    private an() {
    }

    static Object a(Context context) {
        File b = ao.b(context);
        HttpResponseCache installed = HttpResponseCache.getInstalled();
        return installed == null ? HttpResponseCache.install(b, ao.a(b)) : installed;
    }

    static void a(Object obj) {
        try {
            ((HttpResponseCache) obj).close();
        } catch (IOException e) {
        }
    }
}
