package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class q {
    private final String[] a;

    q(r rVar) {
        this.a = (String[]) rVar.a.toArray(new String[rVar.a.size()]);
    }

    private q(String[] strArr) {
        this.a = strArr;
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static q a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        } else {
            int i;
            String[] strArr2 = (String[]) strArr.clone();
            for (i = 0; i < strArr2.length; i++) {
                if (strArr2[i] == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i] = strArr2[i].trim();
            }
            i = 0;
            while (i < strArr2.length) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i += 2;
                } else {
                    throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                }
            }
            return new q(strArr2);
        }
    }

    public int a() {
        return this.a.length / 2;
    }

    public String a(int i) {
        return this.a[i * 2];
    }

    @Nullable
    public String a(String str) {
        return a(this.a, str);
    }

    public String b(int i) {
        return this.a[(i * 2) + 1];
    }

    public List<String> b(String str) {
        int a = a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(b(i));
            }
        }
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public r b() {
        r rVar = new r();
        Collections.addAll(rVar.a, this.a);
        return rVar;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q) && Arrays.equals(((q) obj).a, this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
