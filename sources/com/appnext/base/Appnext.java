package com.appnext.base;

import android.annotation.SuppressLint;
import android.content.Context;
import com.appnext.base.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.services.OperationService;
import com.appnext.base.services.ReceiverService;
import com.appnext.core.g;

public class Appnext {
    @SuppressLint({"StaticFieldLeak"})
    private static final Appnext fI = new Appnext();
    private Context fH = null;
    private boolean fJ = false;

    private Appnext() {
    }

    protected static Appnext aG() {
        return fI;
    }

    private void aH() {
        String u = g.u(this.fH);
        if (!u.equals(i.cE().getString(i.kc, ""))) {
            i.cE().clear();
            i.cE().putString(i.kc, u);
        }
    }

    private void e(Context context) {
        if (context == null) {
            throw new ExceptionInInitializerError("Cannot init Appnext with null context");
        } else if (!this.fJ || this.fH == null) {
            this.fJ = true;
            d.init(context);
            this.fH = context.getApplicationContext();
            if (k.a(OperationService.class) && k.a(ReceiverService.class)) {
                com.appnext.base.b.g.cC().b(new Runnable() {
                    public void run() {
                        try {
                            k.e(c.jP, g.u(d.getContext()), a.String);
                            i.cE().init(Appnext.this.fH);
                            if (k.q(Appnext.this.fH)) {
                                Appnext.this.fJ = false;
                                i.cE().putBoolean(i.ki, true);
                                return;
                            }
                            d.init(Appnext.this.fH);
                            i.cE().init(Appnext.this.fH);
                            Appnext.this.aH();
                            com.appnext.base.a.a.a.g(Appnext.this.fH);
                            k.o(Appnext.this.fH);
                        } catch (Throwable th) {
                            b.a(th);
                        }
                    }
                });
            }
        } else {
            this.fH = context.getApplicationContext();
        }
    }

    public static void init(Context context) {
        aG().e(context);
    }

    public static void setParam(String str, String str2) {
        if (d.getContext() != null && str.hashCode() == 951500826) {
            k.e(c.jH, str2, a.Boolean);
        }
    }
}
