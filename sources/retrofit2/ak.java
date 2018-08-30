package retrofit2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.s;
import okhttp3.z;

public final class ak {
    private final ac a;
    @Nullable
    private Factory b;
    private s c;
    private final List<h> d;
    private final List<g> e;
    @Nullable
    private Executor f;
    private boolean g;

    public ak() {
        this(ac.a());
    }

    ak(ac acVar) {
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.a = acVar;
        this.d.add(new a());
    }

    public aj a() {
        if (this.c == null) {
            throw new IllegalStateException("Base URL required.");
        }
        Factory factory = this.b;
        if (factory == null) {
            factory = new z();
        }
        Executor executor = this.f;
        if (executor == null) {
            executor = this.a.b();
        }
        List arrayList = new ArrayList(this.e);
        arrayList.add(this.a.a(executor));
        return new aj(factory, this.c, new ArrayList(this.d), arrayList, executor, this.g);
    }

    public ak a(String str) {
        an.a((Object) str, "baseUrl == null");
        s e = s.e(str);
        if (e != null) {
            return a(e);
        }
        throw new IllegalArgumentException("Illegal URL: " + str);
    }

    public ak a(Factory factory) {
        this.b = (Factory) an.a((Object) factory, "factory == null");
        return this;
    }

    public ak a(s sVar) {
        an.a((Object) sVar, "baseUrl == null");
        List j = sVar.j();
        if ("".equals(j.get(j.size() - 1))) {
            this.c = sVar;
            return this;
        }
        throw new IllegalArgumentException("baseUrl must end in /: " + sVar);
    }

    public ak a(z zVar) {
        return a((Factory) an.a((Object) zVar, "client == null"));
    }

    public ak a(h hVar) {
        this.d.add(an.a((Object) hVar, "factory == null"));
        return this;
    }
}
