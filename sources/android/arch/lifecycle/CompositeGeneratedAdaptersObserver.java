package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter[] a;

    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.a = generatedAdapterArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        int i = 0;
        h hVar = new h();
        for (GeneratedAdapter callMethods : this.a) {
            callMethods.callMethods(lifecycleOwner, event, false, hVar);
        }
        GeneratedAdapter[] generatedAdapterArr = this.a;
        int length = generatedAdapterArr.length;
        while (i < length) {
            generatedAdapterArr[i].callMethods(lifecycleOwner, event, true, hVar);
            i++;
        }
    }
}
