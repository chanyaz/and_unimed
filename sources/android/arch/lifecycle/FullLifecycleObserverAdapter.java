package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    private final FullLifecycleObserver a;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.a = fullLifecycleObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        switch (event) {
            case ON_CREATE:
                this.a.onCreate(lifecycleOwner);
                return;
            case ON_START:
                this.a.onStart(lifecycleOwner);
                return;
            case ON_RESUME:
                this.a.onResume(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.a.onPause(lifecycleOwner);
                return;
            case ON_STOP:
                this.a.onStop(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.a.onDestroy(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
