package android.support.design.widget;

import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class al extends a {
    final /* synthetic */ TextInputLayout a;

    al(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.b(TextInputLayout.class.getSimpleName());
        CharSequence j = this.a.d.j();
        if (!TextUtils.isEmpty(j)) {
            bVar.c(j);
        }
        if (this.a.a != null) {
            bVar.d(this.a.a);
        }
        j = this.a.b != null ? this.a.b.getText() : null;
        if (!TextUtils.isEmpty(j)) {
            bVar.l(true);
            bVar.e(j);
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        CharSequence j = this.a.d.j();
        if (!TextUtils.isEmpty(j)) {
            accessibilityEvent.getText().add(j);
        }
    }
}
