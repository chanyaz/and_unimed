package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.p;
import android.support.v4.util.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({Scope.LIBRARY})
public final class n<T> {
    private final Pool<ArrayList<T>> a = new p(10);
    private final s<T, ArrayList<T>> b = new s();
    private final ArrayList<T> c = new ArrayList();
    private final HashSet<T> d = new HashSet();

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private void a(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.release(arrayList);
    }

    @NonNull
    private ArrayList<T> c() {
        ArrayList<T> arrayList = (ArrayList) this.a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public void a() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.b.c(i);
            if (arrayList != null) {
                a(arrayList);
            }
        }
        this.b.clear();
    }

    public void a(@NonNull T t) {
        if (!this.b.containsKey(t)) {
            this.b.put(t, null);
        }
    }

    public void a(@NonNull T t, @NonNull T t2) {
        if (this.b.containsKey(t) && this.b.containsKey(t2)) {
            ArrayList arrayList = (ArrayList) this.b.get(t);
            if (arrayList == null) {
                arrayList = c();
                this.b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    @NonNull
    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a(this.b.b(i), this.c, this.d);
        }
        return this.c;
    }

    public boolean b(@NonNull T t) {
        return this.b.containsKey(t);
    }

    @Nullable
    public List c(@NonNull T t) {
        return (List) this.b.get(t);
    }

    @Nullable
    public List<T> d(@NonNull T t) {
        List<T> list = null;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.b.c(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.b.b(i));
                list = arrayList;
            }
        }
        return list;
    }

    public boolean e(@NonNull T t) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.b.c(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
