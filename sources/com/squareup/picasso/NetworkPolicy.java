package com.squareup.picasso;

public enum NetworkPolicy {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    final int d;

    private NetworkPolicy(int i) {
        this.d = i;
    }

    public static boolean a(int i) {
        return (NO_CACHE.d & i) == 0;
    }

    public static boolean b(int i) {
        return (NO_STORE.d & i) == 0;
    }

    public static boolean c(int i) {
        return (OFFLINE.d & i) != 0;
    }
}
