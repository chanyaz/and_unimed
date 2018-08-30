package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class SnackbarManager {
    private static SnackbarManager a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new android.os.Handler.Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SnackbarManager.this.a((aa) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });
    private aa d;
    private aa e;

    interface Callback {
        void dismiss(int i);

        void show();
    }

    private SnackbarManager() {
    }

    static SnackbarManager a() {
        if (a == null) {
            a = new SnackbarManager();
        }
        return a;
    }

    private boolean a(aa aaVar, int i) {
        Callback callback = (Callback) aaVar.a.get();
        if (callback == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(aaVar);
        callback.dismiss(i);
        return true;
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            Callback callback = (Callback) this.d.a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.d = null;
            }
        }
    }

    private void b(aa aaVar) {
        if (aaVar.b != -2) {
            int i = 2750;
            if (aaVar.b > 0) {
                i = aaVar.b;
            } else if (aaVar.b == -1) {
                i = 1500;
            }
            this.c.removeCallbacksAndMessages(aaVar);
            this.c.sendMessageDelayed(Message.obtain(this.c, 0, aaVar), (long) i);
        }
    }

    private boolean f(Callback callback) {
        return this.d != null && this.d.a(callback);
    }

    private boolean g(Callback callback) {
        return this.e != null && this.e.a(callback);
    }

    public void a(Callback callback) {
        synchronized (this.b) {
            if (f(callback)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void a(Callback callback, int i) {
        synchronized (this.b) {
            if (f(callback)) {
                a(this.d, i);
            } else if (g(callback)) {
                a(this.e, i);
            }
        }
    }

    void a(aa aaVar) {
        synchronized (this.b) {
            if (this.d == aaVar || this.e == aaVar) {
                a(aaVar, 2);
            }
        }
    }

    public void b(Callback callback) {
        synchronized (this.b) {
            if (f(callback)) {
                b(this.d);
            }
        }
    }

    public void c(Callback callback) {
        synchronized (this.b) {
            if (f(callback) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(Callback callback) {
        synchronized (this.b) {
            if (f(callback) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public boolean e(Callback callback) {
        boolean z;
        synchronized (this.b) {
            z = f(callback) || g(callback);
        }
        return z;
    }
}
