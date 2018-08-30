package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.z;
import android.support.v7.a.b;
import android.support.v7.a.k;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private OnItemClickListener B;
    private OnItemSelectedListener C;
    private final bj D;
    private final bi E;
    private final bg F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ao c;
    int d;
    final bk e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, b.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, b.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = MoPubClientPositioning.NO_REPEAT;
        this.x = 0;
        this.e = new bk(this);
        this.D = new bj(this);
        this.E = new bi(this);
        this.F = new bg(this);
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }

    private void a() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private int b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() {
                public void run() {
                    View e = ListPopupWindow.this.e();
                    if (e != null && e.getWindowToken() != null) {
                        ListPopupWindow.this.a();
                    }
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        ao aoVar = ListPopupWindow.this.c;
                        if (aoVar != null) {
                            aoVar.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            View view2 = this.c;
            View view3 = this.w;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i = this.l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.g.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            view = this.w;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (this.p) {
                i4 = i2;
            } else {
                this.n = -this.H.top;
                i4 = i2;
            }
        } else {
            this.H.setEmpty();
            i4 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z = false;
        }
        i = a(e(), this.n, z);
        if (this.u || this.k == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.l, 1073741824);
                break;
        }
        i2 = this.c.a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.c.getPaddingTop() + this.c.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    private void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    @NonNull
    ao a(Context context, boolean z) {
        return new ao(context, z);
    }

    public void a(int i) {
        this.x = i;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(@Nullable Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(@Nullable OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(@Nullable ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new bh(this);
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(@Nullable OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public void b(@StyleRes int i) {
        this.g.setAnimationStyle(i);
    }

    public void b(@Nullable View view) {
        this.z = view;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    public void c(int i) {
        this.m = i;
    }

    public boolean c() {
        return this.J;
    }

    @Nullable
    public Drawable d() {
        return this.g.getBackground();
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    public void dismiss() {
        this.g.dismiss();
        a();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    @Nullable
    public View e() {
        return this.z;
    }

    public void e(int i) {
        this.t = i;
    }

    public int f() {
        return this.m;
    }

    public void f(int i) {
        this.l = i;
    }

    public int g() {
        return !this.p ? 0 : this.n;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = (this.H.left + this.H.right) + i;
            return;
        }
        f(i);
    }

    @Nullable
    public ListView getListView() {
        return this.c;
    }

    public int h() {
        return this.l;
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public void i() {
        ao aoVar = this.c;
        if (aoVar != null) {
            aoVar.setListSelectionHidden(true);
            aoVar.requestLayout();
        }
    }

    public void i(int i) {
        ao aoVar = this.c;
        if (isShowing() && aoVar != null) {
            aoVar.setListSelectionHidden(false);
            aoVar.setSelection(i);
            if (aoVar.getChoiceMode() != 0) {
                aoVar.setItemChecked(i, true);
            }
        }
    }

    public boolean isShowing() {
        return this.g.isShowing();
    }

    public boolean j() {
        return this.g.getInputMethodMode() == 2;
    }

    /* renamed from: show */
    public void a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = b();
        boolean j = j();
        z.a(this.g, this.o);
        PopupWindow popupWindow;
        if (!this.g.isShowing()) {
            int width = this.l == -1 ? -1 : this.l == -2 ? e().getWidth() : this.l;
            if (this.k == -1) {
                b = -1;
            } else if (this.k != -2) {
                b = this.k;
            }
            this.g.setWidth(width);
            this.g.setHeight(b);
            c(true);
            popupWindow = this.g;
            if (this.v || this.u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.g.setTouchInterceptor(this.D);
            if (this.s) {
                z.a(this.g, this.r);
            }
            if (h != null) {
                try {
                    h.invoke(this.g, new Object[]{this.I});
                } catch (Throwable e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            z.a(this.g, e(), this.m, this.n, this.t);
            this.c.setSelection(-1);
            if (!this.J || this.c.isInTouchMode()) {
                i();
            }
            if (!this.J) {
                this.f.post(this.F);
            }
        } else if (ViewCompat.B(e())) {
            int i2;
            int width2 = this.l == -1 ? -1 : this.l == -2 ? e().getWidth() : this.l;
            if (this.k == -1) {
                if (!j) {
                    b = -1;
                }
                if (j) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                    i2 = b;
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                    i2 = b;
                }
            } else {
                i2 = this.k == -2 ? b : this.k;
            }
            popupWindow = this.g;
            if (!(this.v || this.u)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.g;
            View e2 = e();
            b = this.m;
            int i3 = this.n;
            if (width2 < 0) {
                width2 = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(e2, b, i3, width2, i);
        }
    }
}
