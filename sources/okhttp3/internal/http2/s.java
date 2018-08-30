package okhttp3.internal.http2;

final class s {
    final s[] a;
    final int b;
    final int c;

    s() {
        this.a = new s[256];
        this.b = 0;
        this.c = 0;
    }

    s(int i, int i2) {
        this.a = null;
        this.b = i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            i3 = 8;
        }
        this.c = i3;
    }
}
