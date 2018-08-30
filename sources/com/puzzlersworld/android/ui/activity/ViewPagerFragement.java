package com.puzzlersworld.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.ui.a.e;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.LoadMorePostsListener;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.wp.controller.a;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.PostContentType;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class ViewPagerFragement extends Fragment implements OnPageChangeListener, AndroAppFragment, LoadMorePostsListener {
    private static Fragment ae = null;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService a;
    @Inject
    a b;
    @ForUi
    @Inject
    ListeningExecutorService c;
    private Menu d = null;
    private List<Post> e = null;
    private int f = 0;
    private ViewPager g;
    private e h;
    private boolean i = false;

    private void a(Bundle bundle) {
        if (bundle != null) {
            Log.d("AndroApp", "LoadFromSavedInstace called for ViewPager");
            if (this.d == null && this.e == null) {
                if (bundle.getSerializable("menuItem") != null) {
                    this.d = (Menu) bundle.getSerializable("menuItem");
                }
                if (bundle.getSerializable("posts") != null) {
                    this.e = (List) bundle.getSerializable("posts");
                }
                if (bundle.getSerializable("currentPosition") != null) {
                    this.f = ((Integer) bundle.getSerializable("currentPosition")).intValue();
                    return;
                }
                return;
            }
            return;
        }
        Log.d("AndroApp:", "Saved instance is null");
    }

    private Post ae() {
        Object triggerObject = getTriggerObject();
        return triggerObject instanceof Post ? (Post) triggerObject : this.e.size() > 0 ? (Post) this.e.get(0) : null;
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.viewpager_fragment, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        a(bundle);
        this.h = new e(m(), this.e, this, this);
        this.h.a(this.d);
        this.g = (ViewPager) inflate.findViewById(R.id.pager);
        this.g.setPageMargin(20);
        this.g.setAdapter(this.h);
        this.g.a((OnPageChangeListener) this);
        if (this.e.size() <= 0 || ((Post) this.e.get(0)).getPostContentType() != PostContentType.loadurl) {
            this.g.setOffscreenPageLimit(2);
        } else {
            this.g.setOffscreenPageLimit(0);
        }
        this.g.setCurrentItem(this.f);
        return inflate;
    }

    public void a(final int i, Menu menu) {
        if (menu != null) {
            try {
                Log.d("AndroApp", "Viewpager load page " + i);
                final List a = this.b.a(menu, i);
                this.c.execute(new Runnable() {
                    public void run() {
                        if (i == 1) {
                            ViewPagerFragement.this.h.d();
                        }
                        ViewPagerFragement.this.h.b(a);
                    }
                });
            } catch (Exception e) {
                Log.d("FeedActivity", "Retrofit error");
                e.printStackTrace();
                FriopinApplication.a().a(e);
                throw e;
            }
        }
    }

    public void a(Menu menu) {
        this.d = menu;
    }

    public void a(List<Post> list) {
        this.e = new ArrayList();
        this.e.addAll(list);
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a() {
        return this.i;
    }

    public Fragment ac() {
        return this.h.b(this.g.getCurrentItem());
    }

    public int ad() {
        return this.g.getCurrentItem();
    }

    public void b(Bundle bundle) {
        super.b(bundle);
    }

    public void b(List<Post> list) {
        this.h.a((List) list);
    }

    public void d() {
        super.d();
    }

    public void d(int i) {
        this.f = i;
    }

    public void e() {
        super.e();
    }

    public void e(Bundle bundle) {
        Log.d("AndroApp:", "OnSaveInstance called ViewPager");
        super.e(bundle);
        if (this.d != null) {
            bundle.putSerializable("menuItem", this.d);
        }
        if (this.e != null) {
            List arrayList = new ArrayList();
            arrayList.add(ae());
            bundle.putSerializable("posts", (Serializable) arrayList);
            bundle.putSerializable("currentPosition", Integer.valueOf(0));
        }
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.FEED_DETAIL_ACTIVITY;
    }

    public String getTitle() {
        return this.g != null ? this.h.e(this.g.getCurrentItem()).getTitle() : "DUM";
    }

    public Object getTriggerObject() {
        return this.g != null ? this.h.e(this.g.getCurrentItem()) : null;
    }

    public void loadMorePosts(final int i, final Menu menu) {
        if (menu != null) {
            this.a.execute(new Runnable() {
                public void run() {
                    try {
                        ViewPagerFragement.this.a(i, menu);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        getLifecycleActivity().c();
        ((FullscreenActivity) getLifecycleActivity()).a(this.h.e(i).getTitle());
        ((FullscreenActivity) getLifecycleActivity()).s();
        ae = this.h.b(i);
        ((FullscreenActivity) getLifecycleActivity()).F().setTranslationY(0.0f);
        if (ae != null) {
            ((FeedDetailActivity) ae).ad();
        }
    }

    public void t() {
        super.t();
        Log.d("AndroApp", "On Resumer called ViewPager");
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            if (a()) {
                ((FullscreenActivity) getLifecycleActivity()).m();
            } else {
                ((FullscreenActivity) getLifecycleActivity()).f().b(null);
            }
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        }
    }

    public void u() {
        super.u();
    }
}
