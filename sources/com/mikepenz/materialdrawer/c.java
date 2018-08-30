package com.mikepenz.materialdrawer;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem.Position;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.util.b;

class c {
    c() {
    }

    public static int a(b bVar, long j) {
        if (j >= 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bVar.a().getItemCount()) {
                    break;
                } else if (((IDrawerItem) bVar.a().b(i2)).getIdentifier() == j) {
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return -1;
    }

    public static LayoutParams a(b bVar, LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (bVar.w != null && (bVar.w.intValue() == 5 || bVar.w.intValue() == 8388613)) {
                layoutParams.rightMargin = 0;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginEnd(0);
                }
                layoutParams.leftMargin = bVar.d.getResources().getDimensionPixelSize(g.material_drawer_margin);
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginEnd(bVar.d.getResources().getDimensionPixelSize(g.material_drawer_margin));
                }
            }
            if (bVar.v > -1) {
                layoutParams.width = bVar.v;
            } else {
                layoutParams.width = b.a(bVar.d);
            }
        }
        return layoutParams;
    }

    public static ViewGroup a(Context context, b bVar, OnClickListener onClickListener) {
        ViewGroup linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(com.mikepenz.materialize.c.b.a(context, e.material_drawer_background, f.material_drawer_background));
        if (bVar.N) {
            a(context, linearLayout);
        }
        a(bVar, linearLayout, onClickListener);
        return linearLayout;
    }

    private static void a(Context context, ViewGroup viewGroup) {
        View linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setMinimumHeight((int) com.mikepenz.materialize.c.b.a(1.0f, context));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(com.mikepenz.materialize.c.b.a(context, e.material_drawer_divider, f.material_drawer_divider));
        viewGroup.addView(linearLayout, layoutParams);
    }

    public static void a(b bVar) {
        if (bVar.x != null) {
            if (bVar.y) {
                bVar.H = bVar.x.a();
            } else {
                bVar.D = bVar.x.a();
                bVar.E = bVar.x.a.D;
                bVar.F = bVar.x.a.C;
            }
        }
        if (bVar.H != null) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, 1);
            bVar.H.setId(i.material_drawer_sticky_header);
            bVar.q.addView(bVar.H, 0, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.U.getLayoutParams();
            layoutParams2.addRule(3, i.material_drawer_sticky_header);
            bVar.U.setLayoutParams(layoutParams2);
            bVar.H.setBackgroundColor(com.mikepenz.materialize.c.b.a(bVar.d, e.material_drawer_background, f.material_drawer_background));
            if (bVar.I) {
                if (VERSION.SDK_INT >= 21) {
                    bVar.H.setElevation(com.mikepenz.materialize.c.b.a(4.0f, bVar.d));
                } else {
                    View view = new View(bVar.d);
                    view.setBackgroundResource(h.material_drawer_shadow_bottom);
                    bVar.q.addView(view, -1, (int) com.mikepenz.materialize.c.b.a(4.0f, bVar.d));
                    layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams2.addRule(3, i.material_drawer_sticky_header);
                    view.setLayoutParams(layoutParams2);
                }
            }
            bVar.U.setPadding(0, 0, 0, 0);
        }
        if (bVar.D == null) {
            return;
        }
        if (bVar.U == null) {
            throw new RuntimeException("can't use a headerView without a recyclerView");
        }
        if (bVar.F) {
            bVar.c().add(new ContainerDrawerItem().a(bVar.D).a(bVar.G).a(bVar.E).a(Position.TOP));
        } else {
            bVar.c().add(new ContainerDrawerItem().a(bVar.D).a(bVar.G).a(bVar.E).a(Position.NONE));
        }
        bVar.U.setPadding(bVar.U.getPaddingLeft(), 0, bVar.U.getPaddingRight(), bVar.U.getPaddingBottom());
    }

    public static void a(b bVar, int i, Boolean bool) {
        if (i > -1 && bVar.M != null && (bVar.M instanceof LinearLayout)) {
            LinearLayout linearLayout = (LinearLayout) bVar.M;
            if (linearLayout.getChildCount() > i && i >= 0) {
                a(bVar, (IDrawerItem) linearLayout.getChildAt(i).getTag(), linearLayout.getChildAt(i), bool);
            }
        }
    }

    public static void a(b bVar, OnClickListener onClickListener) {
        Context context = bVar.q.getContext();
        if (bVar.ad != null && bVar.ad.size() > 0) {
            bVar.M = a(context, bVar, onClickListener);
        }
        if (bVar.M != null) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, 1);
            bVar.M.setId(i.material_drawer_sticky_footer);
            bVar.q.addView(bVar.M, layoutParams);
            if ((bVar.k || bVar.m) && VERSION.SDK_INT >= 19) {
                bVar.M.setPadding(0, 0, 0, com.mikepenz.materialize.c.b.a(context));
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.U.getLayoutParams();
            layoutParams2.addRule(2, i.material_drawer_sticky_footer);
            bVar.U.setLayoutParams(layoutParams2);
            if (bVar.P) {
                bVar.O = new View(context);
                bVar.O.setBackgroundResource(h.material_drawer_shadow_top);
                bVar.q.addView(bVar.O, -1, context.getResources().getDimensionPixelSize(g.material_drawer_sticky_footer_elevation));
                layoutParams2 = (RelativeLayout.LayoutParams) bVar.O.getLayoutParams();
                layoutParams2.addRule(2, i.material_drawer_sticky_footer);
                bVar.O.setLayoutParams(layoutParams2);
            }
            bVar.U.setPadding(bVar.U.getPaddingLeft(), bVar.U.getPaddingTop(), bVar.U.getPaddingRight(), context.getResources().getDimensionPixelSize(g.material_drawer_padding));
        }
        if (bVar.J == null) {
            return;
        }
        if (bVar.U == null) {
            throw new RuntimeException("can't use a footerView without a recyclerView");
        } else if (bVar.K) {
            bVar.d().add(new ContainerDrawerItem().a(bVar.J).a(Position.BOTTOM));
        } else {
            bVar.d().add(new ContainerDrawerItem().a(bVar.J).a(Position.NONE));
        }
    }

    public static void a(b bVar, ViewGroup viewGroup, OnClickListener onClickListener) {
        for (IDrawerItem iDrawerItem : bVar.ad) {
            View generateView = iDrawerItem.generateView(viewGroup.getContext(), viewGroup);
            generateView.setTag(iDrawerItem);
            if (iDrawerItem.isEnabled()) {
                generateView.setOnClickListener(onClickListener);
            }
            viewGroup.addView(generateView);
            b.a(generateView);
        }
        viewGroup.setPadding(0, 0, 0, 0);
    }

    public static void a(b bVar, IDrawerItem iDrawerItem, View view, Boolean bool) {
        boolean z = false;
        boolean z2 = iDrawerItem == null || !(iDrawerItem instanceof Selectable) || ((Selectable) iDrawerItem).isSelectable();
        if (z2) {
            bVar.h();
            view.setActivated(true);
            view.setSelected(true);
            bVar.a().c();
            if (bVar.M != null && (bVar.M instanceof LinearLayout)) {
                LinearLayout linearLayout = (LinearLayout) bVar.M;
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    if (linearLayout.getChildAt(i) == view) {
                        bVar.b = i;
                        break;
                    }
                }
            }
        }
        if (bool != null) {
            if (bool.booleanValue() && bVar.ai != null) {
                z = bVar.ai.onItemClick(view, -1, iDrawerItem);
            }
            if (!z) {
                bVar.g();
            }
        }
    }
}
