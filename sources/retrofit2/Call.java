package retrofit2;

import okhttp3.ad;

public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    ai<T> execute();

    boolean isCanceled();

    boolean isExecuted();

    ad request();
}
