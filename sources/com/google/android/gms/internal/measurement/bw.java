package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class bw {
    private int a;
    private ByteArrayOutputStream b = new ByteArrayOutputStream();
    private final /* synthetic */ bv c;

    public bw(bv bvVar) {
        this.c = bvVar;
    }

    public final int a() {
        return this.a;
    }

    public final boolean a(bp bpVar) {
        ar.a((Object) bpVar);
        if (this.a + 1 > bd.g()) {
            return false;
        }
        String a = this.c.a(bpVar, false);
        if (a == null) {
            this.c.h().a(bpVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > bd.c()) {
            this.c.h().a(bpVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.b.size() > 0) {
            length++;
        }
        if (this.b.size() + length > ((Integer) bk.t.a()).intValue()) {
            return false;
        }
        try {
            if (this.b.size() > 0) {
                this.b.write(bv.c);
            }
            this.b.write(bytes);
            this.a++;
            return true;
        } catch (IOException e) {
            this.c.e("Failed to write payload when batching hits", e);
            return true;
        }
    }

    public final byte[] b() {
        return this.b.toByteArray();
    }
}
