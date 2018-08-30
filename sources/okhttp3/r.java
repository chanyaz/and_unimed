package okhttp3;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.c;

public final class r {
    final List<String> a = new ArrayList(20);

    private void d(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else {
            int i;
            char charAt;
            int length = str.length();
            for (i = 0; i < length; i++) {
                charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            length = str2.length();
            i = 0;
            while (i < length) {
                charAt = str2.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i++;
                } else {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                }
            }
        }
    }

    public q a() {
        return new q(this);
    }

    r a(String str) {
        int indexOf = str.indexOf(":", 1);
        return indexOf != -1 ? b(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? b("", str.substring(1)) : b("", str);
    }

    public r a(String str, String str2) {
        d(str, str2);
        return b(str, str2);
    }

    public r b(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return this;
            }
            if (str.equalsIgnoreCase((String) this.a.get(i2))) {
                this.a.remove(i2);
                this.a.remove(i2);
                i2 -= 2;
            }
            i = i2 + 2;
        }
    }

    r b(String str, String str2) {
        this.a.add(str);
        this.a.add(str2.trim());
        return this;
    }

    public r c(String str, String str2) {
        d(str, str2);
        b(str);
        b(str, str2);
        return this;
    }
}
