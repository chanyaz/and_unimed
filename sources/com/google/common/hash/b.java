package com.google.common.hash;

import com.google.common.base.s;
import java.nio.charset.Charset;

abstract class b implements HashFunction {
    b() {
    }

    public g hashBytes(byte[] bArr) {
        return newHasher().putBytes(bArr).hash();
    }

    public g hashBytes(byte[] bArr, int i, int i2) {
        return newHasher().putBytes(bArr, i, i2).hash();
    }

    public g hashInt(int i) {
        return newHasher().putInt(i).hash();
    }

    public g hashLong(long j) {
        return newHasher().putLong(j).hash();
    }

    public <T> g hashObject(T t, Funnel<? super T> funnel) {
        return newHasher().putObject(t, funnel).hash();
    }

    public g hashString(CharSequence charSequence, Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    public g hashUnencodedChars(CharSequence charSequence) {
        return newHasher().putUnencodedChars(charSequence).hash();
    }

    public Hasher newHasher(int i) {
        s.a(i >= 0);
        return newHasher();
    }
}
