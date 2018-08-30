package okhttp3;

import java.util.ArrayList;
import java.util.List;

public final class o {
    private final List<String> a = new ArrayList();
    private final List<String> b = new ArrayList();

    public n a() {
        return new n(this.a, this.b);
    }

    public o a(String str, String str2) {
        this.a.add(s.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
        this.b.add(s.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
        return this;
    }

    public o b(String str, String str2) {
        this.a.add(s.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
        this.b.add(s.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
        return this;
    }
}
