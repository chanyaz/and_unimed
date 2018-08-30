package com.puzzlersworld.android.ui.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.aa;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.puzzlersworld.android.ui.activity.FeedDetailActivity;
import com.puzzlersworld.android.ui.activity.ViewPagerFragement;
import com.puzzlersworld.android.util.LoadMorePostsListener;
import com.puzzlersworld.wp.controller.a;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.Post;
import java.util.ArrayList;
import java.util.List;

public class e extends aa {
    private SparseArray<Fragment> a = new SparseArray();
    private int b = 5;
    private int c = 0;
    private int d = 0;
    private boolean e = true;
    private int f = 0;
    private List<Post> g = new ArrayList();
    private Menu h;
    private LoadMorePostsListener i;
    private ViewPagerFragement j = null;

    public e(FragmentManager fragmentManager, List<Post> list, LoadMorePostsListener loadMorePostsListener, ViewPagerFragement viewPagerFragement) {
        super(fragmentManager);
        this.g = list;
        this.i = loadMorePostsListener;
        this.j = viewPagerFragement;
        if (list != null) {
            this.f = ((list.size() + a.e) - 1) / a.e;
            this.c = this.f;
            this.d = list.size();
            this.e = false;
        }
    }

    private void a(int i, int i2) {
        try {
            this.i.loadMorePosts(i, this.h);
        } catch (Exception e) {
            try {
                this.i.loadMorePosts(i, this.h);
            } catch (Exception e2) {
                this.e = false;
            }
        }
    }

    private void f(int i) {
        int b = b();
        if (b < this.d) {
            this.c = this.f;
            this.d = b;
            if (b == 0) {
                this.e = true;
            }
        }
        if (this.e && b > this.d) {
            this.e = false;
            this.d = b;
            this.c++;
        }
        if (!this.e && b - i <= this.b) {
            a(this.c + 1, b);
            this.e = true;
        }
    }

    public Fragment a(int i) {
        f(i);
        Fragment feedDetailActivity = new FeedDetailActivity();
        Post post = (Post) this.g.get(i);
        if (post.getMenuItem() != null) {
            ((FeedDetailActivity) feedDetailActivity).a(post.getMenuItem());
        } else if (post.getID() == null) {
            ((FeedDetailActivity) feedDetailActivity).b(post.getLink());
            ((FeedDetailActivity) feedDetailActivity).a(post.getFetchUrl().booleanValue());
        } else {
            ((FeedDetailActivity) feedDetailActivity).a(post);
        }
        ((FeedDetailActivity) feedDetailActivity).d(i);
        ((FeedDetailActivity) feedDetailActivity).a(this.j);
        return feedDetailActivity;
    }

    public Object a(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.a(viewGroup, i);
        this.a.put(i, fragment);
        return fragment;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        super.a(viewGroup, i, obj);
        this.a.remove(Integer.valueOf(i).intValue());
    }

    public void a(Menu menu) {
        this.h = menu;
    }

    public void a(List<Post> list) {
        this.g.clear();
        this.g.addAll(list);
    }

    public int b() {
        return this.g.size();
    }

    public Fragment b(int i) {
        return (Fragment) this.a.get(i);
    }

    public void b(List<Post> list) {
        this.g.addAll(list);
        c();
    }

    public CharSequence c(int i) {
        return ((Post) this.g.get(i)).getTitle();
    }

    public void d() {
        this.c = 0;
        this.d = 0;
        this.e = true;
        this.f = 0;
        this.g = new ArrayList();
        c();
    }

    public Post e(int i) {
        return (Post) this.g.get(i);
    }
}
