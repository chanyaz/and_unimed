package okhttp3;

public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(ad adVar);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    ag execute();

    boolean isCanceled();

    boolean isExecuted();

    ad request();
}
