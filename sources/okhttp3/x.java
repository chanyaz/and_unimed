package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okio.ByteString;

public final class x {
    private final ByteString a;
    private v b;
    private final List<y> c;

    public x() {
        this(UUID.randomUUID().toString());
    }

    public x(String str) {
        this.b = w.a;
        this.c = new ArrayList();
        this.a = ByteString.a(str);
    }

    public w a() {
        if (!this.c.isEmpty()) {
            return new w(this.a, this.b, this.c);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }

    public x a(@Nullable q qVar, af afVar) {
        return a(y.a(qVar, afVar));
    }

    public x a(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("type == null");
        } else if (vVar.a().equals("multipart")) {
            this.b = vVar;
            return this;
        } else {
            throw new IllegalArgumentException("multipart != " + vVar);
        }
    }

    public x a(y yVar) {
        if (yVar == null) {
            throw new NullPointerException("part == null");
        }
        this.c.add(yVar);
        return this;
    }
}
