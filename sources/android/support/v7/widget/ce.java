package android.support.v7.widget;

import android.support.annotation.VisibleForTesting;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;
import com.appnext.base.b.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ce {
    private static final List<Object> n = Collections.EMPTY_LIST;
    WeakReference<RecyclerView> a;
    int b = -1;
    int c = -1;
    long d = -1;
    int e = -1;
    int f = -1;
    ce g = null;
    ce h = null;
    List<Object> i = null;
    public final View itemView;
    List<Object> j = null;
    @VisibleForTesting
    int k = -1;
    RecyclerView l;
    private int m;
    private int o = 0;
    private bz p = null;
    private boolean q = false;
    private int r = 0;

    public ce(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = view;
    }

    private void a(RecyclerView recyclerView) {
        if (this.k != -1) {
            this.r = this.k;
        } else {
            this.r = ViewCompat.e(this.itemView);
        }
        recyclerView.a(this, 4);
    }

    private void b(RecyclerView recyclerView) {
        recyclerView.a(this, this.r);
        this.r = 0;
    }

    private void s() {
        if (this.i == null) {
            this.i = new ArrayList();
            this.j = Collections.unmodifiableList(this.i);
        }
    }

    private boolean t() {
        return (this.m & 16) != 0;
    }

    private boolean u() {
        return (this.m & 16) == 0 && ViewCompat.c(this.itemView);
    }

    void a() {
        this.c = -1;
        this.f = -1;
    }

    void a(int i, int i2) {
        this.m = (this.m & (i2 ^ -1)) | (i & i2);
    }

    void a(int i, int i2, boolean z) {
        b(8);
        a(i2, z);
        this.b = i;
    }

    void a(int i, boolean z) {
        if (this.c == -1) {
            this.c = this.b;
        }
        if (this.f == -1) {
            this.f = this.b;
        }
        if (z) {
            this.f += i;
        }
        this.b += i;
        if (this.itemView.getLayoutParams() != null) {
            ((LayoutParams) this.itemView.getLayoutParams()).e = true;
        }
    }

    void a(bz bzVar, boolean z) {
        this.p = bzVar;
        this.q = z;
    }

    void a(Object obj) {
        if (obj == null) {
            b((int) c.jk);
        } else if ((this.m & c.jk) == 0) {
            s();
            this.i.add(obj);
        }
    }

    boolean a(int i) {
        return (this.m & i) != 0;
    }

    void b() {
        if (this.c == -1) {
            this.c = this.b;
        }
    }

    void b(int i) {
        this.m |= i;
    }

    boolean c() {
        return (this.m & 128) != 0;
    }

    boolean d() {
        return this.p != null;
    }

    void e() {
        this.p.c(this);
    }

    boolean f() {
        return (this.m & 32) != 0;
    }

    void g() {
        this.m &= -33;
    }

    public final int getAdapterPosition() {
        return this.l == null ? -1 : this.l.d(this);
    }

    public final long getItemId() {
        return this.d;
    }

    public final int getItemViewType() {
        return this.e;
    }

    public final int getLayoutPosition() {
        return this.f == -1 ? this.b : this.f;
    }

    public final int getOldPosition() {
        return this.c;
    }

    @Deprecated
    public final int getPosition() {
        return this.f == -1 ? this.b : this.f;
    }

    void h() {
        this.m &= -257;
    }

    boolean i() {
        return (this.m & 4) != 0;
    }

    public final boolean isRecyclable() {
        return (this.m & 16) == 0 && !ViewCompat.c(this.itemView);
    }

    boolean j() {
        return (this.m & 2) != 0;
    }

    boolean k() {
        return (this.m & 1) != 0;
    }

    boolean l() {
        return (this.m & 8) != 0;
    }

    boolean m() {
        return (this.m & 256) != 0;
    }

    boolean n() {
        return (this.m & 512) != 0 || i();
    }

    void o() {
        if (this.i != null) {
            this.i.clear();
        }
        this.m &= -1025;
    }

    List<Object> p() {
        return (this.m & c.jk) == 0 ? (this.i == null || this.i.size() == 0) ? n : this.j : n;
    }

    void q() {
        this.m = 0;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = -1;
        this.o = 0;
        this.g = null;
        this.h = null;
        o();
        this.r = 0;
        this.k = -1;
        RecyclerView.c(this);
    }

    boolean r() {
        return (this.m & 2) != 0;
    }

    public final void setIsRecyclable(boolean z) {
        this.o = z ? this.o - 1 : this.o + 1;
        if (this.o < 0) {
            this.o = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.o == 1) {
            this.m |= 16;
        } else if (z && this.o == 0) {
            this.m &= -17;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
        if (d()) {
            stringBuilder.append(" scrap ").append(this.q ? "[changeScrap]" : "[attachedScrap]");
        }
        if (i()) {
            stringBuilder.append(" invalid");
        }
        if (!k()) {
            stringBuilder.append(" unbound");
        }
        if (j()) {
            stringBuilder.append(" update");
        }
        if (l()) {
            stringBuilder.append(" removed");
        }
        if (c()) {
            stringBuilder.append(" ignored");
        }
        if (m()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!isRecyclable()) {
            stringBuilder.append(" not recyclable(" + this.o + ")");
        }
        if (n()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
