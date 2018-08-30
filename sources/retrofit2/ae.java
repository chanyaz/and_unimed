package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class ae implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    ae() {
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
