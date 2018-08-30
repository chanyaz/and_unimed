package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class e {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;
    boolean d;

    e(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.a = intentFilter;
        this.b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.a);
        if (this.d) {
            stringBuilder.append(" DEAD");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
