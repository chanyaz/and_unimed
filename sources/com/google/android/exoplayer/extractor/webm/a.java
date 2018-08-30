package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.b;
import java.nio.charset.Charset;
import java.util.Stack;

final class a implements EbmlReader {
    private final byte[] a = new byte[8];
    private final Stack<b> b = new Stack();
    private final d c = new d();
    private EbmlReaderOutput d;
    private int e;
    private int f;
    private long g;

    a() {
    }

    private long a(ExtractorInput extractorInput, int i) {
        int i2 = 0;
        extractorInput.readFully(this.a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.a[i2] & 255));
            i2++;
        }
        return j;
    }

    private double b(ExtractorInput extractorInput, int i) {
        long a = a(extractorInput, i);
        return i == 4 ? (double) Float.intBitsToFloat((int) a) : Double.longBitsToDouble(a);
    }

    private String c(ExtractorInput extractorInput, int i) {
        byte[] bArr = new byte[i];
        extractorInput.readFully(bArr, 0, i);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public void init(EbmlReaderOutput ebmlReaderOutput) {
        this.d = ebmlReaderOutput;
    }

    public boolean read(ExtractorInput extractorInput) {
        b.b(this.d != null);
        while (true) {
            if (this.b.isEmpty() || extractorInput.getPosition() < ((b) this.b.peek()).b) {
                if (this.e == 0) {
                    long a = this.c.a(extractorInput, true, false);
                    if (a == -1) {
                        return false;
                    }
                    this.f = (int) a;
                    this.e = 1;
                }
                if (this.e == 1) {
                    this.g = this.c.a(extractorInput, false, true);
                    this.e = 2;
                }
                int elementType = this.d.getElementType(this.f);
                switch (elementType) {
                    case 0:
                        extractorInput.skipFully((int) this.g);
                        this.e = 0;
                    case 1:
                        long position = extractorInput.getPosition();
                        this.b.add(new b(this.f, this.g + position));
                        this.d.startMasterElement(this.f, position, this.g);
                        this.e = 0;
                        return true;
                    case 2:
                        if (this.g > 8) {
                            throw new IllegalStateException("Invalid integer size: " + this.g);
                        }
                        this.d.integerElement(this.f, a(extractorInput, (int) this.g));
                        this.e = 0;
                        return true;
                    case 3:
                        if (this.g > 2147483647L) {
                            throw new IllegalStateException("String element size: " + this.g);
                        }
                        this.d.stringElement(this.f, c(extractorInput, (int) this.g));
                        this.e = 0;
                        return true;
                    case 4:
                        this.d.binaryElement(this.f, (int) this.g, extractorInput);
                        this.e = 0;
                        return true;
                    case 5:
                        if (this.g == 4 || this.g == 8) {
                            this.d.floatElement(this.f, b(extractorInput, (int) this.g));
                            this.e = 0;
                            return true;
                        }
                        throw new IllegalStateException("Invalid float size: " + this.g);
                    default:
                        throw new IllegalStateException("Invalid element type " + elementType);
                }
            }
            this.d.endMasterElement(((b) this.b.pop()).a);
            return true;
        }
    }

    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }
}
