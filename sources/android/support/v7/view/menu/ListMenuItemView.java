package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.a.h;
import android.support.v7.a.k;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.db;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ListMenuItemView extends LinearLayout implements ItemView {
    private l a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private Drawable h;
    private int i;
    private Context j;
    private boolean k;
    private Drawable l;
    private int m;
    private LayoutInflater n;
    private boolean o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        db a = db.a(getContext(), attributeSet, k.MenuView, i, 0);
        this.h = a.a(k.MenuView_android_itemBackground);
        this.i = a.g(k.MenuView_android_itemTextAppearance, -1);
        this.k = a.a(k.MenuView_preserveIconSpacing, false);
        this.j = context;
        this.l = a.a(k.MenuView_subMenuArrow);
        a.a();
    }

    private void a() {
        this.b = (ImageView) getInflater().inflate(h.abc_list_menu_item_icon, this, false);
        addView(this.b, 0);
    }

    private void b() {
        this.c = (RadioButton) getInflater().inflate(h.abc_list_menu_item_radio, this, false);
        addView(this.c);
    }

    private void c() {
        this.e = (CheckBox) getInflater().inflate(h.abc_list_menu_item_checkbox, this, false);
        addView(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.n == null) {
            this.n = LayoutInflater.from(getContext());
        }
        return this.n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public l getItemData() {
        return this.a;
    }

    public void initialize(l lVar, int i) {
        this.a = lVar;
        this.m = i;
        setVisibility(lVar.isVisible() ? 0 : 8);
        setTitle(lVar.a((ItemView) this));
        setCheckable(lVar.isCheckable());
        setShortcut(lVar.e(), lVar.c());
        setIcon(lVar.getIcon());
        setEnabled(lVar.isEnabled());
        setSubMenuArrowVisible(lVar.hasSubMenu());
        setContentDescription(lVar.getContentDescription());
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.a((View) this, this.h);
        this.d = (TextView) findViewById(g.title);
        if (this.i != -1) {
            this.d.setTextAppearance(this.j, this.i);
        }
        this.f = (TextView) findViewById(g.shortcut);
        this.g = (ImageView) findViewById(g.submenuarrow);
        if (this.g != null) {
            this.g.setImageDrawable(this.l);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        if (z || this.c != null || this.e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.a.f()) {
                if (this.c == null) {
                    b();
                }
                compoundButton = this.c;
                compoundButton2 = this.e;
            } else {
                if (this.e == null) {
                    c();
                }
                compoundButton = this.e;
                compoundButton2 = this.c;
            }
            if (z) {
                compoundButton.setChecked(this.a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.f()) {
            if (this.c == null) {
                b();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.o = z;
        this.k = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.a.h() || this.o) ? 1 : 0;
        if (i == 0 && !this.k) {
            return;
        }
        if (this.b != null || drawable != null || this.k) {
            if (this.b == null) {
                a();
            }
            if (drawable != null || this.k) {
                ImageView imageView = this.b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.b.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void setShortcut(boolean z, char c) {
        int i = (z && this.a.e()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.a.d());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public boolean showsIcon() {
        return this.o;
    }
}
