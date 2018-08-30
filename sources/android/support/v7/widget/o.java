package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class o {
    public final ComponentName a;
    public final long b;
    public final float c;

    public o(ComponentName componentName, long j, float f) {
        this.a = componentName;
        this.b = j;
        this.c = f;
    }

    public o(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.a == null) {
            if (oVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(oVar.a)) {
            return false;
        }
        return this.b != oVar.b ? false : Float.floatToIntBits(this.c) == Float.floatToIntBits(oVar.c);
    }

    public int hashCode() {
        return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.a);
        stringBuilder.append("; time:").append(this.b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
