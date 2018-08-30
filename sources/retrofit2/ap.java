package retrofit2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class ap implements ParameterizedType {
    private final Type a;
    private final Type b;
    private final Type[] c;

    ap(Type type, Type type2, Type... typeArr) {
        int i = 1;
        int i2 = 0;
        if (type2 instanceof Class) {
            int i3 = type == null ? 1 : 0;
            if (((Class) type2).getEnclosingClass() != null) {
                i = 0;
            }
            if (i3 != i) {
                throw new IllegalArgumentException();
            }
        }
        int length = typeArr.length;
        while (i2 < length) {
            Object obj = typeArr[i2];
            an.a(obj, "typeArgument == null");
            an.c(obj);
            i2++;
        }
        this.a = type;
        this.b = type2;
        this.c = (Type[]) typeArr.clone();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && an.a((Type) this, (ParameterizedType) obj);
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    public Type getOwnerType() {
        return this.a;
    }

    public Type getRawType() {
        return this.b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ an.a(this.a);
    }

    public String toString() {
        if (this.c.length == 0) {
            return an.b(this.b);
        }
        StringBuilder stringBuilder = new StringBuilder((this.c.length + 1) * 30);
        stringBuilder.append(an.b(this.b));
        stringBuilder.append("<").append(an.b(this.c[0]));
        for (int i = 1; i < this.c.length; i++) {
            stringBuilder.append(", ").append(an.b(this.c[i]));
        }
        return stringBuilder.append(">").toString();
    }
}
