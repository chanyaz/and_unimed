package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.a;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class aj {
    private static Transition a = new AutoTransition();
    private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> d = new ThreadLocal();
    private static ArrayList<ViewGroup> e = new ArrayList();
    private a<ac, Transition> b = new a();
    private a<ac, a<ac, Transition>> c = new a();

    static a<ViewGroup, ArrayList<Transition>> a() {
        WeakReference weakReference = (WeakReference) d.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new a());
            d.set(weakReference);
        }
        return (a) weakReference.get();
    }

    public static void a(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!e.contains(viewGroup) && ViewCompat.y(viewGroup)) {
            e.add(viewGroup);
            if (transition == null) {
                transition = a;
            }
            Transition n = transition.clone();
            c(viewGroup, n);
            ac.a(viewGroup, null);
            b(viewGroup, n);
        }
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            Object akVar = new ak(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(akVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(akVar);
        }
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).e(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        ac a = ac.a(viewGroup);
        if (a != null) {
            a.a();
        }
    }
}
