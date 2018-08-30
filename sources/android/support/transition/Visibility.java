package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    private static final String[] g = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int h = 3;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.e);
        int a = f.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a != 0) {
            b(a);
        }
    }

    private bi b(ap apVar, ap apVar2) {
        bi biVar = new bi();
        biVar.a = false;
        biVar.b = false;
        if (apVar == null || !apVar.a.containsKey("android:visibility:visibility")) {
            biVar.c = -1;
            biVar.e = null;
        } else {
            biVar.c = ((Integer) apVar.a.get("android:visibility:visibility")).intValue();
            biVar.e = (ViewGroup) apVar.a.get("android:visibility:parent");
        }
        if (apVar2 == null || !apVar2.a.containsKey("android:visibility:visibility")) {
            biVar.d = -1;
            biVar.f = null;
        } else {
            biVar.d = ((Integer) apVar2.a.get("android:visibility:visibility")).intValue();
            biVar.f = (ViewGroup) apVar2.a.get("android:visibility:parent");
        }
        if (apVar == null || apVar2 == null) {
            if (apVar == null && biVar.d == 0) {
                biVar.b = true;
                biVar.a = true;
            } else if (apVar2 == null && biVar.c == 0) {
                biVar.b = false;
                biVar.a = true;
            }
        } else if (biVar.c == biVar.d && biVar.e == biVar.f) {
            return biVar;
        } else {
            if (biVar.c != biVar.d) {
                if (biVar.c == 0) {
                    biVar.b = false;
                    biVar.a = true;
                } else if (biVar.d == 0) {
                    biVar.b = true;
                    biVar.a = true;
                }
            } else if (biVar.f == null) {
                biVar.b = false;
                biVar.a = true;
            } else if (biVar.e == null) {
                biVar.b = true;
                biVar.a = true;
            }
        }
        return biVar;
    }

    private void d(ap apVar) {
        apVar.a.put("android:visibility:visibility", Integer.valueOf(apVar.b.getVisibility()));
        apVar.a.put("android:visibility:parent", apVar.b.getParent());
        Object obj = new int[2];
        apVar.b.getLocationOnScreen(obj);
        apVar.a.put("android:visibility:screenLocation", obj);
    }

    public Animator a(ViewGroup viewGroup, ap apVar, int i, ap apVar2, int i2) {
        if ((this.h & 1) != 1 || apVar2 == null) {
            return null;
        }
        if (apVar == null) {
            View view = (View) apVar2.b.getParent();
            if (b(b(view, false), a(view, false)).a) {
                return null;
            }
        }
        return a(viewGroup, apVar2.b, apVar, apVar2);
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @Nullable ap apVar, @Nullable ap apVar2) {
        bi b = b(apVar, apVar2);
        if (!b.a || (b.e == null && b.f == null)) {
            return null;
        }
        if (b.b) {
            return a(viewGroup, apVar, b.c, apVar2, b.d);
        }
        return b(viewGroup, apVar, b.c, apVar2, b.d);
    }

    public Animator a(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        return null;
    }

    public void a(@NonNull ap apVar) {
        d(apVar);
    }

    public boolean a(ap apVar, ap apVar2) {
        if (apVar == null && apVar2 == null) {
            return false;
        }
        if (apVar != null && apVar2 != null && apVar2.a.containsKey("android:visibility:visibility") != apVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        bi b = b(apVar, apVar2);
        return b.a ? b.c == 0 || b.d == 0 : false;
    }

    @Nullable
    public String[] a() {
        return g;
    }

    public Animator b(ViewGroup viewGroup, ap apVar, int i, ap apVar2, int i2) {
        Animator animator = null;
        if ((this.h & 2) == 2) {
            int id;
            View view = apVar != null ? apVar.b : null;
            View view2 = apVar2 != null ? apVar2.b : null;
            if (view2 == null || view2.getParent() == null) {
                if (view2 != null) {
                    view = view2;
                    view2 = null;
                } else {
                    if (view != null) {
                        if (view.getParent() == null) {
                            view2 = null;
                        } else if (view.getParent() instanceof View) {
                            view2 = (View) view.getParent();
                            if (b(a(view2, true), b(view2, true)).a) {
                                if (view2.getParent() == null) {
                                    id = view2.getId();
                                    if (!(id == -1 || viewGroup.findViewById(id) == null || !this.e)) {
                                        view2 = view;
                                    }
                                }
                                view2 = null;
                            } else {
                                view2 = an.a(viewGroup, view, view2);
                            }
                            view = view2;
                            view2 = null;
                        }
                    }
                    view2 = null;
                    view = null;
                }
            } else if (i2 == 4) {
                view = null;
            } else if (view == view2) {
                view = null;
            } else {
                view2 = null;
            }
            if (view != null && apVar != null) {
                int[] iArr = (int[]) apVar.a.get("android:visibility:screenLocation");
                int i3 = iArr[0];
                id = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view.offsetLeftAndRight((i3 - iArr2[0]) - view.getLeft());
                view.offsetTopAndBottom((id - iArr2[1]) - view.getTop());
                final ViewGroupOverlayImpl a = av.a(viewGroup);
                a.add(view);
                animator = b(viewGroup, view, apVar, apVar2);
                if (animator == null) {
                    a.remove(view);
                } else {
                    animator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            a.remove(view);
                        }
                    });
                }
            } else if (view2 != null) {
                int visibility = view2.getVisibility();
                bb.a(view2, 0);
                animator = b(viewGroup, view2, apVar, apVar2);
                if (animator != null) {
                    TransitionListener bhVar = new bh(view2, i2, true);
                    animator.addListener(bhVar);
                    a.a(animator, bhVar);
                    a(bhVar);
                } else {
                    bb.a(view2, visibility);
                }
            }
        }
        return animator;
    }

    public Animator b(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        return null;
    }

    public void b(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.h = i;
    }

    public void b(@NonNull ap apVar) {
        d(apVar);
    }

    public int p() {
        return this.h;
    }
}
