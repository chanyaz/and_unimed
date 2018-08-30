package com.google.android.gms.common.util.a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class a implements Executor {
    private final Handler a;

    public a(Looper looper) {
        this.a = new Handler(looper);
    }

    public void execute(@NonNull Runnable runnable) {
        this.a.post(runnable);
    }
}
