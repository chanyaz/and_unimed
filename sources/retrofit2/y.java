package retrofit2;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class y<T> extends o<Map<String, T>> {
    private final Converter<T, String> a;
    private final boolean b;

    y(Converter<T, String> converter, boolean z) {
        this.a = converter;
        this.b = z;
    }

    void a(ag agVar, @Nullable Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Query map was null.");
        }
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new IllegalArgumentException("Query map contained null key.");
            }
            Object value = entry.getValue();
            if (value == null) {
                throw new IllegalArgumentException("Query map contained null value for key '" + str + "'.");
            }
            String str2 = (String) this.a.convert(value);
            if (str2 == null) {
                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.a.getClass().getName() + " for key '" + str + "'.");
            }
            agVar.b(str, str2, this.b);
        }
    }
}
