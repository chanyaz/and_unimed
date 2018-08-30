package okhttp3;

import javax.annotation.Nullable;

public interface Interceptor {

    public interface Chain {
        @Nullable
        Connection connection();

        ag proceed(ad adVar);

        ad request();
    }

    ag intercept(Chain chain);
}
