package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.ce;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class a {
    private static final ItemTouchUIUtil a;
    private static final Interpolator b = new Interpolator() {
        public float getInterpolation(float f) {
            return (((f * f) * f) * f) * f;
        }
    };
    private static final Interpolator c = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int d = -1;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new d();
        } else {
            a = new e();
        }
    }

    public static int a(int i, int i2) {
        int i3 = i & 789516;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        return i2 == 0 ? i4 | (i3 << 2) : (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
    }

    public float a(float f) {
        return f;
    }

    public float a(ce ceVar) {
        return 0.5f;
    }

    public abstract int a(RecyclerView recyclerView, ce ceVar);

    public long a(RecyclerView recyclerView, int i, float f, float f2) {
        ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator == null ? i == 8 ? 200 : 250 : i == 8 ? itemAnimator.e() : itemAnimator.g();
    }

    public void a(Canvas canvas, RecyclerView recyclerView, ce ceVar, float f, float f2, int i, boolean z) {
        a.onDraw(canvas, recyclerView, ceVar.itemView, f, f2, i, z);
    }

    void a(Canvas canvas, RecyclerView recyclerView, ce ceVar, List<b> list, int i, float f, float f2) {
        int i2;
        int size = list.size();
        for (i2 = 0; i2 < size; i2++) {
            b bVar = (b) list.get(i2);
            bVar.c();
            int save = canvas.save();
            a(canvas, recyclerView, bVar.h, bVar.l, bVar.m, bVar.i, false);
            canvas.restoreToCount(save);
        }
        if (ceVar != null) {
            i2 = canvas.save();
            a(canvas, recyclerView, ceVar, f, f2, i, true);
            canvas.restoreToCount(i2);
        }
    }

    public abstract void a(ce ceVar, int i);

    public float b(float f) {
        return f;
    }

    public int b(int i, int i2) {
        int i3 = i & 3158064;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        return i2 == 0 ? i4 | (i3 >> 2) : (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
    }

    final int b(RecyclerView recyclerView, ce ceVar) {
        return b(a(recyclerView, ceVar), ViewCompat.f(recyclerView));
    }

    public void b(Canvas canvas, RecyclerView recyclerView, ce ceVar, float f, float f2, int i, boolean z) {
        a.onDrawOver(canvas, recyclerView, ceVar.itemView, f, f2, i, z);
    }

    void b(Canvas canvas, RecyclerView recyclerView, ce ceVar, List<b> list, int i, float f, float f2) {
        int i2;
        b bVar;
        int size = list.size();
        for (i2 = 0; i2 < size; i2++) {
            bVar = (b) list.get(i2);
            int save = canvas.save();
            b(canvas, recyclerView, bVar.h, bVar.l, bVar.m, bVar.i, false);
            canvas.restoreToCount(save);
        }
        if (ceVar != null) {
            i2 = canvas.save();
            b(canvas, recyclerView, ceVar, f, f2, i, true);
            canvas.restoreToCount(i2);
        }
        Object obj = null;
        int i3 = size - 1;
        while (i3 >= 0) {
            Object obj2;
            bVar = (b) list.get(i3);
            if (!bVar.o || bVar.k) {
                obj2 = !bVar.o ? 1 : obj;
            } else {
                list.remove(i3);
                obj2 = obj;
            }
            i3--;
            obj = obj2;
        }
        if (obj != null) {
            recyclerView.invalidate();
        }
    }

    public void b(ce ceVar, int i) {
        if (ceVar != null) {
            a.onSelected(ceVar.itemView);
        }
    }

    public void c(RecyclerView recyclerView, ce ceVar) {
        a.clearView(ceVar.itemView);
    }
}
