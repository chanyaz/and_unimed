package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.design.i;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.q;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.a;
import android.support.v7.c.a.b;
import android.support.v7.widget.de;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class aj extends LinearLayout {
    final /* synthetic */ TabLayout a;
    private ah b;
    private TextView c;
    private ImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    private int h = 2;

    public aj(TabLayout tabLayout, Context context) {
        this.a = tabLayout;
        super(context);
        if (tabLayout.i != 0) {
            ViewCompat.a((View) this, b.b(context, tabLayout.i));
        }
        ViewCompat.b(this, tabLayout.a, tabLayout.b, tabLayout.c, tabLayout.d);
        setGravity(17);
        setOrientation(1);
        setClickable(true);
        ViewCompat.a((View) this, q.a(getContext(), 1002));
    }

    private float a(Layout layout, int i, float f) {
        return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
    }

    private void a(@Nullable TextView textView, @Nullable ImageView imageView) {
        CharSequence charSequence = null;
        Drawable c = this.b != null ? this.b.c() : null;
        CharSequence e = this.b != null ? this.b.e() : null;
        CharSequence h = this.b != null ? this.b.h() : null;
        if (imageView != null) {
            if (c != null) {
                imageView.setImageDrawable(c);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(h);
        }
        int i = !TextUtils.isEmpty(e) ? 1 : 0;
        if (textView != null) {
            if (i != 0) {
                textView.setText(e);
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
            textView.setContentDescription(h);
        }
        if (imageView != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            int b = (i == 0 || imageView.getVisibility() != 0) ? 0 : this.a.b(8);
            if (b != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = b;
                imageView.requestLayout();
            }
        }
        if (i == 0) {
            charSequence = h;
        }
        de.a(this, charSequence);
    }

    void a() {
        a(null);
        setSelected(false);
    }

    void a(@Nullable ah ahVar) {
        if (ahVar != this.b) {
            this.b = ahVar;
            b();
        }
    }

    final void b() {
        ah ahVar = this.b;
        View b = ahVar != null ? ahVar.b() : null;
        if (b != null) {
            aj parent = b.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(b);
                }
                addView(b);
            }
            this.e = b;
            if (this.c != null) {
                this.c.setVisibility(8);
            }
            if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setImageDrawable(null);
            }
            this.f = (TextView) b.findViewById(16908308);
            if (this.f != null) {
                this.h = TextViewCompat.a(this.f);
            }
            this.g = (ImageView) b.findViewById(16908294);
        } else {
            if (this.e != null) {
                removeView(this.e);
                this.e = null;
            }
            this.f = null;
            this.g = null;
        }
        if (this.e == null) {
            if (this.d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(i.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.d = imageView;
            }
            if (this.c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(i.design_layout_tab_text, this, false);
                addView(textView);
                this.c = textView;
                this.h = TextViewCompat.a(this.c);
            }
            TextViewCompat.a(this.c, this.a.e);
            if (this.a.f != null) {
                this.c.setTextColor(this.a.f);
            }
            a(this.c, this.d);
        } else if (!(this.f == null && this.g == null)) {
            a(this.f, this.g);
        }
        boolean z = ahVar != null && ahVar.g();
        setSelected(z);
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
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int tabMaxWidth = this.a.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = MeasureSpec.makeMeasureSpec(this.a.j, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            getResources();
            float f = this.a.g;
            size = this.h;
            if (this.d != null && this.d.getVisibility() == 0) {
                size = 1;
            } else if (this.c != null && this.c.getLineCount() > 1) {
                f = this.a.h;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int a = TextViewCompat.a(this.c);
            if (f != textSize || (a >= 0 && size != a)) {
                if (this.a.l == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.c.getLayout();
                    if (layout == null || a(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.c.setTextSize(0, f);
                    this.c.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (this.b == null) {
            return performClick;
        }
        if (!performClick) {
            playSoundEffect(0);
        }
        this.b.f();
        return true;
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z && VERSION.SDK_INT < 16) {
            sendAccessibilityEvent(4);
        }
        if (this.c != null) {
            this.c.setSelected(z);
        }
        if (this.d != null) {
            this.d.setSelected(z);
        }
        if (this.e != null) {
            this.e.setSelected(z);
        }
    }
}
