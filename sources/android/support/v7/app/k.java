package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.view.ActionMode;
import android.support.v7.view.f;
import android.support.v7.widget.db;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

@RequiresApi(14)
abstract class k extends AppCompatDelegate {
    private static boolean m = true;
    private static final boolean n = (VERSION.SDK_INT < 21);
    private static final int[] o = new int[]{16842836};
    final Context a;
    final Window b;
    final Callback c = this.b.getCallback();
    final Callback d;
    final AppCompatCallback e;
    ActionBar f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence p;
    private boolean q;
    private boolean r;

    static {
        if (n && !m) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                private boolean a(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    return message != null ? message.contains("drawable") || message.contains("Drawable") : false;
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Throwable notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    k(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.a = context;
        this.b = window;
        this.e = appCompatCallback;
        if (this.c instanceof m) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = a(this.c);
        this.b.setCallback(this.d);
        db a = db.a(context, null, o);
        Drawable b = a.b(0);
        if (b != null) {
            this.b.setBackgroundDrawable(b);
        }
        a.a();
    }

    public ActionBar a() {
        m();
        return this.f;
    }

    abstract ActionMode a(ActionMode.Callback callback);

    Callback a(Callback callback) {
        return new m(this, callback);
    }

    abstract void a(int i, Menu menu);

    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    public MenuInflater b() {
        if (this.g == null) {
            m();
            this.g = new f(this.f != null ? this.f.e() : this.a);
        }
        return this.g;
    }

    abstract void b(CharSequence charSequence);

    abstract boolean b(int i, Menu menu);

    public void c() {
        this.q = true;
    }

    public void c(Bundle bundle) {
    }

    public void d() {
        this.q = false;
    }

    public void g() {
        this.r = true;
    }

    public final Delegate h() {
        return new l(this);
    }

    public boolean j() {
        return false;
    }

    abstract void m();

    final ActionBar n() {
        return this.f;
    }

    final Context o() {
        Context context = null;
        ActionBar a = a();
        if (a != null) {
            context = a.e();
        }
        return context == null ? this.a : context;
    }

    public boolean p() {
        return false;
    }

    final boolean q() {
        return this.r;
    }

    final Callback r() {
        return this.b.getCallback();
    }

    final CharSequence s() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.p;
    }
}
