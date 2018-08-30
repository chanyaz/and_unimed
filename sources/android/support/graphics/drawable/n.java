package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.v4.content.res.f;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class n extends p {
    int a = 0;
    float b = 0.0f;
    int c = 0;
    float d = 1.0f;
    int e = 0;
    float f = 1.0f;
    float g = 0.0f;
    float h = 1.0f;
    float i = 0.0f;
    Cap j = Cap.BUTT;
    Join k = Join.MITER;
    float l = 4.0f;
    private int[] p;

    public n(n nVar) {
        super(nVar);
        this.p = nVar.p;
        this.a = nVar.a;
        this.b = nVar.b;
        this.d = nVar.d;
        this.c = nVar.c;
        this.e = nVar.e;
        this.f = nVar.f;
        this.g = nVar.g;
        this.h = nVar.h;
        this.i = nVar.i;
        this.j = nVar.j;
        this.k = nVar.k;
        this.l = nVar.l;
    }

    private Cap a(int i, Cap cap) {
        switch (i) {
            case 0:
                return Cap.BUTT;
            case 1:
                return Cap.ROUND;
            case 2:
                return Cap.SQUARE;
            default:
                return cap;
        }
    }

    private Join a(int i, Join join) {
        switch (i) {
            case 0:
                return Join.MITER;
            case 1:
                return Join.ROUND;
            case 2:
                return Join.BEVEL;
            default:
                return join;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.p = null;
        if (f.a(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(2);
            if (string != null) {
                this.m = b.b(string);
            }
            this.c = f.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
            this.f = f.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
            this.j = a(f.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
            this.k = a(f.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
            this.l = f.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
            this.a = f.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
            this.d = f.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
            this.b = f.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
            this.h = f.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
            this.i = f.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
            this.g = f.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
            this.e = f.a(typedArray, xmlPullParser, "fillType", 13, this.e);
        }
    }

    public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray a = f.a(resources, theme, attributeSet, a.c);
        a(a, xmlPullParser);
        a.recycle();
    }

    float getFillAlpha() {
        return this.f;
    }

    int getFillColor() {
        return this.c;
    }

    float getStrokeAlpha() {
        return this.d;
    }

    int getStrokeColor() {
        return this.a;
    }

    float getStrokeWidth() {
        return this.b;
    }

    float getTrimPathEnd() {
        return this.h;
    }

    float getTrimPathOffset() {
        return this.i;
    }

    float getTrimPathStart() {
        return this.g;
    }

    void setFillAlpha(float f) {
        this.f = f;
    }

    void setFillColor(int i) {
        this.c = i;
    }

    void setStrokeAlpha(float f) {
        this.d = f;
    }

    void setStrokeColor(int i) {
        this.a = i;
    }

    void setStrokeWidth(float f) {
        this.b = f;
    }

    void setTrimPathEnd(float f) {
        this.h = f;
    }

    void setTrimPathOffset(float f) {
        this.i = f;
    }

    void setTrimPathStart(float f) {
        this.g = f;
    }
}
