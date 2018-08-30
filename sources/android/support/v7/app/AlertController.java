package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.a.k;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

class AlertController {
    private int A;
    private boolean B = false;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I = 0;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R = 0;
    private final OnClickListener S = new OnClickListener() {
        public void onClick(View view) {
            Message obtain = (view != AlertController.this.c || AlertController.this.d == null) ? (view != AlertController.this.e || AlertController.this.f == null) ? (view != AlertController.this.g || AlertController.this.h == null) ? null : Message.obtain(AlertController.this.h) : Message.obtain(AlertController.this.f) : Message.obtain(AlertController.this.d);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.p.obtainMessage(1, AlertController.this.a).sendToTarget();
        }
    };
    final y a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k = -1;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;

    public class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public OnItemSelectedListener N;
        public OnPrepareListViewListener O;
        public boolean P = true;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public OnCancelListener s;
        public OnDismissListener t;
        public OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.a = context;
            this.r = true;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.b.inflate(alertController.l, null);
            if (!this.G) {
                int i = this.H ? alertController.n : alertController.o;
                simpleCursorAdapter = this.K != null ? new SimpleCursorAdapter(this.a, i, this.K, new String[]{this.L}, new int[]{16908308}) : this.w != null ? this.w : new h(this.a, i, 16908308, this.v);
            } else if (this.K == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this.a, alertController.m, 16908308, this.v) {
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (AlertParams.this.F != null && AlertParams.this.F[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final AlertController alertController2 = alertController;
                Object simpleCursorAdapter2 = new CursorAdapter(this.a, this.K, false) {
                    private final int d;
                    private final int e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.d));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.b.inflate(alertController2.m, viewGroup, false);
                    }
                };
            }
            if (this.O != null) {
                this.O.onPrepareListView(recycleListView);
            }
            alertController.j = simpleCursorAdapter2;
            alertController.k = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AlertParams.this.x.onClick(alertController.a, i);
                        if (!AlertParams.this.H) {
                            alertController.a.dismiss();
                        }
                    }
                });
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (AlertParams.this.F != null) {
                            AlertParams.this.F[i] = recycleListView.isItemChecked(i);
                        }
                        AlertParams.this.J.onClick(alertController.a, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            if (this.N != null) {
                recycleListView.setOnItemSelectedListener(this.N);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.b = recycleListView;
        }

        public void a(AlertController alertController) {
            if (this.g != null) {
                alertController.b(this.g);
            } else {
                if (this.f != null) {
                    alertController.a(this.f);
                }
                if (this.d != null) {
                    alertController.a(this.d);
                }
                if (this.c != 0) {
                    alertController.b(this.c);
                }
                if (this.e != 0) {
                    alertController.b(alertController.c(this.e));
                }
            }
            if (this.h != null) {
                alertController.b(this.h);
            }
            if (!(this.i == null && this.j == null)) {
                alertController.a(-1, this.i, this.k, null, this.j);
            }
            if (!(this.l == null && this.m == null)) {
                alertController.a(-2, this.l, this.n, null, this.m);
            }
            if (!(this.o == null && this.p == null)) {
                alertController.a(-3, this.o, this.q, null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            if (this.z != null) {
                if (this.E) {
                    alertController.a(this.z, this.A, this.B, this.C, this.D);
                    return;
                }
                alertController.c(this.z);
            } else if (this.y != 0) {
                alertController.a(this.y);
            }
        }
    }

    public class RecycleListView extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.RecycleListView);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(k.RecycleListView_paddingBottomNoButtons, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(k.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
            }
        }
    }

    public AlertController(Context context, y yVar, Window window) {
        this.q = context;
        this.a = yVar;
        this.r = window;
        this.p = new g(yVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, k.AlertDialog, b.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(k.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(k.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(k.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(k.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(k.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(k.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(k.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(k.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        yVar.a(1);
    }

    @Nullable
    private ViewGroup a(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    static void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.v != null ? this.v : this.w != 0 ? LayoutInflater.from(this.q).inflate(this.w, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && a(inflate))) {
            this.r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(g.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.r.findViewById(g.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(g.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ViewCompat.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.u != null) {
                this.i.setOnScrollChangeListener(new OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.a(nestedScrollView, findViewById, view2);
                    }
                });
                this.i.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.i, findViewById, view2);
                    }
                });
            } else if (this.b != null) {
                this.b.setOnScrollListener(new OnScrollListener() {
                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.a(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.b.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.b, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        return this.P == 0 ? this.O : this.R == 1 ? this.P : this.O;
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new LayoutParams(-1, -2));
            this.r.findViewById(g.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.t) ? 1 : 0) == 0 || !this.Q) {
            this.r.findViewById(g.title_template).setVisibility(8);
            this.K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.L = (TextView) this.r.findViewById(g.alertTitle);
        this.L.setText(this.t);
        if (this.I != 0) {
            this.K.setImageResource(this.I);
        } else if (this.J != null) {
            this.K.setImageDrawable(this.J);
        } else {
            this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
            this.K.setVisibility(8);
        }
    }

    private void c() {
        View findViewById = this.r.findViewById(g.parentPanel);
        View findViewById2 = findViewById.findViewById(g.topPanel);
        View findViewById3 = findViewById.findViewById(g.contentPanel);
        View findViewById4 = findViewById.findViewById(g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(g.customPanel);
        a(viewGroup);
        View findViewById5 = viewGroup.findViewById(g.topPanel);
        View findViewById6 = viewGroup.findViewById(g.contentPanel);
        View findViewById7 = viewGroup.findViewById(g.buttonPanel);
        ViewGroup a = a(findViewById5, findViewById2);
        ViewGroup a2 = a(findViewById6, findViewById3);
        ViewGroup a3 = a(findViewById7, findViewById4);
        c(a2);
        d(a3);
        b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById = a2.findViewById(g.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (z2) {
            if (this.i != null) {
                this.i.setClipToPadding(true);
            }
            findViewById = null;
            if (!(this.u == null && this.b == null)) {
                findViewById = a.findViewById(g.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById = a2.findViewById(g.textSpacerNoTitle);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (this.b instanceof RecycleListView) {
            ((RecycleListView) this.b).a(z2, z3);
        }
        if (!z) {
            findViewById3 = this.b != null ? this.b : this.i;
            if (findViewById3 != null) {
                a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.b;
        if (listView != null && this.j != null) {
            listView.setAdapter(this.j);
            int i = this.k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(g.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView) viewGroup.findViewById(16908299);
        if (this.M != null) {
            if (this.u != null) {
                this.M.setText(this.u);
                return;
            }
            this.M.setVisibility(8);
            this.i.removeView(this.M);
            if (this.b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.b, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.c = (Button) viewGroup.findViewById(16908313);
        this.c.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.C) && this.D == null) {
            this.c.setVisibility(8);
            i = 0;
        } else {
            this.c.setText(this.C);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.c.setVisibility(0);
            i = 1;
        }
        this.e = (Button) viewGroup.findViewById(16908314);
        this.e.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) && this.F == null) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(this.E);
            if (this.F != null) {
                this.F.setBounds(0, 0, this.s, this.s);
                this.e.setCompoundDrawables(this.F, null, null, null);
            }
            this.e.setVisibility(0);
            i |= 2;
        }
        this.g = (Button) viewGroup.findViewById(16908315);
        this.g.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) && this.H == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.G);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.g.setVisibility(0);
            i |= 4;
        }
        if (a(this.q)) {
            if (i == 1) {
                a(this.c);
            } else if (i == 2) {
                a(this.e);
            } else if (i == 4) {
                a(this.g);
            }
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        this.a.setContentView(b());
        c();
    }

    public void a(int i) {
        this.v = null;
        this.w = i;
        this.B = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.G = charSequence;
                this.h = message;
                this.H = drawable;
                return;
            case -2:
                this.E = charSequence;
                this.f = message;
                this.F = drawable;
                return;
            case -1:
                this.C = charSequence;
                this.d = message;
                this.D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        if (this.K == null) {
            return;
        }
        if (drawable != null) {
            this.K.setVisibility(0);
            this.K.setImageDrawable(drawable);
            return;
        }
        this.K.setVisibility(8);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        if (this.L != null) {
            this.L.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public void b(int i) {
        this.J = null;
        this.I = i;
        if (this.K == null) {
            return;
        }
        if (i != 0) {
            this.K.setVisibility(0);
            this.K.setImageResource(this.I);
            return;
        }
        this.K.setVisibility(8);
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        if (this.M != null) {
            this.M.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }
}
