package com.mopub.common;

import android.support.annotation.NonNull;
import com.mopub.common.DiskLruCache.Editor;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class e extends FilterOutputStream {
    final /* synthetic */ Editor a;

    private e(Editor editor, OutputStream outputStream) {
        this.a = editor;
        super(outputStream);
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.a.d = true;
        }
    }

    public void write(@NonNull byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.a.d = true;
        }
    }
}
