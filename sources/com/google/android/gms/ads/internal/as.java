package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.ada;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.kk;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class as extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ ao a;

    private as(ao aoVar) {
        this.a = aoVar;
    }

    /* synthetic */ as(ao aoVar, ap apVar) {
        this(aoVar);
    }

    private final String a(Void... voidArr) {
        Throwable e;
        try {
            this.a.h = (ada) this.a.c.get(((Long) akc.f().a(amn.cz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            kk.c("", e);
            return this.a.a();
        } catch (ExecutionException e3) {
            e = e3;
            kk.c("", e);
            return this.a.a();
        } catch (TimeoutException e4) {
            e = e4;
            kk.c("", e);
            return this.a.a();
        }
        return this.a.a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.a.f != null && str != null) {
            this.a.f.loadUrl(str);
        }
    }
}
