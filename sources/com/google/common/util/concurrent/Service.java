package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Beta
public interface Service {

    @Beta
    public enum State {
        NEW {
        },
        STARTING {
        },
        RUNNING {
        },
        STOPPING {
        },
        TERMINATED {
        },
        FAILED {
        }
    }

    void addListener(w wVar, Executor executor);

    void awaitRunning();

    void awaitRunning(long j, TimeUnit timeUnit);

    void awaitTerminated();

    void awaitTerminated(long j, TimeUnit timeUnit);

    Throwable failureCause();

    boolean isRunning();

    @Deprecated
    ListenableFuture<State> start();

    @Deprecated
    State startAndWait();

    Service startAsync();

    State state();

    @Deprecated
    ListenableFuture<State> stop();

    @Deprecated
    State stopAndWait();

    Service stopAsync();
}
