package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import java.util.Arrays;

class ax implements LayoutPrefetchRegistry {
    int a;
    int b;
    int[] c;
    int d;

    ax() {
    }

    void a() {
        if (this.c != null) {
            Arrays.fill(this.c, -1);
        }
        this.d = 0;
    }

    void a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    void a(RecyclerView recyclerView, boolean z) {
        this.d = 0;
        if (this.c != null) {
            Arrays.fill(this.c, -1);
        }
        LayoutManager layoutManager = recyclerView.m;
        if (recyclerView.l != null && layoutManager != null && layoutManager.q()) {
            if (z) {
                if (!recyclerView.e.d()) {
                    layoutManager.a(recyclerView.l.getItemCount(), (LayoutPrefetchRegistry) this);
                }
            } else if (!recyclerView.v()) {
                layoutManager.a(this.a, this.b, recyclerView.C, (LayoutPrefetchRegistry) this);
            }
            if (this.d > layoutManager.x) {
                layoutManager.x = this.d;
                layoutManager.y = z;
                recyclerView.d.b();
            }
        }
    }

    boolean a(int i) {
        if (this.c == null) {
            return false;
        }
        int i2 = this.d * 2;
        for (int i3 = 0; i3 < i2; i3 += 2) {
            if (this.c[i3] == i) {
                return true;
            }
        }
        return false;
    }

    public void addPosition(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        } else {
            int i3 = this.d * 2;
            if (this.c == null) {
                this.c = new int[4];
                Arrays.fill(this.c, -1);
            } else if (i3 >= this.c.length) {
                Object obj = this.c;
                this.c = new int[(i3 * 2)];
                System.arraycopy(obj, 0, this.c, 0, obj.length);
            }
            this.c[i3] = i;
            this.c[i3 + 1] = i2;
            this.d++;
        }
    }
}
