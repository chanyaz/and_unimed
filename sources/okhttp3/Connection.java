package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

public interface Connection {
    @Nullable
    p handshake();

    Protocol protocol();

    ak route();

    Socket socket();
}
