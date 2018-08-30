package okio;

import java.util.AbstractList;
import java.util.RandomAccess;

public final class j extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] a;

    /* renamed from: a */
    public ByteString get(int i) {
        return this.a[i];
    }

    public int size() {
        return this.a.length;
    }
}
