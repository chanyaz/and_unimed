package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class o<E> extends m {
    private final Activity a;
    final Context b;
    final int c;
    final FragmentManagerImpl d;
    private final Handler e;

    o(Activity activity, Context context, Handler handler, int i) {
        this.d = new FragmentManagerImpl();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    o(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.c, 0);
    }

    @Nullable
    public View a(int i) {
        return null;
    }

    public void a(Fragment fragment, Intent intent, int i, @Nullable Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.b.startActivity(intent);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    @NonNull
    public LayoutInflater b() {
        return LayoutInflater.from(this.b);
    }

    void b(Fragment fragment) {
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    FragmentManagerImpl i() {
        return this.d;
    }
}
