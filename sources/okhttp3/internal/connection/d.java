package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ak;

public final class d {
    private final Set<ak> a = new LinkedHashSet();

    public synchronized void a(ak akVar) {
        this.a.add(akVar);
    }

    public synchronized void b(ak akVar) {
        this.a.remove(akVar);
    }

    public synchronized boolean c(ak akVar) {
        return this.a.contains(akVar);
    }
}
