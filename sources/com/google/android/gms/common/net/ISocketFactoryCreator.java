package com.google.android.gms.common.net;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface ISocketFactoryCreator extends IInterface {
    IObjectWrapper newSocketFactory(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, boolean z);

    IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, String str);
}
