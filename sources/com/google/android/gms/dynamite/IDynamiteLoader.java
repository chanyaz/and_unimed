package com.google.android.gms.dynamite;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface IDynamiteLoader extends IInterface {
    IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i);

    int getModuleVersion(IObjectWrapper iObjectWrapper, String str);

    int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z);
}
