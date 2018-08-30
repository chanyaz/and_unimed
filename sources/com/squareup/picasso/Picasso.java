package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class Picasso {
    static final Handler a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            List list;
            int size;
            int i;
            switch (message.what) {
                case 3:
                    a aVar = (a) message.obj;
                    if (aVar.j().l) {
                        ao.a("Main", "canceled", aVar.b.a(), "target got garbage collected");
                    }
                    aVar.a.a(aVar.d());
                    return;
                case 8:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        d dVar = (d) list.get(i);
                        dVar.b.a(dVar);
                    }
                    return;
                case 13:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        a aVar2 = (a) list.get(i);
                        aVar2.a.c(aVar2);
                    }
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    };
    static volatile Picasso b = null;
    final Context c;
    final i d;
    final Cache e;
    final ai f;
    final Map<Object, a> g;
    final Map<ImageView, h> h;
    final ReferenceQueue<Object> i;
    final Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final Listener n;
    private final RequestTransformer o;
    private final y p;
    private final List<af> q;

    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception);
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int d;

        private LoadedFrom(int i) {
            this.d = i;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public interface RequestTransformer {
        public static final RequestTransformer a = new RequestTransformer() {
            public ac transformRequest(ac acVar) {
                return acVar;
            }
        };

        ac transformRequest(ac acVar);
    }

    Picasso(Context context, i iVar, Cache cache, Listener listener, RequestTransformer requestTransformer, List<af> list, ai aiVar, Config config, boolean z, boolean z2) {
        this.c = context;
        this.d = iVar;
        this.e = cache;
        this.n = listener;
        this.o = requestTransformer;
        this.j = config;
        List arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ah(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new e(context));
        arrayList.add(new s(context));
        arrayList.add(new g(context));
        arrayList.add(new c(context));
        arrayList.add(new n(context));
        arrayList.add(new u(iVar.d, aiVar));
        this.q = Collections.unmodifiableList(arrayList);
        this.f = aiVar;
        this.g = new WeakHashMap();
        this.h = new WeakHashMap();
        this.k = z;
        this.l = z2;
        this.i = new ReferenceQueue();
        this.p = new y(this.i, a);
        this.p.start();
    }

    public static Picasso a(Context context) {
        if (b == null) {
            synchronized (Picasso.class) {
                if (b == null) {
                    b = new x(context).a();
                }
            }
        }
        return b;
    }

    private void a(Bitmap bitmap, LoadedFrom loadedFrom, a aVar) {
        if (!aVar.f()) {
            if (!aVar.g()) {
                this.g.remove(aVar.d());
            }
            if (bitmap == null) {
                aVar.a();
                if (this.l) {
                    ao.a("Main", "errored", aVar.b.a());
                }
            } else if (loadedFrom == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                aVar.a(bitmap, loadedFrom);
                if (this.l) {
                    ao.a("Main", "completed", aVar.b.a(), "from " + loadedFrom);
                }
            }
        }
    }

    private void a(Object obj) {
        ao.b();
        a aVar = (a) this.g.remove(obj);
        if (aVar != null) {
            aVar.b();
            this.d.b(aVar);
        }
        if (obj instanceof ImageView) {
            h hVar = (h) this.h.remove((ImageView) obj);
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    ac a(ac acVar) {
        ac transformRequest = this.o.transformRequest(acVar);
        if (transformRequest != null) {
            return transformRequest;
        }
        throw new IllegalStateException("Request transformer " + this.o.getClass().getCanonicalName() + " returned null for " + acVar);
    }

    public ae a(int i) {
        if (i != 0) {
            return new ae(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public ae a(Uri uri) {
        return new ae(this, uri, 0);
    }

    public ae a(String str) {
        if (str == null) {
            return new ae(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    List<af> a() {
        return this.q;
    }

    public void a(ImageView imageView) {
        a((Object) imageView);
    }

    void a(ImageView imageView, h hVar) {
        this.h.put(imageView, hVar);
    }

    public void a(Target target) {
        a((Object) target);
    }

    void a(a aVar) {
        Object d = aVar.d();
        if (!(d == null || this.g.get(d) == aVar)) {
            a(d);
            this.g.put(d, aVar);
        }
        b(aVar);
    }

    void a(d dVar) {
        Object obj = 1;
        a i = dVar.i();
        List k = dVar.k();
        Object obj2 = (k == null || k.isEmpty()) ? null : 1;
        if (i == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = dVar.h().d;
            Exception l = dVar.l();
            Bitmap e = dVar.e();
            LoadedFrom m = dVar.m();
            if (i != null) {
                a(e, m, i);
            }
            if (obj2 != null) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(e, m, (a) k.get(i2));
                }
            }
            if (this.n != null && l != null) {
                this.n.onImageLoadFailed(this, uri, l);
            }
        }
    }

    Bitmap b(String str) {
        Bitmap bitmap = this.e.get(str);
        if (bitmap != null) {
            this.f.a();
        } else {
            this.f.b();
        }
        return bitmap;
    }

    void b(a aVar) {
        this.d.a(aVar);
    }

    void c(a aVar) {
        Bitmap bitmap = null;
        if (MemoryPolicy.a(aVar.e)) {
            bitmap = b(aVar.e());
        }
        if (bitmap != null) {
            a(bitmap, LoadedFrom.MEMORY, aVar);
            if (this.l) {
                ao.a("Main", "completed", aVar.b.a(), "from " + LoadedFrom.MEMORY);
                return;
            }
            return;
        }
        a(aVar);
        if (this.l) {
            ao.a("Main", "resumed", aVar.b.a());
        }
    }
}
