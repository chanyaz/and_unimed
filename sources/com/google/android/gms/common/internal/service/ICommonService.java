package com.google.android.gms.common.internal.service;

import android.os.IInterface;

public interface ICommonService extends IInterface {
    void clearDefaultAccount(ICommonCallbacks iCommonCallbacks);
}
