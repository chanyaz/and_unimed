package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bz {
    final ArrayList<ce> a = new ArrayList();
    ArrayList<ce> b = null;
    final ArrayList<ce> c = new ArrayList();
    int d = 2;
    bx e;
    final /* synthetic */ RecyclerView f;
    private final List<ce> g = Collections.unmodifiableList(this.a);
    private int h = 2;
    private cc i;

    public bz(RecyclerView recyclerView) {
        this.f = recyclerView;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    private boolean a(ce ceVar, int i, int i2, long j) {
        ceVar.l = this.f;
        int itemViewType = ceVar.getItemViewType();
        long nanoTime = this.f.getNanoTime();
        if (j != Long.MAX_VALUE && !this.e.b(itemViewType, nanoTime, j)) {
            return false;
        }
        this.f.l.bindViewHolder(ceVar, i);
        this.e.b(ceVar.getItemViewType(), this.f.getNanoTime() - nanoTime);
        e(ceVar);
        if (this.f.C.a()) {
            ceVar.f = i2;
        }
        return true;
    }

    private void e(ce ceVar) {
        if (this.f.n()) {
            View view = ceVar.itemView;
            if (ViewCompat.e(view) == 0) {
                ViewCompat.b(view, 1);
            }
            if (!ViewCompat.b(view)) {
                ceVar.b(16384);
                ViewCompat.a(view, this.f.G.c());
            }
        }
    }

    private void f(ce ceVar) {
        if (ceVar.itemView instanceof ViewGroup) {
            a((ViewGroup) ceVar.itemView, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    @android.support.annotation.Nullable
    android.support.v7.widget.ce a(int r12, boolean r13, long r14) {
        /*
        r11 = this;
        r10 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r8 = 0;
        r6 = 1;
        r7 = 0;
        if (r12 < 0) goto L_0x0011;
    L_0x0007:
        r0 = r11.f;
        r0 = r0.C;
        r0 = r0.e();
        if (r12 < r0) goto L_0x0050;
    L_0x0011:
        r0 = new java.lang.IndexOutOfBoundsException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid item position ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = "(";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = "). Item count:";
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.C;
        r2 = r2.e();
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.a();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r11.f;
        r0 = r0.C;
        r0 = r0.a();
        if (r0 == 0) goto L_0x0283;
    L_0x005a:
        r1 = r11.f(r12);
        if (r1 == 0) goto L_0x00e6;
    L_0x0060:
        r0 = r6;
    L_0x0061:
        r2 = r0;
        r0 = r1;
    L_0x0063:
        if (r0 != 0) goto L_0x008b;
    L_0x0065:
        r0 = r11.b(r12, r13);
        if (r0 == 0) goto L_0x008b;
    L_0x006b:
        r1 = r11.a(r0);
        if (r1 != 0) goto L_0x00f3;
    L_0x0071:
        if (r13 != 0) goto L_0x008a;
    L_0x0073:
        r1 = 4;
        r0.b(r1);
        r1 = r0.d();
        if (r1 == 0) goto L_0x00e9;
    L_0x007d:
        r1 = r11.f;
        r3 = r0.itemView;
        r1.removeDetachedView(r3, r7);
        r0.e();
    L_0x0087:
        r11.b(r0);
    L_0x008a:
        r0 = r8;
    L_0x008b:
        if (r0 != 0) goto L_0x027f;
    L_0x008d:
        r1 = r11.f;
        r1 = r1.e;
        r3 = r1.b(r12);
        if (r3 < 0) goto L_0x00a1;
    L_0x0097:
        r1 = r11.f;
        r1 = r1.l;
        r1 = r1.getItemCount();
        if (r3 < r1) goto L_0x00f5;
    L_0x00a1:
        r0 = new java.lang.IndexOutOfBoundsException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Inconsistency detected. Invalid item position ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = "(offset:";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ").";
        r1 = r1.append(r2);
        r2 = "state:";
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.C;
        r2 = r2.e();
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.a();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e6:
        r0 = r7;
        goto L_0x0061;
    L_0x00e9:
        r1 = r0.f();
        if (r1 == 0) goto L_0x0087;
    L_0x00ef:
        r0.g();
        goto L_0x0087;
    L_0x00f3:
        r2 = r6;
        goto L_0x008b;
    L_0x00f5:
        r1 = r11.f;
        r1 = r1.l;
        r1 = r1.getItemViewType(r3);
        r4 = r11.f;
        r4 = r4.l;
        r4 = r4.hasStableIds();
        if (r4 == 0) goto L_0x027c;
    L_0x0107:
        r0 = r11.f;
        r0 = r0.l;
        r4 = r0.getItemId(r3);
        r0 = r11.a(r4, r1, r13);
        if (r0 == 0) goto L_0x027c;
    L_0x0115:
        r0.b = r3;
        r9 = r6;
    L_0x0118:
        if (r0 != 0) goto L_0x0172;
    L_0x011a:
        r2 = r11.i;
        if (r2 == 0) goto L_0x0172;
    L_0x011e:
        r2 = r11.i;
        r2 = r2.a(r11, r12, r1);
        if (r2 == 0) goto L_0x0172;
    L_0x0126:
        r0 = r11.f;
        r0 = r0.b(r2);
        if (r0 != 0) goto L_0x014d;
    L_0x012e:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder";
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.a();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014d:
        r2 = r0.c();
        if (r2 == 0) goto L_0x0172;
    L_0x0153:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.";
        r1 = r1.append(r2);
        r2 = r11.f;
        r2 = r2.a();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0172:
        if (r0 != 0) goto L_0x0188;
    L_0x0174:
        r0 = r11.g();
        r0 = r0.a(r1);
        if (r0 == 0) goto L_0x0188;
    L_0x017e:
        r0.q();
        r2 = android.support.v7.widget.RecyclerView.a;
        if (r2 == 0) goto L_0x0188;
    L_0x0185:
        r11.f(r0);
    L_0x0188:
        if (r0 != 0) goto L_0x01d0;
    L_0x018a:
        r0 = r11.f;
        r2 = r0.getNanoTime();
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r0 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x01a4;
    L_0x0199:
        r0 = r11.e;
        r4 = r14;
        r0 = r0.a(r1, r2, r4);
        if (r0 != 0) goto L_0x01a4;
    L_0x01a2:
        r1 = r8;
    L_0x01a3:
        return r1;
    L_0x01a4:
        r0 = r11.f;
        r0 = r0.l;
        r4 = r11.f;
        r0 = r0.createViewHolder(r4, r1);
        r4 = android.support.v7.widget.RecyclerView.L;
        if (r4 == 0) goto L_0x01c3;
    L_0x01b4:
        r4 = r0.itemView;
        r4 = android.support.v7.widget.RecyclerView.l(r4);
        if (r4 == 0) goto L_0x01c3;
    L_0x01bc:
        r5 = new java.lang.ref.WeakReference;
        r5.<init>(r4);
        r0.a = r5;
    L_0x01c3:
        r4 = r11.f;
        r4 = r4.getNanoTime();
        r8 = r11.e;
        r2 = r4 - r2;
        r8.a(r1, r2);
    L_0x01d0:
        r1 = r0;
        r8 = r9;
    L_0x01d2:
        if (r8 == 0) goto L_0x020a;
    L_0x01d4:
        r0 = r11.f;
        r0 = r0.C;
        r0 = r0.a();
        if (r0 != 0) goto L_0x020a;
    L_0x01de:
        r0 = r1.a(r10);
        if (r0 == 0) goto L_0x020a;
    L_0x01e4:
        r1.a(r7, r10);
        r0 = r11.f;
        r0 = r0.C;
        r0 = r0.i;
        if (r0 == 0) goto L_0x020a;
    L_0x01ef:
        r0 = android.support.v7.widget.RecyclerView.ItemAnimator.e(r1);
        r0 = r0 | 4096;
        r2 = r11.f;
        r2 = r2.y;
        r3 = r11.f;
        r3 = r3.C;
        r4 = r1.p();
        r0 = r2.a(r3, r1, r0, r4);
        r2 = r11.f;
        r2.a(r1, r0);
    L_0x020a:
        r0 = r11.f;
        r0 = r0.C;
        r0 = r0.a();
        if (r0 == 0) goto L_0x023c;
    L_0x0214:
        r0 = r1.k();
        if (r0 == 0) goto L_0x023c;
    L_0x021a:
        r1.f = r12;
        r2 = r7;
    L_0x021d:
        r0 = r1.itemView;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x025f;
    L_0x0225:
        r0 = r11.f;
        r0 = r0.generateDefaultLayoutParams();
        r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0;
        r3 = r1.itemView;
        r3.setLayoutParams(r0);
    L_0x0232:
        r0.c = r1;
        if (r8 == 0) goto L_0x0278;
    L_0x0236:
        if (r2 == 0) goto L_0x0278;
    L_0x0238:
        r0.f = r6;
        goto L_0x01a3;
    L_0x023c:
        r0 = r1.k();
        if (r0 == 0) goto L_0x024e;
    L_0x0242:
        r0 = r1.j();
        if (r0 != 0) goto L_0x024e;
    L_0x0248:
        r0 = r1.i();
        if (r0 == 0) goto L_0x027a;
    L_0x024e:
        r0 = r11.f;
        r0 = r0.e;
        r2 = r0.b(r12);
        r0 = r11;
        r3 = r12;
        r4 = r14;
        r0 = r0.a(r1, r2, r3, r4);
        r2 = r0;
        goto L_0x021d;
    L_0x025f:
        r3 = r11.f;
        r3 = r3.checkLayoutParams(r0);
        if (r3 != 0) goto L_0x0275;
    L_0x0267:
        r3 = r11.f;
        r0 = r3.generateLayoutParams(r0);
        r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0;
        r3 = r1.itemView;
        r3.setLayoutParams(r0);
        goto L_0x0232;
    L_0x0275:
        r0 = (android.support.v7.widget.RecyclerView.LayoutParams) r0;
        goto L_0x0232;
    L_0x0278:
        r6 = r7;
        goto L_0x0238;
    L_0x027a:
        r2 = r7;
        goto L_0x021d;
    L_0x027c:
        r9 = r2;
        goto L_0x0118;
    L_0x027f:
        r1 = r0;
        r8 = r2;
        goto L_0x01d2;
    L_0x0283:
        r0 = r8;
        r2 = r7;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bz.a(int, boolean, long):android.support.v7.widget.ce");
    }

    ce a(long j, int i, boolean z) {
        int size;
        ce ceVar;
        for (size = this.a.size() - 1; size >= 0; size--) {
            ceVar = (ce) this.a.get(size);
            if (ceVar.getItemId() == j && !ceVar.f()) {
                if (i == ceVar.getItemViewType()) {
                    ceVar.b(32);
                    if (!ceVar.l() || this.f.C.a()) {
                        return ceVar;
                    }
                    ceVar.a(2, 14);
                    return ceVar;
                } else if (!z) {
                    this.a.remove(size);
                    this.f.removeDetachedView(ceVar.itemView, false);
                    b(ceVar.itemView);
                }
            }
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            ceVar = (ce) this.c.get(size);
            if (ceVar.getItemId() == j) {
                if (i == ceVar.getItemViewType()) {
                    if (z) {
                        return ceVar;
                    }
                    this.c.remove(size);
                    return ceVar;
                } else if (!z) {
                    d(size);
                    return null;
                }
            }
        }
        return null;
    }

    View a(int i, boolean z) {
        return a(i, z, Long.MAX_VALUE).itemView;
    }

    public void a() {
        this.a.clear();
        d();
    }

    public void a(int i) {
        this.h = i;
        b();
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.c.size();
        for (int i6 = 0; i6 < size; i6++) {
            ce ceVar = (ce) this.c.get(i6);
            if (ceVar != null && ceVar.b >= i5 && ceVar.b <= i4) {
                if (ceVar.b == i) {
                    ceVar.a(i2 - i, false);
                } else {
                    ceVar.a(i3, false);
                }
            }
        }
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) this.c.get(size);
            if (ceVar != null) {
                if (ceVar.b >= i3) {
                    ceVar.a(-i2, z);
                } else if (ceVar.b >= i) {
                    ceVar.b(8);
                    d(size);
                }
            }
        }
    }

    void a(bo boVar, bo boVar2, boolean z) {
        a();
        g().a(boVar, boVar2, z);
    }

    void a(bx bxVar) {
        if (this.e != null) {
            this.e.b();
        }
        this.e = bxVar;
        if (bxVar != null) {
            this.e.a(this.f.getAdapter());
        }
    }

    void a(cc ccVar) {
        this.i = ccVar;
    }

    void a(ce ceVar, boolean z) {
        RecyclerView.c(ceVar);
        if (ceVar.a(16384)) {
            ceVar.a(0, 16384);
            ViewCompat.a(ceVar.itemView, null);
        }
        if (z) {
            d(ceVar);
        }
        ceVar.l = null;
        g().a(ceVar);
    }

    public void a(View view) {
        ce e = RecyclerView.e(view);
        if (e.m()) {
            this.f.removeDetachedView(view, false);
        }
        if (e.d()) {
            e.e();
        } else if (e.f()) {
            e.g();
        }
        b(e);
    }

    boolean a(ce ceVar) {
        if (ceVar.l()) {
            return this.f.C.a();
        }
        if (ceVar.b >= 0 && ceVar.b < this.f.l.getItemCount()) {
            return (this.f.C.a() || this.f.l.getItemViewType(ceVar.b) == ceVar.getItemViewType()) ? !this.f.l.hasStableIds() || ceVar.getItemId() == this.f.l.getItemId(ceVar.b) : false;
        } else {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + ceVar + this.f.a());
        }
    }

    public int b(int i) {
        if (i >= 0 && i < this.f.C.e()) {
            return !this.f.C.a() ? i : this.f.e.b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f.C.e() + this.f.a());
        }
    }

    ce b(int i, boolean z) {
        ce ceVar;
        int i2 = 0;
        int size = this.a.size();
        int i3 = 0;
        while (i3 < size) {
            ceVar = (ce) this.a.get(i3);
            if (ceVar.f() || ceVar.getLayoutPosition() != i || ceVar.i() || (!this.f.C.f && ceVar.l())) {
                i3++;
            } else {
                ceVar.b(32);
                return ceVar;
            }
        }
        if (!z) {
            View c = this.f.f.c(i);
            if (c != null) {
                ceVar = RecyclerView.e(c);
                this.f.f.e(c);
                i2 = this.f.f.b(c);
                if (i2 == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ceVar + this.f.a());
                }
                this.f.f.e(i2);
                c(c);
                ceVar.b(8224);
                return ceVar;
            }
        }
        i3 = this.c.size();
        while (i2 < i3) {
            ceVar = (ce) this.c.get(i2);
            if (ceVar.i() || ceVar.getLayoutPosition() != i) {
                i2++;
            } else if (z) {
                return ceVar;
            } else {
                this.c.remove(i2);
                return ceVar;
            }
        }
        return null;
    }

    void b() {
        this.d = (this.f.m != null ? this.f.m.x : 0) + this.h;
        for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
            d(size);
        }
    }

    void b(int i, int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            ce ceVar = (ce) this.c.get(i3);
            if (ceVar != null && ceVar.b >= i) {
                ceVar.a(i2, true);
            }
        }
    }

    void b(ce ceVar) {
        int i = 0;
        if (ceVar.d() || ceVar.itemView.getParent() != null) {
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + ceVar.d() + " isAttached:" + (ceVar.itemView.getParent() != null) + this.f.a());
        } else if (ceVar.m()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + ceVar + this.f.a());
        } else if (ceVar.c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f.a());
        } else {
            int size;
            boolean a = ceVar.u();
            boolean z = this.f.l != null && a && this.f.l.onFailedToRecycleView(ceVar);
            if (z || ceVar.isRecyclable()) {
                if (this.d <= 0 || ceVar.a(526)) {
                    z = false;
                } else {
                    size = this.c.size();
                    if (size >= this.d && size > 0) {
                        d(0);
                        size--;
                    }
                    if (RecyclerView.L && size > 0 && !this.f.B.a(ceVar.b)) {
                        int i2 = size - 1;
                        while (i2 >= 0) {
                            if (!this.f.B.a(((ce) this.c.get(i2)).b)) {
                                break;
                            }
                            i2--;
                        }
                        size = i2 + 1;
                    }
                    this.c.add(size, ceVar);
                    size = true;
                }
                if (!size == true) {
                    a(ceVar, true);
                    i = 1;
                }
            } else {
                size = 0;
            }
            this.f.g.g(ceVar);
            if (size == 0 && i == 0 && a) {
                ceVar.l = null;
            }
        }
    }

    void b(View view) {
        ce e = RecyclerView.e(view);
        e.p = null;
        e.q = false;
        e.g();
        b(e);
    }

    public View c(int i) {
        return a(i, false);
    }

    public List<ce> c() {
        return this.g;
    }

    void c(int i, int i2) {
        int i3 = i + i2;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) this.c.get(size);
            if (ceVar != null) {
                int i4 = ceVar.b;
                if (i4 >= i && i4 < i3) {
                    ceVar.b(2);
                    d(size);
                }
            }
        }
    }

    void c(ce ceVar) {
        if (ceVar.q) {
            this.b.remove(ceVar);
        } else {
            this.a.remove(ceVar);
        }
        ceVar.p = null;
        ceVar.q = false;
        ceVar.g();
    }

    void c(View view) {
        ce e = RecyclerView.e(view);
        if (!e.a(12) && e.r() && !this.f.b(e)) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            e.a(this, true);
            this.b.add(e);
        } else if (!e.i() || e.l() || this.f.l.hasStableIds()) {
            e.a(this, false);
            this.a.add(e);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f.a());
        }
    }

    void d() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            d(size);
        }
        this.c.clear();
        if (RecyclerView.L) {
            this.f.B.a();
        }
    }

    void d(int i) {
        a((ce) this.c.get(i), true);
        this.c.remove(i);
    }

    void d(ce ceVar) {
        if (this.f.n != null) {
            this.f.n.onViewRecycled(ceVar);
        }
        if (this.f.l != null) {
            this.f.l.onViewRecycled(ceVar);
        }
        if (this.f.C != null) {
            this.f.g.g(ceVar);
        }
    }

    int e() {
        return this.a.size();
    }

    View e(int i) {
        return ((ce) this.a.get(i)).itemView;
    }

    ce f(int i) {
        int i2 = 0;
        if (this.b != null) {
            int size = this.b.size();
            if (size != 0) {
                ce ceVar;
                int i3 = 0;
                while (i3 < size) {
                    ceVar = (ce) this.b.get(i3);
                    if (ceVar.f() || ceVar.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        ceVar.b(32);
                        return ceVar;
                    }
                }
                if (this.f.l.hasStableIds()) {
                    int b = this.f.e.b(i);
                    if (b > 0 && b < this.f.l.getItemCount()) {
                        long itemId = this.f.l.getItemId(b);
                        while (i2 < size) {
                            ceVar = (ce) this.b.get(i2);
                            if (ceVar.f() || ceVar.getItemId() != itemId) {
                                i2++;
                            } else {
                                ceVar.b(32);
                                return ceVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    void f() {
        this.a.clear();
        if (this.b != null) {
            this.b.clear();
        }
    }

    bx g() {
        if (this.e == null) {
            this.e = new bx();
        }
        return this.e;
    }

    void h() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            ce ceVar = (ce) this.c.get(i);
            if (ceVar != null) {
                ceVar.b(6);
                ceVar.a(null);
            }
        }
        if (this.f.l == null || !this.f.l.hasStableIds()) {
            d();
        }
    }

    void i() {
        int i;
        int i2 = 0;
        int size = this.c.size();
        for (i = 0; i < size; i++) {
            ((ce) this.c.get(i)).a();
        }
        size = this.a.size();
        for (i = 0; i < size; i++) {
            ((ce) this.a.get(i)).a();
        }
        if (this.b != null) {
            i = this.b.size();
            while (i2 < i) {
                ((ce) this.b.get(i2)).a();
                i2++;
            }
        }
    }

    void j() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            LayoutParams layoutParams = (LayoutParams) ((ce) this.c.get(i)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.e = true;
            }
        }
    }
}
