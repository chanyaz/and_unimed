package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.SpinnerAdapter;

class ac extends ListPopupWindow {
    ListAdapter a;
    final /* synthetic */ AppCompatSpinner b;
    private CharSequence h;
    private final Rect i = new Rect();

    public ac(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
        this.b = appCompatSpinner;
        super(context, attributeSet, i);
        b((View) appCompatSpinner);
        a(true);
        a(0);
        a(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ac.this.b.setSelection(i);
                if (ac.this.b.getOnItemClickListener() != null) {
                    ac.this.b.performItemClick(view, i, ac.this.a.getItemId(i));
                }
                ac.this.dismiss();
            }
        });
    }

    public CharSequence a() {
        return this.h;
    }

    public void a(ListAdapter listAdapter) {
        super.a(listAdapter);
        this.a = listAdapter;
    }

    public void a(CharSequence charSequence) {
        this.h = charSequence;
    }

    boolean a(View view) {
        return ViewCompat.B(view) && view.getGlobalVisibleRect(this.i);
    }

    void b() {
        int i;
        Drawable d = d();
        if (d != null) {
            d.getPadding(this.b.i);
            i = dk.a(this.b) ? this.b.i.right : -this.b.i.left;
        } else {
            Rect b = this.b.i;
            this.b.i.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.b.getPaddingLeft();
        int paddingRight = this.b.getPaddingRight();
        int width = this.b.getWidth();
        if (this.b.h == -2) {
            int a = this.b.a((SpinnerAdapter) this.a, d());
            int i2 = (this.b.getContext().getResources().getDisplayMetrics().widthPixels - this.b.i.left) - this.b.i.right;
            if (a <= i2) {
                i2 = a;
            }
            g(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.b.h == -1) {
            g((width - paddingLeft) - paddingRight);
        } else {
            g(this.b.h);
        }
        c(dk.a(this.b) ? ((width - paddingRight) - h()) + i : i + paddingLeft);
    }

    public void show() {
        boolean isShowing = isShowing();
        b();
        h(2);
        super.a();
        getListView().setChoiceMode(1);
        i(this.b.getSelectedItemPosition());
        if (!isShowing) {
            ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
            if (viewTreeObserver != null) {
                final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (ac.this.a(ac.this.b)) {
                            ac.this.b();
                            super.a();
                            return;
                        }
                        ac.this.dismiss();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                a(new OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = ac.this.b.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                        }
                    }
                });
            }
        }
    }
}
