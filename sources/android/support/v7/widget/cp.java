package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class cp {
    private Method a;
    private Method b;
    private Method c;

    cp() {
        try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
    }

    void a(AutoCompleteTextView autoCompleteTextView) {
        if (this.a != null) {
            try {
                this.a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.c != null) {
            try {
                this.c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }

    void b(AutoCompleteTextView autoCompleteTextView) {
        if (this.b != null) {
            try {
                this.b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }
}
