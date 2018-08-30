package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

public abstract class n {
    private final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public int a(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public Parcelable a() {
        return null;
    }

    @Deprecated
    @NonNull
    public Object a(@NonNull View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @NonNull
    public Object a(@NonNull ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(@NonNull DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public void a(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Deprecated
    public void a(@NonNull View view) {
    }

    @Deprecated
    public void a(@NonNull View view, int i, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(@NonNull ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public void a(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        a((View) viewGroup, i, obj);
    }

    public abstract boolean a(@NonNull View view, @NonNull Object obj);

    public abstract int b();

    public void b(@NonNull DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void b(@NonNull View view) {
    }

    @Deprecated
    public void b(@NonNull View view, int i, @NonNull Object obj) {
    }

    public void b(@NonNull ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    public void b(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        b((View) viewGroup, i, obj);
    }

    @Nullable
    public CharSequence c(int i) {
        return null;
    }

    public void c() {
        synchronized (this) {
            if (this.b != null) {
                this.b.onChanged();
            }
        }
        this.a.notifyChanged();
    }

    void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    public float d(int i) {
        return 1.0f;
    }
}
