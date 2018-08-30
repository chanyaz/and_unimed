package retrofit2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class ao implements GenericArrayType {
    private final Type a;

    ao(Type type) {
        this.a = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && an.a((Type) this, (GenericArrayType) obj);
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return an.b(this.a) + "[]";
    }
}
