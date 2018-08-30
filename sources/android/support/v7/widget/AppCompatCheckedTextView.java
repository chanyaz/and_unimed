package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private final ad b;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(cy.a(context), attributeSet, i);
        this.b = ad.a((TextView) this);
        this.b.a(attributeSet, i);
        this.b.a();
        db a = db.a(getContext(), attributeSet, a, i, 0);
        setCheckMarkDrawable(a.a(0));
        a.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return x.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(@DrawableRes int i) {
        setCheckMarkDrawable(b.b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.b != null) {
            this.b.a(context, i);
        }
    }
}
