package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appnext.base.a.b.c;
import com.appnext.base.b;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;
import java.util.Calendar;
import java.util.List;

public class scron extends a {
    public static final String he = scron.class.getSimpleName();
    public static final String iB = (scron.class.getSimpleName() + "temp");
    private static final String iC = "0500";
    private static final String iD = "0900";
    private static final int iE = 3;
    private static final String iF = "max";
    private static final String iG = "start";
    private static final String iH = "end";
    private c gP = com.appnext.base.a.a.aM().aR().ac(he);
    private long iI;
    private long iJ;
    private int iK;

    public scron() {
        ci();
        cj();
    }

    private long b(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    private boolean ch() {
        return cl() && !ck();
    }

    private void ci() {
        String str = iC;
        String str2 = iD;
        if (this.gP != null) {
            str = this.gP.e(iG, iC);
            str2 = this.gP.e(iH, iD);
        }
        this.iI = g(str, iC);
        this.iJ = g(str2, iD);
    }

    private void cj() {
        this.iK = 3;
        if (this.gP != null) {
            this.iK = this.gP.b(iF, 3);
        }
    }

    private boolean ck() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.iI);
        long timeInMillis = instance.getTimeInMillis();
        List c = com.appnext.base.a.a.aM().aP().c(iB, timeInMillis);
        com.appnext.base.a.a.aM().aP().b(iB, timeInMillis);
        return c != null && c.size() >= this.iK;
    }

    private boolean cl() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        long timeInMillis = instance.getTimeInMillis();
        return timeInMillis >= this.iI && timeInMillis <= this.iJ;
    }

    private long g(String str, String str2) {
        if (str != null && str.length() == 4 && str.matches("[0-9]+")) {
            str2 = str;
        }
        return b(Integer.valueOf(str2.substring(0, 2)).intValue(), Integer.valueOf(str2.substring(2, 4)).intValue());
    }

    public IntentFilter getBRFilter() {
        try {
            if (!hasPermission()) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            return intentFilter;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return true;
    }

    public void onReceive(Context context, final Intent intent) {
        super.onReceive(context, intent);
        l.k("Receiver", he);
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (scron.this.ch()) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                            scron.this.a(scron.he, "true", com.appnext.base.b.c.a.Boolean);
                            com.appnext.base.a.a.aM().aP().a(new com.appnext.base.a.b.b(scron.iB, "true", com.appnext.base.b.c.a.Boolean.getType()));
                        }
                    }
                } catch (Throwable th) {
                    b.a(th);
                }
            }
        }).start();
    }
}
