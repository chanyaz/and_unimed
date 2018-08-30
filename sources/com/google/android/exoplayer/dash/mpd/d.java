package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.l;

public final class d {
    public final long a;
    public final long b;
    private final String c;
    private final String d;
    private int e;

    public d(String str, String str2, long j, long j2) {
        boolean z = (str == null && str2 == null) ? false : true;
        b.a(z);
        this.c = str;
        this.d = str2;
        this.a = j;
        this.b = j2;
    }

    public Uri a() {
        return l.a(this.c, this.d);
    }

    public d a(d dVar) {
        d dVar2 = null;
        long j = -1;
        if (dVar != null && b().equals(dVar.b())) {
            String str;
            String str2;
            long j2;
            if (this.b != -1 && this.a + this.b == dVar.a) {
                str = this.c;
                str2 = this.d;
                j2 = this.a;
                if (dVar.b != -1) {
                    j = this.b + dVar.b;
                }
                dVar2 = new d(str, str2, j2, j);
            } else if (dVar.b != -1 && dVar.a + dVar.b == this.a) {
                str = this.c;
                str2 = this.d;
                j2 = dVar.a;
                if (this.b != -1) {
                    j = dVar.b + this.b;
                }
                dVar2 = new d(str, str2, j2, j);
            }
        }
        return dVar2;
    }

    public String b() {
        return l.b(this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && b().equals(dVar.b());
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((((((int) this.a) + 527) * 31) + ((int) this.b)) * 31) + b().hashCode();
        }
        return this.e;
    }
}
