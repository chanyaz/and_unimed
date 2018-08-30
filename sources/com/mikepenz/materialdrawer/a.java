package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.mikepenz.materialdrawer.AccountHeader.OnAccountHeaderItemLongClickListener;
import com.mikepenz.materialdrawer.AccountHeader.OnAccountHeaderListener;
import com.mikepenz.materialdrawer.AccountHeader.OnAccountHeaderProfileImageListener;
import com.mikepenz.materialdrawer.AccountHeader.OnAccountHeaderSelectionViewClickListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemLongClickListener;
import com.mikepenz.materialdrawer.a.b;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.a.d;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader.Tags;
import com.mikepenz.materialdrawer.view.BezelImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class a {
    protected String A;
    protected String B;
    protected boolean C = true;
    protected boolean D = true;
    protected boolean E = true;
    protected d F;
    protected ScaleType G = null;
    protected boolean H = true;
    protected boolean I = false;
    protected boolean J = false;
    protected Boolean K = null;
    protected boolean L = true;
    protected boolean M = true;
    protected boolean N = false;
    protected boolean O = false;
    protected int P = 100;
    protected OnAccountHeaderProfileImageListener Q;
    protected OnAccountHeaderSelectionViewClickListener R;
    protected boolean S = true;
    protected boolean T = true;
    protected View U;
    protected List<IProfile> V;
    protected OnAccountHeaderListener W;
    protected OnAccountHeaderItemLongClickListener X;
    protected Drawer Y;
    protected Bundle Z;
    protected View a;
    private OnClickListener aa = new OnClickListener() {
        public void onClick(View view) {
            a.this.b(view, true);
        }
    };
    private OnClickListener ab = new OnClickListener() {
        public void onClick(View view) {
            a.this.b(view, false);
        }
    };
    private OnLongClickListener ac = new OnLongClickListener() {
        public boolean onLongClick(View view) {
            if (a.this.Q == null) {
                return false;
            }
            return a.this.Q.onProfileImageLongClick(view, (IProfile) view.getTag(i.material_drawer_profile_header), true);
        }
    };
    private OnLongClickListener ad = new OnLongClickListener() {
        public boolean onLongClick(View view) {
            if (a.this.Q == null) {
                return false;
            }
            return a.this.Q.onProfileImageLongClick(view, (IProfile) view.getTag(i.material_drawer_profile_header), false);
        }
    };
    private OnClickListener ae = new OnClickListener() {
        public void onClick(View view) {
            boolean z = false;
            if (a.this.R != null) {
                z = a.this.R.onClick(view, (IProfile) view.getTag(i.material_drawer_profile_header));
            }
            if (a.this.e.getVisibility() == 0 && !z) {
                a.this.a(view.getContext());
            }
        }
    };
    private OnDrawerItemClickListener af = new OnDrawerItemClickListener() {
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
            boolean z = false;
            boolean a = (iDrawerItem != null && (iDrawerItem instanceof IProfile) && iDrawerItem.isSelectable()) ? a.this.a((IProfile) iDrawerItem) : false;
            if (a.this.L) {
                a.this.Y.a(null);
            }
            if (!(!a.this.L || a.this.Y == null || view == null || view.getContext() == null)) {
                a.this.b(view.getContext());
            }
            if (!(a.this.Y == null || a.this.Y.a() == null || a.this.Y.a().an == null)) {
                a.this.Y.a().an.a();
            }
            a = (iDrawerItem == null || !(iDrawerItem instanceof IProfile) || a.this.W == null) ? false : a.this.W.onProfileChanged(view, (IProfile) iDrawerItem, a);
            if (a.this.K == null) {
                z = a;
            } else if (a && !a.this.K.booleanValue()) {
                z = true;
            }
            if (!(a.this.Y == null || z)) {
                a.this.Y.a.g();
            }
            return true;
        }
    };
    private OnDrawerItemLongClickListener ag = new OnDrawerItemLongClickListener() {
        public boolean onItemLongClick(View view, int i, IDrawerItem iDrawerItem) {
            if (a.this.X == null) {
                return false;
            }
            boolean z = iDrawerItem != null && iDrawerItem.isSelected();
            return (iDrawerItem == null || !(iDrawerItem instanceof IProfile)) ? false : a.this.X.onProfileLongClick(view, (IProfile) iDrawerItem, z);
        }
    };
    protected ImageView b;
    protected BezelImageView c;
    protected View d;
    protected ImageView e;
    protected TextView f;
    protected TextView g;
    protected BezelImageView h;
    protected BezelImageView i;
    protected BezelImageView j;
    protected IProfile k;
    protected IProfile l;
    protected IProfile m;
    protected IProfile n;
    protected boolean o = false;
    protected int p = -1;
    protected Activity q;
    protected boolean r = false;
    protected Typeface s;
    protected Typeface t;
    protected Typeface u;
    protected c v;
    protected b w;
    protected boolean x = false;
    protected boolean y = true;
    protected boolean z = true;

    private void a(ImageView imageView, d dVar) {
        DrawerImageLoader.a().a(imageView);
        imageView.setImageDrawable(DrawerImageLoader.a().b().placeholder(imageView.getContext(), Tags.PROFILE.name()));
        com.mikepenz.materialize.b.c.a(dVar, imageView, Tags.PROFILE.name());
    }

    private void a(IProfile iProfile, boolean z) {
        if (z) {
            if (VERSION.SDK_INT >= 21) {
                ((FrameLayout) this.U).setForeground(android.support.v4.content.a.a(this.U.getContext(), this.p));
                this.U.setOnClickListener(this.ae);
                this.U.setTag(i.material_drawer_profile_header, iProfile);
                return;
            }
            this.d.setBackgroundResource(this.p);
            this.d.setOnClickListener(this.ae);
            this.d.setTag(i.material_drawer_profile_header, iProfile);
        } else if (VERSION.SDK_INT >= 21) {
            ((FrameLayout) this.U).setForeground(null);
            this.U.setOnClickListener(null);
        } else {
            com.mikepenz.materialize.c.b.a(this.d, null);
            this.d.setOnClickListener(null);
        }
    }

    private void b(int i) {
        if (this.U != null) {
            LayoutParams layoutParams;
            LayoutParams layoutParams2 = this.U.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = i;
                this.U.setLayoutParams(layoutParams2);
            }
            View findViewById = this.U.findViewById(i.material_drawer_account_header);
            if (findViewById != null) {
                layoutParams = findViewById.getLayoutParams();
                layoutParams.height = i;
                findViewById.setLayoutParams(layoutParams);
            }
            findViewById = this.U.findViewById(i.material_drawer_account_header_background);
            if (findViewById != null) {
                layoutParams = findViewById.getLayoutParams();
                layoutParams.height = i;
                findViewById.setLayoutParams(layoutParams);
            }
        }
    }

    private void b(Context context) {
        if (this.Y != null) {
            this.Y.j();
        }
        this.e.clearAnimation();
        ViewCompat.l(this.e).c(0.0f).c();
    }

    private void b(View view, boolean z) {
        if (!(this.Q != null ? this.Q.onProfileImageClick(view, (IProfile) view.getTag(i.material_drawer_profile_header), z) : false)) {
            a(view, z);
        }
    }

    /* JADX WARNING: Missing block: B:46:0x01af, code:
            if (((float) r0) <= (((float) r2) - com.mikepenz.materialize.c.b.a(8.0f, r10.q))) goto L_0x01b1;
     */
    public com.mikepenz.materialdrawer.AccountHeader a() {
        /*
        r10 = this;
        r9 = 1;
        r8 = -1;
        r0 = r10.U;
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r10.a(r8);
    L_0x0009:
        r0 = r10.U;
        r1 = com.mikepenz.materialdrawer.i.material_drawer_account_header;
        r0 = r0.findViewById(r1);
        r10.a = r0;
        r0 = r10.q;
        r0 = r0.getResources();
        r1 = com.mikepenz.materialdrawer.g.material_drawer_account_header_height;
        r2 = r0.getDimensionPixelSize(r1);
        r0 = r10.q;
        r3 = com.mikepenz.materialize.c.b.a(r0, r9);
        r0 = r10.v;
        if (r0 == 0) goto L_0x017d;
    L_0x0029:
        r0 = r10.v;
        r1 = r10.q;
        r0 = r0.a(r1);
    L_0x0031:
        r1 = r10.E;
        if (r1 == 0) goto L_0x005e;
    L_0x0035:
        r1 = android.os.Build.VERSION.SDK_INT;
        r4 = 21;
        if (r1 < r4) goto L_0x005e;
    L_0x003b:
        r1 = r10.a;
        r4 = r10.a;
        r4 = r4.getPaddingLeft();
        r5 = r10.a;
        r5 = r5.getPaddingTop();
        r5 = r5 + r3;
        r6 = r10.a;
        r6 = r6.getPaddingRight();
        r7 = r10.a;
        r7 = r7.getPaddingBottom();
        r1.setPadding(r4, r5, r6, r7);
        r1 = r10.r;
        if (r1 == 0) goto L_0x01b4;
    L_0x005d:
        r0 = r0 + r3;
    L_0x005e:
        r10.b(r0);
        r0 = r10.U;
        r1 = com.mikepenz.materialdrawer.i.material_drawer_account_header_background;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.ImageView) r0;
        r10.b = r0;
        r0 = r10.F;
        r1 = r10.b;
        r2 = com.mikepenz.materialdrawer.util.DrawerImageLoader.Tags.ACCOUNT_HEADER;
        r2 = r2.name();
        com.mikepenz.materialize.b.c.a(r0, r1, r2);
        r0 = r10.G;
        if (r0 == 0) goto L_0x0085;
    L_0x007e:
        r0 = r10.b;
        r1 = r10.G;
        r0.setScaleType(r1);
    L_0x0085:
        r0 = r10.w;
        r1 = r10.q;
        r2 = com.mikepenz.materialdrawer.e.material_drawer_header_selection_text;
        r3 = com.mikepenz.materialdrawer.f.material_drawer_header_selection_text;
        r1 = com.mikepenz.materialize.b.a.a(r0, r1, r2, r3);
        r0 = r10.r;
        if (r0 == 0) goto L_0x01bc;
    L_0x0095:
        r0 = r10.a;
        r10.d = r0;
    L_0x0099:
        r0 = r10.q;
        r0 = com.mikepenz.materialize.c.b.d(r0);
        r10.p = r0;
        r0 = r10.k;
        r10.a(r0, r9);
        r0 = r10.U;
        r2 = com.mikepenz.materialdrawer.i.material_drawer_account_header_text_switcher;
        r0 = r0.findViewById(r2);
        r0 = (android.widget.ImageView) r0;
        r10.e = r0;
        r0 = r10.e;
        r2 = new com.mikepenz.iconics.d;
        r3 = r10.q;
        r4 = com.mikepenz.materialdrawer.icons.MaterialDrawerFont.Icon.mdf_arrow_drop_down;
        r2.<init>(r3, r4);
        r3 = com.mikepenz.materialdrawer.g.material_drawer_account_header_dropdown;
        r2 = r2.h(r3);
        r3 = com.mikepenz.materialdrawer.g.material_drawer_account_header_dropdown_padding;
        r2 = r2.e(r3);
        r2 = r2.a(r1);
        r0.setImageDrawable(r2);
        r0 = r10.a;
        r2 = com.mikepenz.materialdrawer.i.material_drawer_account_header_current;
        r0 = r0.findViewById(r2);
        r0 = (com.mikepenz.materialdrawer.view.BezelImageView) r0;
        r10.c = r0;
        r0 = r10.a;
        r2 = com.mikepenz.materialdrawer.i.material_drawer_account_header_name;
        r0 = r0.findViewById(r2);
        r0 = (android.widget.TextView) r0;
        r10.f = r0;
        r0 = r10.a;
        r2 = com.mikepenz.materialdrawer.i.material_drawer_account_header_email;
        r0 = r0.findViewById(r2);
        r0 = (android.widget.TextView) r0;
        r10.g = r0;
        r0 = r10.t;
        if (r0 == 0) goto L_0x01c8;
    L_0x00f8:
        r0 = r10.f;
        r2 = r10.t;
        r0.setTypeface(r2);
    L_0x00ff:
        r0 = r10.u;
        if (r0 == 0) goto L_0x01d5;
    L_0x0103:
        r0 = r10.g;
        r2 = r10.u;
        r0.setTypeface(r2);
    L_0x010a:
        r0 = r10.f;
        r0.setTextColor(r1);
        r0 = r10.g;
        r0.setTextColor(r1);
        r0 = r10.a;
        r1 = com.mikepenz.materialdrawer.i.material_drawer_account_header_small_first;
        r0 = r0.findViewById(r1);
        r0 = (com.mikepenz.materialdrawer.view.BezelImageView) r0;
        r10.h = r0;
        r0 = r10.a;
        r1 = com.mikepenz.materialdrawer.i.material_drawer_account_header_small_second;
        r0 = r0.findViewById(r1);
        r0 = (com.mikepenz.materialdrawer.view.BezelImageView) r0;
        r10.i = r0;
        r0 = r10.a;
        r1 = com.mikepenz.materialdrawer.i.material_drawer_account_header_small_third;
        r0 = r0.findViewById(r1);
        r0 = (com.mikepenz.materialdrawer.view.BezelImageView) r0;
        r10.j = r0;
        r10.b();
        r10.c();
        r0 = r10.Z;
        if (r0 == 0) goto L_0x0165;
    L_0x0142:
        r0 = r10.Z;
        r1 = "bundle_selection_header";
        r0 = r0.getInt(r1, r8);
        if (r0 == r8) goto L_0x0165;
    L_0x014c:
        r1 = r10.V;
        if (r1 == 0) goto L_0x0165;
    L_0x0150:
        if (r0 <= r8) goto L_0x0165;
    L_0x0152:
        r1 = r10.V;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x0165;
    L_0x015a:
        r1 = r10.V;
        r0 = r1.get(r0);
        r0 = (com.mikepenz.materialdrawer.model.interfaces.IProfile) r0;
        r10.a(r0);
    L_0x0165:
        r0 = r10.Y;
        if (r0 == 0) goto L_0x0174;
    L_0x0169:
        r0 = r10.Y;
        r1 = r10.U;
        r2 = r10.C;
        r3 = r10.D;
        r0.a(r1, r2, r3);
    L_0x0174:
        r0 = 0;
        r10.q = r0;
        r0 = new com.mikepenz.materialdrawer.AccountHeader;
        r0.<init>(r10);
        return r0;
    L_0x017d:
        r0 = r10.r;
        if (r0 == 0) goto L_0x018f;
    L_0x0181:
        r0 = r10.q;
        r0 = r0.getResources();
        r1 = com.mikepenz.materialdrawer.g.material_drawer_account_header_height_compact;
        r0 = r0.getDimensionPixelSize(r1);
        goto L_0x0031;
    L_0x018f:
        r0 = r10.q;
        r0 = com.mikepenz.materialdrawer.util.b.a(r0);
        r0 = (double) r0;
        r4 = 4603241769126068224; // 0x3fe2000000000000 float:0.0 double:0.5625;
        r0 = r0 * r4;
        r1 = (int) r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r4 = 19;
        if (r0 >= r4) goto L_0x01b1;
    L_0x01a0:
        r0 = r1 - r3;
        r4 = (float) r0;
        r5 = (float) r2;
        r6 = 1090519040; // 0x41000000 float:8.0 double:5.38787994E-315;
        r7 = r10.q;
        r6 = com.mikepenz.materialize.c.b.a(r6, r7);
        r5 = r5 - r6;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 > 0) goto L_0x0031;
    L_0x01b1:
        r0 = r1;
        goto L_0x0031;
    L_0x01b4:
        r1 = r0 - r3;
        if (r1 > r2) goto L_0x005e;
    L_0x01b8:
        r0 = r2 + r3;
        goto L_0x005e;
    L_0x01bc:
        r0 = r10.U;
        r2 = com.mikepenz.materialdrawer.i.material_drawer_account_header_text_section;
        r0 = r0.findViewById(r2);
        r10.d = r0;
        goto L_0x0099;
    L_0x01c8:
        r0 = r10.s;
        if (r0 == 0) goto L_0x00ff;
    L_0x01cc:
        r0 = r10.f;
        r2 = r10.s;
        r0.setTypeface(r2);
        goto L_0x00ff;
    L_0x01d5:
        r0 = r10.s;
        if (r0 == 0) goto L_0x010a;
    L_0x01d9:
        r0 = r10.g;
        r2 = r10.s;
        r0.setTypeface(r2);
        goto L_0x010a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.a.a():com.mikepenz.materialdrawer.AccountHeader");
    }

    public a a(@LayoutRes int i) {
        if (this.q == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.U = this.q.getLayoutInflater().inflate(i, null, false);
        } else if (this.r) {
            this.U = this.q.getLayoutInflater().inflate(j.material_drawer_compact_header, null, false);
        } else {
            this.U = this.q.getLayoutInflater().inflate(j.material_drawer_header, null, false);
        }
        return this;
    }

    public a a(@NonNull Activity activity) {
        this.q = activity;
        return this;
    }

    public a a(Drawable drawable) {
        this.F = new d(drawable);
        return this;
    }

    public a a(boolean z) {
        this.D = z;
        return this;
    }

    protected void a(Context context) {
        if (this.Y == null) {
            return;
        }
        if (this.Y.i()) {
            b(context);
            this.o = false;
            return;
        }
        d();
        this.e.clearAnimation();
        ViewCompat.l(this.e).c(180.0f).c();
        this.o = true;
    }

    protected void a(View view, boolean z) {
        IProfile iProfile = (IProfile) view.getTag(i.material_drawer_profile_header);
        a(iProfile);
        b(view.getContext());
        if (!(this.Y == null || this.Y.a() == null || this.Y.a().an == null)) {
            this.Y.a().an.a();
        }
        if (!(this.W != null ? this.W.onProfileChanged(view, iProfile, z) : false)) {
            if (this.P > 0) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (a.this.Y != null) {
                            a.this.Y.b();
                        }
                    }
                }, (long) this.P);
            } else if (this.Y != null) {
                this.Y.b();
            }
        }
    }

    protected boolean a(IProfile iProfile) {
        boolean z = true;
        if (iProfile == null) {
            return false;
        }
        if (this.k == iProfile) {
            return true;
        }
        if (this.N) {
            if (this.l == iProfile) {
                z = true;
            } else if (this.m == iProfile) {
                z = true;
            } else if (this.n == iProfile) {
                z = true;
            }
            IProfile iProfile2 = this.k;
            this.k = iProfile;
            if (z) {
                this.l = iProfile2;
            } else if (z) {
                this.m = iProfile2;
            } else if (z) {
                this.n = iProfile2;
            }
        } else if (this.V != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new IProfile[]{this.k, this.l, this.m, this.n}));
            if (arrayList.contains(iProfile)) {
                int i = 0;
                while (i < 4) {
                    if (arrayList.get(i) == iProfile) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    arrayList.remove(i);
                    arrayList.add(0, iProfile);
                    this.k = (IProfile) arrayList.get(0);
                    this.l = (IProfile) arrayList.get(1);
                    this.m = (IProfile) arrayList.get(2);
                    this.n = (IProfile) arrayList.get(3);
                }
            } else {
                this.n = this.m;
                this.m = this.l;
                this.l = this.k;
                this.k = iProfile;
            }
        }
        if (this.J) {
            this.n = this.m;
            this.m = this.l;
            this.l = this.k;
        }
        c();
        return false;
    }

    protected void b() {
        int i = 0;
        if (this.V == null) {
            this.V = new ArrayList();
        }
        int i2;
        if (this.k == null) {
            i2 = 0;
            while (i < this.V.size()) {
                if (this.V.size() > i && ((IProfile) this.V.get(i)).isSelectable()) {
                    if (i2 == 0 && this.k == null) {
                        this.k = (IProfile) this.V.get(i);
                    } else if (i2 == 1 && this.l == null) {
                        this.l = (IProfile) this.V.get(i);
                    } else if (i2 == 2 && this.m == null) {
                        this.m = (IProfile) this.V.get(i);
                    } else if (i2 == 3 && this.n == null) {
                        this.n = (IProfile) this.V.get(i);
                    }
                    i2++;
                }
                i++;
            }
            return;
        }
        IProfile[] iProfileArr = new IProfile[]{this.k, this.l, this.m, this.n};
        IProfile[] iProfileArr2 = new IProfile[4];
        Stack stack = new Stack();
        for (i2 = 0; i2 < this.V.size(); i2++) {
            IProfile iProfile = (IProfile) this.V.get(i2);
            if (iProfile.isSelectable()) {
                int i3;
                for (i3 = 0; i3 < 4; i3++) {
                    if (iProfileArr[i3] == iProfile) {
                        iProfileArr2[i3] = iProfile;
                        i3 = 1;
                        break;
                    }
                }
                i3 = 0;
                if (i3 == 0) {
                    stack.push(iProfile);
                }
            }
        }
        Stack stack2 = new Stack();
        while (i < 4) {
            if (iProfileArr2[i] != null) {
                stack2.push(iProfileArr2[i]);
            } else if (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            i++;
        }
        Stack stack3 = new Stack();
        while (!stack2.empty()) {
            stack3.push(stack2.pop());
        }
        if (stack3.isEmpty()) {
            this.k = null;
        } else {
            this.k = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.l = null;
        } else {
            this.l = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.m = null;
        } else {
            this.m = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.n = null;
        } else {
            this.n = (IProfile) stack3.pop();
        }
    }

    protected void c() {
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(8);
        this.h.setVisibility(8);
        this.h.setOnClickListener(null);
        this.i.setVisibility(8);
        this.i.setOnClickListener(null);
        this.j.setVisibility(8);
        this.j.setOnClickListener(null);
        this.f.setText("");
        this.g.setText("");
        if (!this.r) {
            this.d.setPadding(0, 0, (int) com.mikepenz.materialize.c.b.a(56.0f, this.d.getContext()), 0);
        }
        a(this.k, true);
        if (this.k != null) {
            if ((this.H || this.I) && !this.J) {
                a(this.c, this.k.getIcon());
                if (this.M) {
                    this.c.setOnClickListener(this.aa);
                    this.c.setOnLongClickListener(this.ac);
                    this.c.a(false);
                } else {
                    this.c.a(true);
                }
                this.c.setVisibility(0);
                this.c.invalidate();
            } else if (this.r) {
                this.c.setVisibility(8);
            }
            this.d.setVisibility(0);
            a(this.k, true);
            this.e.setVisibility(0);
            this.c.setTag(i.material_drawer_profile_header, this.k);
            com.mikepenz.materialize.b.d.a(this.k.getName(), this.f);
            com.mikepenz.materialize.b.d.a(this.k.getEmail(), this.g);
            if (!(this.l == null || !this.H || this.I)) {
                a(this.h, this.l.getIcon());
                this.h.setTag(i.material_drawer_profile_header, this.l);
                if (this.M) {
                    this.h.setOnClickListener(this.ab);
                    this.h.setOnLongClickListener(this.ad);
                    this.h.a(false);
                } else {
                    this.h.a(true);
                }
                this.h.setVisibility(0);
                this.h.invalidate();
            }
            if (!(this.m == null || !this.H || this.I)) {
                a(this.i, this.m.getIcon());
                this.i.setTag(i.material_drawer_profile_header, this.m);
                if (this.M) {
                    this.i.setOnClickListener(this.ab);
                    this.i.setOnLongClickListener(this.ad);
                    this.i.a(false);
                } else {
                    this.i.a(true);
                }
                this.i.setVisibility(0);
                this.i.invalidate();
            }
            if (this.n != null && this.O && this.H && !this.I) {
                a(this.j, this.n.getIcon());
                this.j.setTag(i.material_drawer_profile_header, this.n);
                if (this.M) {
                    this.j.setOnClickListener(this.ab);
                    this.j.setOnLongClickListener(this.ad);
                    this.j.a(false);
                } else {
                    this.j.a(true);
                }
                this.j.setVisibility(0);
                this.j.invalidate();
            }
        } else if (this.V != null && this.V.size() > 0) {
            this.d.setTag(i.material_drawer_profile_header, (IProfile) this.V.get(0));
            this.d.setVisibility(0);
            a(this.k, true);
            this.e.setVisibility(0);
            if (this.k != null) {
                com.mikepenz.materialize.b.d.a(this.k.getName(), this.f);
                com.mikepenz.materialize.b.d.a(this.k.getEmail(), this.g);
            }
        }
        if (!this.y) {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.A)) {
            this.f.setText(this.A);
            this.d.setVisibility(0);
        }
        if (!this.z) {
            this.g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.B)) {
            this.g.setText(this.B);
            this.d.setVisibility(0);
        }
        if (!this.T || (!this.S && this.l == null && (this.V == null || this.V.size() == 1))) {
            this.e.setVisibility(8);
            a(null, false);
            if (!this.r) {
                this.d.setPadding(0, 0, (int) com.mikepenz.materialize.c.b.a(16.0f, this.d.getContext()), 0);
            }
        }
        if (this.R != null) {
            a(this.k, true);
        }
    }

    protected void d() {
        int i;
        List arrayList = new ArrayList();
        if (this.V != null) {
            int i2 = 0;
            i = -1;
            for (IProfile iProfile : this.V) {
                int i3;
                if (iProfile != this.k) {
                    i3 = i;
                } else if (!this.x) {
                    i3 = this.Y.a.b().getGlobalPosition(i2);
                }
                if (iProfile instanceof IDrawerItem) {
                    ((IDrawerItem) iProfile).withSetSelected(false);
                    arrayList.add((IDrawerItem) iProfile);
                }
                i2++;
                i = i3;
            }
        } else {
            i = -1;
        }
        this.Y.a(this.af, this.ag, arrayList, i);
    }
}
