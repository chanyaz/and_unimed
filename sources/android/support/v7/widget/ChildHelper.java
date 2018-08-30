package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    final Callback a;
    final aj b = new aj();
    final List<View> c = new ArrayList();

    interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        ce getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    ChildHelper(Callback callback) {
        this.a = callback;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.onEnteredHiddenState(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.onLeftHiddenState(view);
        return true;
    }

    void a() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.onLeftHiddenState((View) this.c.get(size));
            this.c.remove(size);
        }
        this.a.removeAllViews();
    }

    void a(int i) {
        int f = f(i);
        View childAt = this.a.getChildAt(f);
        if (childAt != null) {
            if (this.b.d(f)) {
                h(childAt);
            }
            this.a.removeViewAt(f);
        }
    }

    void a(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.b.d(indexOfChild)) {
                h(view);
            }
            this.a.removeViewAt(indexOfChild);
        }
    }

    void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount = i < 0 ? this.a.getChildCount() : f(i);
        this.b.a(childCount, z);
        if (z) {
            g(view);
        }
        this.a.attachViewToParent(view, childCount, layoutParams);
    }

    void a(View view, int i, boolean z) {
        int childCount = i < 0 ? this.a.getChildCount() : f(i);
        this.b.a(childCount, z);
        if (z) {
            g(view);
        }
        this.a.addView(view, childCount);
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    int b() {
        return this.a.getChildCount() - this.c.size();
    }

    int b(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        return (indexOfChild == -1 || this.b.c(indexOfChild)) ? -1 : indexOfChild - this.b.e(indexOfChild);
    }

    View b(int i) {
        return this.a.getChildAt(f(i));
    }

    int c() {
        return this.a.getChildCount();
    }

    View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.c.get(i2);
            ce childViewHolder = this.a.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.i() && !childViewHolder.l()) {
                return view;
            }
        }
        return null;
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    View d(int i) {
        return this.a.getChildAt(i);
    }

    void d(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(indexOfChild);
        g(view);
    }

    void e(int i) {
        int f = f(i);
        this.b.d(f);
        this.a.detachViewFromParent(f);
    }

    void e(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.b.c(indexOfChild)) {
            this.b.b(indexOfChild);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean f(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild == -1) {
            if (h(view)) {
            }
            return true;
        } else if (!this.b.c(indexOfChild)) {
            return false;
        } else {
            this.b.d(indexOfChild);
            if (!h(view)) {
            }
            this.a.removeViewAt(indexOfChild);
            return true;
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
