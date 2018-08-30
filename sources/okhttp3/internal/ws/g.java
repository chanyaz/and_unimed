package okhttp3.internal.ws;

public final class g {
    private g() {
        throw new AssertionError("No instances.");
    }

    static String a(int i) {
        return (i < 1000 || i >= 5000) ? "Code must be in range [1000,5000): " + i : ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) ? null : "Code " + i + " is reserved and may not be used.";
    }

    static void a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int length = bArr2.length;
        int i = 0;
        while (((long) i) < j) {
            int i2 = (int) (j2 % ((long) length));
            bArr[i] = (byte) (bArr2[i2] ^ bArr[i]);
            i++;
            j2++;
        }
    }

    static void b(int i) {
        String a = a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }
}
