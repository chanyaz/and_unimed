package com.google.common.io;

import com.google.common.base.s;
import javax.annotation.Nullable;

final class b extends BaseEncoding {
    private final a a;
    @Nullable
    private final Character b;

    b(a aVar, @Nullable Character ch) {
        this.a = (a) s.a((Object) aVar);
        boolean z = ch == null || !aVar.b(ch.charValue());
        s.a(z, "Padding character %s was already in alphabet", ch);
        this.b = ch;
    }

    b(String str, String str2, @Nullable Character ch) {
        this(new a(str, str2.toCharArray()), ch);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
        stringBuilder.append(this.a.toString());
        if (8 % this.a.q != 0) {
            if (this.b == null) {
                stringBuilder.append(".omitPadding()");
            } else {
                stringBuilder.append(".withPadChar(").append(this.b).append(')');
            }
        }
        return stringBuilder.toString();
    }
}
