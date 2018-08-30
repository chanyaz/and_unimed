package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    ListAdapter a;
    private final Runnable ae = new Runnable() {
        public void run() {
            ListFragment.this.b.focusableViewAvailable(ListFragment.this.b);
        }
    };
    private final OnItemClickListener af = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.a((ListView) adapterView, view, i, j);
        }
    };
    ListView b;
    View c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;
    private final Handler i = new Handler();

    private void a() {
        if (this.b == null) {
            View s = s();
            if (s == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (s instanceof ListView) {
                this.b = (ListView) s;
            } else {
                this.d = (TextView) s.findViewById(16711681);
                if (this.d == null) {
                    this.c = s.findViewById(16908292);
                } else {
                    this.d.setVisibility(8);
                }
                this.e = s.findViewById(16711682);
                this.f = s.findViewById(16711683);
                s = s.findViewById(16908298);
                if (s instanceof ListView) {
                    this.b = (ListView) s;
                    if (this.c != null) {
                        this.b.setEmptyView(this.c);
                    } else if (this.g != null) {
                        this.d.setText(this.g);
                        this.b.setEmptyView(this.d);
                    }
                } else if (s == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.h = true;
            this.b.setOnItemClickListener(this.af);
            if (this.a != null) {
                ListAdapter listAdapter = this.a;
                this.a = null;
                a(listAdapter);
            } else if (this.e != null) {
                a(false, false);
            }
            this.i.post(this.ae);
        }
    }

    private void a(boolean z, boolean z2) {
        a();
        if (this.e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.h != z) {
            this.h = z;
            if (z) {
                if (z2) {
                    this.e.startAnimation(AnimationUtils.loadAnimation(h(), 17432577));
                    this.f.startAnimation(AnimationUtils.loadAnimation(h(), 17432576));
                } else {
                    this.e.clearAnimation();
                    this.f.clearAnimation();
                }
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                return;
            }
            if (z2) {
                this.e.startAnimation(AnimationUtils.loadAnimation(h(), 17432576));
                this.f.startAnimation(AnimationUtils.loadAnimation(h(), 17432577));
            } else {
                this.e.clearAnimation();
                this.f.clearAnimation();
            }
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context h = h();
        View frameLayout = new FrameLayout(h);
        View linearLayout = new LinearLayout(h);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(h, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(h);
        linearLayout.setId(16711683);
        View textView = new TextView(h);
        textView.setId(16711681);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(h);
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void a(@NonNull View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        a();
    }

    public void a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.a != null;
        this.a = listAdapter;
        if (this.b != null) {
            this.b.setAdapter(listAdapter);
            if (!this.h && !z2) {
                if (s().getWindowToken() != null) {
                    z = true;
                }
                a(true, z);
            }
        }
    }

    public void a(ListView listView, View view, int i, long j) {
    }

    public void e() {
        this.i.removeCallbacks(this.ae);
        this.b = null;
        this.h = false;
        this.f = null;
        this.e = null;
        this.c = null;
        this.d = null;
        super.e();
    }
}
