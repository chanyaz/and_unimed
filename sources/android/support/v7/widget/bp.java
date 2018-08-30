package android.support.v7.widget;

import android.database.Observable;
import android.support.annotation.Nullable;

class bp extends Observable<bq> {
    bp() {
    }

    public void a(int i, int i2) {
        a(i, i2, null);
    }

    public void a(int i, int i2, @Nullable Object obj) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((bq) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }

    public boolean a() {
        return !this.mObservers.isEmpty();
    }

    public void b() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((bq) this.mObservers.get(size)).onChanged();
        }
    }

    public void b(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((bq) this.mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    public void c(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((bq) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }

    public void d(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((bq) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
        }
    }
}
