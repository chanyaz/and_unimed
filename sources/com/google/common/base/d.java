package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@Beta
public abstract class d implements Predicate<Character> {
    public static final d a = new d() {
        public boolean b(char c) {
            switch (c) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case ' ':
                case 133:
                case 5760:
                case 8232:
                case 8233:
                case 8287:
                case 12288:
                    return true;
                case 8199:
                    return false;
                default:
                    return c >= 8192 && c <= 8202;
            }
        }

        public String toString() {
            return "CharMatcher.BREAKING_WHITESPACE";
        }
    };
    public static final d b = a(0, 127, "CharMatcher.ASCII");
    public static final d c = new g("CharMatcher.DIGIT", "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray(), p.toCharArray());
    public static final d d = new d("CharMatcher.JAVA_DIGIT") {
        public boolean b(char c) {
            return Character.isDigit(c);
        }
    };
    public static final d e = new d("CharMatcher.JAVA_LETTER") {
        public boolean b(char c) {
            return Character.isLetter(c);
        }
    };
    public static final d f = new d("CharMatcher.JAVA_LETTER_OR_DIGIT") {
        public boolean b(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final d g = new d("CharMatcher.JAVA_UPPER_CASE") {
        public boolean b(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final d h = new d("CharMatcher.JAVA_LOWER_CASE") {
        public boolean b(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final d i = a(0, 31).a(a(127, 159)).a("CharMatcher.JAVA_ISO_CONTROL");
    public static final d j = new g("CharMatcher.INVISIBLE", "\u0000­؀۝܏ ᠎   ⁪　?﻿￹￺".toCharArray(), "  ­؄۝܏ ᠎‏ ⁤⁯　﻿￹￻".toCharArray());
    public static final d k = new g("CharMatcher.SINGLE_WIDTH", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
    public static final d l = new e("CharMatcher.ANY") {
        public int a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            s.b(i, length);
            return i == length ? -1 : i;
        }

        public d a(d dVar) {
            s.a((Object) dVar);
            return this;
        }

        public boolean b(char c) {
            return true;
        }
    };
    public static final d m = new e("CharMatcher.NONE") {
        public int a(CharSequence charSequence, int i) {
            s.b(i, charSequence.length());
            return -1;
        }

        public d a(d dVar) {
            return (d) s.a((Object) dVar);
        }

        public boolean b(char c) {
            return false;
        }
    };
    public static final d o = new e("WHITESPACE") {
        public boolean b(char c) {
            return "\t　\n\t\t\t \t\t  \t\t\t\t\t᠎\t \t\t\t   \t\t\t\r\t\t  \t \t  \t\t\t\f \t\t \t\t  \t\t\t\u000b\t\t\t\t\t\t  \t".charAt((-844444961 * c) >>> 26) == c;
        }
    };
    private static final String p;
    final String n;

    static {
        StringBuilder stringBuilder = new StringBuilder("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length());
        for (int i = 0; i < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); i++) {
            stringBuilder.append((char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + 9));
        }
        p = stringBuilder.toString();
    }

    protected d() {
        this.n = super.toString();
    }

    d(String str) {
        this.n = str;
    }

    public static d a(final char c) {
        return new e("CharMatcher.is('" + c(c) + "')") {
            public d a(d dVar) {
                return dVar.b(c) ? dVar : super.a(dVar);
            }

            public boolean b(char c) {
                return c == c;
            }
        };
    }

    public static d a(char c, char c2) {
        s.a(c2 >= c);
        return a(c, c2, "CharMatcher.inRange('" + c(c) + "', '" + c(c2) + "')");
    }

    static d a(final char c, final char c2, String str) {
        return new e(str) {
            public boolean b(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    private static String c(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            int c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        s.b(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (b(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public d a(d dVar) {
        return new f(this, (d) s.a((Object) dVar));
    }

    d a(String str) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* renamed from: a */
    public boolean apply(Character ch) {
        return b(ch.charValue());
    }

    public abstract boolean b(char c);

    public String toString() {
        return this.n;
    }
}
