package android.support.v4.text;

class c implements TextDirectionAlgorithm {
    static final c a = new c();

    private c() {
    }

    public int checkRtl(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            i4 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return i4;
    }
}
