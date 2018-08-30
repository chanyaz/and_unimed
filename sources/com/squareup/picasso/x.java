package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap.Config;
import com.squareup.picasso.Picasso.Listener;
import com.squareup.picasso.Picasso.RequestTransformer;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class x {
    private final Context a;
    private Downloader b;
    private ExecutorService c;
    private Cache d;
    private Listener e;
    private RequestTransformer f;
    private List<af> g;
    private Config h;
    private boolean i;
    private boolean j;

    public x(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.a = context.getApplicationContext();
    }

    public Picasso a() {
        Context context = this.a;
        if (this.b == null) {
            this.b = ao.a(context);
        }
        if (this.d == null) {
            this.d = new q(context);
        }
        if (this.c == null) {
            this.c = new aa();
        }
        if (this.f == null) {
            this.f = RequestTransformer.a;
        }
        ai aiVar = new ai(this.d);
        return new Picasso(context, new i(context, this.c, Picasso.a, this.b, this.d, aiVar), this.d, this.e, this.f, this.g, aiVar, this.h, this.i, this.j);
    }
}
