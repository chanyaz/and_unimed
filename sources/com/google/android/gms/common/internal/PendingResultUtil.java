package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class PendingResultUtil {
    private static final StatusConverter a = new bi();

    public interface ResultConverter<R extends Result, T> {
        T convert(R r);
    }

    public interface StatusConverter {
        ApiException convert(Status status);
    }
}
