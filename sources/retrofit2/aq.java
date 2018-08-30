package retrofit2;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class aq implements WildcardType {
    private final Type a;
    private final Type b;

    aq(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        } else if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        } else if (typeArr2.length == 1) {
            if (typeArr2[0] == null) {
                throw new NullPointerException();
            }
            an.c(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.b = typeArr2[0];
            this.a = Object.class;
        } else if (typeArr[0] == null) {
            throw new NullPointerException();
        } else {
            an.c(typeArr[0]);
            this.b = null;
            this.a = typeArr[0];
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && an.a((Type) this, (WildcardType) obj);
    }

    public Type[] getLowerBounds() {
        if (this.b == null) {
            return an.a;
        }
        return new Type[]{this.b};
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public int hashCode() {
        return (this.b != null ? this.b.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
    }

    public String toString() {
        return this.b != null ? "? super " + an.b(this.b) : this.a == Object.class ? "?" : "? extends " + an.b(this.a);
    }
}
