package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;

public class VideoDownloader {
    private static final Deque<WeakReference<ah>> a = new ArrayDeque();

    interface VideoDownloaderListener {
        void onComplete(boolean z);
    }

    private VideoDownloader() {
    }

    private static boolean a(@Nullable WeakReference<ah> weakReference) {
        if (weakReference == null) {
            return false;
        }
        ah ahVar = (ah) weakReference.get();
        return ahVar == null ? false : ahVar.cancel(true);
    }

    public static void cache(@Nullable String str, @NonNull VideoDownloaderListener videoDownloaderListener) {
        Preconditions.checkNotNull(videoDownloaderListener);
        if (str == null) {
            MoPubLog.d("VideoDownloader attempted to cache video with null url.");
            videoDownloaderListener.onComplete(false);
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new ah(videoDownloaderListener), str);
        } catch (Exception e) {
            videoDownloaderListener.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks() {
        for (WeakReference a : a) {
            a(a);
        }
        a.clear();
    }

    public static void cancelLastDownloadTask() {
        if (!a.isEmpty()) {
            a((WeakReference) a.peekLast());
            a.removeLast();
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void clearDownloaderTasks() {
        a.clear();
    }

    @Deprecated
    @VisibleForTesting
    public static Deque<WeakReference<ah>> getDownloaderTasks() {
        return a;
    }
}
