package com.google.firebase.iid;

import android.os.Bundle;

final class c extends d<Void> {
    c(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a(null);
        } else {
            a(new zzac(4, "Invalid response to one way request"));
        }
    }

    final boolean a() {
        return true;
    }
}
