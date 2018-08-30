package okhttp3;

import javax.annotation.Nullable;
import okhttp3.internal.http.e;

public class ae {
    s a;
    String b;
    r c;
    af d;
    Object e;

    public ae() {
        this.b = "GET";
        this.c = new r();
    }

    ae(ad adVar) {
        this.a = adVar.a;
        this.b = adVar.b;
        this.d = adVar.d;
        this.e = adVar.e;
        this.c = adVar.c.b();
    }

    public ad a() {
        if (this.a != null) {
            return new ad(this);
        }
        throw new IllegalStateException("url == null");
    }

    public ae a(String str) {
        this.c.b(str);
        return this;
    }

    public ae a(String str, String str2) {
        this.c.c(str, str2);
        return this;
    }

    public ae a(String str, @Nullable af afVar) {
        if (str == null) {
            throw new NullPointerException("method == null");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
        } else if (afVar != null && !e.c(str)) {
            throw new IllegalArgumentException("method " + str + " must not have a request body.");
        } else if (afVar == null && e.b(str)) {
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        } else {
            this.b = str;
            this.d = afVar;
            return this;
        }
    }

    public ae a(q qVar) {
        this.c = qVar.b();
        return this;
    }

    public ae a(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("url == null");
        }
        this.a = sVar;
        return this;
    }

    public ae b(String str, String str2) {
        this.c.a(str, str2);
        return this;
    }
}
