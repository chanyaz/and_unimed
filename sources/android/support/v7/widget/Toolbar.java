package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.d;
import android.support.v4.view.h;
import android.support.v7.a.b;
import android.support.v7.a.k;
import android.support.v7.view.f;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.l;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener H;
    private dd I;
    private ActionMenuPresenter J;
    private dc K;
    private Callback L;
    private MenuBuilder.Callback M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    OnMenuItemClickListener d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private cj u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.b = 0;
            this.a = i3;
        }

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.b = 0;
            this.b = layoutParams.b;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        boolean b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, b.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new android.support.v7.widget.ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return Toolbar.this.d != null ? Toolbar.this.d.onMenuItemClick(menuItem) : false;
            }
        };
        this.O = new Runnable() {
            public void run() {
                Toolbar.this.d();
            }
        };
        db a = db.a(getContext(), attributeSet, k.Toolbar, i, 0);
        this.n = a.g(k.Toolbar_titleTextAppearance, 0);
        this.o = a.g(k.Toolbar_subtitleTextAppearance, 0);
        this.x = a.c(k.Toolbar_android_gravity, this.x);
        this.c = a.c(k.Toolbar_buttonGravity, 48);
        int d = a.d(k.Toolbar_titleMargin, 0);
        if (a.g(k.Toolbar_titleMargins)) {
            d = a.d(k.Toolbar_titleMargins, d);
        }
        this.t = d;
        this.s = d;
        this.r = d;
        this.q = d;
        d = a.d(k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.q = d;
        }
        d = a.d(k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.r = d;
        }
        d = a.d(k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.s = d;
        }
        d = a.d(k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.t = d;
        }
        this.p = a.e(k.Toolbar_maxButtonHeight, -1);
        d = a.d(k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.d(k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.e(k.Toolbar_contentInsetLeft, 0);
        int e2 = a.e(k.Toolbar_contentInsetRight, 0);
        t();
        this.u.b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.u.a(d, d2);
        }
        this.v = a.d(k.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a.d(k.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = a.a(k.Toolbar_collapseIcon);
        this.k = a.c(k.Toolbar_collapseContentDescription);
        CharSequence c = a.c(k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.c(k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.l = getContext();
        setPopupTheme(a.g(k.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.c(k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.a(k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.c(k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.g(k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.b(k.Toolbar_titleTextColor, -1));
        }
        if (a.g(k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.b(k.Toolbar_subtitleTextColor, -1));
        }
        a.a();
    }

    private int a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.x & 112;
        }
    }

    private int a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(layoutParams.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i6 = layoutParams.leftMargin - i6;
            i = layoutParams.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = generateLayoutParams(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.b == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.F.add(view);
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ViewCompat.f(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = d.a(i, ViewCompat.f(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b == 0 && a(childAt) && b(layoutParams.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.b == 0 && a(childAt2) && b(layoutParams.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int f = ViewCompat.f(this);
        int a = d.a(i, f) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return f == 1 ? 5 : 3;
        }
    }

    private int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return h.b(marginLayoutParams) + h.a(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new f(getContext());
    }

    private void n() {
        if (this.i == null) {
            this.i = new AppCompatImageView(getContext());
        }
    }

    private void o() {
        p();
        if (this.e.d() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.e.getMenu();
            if (this.K == null) {
                this.K = new dc(this);
            }
            this.e.setExpandedActionViewsExclusive(true);
            menuBuilder.a(this.K, this.l);
        }
    }

    private void p() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            android.view.ViewGroup.LayoutParams k = generateDefaultLayoutParams();
            k.a = 8388613 | (this.c & 112);
            this.e.setLayoutParams(k);
            a(this.e, false);
        }
    }

    private void q() {
        if (this.h == null) {
            this.h = new AppCompatImageButton(getContext(), null, b.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams k = generateDefaultLayoutParams();
            k.a = 8388611 | (this.c & 112);
            this.h.setLayoutParams(k);
        }
    }

    private void r() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean s() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void t() {
        if (this.u == null) {
            this.u = new cj();
        }
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams ? new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void a(int i, int i2) {
        t();
        this.u.a(i, i2);
    }

    public void a(Context context, @StyleRes int i) {
        this.n = i;
        if (this.f != null) {
            this.f.setTextAppearance(context, i);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.e != null) {
            p();
            MenuBuilder d = this.e.d();
            if (d != menuBuilder) {
                if (d != null) {
                    d.b(this.J);
                    d.b(this.K);
                }
                if (this.K == null) {
                    this.K = new dc(this);
                }
                actionMenuPresenter.b(true);
                if (menuBuilder != null) {
                    menuBuilder.a((MenuPresenter) actionMenuPresenter, this.l);
                    menuBuilder.a(this.K, this.l);
                } else {
                    actionMenuPresenter.initForMenu(this.l, null);
                    this.K.initForMenu(this.l, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.K.updateMenuView(true);
                }
                this.e.setPopupTheme(this.m);
                this.e.setPresenter(actionMenuPresenter);
                this.J = actionMenuPresenter;
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Callback callback, MenuBuilder.Callback callback2) {
        this.L = callback;
        this.M = callback2;
        if (this.e != null) {
            this.e.a(callback, callback2);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, @StyleRes int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean c() {
        return this.e != null && this.e.h();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean g() {
        if (this.f == null) {
            return false;
        }
        Layout layout = this.f.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public int getContentInsetEnd() {
        return this.u != null ? this.u.d() : 0;
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.u != null ? this.u.a() : 0;
    }

    public int getContentInsetRight() {
        return this.u != null ? this.u.b() : 0;
    }

    public int getContentInsetStart() {
        return this.u != null ? this.u.c() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.e != null) {
            MenuBuilder d = this.e.d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        return i != 0 ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return ViewCompat.f(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ViewCompat.f(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.i != null ? this.i.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.i != null ? this.i.getContentDescription() : null;
    }

    public Menu getMenu() {
        o();
        return this.e.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        return this.h != null ? this.h.getContentDescription() : null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        return this.h != null ? this.h.getDrawable() : null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.J;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        o();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public DecorToolbar getWrapper() {
        if (this.I == null) {
            this.I = new dd(this, true);
        }
        return this.I;
    }

    public boolean h() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    public void i() {
        l lVar = this.K == null ? null : this.K.b;
        if (lVar != null) {
            lVar.collapseActionView();
        }
    }

    void j() {
        if (this.a == null) {
            this.a = new AppCompatImageButton(getContext(), null, b.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            android.view.ViewGroup.LayoutParams k = generateDefaultLayoutParams();
            k.a = 8388611 | (this.c & 112);
            k.b = 2;
            this.a.setLayoutParams(k);
            this.a.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.i();
                }
            });
        }
    }

    /* renamed from: k */
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    void l() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).b == 2 || childAt == this.e)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void m() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int measuredHeight;
        int measuredWidth;
        Object obj = ViewCompat.f(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int k = ViewCompat.k(this);
        int min = k >= 0 ? Math.min(k, i4 - i2) : 0;
        if (!a(this.h)) {
            k = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            k = b(this.h, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = a(this.h, paddingLeft, iArr, min);
            k = i6;
        }
        if (a(this.a)) {
            if (obj != null) {
                k = b(this.a, k, iArr, min);
            } else {
                i5 = a(this.a, i5, iArr, min);
            }
        }
        if (a(this.e)) {
            if (obj != null) {
                i5 = a(this.e, i5, iArr, min);
            } else {
                k = b(this.e, k, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - k));
        i5 = Math.max(i5, currentContentInsetLeft);
        k = Math.min(k, (width - paddingRight) - currentContentInsetRight);
        if (a(this.b)) {
            if (obj != null) {
                k = b(this.b, k, iArr, min);
            } else {
                i5 = a(this.b, i5, iArr, min);
            }
        }
        if (!a(this.i)) {
            currentContentInsetLeft = k;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = b(this.i, k, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = k;
            currentContentInsetRight = a(this.i, i5, iArr, min);
        }
        boolean a = a(this.f);
        boolean a2 = a(this.g);
        i5 = 0;
        if (a) {
            layoutParams = (LayoutParams) this.f.getLayoutParams();
            i5 = 0 + (layoutParams.bottomMargin + (layoutParams.topMargin + this.f.getMeasuredHeight()));
        }
        if (a2) {
            layoutParams = (LayoutParams) this.g.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.g.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (a ? this.f : this.g).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (a2 ? this.g : this.f).getLayoutParams();
            Object obj2 = ((!a || this.f.getMeasuredWidth() <= 0) && (!a2 || this.g.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.x & 112) {
                case 48:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.s;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.t) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.s) {
                        k = layoutParams.topMargin + this.s;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        k = measuredHeight < layoutParams.bottomMargin + this.t ? Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.t) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + k;
                    break;
            }
            if (obj != null) {
                k = (obj2 != null ? this.q : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, k);
                iArr[1] = Math.max(0, -k);
                if (a) {
                    layoutParams = (LayoutParams) this.f.getLayoutParams();
                    measuredWidth = i5 - this.f.getMeasuredWidth();
                    currentContentInsetLeft = this.f.getMeasuredHeight() + paddingTop2;
                    this.f.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + layoutParams.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.r;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    layoutParams = (LayoutParams) this.g.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop2;
                    measuredHeight = this.g.getMeasuredHeight() + measuredWidth;
                    this.g.layout(i5 - this.g.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    k = layoutParams.bottomMargin + measuredHeight;
                    k = i5 - this.r;
                } else {
                    k = i5;
                }
                currentContentInsetLeft = obj2 != null ? Math.min(currentContentInsetLeft, k) : i5;
            } else {
                k = (obj2 != null ? this.q : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, k);
                iArr[0] = Math.max(0, -k);
                if (a) {
                    layoutParams = (LayoutParams) this.f.getLayoutParams();
                    i5 = this.f.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f.getMeasuredHeight() + paddingTop2;
                    this.f.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    k = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.r;
                    i5 = k;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    layoutParams = (LayoutParams) this.g.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop2 = this.g.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.g.getMeasuredHeight() + i5;
                    this.g.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    k = layoutParams.bottomMargin + measuredHeight;
                    k = this.r + paddingTop2;
                } else {
                    k = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, k);
                }
            }
        }
        a(this.E, 3);
        int size = this.E.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = a((View) this.E.get(measuredWidth), i5, iArr, min);
        }
        a(this.E, 5);
        currentContentInsetRight = this.E.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = b((View) this.E.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        a(this.E, 1);
        measuredWidth = a(this.E, iArr);
        k = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += k;
        if (k < i5) {
            k = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            k -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.E.size();
        measuredWidth = k;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = a((View) this.E.get(i5), measuredWidth, iArr, min);
        }
        this.E.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.G;
        if (dk.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            i7 = this.h.getMeasuredWidth() + b(this.h);
            max = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            i6 = View.combineMeasuredStates(0, this.h.getMeasuredState());
            i5 = max;
        }
        if (a(this.a)) {
            a(this.a, i, 0, i2, 0, this.p);
            i7 = this.a.getMeasuredWidth() + b(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            i6 = View.combineMeasuredStates(i6, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (a(this.e)) {
            a(this.e, i, max2, i2, 0, this.p);
            i7 = this.e.getMeasuredWidth() + b(this.e);
            i5 = Math.max(i5, this.e.getMeasuredHeight() + c(this.e));
            i6 = View.combineMeasuredStates(i6, this.e.getMeasuredState());
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (a(this.b)) {
            max2 += a(this.b, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + c(this.b));
            i6 = View.combineMeasuredStates(i6, this.b.getMeasuredState());
        }
        if (a(this.i)) {
            max2 += a(this.i, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + c(this.i));
            i6 = View.combineMeasuredStates(i6, this.i.getMeasuredState());
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i7 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.s + this.t;
        max = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = b(this.f) + this.f.getMeasuredWidth();
            i7 = this.f.getMeasuredHeight() + c(this.f);
            i5 = View.combineMeasuredStates(i5, this.f.getMeasuredState());
        }
        if (a(this.g)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, a(this.g, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.g.getMeasuredHeight() + c(this.g);
            i5 = View.combineMeasuredStates(i5, this.g.getMeasuredState());
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = View.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, CtaButton.BACKGROUND_COLOR & i5);
        i7 = View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (s()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            Menu d = this.e != null ? this.e.d() : null;
            if (!(savedState.a == 0 || this.K == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.a);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (savedState.b) {
                r();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        t();
        cj cjVar = this.u;
        if (i != 1) {
            z = false;
        }
        cjVar.a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.K == null || this.K.b == null)) {
            savedState.a = this.K.b.getItemId();
        }
        savedState.b = b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            n();
            if (!d(this.i)) {
                a(this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            q();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(android.support.v7.c.a.b.b(getContext(), i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            q();
            if (!d(this.h)) {
                a(this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        q();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.d = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        o();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new AppCompatTextView(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a(this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.B = i;
        if (this.g != null) {
            this.g.setTextColor(i);
        }
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new AppCompatTextView(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a(this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.A = i;
        if (this.f != null) {
            this.f.setTextColor(i);
        }
    }
}
