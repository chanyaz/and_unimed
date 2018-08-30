package android.support.v4.text;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat a = new e(null, false);
    public static final TextDirectionHeuristicCompat b = new e(null, true);
    public static final TextDirectionHeuristicCompat c = new e(c.a, false);
    public static final TextDirectionHeuristicCompat d = new e(c.a, true);
    public static final TextDirectionHeuristicCompat e = new e(b.a, false);
    public static final TextDirectionHeuristicCompat f = f.a;

    interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int b(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
