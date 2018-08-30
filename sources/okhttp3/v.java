package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class v {
    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;
    private final String d;
    private final String e;
    @Nullable
    private final String f;

    private v(String str, String str2, String str3, @Nullable String str4) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    @Nullable
    public static v a(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                group = matcher2.group(2);
                if (group == null) {
                    group = matcher2.group(3);
                } else if (group.startsWith("'") && group.endsWith("'") && group.length() > 2) {
                    group = group.substring(1, group.length() - 1);
                }
                if (str2 != null && !group.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group;
            }
        }
        return new v(str, toLowerCase, toLowerCase2, str2);
    }

    public String a() {
        return this.d;
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        try {
            return this.f != null ? Charset.forName(this.f) : charset;
        } catch (IllegalArgumentException e) {
            return charset;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && ((v) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return this.c;
    }
}
