package com.google.android.gms.internal.ads;

public abstract class abe<M extends abe<M>> extends abj {
    protected abg Y;

    protected int a() {
        int i = 0;
        if (this.Y == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.Y.a()) {
            i2 += this.Y.b(i).a();
            i++;
        }
        return i2;
    }

    public void a(abd abd) {
        if (this.Y != null) {
            for (int i = 0; i < this.Y.a(); i++) {
                this.Y.b(i).a(abd);
            }
        }
    }

    protected final boolean a(abb abb, int i) {
        int j = abb.j();
        if (!abb.b(i)) {
            return false;
        }
        int i2 = i >>> 3;
        abl abl = new abl(i, abb.a(j, abb.j() - j));
        abh abh = null;
        if (this.Y == null) {
            this.Y = new abg();
        } else {
            abh = this.Y.a(i2);
        }
        if (abh == null) {
            abh = new abh();
            this.Y.a(i2, abh);
        }
        abh.a(abl);
        return true;
    }

    public final /* synthetic */ abj c() {
        return (abe) clone();
    }

    public /* synthetic */ Object clone() {
        abe abe = (abe) super.clone();
        abi.a(this, abe);
        return abe;
    }
}
