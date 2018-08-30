package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzacd extends IOException {
    public zzacd(String str) {
        super(str);
    }

    static zzacd a() {
        return new zzacd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzacd b() {
        return new zzacd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzacd c() {
        return new zzacd("CodedInputStream encountered a malformed varint.");
    }

    static zzacd d() {
        return new zzacd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
