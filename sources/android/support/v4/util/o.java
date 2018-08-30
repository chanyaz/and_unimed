package android.support.v4.util;

import android.support.annotation.Nullable;

public class o<F, S> {
    @Nullable
    public final F a;
    @Nullable
    public final S b;

    public o(@Nullable F f, @Nullable S s) {
        this.a = f;
        this.b = s;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return a(oVar.a, this.a) && a(oVar.b, this.b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}
