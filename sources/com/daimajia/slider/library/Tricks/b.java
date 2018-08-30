package com.daimajia.slider.library.Tricks;

import android.os.Parcelable;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import com.daimajia.slider.library.f;

public class b extends n {
    private f a;

    public b(f fVar) {
        this.a = fVar;
    }

    private void a(String str) {
    }

    public Parcelable a() {
        return this.a.a();
    }

    public Object a(ViewGroup viewGroup, int i) {
        if (e() == 0) {
            return null;
        }
        int e = i % e();
        a("instantiateItem: real position: " + i);
        a("instantiateItem: virtual position: " + e);
        return this.a.a(viewGroup, e);
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
        this.a.a(parcelable, classLoader);
    }

    public void a(ViewGroup viewGroup) {
        this.a.a(viewGroup);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        if (e() != 0) {
            int e = i % e();
            a("destroyItem: real position: " + i);
            a("destroyItem: virtual position: " + e);
            this.a.a(viewGroup, e, obj);
        }
    }

    public boolean a(View view, Object obj) {
        return this.a.a(view, obj);
    }

    public int b() {
        return this.a.b();
    }

    public void b(ViewGroup viewGroup) {
        this.a.b(viewGroup);
    }

    public f d() {
        return this.a;
    }

    public int e() {
        return this.a.b();
    }
}
