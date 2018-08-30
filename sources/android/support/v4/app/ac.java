package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.a;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class ac {
    private static final int[] a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final af b = (VERSION.SDK_INT >= 21 ? new ae() : null);
    private static final af c = a();

    ac() {
    }

    private static ad a(ad adVar, SparseArray<ad> sparseArray, int i) {
        if (adVar != null) {
            return adVar;
        }
        adVar = new ad();
        sparseArray.put(i, adVar);
        return adVar;
    }

    private static af a() {
        try {
            return (af) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static af a(Fragment fragment, Fragment fragment2) {
        Object A;
        List arrayList = new ArrayList();
        if (fragment != null) {
            A = fragment.A();
            if (A != null) {
                arrayList.add(A);
            }
            A = fragment.z();
            if (A != null) {
                arrayList.add(A);
            }
            A = fragment.D();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (fragment2 != null) {
            A = fragment2.y();
            if (A != null) {
                arrayList.add(A);
            }
            A = fragment2.B();
            if (A != null) {
                arrayList.add(A);
            }
            A = fragment2.C();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && a(b, arrayList)) {
            return b;
        }
        if (c != null && a(c, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static a<String, String> a(int i, ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        a<String, String> aVar = new a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            d dVar = (d) arrayList.get(i4);
            if (dVar.b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (dVar.r != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = dVar.r.size();
                    if (booleanValue) {
                        arrayList3 = dVar.r;
                        arrayList4 = dVar.s;
                    } else {
                        ArrayList arrayList5 = dVar.r;
                        arrayList3 = dVar.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static Object a(af afVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return afVar.c(afVar.b(z ? fragment2.D() : fragment.C()));
    }

    private static Object a(af afVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return afVar.b(z ? fragment.B() : fragment.y());
    }

    private static Object a(af afVar, ViewGroup viewGroup, View view, a<String, String> aVar, ad adVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Fragment fragment = adVar.a;
        Fragment fragment2 = adVar.d;
        if (fragment != null) {
            fragment.s().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        boolean z = adVar.b;
        Object a = aVar.isEmpty() ? null : a(afVar, fragment, fragment2, z);
        a b = b(afVar, (a) aVar, a, adVar);
        final a c = c(afVar, aVar, a, adVar);
        if (aVar.isEmpty()) {
            obj3 = null;
            if (b != null) {
                b.clear();
            }
            if (c != null) {
                c.clear();
            }
        } else {
            a((ArrayList) arrayList, b, aVar.keySet());
            a((ArrayList) arrayList2, c, aVar.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        View b2;
        b(fragment, fragment2, z, b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            afVar.a(obj3, view, (ArrayList) arrayList);
            a(afVar, obj3, obj2, b, adVar.e, adVar.f);
            rect = new Rect();
            b2 = b(c, adVar, obj, z);
            if (b2 != null) {
                afVar.a(obj, rect);
            }
        } else {
            rect = null;
            b2 = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final af afVar2 = afVar;
        at.a(viewGroup, new Runnable() {
            public void run() {
                ac.b(fragment3, fragment4, z2, c, false);
                if (b2 != null) {
                    afVar2.a(b2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(af afVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.F() : fragment.E();
        }
        return z2 ? afVar.a(obj2, obj, obj3) : afVar.b(obj2, obj, obj3);
    }

    private static String a(a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return (String) aVar.b(i);
            }
        }
        return null;
    }

    private static void a(FragmentManagerImpl fragmentManagerImpl, int i, ad adVar, View view, a<String, String> aVar) {
        View view2 = null;
        if (fragmentManagerImpl.n.a()) {
            view2 = (ViewGroup) fragmentManagerImpl.n.a(i);
        }
        if (view2 != null) {
            Fragment fragment = adVar.a;
            Fragment fragment2 = adVar.d;
            af a = a(fragment2, fragment);
            if (a != null) {
                boolean z = adVar.b;
                boolean z2 = adVar.e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a2 = a(a, fragment, z);
                Object b = b(a, fragment2, z2);
                Object a3 = a(a, (ViewGroup) view2, view, (a) aVar, adVar, arrayList2, arrayList, a2, b);
                if (a2 != null || a3 != null || b != null) {
                    ArrayList b2 = b(a, b, fragment2, arrayList2, view);
                    ArrayList b3 = b(a, a2, fragment, arrayList, view);
                    b(b3, 4);
                    Object a4 = a(a, a2, b, a3, fragment, z);
                    if (a4 != null) {
                        a(a, b, fragment2, b2);
                        ArrayList a5 = a.a(arrayList);
                        a.a(a4, a2, b3, b, b2, a3, arrayList);
                        a.a((ViewGroup) view2, a4);
                        a.a(view2, arrayList2, arrayList, a5, aVar);
                        b(b3, 0);
                        a.a(a3, arrayList2, arrayList);
                    }
                }
            }
        }
    }

    static void a(FragmentManagerImpl fragmentManagerImpl, ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                d dVar = (d) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    b(dVar, sparseArray, z);
                } else {
                    a(dVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    a a = a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    ad adVar = (ad) sparseArray.valueAt(i4);
                    if (z) {
                        a(fragmentManagerImpl, keyAt, adVar, view, a);
                    } else {
                        b(fragmentManagerImpl, keyAt, adVar, view, a);
                    }
                }
            }
        }
    }

    private static void a(af afVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final af afVar2 = afVar;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        at.a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    afVar2.c(obj3, view2);
                    arrayList5.addAll(ac.b(afVar2, obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        afVar2.b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(af afVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.u && fragment.K && fragment.Z) {
            fragment.k(true);
            afVar.b(obj, fragment.s(), (ArrayList) arrayList);
            at.a(fragment.R, new Runnable() {
                public void run() {
                    ac.b(arrayList, 4);
                }
            });
        }
    }

    private static void a(af afVar, Object obj, Object obj2, a<String, View> aVar, boolean z, d dVar) {
        if (dVar.r != null && !dVar.r.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) dVar.s.get(0);
            } else {
                String obj32 = (String) dVar.r.get(0);
            }
            View view = (View) aVar.get(obj32);
            afVar.a(obj, view);
            if (obj2 != null) {
                afVar.a(obj2, view);
            }
        }
    }

    private static void a(d dVar, e eVar, SparseArray<ad> sparseArray, boolean z, boolean z2) {
        Fragment fragment = eVar.b;
        if (fragment != null) {
            int i = fragment.I;
            if (i != 0) {
                int i2;
                int i3;
                ad a;
                boolean z3;
                int i4;
                int i5;
                boolean i32;
                int i6;
                switch (z ? a[eVar.a] : eVar.a) {
                    case 1:
                    case 7:
                        z3 = z2 ? fragment.Y : (fragment.u || fragment.K) ? false : true;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    case 3:
                    case 6:
                        i6 = z2 ? (fragment.u || fragment.S == null || fragment.S.getVisibility() != 0 || fragment.aa < 0.0f) ? 0 : 1 : (!fragment.u || fragment.K) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 4:
                        i6 = z2 ? (fragment.Z && fragment.u && fragment.K) ? 1 : 0 : (!fragment.u || fragment.K) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 5:
                        z3 = z2 ? fragment.Z && !fragment.K && fragment.u : fragment.K;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    default:
                        i4 = 0;
                        i2 = 0;
                        i5 = 0;
                        i32 = 0;
                        break;
                }
                ad adVar = (ad) sparseArray.get(i);
                if (i32 != 0) {
                    a = a(adVar, (SparseArray) sparseArray, i);
                    a.a = fragment;
                    a.b = z;
                    a.c = dVar;
                } else {
                    a = adVar;
                }
                if (!(z2 || i4 == 0)) {
                    if (a != null && a.d == fragment) {
                        a.d = null;
                    }
                    FragmentManagerImpl fragmentManagerImpl = dVar.a;
                    if (fragment.k < 1 && fragmentManagerImpl.l >= 1 && !dVar.t) {
                        fragmentManagerImpl.g(fragment);
                        fragmentManagerImpl.a(fragment, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.d == null)) {
                    adVar = a;
                } else {
                    adVar = a(a, (SparseArray) sparseArray, i);
                    adVar.d = fragment;
                    adVar.e = z;
                    adVar.f = dVar;
                }
                if (!z2 && i5 != 0 && adVar != null && adVar.a == fragment) {
                    adVar.a = null;
                }
            }
        }
    }

    public static void a(d dVar, SparseArray<ad> sparseArray, boolean z) {
        int size = dVar.b.size();
        for (int i = 0; i < size; i++) {
            a(dVar, (e) dVar.b.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    private static void a(a<String, String> aVar, a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.c(size);
            if (collection.contains(ViewCompat.o(view))) {
                arrayList.add(view);
            }
        }
    }

    private static boolean a(af afVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!afVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static a<String, View> b(af afVar, a<String, String> aVar, Object obj, ad adVar) {
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        Fragment fragment = adVar.d;
        Map aVar2 = new a();
        afVar.a(aVar2, fragment.s());
        d dVar = adVar.f;
        SharedElementCallback V;
        if (adVar.e) {
            V = fragment.V();
            arrayList = dVar.s;
            sharedElementCallback = V;
        } else {
            V = fragment.W();
            arrayList = dVar.r;
            sharedElementCallback = V;
        }
        aVar2.a(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(ViewCompat.o(view))) {
                    aVar.put(ViewCompat.o(view), (String) aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar2.keySet());
        }
        return aVar2;
    }

    private static View b(a<String, View> aVar, ad adVar, Object obj, boolean z) {
        d dVar = adVar.c;
        if (obj == null || aVar == null || dVar.r == null || dVar.r.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) dVar.r.get(0);
        } else {
            String obj22 = (String) dVar.s.get(0);
        }
        return (View) aVar.get(obj22);
    }

    private static Object b(af afVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return afVar.b(z ? fragment.z() : fragment.A());
    }

    private static Object b(af afVar, ViewGroup viewGroup, View view, a<String, String> aVar, ad adVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final Fragment fragment = adVar.a;
        final Fragment fragment2 = adVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        final boolean z = adVar.b;
        Object a = aVar.isEmpty() ? null : a(afVar, fragment, fragment2, z);
        a b = b(afVar, (a) aVar, a, adVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        b(fragment, fragment2, z, b, true);
        if (obj3 != null) {
            rect = new Rect();
            afVar.a(obj3, view, (ArrayList) arrayList);
            a(afVar, obj3, obj2, b, adVar.e, adVar.f);
            if (obj != null) {
                afVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final af afVar2 = afVar;
        final a<String, String> aVar2 = aVar;
        final Object obj4 = obj3;
        final ad adVar2 = adVar;
        final ArrayList<View> arrayList3 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj5 = obj;
        at.a(viewGroup, new Runnable() {
            public void run() {
                a a = ac.c(afVar2, aVar2, obj4, adVar2);
                if (a != null) {
                    arrayList3.addAll(a.values());
                    arrayList3.add(view2);
                }
                ac.b(fragment, fragment2, z, a, false);
                if (obj4 != null) {
                    afVar2.a(obj4, arrayList4, arrayList3);
                    View a2 = ac.b(a, adVar2, obj5, z);
                    if (a2 != null) {
                        afVar2.a(a2, rect);
                    }
                }
            }
        });
        return obj3;
    }

    private static ArrayList<View> b(af afVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View s = fragment.s();
            if (s != null) {
                afVar.a((ArrayList) arrayList2, s);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                afVar.a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    private static void b(Fragment fragment, Fragment fragment2, boolean z, a<String, View> aVar, boolean z2) {
        int i = 0;
        SharedElementCallback V = z ? fragment2.V() : fragment.V();
        if (V != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            while (i < size) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
                i++;
            }
            if (z2) {
                V.a(arrayList2, arrayList, null);
            } else {
                V.b(arrayList2, arrayList, null);
            }
        }
    }

    private static void b(FragmentManagerImpl fragmentManagerImpl, int i, ad adVar, View view, a<String, String> aVar) {
        ViewGroup viewGroup = null;
        if (fragmentManagerImpl.n.a()) {
            viewGroup = (ViewGroup) fragmentManagerImpl.n.a(i);
        }
        if (viewGroup != null) {
            Fragment fragment = adVar.a;
            Fragment fragment2 = adVar.d;
            af a = a(fragment2, fragment);
            if (a != null) {
                boolean z = adVar.b;
                boolean z2 = adVar.e;
                Object a2 = a(a, fragment, z);
                Object b = b(a, fragment2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object b2 = b(a, viewGroup, view, aVar, adVar, arrayList, arrayList2, a2, b);
                if (a2 != null || b2 != null || b != null) {
                    ArrayList b3 = b(a, b, fragment2, arrayList, view);
                    Object obj = (b3 == null || b3.isEmpty()) ? null : b;
                    a.b(a2, view);
                    Object a3 = a(a, a2, obj, b2, fragment, adVar.b);
                    if (a3 != null) {
                        ArrayList arrayList3 = new ArrayList();
                        a.a(a3, a2, arrayList3, obj, b3, b2, arrayList2);
                        a(a, viewGroup, fragment, view, arrayList2, a2, arrayList3, obj, b3);
                        a.a((View) viewGroup, arrayList2, (Map) aVar);
                        a.a(viewGroup, a3);
                        a.a(viewGroup, arrayList2, (Map) aVar);
                    }
                }
            }
        }
    }

    public static void b(d dVar, SparseArray<ad> sparseArray, boolean z) {
        if (dVar.a.n.a()) {
            for (int size = dVar.b.size() - 1; size >= 0; size--) {
                a(dVar, (e) dVar.b.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static a<String, View> c(af afVar, a<String, String> aVar, Object obj, ad adVar) {
        Fragment fragment = adVar.a;
        View s = fragment.s();
        if (aVar.isEmpty() || obj == null || s == null) {
            aVar.clear();
            return null;
        }
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        a<String, View> aVar2 = new a();
        afVar.a((Map) aVar2, s);
        d dVar = adVar.c;
        SharedElementCallback W;
        if (adVar.b) {
            W = fragment.W();
            arrayList = dVar.r;
            sharedElementCallback = W;
        } else {
            W = fragment.V();
            arrayList = dVar.s;
            sharedElementCallback = W;
        }
        if (arrayList != null) {
            aVar2.a(arrayList);
            aVar2.a(aVar.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                s = (View) aVar2.get(str);
                if (s == null) {
                    str = a((a) aVar, str);
                    if (str != null) {
                        aVar.remove(str);
                    }
                } else if (!str.equals(ViewCompat.o(s))) {
                    str = a((a) aVar, str);
                    if (str != null) {
                        aVar.put(str, ViewCompat.o(s));
                    }
                }
            }
        } else {
            a((a) aVar, (a) aVar2);
        }
        return aVar2;
    }
}
