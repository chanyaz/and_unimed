package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ReportFragment;
import android.arch.lifecycle.d;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.s;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SupportActivity extends Activity implements LifecycleOwner {
    private s<Class<? extends Object>, Object> a = new s();
    private d b = new d(this);

    public Lifecycle getLifecycle() {
        return this.b;
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.a((Activity) this);
    }

    @CallSuper
    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(State.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
