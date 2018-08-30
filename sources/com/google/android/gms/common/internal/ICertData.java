package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface ICertData extends IInterface {
    IObjectWrapper getBytesWrapped();

    int getHashCode();
}
