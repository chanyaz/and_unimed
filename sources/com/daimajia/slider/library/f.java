package com.daimajia.slider.library;

import android.content.Context;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.ImageLoadListener;
import java.util.ArrayList;
import java.util.Iterator;

public class f extends n implements ImageLoadListener {
    private Context a;
    private ArrayList<BaseSliderView> b = new ArrayList();

    public f(Context context) {
        this.a = context;
    }

    public int a(Object obj) {
        return -2;
    }

    public BaseSliderView a(int i) {
        return (i < 0 || i >= this.b.size()) ? null : (BaseSliderView) this.b.get(i);
    }

    public Object a(ViewGroup viewGroup, int i) {
        View g = ((BaseSliderView) this.b.get(i)).g();
        viewGroup.addView(g);
        return g;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public <T extends BaseSliderView> void a(T t) {
        t.a((ImageLoadListener) this);
        this.b.add(t);
        c();
    }

    public boolean a(View view, Object obj) {
        return view == obj;
    }

    public int b() {
        return this.b.size();
    }

    public <T extends BaseSliderView> void b(T t) {
        if (this.b.contains(t)) {
            this.b.remove(t);
            c();
        }
    }

    public void onEnd(boolean z, BaseSliderView baseSliderView) {
        if (baseSliderView.b() && !z) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                if (((BaseSliderView) it.next()).equals(baseSliderView)) {
                    b(baseSliderView);
                    return;
                }
            }
        }
    }

    public void onStart(BaseSliderView baseSliderView) {
    }
}
