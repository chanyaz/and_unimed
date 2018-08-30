package okhttp3.internal.http2;

import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver a = new PushObserver() {
        public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) {
            bufferedSource.skip((long) i2);
            return true;
        }

        public boolean onHeaders(int i, List<a> list, boolean z) {
            return true;
        }

        public boolean onRequest(int i, List<a> list) {
            return true;
        }

        public void onReset(int i, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z);

    boolean onHeaders(int i, List<a> list, boolean z);

    boolean onRequest(int i, List<a> list);

    void onReset(int i, ErrorCode errorCode);
}
