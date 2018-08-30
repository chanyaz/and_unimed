package com.puzzlersworld.android.ui.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.mopub.mobileads.MoPubView;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.ui.activity.CommentsActivity;
import com.puzzlersworld.android.ui.activity.FeedActivity;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.AdLocation;
import com.puzzlersworld.wp.dto.AndroAppAdUnit;
import com.puzzlersworld.wp.dto.Author;
import com.puzzlersworld.wp.dto.Category;
import com.puzzlersworld.wp.dto.Comment;
import com.puzzlersworld.wp.dto.Layout;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Monetise;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.Term;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobi.androapp.ac.c8700.R;

public class d<T> extends BaseAdapter {
    private Context a;
    private Fragment b;
    private ListeningScheduledExecutorService c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g;
    private List<T> h = new ArrayList();
    private Map<Integer, AdView> i = new HashMap();
    private OnTouchListener j;

    public d(List<T> list, Context context, ListeningScheduledExecutorService listeningScheduledExecutorService, Fragment fragment, OnTouchListener onTouchListener) {
        this.a = context;
        this.b = fragment;
        this.c = listeningScheduledExecutorService;
        c();
        this.j = onTouchListener;
        a((List) list);
    }

    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (!w.a(13)) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return (int) (((double) point.y) * 0.25d);
    }

    private View a(Comment comment, View view) {
        b bVar;
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.comments_cell, null);
            b bVar2 = new b(this.a);
            bVar2.a = (TextView) view.findViewById(R.id.content);
            bVar2.b = (TextView) view.findViewById(R.id.author);
            bVar2.c = (TextView) view.findViewById(R.id.time);
            bVar2.d = (TextView) view.findViewById(R.id.reply);
            bVar2.h = (RelativeLayout) view.findViewById(R.id.feedItemLayout);
            bVar2.m = (CardView) view.findViewById(R.id.cardview);
            bVar2.g = (CommentsActivity) this.b;
            bVar2.e = (TextView) view.findViewById(R.id.status);
            bVar2.a(this.d);
            bVar2.b(this.e);
            bVar2.c(this.f);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
            bVar.c(this.f);
        }
        bVar.a(comment);
        return view;
    }

    private View a(final Post post, View view) {
        View inflate;
        c cVar;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
            inflate = FullscreenActivity.y() == Layout.cardview ? layoutInflater.inflate(R.layout.feedlistcell, null) : layoutInflater.inflate(R.layout.compactfeedlistcell, null);
            c cVar2 = new c(this.a);
            cVar2.a = (TextView) inflate.findViewById(R.id.category);
            cVar2.b = (TextView) inflate.findViewById(R.id.title);
            cVar2.c = (TextView) inflate.findViewById(R.id.content);
            cVar2.f = (ImageView) inflate.findViewById(R.id.post_image);
            cVar2.k = (LinearLayout) inflate.findViewById(R.id.shareLayout);
            cVar2.l = (CardView) inflate.findViewById(R.id.cardview);
            cVar2.m = (LinearLayout) inflate.findViewById(R.id.cattimelayout);
            if (this.j != null) {
                inflate.findViewById(R.id.feedItemLayout).setOnTouchListener(this.j);
            }
            cVar2.d = (TextView) inflate.findViewById(R.id.author);
            cVar2.e = (TextView) inflate.findViewById(R.id.time);
            cVar2.a(this.d);
            cVar2.b(this.e);
            inflate.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
            inflate = view;
        }
        cVar.a(post);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Menu menu = null;
                if (d.this.b instanceof FeedActivity) {
                    menu = ((FeedActivity) d.this.b).ad();
                    menu.setIsHome(Boolean.valueOf(false));
                }
                d.a(d.this.a, post, d.this.h, menu);
            }
        });
        if (cVar.a != null) {
            cVar.a.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.this.a(view, post);
                }
            });
        }
        if (cVar.d != null) {
            cVar.d.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.this.a(post);
                }
            });
        }
        return inflate;
    }

    public static void a(Context context, Post post, List<Post> list, Menu menu) {
        Activity j = InjectibleApplication.j();
        if (j instanceof FullscreenActivity) {
            ((FullscreenActivity) j).a(post, list, menu, menu == null ? false : menu.getIsHome().booleanValue());
        }
    }

    public static void a(Context context, String str) {
        Post post = (Post) ((FriopinApplication) context.getApplicationContext()).f().fromJson(str, Post.class);
        Activity j = InjectibleApplication.j();
        if (j instanceof FullscreenActivity) {
            ((FullscreenActivity) j).a(post, null, null, false);
        }
    }

    public static void a(Context context, String str, boolean z) {
        Activity j = InjectibleApplication.j();
        if (j instanceof FullscreenActivity) {
            ((FullscreenActivity) j).a(str, z);
        }
    }

    @SuppressLint({"NewApi"})
    public static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (!w.a(13)) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return (int) (((double) Math.min(point.x, point.y)) * 0.25d);
    }

    @SuppressLint({"NewApi"})
    public static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (!w.a(13)) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    private void c() {
        Monetise monetise = FullscreenActivity.o;
        this.g = 10000;
        if (monetise.getMiddleAdUnitList().size() > 0) {
            for (AndroAppAdUnit androAppAdUnit : monetise.getMiddleAdUnitList()) {
                if (androAppAdUnit.showOnLocation(AdLocation.LIST)) {
                    this.g = androAppAdUnit.getAdFrequency();
                }
            }
        }
    }

    public int a(T t) {
        int i = 0;
        for (Object equals : this.h) {
            if (equals.equals(t)) {
                return i + ((i + 1) / this.g);
            }
            i++;
        }
        return -1;
    }

    public void a() {
        this.h.clear();
        this.i.clear();
        notifyDataSetChanged();
    }

    public void a(View view, Post post) {
        Object tag = view.getTag();
        Menu menu = new Menu();
        if (tag instanceof Category) {
            Category category = (Category) tag;
            menu.setMenuItemType(MenuItemType.category);
            menu.setName(category.getName());
            menu.setID(Long.valueOf(-1));
            menu.setObjectId(category.getID());
            menu.setSlug(category.getSlug());
            menu.setLink(category.getLink());
        } else if (tag instanceof Term) {
            Term term = (Term) tag;
            menu.setMenuItemType(MenuItemType.custom_taxonomy);
            menu.setID(Long.valueOf(-1));
            menu.setName(term.getName());
            menu.setObjectId(term.getID());
            menu.setSlug(term.getSlug());
            menu.setTaxonomy_name(term.getTaxonomy());
        } else {
            return;
        }
        Activity j = InjectibleApplication.j();
        if (j instanceof FullscreenActivity) {
            ((FullscreenActivity) j).a(menu, -1);
        }
    }

    public void a(Post post) {
        Menu menu = new Menu();
        menu.setMenuItemType(MenuItemType.author);
        if (post.getAuthor() != null) {
            Author author = post.getAuthor();
            menu.setName(author.getName());
            menu.setID(Long.valueOf(-1));
            menu.setObjectId(author.getID());
            menu.setSlug(author.getSlug());
            Activity j = InjectibleApplication.j();
            if (j instanceof FullscreenActivity) {
                ((FullscreenActivity) j).a(menu, -1);
            }
        }
    }

    public void a(List<T> list) {
        this.h.addAll(list);
        notifyDataSetChanged();
    }

    public List<T> b() {
        return this.h;
    }

    public int getCount() {
        return this.h.size() + (this.h.size() / this.g);
    }

    public Object getItem(int i) {
        if (getItemViewType(i) == 1) {
            return null;
        }
        return this.h.get(i - (i / this.g));
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (i == 0 || i % this.g != 0) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) != 1) {
            if (this.d == 0) {
                this.d = a(this.a);
                this.e = b(this.a);
                this.f = c(this.a);
            }
            Object item = getItem(i);
            if (item instanceof Post) {
                return a((Post) item, view);
            }
            this.f = c(this.a);
            return a((Comment) item, view);
        } else if (this.i.get(Integer.valueOf(i)) != null) {
            return (View) this.i.get(Integer.valueOf(i));
        } else {
            if (view == null || !((view instanceof AdView) || (view instanceof MoPubView) || view.getId() == R.id.appNextBannerAd)) {
                Log.d("ADMOB", "Loading ad for position " + i);
                View a = w.a(null, -1, 12938, FullscreenActivity.o.getMiddleAdUnitList(), AdLocation.LIST);
                if (a != null) {
                    if (a instanceof AdView) {
                        AdView adView = (AdView) a;
                        for (int i2 = 0; i2 < adView.getChildCount(); i2++) {
                            adView.getChildAt(i2).setFocusable(false);
                        }
                    }
                    a.setFocusable(false);
                    a.setTag(new Integer(i));
                } else {
                    a = new TextView(this.a);
                }
                return a;
            }
            Log.d("ADMOB", "Returning same ad for position " + i);
            return view;
        }
    }

    public int getViewTypeCount() {
        return 2;
    }
}
