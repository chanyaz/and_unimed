package com.google.common.hash;

import java.io.Serializable;
import javax.annotation.Nullable;

final class k extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;

    k(int i) {
        this.a = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        return this.a == ((k) obj).a;
    }

    public int hashCode() {
        return getClass().hashCode() ^ this.a;
    }

    public Hasher newHasher() {
        return new l(this.a);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.a + ")";
    }
}
