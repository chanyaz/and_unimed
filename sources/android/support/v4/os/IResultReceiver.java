package android.support.v4.os;

import android.os.Bundle;
import android.os.IInterface;

public interface IResultReceiver extends IInterface {
    void send(int i, Bundle bundle);
}
