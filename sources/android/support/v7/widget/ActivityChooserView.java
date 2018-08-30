package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.b;
import android.support.v7.a.e;
import android.support.v7.a.g;
import android.support.v7.a.h;
import android.support.v7.a.i;
import android.support.v7.a.k;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ActivityChooserModel.ActivityChooserModelClient;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModelClient {
    final q a;
    final FrameLayout b;
    final FrameLayout c;
    ActionProvider d;
    final DataSetObserver e;
    OnDismissListener f;
    boolean g;
    int h;
    private final r i;
    private final View j;
    private final Drawable k;
    private final ImageView l;
    private final ImageView m;
    private final int n;
    private final OnGlobalLayoutListener o;
    private ListPopupWindow p;
    private boolean q;
    private int r;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class InnerLayout extends LinearLayout {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            db a = db.a(context, attributeSet, a);
            setBackgroundDrawable(a.a(0));
            a.a();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.a.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.a.notifyDataSetInvalidated();
            }
        };
        this.o = new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.c()) {
                    return;
                }
                if (ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.d != null) {
                        ActivityChooserView.this.d.a(true);
                        return;
                    }
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().dismiss();
            }
        };
        this.h = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActivityChooserView, i, 0);
        this.h = obtainStyledAttributes.getInt(k.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.abc_activity_chooser_view, this, true);
        this.i = new r(this);
        this.j = findViewById(g.activity_chooser_view_content);
        this.k = this.j.getBackground();
        this.c = (FrameLayout) findViewById(g.default_activity_button);
        this.c.setOnClickListener(this.i);
        this.c.setOnLongClickListener(this.i);
        this.m = (ImageView) this.c.findViewById(g.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(g.expand_activities_button);
        frameLayout.setOnClickListener(this.i);
        frameLayout.setAccessibilityDelegate(new AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                b.a(accessibilityNodeInfo).m(true);
            }
        });
        frameLayout.setOnTouchListener(new at(frameLayout) {
            public ShowableListMenu a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            protected boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            protected boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.b = frameLayout;
        this.l = (ImageView) frameLayout.findViewById(g.image);
        this.l.setImageDrawable(drawable);
        this.a = new q(this);
        this.a.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.d();
            }
        });
        Resources resources = context.getResources();
        this.n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
    }

    void a(int i) {
        if (this.a.e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        boolean z = this.c.getVisibility() == 0;
        int c = this.a.c();
        int i2 = z ? 1 : 0;
        if (i == MoPubClientPositioning.NO_REPEAT || c <= i2 + i) {
            this.a.a(false);
            this.a.a(i);
        } else {
            this.a.a(true);
            this.a.a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.g || !z) {
                this.a.a(true, z);
            } else {
                this.a.a(false, false);
            }
            listPopupWindow.g(Math.min(this.a.a(), this.n));
            listPopupWindow.show();
            if (this.d != null) {
                this.d.a(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(i.abc_activitychooserview_choose_application));
            listPopupWindow.getListView().setSelector(new ColorDrawable(0));
        }
    }

    public boolean a() {
        if (c() || !this.q) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.o);
            }
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().isShowing();
    }

    void d() {
        if (this.a.getCount() > 0) {
            this.b.setEnabled(true);
        } else {
            this.b.setEnabled(false);
        }
        int c = this.a.c();
        int d = this.a.d();
        if (c == 1 || (c > 1 && d > 0)) {
            this.c.setVisibility(0);
            ResolveInfo b = this.a.b();
            PackageManager packageManager = getContext().getPackageManager();
            this.m.setImageDrawable(b.loadIcon(packageManager));
            if (this.r != 0) {
                CharSequence loadLabel = b.loadLabel(packageManager);
                this.c.setContentDescription(getContext().getString(this.r, new Object[]{loadLabel}));
            }
        } else {
            this.c.setVisibility(8);
        }
        if (this.c.getVisibility() == 0) {
            this.j.setBackgroundDrawable(this.k);
        } else {
            this.j.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.a.e();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.p == null) {
            this.p = new ListPopupWindow(getContext());
            this.p.a(this.a);
            this.p.b((View) this);
            this.p.a(true);
            this.p.a(this.i);
            this.p.a(this.i);
        }
        return this.p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel e = this.a.e();
        if (e != null) {
            e.registerObserver(this.e);
        }
        this.q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel e = this.a.e();
        if (e != null) {
            e.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.o);
        }
        if (c()) {
            b();
        }
        this.q = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.a.a(activityChooserModel);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.l.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.l.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setProvider(ActionProvider actionProvider) {
        this.d = actionProvider;
    }
}
