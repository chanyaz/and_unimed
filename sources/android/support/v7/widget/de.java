package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class de {
    private de() {
    }

    public static void a(@NonNull View view, @Nullable CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            df.a(view, charSequence);
        }
    }
}
