package android.support.v4.content;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    int a;
    OnLoadCompleteListener<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d);
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> loader);
    }

    @NonNull
    public String a(@Nullable D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @MainThread
    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    @MainThread
    public void a(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }

    @MainThread
    protected void b() {
    }

    @MainThread
    public boolean c() {
        return d();
    }

    @MainThread
    protected boolean d() {
        return false;
    }

    @MainThread
    public void e() {
        this.c = false;
        f();
    }

    @MainThread
    protected void f() {
    }

    @MainThread
    public void g() {
        this.d = true;
        h();
    }

    @MainThread
    protected void h() {
    }

    @MainThread
    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    @MainThread
    protected void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
