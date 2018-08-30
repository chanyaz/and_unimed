package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class e<TListener> {
    private TListener a;
    private boolean b = false;
    private final /* synthetic */ BaseGmsClient c;

    public e(BaseGmsClient baseGmsClient, TListener tListener) {
        this.c = baseGmsClient;
        this.a = tListener;
    }

    protected abstract void a();

    protected abstract void a(TListener tListener);

    public void b() {
        Object obj;
        synchronized (this) {
            obj = this.a;
            if (this.b) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e) {
                a();
                throw e;
            }
        }
        a();
        synchronized (this) {
            this.b = true;
        }
        c();
    }

    public void c() {
        d();
        synchronized (this.c.t) {
            this.c.t.remove(this);
        }
    }

    public void d() {
        synchronized (this) {
            this.a = null;
        }
    }
}
