package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class k extends o<FragmentActivity> {
    final /* synthetic */ FragmentActivity a;

    public k(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
        super(fragmentActivity);
    }

    @Nullable
    public View a(int i) {
        return this.a.findViewById(i);
    }

    public void a(Fragment fragment, Intent intent, int i, @Nullable Bundle bundle) {
        this.a.a(fragment, intent, i, bundle);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.a.dump(str, fileDescriptor, printWriter, strArr);
    }

    public boolean a() {
        Window window = this.a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public boolean a(Fragment fragment) {
        return !this.a.isFinishing();
    }

    public LayoutInflater b() {
        return this.a.getLayoutInflater().cloneInContext(this.a);
    }

    public void b(Fragment fragment) {
        this.a.a(fragment);
    }

    public void c() {
        this.a.c();
    }

    public boolean d() {
        return this.a.getWindow() != null;
    }

    public int e() {
        Window window = this.a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }
}
