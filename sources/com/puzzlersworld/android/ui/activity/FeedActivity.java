package com.puzzlersworld.android.ui.activity;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.c;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.exception.UiErrorHandler;
import com.puzzlersworld.android.exception.a;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.j;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.AdLocation;
import com.puzzlersworld.wp.dto.Category;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.PostTag;
import com.puzzlersworld.wp.dto.Product;
import com.puzzlersworld.wp.dto.StringConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class FeedActivity extends Fragment implements OnRefreshListener, ObservableScrollViewCallbacks, UiErrorHandler, AndroAppFragment {
    private static String h = "FeedActivity";
    Parcelable a = null;
    private d ae;
    private Menu af;
    private int ag = 1;
    private a ah = new a(this);
    private OnTouchListener ai = null;
    private int aj = 0;
    private com.puzzlersworld.android.util.d ak;
    private SwipeRefreshLayout al;
    private View am;
    private View an;
    private TextView ao;
    private TextView ap;
    private int aq;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService b;
    @ForUi
    @Inject
    ListeningExecutorService c;
    @Inject
    com.puzzlersworld.wp.controller.a d;
    @Inject
    g e;
    Gson f;
    Integer g = null;
    private ListView i;

    private void a(Bundle bundle) {
        if (bundle == null) {
            Log.d("AndroApp:", "Saved instance is null");
        } else if (this.af == null && bundle.getSerializable("menuitem") != null) {
            this.af = (Menu) bundle.getSerializable("menuitem");
        }
    }

    private void a(Post post) {
        if (this.af.getMenuItemType() == MenuItemType.author && post.getAuthor() != null) {
            this.af.setName(post.getAuthor().getName());
        }
        if (this.af.getMenuItemType() == MenuItemType.category && post.getTerms() != null && post.getTerms().getCategories() != null && post.getTerms().getCategories().size() > 0) {
            for (Category category : post.getTerms().getCategories()) {
                if (this.af.getSlug().equals(category.getSlug())) {
                    this.af.setName(category.getName());
                    break;
                }
            }
        }
        if (this.af.getMenuItemType() == MenuItemType.tag && post.getTerms() != null && post.getTerms().getTags() != null && post.getTerms().getTags().size() > 0) {
            for (PostTag postTag : post.getTerms().getTags()) {
                if (this.af.getSlug().equals(postTag.getSlug())) {
                    this.af.setName(postTag.getName());
                    break;
                }
            }
        }
        if (this.af.getName() == null || this.af.getName().isEmpty()) {
            this.af.setName(this.af.getSlug());
        }
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        }
    }

    private void a(List<Post> list) {
        this.ae = new d(list, getLifecycleActivity(), this.b, this, this.ai);
        this.i.setAdapter(this.ae);
    }

    private void ae() {
        this.am.setVisibility(0);
        this.ao.setVisibility(0);
    }

    private void c(final String str) {
        this.c.execute(new Runnable() {
            public void run() {
                FeedActivity.this.ap.setText(str + "\n " + StringConstants.RETRY.getMessage());
                FeedActivity.this.an.setVisibility(0);
                FeedActivity.this.ao.setVisibility(8);
            }
        });
    }

    private void d(final int i) {
        this.ag = i;
        try {
            final List a = this.d.a(this.af, i);
            if (a != null) {
                this.c.execute(new Runnable() {
                    public void run() {
                        FeedActivity.this.am.setVisibility(4);
                        if (i == 1) {
                            FeedActivity.this.ae.a();
                        }
                        if (i == 1 && FeedActivity.this.af.getMenuItemType() == MenuItemType.search && a.size() == 0) {
                            w.a(null, StringConstants.EMPTY_SEARCH_RESULT.getMessage(), FeedActivity.this.getLifecycleActivity());
                        }
                        if ((FeedActivity.this.af.getName() == null || FeedActivity.this.af.getName().isEmpty()) && a.size() > 0) {
                            FeedActivity.this.a((Post) a.get(0));
                        }
                        FeedActivity.this.ae.a(a);
                    }
                });
                return;
            }
            throw new Exception("Error in parsing feeds");
        } catch (Exception e) {
            Log.d("FeedActivity", "Retrofit error");
            e.printStackTrace();
            this.ah.a(e);
            FriopinApplication.a().a(e);
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_feeds, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        this.al = (SwipeRefreshLayout) inflate.findViewById(R.id.swiperefresh);
        this.i = (ListView) inflate.findViewById(R.id.FeedsList);
        this.aq = ac();
        List sliderMenu = FullscreenActivity.A().getSliderMenu();
        View inflate2 = (sliderMenu == null || sliderMenu.size() <= 0) ? LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.emptyspace, null) : LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.feedactivityemptyspace, null);
        this.i.addHeaderView(inflate2);
        ((ObservableListView) this.i).setScrollViewCallbacks(this);
        this.am = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.feed_loading, null);
        this.i.addFooterView(this.am);
        if (FullscreenActivity.z() != null) {
            this.i.setBackgroundColor(Color.parseColor(FullscreenActivity.z().getScreenBgColor()));
            inflate.setBackgroundColor(Color.parseColor(FullscreenActivity.z().getScreenBgColor()));
        }
        this.am.setVisibility(4);
        this.an = this.am.findViewById(R.id.retryLayout);
        this.an.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedActivity.this.b(view);
            }
        });
        this.an.setVisibility(8);
        this.ao = (TextView) this.am.findViewById(R.id.loading);
        this.ao.setText(StringConstants.LOADING.getMessage());
        this.ao.setVisibility(8);
        this.ap = (TextView) this.am.findViewById(R.id.retry);
        this.ak = new com.puzzlersworld.android.util.d(this.aj) {
            public void a(final int i, int i2) {
                Log.d("FeedActivity", "Load next page...." + i + "totalItemsCount=" + i2);
                FeedActivity.this.ae();
                FeedActivity.this.b.execute(new Runnable() {
                    public void run() {
                        try {
                            FeedActivity.this.d(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                            FriopinApplication.a().a(e);
                        }
                    }
                });
            }
        };
        this.i.setOnScrollListener(this.ak);
        this.f = new Gson();
        if (this.ae == null) {
            a(new ArrayList());
        } else {
            this.i.setAdapter(this.ae);
        }
        if (this.a == null) {
            if (this.af.getMenuItemType() == MenuItemType.home || this.af.getIsHome().booleanValue()) {
                this.e.a();
                String d = this.e.d();
                if (d.length() > 0) {
                    b(d);
                }
            }
            ae();
            this.b.execute(new Runnable() {
                public void run() {
                    try {
                        FeedActivity.this.d(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        FriopinApplication.a().a(e);
                    }
                }
            });
        } else {
            this.i.onRestoreInstanceState(this.a);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.FeedLayout);
        LayoutParams layoutParams = (LayoutParams) this.al.getLayoutParams();
        View a = w.a(null, 10, 19493, FullscreenActivity.o.getTopAdUnitList(), AdLocation.LIST);
        if (a != null) {
            ((LinearLayout) inflate2).addView(a);
        }
        View a2 = w.a(relativeLayout, 12, 19494, FullscreenActivity.o.getBottomAdUnitList(), AdLocation.LIST);
        if (a2 != null) {
            layoutParams.addRule(2, a2.getId());
        }
        a();
        this.al.a(false, ((FullscreenActivity) getLifecycleActivity()).o(), ((FullscreenActivity) getLifecycleActivity()).o() + 200);
        this.al.setOnRefreshListener(this);
        return inflate;
    }

    public void a() {
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).n();
        }
    }

    public void a(android.view.Menu menu, MenuInflater menuInflater) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called FeedActivity");
        menu.clear();
        menuInflater.inflate(R.menu.main, menu);
        j.a(menu, getLifecycleActivity());
        super.a(menu, menuInflater);
    }

    public void a(Menu menu) {
        this.af = menu;
    }

    int ac() {
        int[] iArr = new int[]{R.attr.actionBarSize};
        TypedArray obtainStyledAttributes = getLifecycleActivity().obtainStyledAttributes(new TypedValue().data, iArr);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public Menu ad() {
        return this.af;
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        a(bundle);
        d(true);
    }

    public void b(View view) {
        this.an.setVisibility(8);
        this.ao.setVisibility(0);
        ae();
        Log.d("FeedActivity", "Loading " + this.ag + " page again");
        this.b.execute(new Runnable() {
            public void run() {
                try {
                    FeedActivity.this.d(FeedActivity.this.ag);
                } catch (Exception e) {
                    e.printStackTrace();
                    FriopinApplication.a().a(e);
                }
            }
        });
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            Log.d(h, "Feeds Loaded from cache");
            List list = (List) this.f.fromJson(str, new TypeToken<List<Product>>() {
            }.getType());
            if (list != null && list.size() > 0 && ((Product) list.get(0)).getSku() == null && ((Product) list.get(0)).getMrp() == null) {
                list = (List) this.f.fromJson(str, new TypeToken<List<Post>>() {
                }.getType());
            }
            this.ae.a(list);
        }
    }

    public void d(Bundle bundle) {
        Log.d("AndroApp:", "OnActivityCreated called");
        super.d(bundle);
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        }
    }

    public void e() {
        this.aj = this.ak.a() > 0 ? this.ak.a() - 1 : 0;
        this.a = this.i.onSaveInstanceState();
        super.e();
    }

    public void e(Bundle bundle) {
        Log.d("AndroApp:", "Feed Activity OnSaveInstance called");
        super.e(bundle);
        if (this.af != null) {
            bundle.putSerializable("menuitem", this.af);
        }
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.FEED_ACTIVITY;
    }

    public String getTitle() {
        return this.af != null ? this.af.getName() : null;
    }

    public Object getTriggerObject() {
        return this.af != null ? this.af : null;
    }

    public void onConnectionTimeout() {
        c(StringConstants.CONNECTION_TIMEOUT.getMessage());
    }

    public void onDownMotionEvent() {
    }

    public void onError(Exception exception) {
        c(StringConstants.UNKNOWN_ERROR.getMessage());
    }

    public void onNoNetwork() {
        c(StringConstants.CANT_CONNECT.getMessage());
    }

    public void onRefresh() {
        this.b.execute(new Runnable() {
            public void run() {
                try {
                    FeedActivity.this.ak.a(1);
                    FeedActivity.this.d(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    FriopinApplication.a().a(e);
                }
                FeedActivity.this.c.execute(new Runnable() {
                    public void run() {
                        FeedActivity.this.al.setRefreshing(false);
                    }
                });
            }
        });
    }

    public void onScrollChanged(int i, boolean z, boolean z2) {
        View G = ((FullscreenActivity) getLifecycleActivity()).G();
        if (this.g != null) {
            com.nineoldandroids.a.a.j(G, c.a((G.getTranslationY() + ((float) this.g.intValue())) - ((float) i), (float) (-this.aq), 0.0f));
        }
        this.g = Integer.valueOf(i);
    }

    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    public void t() {
        super.t();
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
            ((FullscreenActivity) getLifecycleActivity()).m();
        }
        if (this.af != null) {
            FriopinApplication.a().a(this.af.getMenuItemType() + " screen");
        } else {
            FriopinApplication.a().a("home screen");
        }
    }

    public void u() {
        super.u();
    }
}
