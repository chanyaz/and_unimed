package android.arch.lifecycle;

abstract class g {
    final Observer<T> c;
    boolean d;
    int e = -1;
    final /* synthetic */ LiveData f;

    g(LiveData liveData, Observer<T> observer) {
        this.f = liveData;
        this.c = observer;
    }

    void a(boolean z) {
        int i = 1;
        if (z != this.d) {
            this.d = z;
            int i2 = this.f.d == 0 ? 1 : 0;
            LiveData liveData = this.f;
            int c = liveData.d;
            if (!this.d) {
                i = -1;
            }
            liveData.d = i + c;
            if (i2 != 0 && this.d) {
                this.f.b();
            }
            if (this.f.d == 0 && !this.d) {
                this.f.c();
            }
            if (this.d) {
                this.f.b(this);
            }
        }
    }

    abstract boolean a();

    boolean a(LifecycleOwner lifecycleOwner) {
        return false;
    }

    void b() {
    }
}
