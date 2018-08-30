package retrofit2;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class t<T> extends o<Map<String, T>> {
    private final Converter<T, String> a;

    t(Converter<T, String> converter) {
        this.a = converter;
    }

    void a(ag agVar, @Nullable Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Header map was null.");
        }
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new IllegalArgumentException("Header map contained null key.");
            }
            Object value = entry.getValue();
            if (value == null) {
                throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
            }
            agVar.a(str, (String) this.a.convert(value));
        }
    }
}
