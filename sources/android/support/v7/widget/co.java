package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.b;
import android.support.v7.app.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class co extends LinearLayout {
    final /* synthetic */ cl a;
    private final int[] b = new int[]{16842964};
    private a c;
    private TextView d;
    private ImageView e;
    private View f;

    public co(cl clVar, Context context, a aVar, boolean z) {
        this.a = clVar;
        super(context, null, b.actionBarTabStyle);
        this.c = aVar;
        db a = db.a(context, null, this.b, b.actionBarTabStyle, 0);
        if (a.g(0)) {
            setBackgroundDrawable(a.a(0));
        }
        a.a();
        if (z) {
            setGravity(8388627);
        }
        a();
    }

    public void a() {
        a aVar = this.c;
        View c = aVar.c();
        if (c != null) {
            co parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f = c;
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
                return;
            }
            return;
        }
        View appCompatImageView;
        LayoutParams layoutParams;
        if (this.f != null) {
            removeView(this.f);
            this.f = null;
        }
        Drawable a = aVar.a();
        CharSequence b = aVar.b();
        if (a != null) {
            if (this.e == null) {
                appCompatImageView = new AppCompatImageView(getContext());
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                appCompatImageView.setLayoutParams(layoutParams);
                addView(appCompatImageView, 0);
                this.e = appCompatImageView;
            }
            this.e.setImageDrawable(a);
            this.e.setVisibility(0);
        } else if (this.e != null) {
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
        }
        int i = !TextUtils.isEmpty(b) ? 1 : 0;
        if (i != 0) {
            if (this.d == null) {
                appCompatImageView = new AppCompatTextView(getContext(), null, b.actionBarTabTextStyle);
                appCompatImageView.setEllipsize(TruncateAt.END);
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                appCompatImageView.setLayoutParams(layoutParams);
                addView(appCompatImageView);
                this.d = appCompatImageView;
            }
            this.d.setText(b);
            this.d.setVisibility(0);
        } else if (this.d != null) {
            this.d.setVisibility(8);
            this.d.setText(null);
        }
        if (this.e != null) {
            this.e.setContentDescription(aVar.e());
        }
        de.a(this, i != 0 ? null : aVar.e());
    }

    public void a(a aVar) {
        this.c = aVar;
        a();
    }

    public a b() {
        return this.c;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(a.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.class.getName());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a.c > 0 && getMeasuredWidth() > this.a.c) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.a.c, 1073741824), i2);
        }
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }
}
