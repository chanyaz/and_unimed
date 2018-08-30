package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ai;

final class l<T> implements Call<T> {
    private final al<T, ?> a;
    @Nullable
    private final Object[] b;
    private volatile boolean c;
    @GuardedBy("this")
    @Nullable
    private Call d;
    @GuardedBy("this")
    @Nullable
    private Throwable e;
    @GuardedBy("this")
    private boolean f;

    l(al<T, ?> alVar, @Nullable Object[] objArr) {
        this.a = alVar;
        this.b = objArr;
    }

    private Call b() {
        Call newCall = this.a.c.newCall(this.a.a(this.b));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    ai<T> a(ag agVar) {
        ai g = agVar.g();
        ag a = agVar.h().a(new n(g.a(), g.b())).a();
        int b = a.b();
        if (b < 200 || b >= 300) {
            try {
                ai<T> a2 = ai.a(an.a(g), a);
                return a2;
            } finally {
                g.close();
            }
        } else if (b == 204 || b == 205) {
            g.close();
            return ai.a(null, a);
        } else {
            ai mVar = new m(g);
            try {
                return ai.a(this.a.a(mVar), a);
            } catch (RuntimeException e) {
                mVar.g();
                throw e;
            }
        }
    }

    /* renamed from: a */
    public l<T> clone() {
        return new l(this.a, this.b);
    }

    public void cancel() {
        Call call;
        this.c = true;
        synchronized (this) {
            call = this.d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public void enqueue(final Callback<T> callback) {
        Throwable th;
        Call b;
        an.a((Object) callback, "callback == null");
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f = true;
            Call call = this.d;
            th = this.e;
            if (call == null && th == null) {
                try {
                    b = b();
                    this.d = b;
                } catch (Throwable th2) {
                    th = th2;
                    this.e = th;
                    b = call;
                }
            } else {
                b = call;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.c) {
            b.cancel();
        }
        b.enqueue(new Callback() {
            private void a(Throwable th) {
                try {
                    callback.onFailure(l.this, th);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }

            private void a(ai<T> aiVar) {
                try {
                    callback.onResponse(l.this, aiVar);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                try {
                    callback.onFailure(l.this, iOException);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onResponse(Call call, ag agVar) {
                try {
                    a(l.this.a(agVar));
                } catch (Throwable th) {
                    a(th);
                }
            }
        });
    }

    public ai<T> execute() {
        Call call;
        Throwable e;
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f = true;
            if (this.e == null) {
                call = this.d;
                if (call == null) {
                    try {
                        call = b();
                        this.d = call;
                    } catch (IOException e2) {
                        e = e2;
                        this.e = e;
                        throw e;
                    } catch (RuntimeException e3) {
                        e = e3;
                        this.e = e;
                        throw e;
                    }
                }
            } else if (this.e instanceof IOException) {
                throw ((IOException) this.e);
            } else {
                throw ((RuntimeException) this.e);
            }
        }
        if (this.c) {
            call.cancel();
        }
        return a(call.execute());
    }

    public boolean isCanceled() {
        boolean z = true;
        if (!this.c) {
            synchronized (this) {
                if (this.d == null || !this.d.isCanceled()) {
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized boolean isExecuted() {
        return this.f;
    }

    public synchronized ad request() {
        ad request;
        Call call = this.d;
        if (call != null) {
            request = call.request();
        } else if (this.e == null) {
            try {
                call = b();
                this.d = call;
                request = call.request();
            } catch (Throwable e) {
                this.e = e;
                throw e;
            } catch (Throwable e2) {
                this.e = e2;
                throw new RuntimeException("Unable to create request.", e2);
            }
        } else if (this.e instanceof IOException) {
            throw new RuntimeException("Unable to create request.", this.e);
        } else {
            throw ((RuntimeException) this.e);
        }
        return request;
    }
}
