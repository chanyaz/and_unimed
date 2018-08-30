package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.VisibleForTesting;
import android.support.design.g;
import android.support.design.i;
import android.support.design.j;
import android.support.design.k;
import android.support.design.l;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v4.widget.au;
import android.support.v7.a.d;
import android.support.v7.c.a.b;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.WithHint;
import android.support.v7.widget.an;
import android.support.v7.widget.db;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout implements WithHint {
    private boolean A;
    private Drawable B;
    private Drawable C;
    private ColorStateList D;
    private boolean E;
    private Mode F;
    private boolean G;
    private ColorStateList H;
    private ColorStateList I;
    private boolean J;
    private boolean K;
    private ValueAnimator L;
    private boolean M;
    private boolean N;
    private boolean O;
    EditText a;
    TextView b;
    boolean c;
    final j d;
    private final FrameLayout e;
    private CharSequence f;
    private boolean g;
    private CharSequence h;
    private Paint i;
    private final Rect j;
    private LinearLayout k;
    private int l;
    private Typeface m;
    private boolean n;
    private int o;
    private boolean p;
    private CharSequence q;
    private TextView r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private Drawable x;
    private CharSequence y;
    private CheckableImageButton z;

    class SavedState extends AbsSavedState {
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
        CharSequence a;
        boolean b;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j = new Rect();
        this.d = new j(this);
        am.a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.e = new FrameLayout(context);
        this.e.setAddStatesFromChildren(true);
        addView(this.e);
        this.d.a(a.b);
        this.d.b(new AccelerateInterpolator());
        this.d.b(8388659);
        db a = db.a(context, attributeSet, l.TextInputLayout, i, k.Widget_Design_TextInputLayout);
        this.g = a.a(l.TextInputLayout_hintEnabled, true);
        setHint(a.c(l.TextInputLayout_android_hint));
        this.K = a.a(l.TextInputLayout_hintAnimationEnabled, true);
        if (a.g(l.TextInputLayout_android_textColorHint)) {
            ColorStateList e = a.e(l.TextInputLayout_android_textColorHint);
            this.I = e;
            this.H = e;
        }
        if (a.g(l.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(a.g(l.TextInputLayout_hintTextAppearance, 0));
        }
        this.o = a.g(l.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = a.a(l.TextInputLayout_errorEnabled, false);
        boolean a3 = a.a(l.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(a.a(l.TextInputLayout_counterMaxLength, -1));
        this.t = a.g(l.TextInputLayout_counterTextAppearance, 0);
        this.u = a.g(l.TextInputLayout_counterOverflowTextAppearance, 0);
        this.w = a.a(l.TextInputLayout_passwordToggleEnabled, false);
        this.x = a.a(l.TextInputLayout_passwordToggleDrawable);
        this.y = a.c(l.TextInputLayout_passwordToggleContentDescription);
        if (a.g(l.TextInputLayout_passwordToggleTint)) {
            this.E = true;
            this.D = a.e(l.TextInputLayout_passwordToggleTint);
        }
        if (a.g(l.TextInputLayout_passwordToggleTintMode)) {
            this.G = true;
            this.F = ao.a(a.a(l.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        a.a();
        setErrorEnabled(a2);
        setCounterEnabled(a3);
        h();
        if (ViewCompat.e(this) == 0) {
            ViewCompat.b((View) this, 1);
        }
        ViewCompat.a((View) this, new al(this));
    }

    private void a() {
        int i;
        LayoutParams layoutParams = (LayoutParams) this.e.getLayoutParams();
        if (this.g) {
            if (this.i == null) {
                this.i = new Paint();
            }
            this.i.setTypeface(this.d.d());
            this.i.setTextSize(this.d.h());
            i = (int) (-this.i.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.e.requestLayout();
        }
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    private void a(TextView textView) {
        if (this.k != null) {
            this.k.removeView(textView);
            int i = this.l - 1;
            this.l = i;
            if (i == 0) {
                this.k.setVisibility(8);
            }
        }
    }

    private void a(TextView textView, int i) {
        if (this.k == null) {
            this.k = new LinearLayout(getContext());
            this.k.setOrientation(0);
            addView(this.k, -1, -2);
            this.k.addView(new Space(getContext()), new LayoutParams(0, 0, 1.0f));
            if (this.a != null) {
                b();
            }
        }
        this.k.setVisibility(0);
        this.k.addView(textView, i);
        this.l++;
    }

    private void a(@Nullable final CharSequence charSequence, boolean z) {
        boolean z2 = true;
        this.q = charSequence;
        if (!this.n) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        }
        this.p = z2;
        this.b.animate().cancel();
        if (this.p) {
            this.b.setText(charSequence);
            this.b.setVisibility(0);
            if (z) {
                if (this.b.getAlpha() == 1.0f) {
                    this.b.setAlpha(0.0f);
                }
                this.b.animate().alpha(1.0f).setDuration(200).setInterpolator(a.d).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        TextInputLayout.this.b.setVisibility(0);
                    }
                }).start();
            } else {
                this.b.setAlpha(1.0f);
            }
        } else if (this.b.getVisibility() == 0) {
            if (z) {
                this.b.animate().alpha(0.0f).setDuration(200).setInterpolator(a.c).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.b.setText(charSequence);
                        TextInputLayout.this.b.setVisibility(4);
                    }
                }).start();
            } else {
                this.b.setText(charSequence);
                this.b.setVisibility(4);
            }
        }
        c();
        a(z);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        ViewCompat.b(this.k, ViewCompat.h(this.a), 0, ViewCompat.i(this.a), this.a.getPaddingBottom());
    }

    private void b(boolean z) {
        if (this.w) {
            int selectionEnd = this.a.getSelectionEnd();
            if (f()) {
                this.a.setTransformationMethod(null);
                this.A = true;
            } else {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.A = false;
            }
            this.z.setChecked(this.A);
            if (z) {
                this.z.jumpDrawablesToCurrentState();
            }
            this.a.setSelection(selectionEnd);
        }
    }

    private void c() {
        if (this.a != null) {
            Drawable background = this.a.getBackground();
            if (background != null) {
                d();
                if (an.c(background)) {
                    background = background.mutate();
                }
                if (this.p && this.b != null) {
                    background.setColorFilter(AppCompatDrawableManager.a(this.b.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.v || this.r == null) {
                    a.f(background);
                    this.a.refreshDrawableState();
                } else {
                    background.setColorFilter(AppCompatDrawableManager.a(this.r.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void c(boolean z) {
        if (this.L != null && this.L.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(1.0f);
        } else {
            this.d.b(1.0f);
        }
        this.J = false;
    }

    private void d() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.a.getBackground();
            if (background != null && !this.M) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.M = p.a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.M) {
                    ViewCompat.a(this.a, newDrawable);
                    this.M = true;
                }
            }
        }
    }

    private void d(boolean z) {
        if (this.L != null && this.L.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(0.0f);
        } else {
            this.d.b(0.0f);
        }
        this.J = true;
    }

    private void e() {
        if (this.a != null) {
            Drawable[] b;
            if (g()) {
                if (this.z == null) {
                    this.z = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i.design_text_input_password_icon, this.e, false);
                    this.z.setImageDrawable(this.x);
                    this.z.setContentDescription(this.y);
                    this.e.addView(this.z);
                    this.z.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.b(false);
                        }
                    });
                }
                if (this.a != null && ViewCompat.k(this.a) <= 0) {
                    this.a.setMinimumHeight(ViewCompat.k(this.z));
                }
                this.z.setVisibility(0);
                this.z.setChecked(this.A);
                if (this.B == null) {
                    this.B = new ColorDrawable();
                }
                this.B.setBounds(0, 0, this.z.getMeasuredWidth(), 1);
                b = TextViewCompat.b(this.a);
                if (b[2] != this.B) {
                    this.C = b[2];
                }
                TextViewCompat.a(this.a, b[0], b[1], this.B, b[3]);
                this.z.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
                return;
            }
            if (this.z != null && this.z.getVisibility() == 0) {
                this.z.setVisibility(8);
            }
            if (this.B != null) {
                b = TextViewCompat.b(this.a);
                if (b[2] == this.B) {
                    TextViewCompat.a(this.a, b[0], b[1], this.C, b[3]);
                    this.B = null;
                }
            }
        }
    }

    private boolean f() {
        return this.a != null && (this.a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean g() {
        return this.w && (f() || this.A);
    }

    private void h() {
        if (this.x == null) {
            return;
        }
        if (this.E || this.G) {
            this.x = a.g(this.x).mutate();
            if (this.E) {
                a.a(this.x, this.D);
            }
            if (this.G) {
                a.a(this.x, this.F);
            }
            if (this.z != null && this.z.getDrawable() != this.x) {
                this.z.setImageDrawable(this.x);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.a = editText;
        if (!f()) {
            this.d.c(this.a.getTypeface());
        }
        this.d.a(this.a.getTextSize());
        int gravity = this.a.getGravity();
        this.d.b((gravity & -113) | 48);
        this.d.a(gravity);
        this.a.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.a(!TextInputLayout.this.O);
                if (TextInputLayout.this.c) {
                    TextInputLayout.this.a(editable.length());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.H == null) {
            this.H = this.a.getHintTextColors();
        }
        if (this.g && TextUtils.isEmpty(this.h)) {
            this.f = this.a.getHint();
            setHint(this.f);
            this.a.setHint(null);
        }
        if (this.r != null) {
            a(this.a.getText().length());
        }
        if (this.k != null) {
            b();
        }
        e();
        a(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        this.h = charSequence;
        this.d.a(charSequence);
    }

    @VisibleForTesting
    void a(float f) {
        if (this.d.g() != f) {
            if (this.L == null) {
                this.L = new ValueAnimator();
                this.L.setInterpolator(a.a);
                this.L.setDuration(200);
                this.L.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.d.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.L.setFloatValues(new float[]{this.d.g(), f});
            this.L.start();
        }
    }

    void a(int i) {
        boolean z = this.v;
        if (this.s == -1) {
            this.r.setText(String.valueOf(i));
            this.v = false;
        } else {
            this.v = i > this.s;
            if (z != this.v) {
                TextViewCompat.a(this.r, this.v ? this.u : this.t);
            }
            this.r.setText(getContext().getString(j.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.s)}));
        }
        if (this.a != null && z != this.v) {
            a(false);
            c();
        }
    }

    void a(boolean z) {
        a(z, false);
    }

    void a(boolean z, boolean z2) {
        Object obj = 1;
        boolean isEnabled = isEnabled();
        Object obj2 = (this.a == null || TextUtils.isEmpty(this.a.getText())) ? null : 1;
        boolean a = a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.H != null) {
            this.d.b(this.H);
        }
        if (isEnabled && this.v && this.r != null) {
            this.d.a(this.r.getTextColors());
        } else if (isEnabled && a && this.I != null) {
            this.d.a(this.I);
        } else if (this.H != null) {
            this.d.a(this.H);
        }
        if (obj2 != null || (isEnabled() && (a || obj != null))) {
            if (z2 || this.J) {
                c(z);
            }
        } else if (z2 || !this.J) {
            d(z);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.e.addView(view, layoutParams2);
            this.e.setLayoutParams(layoutParams);
            a();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f == null || this.a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        CharSequence hint = this.a.getHint();
        this.a.setHint(this.f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.a.setHint(hint);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.O = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.O = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g) {
            this.d.a(canvas);
        }
    }

    protected void drawableStateChanged() {
        boolean z = true;
        if (!this.N) {
            this.N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!(ViewCompat.y(this) && isEnabled())) {
                z = false;
            }
            a(z);
            c();
            if ((this.d != null ? this.d.a(drawableState) | 0 : 0) != 0) {
                invalidate();
            }
            this.N = false;
        }
    }

    public int getCounterMaxLength() {
        return this.s;
    }

    @Nullable
    public EditText getEditText() {
        return this.a;
    }

    @Nullable
    public CharSequence getError() {
        return this.n ? this.q : null;
    }

    @Nullable
    public CharSequence getHint() {
        return this.g ? this.h : null;
    }

    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.y;
    }

    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.x;
    }

    @NonNull
    public Typeface getTypeface() {
        return this.m;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g && this.a != null) {
            Rect rect = this.j;
            au.b(this, this.a, rect);
            int compoundPaddingLeft = rect.left + this.a.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.a.getCompoundPaddingRight();
            this.d.a(compoundPaddingLeft, rect.top + this.a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.a.getCompoundPaddingBottom());
            this.d.b(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.d.i();
        }
    }

    protected void onMeasure(int i, int i2) {
        e();
        super.onMeasure(i, i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            setError(savedState.a);
            if (savedState.b) {
                b(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.p) {
            savedState.a = getError();
        }
        savedState.b = this.A;
        return savedState;
    }

    public void setCounterEnabled(boolean z) {
        if (this.c != z) {
            if (z) {
                this.r = new AppCompatTextView(getContext());
                this.r.setId(g.textinput_counter);
                if (this.m != null) {
                    this.r.setTypeface(this.m);
                }
                this.r.setMaxLines(1);
                try {
                    TextViewCompat.a(this.r, this.t);
                } catch (Exception e) {
                    TextViewCompat.a(this.r, android.support.v7.a.j.TextAppearance_AppCompat_Caption);
                    this.r.setTextColor(android.support.v4.content.a.c(getContext(), d.error_color_material));
                }
                a(this.r, -1);
                if (this.a == null) {
                    a(0);
                } else {
                    a(this.a.getText().length());
                }
            } else {
                a(this.r);
                this.r = null;
            }
            this.c = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.s != i) {
            if (i > 0) {
                this.s = i;
            } else {
                this.s = -1;
            }
            if (this.c) {
                a(this.a == null ? 0 : this.a.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    public void setError(@Nullable CharSequence charSequence) {
        boolean z = ViewCompat.y(this) && isEnabled() && (this.b == null || !TextUtils.equals(this.b.getText(), charSequence));
        a(charSequence, z);
    }

    public void setErrorEnabled(boolean z) {
        if (this.n != z) {
            if (this.b != null) {
                this.b.animate().cancel();
            }
            if (z) {
                int i;
                this.b = new AppCompatTextView(getContext());
                this.b.setId(g.textinput_error);
                if (this.m != null) {
                    this.b.setTypeface(this.m);
                }
                try {
                    TextViewCompat.a(this.b, this.o);
                    if (VERSION.SDK_INT < 23 || this.b.getTextColors().getDefaultColor() != -65281) {
                        boolean i2 = false;
                    } else {
                        i2 = 1;
                    }
                } catch (Exception e) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    TextViewCompat.a(this.b, android.support.v7.a.j.TextAppearance_AppCompat_Caption);
                    this.b.setTextColor(android.support.v4.content.a.c(getContext(), d.error_color_material));
                }
                this.b.setVisibility(4);
                ViewCompat.c(this.b, 1);
                a(this.b, 0);
            } else {
                this.p = false;
                c();
                a(this.b);
                this.b = null;
            }
            this.n = z;
        }
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        this.o = i;
        if (this.b != null) {
            TextViewCompat.a(this.b, i);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.g) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.K = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.g) {
            this.g = z;
            CharSequence hint = this.a.getHint();
            if (!this.g) {
                if (!TextUtils.isEmpty(this.h) && TextUtils.isEmpty(hint)) {
                    this.a.setHint(this.h);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.h)) {
                    setHint(hint);
                }
                this.a.setHint(null);
            }
            if (this.a != null) {
                a();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.d.c(i);
        this.I = this.d.k();
        if (this.a != null) {
            a(false);
            a();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.y = charSequence;
        if (this.z != null) {
            this.z.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? b.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.x = drawable;
        if (this.z != null) {
            this.z.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!(z || !this.A || this.a == null)) {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.A = false;
            e();
        }
    }

    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.D = colorStateList;
        this.E = true;
        h();
    }

    public void setPasswordVisibilityToggleTintMode(@Nullable Mode mode) {
        this.F = mode;
        this.G = true;
        h();
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if ((this.m != null && !this.m.equals(typeface)) || (this.m == null && typeface != null)) {
            this.m = typeface;
            this.d.c(typeface);
            if (this.r != null) {
                this.r.setTypeface(typeface);
            }
            if (this.b != null) {
                this.b.setTypeface(typeface);
            }
        }
    }
}
