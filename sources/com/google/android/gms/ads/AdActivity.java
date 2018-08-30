package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaap;

@KeepForSdkWithMembers
public class AdActivity extends Activity {
    private zzaap a;

    private final void a() {
        if (this.a != null) {
            try {
                this.a.zzax();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.a.onActivityResult(i, i2, intent);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.a != null) {
                z = this.a.zznj();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.a.zzo(c.a((Object) configuration));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = akc.b().a((Activity) this);
        if (this.a == null) {
            kk.d("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            this.a.onCreate(bundle);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.onDestroy();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.a != null) {
                this.a.onPause();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.a != null) {
                this.a.onRestart();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.a != null) {
                this.a.onResume();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.a != null) {
                this.a.onSaveInstanceState(bundle);
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.a != null) {
                this.a.onStart();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.a != null) {
                this.a.onStop();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
