package com.fasterxml.jackson.core.sym;

import com.appnext.base.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteQuadsCanonicalizer {
    protected int _count;
    protected final boolean _failOnDoS;
    protected int[] _hashArea;
    protected int _hashSize;
    protected boolean _intern;
    protected final ByteQuadsCanonicalizer _parent = null;
    protected int _secondaryStart;
    private final int _seed;
    protected int _spilloverEnd;
    protected final AtomicReference<TableInfo> _tableInfo;
    protected int _tertiaryStart;

    final class TableInfo {
        public final int count;
        public final int longNameOffset;
        public final int[] mainHash;
        public final String[] names;
        public final int size;
        public final int spilloverEnd;
        public final int tertiaryShift;

        public TableInfo(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
            this.size = i;
            this.count = i2;
            this.tertiaryShift = i3;
            this.mainHash = iArr;
            this.names = strArr;
            this.spilloverEnd = i4;
            this.longNameOffset = i5;
        }

        public static TableInfo createInitial(int i) {
            int i2 = i << 3;
            return new TableInfo(i, 0, ByteQuadsCanonicalizer._calcTertiaryShift(i), new int[i2], new String[(i << 1)], i2 - i, i2);
        }
    }

    private ByteQuadsCanonicalizer(int i, boolean z, int i2, boolean z2) {
        int i3 = 16;
        this._seed = i2;
        this._intern = z;
        this._failOnDoS = z2;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this._tableInfo = new AtomicReference(TableInfo.createInitial(i));
    }

    static int _calcTertiaryShift(int i) {
        int i2 = i >> 2;
        return i2 < 64 ? 4 : i2 <= 256 ? 5 : i2 <= c.jk ? 6 : 7;
    }

    private final int _spilloverStart() {
        int i = this._hashSize;
        return (i << 3) - i;
    }

    public static ByteQuadsCanonicalizer createRoot() {
        long currentTimeMillis = System.currentTimeMillis();
        return createRoot((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static ByteQuadsCanonicalizer createRoot(int i) {
        return new ByteQuadsCanonicalizer(64, true, i, true);
    }

    public int primaryCount() {
        int i = this._secondaryStart;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this._hashArea[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public int secondaryCount() {
        int i = this._secondaryStart + 3;
        int i2 = this._tertiaryStart;
        int i3 = i;
        i = 0;
        for (int i4 = i3; i4 < i2; i4 += 4) {
            if (this._hashArea[i4] != 0) {
                i++;
            }
        }
        return i;
    }

    public int spilloverCount() {
        return (this._spilloverEnd - _spilloverStart()) >> 2;
    }

    public int tertiaryCount() {
        int i = this._tertiaryStart + 3;
        int i2 = this._hashSize + i;
        int i3 = i;
        i = 0;
        for (int i4 = i3; i4 < i2; i4 += 4) {
            if (this._hashArea[i4] != 0) {
                i++;
            }
        }
        return i;
    }

    public String toString() {
        int primaryCount = primaryCount();
        int secondaryCount = secondaryCount();
        int tertiaryCount = tertiaryCount();
        int spilloverCount = spilloverCount();
        int totalCount = totalCount();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{getClass().getName(), Integer.valueOf(this._count), Integer.valueOf(this._hashSize), Integer.valueOf(primaryCount), Integer.valueOf(secondaryCount), Integer.valueOf(tertiaryCount), Integer.valueOf(spilloverCount), Integer.valueOf(totalCount), Integer.valueOf(((primaryCount + secondaryCount) + tertiaryCount) + spilloverCount), Integer.valueOf(totalCount)});
    }

    public int totalCount() {
        int i = this._hashSize << 3;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this._hashArea[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }
}
