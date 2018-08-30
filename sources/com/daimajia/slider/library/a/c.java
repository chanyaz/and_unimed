package com.daimajia.slider.library.a;

import android.view.View;
import com.daimajia.slider.library.Animations.BaseAnimationInterface;
import com.daimajia.slider.library.Tricks.ViewPagerEx.PageTransformer;
import com.nineoldandroids.a.a;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class c implements PageTransformer {
    boolean a;
    boolean b;
    private BaseAnimationInterface c;
    private HashMap<View, ArrayList<Float>> d = new HashMap();

    protected abstract void a(View view, float f);

    public void a(BaseAnimationInterface baseAnimationInterface) {
        this.c = baseAnimationInterface;
    }

    protected boolean a() {
        return true;
    }

    protected void b(View view, float f) {
        float width = (float) view.getWidth();
        a.e(view, 0.0f);
        a.f(view, 0.0f);
        a.d(view, 0.0f);
        a.g(view, 1.0f);
        a.h(view, 1.0f);
        a.b(view, 0.0f);
        a.c(view, 0.0f);
        a.j(view, 0.0f);
        a.i(view, b() ? 0.0f : (-width) * f);
        if (a()) {
            width = (f <= -1.0f || f >= 1.0f) ? 0.0f : 1.0f;
            a.a(view, width);
        } else {
            a.a(view, 1.0f);
        }
        if (this.c == null) {
            return;
        }
        if ((!this.d.containsKey(view) || ((ArrayList) this.d.get(view)).size() == 1) && f > -1.0f && f < 1.0f) {
            if (this.d.get(view) == null) {
                this.d.put(view, new ArrayList());
            }
            ((ArrayList) this.d.get(view)).add(Float.valueOf(f));
            if (((ArrayList) this.d.get(view)).size() == 2) {
                width = ((Float) ((ArrayList) this.d.get(view)).get(1)).floatValue() - ((Float) ((ArrayList) this.d.get(view)).get(0)).floatValue();
                if (((Float) ((ArrayList) this.d.get(view)).get(0)).floatValue() > 0.0f) {
                    if (width <= -1.0f || width >= 0.0f) {
                        this.c.onPrepareCurrentItemLeaveScreen(view);
                    } else {
                        this.c.onPrepareNextItemShowInScreen(view);
                    }
                } else if (width <= -1.0f || width >= 0.0f) {
                    this.c.onPrepareNextItemShowInScreen(view);
                } else {
                    this.c.onPrepareCurrentItemLeaveScreen(view);
                }
            }
        }
    }

    protected boolean b() {
        return false;
    }

    protected void c(View view, float f) {
        if (this.c != null) {
            if (f == -1.0f || f == 1.0f) {
                this.c.onCurrentItemDisappear(view);
                this.a = true;
            } else if (f == 0.0f) {
                this.c.onNextItemAppear(view);
                this.b = true;
            }
            if (this.a && this.b) {
                this.d.clear();
                this.a = false;
                this.b = false;
            }
        }
    }

    public void transformPage(View view, float f) {
        b(view, f);
        a(view, f);
        c(view, f);
    }
}
