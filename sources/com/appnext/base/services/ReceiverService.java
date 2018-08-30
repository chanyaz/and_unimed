package com.appnext.base.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.appnext.base.b;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.appnext.base.receivers.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReceiverService extends Service {
    private static final String iT = "com.appnext.base.receivers.imp";
    private List<c> iU;

    private void b(com.appnext.base.a.b.c cVar) {
        if (cVar != null) {
            try {
                this.iU.add((c) Class.forName(getOperationClassName(cVar.getKey())).getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException e) {
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    private void cm() {
        cn();
        co();
    }

    private void cn() {
        this.iU = new ArrayList();
    }

    private void co() {
        try {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        List<com.appnext.base.a.b.c> cz = e.cy().cz();
                        if (cz != null) {
                            for (com.appnext.base.a.b.c cVar : cz) {
                                if (cVar != null && com.appnext.base.b.c.jt.equalsIgnoreCase(cVar.bc())) {
                                    String key = cVar.getKey();
                                    if (!k.a(key, com.appnext.base.b.c.jt, cVar)) {
                                        l.k(key, " *** No Permission ***");
                                    } else if (com.appnext.base.b.c.jx.equalsIgnoreCase(cVar.ba())) {
                                        ReceiverService.this.b(cVar);
                                    }
                                }
                            }
                            ReceiverService.this.cq();
                        }
                    } catch (Throwable th) {
                    }
                }
            }).start();
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private void cp() {
        try {
            for (c unregister : this.iU) {
                unregister.unregister();
            }
            this.iU.clear();
        } catch (Throwable th) {
        }
    }

    private void cq() {
        Iterator listIterator = this.iU.listIterator();
        while (listIterator.hasNext()) {
            if (!((c) listIterator.next()).register()) {
                listIterator.remove();
            }
        }
    }

    public static String getOperationClassName(String str) {
        return "com.appnext.base.receivers.imp." + str;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        d.init(this);
        cm();
    }

    public void onDestroy() {
        cp();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
