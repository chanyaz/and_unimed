package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(ad adVar, al alVar);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    ad request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
