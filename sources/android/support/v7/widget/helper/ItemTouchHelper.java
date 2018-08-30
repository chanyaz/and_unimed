package android.support.v7.widget.helper;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.bt;
import android.support.v7.widget.ce;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import java.util.List;

public class ItemTouchHelper extends bt implements OnChildAttachStateChangeListener {
    final List<View> a;
    ce b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    int i;
    a j;
    int k;
    int l;
    List<b> m;
    RecyclerView n;
    VelocityTracker o;
    View p;
    int q;
    private final float[] r;
    private ChildDrawingOrderCallback s;
    private long t;

    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    private int a(ce ceVar) {
        if (this.k == 2) {
            return 0;
        }
        int a = this.j.a(this.n, ceVar);
        int b = (this.j.b(a, ViewCompat.f(this.n)) & 65280) >> 8;
        if (b == 0) {
            return 0;
        }
        int i = (a & 65280) >> 8;
        if (Math.abs(this.e) > Math.abs(this.f)) {
            a = b(ceVar, b);
            if (a > 0) {
                return (i & a) == 0 ? a.a(a, ViewCompat.f(this.n)) : a;
            } else {
                a = c(ceVar, b);
                return a > 0 ? a : 0;
            }
        } else {
            a = c(ceVar, b);
            if (a > 0) {
                return a;
            }
            a = b(ceVar, b);
            return a > 0 ? (i & a) == 0 ? a.a(a, ViewCompat.f(this.n)) : a : 0;
        }
    }

    private void a(float[] fArr) {
        if ((this.l & 12) != 0) {
            fArr[0] = (this.g + this.e) - ((float) this.b.itemView.getLeft());
        } else {
            fArr[0] = this.b.itemView.getTranslationX();
        }
        if ((this.l & 3) != 0) {
            fArr[1] = (this.h + this.f) - ((float) this.b.itemView.getTop());
        } else {
            fArr[1] = this.b.itemView.getTranslationY();
        }
    }

    private int b(ce ceVar, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.e > 0.0f ? 8 : 4;
            if (this.o != null && this.i > -1) {
                this.o.computeCurrentVelocity(1000, this.j.b(this.d));
                float xVelocity = this.o.getXVelocity(this.i);
                float yVelocity = this.o.getYVelocity(this.i);
                if (xVelocity <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.j.a(this.c) && abs > Math.abs(yVelocity)) {
                    return i2;
                }
            }
            float width = ((float) this.n.getWidth()) * this.j.a(ceVar);
            if ((i & i3) != 0 && Math.abs(this.e) > width) {
                return i3;
            }
        }
        return 0;
    }

    private void b() {
        if (this.o != null) {
            this.o.recycle();
            this.o = null;
        }
    }

    private int c(ce ceVar, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.f > 0.0f ? 2 : 1;
            if (this.o != null && this.i > -1) {
                this.o.computeCurrentVelocity(1000, this.j.b(this.d));
                float xVelocity = this.o.getXVelocity(this.i);
                float yVelocity = this.o.getYVelocity(this.i);
                if (yVelocity <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.j.a(this.c) && abs > Math.abs(xVelocity)) {
                    return i2;
                }
            }
            float height = ((float) this.n.getHeight()) * this.j.a(ceVar);
            if ((i & i3) != 0 && Math.abs(this.f) > height) {
                return i3;
            }
        }
        return 0;
    }

    private void c() {
        if (VERSION.SDK_INT < 21) {
            if (this.s == null) {
                this.s = new ChildDrawingOrderCallback() {
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.p == null) {
                            return i2;
                        }
                        int i3 = ItemTouchHelper.this.q;
                        if (i3 == -1) {
                            i3 = ItemTouchHelper.this.n.indexOfChild(ItemTouchHelper.this.p);
                            ItemTouchHelper.this.q = i3;
                        }
                        return i2 == i + -1 ? i3 : i2 >= i3 ? i2 + 1 : i2;
                    }
                };
            }
            this.n.setChildDrawingOrderCallback(this.s);
        }
    }

    int a(ce ceVar, boolean z) {
        for (int size = this.m.size() - 1; size >= 0; size--) {
            b bVar = (b) this.m.get(size);
            if (bVar.h == ceVar) {
                bVar.n |= z;
                if (!bVar.o) {
                    bVar.b();
                }
                this.m.remove(size);
                return bVar.j;
            }
        }
        return 0;
    }

    public void a(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        if (this.b != null) {
            a(this.r);
            f = this.r[0];
            f2 = this.r[1];
        } else {
            f = 0.0f;
        }
        this.j.b(canvas, recyclerView, this.b, this.m, this.k, f, f2);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.setEmpty();
    }

    void a(ce ceVar, int i) {
        if (ceVar != this.b || i != this.k) {
            this.t = Long.MIN_VALUE;
            int i2 = this.k;
            a(ceVar, true);
            this.k = i;
            if (i == 2) {
                this.p = ceVar.itemView;
                c();
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.b != null) {
                ce ceVar2 = this.b;
                if (ceVar2.itemView.getParent() != null) {
                    float f;
                    float signum;
                    final int a = i2 == 2 ? 0 : a(ceVar2);
                    b();
                    switch (a) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.f) * ((float) this.n.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.e) * ((float) this.n.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    int i4 = i2 == 2 ? 8 : a > 0 ? 2 : 4;
                    a(this.r);
                    float f2 = this.r[0];
                    float f3 = this.r[1];
                    final ce ceVar3 = ceVar2;
                    b anonymousClass1 = new b(ceVar2, i4, i2, f2, f3, f, signum) {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            if (!this.n) {
                                if (a <= 0) {
                                    ItemTouchHelper.this.j.c(ItemTouchHelper.this.n, ceVar3);
                                } else {
                                    ItemTouchHelper.this.a.add(ceVar3.itemView);
                                    this.k = true;
                                    if (a > 0) {
                                        ItemTouchHelper.this.a((b) this, a);
                                    }
                                }
                                if (ItemTouchHelper.this.p == ceVar3.itemView) {
                                    ItemTouchHelper.this.a(ceVar3.itemView);
                                }
                            }
                        }
                    };
                    anonymousClass1.a(this.j.a(this.n, i4, f - f2, signum - f3));
                    this.m.add(anonymousClass1);
                    anonymousClass1.a();
                    obj = 1;
                } else {
                    a(ceVar2.itemView);
                    this.j.c(this.n, ceVar2);
                }
                this.b = null;
            }
            Object obj2 = obj;
            if (ceVar != null) {
                this.l = (this.j.b(this.n, ceVar) & i3) >> (this.k * 8);
                this.g = (float) ceVar.itemView.getLeft();
                this.h = (float) ceVar.itemView.getTop();
                this.b = ceVar;
                if (i == 2) {
                    this.b.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.n.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.b != null);
            }
            if (obj2 == null) {
                this.n.getLayoutManager().J();
            }
            this.j.b(this.b, this.k);
            this.n.invalidate();
        }
    }

    void a(final b bVar, final int i) {
        this.n.post(new Runnable() {
            public void run() {
                if (ItemTouchHelper.this.n != null && ItemTouchHelper.this.n.isAttachedToWindow() && !bVar.n && bVar.h.getAdapterPosition() != -1) {
                    ItemAnimator itemAnimator = ItemTouchHelper.this.n.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.a(null)) && !ItemTouchHelper.this.a()) {
                        ItemTouchHelper.this.j.a(bVar.h, i);
                    } else {
                        ItemTouchHelper.this.n.post(this);
                    }
                }
            }
        });
    }

    void a(View view) {
        if (view == this.p) {
            this.p = null;
            if (this.s != null) {
                this.n.setChildDrawingOrderCallback(null);
            }
        }
    }

    boolean a() {
        int size = this.m.size();
        for (int i = 0; i < size; i++) {
            if (!((b) this.m.get(i)).o) {
                return true;
            }
        }
        return false;
    }

    public void b(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        this.q = -1;
        if (this.b != null) {
            a(this.r);
            f = this.r[0];
            f2 = this.r[1];
        } else {
            f = 0.0f;
        }
        this.j.a(canvas, recyclerView, this.b, this.m, this.k, f, f2);
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        a(view);
        ce b = this.n.b(view);
        if (b != null) {
            if (this.b == null || b != this.b) {
                a(b, false);
                if (this.a.remove(b.itemView)) {
                    this.j.c(this.n, b);
                    return;
                }
                return;
            }
            a(null, 0);
        }
    }
}
