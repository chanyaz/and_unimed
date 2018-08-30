package android.arch.lifecycle;

import android.support.annotation.NonNull;

public class ViewModelProvider {

    public interface Factory {
        @NonNull
        <T extends j> T create(@NonNull Class<T> cls);
    }
}
