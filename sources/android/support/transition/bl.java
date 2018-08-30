package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowId;

@RequiresApi(18)
class bl implements WindowIdImpl {
    private final WindowId a;

    bl(@NonNull View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof bl) && ((bl) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
