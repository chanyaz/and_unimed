package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class s implements OnClickListener {
    public static s a(Activity activity, Intent intent, int i) {
        return new ba(intent, activity, i);
    }

    public static s a(@NonNull Fragment fragment, Intent intent, int i) {
        return new bb(intent, fragment, i);
    }

    public static s a(@NonNull LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new bc(intent, lifecycleFragment, i);
    }

    protected abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
