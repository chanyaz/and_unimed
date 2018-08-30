package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.b.d;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class m extends MarginLayoutParams {
    Behavior a;
    boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = -1;
    int f = -1;
    public int g = 0;
    public int h = 0;
    int i;
    int j;
    View k;
    View l;
    final Rect m = new Rect();
    Object n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;

    public m(int i, int i2) {
        super(i, i2);
    }

    m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CoordinatorLayout_Layout);
        this.c = obtainStyledAttributes.getInteger(d.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f = obtainStyledAttributes.getResourceId(d.CoordinatorLayout_Layout_layout_anchor, -1);
        this.d = obtainStyledAttributes.getInteger(d.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.e = obtainStyledAttributes.getInteger(d.CoordinatorLayout_Layout_layout_keyline, -1);
        this.g = obtainStyledAttributes.getInt(d.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.h = obtainStyledAttributes.getInt(d.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        this.b = obtainStyledAttributes.hasValue(d.CoordinatorLayout_Layout_layout_behavior);
        if (this.b) {
            this.a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(d.CoordinatorLayout_Layout_layout_behavior));
        }
        obtainStyledAttributes.recycle();
        if (this.a != null) {
            this.a.a(this);
        }
    }

    public m(m mVar) {
        super(mVar);
    }

    public m(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public m(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    private void a(View view, CoordinatorLayout coordinatorLayout) {
        this.k = coordinatorLayout.findViewById(this.f);
        if (this.k != null) {
            if (this.k != coordinatorLayout) {
                View view2 = this.k;
                View parent = this.k.getParent();
                while (parent != coordinatorLayout && parent != null) {
                    if (parent != view) {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                        parent = parent.getParent();
                    } else if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    } else {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                }
                this.l = view2;
            } else if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.k = null;
            } else {
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
        } else if (coordinatorLayout.isInEditMode()) {
            this.l = null;
            this.k = null;
        } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
        }
    }

    private boolean a(View view, int i) {
        int a = android.support.v4.view.d.a(((m) view.getLayoutParams()).g, i);
        return a != 0 && (android.support.v4.view.d.a(this.h, i) & a) == a;
    }

    private boolean b(View view, CoordinatorLayout coordinatorLayout) {
        if (this.k.getId() != this.f) {
            return false;
        }
        View view2 = this.k;
        View parent = this.k.getParent();
        while (parent != coordinatorLayout) {
            if (parent == null || parent == view) {
                this.l = null;
                this.k = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        this.l = view2;
        return true;
    }

    @IdRes
    public int a() {
        return this.f;
    }

    void a(int i) {
        a(i, false);
    }

    void a(int i, boolean z) {
        switch (i) {
            case 0:
                this.p = z;
                return;
            case 1:
                this.q = z;
                return;
            default:
                return;
        }
    }

    void a(Rect rect) {
        this.m.set(rect);
    }

    public void a(@Nullable Behavior behavior) {
        if (this.a != behavior) {
            if (this.a != null) {
                this.a.c();
            }
            this.a = behavior;
            this.n = null;
            this.b = true;
            if (behavior != null) {
                behavior.a(this);
            }
        }
    }

    void a(boolean z) {
        this.r = z;
    }

    boolean a(CoordinatorLayout coordinatorLayout, View view) {
        if (this.o) {
            return true;
        }
        boolean e = (this.a != null ? this.a.e(coordinatorLayout, view) : 0) | this.o;
        this.o = e;
        return e;
    }

    boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 == this.l || a(view2, ViewCompat.f(coordinatorLayout)) || (this.a != null && this.a.a(coordinatorLayout, view, view2));
    }

    @Nullable
    public Behavior b() {
        return this.a;
    }

    View b(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f == -1) {
            this.l = null;
            this.k = null;
            return null;
        }
        if (this.k == null || !b(view, coordinatorLayout)) {
            a(view, coordinatorLayout);
        }
        return this.k;
    }

    boolean b(int i) {
        switch (i) {
            case 0:
                return this.p;
            case 1:
                return this.q;
            default:
                return false;
        }
    }

    Rect c() {
        return this.m;
    }

    boolean d() {
        return this.k == null && this.f != -1;
    }

    boolean e() {
        if (this.a == null) {
            this.o = false;
        }
        return this.o;
    }

    void f() {
        this.o = false;
    }

    boolean g() {
        return this.r;
    }

    void h() {
        this.r = false;
    }
}
