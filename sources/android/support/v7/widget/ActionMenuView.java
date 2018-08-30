package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    Callback a;
    OnMenuItemClickListener b;
    private MenuBuilder c;
    private Context d;
    private int e;
    private boolean f;
    private ActionMenuPresenter g;
    private MenuPresenter.Callback h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean a;
        @ExportedProperty
        public int b;
        @ExportedProperty
        public int c;
        @ExportedProperty
        public boolean d;
        @ExportedProperty
        public boolean e;
        boolean f;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.a();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.a && z2) {
            z = true;
        }
        layoutParams.d = z;
        layoutParams.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01dc  */
    private void c(int r35, int r36) {
        /*
        r34 = this;
        r23 = android.view.View.MeasureSpec.getMode(r36);
        r6 = android.view.View.MeasureSpec.getSize(r35);
        r17 = android.view.View.MeasureSpec.getSize(r36);
        r7 = r34.getPaddingLeft();
        r8 = r34.getPaddingRight();
        r7 = r7 + r8;
        r8 = r34.getPaddingTop();
        r9 = r34.getPaddingBottom();
        r19 = r8 + r9;
        r8 = -2;
        r0 = r36;
        r1 = r19;
        r24 = getChildMeasureSpec(r0, r1, r8);
        r25 = r6 - r7;
        r0 = r34;
        r6 = r0.k;
        r9 = r25 / r6;
        r0 = r34;
        r6 = r0.k;
        r6 = r25 % r6;
        if (r9 != 0) goto L_0x0041;
    L_0x0038:
        r6 = 0;
        r0 = r34;
        r1 = r25;
        r0.setMeasuredDimension(r1, r6);
    L_0x0040:
        return;
    L_0x0041:
        r0 = r34;
        r7 = r0.k;
        r6 = r6 / r9;
        r26 = r7 + r6;
        r16 = 0;
        r15 = 0;
        r10 = 0;
        r7 = 0;
        r11 = 0;
        r12 = 0;
        r27 = r34.getChildCount();
        r6 = 0;
        r18 = r6;
    L_0x0057:
        r0 = r18;
        r1 = r27;
        if (r0 >= r1) goto L_0x0103;
    L_0x005d:
        r0 = r34;
        r1 = r18;
        r8 = r0.getChildAt(r1);
        r6 = r8.getVisibility();
        r14 = 8;
        if (r6 != r14) goto L_0x007e;
    L_0x006d:
        r8 = r7;
        r6 = r12;
        r12 = r16;
        r13 = r9;
        r9 = r15;
    L_0x0073:
        r14 = r18 + 1;
        r18 = r14;
        r15 = r9;
        r16 = r12;
        r9 = r13;
        r12 = r6;
        r7 = r8;
        goto L_0x0057;
    L_0x007e:
        r0 = r8 instanceof android.support.v7.view.menu.ActionMenuItemView;
        r20 = r0;
        r14 = r7 + 1;
        if (r20 == 0) goto L_0x009a;
    L_0x0086:
        r0 = r34;
        r6 = r0.l;
        r7 = 0;
        r0 = r34;
        r0 = r0.l;
        r21 = r0;
        r22 = 0;
        r0 = r21;
        r1 = r22;
        r8.setPadding(r6, r7, r0, r1);
    L_0x009a:
        r6 = r8.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r7 = 0;
        r6.f = r7;
        r7 = 0;
        r6.c = r7;
        r7 = 0;
        r6.b = r7;
        r7 = 0;
        r6.d = r7;
        r7 = 0;
        r6.leftMargin = r7;
        r7 = 0;
        r6.rightMargin = r7;
        if (r20 == 0) goto L_0x00ff;
    L_0x00b4:
        r7 = r8;
        r7 = (android.support.v7.view.menu.ActionMenuItemView) r7;
        r7 = r7.a();
        if (r7 == 0) goto L_0x00ff;
    L_0x00bd:
        r7 = 1;
    L_0x00be:
        r6.e = r7;
        r7 = r6.a;
        if (r7 == 0) goto L_0x0101;
    L_0x00c4:
        r7 = 1;
    L_0x00c5:
        r0 = r26;
        r1 = r24;
        r2 = r19;
        r20 = a(r8, r0, r7, r1, r2);
        r0 = r20;
        r15 = java.lang.Math.max(r15, r0);
        r7 = r6.d;
        if (r7 == 0) goto L_0x031f;
    L_0x00d9:
        r7 = r10 + 1;
    L_0x00db:
        r6 = r6.a;
        if (r6 == 0) goto L_0x031c;
    L_0x00df:
        r6 = 1;
    L_0x00e0:
        r11 = r9 - r20;
        r8 = r8.getMeasuredHeight();
        r0 = r16;
        r10 = java.lang.Math.max(r0, r8);
        r8 = 1;
        r0 = r20;
        if (r0 != r8) goto L_0x0310;
    L_0x00f1:
        r8 = 1;
        r8 = r8 << r18;
        r8 = (long) r8;
        r8 = r8 | r12;
        r12 = r10;
        r13 = r11;
        r10 = r7;
        r11 = r6;
        r6 = r8;
        r9 = r15;
        r8 = r14;
        goto L_0x0073;
    L_0x00ff:
        r7 = 0;
        goto L_0x00be;
    L_0x0101:
        r7 = r9;
        goto L_0x00c5;
    L_0x0103:
        if (r11 == 0) goto L_0x0140;
    L_0x0105:
        r6 = 2;
        if (r7 != r6) goto L_0x0140;
    L_0x0108:
        r6 = 1;
        r8 = r6;
    L_0x010a:
        r18 = 0;
        r20 = r12;
        r19 = r9;
    L_0x0110:
        if (r10 <= 0) goto L_0x030c;
    L_0x0112:
        if (r19 <= 0) goto L_0x030c;
    L_0x0114:
        r14 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r12 = 0;
        r9 = 0;
        r6 = 0;
        r22 = r6;
    L_0x011d:
        r0 = r22;
        r1 = r27;
        if (r0 >= r1) goto L_0x0161;
    L_0x0123:
        r0 = r34;
        r1 = r22;
        r6 = r0.getChildAt(r1);
        r6 = r6.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r0 = r6.d;
        r28 = r0;
        if (r28 != 0) goto L_0x0143;
    L_0x0137:
        r6 = r9;
        r9 = r14;
    L_0x0139:
        r14 = r22 + 1;
        r22 = r14;
        r14 = r9;
        r9 = r6;
        goto L_0x011d;
    L_0x0140:
        r6 = 0;
        r8 = r6;
        goto L_0x010a;
    L_0x0143:
        r0 = r6.b;
        r28 = r0;
        r0 = r28;
        if (r0 >= r14) goto L_0x0153;
    L_0x014b:
        r9 = r6.b;
        r12 = 1;
        r12 = r12 << r22;
        r6 = 1;
        goto L_0x0139;
    L_0x0153:
        r6 = r6.b;
        if (r6 != r14) goto L_0x0308;
    L_0x0157:
        r28 = 1;
        r28 = r28 << r22;
        r12 = r12 | r28;
        r6 = r9 + 1;
        r9 = r14;
        goto L_0x0139;
    L_0x0161:
        r20 = r20 | r12;
        r0 = r19;
        if (r9 <= r0) goto L_0x01ec;
    L_0x0167:
        r12 = r20;
    L_0x0169:
        if (r11 != 0) goto L_0x0271;
    L_0x016b:
        r6 = 1;
        if (r7 != r6) goto L_0x0271;
    L_0x016e:
        r6 = 1;
    L_0x016f:
        if (r19 <= 0) goto L_0x02bd;
    L_0x0171:
        r8 = 0;
        r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r8 == 0) goto L_0x02bd;
    L_0x0177:
        r7 = r7 + -1;
        r0 = r19;
        if (r0 < r7) goto L_0x0182;
    L_0x017d:
        if (r6 != 0) goto L_0x0182;
    L_0x017f:
        r7 = 1;
        if (r15 <= r7) goto L_0x02bd;
    L_0x0182:
        r7 = java.lang.Long.bitCount(r12);
        r7 = (float) r7;
        if (r6 != 0) goto L_0x0302;
    L_0x0189:
        r8 = 1;
        r8 = r8 & r12;
        r10 = 0;
        r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r6 == 0) goto L_0x01a6;
    L_0x0192:
        r6 = 0;
        r0 = r34;
        r6 = r0.getChildAt(r6);
        r6 = r6.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r6 = r6.e;
        if (r6 != 0) goto L_0x01a6;
    L_0x01a3:
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = r7 - r6;
    L_0x01a6:
        r6 = 1;
        r8 = r27 + -1;
        r6 = r6 << r8;
        r8 = (long) r6;
        r8 = r8 & r12;
        r10 = 0;
        r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r6 == 0) goto L_0x0302;
    L_0x01b2:
        r6 = r27 + -1;
        r0 = r34;
        r6 = r0.getChildAt(r6);
        r6 = r6.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r6 = r6.e;
        if (r6 != 0) goto L_0x0302;
    L_0x01c4:
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r6 = r7 - r6;
    L_0x01c8:
        r7 = 0;
        r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r7 <= 0) goto L_0x0274;
    L_0x01cd:
        r7 = r19 * r26;
        r7 = (float) r7;
        r6 = r7 / r6;
        r6 = (int) r6;
        r7 = r6;
    L_0x01d4:
        r6 = 0;
        r9 = r6;
        r8 = r18;
    L_0x01d8:
        r0 = r27;
        if (r9 >= r0) goto L_0x02bf;
    L_0x01dc:
        r6 = 1;
        r6 = r6 << r9;
        r10 = (long) r6;
        r10 = r10 & r12;
        r14 = 0;
        r6 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r6 != 0) goto L_0x0278;
    L_0x01e6:
        r6 = r8;
    L_0x01e7:
        r8 = r9 + 1;
        r9 = r8;
        r8 = r6;
        goto L_0x01d8;
    L_0x01ec:
        r22 = r14 + 1;
        r6 = 0;
        r14 = r6;
        r9 = r19;
        r18 = r20;
    L_0x01f4:
        r0 = r27;
        if (r14 >= r0) goto L_0x0268;
    L_0x01f8:
        r0 = r34;
        r20 = r0.getChildAt(r14);
        r6 = r20.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r21 = 1;
        r21 = r21 << r14;
        r0 = r21;
        r0 = (long) r0;
        r28 = r0;
        r28 = r28 & r12;
        r30 = 0;
        r21 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1));
        if (r21 != 0) goto L_0x0228;
    L_0x0215:
        r6 = r6.b;
        r0 = r22;
        if (r6 != r0) goto L_0x0305;
    L_0x021b:
        r6 = 1;
        r6 = r6 << r14;
        r0 = (long) r6;
        r20 = r0;
        r18 = r18 | r20;
        r6 = r9;
    L_0x0223:
        r9 = r14 + 1;
        r14 = r9;
        r9 = r6;
        goto L_0x01f4;
    L_0x0228:
        if (r8 == 0) goto L_0x0255;
    L_0x022a:
        r0 = r6.e;
        r21 = r0;
        if (r21 == 0) goto L_0x0255;
    L_0x0230:
        r21 = 1;
        r0 = r21;
        if (r9 != r0) goto L_0x0255;
    L_0x0236:
        r0 = r34;
        r0 = r0.l;
        r21 = r0;
        r21 = r21 + r26;
        r28 = 0;
        r0 = r34;
        r0 = r0.l;
        r29 = r0;
        r30 = 0;
        r0 = r20;
        r1 = r21;
        r2 = r28;
        r3 = r29;
        r4 = r30;
        r0.setPadding(r1, r2, r3, r4);
    L_0x0255:
        r0 = r6.b;
        r20 = r0;
        r20 = r20 + 1;
        r0 = r20;
        r6.b = r0;
        r20 = 1;
        r0 = r20;
        r6.f = r0;
        r6 = r9 + -1;
        goto L_0x0223;
    L_0x0268:
        r6 = 1;
        r20 = r18;
        r18 = r6;
        r19 = r9;
        goto L_0x0110;
    L_0x0271:
        r6 = 0;
        goto L_0x016f;
    L_0x0274:
        r6 = 0;
        r7 = r6;
        goto L_0x01d4;
    L_0x0278:
        r0 = r34;
        r10 = r0.getChildAt(r9);
        r6 = r10.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r10 = r10 instanceof android.support.v7.view.menu.ActionMenuItemView;
        if (r10 == 0) goto L_0x029b;
    L_0x0288:
        r6.c = r7;
        r8 = 1;
        r6.f = r8;
        if (r9 != 0) goto L_0x0298;
    L_0x028f:
        r8 = r6.e;
        if (r8 != 0) goto L_0x0298;
    L_0x0293:
        r8 = -r7;
        r8 = r8 / 2;
        r6.leftMargin = r8;
    L_0x0298:
        r6 = 1;
        goto L_0x01e7;
    L_0x029b:
        r10 = r6.a;
        if (r10 == 0) goto L_0x02ac;
    L_0x029f:
        r6.c = r7;
        r8 = 1;
        r6.f = r8;
        r8 = -r7;
        r8 = r8 / 2;
        r6.rightMargin = r8;
        r6 = 1;
        goto L_0x01e7;
    L_0x02ac:
        if (r9 == 0) goto L_0x02b2;
    L_0x02ae:
        r10 = r7 / 2;
        r6.leftMargin = r10;
    L_0x02b2:
        r10 = r27 + -1;
        if (r9 == r10) goto L_0x02ba;
    L_0x02b6:
        r10 = r7 / 2;
        r6.rightMargin = r10;
    L_0x02ba:
        r6 = r8;
        goto L_0x01e7;
    L_0x02bd:
        r8 = r18;
    L_0x02bf:
        if (r8 == 0) goto L_0x02ee;
    L_0x02c1:
        r6 = 0;
        r7 = r6;
    L_0x02c3:
        r0 = r27;
        if (r7 >= r0) goto L_0x02ee;
    L_0x02c7:
        r0 = r34;
        r8 = r0.getChildAt(r7);
        r6 = r8.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r9 = r6.f;
        if (r9 != 0) goto L_0x02db;
    L_0x02d7:
        r6 = r7 + 1;
        r7 = r6;
        goto L_0x02c3;
    L_0x02db:
        r9 = r6.b;
        r9 = r9 * r26;
        r6 = r6.c;
        r6 = r6 + r9;
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9);
        r0 = r24;
        r8.measure(r6, r0);
        goto L_0x02d7;
    L_0x02ee:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r23;
        if (r0 == r6) goto L_0x02ff;
    L_0x02f4:
        r0 = r34;
        r1 = r25;
        r2 = r16;
        r0.setMeasuredDimension(r1, r2);
        goto L_0x0040;
    L_0x02ff:
        r16 = r17;
        goto L_0x02f4;
    L_0x0302:
        r6 = r7;
        goto L_0x01c8;
    L_0x0305:
        r6 = r9;
        goto L_0x0223;
    L_0x0308:
        r6 = r9;
        r9 = r14;
        goto L_0x0139;
    L_0x030c:
        r12 = r20;
        goto L_0x0169;
    L_0x0310:
        r8 = r14;
        r9 = r15;
        r32 = r12;
        r12 = r10;
        r13 = r11;
        r11 = r6;
        r10 = r7;
        r6 = r32;
        goto L_0x0073;
    L_0x031c:
        r6 = r11;
        goto L_0x00e0;
    L_0x031f:
        r7 = r10;
        goto L_0x00db;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.c(int, int):void");
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return j();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.h > 0) {
            return layoutParams2;
        }
        layoutParams2.h = 16;
        return layoutParams2;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(MenuPresenter.Callback callback, Callback callback2) {
        this.h = callback;
        this.a = callback2;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean a() {
        return this.f;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = 0 | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : ((ActionMenuChildView) childAt2).needsDividerBefore() | z;
    }

    /* renamed from: b */
    protected LayoutParams j() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.h = 16;
        return layoutParams;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public LayoutParams c() {
        LayoutParams b = j();
        b.a = true;
        return b;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public MenuBuilder d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.c();
    }

    public boolean f() {
        return this.g != null && this.g.d();
    }

    public boolean g() {
        return this.g != null && this.g.g();
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new MenuBuilder(context);
            this.c.a(new l(this));
            this.g = new ActionMenuPresenter(context);
            this.g.a(true);
            this.g.setCallback(this.h != null ? this.h : new k());
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.b();
    }

    public int getPopupTheme() {
        return this.e;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int getWindowAnimations() {
        return 0;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean h() {
        return this.g != null && this.g.h();
    }

    public void i() {
        if (this.g != null) {
            this.g.e();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void initialize(MenuBuilder menuBuilder) {
        this.c = menuBuilder;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean invokeItem(l lVar) {
        return this.c.a((MenuItem) lVar, 0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.updateMenuView(false);
            if (this.g.g()) {
                this.g.d();
                this.g.c();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i) {
            int i5;
            int i6;
            LayoutParams layoutParams;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = dk.a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.a) {
                        i6 = childAt.getMeasuredWidth();
                        if (a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (layoutParams.a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (layoutParams.a) {
                    paddingLeft = i6;
                } else {
                    i6 += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((layoutParams.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.i;
        this.i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.i || this.c == null || size == this.j)) {
            this.j = size;
            this.c.a(true);
        }
        int childCount = getChildCount();
        if (!this.i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        c(i, i2);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.b(z);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.b = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.g = actionMenuPresenter;
        this.g.a(this);
    }
}
