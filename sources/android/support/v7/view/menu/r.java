package android.support.v7.view.menu;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;

@RequiresApi(16)
@RestrictTo({Scope.LIBRARY_GROUP})
class r extends m {
    r(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    n a(ActionProvider actionProvider) {
        return new s(this, this.a, actionProvider);
    }
}
