package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.collect.MapMaker;
import com.google.common.collect.fb;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Beta
public class CycleDetectingLockFactory {
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, e>> a = new MapMaker().e().k();
    private static final Logger b = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    private static final ThreadLocal<ArrayList<e>> c = new ThreadLocal<ArrayList<e>>() {
        /* renamed from: a */
        protected ArrayList<e> initialValue() {
            return fb.b(3);
        }
    };

    interface CycleDetectingLock {
        e getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    @ThreadSafe
    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @Beta
    public enum Policies implements Policy {
        THROW {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.b.log(Level.SEVERE, "Detected potential deadlock", potentialDeadlockException);
            }
        },
        DISABLED {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }
    }

    @Beta
    public final class PotentialDeadlockException extends d {
        private final d c;

        public String getMessage() {
            StringBuilder stringBuilder = new StringBuilder(super.getMessage());
            for (Throwable th = this.c; th != null; th = th.getCause()) {
                stringBuilder.append(", ").append(th.getMessage());
            }
            return stringBuilder.toString();
        }
    }
}
