package android.support.v4.text;

import java.nio.CharBuffer;

abstract class d implements TextDirectionHeuristicCompat {
    private final TextDirectionAlgorithm a;

    d(TextDirectionAlgorithm textDirectionAlgorithm) {
        this.a = textDirectionAlgorithm;
    }

    private boolean a(CharSequence charSequence, int i, int i2) {
        switch (this.a.checkRtl(charSequence, i, i2)) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return a();
        }
    }

    protected abstract boolean a();

    public boolean isRtl(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
            return this.a == null ? a() : a(charSequence, i, i2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRtl(char[] cArr, int i, int i2) {
        return isRtl(CharBuffer.wrap(cArr), i, i2);
    }
}
