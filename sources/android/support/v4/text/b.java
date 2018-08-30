package android.support.v4.text;

class b implements TextDirectionAlgorithm {
    static final b a = new b(true);
    static final b b = new b(false);
    private final boolean c;

    private b(boolean z) {
        this.c = z;
    }

    public int checkRtl(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            switch (TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i)))) {
                case 0:
                    if (!this.c) {
                        i4 = 1;
                        break;
                    }
                    return 0;
                case 1:
                    if (this.c) {
                        i4 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
            i++;
        }
        return i4 != 0 ? !this.c ? 0 : 1 : 2;
    }
}
