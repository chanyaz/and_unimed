package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public interface IGmsCallbacks extends IInterface {
    void onAccountValidationComplete(int i, Bundle bundle);

    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle);

    void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo);
}
