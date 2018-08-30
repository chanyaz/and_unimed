package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v7.a.b;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;

class h extends AppCompatImageView implements ActionMenuChildView {
    final /* synthetic */ ActionMenuPresenter a;
    private final float[] b = new float[2];

    public h(final ActionMenuPresenter actionMenuPresenter, Context context) {
        this.a = actionMenuPresenter;
        super(context, null, b.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        de.a(this, getContentDescription());
        setOnTouchListener(new at(this) {
            public ShowableListMenu a() {
                return h.this.a.h == null ? null : h.this.a.h.b();
            }

            public boolean b() {
                h.this.a.c();
                return true;
            }

            public boolean c() {
                if (h.this.a.j != null) {
                    return false;
                }
                h.this.a.d();
                return true;
            }
        });
    }

    public boolean needsDividerAfter() {
        return false;
    }

    public boolean needsDividerBefore() {
        return false;
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.a.c();
        }
        return true;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            a.a(background, width - max, height - max, width + max, height + max);
        }
        return frame;
    }
}
