package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.v4.content.res.f;
import android.support.v4.util.a;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class o {
    final ArrayList<Object> a = new ArrayList();
    float b = 0.0f;
    int c;
    private final Matrix d = new Matrix();
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 1.0f;
    private float h = 1.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private final Matrix k = new Matrix();
    private int[] l;
    private String m = null;

    public o(o oVar, a<String, Object> aVar) {
        this.b = oVar.b;
        this.e = oVar.e;
        this.f = oVar.f;
        this.g = oVar.g;
        this.h = oVar.h;
        this.i = oVar.i;
        this.j = oVar.j;
        this.l = oVar.l;
        this.m = oVar.m;
        this.c = oVar.c;
        if (this.m != null) {
            aVar.put(this.m, this);
        }
        this.k.set(oVar.k);
        ArrayList arrayList = oVar.a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                Object obj = arrayList.get(i2);
                if (obj instanceof o) {
                    this.a.add(new o((o) obj, aVar));
                } else {
                    p nVar;
                    if (obj instanceof n) {
                        nVar = new n((n) obj);
                    } else if (obj instanceof m) {
                        nVar = new m((m) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.a.add(nVar);
                    if (nVar.n != null) {
                        aVar.put(nVar.n, nVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a() {
        this.k.reset();
        this.k.postTranslate(-this.e, -this.f);
        this.k.postScale(this.g, this.h);
        this.k.postRotate(this.b, 0.0f, 0.0f);
        this.k.postTranslate(this.i + this.e, this.j + this.f);
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.l = null;
        this.b = f.a(typedArray, xmlPullParser, "rotation", 5, this.b);
        this.e = typedArray.getFloat(1, this.e);
        this.f = typedArray.getFloat(2, this.f);
        this.g = f.a(typedArray, xmlPullParser, "scaleX", 3, this.g);
        this.h = f.a(typedArray, xmlPullParser, "scaleY", 4, this.h);
        this.i = f.a(typedArray, xmlPullParser, "translateX", 6, this.i);
        this.j = f.a(typedArray, xmlPullParser, "translateY", 7, this.j);
        String string = typedArray.getString(0);
        if (string != null) {
            this.m = string;
        }
        a();
    }

    public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray a = f.a(resources, theme, attributeSet, a.b);
        a(a, xmlPullParser);
        a.recycle();
    }

    public String getGroupName() {
        return this.m;
    }

    public Matrix getLocalMatrix() {
        return this.k;
    }

    public float getPivotX() {
        return this.e;
    }

    public float getPivotY() {
        return this.f;
    }

    public float getRotation() {
        return this.b;
    }

    public float getScaleX() {
        return this.g;
    }

    public float getScaleY() {
        return this.h;
    }

    public float getTranslateX() {
        return this.i;
    }

    public float getTranslateY() {
        return this.j;
    }

    public void setPivotX(float f) {
        if (f != this.e) {
            this.e = f;
            a();
        }
    }

    public void setPivotY(float f) {
        if (f != this.f) {
            this.f = f;
            a();
        }
    }

    public void setRotation(float f) {
        if (f != this.b) {
            this.b = f;
            a();
        }
    }

    public void setScaleX(float f) {
        if (f != this.g) {
            this.g = f;
            a();
        }
    }

    public void setScaleY(float f) {
        if (f != this.h) {
            this.h = f;
            a();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.i) {
            this.i = f;
            a();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.j) {
            this.j = f;
            a();
        }
    }
}
