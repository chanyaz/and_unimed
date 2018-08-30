package retrofit2;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import okhttp3.af;
import okhttp3.q;

final class v<T> extends o<Map<String, T>> {
    private final Converter<T, af> a;
    private final String b;

    v(Converter<T, af> converter, String str) {
        this.a = converter;
        this.b = str;
    }

    void a(ag agVar, @Nullable Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Part map was null.");
        }
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new IllegalArgumentException("Part map contained null key.");
            }
            Object value = entry.getValue();
            if (value == null) {
                throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
            }
            agVar.a(q.a("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.b), (af) this.a.convert(value));
        }
    }
}
