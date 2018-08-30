package com.google.android.gms.dynamite;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface IDynamiteLoaderV2 extends IInterface {
    IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr);

    IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2);
}
