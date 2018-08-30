package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.nio.charset.Charset;

@Beta
public interface HashFunction {
    int bits();

    g hashBytes(byte[] bArr);

    g hashBytes(byte[] bArr, int i, int i2);

    g hashInt(int i);

    g hashLong(long j);

    <T> g hashObject(T t, Funnel<? super T> funnel);

    g hashString(CharSequence charSequence, Charset charset);

    g hashUnencodedChars(CharSequence charSequence);

    Hasher newHasher();

    Hasher newHasher(int i);
}
