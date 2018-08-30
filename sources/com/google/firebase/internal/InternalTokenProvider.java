package com.google.firebase.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.a;

@KeepForSdk
public interface InternalTokenProvider {
    @KeepForSdk
    a<Object> getAccessToken(boolean z);

    @Nullable
    @KeepForSdk
    String getUid();
}
