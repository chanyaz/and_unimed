package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.bs;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

@VisibleForTesting
public class a implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler a;
    private final i b;
    private final Context c;
    private ExceptionParser d;
    private GoogleAnalytics e;

    public a(i iVar, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (iVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.a = uncaughtExceptionHandler;
            this.b = iVar;
            this.d = new h(context, new ArrayList());
            this.c = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            bs.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    final UncaughtExceptionHandler a() {
        return this.a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.d != null) {
            str = this.d.getDescription(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        bs.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.b.a(new e().a(str).a(true).a());
        if (this.e == null) {
            this.e = GoogleAnalytics.a(this.c);
        }
        k kVar = this.e;
        kVar.f();
        kVar.g().h().d();
        if (this.a != null) {
            bs.a("Passing exception to the original handler");
            this.a.uncaughtException(thread, th);
        }
    }
}
