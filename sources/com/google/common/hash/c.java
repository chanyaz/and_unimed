package com.google.common.hash;

import com.google.common.base.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class c extends a {
    private final ByteBuffer a;
    private final int b;
    private final int c;

    protected c(int i) {
        this(i, i);
    }

    protected c(int i, int i2) {
        s.a(i2 % i == 0);
        this.a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    private void b() {
        if (this.a.remaining() < 8) {
            c();
        }
    }

    private Hasher c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            b();
        } else {
            int position = this.b - this.a.position();
            for (int i = 0; i < position; i++) {
                this.a.put(byteBuffer.get());
            }
            c();
            while (byteBuffer.remaining() >= this.c) {
                a(byteBuffer);
            }
            this.a.put(byteBuffer);
        }
        return this;
    }

    private void c() {
        this.a.flip();
        while (this.a.remaining() >= this.c) {
            a(this.a);
        }
        this.a.compact();
    }

    abstract g a();

    protected abstract void a(ByteBuffer byteBuffer);

    protected void b(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.c + 7);
        while (byteBuffer.position() < this.c) {
            byteBuffer.putLong(0);
        }
        byteBuffer.limit(this.c);
        byteBuffer.flip();
        a(byteBuffer);
    }

    public final g hash() {
        c();
        this.a.flip();
        if (this.a.remaining() > 0) {
            b(this.a);
        }
        return a();
    }

    public final Hasher putByte(byte b) {
        this.a.put(b);
        b();
        return this;
    }

    public final Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return c(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    public final Hasher putChar(char c) {
        this.a.putChar(c);
        b();
        return this;
    }

    public final Hasher putInt(int i) {
        this.a.putInt(i);
        b();
        return this;
    }

    public final Hasher putLong(long j) {
        this.a.putLong(j);
        b();
        return this;
    }

    public final <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    public final Hasher putShort(short s) {
        this.a.putShort(s);
        b();
        return this;
    }

    public final Hasher putUnencodedChars(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }
}
