package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.ai;
import retrofit2.Converter;

final class c<T> implements Converter<ai, T> {
    private final ObjectReader a;

    c(ObjectReader objectReader) {
        this.a = objectReader;
    }

    /* renamed from: a */
    public T convert(ai aiVar) {
        try {
            T readValue = this.a.readValue(aiVar.e());
            return readValue;
        } finally {
            aiVar.close();
        }
    }
}
