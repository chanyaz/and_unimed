package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public enum RemovalCause {
    EXPLICIT {
        boolean a() {
            return false;
        }
    },
    REPLACED {
        boolean a() {
            return false;
        }
    },
    COLLECTED {
        boolean a() {
            return true;
        }
    },
    EXPIRED {
        boolean a() {
            return true;
        }
    },
    SIZE {
        boolean a() {
            return true;
        }
    };

    abstract boolean a();
}
