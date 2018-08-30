package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager {

    public interface BackStackEntry {
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        @StringRes
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public abstract SavedState a(Fragment fragment);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract FragmentTransaction a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract void c();

    public abstract boolean d();

    public abstract int e();

    public abstract List<Fragment> f();

    public abstract boolean g();
}
