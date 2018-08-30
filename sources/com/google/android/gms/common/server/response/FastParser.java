package com.google.android.gms.common.server.response;

import com.appnext.base.b.c;
import com.google.android.gms.common.util.m;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] f = new char[]{'u', 'l', 'l'};
    private static final char[] g = new char[]{'r', 'u', 'e'};
    private static final char[] h = new char[]{'r', 'u', 'e', '\"'};
    private static final char[] i = new char[]{'a', 'l', 's', 'e'};
    private static final char[] j = new char[]{'a', 'l', 's', 'e', '\"'};
    private static final char[] k = new char[]{10};
    private static final zza<Integer> m = new f();
    private static final zza<Long> n = new g();
    private static final zza<Float> o = new h();
    private static final zza<Double> p = new i();
    private static final zza<Boolean> q = new j();
    private static final zza<String> r = new k();
    private static final zza<BigInteger> s = new l();
    private static final zza<BigDecimal> t = new m();
    private final char[] a = new char[1];
    private final char[] b = new char[32];
    private final char[] c = new char[c.jk];
    private final StringBuilder d = new StringBuilder(32);
    private final StringBuilder e = new StringBuilder(c.jk);
    private final Stack<Integer> l = new Stack();

    public class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }
    }

    interface zza<O> {
        O zzh(FastParser fastParser, BufferedReader bufferedReader);
    }

    private final int a(BufferedReader bufferedReader, char[] cArr) {
        char h = h(bufferedReader);
        if (h == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (h == ',') {
            throw new ParseException("Missing value");
        } else if (h == 'n') {
            b(bufferedReader, f);
            return 0;
        } else {
            int i;
            bufferedReader.mark(c.jk);
            if (h == '\"') {
                h = 0;
                int i2 = 0;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c = cArr[i2];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c == '\"' && h == 0) {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 + 1));
                        return i2;
                    } else {
                        h = c == '\\' ? h == 0 ? 1 : 0 : 0;
                        i2++;
                    }
                }
                i = i2;
            } else {
                cArr[0] = h;
                i = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i++;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    private final String a(BufferedReader bufferedReader) {
        return a(bufferedReader, this.b, this.d, null);
    }

    private final String a(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) {
        switch (h(bufferedReader)) {
            case '\"':
                return b(bufferedReader, cArr, stringBuilder, cArr2);
            case 'n':
                b(bufferedReader, f);
                return null;
            default:
                throw new ParseException("Expected string");
        }
    }

    private final boolean a(BufferedReader bufferedReader, boolean z) {
        while (true) {
            char h = h(bufferedReader);
            switch (h) {
                case '\"':
                    if (z) {
                        throw new ParseException("No boolean value found in string");
                    }
                    z = true;
                case 'f':
                    b(bufferedReader, z ? j : i);
                    return false;
                case 'n':
                    b(bufferedReader, f);
                    return false;
                case 't':
                    b(bufferedReader, z ? h : g);
                    return true;
                default:
                    throw new ParseException("Unexpected token: " + h);
            }
        }
    }

    private final int b(BufferedReader bufferedReader) {
        int i = 0;
        int a = a(bufferedReader, this.c);
        if (a == 0) {
            return 0;
        }
        char[] cArr = this.c;
        if (a > 0) {
            int i2;
            int i3;
            int i4;
            if (cArr[0] == '-') {
                i2 = Integer.MIN_VALUE;
                i3 = 1;
                i4 = 1;
            } else {
                i2 = -2147483647;
                i3 = 0;
                i4 = 0;
            }
            if (i4 < a) {
                i = i4 + 1;
                i4 = Character.digit(cArr[i4], 10);
                if (i4 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                int i5 = i;
                i = -i4;
                i4 = i5;
            }
            while (i4 < a) {
                int i6 = i4 + 1;
                i4 = Character.digit(cArr[i4], 10);
                if (i4 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i < -214748364) {
                    throw new ParseException("Number too large");
                } else {
                    i *= 10;
                    if (i < i2 + i4) {
                        throw new ParseException("Number too large");
                    }
                    i -= i4;
                    i4 = i6;
                }
            }
            if (i3 == 0) {
                return -i;
            }
            if (i4 > 1) {
                return i;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private static String b(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) {
        stringBuilder.setLength(0);
        bufferedReader.mark(cArr.length);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                int i3 = 0;
                while (i3 < read) {
                    char c = cArr[i3];
                    if (Character.isISOControl(c)) {
                        int i4;
                        if (cArr2 != null) {
                            for (char c2 : cArr2) {
                                if (c2 == c) {
                                    i4 = 1;
                                    break;
                                }
                            }
                        }
                        i4 = 0;
                        if (i4 == 0) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                    if (c == '\"' && i2 == 0) {
                        stringBuilder.append(cArr, 0, i3);
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i3 + 1));
                        return i != 0 ? m.a(stringBuilder.toString()) : stringBuilder.toString();
                    } else {
                        if (c == '\\') {
                            i2 = i2 == 0 ? 1 : 0;
                            i = 1;
                        } else {
                            i2 = 0;
                        }
                        i3++;
                    }
                }
                stringBuilder.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
    }

    private final void b(BufferedReader bufferedReader, char[] cArr) {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.b, 0, cArr.length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.b[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    private final long c(BufferedReader bufferedReader) {
        long j = 0;
        int a = a(bufferedReader, this.c);
        if (a == 0) {
            return 0;
        }
        char[] cArr = this.c;
        if (a > 0) {
            long j2;
            int i;
            int i2;
            if (cArr[0] == '-') {
                j2 = Long.MIN_VALUE;
                i = 1;
                i2 = 1;
            } else {
                i = 0;
                j2 = -9223372036854775807L;
                i2 = 0;
            }
            if (i2 < a) {
                int i3 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                int i4 = i3;
                j = (long) (-digit);
                i2 = i4;
            }
            while (i2 < a) {
                int i5 = i2 + 1;
                i2 = Character.digit(cArr[i2], 10);
                if (i2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j < -922337203685477580L) {
                    throw new ParseException("Number too large");
                } else {
                    j *= 10;
                    if (j < ((long) i2) + j2) {
                        throw new ParseException("Number too large");
                    }
                    j -= (long) i2;
                    i2 = i5;
                }
            }
            if (i == 0) {
                return -j;
            }
            if (i2 > 1) {
                return j;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private final BigInteger d(BufferedReader bufferedReader) {
        int a = a(bufferedReader, this.c);
        return a == 0 ? null : new BigInteger(new String(this.c, 0, a));
    }

    private final float e(BufferedReader bufferedReader) {
        int a = a(bufferedReader, this.c);
        return a == 0 ? 0.0f : Float.parseFloat(new String(this.c, 0, a));
    }

    private final double f(BufferedReader bufferedReader) {
        int a = a(bufferedReader, this.c);
        return a == 0 ? 0.0d : Double.parseDouble(new String(this.c, 0, a));
    }

    private final BigDecimal g(BufferedReader bufferedReader) {
        int a = a(bufferedReader, this.c);
        return a == 0 ? null : new BigDecimal(new String(this.c, 0, a));
    }

    private final char h(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.a) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.a[0])) {
            if (bufferedReader.read(this.a) == -1) {
                return 0;
            }
        }
        return this.a[0];
    }
}
