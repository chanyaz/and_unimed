package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.mopub.common.Constants;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.InputStream;

class u extends af {
    private final Downloader a;
    private final ai b;

    public u(Downloader downloader, ai aiVar) {
        this.a = downloader;
        this.b = aiVar;
    }

    int a() {
        return 2;
    }

    public ag a(ac acVar, int i) {
        m load = this.a.load(acVar.d, acVar.c);
        if (load == null) {
            return null;
        }
        LoadedFrom loadedFrom = load.c ? LoadedFrom.DISK : LoadedFrom.NETWORK;
        Bitmap b = load.b();
        if (b != null) {
            return new ag(b, loadedFrom);
        }
        InputStream a = load.a();
        if (a == null) {
            return null;
        }
        if (loadedFrom == LoadedFrom.DISK && load.c() == 0) {
            ao.a(a);
            throw new v("Received response with 0 content-length header.");
        }
        if (loadedFrom == LoadedFrom.NETWORK && load.c() > 0) {
            this.b.a(load.c());
        }
        return new ag(a, loadedFrom);
    }

    public boolean a(ac acVar) {
        String scheme = acVar.d.getScheme();
        return Constants.HTTP.equals(scheme) || Constants.HTTPS.equals(scheme);
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    boolean b() {
        return true;
    }
}
