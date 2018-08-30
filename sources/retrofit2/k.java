package retrofit2;

import java.io.IOException;
import java.util.concurrent.Executor;
import okhttp3.ad;

final class k<T> implements Call<T> {
    final Executor a;
    final Call<T> b;

    k(Executor executor, Call<T> call) {
        this.a = executor;
        this.b = call;
    }

    public void cancel() {
        this.b.cancel();
    }

    public Call<T> clone() {
        return new k(this.a, this.b.clone());
    }

    public void enqueue(final Callback<T> callback) {
        an.a((Object) callback, "callback == null");
        this.b.enqueue(new Callback<T>() {
            public void onFailure(Call<T> call, final Throwable th) {
                k.this.a.execute(new Runnable() {
                    public void run() {
                        callback.onFailure(k.this, th);
                    }
                });
            }

            public void onResponse(Call<T> call, final ai<T> aiVar) {
                k.this.a.execute(new Runnable() {
                    public void run() {
                        if (k.this.b.isCanceled()) {
                            callback.onFailure(k.this, new IOException("Canceled"));
                        } else {
                            callback.onResponse(k.this, aiVar);
                        }
                    }
                });
            }
        });
    }

    public ai<T> execute() {
        return this.b.execute();
    }

    public boolean isCanceled() {
        return this.b.isCanceled();
    }

    public boolean isExecuted() {
        return this.b.isExecuted();
    }

    public ad request() {
        return this.b.request();
    }
}
