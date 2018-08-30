package android.support.v7.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

class r implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView a;

    r(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    private void a() {
        if (this.a.f != null) {
            this.a.f.onDismiss();
        }
    }

    public void onClick(View view) {
        if (view == this.a.c) {
            this.a.b();
            Intent b = this.a.a.e().b(this.a.a.e().a(this.a.a.b()));
            if (b != null) {
                b.addFlags(524288);
                this.a.getContext().startActivity(b);
            }
        } else if (view == this.a.b) {
            this.a.g = false;
            this.a.a(this.a.h);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onDismiss() {
        a();
        if (this.a.d != null) {
            this.a.d.a(false);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (((q) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.a.b();
                if (!this.a.g) {
                    if (!this.a.a.f()) {
                        i++;
                    }
                    Intent b = this.a.a.e().b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    this.a.a.e().c(i);
                    return;
                } else {
                    return;
                }
            case 1:
                this.a.a(MoPubClientPositioning.NO_REPEAT);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.a.c) {
            if (this.a.a.getCount() > 0) {
                this.a.g = true;
                this.a.a(this.a.h);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
