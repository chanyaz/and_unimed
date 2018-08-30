package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class n {
    private final o<?> a;

    private n(o<?> oVar) {
        this.a = oVar;
    }

    public static n a(o<?> oVar) {
        return new n(oVar);
    }

    @Nullable
    public Fragment a(String str) {
        return this.a.d.b(str);
    }

    public FragmentManager a() {
        return this.a.i();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.d.onCreateView(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void a(Parcelable parcelable, y yVar) {
        this.a.d.a(parcelable, yVar);
    }

    public void a(Fragment fragment) {
        this.a.d.a(this.a, this.a, fragment);
    }

    public void a(boolean z) {
        this.a.d.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public void b() {
        this.a.d.o();
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public void b(boolean z) {
        this.a.d.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public Parcelable c() {
        return this.a.d.n();
    }

    public y d() {
        return this.a.d.l();
    }

    public void e() {
        this.a.d.p();
    }

    public void f() {
        this.a.d.q();
    }

    public void g() {
        this.a.d.r();
    }

    public void h() {
        this.a.d.s();
    }

    public void i() {
        this.a.d.t();
    }

    public void j() {
        this.a.d.u();
    }

    public void k() {
        this.a.d.v();
    }

    public void l() {
        this.a.d.x();
    }

    public void m() {
        this.a.d.y();
    }

    public boolean n() {
        return this.a.d.i();
    }
}
