package com.squareup.picasso;

import com.squareup.picasso.Picasso.Priority;
import java.util.concurrent.FutureTask;

final class ab extends FutureTask<d> implements Comparable<ab> {
    private final d a;

    public ab(d dVar) {
        super(dVar, null);
        this.a = dVar;
    }

    /* renamed from: a */
    public int compareTo(ab abVar) {
        Priority n = this.a.n();
        Priority n2 = abVar.a.n();
        return n == n2 ? this.a.a - abVar.a.a : n2.ordinal() - n.ordinal();
    }
}
