package android.arch.lifecycle;

import android.arch.core.a.a;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LiveData$android.arch.lifecycle.g;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    private static final Object b = new Object();
    private final Object a = new Object();
    private SafeIterableMap<Observer<T>, g> c = new SafeIterableMap();
    private int d = 0;
    private volatile Object e = b;
    private volatile Object f = b;
    private int g = -1;
    private boolean h;
    private boolean i;
    private final Runnable j = new Runnable() {
        public void run() {
            Object b;
            synchronized (LiveData.this.a) {
                b = LiveData.this.f;
                LiveData.this.f = LiveData.b;
            }
            LiveData.this.b(b);
        }
    };

    class LifecycleBoundObserver extends g implements GenericLifecycleObserver {
        @NonNull
        final LifecycleOwner a;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
            super(LiveData.this, observer);
            this.a = lifecycleOwner;
        }

        boolean a() {
            return this.a.getLifecycle().a().a(State.STARTED);
        }

        boolean a(LifecycleOwner lifecycleOwner) {
            return this.a == lifecycleOwner;
        }

        void b() {
            this.a.getLifecycle().b(this);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            if (this.a.getLifecycle().a() == State.DESTROYED) {
                LiveData.this.a(this.c);
            } else {
                a(a());
            }
        }
    }

    private void a(g gVar) {
        if (!gVar.d) {
            return;
        }
        if (!gVar.a()) {
            gVar.a(false);
        } else if (gVar.e < this.g) {
            gVar.e = this.g;
            gVar.c.onChanged(this.e);
        }
    }

    private static void a(String str) {
        if (!a.a().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }

    private void b(@Nullable g gVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            g gVar2;
            if (gVar2 == null) {
                Iterator c = this.c.c();
                while (c.hasNext()) {
                    a((g) ((Entry) c.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
            a(gVar2);
            gVar2 = null;
        } while (this.i);
        this.h = false;
    }

    @Nullable
    public T a() {
        T t = this.e;
        return t != b ? t : null;
    }

    @MainThread
    public void a(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().a() != State.DESTROYED) {
            LifecycleObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            g gVar = (g) this.c.a(observer, lifecycleBoundObserver);
            if (gVar != null && !gVar.a(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (gVar == null) {
                lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void a(@NonNull Observer<T> observer) {
        a("removeObserver");
        g gVar = (g) this.c.b(observer);
        if (gVar != null) {
            gVar.b();
            gVar.a(false);
        }
    }

    protected void a(T t) {
        Object obj;
        synchronized (this.a) {
            obj = this.f == b ? 1 : null;
            this.f = t;
        }
        if (obj != null) {
            a.a().b(this.j);
        }
    }

    protected void b() {
    }

    @MainThread
    protected void b(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        b(null);
    }

    protected void c() {
    }

    public boolean d() {
        return this.d > 0;
    }
}
