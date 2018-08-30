package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class b {
    @NonNull
    public static ApiException a(@NonNull Status status) {
        return status.b() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
