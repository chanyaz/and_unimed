package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class bh implements Serializable {
    private int a;

    bh(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public int a(int i) {
        int i2 = this.a;
        this.a = i2 + i;
        return i2;
    }

    public int b(int i) {
        int i2 = this.a + i;
        this.a = i2;
        return i2;
    }

    public void c(int i) {
        this.a = i;
    }

    public int d(int i) {
        int i2 = this.a;
        this.a = i;
        return i2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof bh) && ((bh) obj).a == this.a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return Integer.toString(this.a);
    }
}
