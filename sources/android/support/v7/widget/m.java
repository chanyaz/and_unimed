package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class m implements Comparable<m> {
    public final ResolveInfo a;
    public float b;

    public m(ResolveInfo resolveInfo) {
        this.a = resolveInfo;
    }

    /* renamed from: a */
    public int compareTo(m mVar) {
        return Float.floatToIntBits(mVar.b) - Float.floatToIntBits(this.b);
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
        return Float.floatToIntBits(this.b) == Float.floatToIntBits(((m) obj).b);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.b) + 31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
