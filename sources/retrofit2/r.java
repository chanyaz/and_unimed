package retrofit2;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class r<T> extends o<Map<String, T>> {
    private final Converter<T, String> a;
    private final boolean b;

    r(Converter<T, String> converter, boolean z) {
        this.a = converter;
        this.b = z;
    }

    void a(ag agVar, @Nullable Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Field map was null.");
        }
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new IllegalArgumentException("Field map contained null key.");
            }
            Object value = entry.getValue();
            if (value == null) {
                throw new IllegalArgumentException("Field map contained null value for key '" + str + "'.");
            }
            String str2 = (String) this.a.convert(value);
            if (str2 == null) {
                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.a.getClass().getName() + " for key '" + str + "'.");
            }
            agVar.c(str, str2, this.b);
        }
    }
}
