package android.support.v4.app;

import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.util.e;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class d extends FragmentTransaction implements BackStackEntry, OpGenerator {
    final FragmentManagerImpl a;
    ArrayList<e> b = new ArrayList();
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    public d(FragmentManagerImpl fragmentManagerImpl) {
        this.a = fragmentManagerImpl;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        fragment.B = this.a;
        if (str != null) {
            if (fragment.J == null || str.equals(fragment.J)) {
                fragment.J = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.J + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.H == 0 || fragment.H == i) {
                fragment.H = i;
                fragment.I = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.H + " now " + i);
            }
        }
        a(new e(i2, fragment));
    }

    private static boolean b(e eVar) {
        Fragment fragment = eVar.b;
        return (fragment == null || !fragment.u || fragment.S == null || fragment.L || fragment.K || !fragment.aa()) ? false : true;
    }

    int a(boolean z) {
        if (this.l) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
            a("  ", null, printWriter, null);
            printWriter.close();
        }
        this.l = true;
        if (this.i) {
            this.m = this.a.a(this);
        } else {
            this.m = -1;
        }
        this.a.a((OpGenerator) this, z);
        return this.m;
    }

    Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return fragment;
            }
            e eVar = (e) this.b.get(i2);
            switch (eVar.a) {
                case 1:
                case 7:
                    arrayList.add(eVar.b);
                    break;
                case 2:
                    Fragment fragment2 = eVar.b;
                    int i3 = fragment2.I;
                    Object obj = null;
                    int size = arrayList.size() - 1;
                    Fragment fragment3 = fragment;
                    int i4 = i2;
                    while (size >= 0) {
                        Object obj2;
                        Fragment fragment4 = (Fragment) arrayList.get(size);
                        if (fragment4.I != i3) {
                            obj2 = obj;
                        } else if (fragment4 == fragment2) {
                            obj2 = 1;
                        } else {
                            if (fragment4 == fragment3) {
                                this.b.add(i4, new e(9, fragment4));
                                i4++;
                                fragment3 = null;
                            }
                            e eVar2 = new e(3, fragment4);
                            eVar2.c = eVar.c;
                            eVar2.e = eVar.e;
                            eVar2.d = eVar.d;
                            eVar2.f = eVar.f;
                            this.b.add(i4, eVar2);
                            arrayList.remove(fragment4);
                            i4++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.b.remove(i4);
                        i4--;
                    } else {
                        eVar.a = 1;
                        arrayList.add(fragment2);
                    }
                    i2 = i4;
                    fragment = fragment3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(eVar.b);
                    if (eVar.b != fragment) {
                        break;
                    }
                    this.b.add(i2, new e(9, eVar.b));
                    i2++;
                    fragment = null;
                    break;
                case 8:
                    this.b.add(i2, new e(9, fragment));
                    i2++;
                    fragment = eVar.b;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    public FragmentTransaction a() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    public FragmentTransaction a(int i, int i2) {
        return a(i, i2, 0, 0);
    }

    public FragmentTransaction a(int i, int i2, int i3, int i4) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        return this;
    }

    public FragmentTransaction a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public FragmentTransaction a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    public FragmentTransaction a(Fragment fragment) {
        a(new e(3, fragment));
        return this;
    }

    public FragmentTransaction a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public FragmentTransaction a(String str) {
        if (this.j) {
            this.i = true;
            this.k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    void a(int i) {
        if (this.i) {
            if (FragmentManagerImpl.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.b.get(i2);
                if (eVar.b != null) {
                    Fragment fragment = eVar.b;
                    fragment.A += i;
                    if (FragmentManagerImpl.a) {
                        Log.v("FragmentManager", "Bump nesting of " + eVar.b + " to " + eVar.b.A);
                    }
                }
            }
        }
    }

    void a(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b.size()) {
                e eVar = (e) this.b.get(i2);
                if (b(eVar)) {
                    eVar.b.a(onStartEnterTransitionListener);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    void a(e eVar) {
        this.b.add(eVar);
        eVar.c = this.c;
        eVar.d = this.d;
        eVar.e = this.e;
        eVar.f = this.f;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                String str2;
                e eVar = (e) this.b.get(i);
                switch (eVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + eVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(eVar.b);
                if (z) {
                    if (!(eVar.c == 0 && eVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(eVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(eVar.d));
                    }
                    if (eVar.e != 0 || eVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(eVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(eVar.f));
                    }
                }
            }
        }
    }

    boolean a(ArrayList<d> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.b.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            e eVar = (e) this.b.get(i4);
            int i6 = eVar.b != null ? eVar.b.I : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    d dVar = (d) arrayList.get(i7);
                    int size2 = dVar.b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        e eVar2 = (e) dVar.b.get(i8);
                        if ((eVar2.b != null ? eVar2.b.I : 0) == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return fragment;
            }
            e eVar = (e) this.b.get(i2);
            switch (eVar.a) {
                case 1:
                case 7:
                    arrayList.remove(eVar.b);
                    break;
                case 3:
                case 6:
                    arrayList.add(eVar.b);
                    break;
                case 8:
                    fragment = null;
                    break;
                case 9:
                    fragment = eVar.b;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    public FragmentTransaction b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    public FragmentTransaction b(Fragment fragment) {
        a(new e(6, fragment));
        return this;
    }

    public void b() {
        if (this.u != null) {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.u.get(i)).run();
            }
            this.u = null;
        }
    }

    void b(boolean z) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            e eVar = (e) this.b.get(size);
            Fragment fragment = eVar.b;
            if (fragment != null) {
                fragment.a(FragmentManagerImpl.d(this.g), this.h);
            }
            switch (eVar.a) {
                case 1:
                    fragment.b(eVar.f);
                    this.a.i(fragment);
                    break;
                case 3:
                    fragment.b(eVar.e);
                    this.a.a(fragment, false);
                    break;
                case 4:
                    fragment.b(eVar.e);
                    this.a.k(fragment);
                    break;
                case 5:
                    fragment.b(eVar.f);
                    this.a.j(fragment);
                    break;
                case 6:
                    fragment.b(eVar.e);
                    this.a.m(fragment);
                    break;
                case 7:
                    fragment.b(eVar.f);
                    this.a.l(fragment);
                    break;
                case 8:
                    this.a.p(null);
                    break;
                case 9:
                    this.a.p(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + eVar.a);
            }
            if (!(this.t || eVar.a == 3 || fragment == null)) {
                this.a.f(fragment);
            }
        }
        if (!this.t && z) {
            this.a.a(this.a.l, true);
        }
    }

    boolean b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = (e) this.b.get(i2);
            int i3 = eVar.b != null ? eVar.b.I : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public int c() {
        return a(false);
    }

    public FragmentTransaction c(Fragment fragment) {
        a(new e(7, fragment));
        return this;
    }

    public int d() {
        return a(true);
    }

    public void e() {
        a();
        this.a.b((OpGenerator) this, true);
    }

    void f() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            e eVar = (e) this.b.get(i);
            Fragment fragment = eVar.b;
            if (fragment != null) {
                fragment.a(this.g, this.h);
            }
            switch (eVar.a) {
                case 1:
                    fragment.b(eVar.c);
                    this.a.a(fragment, false);
                    break;
                case 3:
                    fragment.b(eVar.d);
                    this.a.i(fragment);
                    break;
                case 4:
                    fragment.b(eVar.d);
                    this.a.j(fragment);
                    break;
                case 5:
                    fragment.b(eVar.c);
                    this.a.k(fragment);
                    break;
                case 6:
                    fragment.b(eVar.d);
                    this.a.l(fragment);
                    break;
                case 7:
                    fragment.b(eVar.c);
                    this.a.m(fragment);
                    break;
                case 8:
                    this.a.p(fragment);
                    break;
                case 9:
                    this.a.p(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + eVar.a);
            }
            if (!(this.t || eVar.a == 1 || fragment == null)) {
                this.a.f(fragment);
            }
        }
        if (!this.t) {
            this.a.a(this.a.l, true);
        }
    }

    boolean g() {
        for (int i = 0; i < this.b.size(); i++) {
            if (b((e) this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean generateOps(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.i) {
            this.a.b(this);
        }
        return true;
    }

    public CharSequence getBreadCrumbShortTitle() {
        return this.p != 0 ? this.a.m.g().getText(this.p) : this.q;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.p;
    }

    public CharSequence getBreadCrumbTitle() {
        return this.n != 0 ? this.a.m.g().getText(this.n) : this.o;
    }

    public int getBreadCrumbTitleRes() {
        return this.n;
    }

    public int getId() {
        return this.m;
    }

    public String getName() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.m);
        }
        if (this.k != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.k);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
