package com.appnext.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.appnext.base.a.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.appnext.base.services.OperationService;
import com.appnext.base.services.ReceiverService;
import java.util.List;

public class a {
    public static final String TAG = a.class.getSimpleName();
    private static volatile a fL;

    private a() {
    }

    public static a aI() {
        if (fL == null) {
            synchronized (a.class) {
                if (fL == null) {
                    fL = new a();
                }
            }
        }
        return fL;
    }

    private void aK() {
        try {
            List<c> cz = e.cy().cz();
            if (cz != null) {
                for (c cVar : cz) {
                    if (!(cVar == null || com.appnext.base.b.c.jt.equalsIgnoreCase(cVar.bc()))) {
                        String key = cVar.getKey();
                        if (k.a(key, com.appnext.base.b.c.jw, cVar)) {
                            Intent intent = new Intent(d.getContext(), OperationService.class);
                            if (com.appnext.base.b.c.jx.equalsIgnoreCase(cVar.ba())) {
                                long i = k.i(cVar.bb(), cVar.bc());
                                if (!com.appnext.base.b.c.ju.equalsIgnoreCase(cVar.bc())) {
                                    long j = i.cE().getLong(key + i.jY, 0);
                                    i += j;
                                    if (!cVar.be().equalsIgnoreCase(com.appnext.base.b.c.jv)) {
                                        k.a(d.getContext(), OperationService.class, Math.max(i, System.currentTimeMillis()), cVar);
                                    } else if (j == 0) {
                                        intent.putExtra(com.appnext.base.b.c.jn, key);
                                        k.a(d.getContext(), intent);
                                    }
                                } else if (i > 0) {
                                    k.a(d.getContext(), OperationService.class, i, cVar);
                                }
                            }
                        } else {
                            l.k(key, " *** No Permission ***");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th);
            l.k(TAG, th.toString());
        }
    }

    private void aL() {
        k.a(d.getContext(), new Intent(d.getContext(), ReceiverService.class));
    }

    public void a(c cVar) {
        new Intent(d.getContext(), OperationService.class).putExtra(com.appnext.base.b.c.jn, cVar.getKey());
        k.a(d.getContext(), OperationService.class, k.i(cVar.bb(), cVar.bc()) + System.currentTimeMillis(), cVar);
    }

    public void a(List<c> list) {
        for (c cVar : list) {
            if (cVar != null) {
                Object bf = cVar.bf();
                l.k(" *** stop *** ", bf);
                if (!TextUtils.isEmpty(bf)) {
                    PendingIntent service = PendingIntent.getService(d.getContext(), bf.hashCode(), new Intent(d.getContext(), OperationService.class), 134217728);
                    if (service != null) {
                        ((AlarmManager) d.getContext().getSystemService("alarm")).cancel(service);
                    }
                }
            }
        }
        d.getContext().stopService(new Intent(d.getContext(), OperationService.class));
        d.getContext().stopService(new Intent(d.getContext(), ReceiverService.class));
        com.appnext.base.operations.d.bG().bH();
    }

    public void aJ() {
        aL();
        aK();
    }
}
