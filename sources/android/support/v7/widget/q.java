package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.a.g;
import android.support.v7.a.h;
import android.support.v7.a.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

class q extends BaseAdapter {
    final /* synthetic */ ActivityChooserView a;
    private ActivityChooserModel b;
    private int c = 4;
    private boolean d;
    private boolean e;
    private boolean f;

    q(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public int a() {
        int i = 0;
        int i2 = this.c;
        this.c = MoPubClientPositioning.NO_REPEAT;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i3 = 0;
        while (i < count) {
            view = getView(i, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
        }
        this.c = i2;
        return i3;
    }

    public void a(int i) {
        if (this.c != i) {
            this.c = i;
            notifyDataSetChanged();
        }
    }

    public void a(ActivityChooserModel activityChooserModel) {
        ActivityChooserModel e = this.a.a.e();
        if (e != null && this.a.isShown()) {
            e.unregisterObserver(this.a.e);
        }
        this.b = activityChooserModel;
        if (activityChooserModel != null && this.a.isShown()) {
            activityChooserModel.registerObserver(this.a.e);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        if (this.f != z) {
            this.f = z;
            notifyDataSetChanged();
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.d != z || this.e != z2) {
            this.d = z;
            this.e = z2;
            notifyDataSetChanged();
        }
    }

    public ResolveInfo b() {
        return this.b.b();
    }

    public int c() {
        return this.b.a();
    }

    public int d() {
        return this.b.c();
    }

    public ActivityChooserModel e() {
        return this.b;
    }

    public boolean f() {
        return this.d;
    }

    public int getCount() {
        int a = this.b.a();
        if (!(this.d || this.b.b() == null)) {
            a--;
        }
        a = Math.min(a, this.c);
        return this.f ? a + 1 : a;
    }

    public Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!(this.d || this.b.b() == null)) {
                    i++;
                }
                return this.b.a(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (this.f && i == getCount() - 1) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != g.list_item) {
                    view = LayoutInflater.from(this.a.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(g.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(g.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.d && i == 0 && this.e) {
                    view.setActivated(true);
                    return view;
                }
                view.setActivated(false);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.a.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(g.title)).setText(this.a.getContext().getString(i.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getViewTypeCount() {
        return 3;
    }
}
