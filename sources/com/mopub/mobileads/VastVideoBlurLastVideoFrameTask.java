package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {
    @NonNull
    private final MediaMetadataRetriever a;
    @NonNull
    private final ImageView b;
    private int c;
    @Nullable
    private Bitmap d;
    @Nullable
    private Bitmap e;

    public VastVideoBlurLastVideoFrameTask(@NonNull MediaMetadataRetriever mediaMetadataRetriever, @NonNull ImageView imageView, int i) {
        this.a = mediaMetadataRetriever;
        this.b = imageView;
        this.c = i;
    }

    /* renamed from: a */
    protected Boolean doInBackground(String... strArr) {
        if (VERSION.SDK_INT < 10) {
            return Boolean.valueOf(false);
        }
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return Boolean.valueOf(false);
        }
        try {
            this.a.setDataSource(strArr[0]);
            this.d = this.a.getFrameAtTime((long) ((this.c * 1000) - 200000), 3);
            if (this.d == null) {
                return Boolean.valueOf(false);
            }
            this.e = ImageUtils.applyFastGaussianBlurToBitmap(this.d, 4);
            return Boolean.valueOf(true);
        } catch (Throwable e) {
            MoPubLog.d("Failed to blur last video frame", e);
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: a */
    protected void onPostExecute(Boolean bool) {
        if (isCancelled()) {
            onCancelled();
        } else if (bool != null && bool.booleanValue()) {
            this.b.setImageBitmap(this.e);
            ImageUtils.setImageViewAlpha(this.b, 100);
        }
    }

    protected void onCancelled() {
        MoPubLog.d("VastVideoBlurLastVideoFrameTask was cancelled.");
    }
}
