package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.d;
import android.support.v4.content.res.f;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class l extends k {
    static final Mode a = Mode.SRC_IN;
    private r c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    l() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new r();
    }

    l(@NonNull r rVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = rVar;
        this.d = a(this.d, rVar.c, rVar.d);
    }

    static int a(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    private static Mode a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    @Nullable
    public static l a(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            l lVar = new l();
            lVar.b = d.a(resources, i, theme);
            lVar.h = new s(lVar.b.getConstantState());
            return lVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
        }
        return null;
    }

    public static l a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        l lVar = new l();
        lVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return lVar;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        r rVar = this.c;
        q qVar = rVar.b;
        rVar.d = a(f.a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            rVar.c = colorStateList;
        }
        rVar.e = f.a(typedArray, xmlPullParser, "autoMirrored", 5, rVar.e);
        qVar.d = f.a(typedArray, xmlPullParser, "viewportWidth", 7, qVar.d);
        qVar.e = f.a(typedArray, xmlPullParser, "viewportHeight", 8, qVar.e);
        if (qVar.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (qVar.e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            qVar.b = typedArray.getDimension(3, qVar.b);
            qVar.c = typedArray.getDimension(2, qVar.c);
            if (qVar.b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (qVar.c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                qVar.setAlpha(f.a(typedArray, xmlPullParser, "alpha", 4, qVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    qVar.g = string;
                    qVar.h.put(string, qVar);
                }
            }
        }
    }

    private boolean a() {
        return VERSION.SDK_INT >= 17 ? isAutoMirrored() && a.i(this) == 1 : false;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        r rVar = this.c;
        q qVar = rVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(qVar.a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                o oVar = (o) arrayDeque.peek();
                if ("path".equals(name)) {
                    n nVar = new n();
                    nVar.a(resources, attributeSet, theme, xmlPullParser);
                    oVar.a.add(nVar);
                    if (nVar.getPathName() != null) {
                        qVar.h.put(nVar.getPathName(), nVar);
                    }
                    obj2 = null;
                    rVar.a = nVar.o | rVar.a;
                } else if ("clip-path".equals(name)) {
                    m mVar = new m();
                    mVar.a(resources, attributeSet, theme, xmlPullParser);
                    oVar.a.add(mVar);
                    if (mVar.getPathName() != null) {
                        qVar.h.put(mVar.getPathName(), mVar);
                    }
                    rVar.a |= mVar.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        o oVar2 = new o();
                        oVar2.a(resources, attributeSet, theme, xmlPullParser);
                        oVar.a.add(oVar2);
                        arrayDeque.push(oVar2);
                        if (oVar2.getGroupName() != null) {
                            qVar.h.put(oVar2.getGroupName(), oVar2);
                        }
                        rVar.a |= oVar2.c;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            throw new XmlPullParserException("no path defined");
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object a(String str) {
        return this.c.b.h.get(str);
    }

    void a(boolean z) {
        this.g = z;
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            a.d(this.b);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.c.b(min, height);
                if (!this.g) {
                    this.c.a(min, height);
                } else if (!this.c.b()) {
                    this.c.a(min, height);
                    this.c.c();
                }
                this.c.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.b != null ? a.c(this.b) : this.c.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.b != null && VERSION.SDK_INT >= 24) {
            return new s(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : (int) this.c.b.c;
    }

    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : (int) this.c.b.b;
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            a.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        r rVar = this.c;
        rVar.b = new q();
        TypedArray a = f.a(resources, theme, attributeSet, a.a);
        a(a, xmlPullParser);
        a.recycle();
        rVar.a = getChangingConfigurations();
        rVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, rVar.c, rVar.d);
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.b != null ? a.b(this.b) : this.c.e;
    }

    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        } else if (!this.f && super.mutate() == this) {
            this.c = new r(this.c);
            this.f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        r rVar = this.c;
        if (rVar.c == null || rVar.d == null) {
            return false;
        }
        this.d = a(this.d, rVar.c, rVar.d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.c.b.getRootAlpha() != i) {
            this.c.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            a.a(this.b, z);
        } else {
            this.c.e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i) {
        if (this.b != null) {
            a.a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            a.a(this.b, colorStateList);
            return;
        }
        r rVar = this.c;
        if (rVar.c != colorStateList) {
            rVar.c = colorStateList;
            this.d = a(this.d, colorStateList, rVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            a.a(this.b, mode);
            return;
        }
        r rVar = this.c;
        if (rVar.d != mode) {
            rVar.d = mode;
            this.d = a(this.d, rVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.b != null ? this.b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
