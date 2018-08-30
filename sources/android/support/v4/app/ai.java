package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.i;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ai<D> extends i<D> implements OnLoadCompleteListener<D> {
    private final int a;
    @Nullable
    private final Bundle b;
    @NonNull
    private final Loader<D> c;
    private LifecycleOwner d;
    private aj<D> e;
    private Loader<D> f;

    @MainThread
    Loader<D> a(boolean z) {
        if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.c.c();
        this.c.g();
        Observer observer = this.e;
        if (observer != null) {
            a(observer);
            if (z) {
                observer.b();
            }
        }
        this.c.a((OnLoadCompleteListener) this);
        if ((observer == null || observer.a()) && !z) {
            return this.c;
        }
        this.c.i();
        return this.f;
    }

    public void a(@NonNull Observer<D> observer) {
        super.a((Observer) observer);
        this.d = null;
        this.e = null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mArgs=");
        printWriter.println(this.b);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.c);
        this.c.a(str + "  ", fileDescriptor, printWriter, strArr);
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.e);
            this.e.a(str + "  ", printWriter);
        }
        printWriter.print(str);
        printWriter.print("mData=");
        printWriter.println(f().a(a()));
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.println(d());
    }

    protected void b() {
        if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Starting: " + this);
        }
        this.c.a();
    }

    public void b(D d) {
        super.b(d);
        if (this.f != null) {
            this.f.i();
            this.f = null;
        }
    }

    protected void c() {
        if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.c.e();
    }

    @NonNull
    Loader<D> f() {
        return this.c;
    }

    void g() {
        LifecycleOwner lifecycleOwner = this.d;
        Observer observer = this.e;
        if (lifecycleOwner != null && observer != null) {
            super.a(observer);
            a(lifecycleOwner, observer);
        }
    }

    public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
        if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(d);
            return;
        }
        if (LoaderManagerImpl.a) {
            Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
        }
        a(d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.a);
        stringBuilder.append(" : ");
        d.a(this.c, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
