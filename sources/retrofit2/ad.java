package retrofit2;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

class ad extends ac {
    ad() {
    }

    g a(@Nullable Executor executor) {
        if (executor != null) {
            return new j(executor);
        }
        throw new AssertionError();
    }

    public Executor b() {
        return new ae();
    }
}
