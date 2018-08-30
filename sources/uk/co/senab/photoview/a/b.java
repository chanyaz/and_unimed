package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(14)
public class b extends a {
    public b(Context context) {
        super(context);
    }

    public boolean a() {
        return this.a.computeScrollOffset();
    }
}
