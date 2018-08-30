package okhttp3;

import javax.annotation.Nullable;

public final class k {
    boolean a;
    @Nullable
    String[] b;
    @Nullable
    String[] c;
    boolean d;

    public k(j jVar) {
        this.a = jVar.d;
        this.b = jVar.f;
        this.c = jVar.g;
        this.d = jVar.e;
    }

    k(boolean z) {
        this.a = z;
    }

    public j a() {
        return new j(this);
    }

    public k a(boolean z) {
        if (this.a) {
            this.d = z;
            return this;
        }
        throw new IllegalStateException("no TLS extensions for cleartext connections");
    }

    public k a(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        } else {
            this.b = (String[]) strArr.clone();
            return this;
        }
    }

    public k a(TlsVersion... tlsVersionArr) {
        if (this.a) {
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].f;
            }
            return b(strArr);
        }
        throw new IllegalStateException("no TLS versions for cleartext connections");
    }

    public k a(h... hVarArr) {
        if (this.a) {
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].bj;
            }
            return a(strArr);
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    public k b(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        } else {
            this.c = (String[]) strArr.clone();
            return this;
        }
    }
}
