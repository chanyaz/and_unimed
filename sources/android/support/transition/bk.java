package android.support.transition;

import android.os.IBinder;
import android.support.annotation.RequiresApi;

@RequiresApi(14)
class bk implements WindowIdImpl {
    private final IBinder a;

    bk(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bk) && ((bk) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
