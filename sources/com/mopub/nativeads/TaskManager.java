package com.mopub.nativeads;

import android.support.annotation.NonNull;
import java.util.Map;

abstract class TaskManager<T> {

    interface TaskManagerListener<T> {
        void onFail();

        void onSuccess(@NonNull Map<String, T> map);
    }
}
