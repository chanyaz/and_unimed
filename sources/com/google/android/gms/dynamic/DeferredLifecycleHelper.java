package com.google.android.gms.dynamic;

import android.os.Bundle;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    private T a;
    private Bundle b;
    private LinkedList<zza> c;
    private final OnDelegateCreatedListener<T> d = new d(this);

    interface zza {
        int getState();

        void zza(LifecycleDelegate lifecycleDelegate);
    }
}
