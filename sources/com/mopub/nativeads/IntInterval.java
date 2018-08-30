package com.mopub.nativeads;

import android.support.annotation.Nullable;

public class IntInterval implements Comparable<IntInterval> {
    private int a;
    private int b;

    public IntInterval(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int compareTo(@Nullable IntInterval intInterval) {
        return this.a == intInterval.a ? this.b - intInterval.b : this.a - intInterval.a;
    }

    public boolean equals(int i, int i2) {
        return this.a == i && this.b == i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntInterval)) {
            return false;
        }
        IntInterval intInterval = (IntInterval) obj;
        return this.a == intInterval.a && this.b == intInterval.b;
    }

    public int getLength() {
        return this.b;
    }

    public int getStart() {
        return this.a;
    }

    public int hashCode() {
        return ((this.a + 899) * 31) + this.b;
    }

    public void setLength(int i) {
        this.b = i;
    }

    public void setStart(int i) {
        this.a = i;
    }

    public String toString() {
        return "{start : " + this.a + ", length : " + this.b + "}";
    }
}
