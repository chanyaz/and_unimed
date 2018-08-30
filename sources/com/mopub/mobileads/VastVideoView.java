package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public class VastVideoView extends VideoView {
    @Nullable
    private VastVideoBlurLastVideoFrameTask a;
    @Nullable
    private MediaMetadataRetriever b = a();
    private int c;

    public VastVideoView(@NonNull Context context) {
        super(context);
        Preconditions.checkNotNull(context, "context cannot be null");
    }

    @Nullable
    @VisibleForTesting
    MediaMetadataRetriever a() {
        return VERSION.SDK_INT >= 10 ? new MediaMetadataRetriever() : null;
    }

    boolean a(MediaPlayer mediaPlayer, int i, int i2, @NonNull String str) {
        Closeable closeable;
        Throwable th;
        if (VERSION.SDK_INT >= 16 || i != 1 || i2 != Integer.MIN_VALUE || this.c >= 1) {
            return false;
        }
        Closeable closeable2 = null;
        try {
            mediaPlayer.reset();
            Closeable fileInputStream = new FileInputStream(new File(str));
            try {
                mediaPlayer.setDataSource(fileInputStream.getFD());
                mediaPlayer.prepareAsync();
                start();
                Streams.closeStream(fileInputStream);
                this.c++;
                return true;
            } catch (Exception e) {
                closeable = fileInputStream;
                Streams.closeStream(closeable);
                this.c++;
                return false;
            } catch (Throwable th2) {
                th = th2;
                closeable2 = fileInputStream;
                Streams.closeStream(closeable2);
                this.c++;
                throw th;
            }
        } catch (Exception e2) {
            closeable = null;
            Streams.closeStream(closeable);
            this.c++;
            return false;
        } catch (Throwable th3) {
            th = th3;
            Streams.closeStream(closeable2);
            this.c++;
            throw th;
        }
    }

    @Nullable
    @Deprecated
    @VisibleForTesting
    VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask() {
        return this.a;
    }

    @Deprecated
    @VisibleForTesting
    int getVideoRetries() {
        return this.c;
    }

    public void onDestroy() {
        if (this.a != null && this.a.getStatus() != Status.FINISHED) {
            this.a.cancel(true);
        }
    }

    public void onResume() {
        this.c = 0;
    }

    public void prepareBlurredLastVideoFrame(@NonNull ImageView imageView, @NonNull String str) {
        if (this.b != null) {
            this.a = new VastVideoBlurLastVideoFrameTask(this.b, imageView, getDuration());
            try {
                AsyncTasks.safeExecuteOnExecutor(this.a, str);
            } catch (Throwable e) {
                MoPubLog.d("Failed to blur last video frame", e);
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    void setBlurLastVideoFrameTask(@NonNull VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask) {
        this.a = vastVideoBlurLastVideoFrameTask;
    }

    @Deprecated
    @VisibleForTesting
    void setMediaMetadataRetriever(@NonNull MediaMetadataRetriever mediaMetadataRetriever) {
        this.b = mediaMetadataRetriever;
    }
}
