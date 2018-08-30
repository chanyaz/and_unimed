package android.arch.lifecycle;

import android.arch.core.internal.a;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class d extends Lifecycle {
    private a<LifecycleObserver, e> a = new a();
    private State b;
    private final WeakReference<LifecycleOwner> c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<State> g = new ArrayList();

    public d(@NonNull LifecycleOwner lifecycleOwner) {
        this.c = new WeakReference(lifecycleOwner);
        this.b = State.INITIALIZED;
    }

    static State a(@NonNull State state, @Nullable State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void a(LifecycleOwner lifecycleOwner) {
        Iterator c = this.a.c();
        while (c.hasNext() && !this.f) {
            Entry entry = (Entry) c.next();
            e eVar = (e) entry.getValue();
            while (eVar.a.compareTo(this.b) < 0 && !this.f && this.a.c(entry.getKey())) {
                c(eVar.a);
                eVar.a(lifecycleOwner, e(eVar.a));
                c();
            }
        }
    }

    static State b(Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return State.STARTED;
            case ON_RESUME:
                return State.RESUMED;
            case ON_DESTROY:
                return State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private void b(State state) {
        if (this.b != state) {
            this.b = state;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private void b(LifecycleOwner lifecycleOwner) {
        Iterator b = this.a.b();
        while (b.hasNext() && !this.f) {
            Entry entry = (Entry) b.next();
            e eVar = (e) entry.getValue();
            while (eVar.a.compareTo(this.b) > 0 && !this.f && this.a.c(entry.getKey())) {
                Event d = d(eVar.a);
                c(b(d));
                eVar.a(lifecycleOwner, d);
                c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        State state = ((e) this.a.d().getValue()).a;
        State state2 = ((e) this.a.e().getValue()).a;
        boolean z = state == state2 && this.b == state2;
        return z;
    }

    private State c(LifecycleObserver lifecycleObserver) {
        Entry d = this.a.d(lifecycleObserver);
        return a(a(this.b, d != null ? ((e) d.getValue()).a : null), !this.g.isEmpty() ? (State) this.g.get(this.g.size() - 1) : null);
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(State state) {
        this.g.add(state);
    }

    private static Event d(State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Event.ON_DESTROY;
            case STARTED:
                return Event.ON_STOP;
            case RESUMED:
                return Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    private void d() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.c.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo(((e) this.a.d().getValue()).a) < 0) {
                b(lifecycleOwner);
            }
            Entry e = this.a.e();
            if (!(this.f || e == null || this.b.compareTo(((e) e.getValue()).a) <= 0)) {
                a(lifecycleOwner);
            }
        }
        this.f = false;
    }

    private static Event e(State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Event.ON_CREATE;
            case CREATED:
                return Event.ON_START;
            case STARTED:
                return Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    @NonNull
    public State a() {
        return this.b;
    }

    public void a(@NonNull Event event) {
        b(b(event));
    }

    @MainThread
    public void a(@NonNull State state) {
        b(state);
    }

    public void a(@NonNull LifecycleObserver lifecycleObserver) {
        e eVar = new e(lifecycleObserver, this.b == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((e) this.a.a(lifecycleObserver, eVar)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.c.get();
            if (lifecycleOwner != null) {
                Object obj = (this.d != 0 || this.e) ? 1 : null;
                Enum c = c(lifecycleObserver);
                this.d++;
                while (eVar.a.compareTo(c) < 0 && this.a.c(lifecycleObserver)) {
                    c(eVar.a);
                    eVar.a(lifecycleOwner, e(eVar.a));
                    c();
                    c = c(lifecycleObserver);
                }
                if (obj == null) {
                    d();
                }
                this.d--;
            }
        }
    }

    public void b(@NonNull LifecycleObserver lifecycleObserver) {
        this.a.b(lifecycleObserver);
    }
}
