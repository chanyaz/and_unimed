package com.puzzlersworld.android.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderLayout.PresetIndicators;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.ScaleType;
import com.daimajia.slider.library.Tricks.ViewPagerEx.OnPageChangeListener;
import com.github.ksoichiro.android.observablescrollview.c;
import com.google.common.base.ab;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.util.FileSave;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.a;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.PostImage;
import com.puzzlersworld.wp.dto.ThemeColors;
import java.util.Iterator;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class ImageViewFragment extends Fragment implements OnPageChangeListener, AndroAppFragment {
    @Inject
    @ForBackground
    ListeningScheduledExecutorService a;
    @ForUi
    @Inject
    ListeningExecutorService b;
    @Inject
    FileSave c;
    private View d = null;
    private Post e = null;
    private SliderLayout f = null;
    private String g = null;

    private int a(String str, Post post) {
        int i = 0;
        if (ab.a(str)) {
            return 0;
        }
        if (post.getPostImages() != null) {
            Iterator it = post.getPostImages().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                } else if (((PostImage) it.next()).getSrc().equals(str)) {
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return -1;
    }

    private String a(Post post, PostImage postImage) {
        return !ab.a(postImage.getDescription()) ? postImage.getDescription() : post.getTitle();
    }

    private void a() {
        a aVar = (a) this.f.getCurrentSlider();
        this.c.saveImageToDisk(aVar.h(), aVar.a(), getLifecycleActivity());
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            Log.d("AndroApp:", "Saved instance is null");
        } else if (this.e == null && bundle.getSerializable("post") != null) {
            this.e = (Post) bundle.getSerializable("post");
            this.g = null;
        }
    }

    private void a(SliderLayout sliderLayout) {
        int i = 1;
        int a = a(this.g, this.e);
        if (a == -1) {
            BaseSliderView aVar = new a(h());
            aVar.a("").b(this.g);
            aVar.a(ScaleType.CenterInside);
            this.f.a(aVar);
            return;
        }
        Iterator it = this.e.getPostImages().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                PostImage postImage = (PostImage) it.next();
                BaseSliderView aVar2 = new a(h());
                aVar2.a(a(this.e, postImage)).b(postImage.getSrc());
                aVar2.a(ScaleType.CenterInside);
                i = i2 + 1;
                aVar2.a(i2, this.e.getPostImages().size());
                this.f.a(aVar2);
            } else {
                this.f.setCurrentPosition(a);
                return;
            }
        }
    }

    private void ac() {
        ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        getLifecycleActivity().invalidateOptionsMenu();
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).n();
        }
        ActionBar f = ((FullscreenActivity) getLifecycleActivity()).f();
        ThemeColors z = FullscreenActivity.z();
        if (z != null) {
            f.a(new ColorDrawable(c.a(0.0f, Color.parseColor(z.getActionBarBgColor()))));
            if (VERSION.SDK_INT >= 21 && z.getStatusBarBgColor() != null) {
                Window window = getLifecycleActivity().getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(Color.parseColor("#000000"));
            }
        }
    }

    private boolean d(int i) {
        if (i == R.id.saveimage) {
            a();
            return true;
        }
        if (i == R.id.shareimage) {
            a aVar = (a) this.f.getCurrentSlider();
            FriopinApplication.a().a("Share", "Share from Image view Fragment Screen", "ImageViewFragment");
            Post post = new Post();
            post.setShareImage(aVar.a());
            post.setTitle("");
            post.setExcerpt("");
            if (((FullscreenActivity) getLifecycleActivity()).B().onShareButtonClick(i, getLifecycleActivity(), post)) {
                return true;
            }
        }
        return false;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(R.layout.image_view_fragment, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        ac();
        this.f = (SliderLayout) this.d.findViewById(R.id.slider);
        this.f.b();
        this.f.setPresetIndicator(PresetIndicators.Center_Bottom);
        this.f.a((OnPageChangeListener) this);
        a(this.f);
        return this.d;
    }

    public void a(Menu menu) {
        super.a(menu);
    }

    public void a(Menu menu, MenuInflater menuInflater) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called ImageViewFragment");
        menu.clear();
        menuInflater.inflate(R.menu.image_view_fragment_menu, menu);
        super.a(menu, menuInflater);
    }

    public void a(Post post) {
        this.e = post;
    }

    public boolean a(MenuItem menuItem) {
        return d(menuItem.getItemId());
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        a(bundle);
        d(true);
    }

    public void b(String str) {
        this.g = str;
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.e != null) {
            bundle.putSerializable("post", this.e);
        }
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.IMAGE_VIEW_FRAGMENT;
    }

    public String getTitle() {
        return "";
    }

    public Object getTriggerObject() {
        return null;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        Log.d("AndroApp:", "Scroll positio " + i);
    }

    public void onPageSelected(int i) {
    }

    public void t() {
        super.t();
        if (!(getLifecycleActivity() == null || ((FullscreenActivity) getLifecycleActivity()).f() == null)) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            ((FullscreenActivity) getLifecycleActivity()).b(true);
        }
        FriopinApplication.a().a("imageViewFragment screen");
    }
}
