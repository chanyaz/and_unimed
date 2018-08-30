package com.squareup.picasso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class i {
    final k a = new k();
    final Context b;
    final ExecutorService c;
    final Downloader d;
    final Map<String, d> e;
    final Map<Object, a> f;
    final Map<Object, a> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final Cache k;
    final ai l;
    final List<d> m;
    final l n;
    final boolean o;
    boolean p;

    i(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, ai aiVar) {
        this.a.start();
        ao.a(this.a.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new j(this.a.getLooper(), this);
        this.d = downloader;
        this.j = handler;
        this.k = cache;
        this.l = aiVar;
        this.m = new ArrayList(4);
        this.p = ao.d(this.b);
        this.o = ao.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new l(this);
        this.n.a();
    }

    private void a(List<d> list) {
        if (list != null && !list.isEmpty() && ((d) list.get(0)).j().l) {
            StringBuilder stringBuilder = new StringBuilder();
            for (d dVar : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(ao.a(dVar));
            }
            ao.a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }

    private void b() {
        if (!this.f.isEmpty()) {
            Iterator it = this.f.values().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                it.remove();
                if (aVar.j().l) {
                    ao.a("Dispatcher", "replaying", aVar.c().a());
                }
                a(aVar, false);
            }
        }
    }

    private void e(a aVar) {
        Object d = aVar.d();
        if (d != null) {
            aVar.k = true;
            this.f.put(d, aVar);
        }
    }

    private void f(d dVar) {
        a i = dVar.i();
        if (i != null) {
            e(i);
        }
        List k = dVar.k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                e((a) k.get(i2));
            }
        }
    }

    private void g(d dVar) {
        if (!dVar.c()) {
            this.m.add(dVar);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    void a() {
        List arrayList = new ArrayList(this.m);
        this.m.clear();
        this.j.sendMessage(this.j.obtainMessage(8, arrayList));
        a(arrayList);
    }

    void a(NetworkInfo networkInfo) {
        this.i.sendMessage(this.i.obtainMessage(9, networkInfo));
    }

    void a(a aVar) {
        this.i.sendMessage(this.i.obtainMessage(1, aVar));
    }

    void a(a aVar, boolean z) {
        if (this.h.contains(aVar.l())) {
            this.g.put(aVar.d(), aVar);
            if (aVar.j().l) {
                ao.a("Dispatcher", "paused", aVar.b.a(), "because tag '" + aVar.l() + "' is paused");
                return;
            }
            return;
        }
        d dVar = (d) this.e.get(aVar.e());
        if (dVar != null) {
            dVar.a(aVar);
        } else if (!this.c.isShutdown()) {
            Object a = d.a(aVar.j(), this, this.k, this.l, aVar);
            a.n = this.c.submit(a);
            this.e.put(aVar.e(), a);
            if (z) {
                this.f.remove(aVar.d());
            }
            if (aVar.j().l) {
                ao.a("Dispatcher", "enqueued", aVar.b.a());
            }
        } else if (aVar.j().l) {
            ao.a("Dispatcher", "ignored", aVar.b.a(), "because shut down");
        }
    }

    void a(d dVar) {
        this.i.sendMessage(this.i.obtainMessage(4, dVar));
    }

    void a(d dVar, boolean z) {
        if (dVar.j().l) {
            ao.a("Dispatcher", "batched", ao.a(dVar), "for error" + (z ? " (will replay)" : ""));
        }
        this.e.remove(dVar.f());
        g(dVar);
    }

    void a(Object obj) {
        if (this.h.add(obj)) {
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                boolean z = dVar.j().l;
                a i = dVar.i();
                List k = dVar.k();
                Object obj2 = (k == null || k.isEmpty()) ? null : 1;
                if (i != null || obj2 != null) {
                    if (i != null && i.l().equals(obj)) {
                        dVar.b(i);
                        this.g.put(i.d(), i);
                        if (z) {
                            ao.a("Dispatcher", "paused", i.b.a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (obj2 != null) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            a aVar = (a) k.get(size);
                            if (aVar.l().equals(obj)) {
                                dVar.b(aVar);
                                this.g.put(aVar.d(), aVar);
                                if (z) {
                                    ao.a("Dispatcher", "paused", aVar.b.a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (dVar.b()) {
                        it.remove();
                        if (z) {
                            ao.a("Dispatcher", "canceled", ao.a(dVar), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void a(boolean z) {
        this.i.sendMessage(this.i.obtainMessage(10, z ? 1 : 0, 0));
    }

    void b(NetworkInfo networkInfo) {
        if (this.c instanceof aa) {
            ((aa) this.c).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            b();
        }
    }

    void b(a aVar) {
        this.i.sendMessage(this.i.obtainMessage(2, aVar));
    }

    void b(d dVar) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, dVar), 500);
    }

    void b(Object obj) {
        if (this.h.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.g.values().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.l().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(aVar);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.j.sendMessage(this.j.obtainMessage(13, obj2));
            }
        }
    }

    void b(boolean z) {
        this.p = z;
    }

    void c(a aVar) {
        a(aVar, true);
    }

    void c(d dVar) {
        this.i.sendMessage(this.i.obtainMessage(6, dVar));
    }

    void d(a aVar) {
        String e = aVar.e();
        d dVar = (d) this.e.get(e);
        if (dVar != null) {
            dVar.b(aVar);
            if (dVar.b()) {
                this.e.remove(e);
                if (aVar.j().l) {
                    ao.a("Dispatcher", "canceled", aVar.c().a());
                }
            }
        }
        if (this.h.contains(aVar.l())) {
            this.g.remove(aVar.d());
            if (aVar.j().l) {
                ao.a("Dispatcher", "canceled", aVar.c().a(), "because paused request got canceled");
            }
        }
        a aVar2 = (a) this.f.remove(aVar.d());
        if (aVar2 != null && aVar2.j().l) {
            ao.a("Dispatcher", "canceled", aVar2.c().a(), "from replaying");
        }
    }

    void d(d dVar) {
        boolean z = true;
        if (!dVar.c()) {
            if (this.c.isShutdown()) {
                a(dVar, false);
                return;
            }
            NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) ao.a(this.b, "connectivity")).getActiveNetworkInfo() : null;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean a = dVar.a(this.p, activeNetworkInfo);
            boolean d = dVar.d();
            if (!a) {
                if (!(this.o && d)) {
                    z = false;
                }
                a(dVar, z);
                if (z) {
                    f(dVar);
                }
            } else if (!this.o || z2) {
                if (dVar.j().l) {
                    ao.a("Dispatcher", "retrying", ao.a(dVar));
                }
                if (dVar.l() instanceof v) {
                    dVar.i |= NetworkPolicy.NO_CACHE.d;
                }
                dVar.n = this.c.submit(dVar);
            } else {
                a(dVar, d);
                if (d) {
                    f(dVar);
                }
            }
        }
    }

    void e(d dVar) {
        if (MemoryPolicy.b(dVar.g())) {
            this.k.set(dVar.f(), dVar.e());
        }
        this.e.remove(dVar.f());
        g(dVar);
        if (dVar.j().l) {
            ao.a("Dispatcher", "batched", ao.a(dVar), "for completion");
        }
    }
}
