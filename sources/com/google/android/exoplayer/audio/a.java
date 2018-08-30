package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class a {
    private final int[] a;
    private final int b;

    public a(int[] iArr, int i) {
        if (iArr != null) {
            this.a = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.a);
        } else {
            this.a = new int[0];
        }
        this.b = i;
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.a, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Arrays.equals(this.a, aVar.a) && this.b == aVar.b;
    }

    public int hashCode() {
        return this.b + (Arrays.hashCode(this.a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.a) + "]";
    }
}
