package com.puzzlersworld.android.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.a;

public class i {
    private Object a;
    private PermissionCallBack b;
    private int c;

    public void a(int i) {
        if (i == this.c) {
            this.b.onPermissionsGranted(i, this.a);
        }
    }

    public void a(Activity activity, String[] strArr, int i, Object obj, PermissionCallBack permissionCallBack) {
        this.a = obj;
        this.b = permissionCallBack;
        this.c = i;
        if (a.b((Context) activity, strArr[0]) == 0) {
            this.b.onPermissionsGranted(i, obj);
        } else if (ActivityCompat.a(activity, strArr[0])) {
            ActivityCompat.a(activity, strArr, i);
        } else {
            ActivityCompat.a(activity, strArr, i);
        }
    }

    public void b(int i) {
        if (i == this.c) {
            this.b.onPermissionsDenied(i, this.a);
        }
    }
}
