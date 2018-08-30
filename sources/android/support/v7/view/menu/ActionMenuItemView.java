package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.a.k;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.at;
import android.support.v7.widget.de;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionMenuItemView extends AppCompatTextView implements ItemView, ActionMenuChildView, OnClickListener {
    l b;
    ItemInvoker c;
    c d;
    private CharSequence e;
    private Drawable f;
    private at g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.h = b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionMenuItemView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    private boolean b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || ((i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2);
    }

    private void c() {
        int i = 0;
        CharSequence charSequence = null;
        int i2 = !TextUtils.isEmpty(this.e) ? 1 : 0;
        if (this.f == null || (this.b.l() && (this.h || this.i))) {
            i = 1;
        }
        int i3 = i2 & i;
        setText(i3 != 0 ? this.e : null);
        CharSequence contentDescription = this.b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(i3 != 0 ? null : this.b.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        contentDescription = this.b.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (i3 == 0) {
                charSequence = this.b.getTitle();
            }
            de.a(this, charSequence);
            return;
        }
        de.a(this, contentDescription);
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    public l getItemData() {
        return this.b;
    }

    public void initialize(l lVar, int i) {
        this.b = lVar;
        setIcon(lVar.getIcon());
        setTitle(lVar.a((ItemView) this));
        setId(lVar.getItemId());
        setVisibility(lVar.isVisible() ? 0 : 8);
        setEnabled(lVar.isEnabled());
        if (lVar.hasSubMenu() && this.g == null) {
            this.g = new b(this);
        }
    }

    public boolean needsDividerAfter() {
        return a();
    }

    public boolean needsDividerBefore() {
        return a() && this.b.getIcon() == null;
    }

    public void onClick(View view) {
        if (this.c != null) {
            this.c.invokeItem(this.b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = b();
        c();
    }

    protected void onMeasure(int i, int i2) {
        boolean a = a();
        if (a && this.k >= 0) {
            super.setPadding(this.k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!a && this.f != null) {
            super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.b.hasSubMenu() && this.g != null && this.g.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            if (this.b != null) {
                this.b.g();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.l) {
                f = ((float) this.l) / ((float) intrinsicWidth);
                intrinsicWidth = this.l;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.l) {
                f = ((float) this.l) / ((float) intrinsicHeight);
                intrinsicHeight = this.l;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        c();
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.c = itemInvoker;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(c cVar) {
        this.d = cVar;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        c();
    }

    public boolean showsIcon() {
        return true;
    }
}
