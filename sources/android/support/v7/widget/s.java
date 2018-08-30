package android.support.v7.widget;

class s {
    int a;
    int b;
    Object c;
    int d;

    s(int i, int i2, int i3, Object obj) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = obj;
    }

    String a() {
        switch (this.a) {
            case 1:
                return "add";
            case 2:
                return "rm";
            case 4:
                return "up";
            case 8:
                return "mv";
            default:
                return "??";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.a != sVar.a ? false : (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == sVar.b && this.b == sVar.d) ? true : this.d != sVar.d ? false : this.b != sVar.b ? false : this.c != null ? this.c.equals(sVar.c) : sVar.c == null;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.d;
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
    }
}
