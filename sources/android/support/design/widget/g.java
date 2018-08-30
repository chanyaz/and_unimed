package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.c;
import android.support.design.i;
import android.support.design.k;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.support.v7.app.y;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class g extends y {
    boolean a = true;
    private BottomSheetBehavior<FrameLayout> b;
    private boolean c = true;
    private boolean d;
    private e e = new e() {
        public void a(@NonNull View view, float f) {
        }

        public void a(@NonNull View view, int i) {
            if (i == 5) {
                g.this.cancel();
            }
        }
    };

    public g(@NonNull Context context, @StyleRes int i) {
        super(context, a(context, i));
        a(1);
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(c.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : k.Theme_Design_Light_BottomSheetDialog;
    }

    private View a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), i.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(android.support.design.g.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(android.support.design.g.design_bottom_sheet);
        this.b = BottomSheetBehavior.b(view2);
        this.b.a(this.e);
        this.b.a(this.a);
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(android.support.design.g.touch_outside).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (g.this.a && g.this.isShowing() && g.this.a()) {
                    g.this.cancel();
                }
            }
        });
        ViewCompat.a(view2, new a() {
            public void a(View view, b bVar) {
                super.a(view, bVar);
                if (g.this.a) {
                    bVar.a(1048576);
                    bVar.n(true);
                    return;
                }
                bVar.n(false);
            }

            public boolean a(View view, int i, Bundle bundle) {
                if (i != 1048576 || !g.this.a) {
                    return super.a(view, i, bundle);
                }
                g.this.cancel();
                return true;
            }
        });
        view2.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    boolean a() {
        if (!this.d) {
            if (VERSION.SDK_INT < 11) {
                this.c = true;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.c = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.d = true;
        }
        return this.c;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    protected void onStart() {
        super.onStart();
        if (this.b != null) {
            this.b.b(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.a != z) {
            this.a = z;
            if (this.b != null) {
                this.b.a(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.a) {
            this.a = true;
        }
        this.c = z;
        this.d = true;
    }

    public void setContentView(@LayoutRes int i) {
        super.setContentView(a(i, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }
}
