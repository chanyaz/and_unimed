package retrofit2;

public interface Converter<F, T> {
    T convert(F f);
}
