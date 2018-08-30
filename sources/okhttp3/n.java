package okhttp3;

import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.BufferedSink;
import okio.d;

public final class n extends af {
    private static final v a = v.a("application/x-www-form-urlencoded");
    private final List<String> b;
    private final List<String> c;

    n(List<String> list, List<String> list2) {
        this.b = c.a((List) list);
        this.c = c.a((List) list2);
    }

    private long a(@Nullable BufferedSink bufferedSink, boolean z) {
        long j = 0;
        d dVar = z ? new d() : bufferedSink.buffer();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                dVar.writeByte(38);
            }
            dVar.writeUtf8((String) this.b.get(i));
            dVar.writeByte(61);
            dVar.writeUtf8((String) this.c.get(i));
        }
        if (z) {
            j = dVar.a();
            dVar.d();
        }
        return j;
    }

    public v a() {
        return a;
    }

    public void a(BufferedSink bufferedSink) {
        a(bufferedSink, false);
    }

    public long b() {
        return a(null, true);
    }
}
