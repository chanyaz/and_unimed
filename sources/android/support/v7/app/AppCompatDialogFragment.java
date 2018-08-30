package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public Dialog a(Bundle bundle) {
        return new y(h(), a());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Dialog dialog, int i) {
        if (dialog instanceof y) {
            y yVar = (y) dialog;
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
            yVar.a(1);
            return;
        }
        super.a(dialog, i);
    }
}
