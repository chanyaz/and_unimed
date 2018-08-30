package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ak;
import android.support.v7.widget.bo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.FastAdapter.OnLongClickListener;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemLongClickListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerNavigationListener;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialize.a;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class b {
    protected boolean A = true;
    protected ActionBarDrawerToggle B;
    protected boolean C = false;
    protected View D;
    protected boolean E = true;
    protected boolean F = true;
    protected c G = null;
    protected View H;
    protected boolean I = true;
    protected View J;
    protected boolean K = true;
    protected boolean L = false;
    protected ViewGroup M;
    protected boolean N = false;
    protected View O;
    protected boolean P = true;
    protected boolean Q = false;
    protected boolean R = false;
    protected int S = 0;
    protected long T = 0;
    protected RecyclerView U;
    protected boolean V = false;
    protected boolean W = true;
    protected FastAdapter<IDrawerItem> X;
    protected com.mikepenz.fastadapter.adapters.c<IDrawerItem> Y = new com.mikepenz.fastadapter.adapters.c();
    protected ItemAdapter<IDrawerItem> Z = new ItemAdapter();
    protected boolean a = false;
    protected com.mikepenz.fastadapter.adapters.b<IDrawerItem> aa = new com.mikepenz.fastadapter.adapters.b();
    protected bo ab;
    protected ItemAnimator ac = new ak();
    protected List<IDrawerItem> ad = new ArrayList();
    protected boolean ae = true;
    protected int af = 50;
    protected int ag = 0;
    protected OnDrawerListener ah;
    protected OnDrawerItemClickListener ai;
    protected OnDrawerItemLongClickListener aj;
    protected OnDrawerNavigationListener ak;
    protected boolean al = false;
    protected boolean am = false;
    protected MiniDrawer an = null;
    protected Bundle ao;
    private boolean ap = false;
    protected int b = -1;
    protected boolean c = false;
    protected Activity d;
    protected LayoutManager e;
    protected ViewGroup f;
    protected a g;
    protected boolean h = true;
    protected Boolean i;
    protected Toolbar j;
    protected boolean k = false;
    protected boolean l = false;
    protected boolean m = false;
    protected boolean n = false;
    protected View o;
    protected DrawerLayout p;
    protected ScrimInsetsRelativeLayout q;
    protected int r = 0;
    protected int s = -1;
    protected Drawable t = null;
    protected int u = -1;
    protected int v = -1;
    protected Integer w = Integer.valueOf(8388611);
    protected AccountHeader x;
    protected boolean y = false;
    protected boolean z = false;

    public b() {
        a();
    }

    private void i() {
        if (this.d != null && this.p != null && this.al) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.d);
            if (!defaultSharedPreferences.getBoolean("navigation_drawer_learned", false)) {
                this.p.h(this.q);
                Editor edit = defaultSharedPreferences.edit();
                edit.putBoolean("navigation_drawer_learned", true);
                edit.apply();
            }
        }
    }

    private void j() {
        if (this.o != null) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.q.addView(this.o, layoutParams);
            return;
        }
        int c;
        View view;
        if (VERSION.SDK_INT < 21 && this.p != null) {
            if (ViewCompat.f(this.f) == 0) {
                this.p.a(this.w.intValue() == 8388611 ? h.material_drawer_shadow_right : h.material_drawer_shadow_left, this.w.intValue());
            } else {
                this.p.a(this.w.intValue() == 8388611 ? h.material_drawer_shadow_left : h.material_drawer_shadow_right, this.w.intValue());
            }
        }
        if (this.U == null) {
            View inflate = LayoutInflater.from(this.d).inflate(j.material_drawer_recycler_view, this.q, false);
            this.U = (RecyclerView) inflate.findViewById(i.material_drawer_recycler_view);
            this.U.setItemAnimator(this.ac);
            this.U.setFadingEdgeLength(0);
            this.U.setClipToPadding(false);
            this.U.setLayoutManager(this.e);
            c = ((this.i == null || this.i.booleanValue()) && !this.n) ? com.mikepenz.materialize.c.b.c(this.d) : 0;
            int i = this.d.getResources().getConfiguration().orientation;
            i = ((this.k || this.m) && VERSION.SDK_INT >= 21 && !this.n && (i == 1 || (i == 2 && com.mikepenz.materialdrawer.util.b.c(this.d)))) ? com.mikepenz.materialize.c.b.a(this.d) : 0;
            this.U.setPadding(0, c, 0, i);
            view = inflate;
        } else {
            view = this.U;
        }
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.q.addView(view, layoutParams2);
        if (this.ap) {
            view = this.q.findViewById(i.material_drawer_inner_shadow);
            view.setVisibility(0);
            view.bringToFront();
            if (this.w.intValue() == 8388611) {
                view.setBackgroundResource(h.material_drawer_shadow_left);
            } else {
                view.setBackgroundResource(h.material_drawer_shadow_right);
            }
        }
        if (this.r != 0) {
            this.q.setBackgroundColor(this.r);
        } else if (this.s != -1) {
            this.q.setBackgroundColor(android.support.v4.content.a.c(this.d, this.s));
        } else if (this.t != null) {
            com.mikepenz.materialize.c.b.a(this.q, this.t);
        } else if (this.u != -1) {
            com.mikepenz.materialize.c.b.a(this.q, this.u);
        }
        c.a(this);
        c.a(this, new OnClickListener() {
            public void onClick(View view) {
                c.a(b.this, (IDrawerItem) view.getTag(), view, Boolean.valueOf(true));
            }
        });
        this.X.a(this.R);
        if (this.R) {
            this.X.b(false);
            this.X.c(true);
        }
        if (this.ab == null) {
            this.U.setAdapter(this.X);
        } else {
            this.U.setAdapter(this.ab);
        }
        if (this.S == 0 && this.T != 0) {
            this.S = c.a(this, this.T);
        }
        if (this.D != null && this.S == 0) {
            this.S = 1;
        }
        this.X.c();
        this.X.g(this.S);
        this.X.a(new FastAdapter.OnClickListener<IDrawerItem>() {
            /* renamed from: a */
            public boolean onClick(final View view, IAdapter<IDrawerItem> iAdapter, final IDrawerItem iDrawerItem, final int i) {
                if (iDrawerItem == null || !(iDrawerItem instanceof Selectable) || iDrawerItem.isSelectable()) {
                    b.this.h();
                    b.this.b = -1;
                }
                boolean onItemClick = (!(iDrawerItem instanceof com.mikepenz.materialdrawer.model.a) || ((com.mikepenz.materialdrawer.model.a) iDrawerItem).a() == null) ? false : ((com.mikepenz.materialdrawer.model.a) iDrawerItem).a().onItemClick(view, i, iDrawerItem);
                if (b.this.ai != null) {
                    if (b.this.ag > 0) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                b.this.ai.onItemClick(view, i, iDrawerItem);
                            }
                        }, (long) b.this.ag);
                    } else {
                        onItemClick = b.this.ai.onItemClick(view, i, iDrawerItem);
                    }
                }
                if (!(onItemClick || b.this.an == null)) {
                    onItemClick = b.this.an.b(iDrawerItem);
                }
                if ((iDrawerItem instanceof IExpandable) && ((IExpandable) iDrawerItem).getSubItems() != null) {
                    return true;
                }
                if (onItemClick) {
                    return onItemClick;
                }
                b.this.g();
                return onItemClick;
            }
        });
        this.X.a(new OnLongClickListener<IDrawerItem>() {
            /* renamed from: a */
            public boolean onLongClick(View view, IAdapter<IDrawerItem> iAdapter, IDrawerItem iDrawerItem, int i) {
                return b.this.aj != null ? b.this.aj.onItemLongClick(view, i, b.this.c(i)) : false;
            }
        });
        if (this.U != null) {
            this.U.a(0);
        }
        if (this.ao != null) {
            if (this.c) {
                this.X.a(this.ao, "_selection_appended");
                c.a(this, this.ao.getInt("bundle_sticky_footer_selection_appended", -1), null);
            } else {
                this.X.a(this.ao, "_selection");
                c.a(this, this.ao.getInt("bundle_sticky_footer_selection", -1), null);
            }
        }
        if (this.Q && this.ai != null) {
            c = this.X.b().size() == 0 ? -1 : ((Integer) this.X.b().iterator().next()).intValue();
            this.ai.onItemClick(null, c, c(c));
        }
    }

    protected FastAdapter<IDrawerItem> a() {
        if (this.X == null) {
            this.X = new FastAdapter();
            this.X.d(true);
            this.X.c(false);
            this.X.setHasStableIds(this.V);
            this.X.e(this.W);
            this.Y.a(this.Z.a(this.aa.a(this.X)));
        }
        return this.X;
    }

    public b a(@LayoutRes int i) {
        if (this.d == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.p = (DrawerLayout) this.d.getLayoutInflater().inflate(i, this.f, false);
        } else if (VERSION.SDK_INT < 21) {
            this.p = (DrawerLayout) this.d.getLayoutInflater().inflate(j.material_drawer_fits_not, this.f, false);
        } else {
            this.p = (DrawerLayout) this.d.getLayoutInflater().inflate(j.material_drawer, this.f, false);
        }
        return this;
    }

    public b a(@NonNull Activity activity) {
        this.f = (ViewGroup) activity.findViewById(16908290);
        this.d = activity;
        this.e = new LinearLayoutManager(this.d);
        return this;
    }

    public b a(@NonNull Toolbar toolbar) {
        this.j = toolbar;
        return this;
    }

    public b a(@NonNull AccountHeader accountHeader) {
        return a(accountHeader, false);
    }

    public b a(@NonNull AccountHeader accountHeader, boolean z) {
        this.x = accountHeader;
        this.y = z;
        return this;
    }

    public b a(@NonNull OnDrawerItemClickListener onDrawerItemClickListener) {
        this.ai = onDrawerItemClickListener;
        return this;
    }

    public b a(@NonNull OnDrawerNavigationListener onDrawerNavigationListener) {
        this.ak = onDrawerNavigationListener;
        return this;
    }

    public b a(boolean z) {
        this.h = z;
        return this;
    }

    protected void a(Activity activity, boolean z) {
        OnClickListener anonymousClass1 = new OnClickListener() {
            public void onClick(View view) {
                boolean z = false;
                if (!(b.this.ak == null || b.this.B == null || b.this.B.c())) {
                    z = b.this.ak.onNavigationClickListener(view);
                }
                if (!z) {
                    if (b.this.p.g(b.this.w.intValue())) {
                        b.this.p.f(b.this.w.intValue());
                    } else {
                        b.this.p.e(b.this.w.intValue());
                    }
                }
            }
        };
        if (z) {
            this.B = null;
        }
        if (this.A && this.B == null && this.j != null) {
            this.B = new ActionBarDrawerToggle(activity, this.p, this.j, k.material_drawer_open, k.material_drawer_close) {
                public void onDrawerClosed(View view) {
                    if (b.this.ah != null) {
                        b.this.ah.onDrawerClosed(view);
                    }
                    super.onDrawerClosed(view);
                }

                public void onDrawerOpened(View view) {
                    if (b.this.ah != null) {
                        b.this.ah.onDrawerOpened(view);
                    }
                    super.onDrawerOpened(view);
                }

                public void onDrawerSlide(View view, float f) {
                    if (b.this.ah != null) {
                        b.this.ah.onDrawerSlide(view, f);
                    }
                    if (b.this.z) {
                        super.onDrawerSlide(view, f);
                    } else {
                        super.onDrawerSlide(view, 0.0f);
                    }
                }
            };
            this.B.a();
        }
        if (this.j != null) {
            this.j.setNavigationOnClickListener(anonymousClass1);
        }
        if (this.B != null) {
            this.B.a(anonymousClass1);
            this.p.a(this.B);
            return;
        }
        this.p.a(new DrawerListener() {
            public void onDrawerClosed(View view) {
                if (b.this.ah != null) {
                    b.this.ah.onDrawerClosed(view);
                }
            }

            public void onDrawerOpened(View view) {
                if (b.this.ah != null) {
                    b.this.ah.onDrawerOpened(view);
                }
            }

            public void onDrawerSlide(View view, float f) {
                if (b.this.ah != null) {
                    b.this.ah.onDrawerSlide(view, f);
                }
            }

            public void onDrawerStateChanged(int i) {
            }
        });
    }

    protected IItemAdapter<IDrawerItem> b() {
        return this.Z;
    }

    public b b(@ColorInt int i) {
        this.r = i;
        return this;
    }

    public b b(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    protected IItemAdapter<IDrawerItem> c() {
        return this.Y;
    }

    public b c(boolean z) {
        this.k = z;
        if (!z) {
            this.l = false;
        }
        return this;
    }

    protected IDrawerItem c(int i) {
        return (IDrawerItem) a().b(i);
    }

    protected IItemAdapter<IDrawerItem> d() {
        return this.aa;
    }

    public b d(boolean z) {
        this.m = z;
        if (z) {
            a(true);
            c(false);
        }
        return this;
    }

    public Drawer e() {
        if (this.a) {
            throw new RuntimeException("you must not reuse a DrawerBuilder builder");
        } else if (this.d == null) {
            throw new RuntimeException("please pass an activity");
        } else {
            this.a = true;
            if (this.p == null) {
                a(-1);
            }
            this.g = new com.mikepenz.materialize.b().a(this.d).a(this.f).f(this.m).g(this.n).a(false).b(this.h).d(this.l).b(this.p).a();
            a(this.d, false);
            Drawer f = f();
            this.q.setId(i.material_drawer_slider_layout);
            this.p.addView(this.q, 1);
            return f;
        }
    }

    public b e(boolean z) {
        this.A = z;
        return this;
    }

    public Drawer f() {
        this.q = (ScrimInsetsRelativeLayout) this.d.getLayoutInflater().inflate(j.material_drawer_slider, this.p, false);
        this.q.setBackgroundColor(com.mikepenz.materialize.c.b.a(this.d, e.material_drawer_background, f.material_drawer_background));
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) this.q.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.a = this.w.intValue();
            this.q.setLayoutParams(c.a(this, layoutParams));
        }
        j();
        Drawer drawer = new Drawer(this);
        if (this.x != null) {
            this.x.a(drawer);
        }
        if (this.ao != null && this.ao.getBoolean("bundle_drawer_content_switched", false)) {
            this.x.a(this.d);
        }
        i();
        if (!this.c && this.am) {
            this.an = new MiniDrawer().a(drawer).a(this.x).a(this.W);
        }
        this.d = null;
        return drawer;
    }

    protected void g() {
        if (this.ae && this.p != null) {
            if (this.af > -1) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        b.this.p.b();
                        if (b.this.C) {
                            b.this.U.c(0);
                        }
                    }
                }, (long) this.af);
            } else {
                this.p.b();
            }
        }
    }

    protected void h() {
        if (this.M instanceof LinearLayout) {
            for (int i = 0; i < this.M.getChildCount(); i++) {
                this.M.getChildAt(i).setActivated(false);
                this.M.getChildAt(i).setSelected(false);
            }
        }
    }
}
