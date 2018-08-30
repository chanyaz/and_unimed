package android.support.transition;

import android.graphics.Matrix;
import android.support.transition.GhostViewImpl.Creator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

class m implements Creator {
    m() {
    }

    public GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        l.f();
        if (l.c != null) {
            try {
                return new l((View) l.c.invoke(null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    public void removeGhost(View view) {
        l.g();
        if (l.e != null) {
            try {
                l.e.invoke(null, new Object[]{view});
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
