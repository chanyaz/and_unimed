package com.puzzlersworld.wp.a;

import android.util.Log;
import com.puzzlersworld.android.util.c;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;

public class b implements Interceptor {
    c a;

    public b(c cVar) {
        this.a = cVar;
    }

    public ag intercept(Chain chain) {
        ad request = chain.request();
        Log.d("AndroApp", "In CartInterceptor");
        System.out.println("CARTSESSION Cookie Used" + this.a.a(request.a().toString()));
        ag proceed = chain.proceed(request.e().b("Cookie", this.a.a(request.a().toString())).a());
        this.a.a(proceed.a("Set-Cookie"));
        System.out.println("CARTSESSION Cookie Received" + this.a);
        return proceed;
    }
}
