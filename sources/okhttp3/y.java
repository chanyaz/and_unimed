package okhttp3;

import javax.annotation.Nullable;

public final class y {
    @Nullable
    final q a;
    final af b;

    private y(@Nullable q qVar, af afVar) {
        this.a = qVar;
        this.b = afVar;
    }

    public static y a(@Nullable q qVar, af afVar) {
        if (afVar == null) {
            throw new NullPointerException("body == null");
        } else if (qVar != null && qVar.a("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        } else if (qVar == null || qVar.a("Content-Length") == null) {
            return new y(qVar, afVar);
        } else {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }
}
