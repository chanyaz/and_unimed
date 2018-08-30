package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.arch.lifecycle.d;
import android.arch.lifecycle.k;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.v4.util.s;
import android.support.v4.view.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements LifecycleOwner, ViewModelStoreOwner, ComponentCallbacks, OnCreateContextMenuListener {
    private static final s<String, Class<?>> a = new s();
    static final Object j = new Object();
    int A;
    FragmentManagerImpl B;
    o C;
    FragmentManagerImpl D;
    y E;
    k F;
    Fragment G;
    int H;
    int I;
    String J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P = true;
    boolean Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    boolean V = true;
    LoaderManagerImpl W;
    j X;
    boolean Y;
    boolean Z;
    float aa;
    LayoutInflater ab;
    boolean ac;
    d ad = new d(this);
    int k = 0;
    Bundle l;
    SparseArray<Parcelable> m;
    @Nullable
    Boolean n;
    int o = -1;
    String p;
    Bundle q;
    Fragment r;
    int s = -1;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    public class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exception) {
            super(str, exception);
        }
    }

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle a;

        SavedState(Bundle bundle) {
            this.a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader != null && this.a != null) {
                this.a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }
    }

    public static Fragment a(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.g(bundle);
            }
            return fragment;
        } catch (Exception e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        } catch (Exception e222) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e222);
        } catch (Exception e2222) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e2222);
        }
    }

    private void a() {
        OnStartEnterTransitionListener onStartEnterTransitionListener = null;
        if (this.X != null) {
            this.X.i = false;
            OnStartEnterTransitionListener onStartEnterTransitionListener2 = this.X.j;
            this.X.j = null;
            onStartEnterTransitionListener = onStartEnterTransitionListener2;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.onStartEnterTransition();
        }
    }

    static boolean a(Context context, String str) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private j ac() {
        if (this.X == null) {
            this.X = new j();
        }
        return this.X;
    }

    @Nullable
    public Object A() {
        return this.X == null ? null : this.X.n;
    }

    public Object B() {
        return this.X == null ? null : this.X.o == j ? A() : this.X.o;
    }

    @Nullable
    public Object C() {
        return this.X == null ? null : this.X.p;
    }

    @Nullable
    public Object D() {
        return this.X == null ? null : this.X.q == j ? C() : this.X.q;
    }

    public boolean E() {
        return (this.X == null || this.X.s == null) ? true : this.X.s.booleanValue();
    }

    public boolean F() {
        return (this.X == null || this.X.r == null) ? true : this.X.r.booleanValue();
    }

    public void G() {
        if (this.B == null || this.B.m == null) {
            ac().i = false;
        } else if (Looper.myLooper() != this.B.m.h().getLooper()) {
            this.B.m.h().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    Fragment.this.a();
                }
            });
        } else {
            a();
        }
    }

    void H() {
        if (this.C == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.D = new FragmentManagerImpl();
        this.D.a(this.C, new m() {
            public Fragment a(Context context, String str, Bundle bundle) {
                return Fragment.this.C.a(context, str, bundle);
            }

            @Nullable
            public View a(int i) {
                if (Fragment.this.S != null) {
                    return Fragment.this.S.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean a() {
                return Fragment.this.S != null;
            }
        }, this);
    }

    void I() {
        if (this.D != null) {
            this.D.o();
            this.D.i();
        }
        this.k = 4;
        this.Q = false;
        c();
        if (this.Q) {
            if (this.D != null) {
                this.D.r();
            }
            this.ad.a(Event.ON_START);
            return;
        }
        throw new av("Fragment " + this + " did not call through to super.onStart()");
    }

    void J() {
        if (this.D != null) {
            this.D.o();
            this.D.i();
        }
        this.k = 5;
        this.Q = false;
        t();
        if (this.Q) {
            if (this.D != null) {
                this.D.s();
                this.D.i();
            }
            this.ad.a(Event.ON_RESUME);
            return;
        }
        throw new av("Fragment " + this + " did not call through to super.onResume()");
    }

    void K() {
        if (this.D != null) {
            this.D.o();
        }
    }

    void L() {
        onLowMemory();
        if (this.D != null) {
            this.D.y();
        }
    }

    void M() {
        this.ad.a(Event.ON_PAUSE);
        if (this.D != null) {
            this.D.t();
        }
        this.k = 4;
        this.Q = false;
        u();
        if (!this.Q) {
            throw new av("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void N() {
        this.ad.a(Event.ON_STOP);
        if (this.D != null) {
            this.D.u();
        }
        this.k = 3;
        this.Q = false;
        d();
        if (!this.Q) {
            throw new av("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void O() {
        if (this.D != null) {
            this.D.v();
        }
        this.k = 2;
    }

    void P() {
        if (this.D != null) {
            this.D.w();
        }
        this.k = 1;
        this.Q = false;
        e();
        if (this.Q) {
            if (this.W != null) {
                this.W.a();
            }
            this.z = false;
            return;
        }
        throw new av("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    void Q() {
        this.ad.a(Event.ON_DESTROY);
        if (this.D != null) {
            this.D.x();
        }
        this.k = 0;
        this.Q = false;
        this.ac = false;
        v();
        if (this.Q) {
            this.D = null;
            return;
        }
        throw new av("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void R() {
        this.Q = false;
        b();
        this.ab = null;
        if (!this.Q) {
            throw new av("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.D == null) {
        } else {
            if (this.N) {
                this.D.x();
                this.D = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }

    int S() {
        return this.X == null ? 0 : this.X.d;
    }

    int T() {
        return this.X == null ? 0 : this.X.e;
    }

    int U() {
        return this.X == null ? 0 : this.X.f;
    }

    SharedElementCallback V() {
        return this.X == null ? null : this.X.g;
    }

    SharedElementCallback W() {
        return this.X == null ? null : this.X.h;
    }

    View X() {
        return this.X == null ? null : this.X.a;
    }

    Animator Y() {
        return this.X == null ? null : this.X.b;
    }

    int Z() {
        return this.X == null ? 0 : this.X.c;
    }

    Fragment a(String str) {
        return str.equals(this.p) ? this : this.D != null ? this.D.b(str) : null;
    }

    @Nullable
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    @NonNull
    public final String a(@StringRes int i) {
        return k().getString(i);
    }

    void a(int i, int i2) {
        if (this.X != null || i != 0 || i2 != 0) {
            ac();
            this.X.e = i;
            this.X.f = i2;
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    final void a(int i, Fragment fragment) {
        this.o = i;
        if (fragment != null) {
            this.p = fragment.p + ":" + this.o;
        } else {
            this.p = "android:fragment:" + this.o;
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    void a(Animator animator) {
        ac().b = animator;
    }

    @Deprecated
    @CallSuper
    public void a(Activity activity) {
        this.Q = true;
    }

    @Deprecated
    @CallSuper
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
    }

    @CallSuper
    public void a(Context context) {
        this.Q = true;
        Activity f = this.C == null ? null : this.C.f();
        if (f != null) {
            this.Q = false;
            a(f);
        }
    }

    @CallSuper
    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
        Activity f = this.C == null ? null : this.C.f();
        if (f != null) {
            this.Q = false;
            a(f, attributeSet, bundle);
        }
    }

    public void a(Intent intent) {
        a(intent, null);
    }

    public void a(Intent intent, int i, @Nullable Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, i, bundle);
    }

    public void a(Intent intent, @Nullable Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, -1, bundle);
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }

    void a(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ac();
        if (onStartEnterTransitionListener != this.X.j) {
            if (onStartEnterTransitionListener == null || this.X.j == null) {
                if (this.X.i) {
                    this.X.j = onStartEnterTransitionListener;
                }
                if (onStartEnterTransitionListener != null) {
                    onStartEnterTransitionListener.startListening();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void a(@Nullable SavedState savedState) {
        if (this.o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.a == null) ? null : savedState.a;
        this.l = bundle;
    }

    public void a(Fragment fragment) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    void a(View view) {
        ac().a = view;
    }

    public void a(@NonNull View view, @Nullable Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.I));
        printWriter.print(" mTag=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.o);
        printWriter.print(" mWho=");
        printWriter.print(this.p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.u);
        printWriter.print(" mRemoving=");
        printWriter.print(this.v);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.w);
        printWriter.print(" mInLayout=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.K);
        printWriter.print(" mDetached=");
        printWriter.print(this.L);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.P);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.O);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.M);
        printWriter.print(" mRetaining=");
        printWriter.print(this.N);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.C);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.G);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.q);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.l);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.m);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.r);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        if (S() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(S());
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.S);
        }
        if (this.T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.S);
        }
        if (X() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(X());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(Z());
        }
        if (this.W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.W.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.D + ":");
            this.D.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    boolean aa() {
        return this.X == null ? false : this.X.i;
    }

    boolean ab() {
        return this.X == null ? false : this.X.k;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    View b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.D != null) {
            this.D.o();
        }
        this.z = true;
        return a(layoutInflater, viewGroup, bundle);
    }

    @CallSuper
    public void b() {
        this.Q = true;
    }

    void b(int i) {
        if (this.X != null || i != 0) {
            ac().d = i;
        }
    }

    @CallSuper
    public void b(@Nullable Bundle bundle) {
        this.Q = true;
        j(bundle);
        if (this.D != null && !this.D.a(1)) {
            this.D.p();
        }
    }

    public void b(Menu menu) {
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            z = true;
            a(menu, menuInflater);
        }
        return this.D != null ? z | this.D.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    @NonNull
    public LayoutInflater c(@Nullable Bundle bundle) {
        return i(bundle);
    }

    @CallSuper
    public void c() {
        this.Q = true;
    }

    void c(int i) {
        ac().c = i;
    }

    public void c(boolean z) {
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            z = true;
            a(menu);
        }
        return this.D != null ? z | this.D.a(menu) : z;
    }

    boolean c(MenuItem menuItem) {
        if (!this.K) {
            if (this.O && this.P && a(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @CallSuper
    public void d() {
        this.Q = true;
    }

    @CallSuper
    public void d(@Nullable Bundle bundle) {
        this.Q = true;
    }

    void d(Menu menu) {
        if (!this.K) {
            if (this.O && this.P) {
                b(menu);
            }
            if (this.D != null) {
                this.D.b(menu);
            }
        }
    }

    public void d(boolean z) {
        if (this.O != z) {
            this.O = z;
            if (o() && !r()) {
                this.C.c();
            }
        }
    }

    boolean d(MenuItem menuItem) {
        if (!this.K) {
            if (b(menuItem)) {
                return true;
            }
            if (this.D != null && this.D.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @CallSuper
    public void e() {
        this.Q = true;
    }

    public void e(@NonNull Bundle bundle) {
    }

    public void e(boolean z) {
        if (this.P != z) {
            this.P = z;
            if (this.O && o() && !r()) {
                this.C.c();
            }
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    final void f(Bundle bundle) {
        if (this.m != null) {
            this.T.restoreHierarchyState(this.m);
            this.m = null;
        }
        this.Q = false;
        k(bundle);
        if (!this.Q) {
            throw new av("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void f(boolean z) {
        if (!this.V && z && this.k < 4 && this.B != null && o()) {
            this.B.b(this);
        }
        this.V = z;
        boolean z2 = this.k < 4 && !z;
        this.U = z2;
        if (this.l != null) {
            this.n = Boolean.valueOf(this.V);
        }
    }

    final boolean f() {
        return this.A > 0;
    }

    public void g(@Nullable Bundle bundle) {
        if (this.o < 0 || !g()) {
            this.q = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public void g(boolean z) {
    }

    public final boolean g() {
        return this.B == null ? false : this.B.g();
    }

    public Lifecycle getLifecycle() {
        return this.ad;
    }

    @NonNull
    public k getViewModelStore() {
        if (h() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.F == null) {
            this.F = new k();
        }
        return this.F;
    }

    @Nullable
    public Context h() {
        return this.C == null ? null : this.C.g();
    }

    @NonNull
    LayoutInflater h(@Nullable Bundle bundle) {
        this.ab = c(bundle);
        return this.ab;
    }

    public void h(boolean z) {
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public final Context i() {
        Context h = h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Deprecated
    @NonNull
    public LayoutInflater i(@Nullable Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater b = this.C.b();
        m();
        e.b(b, this.D.A());
        return b;
    }

    void i(boolean z) {
        g(z);
        if (this.D != null) {
            this.D.a(z);
        }
    }

    @Nullable
    public final FragmentActivity j() {
        return this.C == null ? null : (FragmentActivity) this.C.f();
    }

    void j(@Nullable Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.D == null) {
                    H();
                }
                this.D.a(parcelable, this.E);
                this.E = null;
                this.D.p();
            }
        }
    }

    void j(boolean z) {
        h(z);
        if (this.D != null) {
            this.D.b(z);
        }
    }

    @NonNull
    public final Resources k() {
        return i().getResources();
    }

    @CallSuper
    public void k(@Nullable Bundle bundle) {
        this.Q = true;
    }

    void k(boolean z) {
        ac().k = z;
    }

    @Nullable
    public final FragmentManager l() {
        return this.B;
    }

    void l(Bundle bundle) {
        if (this.D != null) {
            this.D.o();
        }
        this.k = 1;
        this.Q = false;
        b(bundle);
        this.ac = true;
        if (this.Q) {
            this.ad.a(Event.ON_CREATE);
            return;
        }
        throw new av("Fragment " + this + " did not call through to super.onCreate()");
    }

    @NonNull
    public final FragmentManager m() {
        if (this.D == null) {
            H();
            if (this.k >= 5) {
                this.D.s();
            } else if (this.k >= 4) {
                this.D.r();
            } else if (this.k >= 2) {
                this.D.q();
            } else if (this.k >= 1) {
                this.D.p();
            }
        }
        return this.D;
    }

    void m(Bundle bundle) {
        if (this.D != null) {
            this.D.o();
        }
        this.k = 2;
        this.Q = false;
        d(bundle);
        if (!this.Q) {
            throw new av("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.D != null) {
            this.D.q();
        }
    }

    @Nullable
    FragmentManager n() {
        return this.D;
    }

    void n(Bundle bundle) {
        e(bundle);
        if (this.D != null) {
            Parcelable n = this.D.n();
            if (n != null) {
                bundle.putParcelable("android:support:fragments", n);
            }
        }
    }

    public final boolean o() {
        return this.C != null && this.u;
    }

    @CallSuper
    public void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        j().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @CallSuper
    public void onLowMemory() {
        this.Q = true;
    }

    public final boolean p() {
        return this.L;
    }

    public final boolean q() {
        return this.v;
    }

    public final boolean r() {
        return this.K;
    }

    @Nullable
    public View s() {
        return this.S;
    }

    public void startActivityForResult(Intent intent, int i) {
        a(intent, i, null);
    }

    @CallSuper
    public void t() {
        this.Q = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        android.support.v4.util.d.a(this, stringBuilder);
        if (this.o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.o);
        }
        if (this.H != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.H));
        }
        if (this.J != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.J);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @CallSuper
    public void u() {
        this.Q = true;
    }

    @CallSuper
    public void v() {
        this.Q = true;
        if (this.F != null && !this.C.d.s) {
            this.F.a();
        }
    }

    void w() {
        this.o = -1;
        this.p = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.H = 0;
        this.I = 0;
        this.J = null;
        this.K = false;
        this.L = false;
        this.N = false;
    }

    public void x() {
    }

    @Nullable
    public Object y() {
        return this.X == null ? null : this.X.l;
    }

    @Nullable
    public Object z() {
        return this.X == null ? null : this.X.m == j ? y() : this.X.m;
    }
}
