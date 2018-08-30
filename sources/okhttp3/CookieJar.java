package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {
    public static final CookieJar a = new CookieJar() {
        public List<l> loadForRequest(s sVar) {
            return Collections.emptyList();
        }

        public void saveFromResponse(s sVar, List<l> list) {
        }
    };

    List<l> loadForRequest(s sVar);

    void saveFromResponse(s sVar, List<l> list);
}
