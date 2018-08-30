package com.google.android.exoplayer.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public interface DrmSessionManager {
    void close();

    Exception getError();

    MediaCrypto getMediaCrypto();

    int getState();

    void open(a aVar);

    boolean requiresSecureDecoderComponent(String str);
}
