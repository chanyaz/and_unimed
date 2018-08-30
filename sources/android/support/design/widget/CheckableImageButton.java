package android.support.design.widget;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v7.a.b;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

@RestrictTo({Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] a = new int[]{16842912};
    private boolean b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewCompat.a((View) this, new a() {
            public void a(View view, android.support.v4.view.accessibility.b bVar) {
                super.a(view, bVar);
                bVar.a(true);
                bVar.b(CheckableImageButton.this.isChecked());
            }

            public void a(View view, AccessibilityEvent accessibilityEvent) {
                super.a(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public boolean isChecked() {
        return this.b;
    }

    public int[] onCreateDrawableState(int i) {
        return this.b ? mergeDrawableStates(super.onCreateDrawableState(a.length + i), a) : super.onCreateDrawableState(i);
    }

    public void setChecked(boolean z) {
        if (this.b != z) {
            this.b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        setChecked(!this.b);
    }
}
