package android.support.transition;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.app.af;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FragmentTransitionSupport extends af {
    private static boolean a(Transition transition) {
        return (af.a(transition.f()) && af.a(transition.h()) && af.a(transition.i())) ? false : true;
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.b((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.b((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.b((Transition) obj3);
        }
        return transitionSet;
    }

    public void a(ViewGroup viewGroup, Object obj) {
        aj.a(viewGroup, (Transition) obj);
    }

    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).a(new ah() {
                public Rect a(@NonNull Transition transition) {
                    return (rect == null || rect.isEmpty()) ? null : rect;
                }
            });
        }
    }

    public void a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            a(view, rect);
            transition.a(new ah() {
                public Rect a(@NonNull Transition transition) {
                    return rect;
                }
            });
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        List g = obj.g();
        g.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            af.a(g, (View) arrayList.get(i));
        }
        g.add(view);
        arrayList.add(view);
        a(obj, (ArrayList) arrayList);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).a(new TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public void onTransitionEnd(@NonNull Transition transition) {
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public void onTransitionStart(@NonNull Transition transition) {
                if (obj5 != null) {
                    FragmentTransitionSupport.this.b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    FragmentTransitionSupport.this.b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    FragmentTransitionSupport.this.b(obj7, arrayList6, null);
                }
            }
        });
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        if (transition != null) {
            int p;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                p = transitionSet.p();
                while (i < p) {
                    a(transitionSet.b(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!a(transition) && af.a(transition.g())) {
                int size = arrayList.size();
                for (p = 0; p < size; p++) {
                    transition.c((View) arrayList.get(p));
                }
            }
        }
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.g().clear();
            obj.g().addAll(arrayList2);
            b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    public Object b(Object obj) {
        return obj != null ? ((Transition) obj).clone() : null;
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().b(transition2).b(transition3).a(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition3 != null) {
            transition = transition3;
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.b(transition);
        }
        transitionSet.b(transition4);
        return transitionSet;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a(new TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                transition.b((TransitionListener) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public void onTransitionStart(@NonNull Transition transition) {
            }
        });
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i = 0;
        Transition transition = (Transition) obj;
        int p;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            p = transitionSet.p();
            while (i < p) {
                b(transitionSet.b(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!a(transition)) {
            List g = transition.g();
            if (g.size() == arrayList.size() && g.containsAll(arrayList)) {
                p = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < p; i2++) {
                    transition.c((View) arrayList2.get(i2));
                }
                for (p = arrayList.size() - 1; p >= 0; p--) {
                    transition.d((View) arrayList.get(p));
                }
            }
        }
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.b((Transition) obj);
        return transitionSet;
    }

    public void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }
}
