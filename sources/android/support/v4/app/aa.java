package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.n;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class aa extends n {
    private final FragmentManager a;
    private FragmentTransaction b = null;
    private ArrayList<SavedState> c = new ArrayList();
    private ArrayList<Fragment> d = new ArrayList();
    private Fragment e = null;

    public aa(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    public Parcelable a() {
        Bundle bundle = null;
        if (this.c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.c.size()];
            this.c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.d.size(); i++) {
            Fragment fragment = (Fragment) this.d.get(i);
            if (fragment != null && fragment.o()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.a.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public abstract Fragment a(int i);

    public Object a(ViewGroup viewGroup, int i) {
        if (this.d.size() > i) {
            Fragment fragment = (Fragment) this.d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.b == null) {
            this.b = this.a.a();
        }
        Fragment a = a(i);
        if (this.c.size() > i) {
            SavedState savedState = (SavedState) this.c.get(i);
            if (savedState != null) {
                a.a(savedState);
            }
        }
        while (this.d.size() <= i) {
            this.d.add(null);
        }
        a.e(false);
        a.f(false);
        this.d.set(i, a);
        this.b.a(viewGroup.getId(), a);
        return a;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.c.clear();
            this.d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.a.a(bundle, str);
                    if (a != null) {
                        while (this.d.size() <= parseInt) {
                            this.d.add(null);
                        }
                        a.e(false);
                        this.d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.b == null) {
            this.b = this.a.a();
        }
        while (this.c.size() <= i) {
            this.c.add(null);
        }
        this.c.set(i, fragment.o() ? this.a.a(fragment) : null);
        this.d.set(i, null);
        this.b.a(fragment);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).s() == view;
    }

    public void b(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.e();
            this.b = null;
        }
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.e) {
            if (this.e != null) {
                this.e.e(false);
                this.e.f(false);
            }
            if (fragment != null) {
                fragment.e(true);
                fragment.f(true);
            }
            this.e = fragment;
        }
    }
}
