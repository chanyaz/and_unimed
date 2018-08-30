package com.puzzlersworld.android.ui.activity;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.Window;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.StringConstants;
import com.puzzlersworld.wp.dto.ThemeColors;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class LoginActivity extends AppCompatActivity {
    @Inject
    g n;
    @Inject
    ObjectMapper o;
    private Toolbar p;
    private TabLayout q;
    private ViewPager r;

    private void a(ViewPager viewPager) {
        n gVar = new g(this, e());
        gVar.a(new LoginFragment(), StringConstants.LOGIN.getMessage());
        gVar.a(new RegisterFragment(), StringConstants.REGISTER.getMessage());
        viewPager.setAdapter(gVar);
    }

    private void a(ThemeColors themeColors) {
        if (themeColors != null) {
            if (VERSION.SDK_INT >= 11 && f() != null) {
                f().a(new ColorDrawable(Color.parseColor(themeColors.getActionBarBgColor())));
            }
            if (VERSION.SDK_INT >= 21) {
                setTaskDescription(new TaskDescription(Html.fromHtml("<font color=\"" + themeColors.getActionBarTitleColor() + "\">" + getString(R.string.app_name) + "</font>").toString(), null, Color.parseColor(themeColors.getActionBarBgColor())));
                if (themeColors.getStatusBarBgColor() != null) {
                    Window window = getWindow();
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor(themeColors.getStatusBarBgColor()));
                }
            }
        }
    }

    public void a(Customer customer) {
        try {
            this.n.d(this.o.writeValueAsString(customer));
            if (FullscreenActivity.D == null || FullscreenActivity.D.isEmpty()) {
                FullscreenActivity.D = customer.getUsername();
                FullscreenActivity.E = customer.getEmail();
                this.n.g(customer.getUsername());
                this.n.h(customer.getEmail());
            }
            this.n.f(FullscreenActivity.s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        j();
    }

    public void j() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InjectibleApplication.a((Activity) this);
        setContentView((int) R.layout.login_activity);
        this.p = (Toolbar) findViewById(R.id.toolbar);
        a(this.p);
        ThemeColors z = FullscreenActivity.z();
        f().a(3.4f);
        f().a(true);
        a(z);
        this.r = (ViewPager) findViewById(R.id.viewpager);
        a(this.r);
        this.q = (TabLayout) findViewById(R.id.tabs);
        this.q.setupWithViewPager(this.r);
        this.q.setBackgroundColor(Color.parseColor(z.getActionBarBgColor()));
        setTitle(StringConstants.LOGIN.getMessage());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        finish();
        return false;
    }

    public void setTitle(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 11 && f() != null) {
            if (FullscreenActivity.z() != null) {
                f().a(Html.fromHtml("<font color=\"" + FullscreenActivity.z().getActionBarTitleColor() + "\">" + charSequence + "</font>"));
            } else {
                f().a(Html.fromHtml("" + charSequence));
            }
        }
    }
}
