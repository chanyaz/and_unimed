package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.arch.lifecycle.k;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.ActivityCompat.PermissionCompatDelegate;
import android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator;
import android.support.v4.util.t;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends g implements ViewModelStoreOwner, OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    final Handler c = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.h) {
                        FragmentActivity.this.a(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.a();
                    FragmentActivity.this.d.n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final n d = n.a(new k(this));
    LoaderManager e;
    boolean f;
    boolean g;
    boolean h = true;
    boolean i = true;
    boolean j;
    boolean k;
    int l;
    t<String> m;
    private k n;

    private static boolean a(FragmentManager fragmentManager, State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.f()) {
            if (fragment != null) {
                if (fragment.getLifecycle().a().a(State.STARTED)) {
                    fragment.ad.a(state);
                    z = true;
                }
                FragmentManager n = fragment.n();
                z = n != null ? a(n, state) | z : z;
            }
        }
        return z;
    }

    private int b(Fragment fragment) {
        if (this.m.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.m.f(this.l) >= 0) {
            this.l = (this.l + 1) % 65534;
        }
        int i = this.l;
        this.m.b(i, fragment.p);
        this.l = (this.l + 1) % 65534;
        return i;
    }

    private void f() {
        do {
        } while (a(e(), State.CREATED));
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    protected void a() {
        this.d.h();
    }

    public void a(Fragment fragment) {
    }

    public void a(Fragment fragment, Intent intent, int i, @Nullable Bundle bundle) {
        this.b = true;
        if (i == -1) {
            try {
                ActivityCompat.a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            f.a(i);
            ActivityCompat.a(this, intent, ((b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.b = false;
        }
    }

    void a(boolean z) {
        if (!this.i) {
            this.i = true;
            this.j = z;
            this.c.removeMessages(1);
            d();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public Object b() {
        return null;
    }

    @Deprecated
    public void c() {
        invalidateOptionsMenu();
    }

    void d() {
        this.d.k();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f);
        printWriter.print("mResumed=");
        printWriter.print(this.g);
        printWriter.print(" mStopped=");
        printWriter.print(this.h);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.i);
        if (this.e != null) {
            this.e.a(str2, fileDescriptor, printWriter, strArr);
        }
        this.d.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager e() {
        return this.d.a();
    }

    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @NonNull
    public k getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.n == null) {
            this.n = new k();
        }
        return this.n;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.m.a(i4);
            this.m.c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.a(65535 & i, i2, intent);
                return;
            }
        }
        PermissionCompatDelegate a2 = ActivityCompat.a();
        if (a2 == null || !a2.onActivityResult(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        FragmentManager a = this.d.a();
        boolean g = a.g();
        if (g && VERSION.SDK_INT <= 25) {
            return;
        }
        if (g || !a.d()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.b();
        this.d.a(configuration);
    }

    protected void onCreate(@Nullable Bundle bundle) {
        this.d.a(null);
        super.onCreate(bundle);
        l lVar = (l) getLastNonConfigurationInstance();
        if (lVar != null) {
            this.n = lVar.b;
        }
        if (bundle != null) {
            this.d.a(bundle.getParcelable("android:support:fragments"), lVar != null ? lVar.c : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.l = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.m = new t(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.m.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.m == null) {
            this.m = new t();
            this.l = 0;
        }
        this.d.e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.d.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        if (!(this.n == null || this.j)) {
            this.n.a();
        }
        this.d.l();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.d.a(menuItem);
            case 6:
                return this.d.b(menuItem);
            default:
                return false;
        }
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.d.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.g = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            a();
        }
        this.d.i();
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        a();
        this.d.n();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.d.a(menu);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.d.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.m.a(i3);
            this.m.c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.a(i & 65535, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.g = true;
        this.d.n();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.h) {
            a(true);
        }
        Object b = b();
        y d = this.d.d();
        if (d == null && this.n == null && b == null) {
            return null;
        }
        l lVar = new l();
        lVar.a = b;
        lVar.b = this.n;
        lVar.c = d;
        return lVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f();
        Parcelable c = this.d.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.m.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.l);
            int[] iArr = new int[this.m.b()];
            String[] strArr = new String[this.m.b()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.b()) {
                    iArr[i2] = this.m.d(i2);
                    strArr[i2] = (String) this.m.e(i2);
                    i = i2 + 1;
                } else {
                    bundle.putIntArray("android:support:request_indicies", iArr);
                    bundle.putStringArray("android:support:request_fragment_who", strArr);
                    return;
                }
            }
        }
    }

    protected void onStart() {
        super.onStart();
        this.h = false;
        this.i = false;
        this.c.removeMessages(1);
        if (!this.f) {
            this.f = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.g();
    }

    public void onStateNotSaved() {
        this.d.b();
    }

    protected void onStop() {
        super.onStop();
        this.h = true;
        f();
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            f.a(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.k && i != -1) {
            f.a(i);
        }
    }
}
