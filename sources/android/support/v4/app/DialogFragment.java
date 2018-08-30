package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    @interface DialogStyle {
    }

    @StyleRes
    public int a() {
        return this.b;
    }

    @NonNull
    public Dialog a(Bundle bundle) {
        return new Dialog(j(), a());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    public void a(FragmentManager fragmentManager, String str) {
        this.h = false;
        this.i = true;
        FragmentTransaction a = fragmentManager.a();
        a.a((Fragment) this, str);
        a.c();
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
            }
            this.g = true;
            if (this.e >= 0) {
                l().a(this.e, 1);
                this.e = -1;
                return;
            }
            FragmentTransaction a = l().a();
            a.a((Fragment) this);
            if (z) {
                a.d();
            } else {
                a.c();
            }
        }
    }

    public void b() {
        super.b();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    public void b(@Nullable Bundle bundle) {
        super.b(bundle);
        this.d = this.I == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public void b(boolean z) {
        this.d = z;
    }

    public LayoutInflater c(Bundle bundle) {
        if (!this.d) {
            return super.c(bundle);
        }
        this.f = a(bundle);
        if (this.f == null) {
            return (LayoutInflater) this.C.g().getSystemService("layout_inflater");
        }
        a(this.f, this.a);
        return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
    }

    public void c() {
        super.c();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.d) {
            View s = s();
            if (s != null) {
                if (s.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(s);
            }
            Activity j = j();
            if (j != null) {
                this.f.setOwnerActivity(j);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.f != null) {
            Bundle onSaveInstanceState = this.f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }
}
