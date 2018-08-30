package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class aa extends ThreadPoolExecutor {
    aa() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new at());
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
            return;
        }
        switch (networkInfo.getType()) {
            case 0:
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        a(1);
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                        a(2);
                        return;
                    case 13:
                    case 14:
                    case 15:
                        a(3);
                        return;
                    default:
                        a(3);
                        return;
                }
            case 1:
            case 6:
            case 9:
                a(4);
                return;
            default:
                a(3);
                return;
        }
    }

    public Future<?> submit(Runnable runnable) {
        Object abVar = new ab((d) runnable);
        execute(abVar);
        return abVar;
    }
}
