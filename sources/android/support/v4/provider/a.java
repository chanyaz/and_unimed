package android.support.v4.provider;

import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.r;
import android.util.Base64;
import java.util.List;

public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f = new StringBuilder(this.a).append("-").append(this.b).append("-").append(this.c).toString();

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.a = (String) r.a(str);
        this.b = (String) r.a(str2);
        this.c = (String) r.a(str3);
        this.d = (List) r.a(list);
    }

    @NonNull
    public String a() {
        return this.a;
    }

    @NonNull
    public String b() {
        return this.b;
    }

    @NonNull
    public String c() {
        return this.c;
    }

    @Nullable
    public List<List<byte[]>> d() {
        return this.d;
    }

    @ArrayRes
    public int e() {
        return this.e;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder.append("mCertificatesArray: " + this.e);
        return stringBuilder.toString();
    }
}
