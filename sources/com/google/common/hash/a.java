package com.google.common.hash;

import java.nio.charset.Charset;

abstract class a implements Hasher {
    a() {
    }

    public final Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : (byte) 0);
    }

    public final Hasher putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    public final Hasher putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }
}
