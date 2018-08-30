package com.google.android.exoplayer;

import java.nio.ByteBuffer;

public final class m {
    public final b a = new b();
    public ByteBuffer b;
    public int c;
    public int d;
    public long e;
    private final int f;

    public m(int i) {
        this.f = i;
    }

    public boolean a() {
        return (this.d & 2) != 0;
    }

    public boolean a(int i) {
        switch (this.f) {
            case 1:
                this.b = ByteBuffer.allocate(i);
                return true;
            case 2:
                this.b = ByteBuffer.allocateDirect(i);
                return true;
            default:
                return false;
        }
    }

    public boolean b() {
        return (this.d & 134217728) != 0;
    }

    public boolean c() {
        return (this.d & 1) != 0;
    }
}
