package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.ar;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog ae = null;
    private OnCancelListener af = null;

    public static SupportErrorDialogFragment a(Dialog dialog, OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) ar.a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.ae = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.af = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public Dialog a(Bundle bundle) {
        if (this.ae == null) {
            b(false);
        }
        return this.ae;
    }

    public void a(FragmentManager fragmentManager, String str) {
        super.a(fragmentManager, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.af != null) {
            this.af.onCancel(dialogInterface);
        }
    }
}
