package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.content.res.f;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class m extends p {
    public m(m mVar) {
        super(mVar);
    }

    private void a(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.n = string;
        }
        string = typedArray.getString(1);
        if (string != null) {
            this.m = b.b(string);
        }
    }

    public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        if (f.a(xmlPullParser, "pathData")) {
            TypedArray a = f.a(resources, theme, attributeSet, a.d);
            a(a);
            a.recycle();
        }
    }

    public boolean a() {
        return true;
    }
}
