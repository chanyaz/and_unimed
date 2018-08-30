package com.puzzlersworld.android.util;

public interface PermissionCallBack {
    void onPermissionsDenied(int i, Object obj);

    void onPermissionsGranted(int i, Object obj);
}
