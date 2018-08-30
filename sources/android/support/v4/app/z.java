package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;

public abstract class z extends n {
    private final FragmentManager a;
    private FragmentTransaction b = null;
    private Fragment c = null;

    public z(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public Parcelable a() {
        return null;
    }

    public abstract Fragment a(int i);

    public Object a(ViewGroup viewGroup, int i) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        long b = b(i);
        Fragment a = this.a.a(a(viewGroup.getId(), b));
        if (a != null) {
            this.b.c(a);
        } else {
            a = a(i);
            this.b.a(viewGroup.getId(), a, a(viewGroup.getId(), b));
        }
        if (a != this.c) {
            a.e(false);
            a.f(false);
        }
        return a;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        this.b.b((Fragment) obj);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).s() == view;
    }

    public long b(int i) {
        return (long) i;
    }

    public void b(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.e();
            this.b = null;
        }
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.c) {
            if (this.c != null) {
                this.c.e(false);
                this.c.f(false);
            }
            if (fragment != null) {
                fragment.e(true);
                fragment.f(true);
            }
            this.c = fragment;
        }
    }
}
