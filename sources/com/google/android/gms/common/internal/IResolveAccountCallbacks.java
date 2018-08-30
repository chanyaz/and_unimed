package com.google.android.gms.common.internal;

import android.os.IInterface;

public interface IResolveAccountCallbacks extends IInterface {
    void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse);
}
