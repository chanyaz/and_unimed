package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

interface zzq<TResult> {
    void cancel();

    void onComplete(@NonNull a<TResult> aVar);
}
