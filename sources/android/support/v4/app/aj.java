package android.support.v4.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import java.io.PrintWriter;

class aj<D> implements Observer<D> {
    @NonNull
    private final Loader<D> a;
    @NonNull
    private final LoaderCallbacks<D> b;
    private boolean c;

    public void a(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mDeliveredData=");
        printWriter.println(this.c);
    }

    boolean a() {
        return this.c;
    }

    @MainThread
    void b() {
        if (this.c) {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Resetting: " + this.a);
            }
            this.b.onLoaderReset(this.a);
        }
    }

    public void onChanged(@Nullable D d) {
        if (LoaderManagerImpl.a) {
            Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a((Object) d));
        }
        this.b.onLoadFinished(this.a, d);
        this.c = true;
    }

    public String toString() {
        return this.b.toString();
    }
}
