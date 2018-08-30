package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class w implements Downloader {
    private final OkHttpClient a;

    public w(Context context) {
        this(ao.b(context));
    }

    public w(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public w(File file) {
        this(file, ao.a(file));
    }

    public w(File file, long j) {
        this(a());
        try {
            this.a.setCache(new Cache(file, j));
        } catch (IOException e) {
        }
    }

    private static OkHttpClient a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public m load(Uri uri, int i) {
        CacheControl cacheControl = null;
        if (i != 0) {
            if (NetworkPolicy.c(i)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                Builder builder = new Builder();
                if (!NetworkPolicy.a(i)) {
                    builder.noCache();
                }
                if (!NetworkPolicy.b(i)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.a.newCall(url.build()).execute();
        int code = execute.code();
        if (code >= 300) {
            execute.body().close();
            throw new ResponseException(code + " " + execute.message(), i, code);
        }
        boolean z = execute.cacheResponse() != null;
        ResponseBody body = execute.body();
        return new m(body.byteStream(), z, body.contentLength());
    }

    public void shutdown() {
        Cache cache = this.a.getCache();
        if (cache != null) {
            try {
                cache.close();
            } catch (IOException e) {
            }
        }
    }
}
