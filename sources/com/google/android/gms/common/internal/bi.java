package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.StatusConverter;

final class bi implements StatusConverter {
    bi() {
    }

    public final ApiException convert(Status status) {
        return b.a(status);
    }
}
