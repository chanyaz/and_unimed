package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient String e;

    ByteString(byte[] bArr) {
        this.c = bArr;
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 65) + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    static int a(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static ByteString a(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
    }

    public static ByteString a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(q.a));
        byteString.e = str;
        return byteString;
    }

    public static ByteString a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((a(str.charAt(i * 2)) << 4) + a(str.charAt((i * 2) + 1)));
            }
            return a(bArr);
        }
    }

    private ByteString c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ByteString a = a((InputStream) objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a.c);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int i) {
        return this.c[i];
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        str = new String(this.c, q.a);
        this.e = str;
        return str;
    }

    public ByteString a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.c.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.c, i, obj, 0, i3);
                return new ByteString(obj);
            }
        }
    }

    void a(d dVar) {
        dVar.write(this.c, 0, this.c.length);
    }

    public boolean a(int i, ByteString byteString, int i2, int i3) {
        return byteString.a(i2, this.c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && q.a(this.c, i, bArr, i2, i3);
    }

    public final boolean a(ByteString byteString) {
        return a(0, byteString, 0, byteString.g());
    }

    /* renamed from: b */
    public int compareTo(ByteString byteString) {
        int g = g();
        int g2 = byteString.g();
        int min = Math.min(g, g2);
        int i = 0;
        while (i < min) {
            int a = a(i) & 255;
            int a2 = byteString.a(i) & 255;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            } else {
                i++;
            }
        }
        return g == g2 ? 0 : g >= g2 ? 1 : -1;
    }

    public String b() {
        return c.a(this.c);
    }

    public ByteString c() {
        return c("SHA-1");
    }

    public ByteString d() {
        return c("SHA-256");
    }

    public String e() {
        int i = 0;
        char[] cArr = new char[(this.c.length * 2)];
        byte[] bArr = this.c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof ByteString) && ((ByteString) obj).g() == this.c.length && ((ByteString) obj).a(0, this.c, 0, this.c.length);
        return z;
    }

    public ByteString f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.length) {
                return this;
            }
            byte b = this.c[i2];
            if (b < (byte) 65 || b > (byte) 90) {
                i = i2 + 1;
            } else {
                byte[] bArr = (byte[]) this.c.clone();
                int i3 = i2 + 1;
                bArr[i2] = (byte) (b + 32);
                for (i2 = i3; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
    }

    public int g() {
        return this.c.length;
    }

    public byte[] h() {
        return (byte[]) this.c.clone();
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.c);
        this.d = i;
        return i;
    }

    byte[] i() {
        return this.c;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String a = a();
        int a2 = a(a, 64);
        if (a2 == -1) {
            return this.c.length <= 64 ? "[hex=" + e() + "]" : "[size=" + this.c.length + " hex=" + a(0, 64).e() + "…]";
        } else {
            String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return a2 < a.length() ? "[size=" + this.c.length + " text=" + replace + "…]" : "[text=" + replace + "]";
        }
    }
}
