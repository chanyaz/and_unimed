package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzbbu extends IOException {
    private zzbcu a = null;

    public zzbbu(String str) {
        super(str);
    }

    static zzbbu a() {
        return new zzbbu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzbbu b() {
        return new zzbbu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzbbu c() {
        return new zzbbu("CodedInputStream encountered a malformed varint.");
    }

    static zzbbu d() {
        return new zzbbu("Protocol message contained an invalid tag (zero).");
    }

    static zzbbu e() {
        return new zzbbu("Protocol message end-group tag did not match expected tag.");
    }

    static zzbbv f() {
        return new zzbbv("Protocol message tag had invalid wire type.");
    }

    static zzbbu g() {
        return new zzbbu("Failed to parse the message.");
    }

    static zzbbu h() {
        return new zzbbu("Protocol message had invalid UTF-8.");
    }

    public final zzbbu a(zzbcu zzbcu) {
        this.a = zzbcu;
        return this;
    }
}
