package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

class be {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<ce> k = null;
    boolean l;

    be() {
    }

    private View b() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            View view = ((ce) this.k.get(i)).itemView;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.d() && this.d == layoutParams.f()) {
                a(view);
                return view;
            }
        }
        return null;
    }

    View a(bz bzVar) {
        if (this.k != null) {
            return b();
        }
        View c = bzVar.c(this.d);
        this.d += this.e;
        return c;
    }

    public void a() {
        a(null);
    }

    public void a(View view) {
        View b = b(view);
        if (b == null) {
            this.d = -1;
        } else {
            this.d = ((LayoutParams) b.getLayoutParams()).f();
        }
    }

    boolean a(State state) {
        return this.d >= 0 && this.d < state.e();
    }

    public View b(View view) {
        int size = this.k.size();
        View view2 = null;
        int i = MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        while (i2 < size) {
            int i3;
            View view3;
            View view4 = ((ce) this.k.get(i2)).itemView;
            LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
            if (view4 != view) {
                if (layoutParams.d()) {
                    i3 = i;
                    view3 = view2;
                } else {
                    i3 = (layoutParams.f() - this.d) * this.e;
                    if (i3 < 0) {
                        i3 = i;
                        view3 = view2;
                    } else if (i3 < i) {
                        if (i3 == 0) {
                            return view4;
                        }
                        view3 = view4;
                    }
                }
                i2++;
                view2 = view3;
                i = i3;
            }
            i3 = i;
            view3 = view2;
            i2++;
            view2 = view3;
            i = i3;
        }
        return view2;
    }
}
