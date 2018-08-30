package android.support.v4.os;

import android.os.Bundle;

class f extends b {
    final /* synthetic */ ResultReceiver a;

    f(ResultReceiver resultReceiver) {
        this.a = resultReceiver;
    }

    public void send(int i, Bundle bundle) {
        if (this.a.b != null) {
            this.a.b.post(new g(this.a, i, bundle));
        } else {
            this.a.a(i, bundle);
        }
    }
}
