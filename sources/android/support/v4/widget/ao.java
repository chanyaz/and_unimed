package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.widget.TextView;

@RequiresApi(23)
class ao extends an {
    ao() {
    }

    public void a(@NonNull TextView textView, @StyleRes int i) {
        textView.setTextAppearance(i);
    }
}
