package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.e;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends LayoutManager implements ScrollVectorProvider {
    private SavedState A;
    private int B;
    private final Rect C = new Rect();
    private final ct D = new ct(this);
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };
    cu[] a;
    @NonNull
    bn b;
    @NonNull
    bn c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    LazySpanLookup h = new LazySpanLookup();
    private int i = -1;
    private int j;
    private int k;
    @NonNull
    private final bb l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        cu a;
        boolean b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            return this.a == null ? -1 : this.a.e;
        }
    }

    class LazySpanLookup {
        int[] a;
        List<FullSpanItem> b;

        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int a;
            int b;
            int[] c;
            boolean d;

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }
        }

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            if (this.b != null) {
                int i3 = i + i2;
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                    if (fullSpanItem.a >= i) {
                        if (fullSpanItem.a < i3) {
                            this.b.remove(size);
                        } else {
                            fullSpanItem.a -= i2;
                        }
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                    if (fullSpanItem.a >= i) {
                        fullSpanItem.a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.b.get(i2);
            this.b.remove(i2);
            return f.a;
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i) {
                    if (i3 == 0 || fullSpanItem.b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i + i2, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                c(i, i2);
            }
        }

        void a(int i, cu cuVar) {
            e(i);
            this.a[i] = cuVar.e;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            Arrays.fill(this.a, i, g + 1, -1);
            return g + 1;
        }

        void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i, this.a, i + i2, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i + i2, -1);
                d(i, i2);
            }
        }

        int c(int i) {
            return (this.a == null || i >= this.a.length) ? -1 : this.a[i];
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                this.a = new int[d(i)];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        public FullSpanItem f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.j = z;
            this.g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            if (!this.j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.g);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.j = i2;
        a(i);
        this.l = new bb();
        M();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        bu a = LayoutManager.a(context, attributeSet, i, i2);
        b(a.a);
        a(a.b);
        a(a.c);
        this.l = new bb();
        M();
    }

    private void M() {
        this.b = bn.a(this, this.j);
        this.c = bn.a(this, 1 - this.j);
    }

    private void N() {
        boolean z = true;
        if (this.j == 1 || !j()) {
            this.e = this.d;
            return;
        }
        if (this.d) {
            z = false;
        }
        this.e = z;
    }

    private void O() {
        if (this.c.h() != 1073741824) {
            float f = 0.0f;
            int w = w();
            int i = 0;
            while (i < w) {
                float f2;
                View h = h(i);
                float e = (float) this.c.e(h);
                if (e < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((LayoutParams) h.getLayoutParams()).a() ? (1.0f * e) / ((float) this.i) : e);
                }
                i++;
                f = f2;
            }
            i = this.k;
            int round = Math.round(((float) this.i) * f);
            if (this.c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.c.f());
            }
            e(round);
            if (this.k != i) {
                for (int i2 = 0; i2 < w; i2++) {
                    View h2 = h(i2);
                    LayoutParams layoutParams = (LayoutParams) h2.getLayoutParams();
                    if (!layoutParams.b) {
                        if (j() && this.j == 1) {
                            h2.offsetLeftAndRight(((-((this.i - 1) - layoutParams.a.e)) * this.k) - ((-((this.i - 1) - layoutParams.a.e)) * i));
                        } else {
                            int i3 = layoutParams.a.e * this.k;
                            round = layoutParams.a.e * i;
                            if (this.j == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int a(bz bzVar, bb bbVar, State state) {
        int q;
        this.m.set(0, this.i, true);
        int i = this.l.i ? bbVar.e == 1 ? MoPubClientPositioning.NO_REPEAT : Integer.MIN_VALUE : bbVar.e == 1 ? bbVar.g + bbVar.b : bbVar.f - bbVar.b;
        a(bbVar.e, i);
        int d = this.e ? this.b.d() : this.b.c();
        Object obj = null;
        while (bbVar.a(state) && (this.l.i || !this.m.isEmpty())) {
            cu cuVar;
            int e;
            int e2;
            View a = bbVar.a(bzVar);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            int f = layoutParams.f();
            int c = this.h.c(f);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                cu a2 = layoutParams.b ? this.a[0] : a(bbVar);
                this.h.a(f, a2);
                cuVar = a2;
            } else {
                cuVar = this.a[c];
            }
            layoutParams.a = cuVar;
            if (bbVar.e == 1) {
                b(a);
            } else {
                b(a, 0);
            }
            a(a, layoutParams, false);
            if (bbVar.e == 1) {
                q = layoutParams.b ? q(d) : cuVar.b(d);
                e = q + this.b.e(a);
                if (obj2 == null || !layoutParams.b) {
                    c = q;
                } else {
                    FullSpanItem m = m(q);
                    m.b = -1;
                    m.a = f;
                    this.h.a(m);
                    c = q;
                }
            } else {
                q = layoutParams.b ? p(d) : cuVar.a(d);
                c = q - this.b.e(a);
                if (obj2 != null && layoutParams.b) {
                    FullSpanItem n = n(q);
                    n.b = 1;
                    n.a = f;
                    this.h.a(n);
                }
                e = q;
            }
            if (layoutParams.b && bbVar.d == -1) {
                if (obj2 != null) {
                    this.E = true;
                } else {
                    obj = bbVar.e == 1 ? !l() ? 1 : null : !n() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f2 = this.h.f(f);
                        if (f2 != null) {
                            f2.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a, layoutParams, bbVar);
            if (j() && this.j == 1) {
                q = layoutParams.b ? this.c.d() : this.c.d() - (((this.i - 1) - cuVar.e) * this.k);
                e2 = q - this.c.e(a);
                f = q;
            } else {
                q = layoutParams.b ? this.c.c() : (cuVar.e * this.k) + this.c.c();
                f = q + this.c.e(a);
                e2 = q;
            }
            if (this.j == 1) {
                a(a, e2, c, f, e);
            } else {
                a(a, c, e2, e, f);
            }
            if (layoutParams.b) {
                a(this.l.e, i);
            } else {
                a(cuVar, this.l.e, i);
            }
            a(bzVar, this.l);
            if (this.l.h && a.hasFocusable()) {
                if (layoutParams.b) {
                    this.m.clear();
                } else {
                    this.m.set(cuVar.e, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            a(bzVar, this.l);
        }
        q = this.l.e == -1 ? this.b.c() - p(this.b.c()) : q(this.b.d()) - this.b.d();
        return q > 0 ? Math.min(bbVar.b, q) : 0;
    }

    private cu a(bb bbVar) {
        int i;
        int i2;
        cu cuVar = null;
        int i3 = -1;
        if (s(bbVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.i;
            i3 = 1;
        }
        int c;
        int i4;
        cu cuVar2;
        int b;
        cu cuVar3;
        if (bbVar.e == 1) {
            c = this.b.c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                cuVar2 = this.a[i4];
                b = cuVar2.b(c);
                if (b < i) {
                    cuVar3 = cuVar2;
                } else {
                    b = i;
                    cuVar3 = cuVar;
                }
                i4 += i3;
                cuVar = cuVar3;
                i = b;
            }
        } else {
            c = this.b.d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                cuVar2 = this.a[i4];
                b = cuVar2.a(c);
                if (b > i) {
                    cuVar3 = cuVar2;
                } else {
                    b = i;
                    cuVar3 = cuVar;
                }
                i4 += i3;
                cuVar = cuVar3;
                i = b;
            }
        }
        return cuVar;
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.a[i3].a.isEmpty()) {
                a(this.a[i3], i, i2);
            }
        }
    }

    private void a(bz bzVar, int i) {
        while (w() > 0) {
            View h = h(0);
            if (this.b.b(h) <= i && this.b.c(h) <= i) {
                LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (this.a[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.i; i2++) {
                        this.a[i2].h();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.h();
                } else {
                    return;
                }
                a(h, bzVar);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013e  */
    private void a(android.support.v7.widget.bz r9, android.support.v7.widget.RecyclerView.State r10, boolean r11) {
        /*
        r8 = this;
        r7 = -1;
        r2 = 1;
        r1 = 0;
        r3 = r8.D;
        r0 = r8.A;
        if (r0 != 0) goto L_0x000d;
    L_0x0009:
        r0 = r8.f;
        if (r0 == r7) goto L_0x001a;
    L_0x000d:
        r0 = r10.e();
        if (r0 != 0) goto L_0x001a;
    L_0x0013:
        r8.c(r9);
        r3.a();
    L_0x0019:
        return;
    L_0x001a:
        r0 = r3.e;
        if (r0 == 0) goto L_0x0026;
    L_0x001e:
        r0 = r8.f;
        if (r0 != r7) goto L_0x0026;
    L_0x0022:
        r0 = r8.A;
        if (r0 == 0) goto L_0x0087;
    L_0x0026:
        r0 = r2;
    L_0x0027:
        if (r0 == 0) goto L_0x0038;
    L_0x0029:
        r3.a();
        r4 = r8.A;
        if (r4 == 0) goto L_0x0089;
    L_0x0030:
        r8.a(r3);
    L_0x0033:
        r8.a(r10, r3);
        r3.e = r2;
    L_0x0038:
        r4 = r8.A;
        if (r4 != 0) goto L_0x0055;
    L_0x003c:
        r4 = r8.f;
        if (r4 != r7) goto L_0x0055;
    L_0x0040:
        r4 = r3.c;
        r5 = r8.o;
        if (r4 != r5) goto L_0x004e;
    L_0x0046:
        r4 = r8.j();
        r5 = r8.z;
        if (r4 == r5) goto L_0x0055;
    L_0x004e:
        r4 = r8.h;
        r4.a();
        r3.d = r2;
    L_0x0055:
        r4 = r8.w();
        if (r4 <= 0) goto L_0x00b3;
    L_0x005b:
        r4 = r8.A;
        if (r4 == 0) goto L_0x0065;
    L_0x005f:
        r4 = r8.A;
        r4 = r4.c;
        if (r4 >= r2) goto L_0x00b3;
    L_0x0065:
        r4 = r3.d;
        if (r4 == 0) goto L_0x0091;
    L_0x0069:
        r0 = r1;
    L_0x006a:
        r4 = r8.i;
        if (r0 >= r4) goto L_0x00b3;
    L_0x006e:
        r4 = r8.a;
        r4 = r4[r0];
        r4.e();
        r4 = r3.b;
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 == r5) goto L_0x0084;
    L_0x007b:
        r4 = r8.a;
        r4 = r4[r0];
        r5 = r3.b;
        r4.c(r5);
    L_0x0084:
        r0 = r0 + 1;
        goto L_0x006a;
    L_0x0087:
        r0 = r1;
        goto L_0x0027;
    L_0x0089:
        r8.N();
        r4 = r8.e;
        r3.c = r4;
        goto L_0x0033;
    L_0x0091:
        if (r0 != 0) goto L_0x0099;
    L_0x0093:
        r0 = r8.D;
        r0 = r0.f;
        if (r0 != 0) goto L_0x0148;
    L_0x0099:
        r0 = r1;
    L_0x009a:
        r4 = r8.i;
        if (r0 >= r4) goto L_0x00ac;
    L_0x009e:
        r4 = r8.a;
        r4 = r4[r0];
        r5 = r8.e;
        r6 = r3.b;
        r4.a(r5, r6);
        r0 = r0 + 1;
        goto L_0x009a;
    L_0x00ac:
        r0 = r8.D;
        r4 = r8.a;
        r0.a(r4);
    L_0x00b3:
        r8.a(r9);
        r0 = r8.l;
        r0.a = r1;
        r8.E = r1;
        r0 = r8.c;
        r0 = r0.f();
        r8.e(r0);
        r0 = r3.a;
        r8.b(r0, r10);
        r0 = r3.c;
        if (r0 == 0) goto L_0x0160;
    L_0x00ce:
        r8.l(r7);
        r0 = r8.l;
        r8.a(r9, r0, r10);
        r8.l(r2);
        r0 = r8.l;
        r4 = r3.a;
        r5 = r8.l;
        r5 = r5.d;
        r4 = r4 + r5;
        r0.c = r4;
        r0 = r8.l;
        r8.a(r9, r0, r10);
    L_0x00e9:
        r8.O();
        r0 = r8.w();
        if (r0 <= 0) goto L_0x00fc;
    L_0x00f2:
        r0 = r8.e;
        if (r0 == 0) goto L_0x017d;
    L_0x00f6:
        r8.b(r9, r10, r2);
        r8.c(r9, r10, r1);
    L_0x00fc:
        if (r11 == 0) goto L_0x0187;
    L_0x00fe:
        r0 = r10.a();
        if (r0 != 0) goto L_0x0187;
    L_0x0104:
        r0 = r8.n;
        if (r0 == 0) goto L_0x0185;
    L_0x0108:
        r0 = r8.w();
        if (r0 <= 0) goto L_0x0185;
    L_0x010e:
        r0 = r8.E;
        if (r0 != 0) goto L_0x0118;
    L_0x0112:
        r0 = r8.h();
        if (r0 == 0) goto L_0x0185;
    L_0x0118:
        r0 = r2;
    L_0x0119:
        if (r0 == 0) goto L_0x0187;
    L_0x011b:
        r0 = r8.H;
        r8.a(r0);
        r0 = r8.g();
        if (r0 == 0) goto L_0x0187;
    L_0x0126:
        r0 = r2;
    L_0x0127:
        r2 = r10.a();
        if (r2 == 0) goto L_0x0132;
    L_0x012d:
        r2 = r8.D;
        r2.a();
    L_0x0132:
        r2 = r3.c;
        r8.o = r2;
        r2 = r8.j();
        r8.z = r2;
        if (r0 == 0) goto L_0x0019;
    L_0x013e:
        r0 = r8.D;
        r0.a();
        r8.a(r9, r10, r1);
        goto L_0x0019;
    L_0x0148:
        r0 = r1;
    L_0x0149:
        r4 = r8.i;
        if (r0 >= r4) goto L_0x00b3;
    L_0x014d:
        r4 = r8.a;
        r4 = r4[r0];
        r4.e();
        r5 = r8.D;
        r5 = r5.f;
        r5 = r5[r0];
        r4.c(r5);
        r0 = r0 + 1;
        goto L_0x0149;
    L_0x0160:
        r8.l(r2);
        r0 = r8.l;
        r8.a(r9, r0, r10);
        r8.l(r7);
        r0 = r8.l;
        r4 = r3.a;
        r5 = r8.l;
        r5 = r5.d;
        r4 = r4 + r5;
        r0.c = r4;
        r0 = r8.l;
        r8.a(r9, r0, r10);
        goto L_0x00e9;
    L_0x017d:
        r8.c(r9, r10, r2);
        r8.b(r9, r10, r1);
        goto L_0x00fc;
    L_0x0185:
        r0 = r1;
        goto L_0x0119;
    L_0x0187:
        r0 = r1;
        goto L_0x0127;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.bz, android.support.v7.widget.RecyclerView$State, boolean):void");
    }

    private void a(bz bzVar, bb bbVar) {
        if (bbVar.a && !bbVar.i) {
            int o;
            if (bbVar.b == 0) {
                if (bbVar.e == -1) {
                    b(bzVar, bbVar.g);
                } else {
                    a(bzVar, bbVar.f);
                }
            } else if (bbVar.e == -1) {
                o = bbVar.f - o(bbVar.f);
                b(bzVar, o < 0 ? bbVar.g : bbVar.g - Math.min(o, bbVar.b));
            } else {
                o = r(bbVar.g) - bbVar.g;
                a(bzVar, o < 0 ? bbVar.f : Math.min(o, bbVar.b) + bbVar.f);
            }
        }
    }

    private void a(ct ctVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.a[i].e();
                    int i2 = this.A.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.A.i ? i2 + this.b.d() : i2 + this.b.c();
                    }
                    this.a[i].c(i2);
                }
            } else {
                this.A.a();
                this.A.a = this.A.b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        N();
        if (this.A.a != -1) {
            this.f = this.A.a;
            ctVar.c = this.A.i;
        } else {
            ctVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    private void a(cu cuVar, int i, int i2) {
        int i3 = cuVar.i();
        if (i == -1) {
            if (i3 + cuVar.b() <= i2) {
                this.m.set(cuVar.e, false);
            }
        } else if (cuVar.d() - i3 >= i2) {
            this.m.set(cuVar.e, false);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        b(view, this.C);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b = b(i, layoutParams.leftMargin + this.C.left, layoutParams.rightMargin + this.C.right);
        int b2 = b(i2, layoutParams.topMargin + this.C.top, layoutParams.bottomMargin + this.C.bottom);
        if (z ? a(view, b, b2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams) : b(view, b, b2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
            view.measure(b, b2);
        }
    }

    private void a(View view, LayoutParams layoutParams, bb bbVar) {
        if (bbVar.e == 1) {
            if (layoutParams.b) {
                p(view);
            } else {
                layoutParams.a.b(view);
            }
        } else if (layoutParams.b) {
            q(view);
        } else {
            layoutParams.a.a(view);
        }
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.b) {
            if (this.j == 1) {
                a(view, this.B, LayoutManager.a(A(), y(), C() + E(), layoutParams.height, true), z);
            } else {
                a(view, LayoutManager.a(z(), x(), B() + D(), layoutParams.width, true), this.B, z);
            }
        } else if (this.j == 1) {
            a(view, LayoutManager.a(this.k, x(), 0, layoutParams.width, false), LayoutManager.a(A(), y(), C() + E(), layoutParams.height, true), z);
        } else {
            a(view, LayoutManager.a(z(), x(), B() + D(), layoutParams.width, true), LayoutManager.a(this.k, y(), 0, layoutParams.height, false), z);
        }
    }

    private boolean a(cu cuVar) {
        boolean z = true;
        if (this.e) {
            if (cuVar.d() < this.b.d()) {
                return !cuVar.c((View) cuVar.a.get(cuVar.a.size() + -1)).b;
            }
        } else if (cuVar.b() > this.b.c()) {
            if (cuVar.c((View) cuVar.a.get(0)).b) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int b(State state) {
        boolean z = true;
        if (w() == 0) {
            return 0;
        }
        bn bnVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return ck.a(state, bnVar, b, c(z), this, this.F, this.e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    private void b(int r7, android.support.v7.widget.RecyclerView.State r8) {
        /*
        r6 = this;
        r3 = 1;
        r1 = 0;
        r0 = r6.l;
        r0.b = r1;
        r0 = r6.l;
        r0.c = r7;
        r0 = r6.t();
        if (r0 == 0) goto L_0x007c;
    L_0x0010:
        r0 = r8.c();
        r2 = -1;
        if (r0 == r2) goto L_0x007c;
    L_0x0017:
        r2 = r6.e;
        if (r0 >= r7) goto L_0x0060;
    L_0x001b:
        r0 = r3;
    L_0x001c:
        if (r2 != r0) goto L_0x0062;
    L_0x001e:
        r0 = r6.b;
        r0 = r0.f();
        r2 = r1;
    L_0x0025:
        r4 = r6.s();
        if (r4 == 0) goto L_0x006b;
    L_0x002b:
        r4 = r6.l;
        r5 = r6.b;
        r5 = r5.c();
        r2 = r5 - r2;
        r4.f = r2;
        r2 = r6.l;
        r4 = r6.b;
        r4 = r4.d();
        r0 = r0 + r4;
        r2.g = r0;
    L_0x0042:
        r0 = r6.l;
        r0.h = r1;
        r0 = r6.l;
        r0.a = r3;
        r0 = r6.l;
        r2 = r6.b;
        r2 = r2.h();
        if (r2 != 0) goto L_0x005d;
    L_0x0054:
        r2 = r6.b;
        r2 = r2.e();
        if (r2 != 0) goto L_0x005d;
    L_0x005c:
        r1 = r3;
    L_0x005d:
        r0.i = r1;
        return;
    L_0x0060:
        r0 = r1;
        goto L_0x001c;
    L_0x0062:
        r0 = r6.b;
        r0 = r0.f();
        r2 = r0;
        r0 = r1;
        goto L_0x0025;
    L_0x006b:
        r4 = r6.l;
        r5 = r6.b;
        r5 = r5.e();
        r0 = r0 + r5;
        r4.g = r0;
        r0 = r6.l;
        r2 = -r2;
        r0.f = r2;
        goto L_0x0042;
    L_0x007c:
        r0 = r1;
        r2 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, android.support.v7.widget.RecyclerView$State):void");
    }

    private void b(bz bzVar, int i) {
        int w = w() - 1;
        while (w >= 0) {
            View h = h(w);
            if (this.b.a(h) >= i && this.b.d(h) >= i) {
                LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
                if (layoutParams.b) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (this.a[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.i; i2++) {
                        this.a[i2].g();
                    }
                } else if (layoutParams.a.a.size() != 1) {
                    layoutParams.a.g();
                } else {
                    return;
                }
                a(h, bzVar);
                w--;
            } else {
                return;
            }
        }
    }

    private void b(bz bzVar, State state, boolean z) {
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.b.d() - q;
            if (q > 0) {
                q -= -c(-q, bzVar, state);
                if (z && q > 0) {
                    this.b.a(q);
                }
            }
        }
    }

    private void c(int i, int i2, int i3) {
        int i4;
        int i5;
        int o = this.e ? o() : L();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.h.b(i5);
        switch (i3) {
            case 1:
                this.h.b(i, i2);
                break;
            case 2:
                this.h.a(i, i2);
                break;
            case 8:
                this.h.a(i, 1);
                this.h.b(i2, 1);
                break;
        }
        if (i4 > o) {
            if (i5 <= (this.e ? L() : o())) {
                p();
            }
        }
    }

    private void c(bz bzVar, State state, boolean z) {
        int p = p((int) MoPubClientPositioning.NO_REPEAT);
        if (p != MoPubClientPositioning.NO_REPEAT) {
            p -= this.b.c();
            if (p > 0) {
                p -= c(p, bzVar, state);
                if (z && p > 0) {
                    this.b.a(-p);
                }
            }
        }
    }

    private boolean c(State state, ct ctVar) {
        ctVar.a = this.o ? v(state.e()) : u(state.e());
        ctVar.b = Integer.MIN_VALUE;
        return true;
    }

    private int i(State state) {
        boolean z = true;
        if (w() == 0) {
            return 0;
        }
        bn bnVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return ck.a(state, bnVar, b, c(z), this, this.F);
    }

    private int j(State state) {
        boolean z = true;
        if (w() == 0) {
            return 0;
        }
        bn bnVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return ck.b(state, bnVar, b, c(z), this, this.F);
    }

    private void l(int i) {
        int i2 = 1;
        this.l.e = i;
        bb bbVar = this.l;
        if (this.e != (i == -1)) {
            i2 = -1;
        }
        bbVar.d = i2;
    }

    private FullSpanItem m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = i - this.a[i2].b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem n(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = this.a[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private int o(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int p(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].b(view);
        }
    }

    private int q(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].a(view);
        }
    }

    private int r(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean s(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        } else {
            return ((i == -1) == this.e) == j();
        }
    }

    private int t(int i) {
        int i2 = -1;
        if (w() == 0) {
            return this.e ? 1 : -1;
        } else {
            if ((i < L()) == this.e) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int u(int i) {
        int w = w();
        for (int i2 = 0; i2 < w; i2++) {
            int d = d(h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int v(int i) {
        for (int w = w() - 1; w >= 0; w--) {
            int d = d(h(w));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int w(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.j == 1 || !j()) ? -1 : 1;
            case 2:
                return this.j == 1 ? 1 : !j() ? 1 : -1;
            case 17:
                return this.j != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.j != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.j != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.j == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int L() {
        return w() == 0 ? 0 : d(h(0));
    }

    public int a(int i, bz bzVar, State state) {
        return c(i, bzVar, state);
    }

    public int a(bz bzVar, State state) {
        return this.j == 0 ? this.i : super.a(bzVar, state);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a() {
        return this.j == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Nullable
    public View a(View view, int i, bz bzVar, State state) {
        int i2 = 0;
        if (w() == 0) {
            return null;
        }
        View e = e(view);
        if (e == null) {
            return null;
        }
        N();
        int w = w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        int i3;
        View c;
        LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
        boolean z = layoutParams.b;
        cu cuVar = layoutParams.a;
        int o = w == 1 ? o() : L();
        b(o, state);
        l(w);
        this.l.c = this.l.d + o;
        this.l.b = (int) (0.33333334f * ((float) this.b.f()));
        this.l.h = true;
        this.l.a = false;
        a(bzVar, this.l, state);
        this.o = this.e;
        if (!z) {
            a = cuVar.a(o, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (s(w)) {
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                a = this.a[i4].a(o, w);
                if (a != null && a != e) {
                    return a;
                }
            }
        } else {
            for (i3 = 0; i3 < this.i; i3++) {
                View a2 = this.a[i3].a(o, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        }
        boolean z2 = (!this.d) == (w == -1);
        if (!z) {
            c = c(z2 ? cuVar.j() : cuVar.k());
            if (!(c == null || c == e)) {
                return c;
            }
        }
        if (s(w)) {
            for (i3 = this.i - 1; i3 >= 0; i3--) {
                if (i3 != cuVar.e) {
                    c = c(z2 ? this.a[i3].j() : this.a[i3].k());
                    if (!(c == null || c == e)) {
                        return c;
                    }
                }
            }
        } else {
            while (i2 < this.i) {
                c = c(z2 ? this.a[i2].j() : this.a[i2].k());
                if (c != null && c != e) {
                    return c;
                }
                i2++;
            }
        }
        return null;
    }

    public void a(int i) {
        a(null);
        if (i != this.i) {
            i();
            this.i = i;
            this.m = new BitSet(this.i);
            this.a = new cu[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.a[i2] = new cu(this, i2);
            }
            p();
        }
    }

    @RestrictTo({Scope.LIBRARY})
    public void a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3 = 0;
        if (this.j != 0) {
            i = i2;
        }
        if (w() != 0 && i != 0) {
            a(i, state);
            if (this.G == null || this.G.length < this.i) {
                this.G = new int[this.i];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.i; i5++) {
                int a = this.l.d == -1 ? this.l.f - this.a[i5].a(this.l.f) : this.a[i5].b(this.l.g) - this.l.g;
                if (a >= 0) {
                    this.G[i4] = a;
                    i4++;
                }
            }
            Arrays.sort(this.G, 0, i4);
            while (i3 < i4 && this.l.a(state)) {
                layoutPrefetchRegistry.addPosition(this.l.c, this.G[i3]);
                bb bbVar = this.l;
                bbVar.c += this.l.d;
                i3++;
            }
        }
    }

    void a(int i, State state) {
        int o;
        int i2;
        if (i > 0) {
            o = o();
            i2 = 1;
        } else {
            i2 = -1;
            o = L();
        }
        this.l.a = true;
        b(o, state);
        l(i2);
        this.l.c = this.l.d + o;
        this.l.b = Math.abs(i);
    }

    public void a(Rect rect, int i, int i2) {
        int D = D() + B();
        int C = C() + E();
        if (this.j == 1) {
            C = LayoutManager.a(i2, C + rect.height(), H());
            D = LayoutManager.a(i, D + (this.k * this.i), G());
        } else {
            D = LayoutManager.a(i, D + rect.width(), G());
            C = LayoutManager.a(i2, C + (this.k * this.i), H());
        }
        g(D, C);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.A = (SavedState) parcelable;
            p();
        }
    }

    public void a(State state) {
        super.a(state);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    void a(State state, ct ctVar) {
        if (!b(state, ctVar) && !c(state, ctVar)) {
            ctVar.b();
            ctVar.a = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.h.a();
        p();
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    public void a(RecyclerView recyclerView, State state, int i) {
        SmoothScroller bfVar = new bf(recyclerView.getContext());
        bfVar.d(i);
        a(bfVar);
    }

    public void a(RecyclerView recyclerView, bz bzVar) {
        super.a(recyclerView, bzVar);
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.a[i].e();
        }
        recyclerView.requestLayout();
    }

    public void a(bz bzVar, State state, View view, b bVar) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.j == 0) {
                bVar.b(e.a(layoutParams2.b(), layoutParams2.b ? this.i : 1, -1, -1, layoutParams2.b, false));
                return;
            } else {
                bVar.b(e.a(-1, -1, layoutParams2.b(), layoutParams2.b ? this.i : 1, layoutParams2.b, false));
                return;
            }
        }
        super.a(view, bVar);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (w() > 0) {
            View b = b(false);
            View c = c(false);
            if (b != null && c != null) {
                int d = d(b);
                int d2 = d(c);
                if (d < d2) {
                    accessibilityEvent.setFromIndex(d);
                    accessibilityEvent.setToIndex(d2);
                    return;
                }
                accessibilityEvent.setFromIndex(d2);
                accessibilityEvent.setToIndex(d);
            }
        }
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (!(this.A == null || this.A.h == z)) {
            this.A.h = z;
        }
        this.d = z;
        p();
    }

    public boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int b(int i, bz bzVar, State state) {
        return c(i, bzVar, state);
    }

    public int b(bz bzVar, State state) {
        return this.j == 1 ? this.i : super.b(bzVar, state);
    }

    View b(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        int w = w();
        View view = null;
        for (int i = 0; i < w; i++) {
            View h = h(i);
            int a = this.b.a(h);
            if (this.b.b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.j) {
                this.j = i;
                bn bnVar = this.b;
                this.b = this.c;
                this.c = bnVar;
                p();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    public boolean b() {
        return this.A == null;
    }

    boolean b(State state, ct ctVar) {
        boolean z = false;
        if (state.a() || this.f == -1) {
            return false;
        }
        if (this.f < 0 || this.f >= state.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        } else if (this.A == null || this.A.a == -1 || this.A.c < 1) {
            View c = c(this.f);
            if (c != null) {
                ctVar.a = this.e ? o() : L();
                if (this.g != Integer.MIN_VALUE) {
                    if (ctVar.c) {
                        ctVar.b = (this.b.d() - this.g) - this.b.b(c);
                        return true;
                    }
                    ctVar.b = (this.b.c() + this.g) - this.b.a(c);
                    return true;
                } else if (this.b.e(c) > this.b.f()) {
                    ctVar.b = ctVar.c ? this.b.d() : this.b.c();
                    return true;
                } else {
                    int a = this.b.a(c) - this.b.c();
                    if (a < 0) {
                        ctVar.b = -a;
                        return true;
                    }
                    a = this.b.d() - this.b.b(c);
                    if (a < 0) {
                        ctVar.b = a;
                        return true;
                    }
                    ctVar.b = Integer.MIN_VALUE;
                    return true;
                }
            }
            ctVar.a = this.f;
            if (this.g == Integer.MIN_VALUE) {
                if (t(ctVar.a) == 1) {
                    z = true;
                }
                ctVar.c = z;
                ctVar.b();
            } else {
                ctVar.a(this.g);
            }
            ctVar.d = true;
            return true;
        } else {
            ctVar.b = Integer.MIN_VALUE;
            ctVar.a = this.f;
            return true;
        }
    }

    int c(int i, bz bzVar, State state) {
        if (w() == 0 || i == 0) {
            return 0;
        }
        a(i, state);
        int a = a(bzVar, this.l, state);
        if (this.l.b >= a) {
            i = i < 0 ? -a : a;
        }
        this.b.a(-i);
        this.o = this.e;
        this.l.b = 0;
        a(bzVar, this.l);
        return i;
    }

    public int c(State state) {
        return b(state);
    }

    View c(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        View view = null;
        for (int w = w() - 1; w >= 0; w--) {
            View h = h(w);
            int a = this.b.a(h);
            int b = this.b.b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void c(bz bzVar, State state) {
        a(bzVar, state, true);
    }

    public boolean c() {
        return this.n != 0;
    }

    public PointF computeScrollVectorForPosition(int i) {
        int t = t(i);
        PointF pointF = new PointF();
        if (t == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = (float) t;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) t;
        return pointF;
    }

    public int d(State state) {
        return b(state);
    }

    public Parcelable d() {
        if (this.A != null) {
            return new SavedState(this.A);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.d;
        savedState.i = this.o;
        savedState.j = this.z;
        if (this.h == null || this.h.a == null) {
            savedState.e = 0;
        } else {
            savedState.f = this.h.a;
            savedState.e = savedState.f.length;
            savedState.g = this.h.b;
        }
        if (w() > 0) {
            savedState.a = this.o ? o() : L();
            savedState.b = k();
            savedState.c = this.i;
            savedState.d = new int[this.i];
            for (int i = 0; i < this.i; i++) {
                int b;
                if (this.o) {
                    b = this.a[i].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.b.d();
                    }
                } else {
                    b = this.a[i].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.b.c();
                    }
                }
                savedState.d[i] = b;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    public void d(int i) {
        if (!(this.A == null || this.A.a == i)) {
            this.A.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        p();
    }

    public int e(State state) {
        return i(state);
    }

    void e(int i) {
        this.k = i / this.i;
        this.B = MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    public boolean e() {
        return this.j == 0;
    }

    public int f(State state) {
        return i(state);
    }

    public boolean f() {
        return this.j == 1;
    }

    public int g(State state) {
        return j(state);
    }

    boolean g() {
        if (w() == 0 || this.n == 0 || !r()) {
            return false;
        }
        int o;
        int L;
        if (this.e) {
            o = o();
            L = L();
        } else {
            o = L();
            L = o();
        }
        if (o == 0 && h() != null) {
            this.h.a();
            J();
            p();
            return true;
        } else if (!this.E) {
            return false;
        } else {
            int i = this.e ? -1 : 1;
            FullSpanItem a = this.h.a(o, L + 1, i, true);
            if (a == null) {
                this.E = false;
                this.h.a(L + 1);
                return false;
            }
            FullSpanItem a2 = this.h.a(o, a.a, i * -1, true);
            if (a2 == null) {
                this.h.a(a.a);
            } else {
                this.h.a(a2.a + 1);
            }
            J();
            p();
            return true;
        }
    }

    public int h(State state) {
        return j(state);
    }

    View h() {
        int i;
        int w = w() - 1;
        BitSet bitSet = new BitSet(this.i);
        bitSet.set(0, this.i, true);
        boolean z = (this.j == 1 && j()) ? true : true;
        if (this.e) {
            i = -1;
        } else {
            i = w + 1;
            w = 0;
        }
        int i2 = w < i ? 1 : -1;
        int i3 = w;
        while (i3 != i) {
            View h = h(i3);
            LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
            if (bitSet.get(layoutParams.a.e)) {
                if (a(layoutParams.a)) {
                    return h;
                }
                bitSet.clear(layoutParams.a.e);
            }
            if (!(layoutParams.b || i3 + i2 == i)) {
                boolean z2;
                View h2 = h(i3 + i2);
                int b;
                if (this.e) {
                    w = this.b.b(h);
                    b = this.b.b(h2);
                    if (w < b) {
                        return h;
                    }
                    if (w == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    w = this.b.a(h);
                    b = this.b.a(h2);
                    if (w > b) {
                        return h;
                    }
                    if (w == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((layoutParams.a.e - ((LayoutParams) h2.getLayoutParams()).a.e < 0) != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public void i() {
        this.h.a();
        p();
    }

    public void i(int i) {
        super.i(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    boolean j() {
        return u() == 1;
    }

    int k() {
        View c = this.e ? c(true) : b(true);
        return c == null ? -1 : d(c);
    }

    public void k(int i) {
        if (i == 0) {
            g();
        }
    }

    boolean l() {
        int b = this.a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int a = this.a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    int o() {
        int w = w();
        return w == 0 ? 0 : d(h(w - 1));
    }
}
