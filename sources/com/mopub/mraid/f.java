package com.mopub.mraid;

enum f {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);
    
    private final int a;

    private f(int i) {
        this.a = i;
    }

    int a() {
        return this.a;
    }
}
